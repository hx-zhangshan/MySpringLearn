package com.koal.learning.springboot.chapter.controller;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//加入apiModel
@ApiModel
public class UserReq {

	 @ApiModelProperty(value="ID",dataType="String",name="id",example="1020332806740959233")
	String id;
	 
	 @ApiModelProperty(value="编码",dataType="String",name="code",example="001")
	@NotBlank(message="编码不能为空！")
	String code;
	 
	 @ApiModelProperty(value="名称",dataType="String",name="name",example="zhangS")
	@NotBlank(message="名字不能为空！")
	String name;
}
