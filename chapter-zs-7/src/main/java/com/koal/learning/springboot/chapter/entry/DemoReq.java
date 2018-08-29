package com.koal.learning.springboot.chapter.entry;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoReq {

	@NotBlank(message="不能为空值！")
	private String resCode;
	@Length(message="长度不超过10",max=10)
	private String resMsg;
	
	
}
