package org.rusty;

import org.rusty.config.BeanConfig;
import org.rusty.config.WebAppInitializer;
import org.rusty.config.WebConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.main(ServerApplication.class)
				.initializers(applicationContext -> new WebAppInitializer())
				.sources(BeanConfig.class, WebConfig.class)
				.build()
				.run(args);
//		SpringApplication.run(ServerApplication.class, args);
	}
}
