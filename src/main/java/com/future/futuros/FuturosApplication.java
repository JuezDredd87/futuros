package com.future.futuros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:bean.xml"})
public class FuturosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuturosApplication.class, args);
	}
}
