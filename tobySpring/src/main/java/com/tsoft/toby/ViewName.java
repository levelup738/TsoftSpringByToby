package com.tsoft.toby;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ViewName {
	
	//@Retention - https://jeong-pro.tistory.com/234
	//@Inherited - ������̼��� �ڼ�Ŭ�������� ��� �ȴ�.
	String value();
	
	//1.������̼� �����.

}
