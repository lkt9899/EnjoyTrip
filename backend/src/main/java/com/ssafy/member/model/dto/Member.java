package com.ssafy.member.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Member {
   private String id;
   private String password;
   private String name;
   private int age;
   private String phoneNumber;
   private String gender;
   private String role;

}
