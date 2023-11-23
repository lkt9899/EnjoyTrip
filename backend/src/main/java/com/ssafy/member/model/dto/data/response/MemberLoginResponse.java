package com.ssafy.member.model.dto.data.response;

import com.ssafy.member.model.dto.data.common.MemberLogin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberLoginResponse extends MemberLogin {
    private int memberId;
    private String name;
}
