package com.example.springcloudconfigclientapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringCloudConfigClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientAppApplication.class, args);
	}

}

@RestController
class ConfigController {

	@Value("${myapp.who}")
	private String text;

	@GetMapping("/text")
	public String getText() {
		return text;
	}

}
