package com.ness.spn.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountCreationSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountCreationSApplication.class, args);
	}

}
