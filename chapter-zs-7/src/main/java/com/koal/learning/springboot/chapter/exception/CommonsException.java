package com.koal.learning.springboot.chapter.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CommonsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resCode;
	private String resMsg;
	
}
