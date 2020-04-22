package com.tink.recruitment.httpclient.healthcheck;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class HealthcheckFetcher {

    @Value("${base.url:http://localhost:5000}")
    private String baseUrl;

    private final Client client;

    public HealthcheckResponse fetchData() {
        WebResource resource = client.resource(baseUrl + "/api/healthcheck");
        ClientResponse response = resource.get(ClientResponse.class);
        return response.getEntity(HealthcheckResponse.class);
    }

}
