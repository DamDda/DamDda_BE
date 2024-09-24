package org.eightbit.damdda.admin.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.admin.domain.CarouselImage;
import org.eightbit.damdda.admin.dto.files.FileDTO;
import org.eightbit.damdda.admin.dto.files.FileUploadDTO;
import org.eightbit.damdda.admin.repository.CarouselImageRepository;
import org.eightbit.damdda.admin.service.FileService;
import org.eightbit.damdda.common.domain.BaseEntity;
import org.eightbit.damdda.project.domain.ProjectDocument;
import org.eightbit.damdda.project.domain.ProjectImage;
import org.eightbit.damdda.project.repository.ProjectDocumentRepository;
import org.eightbit.damdda.project.repository.ProjectImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${org.eightbit.upload.carousels}")
    private String uploadPathCarousels;
    @Value("${org.eightbit.upload.projects}")
    private String uploadPathProjects;
    @Value("${org.eightbit.client.url}")
    private String clientUrl;

    private final CarouselImageRepository carouselImageRepository;

    @Override
    public List<FileDTO> uploadCarousel(FileUploadDTO fileUploadDTO) {

        if (fileUploadDTO.getFiles() != null) {
            final List<FileDTO> list = new ArrayList<>();

            fileUploadDTO.getFiles().forEach(multipartFile -> {
                String originalFilename = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPathCarousels, uuid + "_" + originalFilename);
                boolean image = false;
                try {
                    // unique id를 붙인 원본 이미지 저장
                    multipartFile.transferTo(savePath);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                list.add(FileDTO.builder()
                        .uuid(uuid)
                        .fileName(originalFilename)
                        .isImage(image).build());

                CarouselImage carouselImage = CarouselImage.builder()
                        .adminImageUrl(savePath.toUri().toString())
                        .build();
                carouselImageRepository.save(carouselImage);
            });
            return list;
        }
        return null;
    }

    @Override
    public ResponseEntity<List<String>> getCarouselUrls() {
        List<CarouselImage> carouselList = carouselImageRepository.findAll();
        List<String> urlList = carouselList.stream()
                .map(CarouselImage::getAdminImageUrl) // 각 이미지의 URL을 가져옴
                .collect(Collectors.toList());

        return ResponseEntity.ok(urlList);
    }
    @Override
    @Transactional
    public void modifyCarousel(List<String> fileNames) {
        fileNames.forEach(fileName -> {
            Resource resource = new FileSystemResource(uploadPathCarousels + File.separator + fileName);

            try {
                if (resource.getFile().exists()) {
                    boolean removed = resource.getFile().delete();
                    log.info("File " + resource.getFile().getAbsolutePath() + " removed? " + removed);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            carouselImageRepository.deleteById(
                    carouselImageRepository.findByAdminImageUrlContaining(fileName)
                            .orElseThrow()
                            .getId()
            );
        });
    }

    @Override
    public ResponseEntity<Resource> downloadResource(String fileType, Long projectId, String fileName, boolean download) {
        String filePath = null;
        if (fileType != null) {
            filePath = uploadPathCarousels + File.separator + fileName;
        } else {
            filePath = uploadPathProjects + File.separator + projectId + File.separator + fileName;
        }
        FileSystemResource resource = new FileSystemResource(filePath);

        if (!resource.exists()) {
            return ResponseEntity.notFound().build(); // 파일이 없을 경우 404 반환
        }
        // 파일의 콘텐츠 타입을 추론
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build(); // 오류 발생 시 500 반환
        }
        if (download) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        }
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource); // 파일 반환
    }


}
