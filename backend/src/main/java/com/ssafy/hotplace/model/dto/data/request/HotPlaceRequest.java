package com.ssafy.hotplace.model.dto.data.request;

import com.ssafy.hotplace.model.dto.data.common.HotPlace;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HotPlaceRequest extends HotPlace {
    private int memberId;
    private int contentId;
}
