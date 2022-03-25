package br.com.projetoudemyspring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "file")
public class FileStorageConfig {
	
	private String uploadDir;

}
