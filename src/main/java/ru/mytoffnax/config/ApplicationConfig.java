package ru.mytoffnax.config;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
@ComponentScan("ru.mytoffnax")
@PropertySource("application.properties")
public class ApplicationConfig {

	@Value("${proxy.enable}")
	private boolean enableProxy;
	@Value("${proxy.host}")
	private String host;
	@Value("${proxy.port}")
	private int port;
	@Value("${proxy.scheme}")
	private String scheme;

	/**
	 * Инициализация и настрока rest клиента. Настрока использования прокси-сервера
	 *
	 * @return RestTemplate.
	 */
	@Bean
	public RestTemplate restTemplate() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		if (enableProxy)
			httpClientBuilder.setProxy(new HttpHost(host, port, scheme));

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				httpClientBuilder.build());

		return new RestTemplate(clientHttpRequestFactory);
	}
}
