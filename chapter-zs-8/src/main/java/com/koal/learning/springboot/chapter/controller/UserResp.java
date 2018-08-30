package com.koal.learning.springboot.chapter.controller;

import com.koal.learning.springboot.chapter.entity.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResp {

	String id;

	String code;

	String name;

	StatusEnum status;
}
