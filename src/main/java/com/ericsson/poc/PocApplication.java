package com.ericsson.poc;

import com.ericsson.poc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocApplication {


    @Autowired
    private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

}
