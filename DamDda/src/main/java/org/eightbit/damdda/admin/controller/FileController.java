package org.eightbit.damdda.admin.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.eightbit.damdda.admin.domain.CarouselImage;
import org.eightbit.damdda.admin.dto.files.FileDTO;
import org.eightbit.damdda.admin.dto.files.FileUploadDTO;
import org.eightbit.damdda.admin.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Log4j2
@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // 클라이언트에서 캐러셀 이미지 등록
    @PostMapping(value = "/carousels", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<FileDTO> upload(FileUploadDTO fileUploadDTO) {
        return fileService.uploadCarousel(fileUploadDTO);
    }

    // 캐러셀 이미지 수정(삭제) 요청
    @PutMapping("/carousels")
    public void modifyCarousels(@RequestBody List<String> fileNames) {
        fileService.modifyCarousel(fileNames);
    }

    // 클라이언트에서 조회할 캐러셀 이미지 url 요청
    @GetMapping("/carousels")
    public ResponseEntity<List<String>> getCarouselUrls() {
        return fileService.getCarouselUrls();
    }

    // 클라이언트에서 캐러셀 이미지 조회
    @GetMapping("/carousels/{fileName}")
    public ResponseEntity<Resource> downloadCarousel(@PathVariable String fileName) {
        return fileService.downloadResource("carousel",null, fileName, false);
    }

    // 클라이언트에서 프로젝트 문서 및 이미지 요청
    @GetMapping("/projects/{projectId}/{fileName}")
    public ResponseEntity<Resource> downloadImage(@PathVariable("fileName")String fileName,
                                                  @PathVariable("projectId")Long projectId) {
        return fileService.downloadResource(null, projectId, fileName, false);
    }

}