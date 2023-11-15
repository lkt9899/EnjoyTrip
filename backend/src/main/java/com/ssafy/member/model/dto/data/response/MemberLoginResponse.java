package com.ssafy.member.model.dto.data.response;

import com.ssafy.member.model.dto.data.common.MemberLogin;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberLoginResponse extends MemberLogin {
    private int memberId;
    private String name;
}
