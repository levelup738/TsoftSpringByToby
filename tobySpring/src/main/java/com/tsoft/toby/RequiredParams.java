package com.tsoft.toby;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RequiredParams {
	
	//@Retention - https://jeong-pro.tistory.com/234
	//@Inherited - 자손 클래스까지 상속
	String[] value();	

}
