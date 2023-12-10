package com.proiectBetFair.demo;

import com.proiectBetFair.demo.Utility.DatabaseConnectionPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class ProiectApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProiectApplication.class, args);


	}

}
