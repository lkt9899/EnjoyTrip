package com.ssafy.hotplace.model.dto.data.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class HotPlace {
    protected int hotPlaceId;
    protected String title;
    protected String desc;
    protected int hit;
    protected String visitedDate;
    protected String uploadFileName;
    protected String storeFileName;
    protected String regDate;
}
