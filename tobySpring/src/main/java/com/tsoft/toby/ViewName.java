package com.tsoft.toby;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ViewName {
	
	//@Retention - https://jeong-pro.tistory.com/234
	//@Inherited - 어노테이션이 자손클래스까지 상속 된다.
	String value();
	
	//1.어노테이션 만든다.

}
