package org.eightbit.damdda.admin.dto.files;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {

    private String uuid;
    private String fileName;
    private boolean isImage;

}
