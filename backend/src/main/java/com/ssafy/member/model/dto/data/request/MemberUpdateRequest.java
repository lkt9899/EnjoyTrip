package com.ssafy.member.model.dto.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemberUpdateRequest {

   private String id;
   private String password;
   private String name;
   private String phoneNumber;
   private String gender;
   private int age;

}
