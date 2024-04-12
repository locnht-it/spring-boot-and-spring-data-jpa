//package com.locnht.SpringBootAndSpringDataJpa.bean;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.Collections;
//
//@SpringBootApplication
//public class SpringBootAndSpringDataJpaApplicationBean {
//
//	public static void main(String[] args) {
//		var app = new SpringApplication(SpringBootAndSpringDataJpaApplicationBean.class);
//		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
//		var context = app.run(args);
//
//		MyFirstService myFirstService = context.getBean(MyFirstService.class);
//		System.out.println(myFirstService.tellAStory());
////		System.out.println(myFirstService.getJavaVersion());
////		System.out.println(myFirstService.getOsName());
////		System.out.println(myFirstService.readProperties());
//		System.out.println(myFirstService.getCustomProperty());
//		System.out.println(myFirstService.getCustomPropertyInt());
////		System.out.println(myFirstService.getCustomPropertyFromAnotherFile());
////		System.out.println(myFirstService.getCustomPropertyFromAnotherFile2());
//
//	}
//
//}
