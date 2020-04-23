package com.tink.recruitment.httpclient.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HealthcheckFetcher {

    @Value("${base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public HealthcheckFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HealthcheckResponse fetchData() {
        ResponseEntity<HealthcheckResponse> response = restTemplate.getForEntity(baseUrl + "/api/healthcheck", HealthcheckResponse.class);
        return response.getBody();
    }

}
