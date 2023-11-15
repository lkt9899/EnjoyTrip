package com.ssafy.member.model.dto.data.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberLoginRequest {
    private String id;
    private String password;
}
