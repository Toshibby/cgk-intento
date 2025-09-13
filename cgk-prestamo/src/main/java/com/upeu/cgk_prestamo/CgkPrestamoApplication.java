package com.upeu.cgk_prestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CgkPrestamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgkPrestamoApplication.class, args);
	}

}
