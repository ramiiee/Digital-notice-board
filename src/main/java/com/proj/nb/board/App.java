

package com.proj.nb.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}
