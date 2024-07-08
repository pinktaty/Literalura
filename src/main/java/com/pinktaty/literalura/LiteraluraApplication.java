package com.pinktaty.literalura;

import com.pinktaty.literalura.controller.LibraryController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);

		LibraryController controller = context.getBean(LibraryController.class);
		controller.generateRequest();
	}

}
