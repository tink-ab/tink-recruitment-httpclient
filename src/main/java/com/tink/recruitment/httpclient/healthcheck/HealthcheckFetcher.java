package com.tink.recruitment.httpclient.healthcheck;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class HealthcheckFetcher {

    @Value("${base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public HealthcheckResponse fetchData() {
        ResponseEntity<HealthcheckResponse> response = restTemplate.getForEntity(baseUrl + "/api/healthcheck", HealthcheckResponse.class);
        return response.getBody();
    }

}
