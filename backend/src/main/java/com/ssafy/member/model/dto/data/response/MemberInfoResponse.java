package com.ssafy.member.model.dto.data.response;

import com.ssafy.member.model.dto.data.common.MemberLogin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberInfoResponse extends MemberLogin {
  private String memberId;
  private String name;
  private String phoneNumber;
  private String gender;
  private int age;
  private String regDate;
  private String modDate;
}
