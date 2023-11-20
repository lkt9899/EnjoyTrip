package com.ssafy.member.model.dto.data.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public abstract class MemberLogin {
    protected String id;
    protected String password;
}
