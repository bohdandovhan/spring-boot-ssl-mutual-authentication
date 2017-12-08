package com.codependent.mutualauth.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeRestController {

    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/")
    public String home() throws RestClientException, URISyntaxException{
        //temporary fix to "java.security.cert.CertificateException: No subject alternative names present" error
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
            new javax.net.ssl.HostnameVerifier(){

                public boolean verify(String hostname,
                        javax.net.ssl.SSLSession sslSession) {
                    return hostname.equals("54.191.93.15");
                }
            }
        );

        String url = "https://54.191.93.15:8443/";
        return restTemplate.getForObject(new URI(url), String.class);
    }
    
}
