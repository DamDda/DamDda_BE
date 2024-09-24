package org.eightbit.damdda.admin.service;

import org.eightbit.damdda.admin.domain.CarouselImage;
import org.eightbit.damdda.admin.dto.files.FileDTO;
import org.eightbit.damdda.admin.dto.files.FileUploadDTO;
import org.eightbit.damdda.common.domain.BaseEntity;
import org.eightbit.damdda.project.domain.ProjectDocument;
import org.eightbit.damdda.project.domain.ProjectImage;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;


public interface FileService {

    List<FileDTO> uploadCarousel(FileUploadDTO fileUploadDTO);
    ResponseEntity<List<String>> getCarouselUrls();
    ResponseEntity<Resource> downloadResource(String fileType, Long projectId, String fileName, boolean download);
    void modifyCarousel(List<String> fileNames);

}
