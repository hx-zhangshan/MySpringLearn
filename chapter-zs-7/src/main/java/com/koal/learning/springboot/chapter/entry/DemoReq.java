package com.koal.learning.springboot.chapter.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoReq {

	private String resCode;
	
	private String resMsg;
}
