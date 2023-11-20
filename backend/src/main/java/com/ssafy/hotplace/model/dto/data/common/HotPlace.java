package com.ssafy.hotplace.model.dto.data.common;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public abstract class HotPlace {
    protected int hotPlaceId;
    protected String title;
    protected String desc;
    protected LocalDate visitedDate;
    protected String uploadFileName;
    protected String storeFileName;
}
