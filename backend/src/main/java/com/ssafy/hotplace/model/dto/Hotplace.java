package com.ssafy.hotplace.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Hotplace {
    private int memberId;
    private int contentId;
    private int contentTypeId;
    private String title;
    private String desc;
    private int hit;
    private LocalDate visitedDate;
    private String uploadFileName;
    private String storeFileName;
}
