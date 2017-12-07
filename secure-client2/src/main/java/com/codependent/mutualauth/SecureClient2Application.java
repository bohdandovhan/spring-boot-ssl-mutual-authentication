package com.codependent.mutualauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SecureClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(SecureClient2Application.class, args);
    }

    @PostConstruct
    public void initSsl() {
        System.setProperty("javax.net.ssl.keyStore", Thread.currentThread().getContextClassLoader()
                .getResource("client-keystore.jks").getPath());
        System.setProperty("javax.net.ssl.keyStorePassword", "secret");
        System.setProperty("javax.net.ssl.trustStore", Thread.currentThread().getContextClassLoader()
                .getResource("client-truststore.jks").getPath());
        System.setProperty("javax.net.ssl.trustStorePassword", "secret");
		/*
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
			(hostname,sslSession) -> {
				if (hostname.equals("localhost")) {
					return true;
				}
				return false;
			});*/
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }
}
