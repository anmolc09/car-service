package com.learning;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RevCarServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(RevCarServiceApplication.class, args);
	}

	@Bean
	public XSSFWorkbook xssfWorkbook() {
		return new XSSFWorkbook();
	}

}
