package com.koal.learning.springboot.chapter.controller;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {

	String id;
	@NotBlank(message="编码不能为空！")
	String code;
	@NotBlank(message="名字不能为空！")
	String name;
}
