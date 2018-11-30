package ru.mytoffnax.services;

import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import ru.mytoffnax.entities.SearchFilters;
import ru.mytoffnax.entities.StackExchangeResponse;

@Service
@RequiredArgsConstructor
public class SOService {

	private final RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(SOService.class);

    /**
     * Обращается к api.stackexchange.com с наложенными фильтрами
     * 
     * @param search фильтры поика
     *
     * @return результат выполнения запроса поиска.
     */
	public StackExchangeResponse search(SearchFilters search) {

		Builder urlBuilder = new HttpUrl.Builder().
				scheme("http")
				.host("api.stackexchange.com")
				.addPathSegments("2.2")
				.addPathSegments("search/advanced")
				.addQueryParameter("order", "desc")
				.addQueryParameter("sort", "activity")
				.addQueryParameter("tagged", "java")
				.addQueryParameter("site", "stackoverflow")
				.addEncodedQueryParameter("filter", "!Fcb3plMx4UAL_cAI1Aq43tpTom");

		if (StringUtils.isNotEmpty(search.getTitle()))
			urlBuilder.addEncodedQueryParameter("title", search.getTitle());
		URL url = urlBuilder.build().url();

		logger.info(String.format("Запрос по адресу: %s", url.toString()));
		
		StackExchangeResponse result = null;
		try {
			ResponseEntity<StackExchangeResponse> response = restTemplate.exchange(url.toString(), HttpMethod.GET, null,
					StackExchangeResponse.class);
			result = response.getBody(); 
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

}
