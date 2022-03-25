package br.com.projetoudemyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import br.com.projetoudemyspring.config.FileStorageConfig;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties({
	FileStorageConfig.class
})
public class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);

	}
	

}
