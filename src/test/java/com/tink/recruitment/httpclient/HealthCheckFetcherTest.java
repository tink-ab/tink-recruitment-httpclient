package com.tink.recruitment.httpclient;

import com.tink.recruitment.httpclient.healthcheck.HealthcheckFetcher;
import com.tink.recruitment.httpclient.healthcheck.HealthcheckResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HealthCheckFetcherTest {

	@Autowired
	private HealthcheckFetcher healthcheckFetcher;

	@Test
	void shouldFetchOkStatus() {
		HealthcheckResponse healthcheckResponse = healthcheckFetcher.fetchData();
		assertThat(healthcheckResponse).hasFieldOrPropertyWithValue("status", "ok");
	}

}
