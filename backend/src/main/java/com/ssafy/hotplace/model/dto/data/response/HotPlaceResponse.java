package com.ssafy.hotplace.model.dto.data.response;

import com.ssafy.hotplace.model.dto.data.common.HotPlace;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class HotPlaceResponse extends HotPlace {
    private String id;
    private int contentId;
    private LocalDateTime regDate;
}
