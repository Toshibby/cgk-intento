package com.upeu.cgk_config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CgkConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgkConfigServerApplication.class, args);
	}

}
