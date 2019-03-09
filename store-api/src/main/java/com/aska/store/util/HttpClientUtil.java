package com.aska.store.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Component
public class HttpClientUtil {

    public <T, R> T getHttpResponse(String url, Class<T> resultClass, HttpMethod method, Map<String, String> headers, R request) throws Exception {
        T response = null;
        ResponseEntity<T> responseEntity = null;
        HttpEntity<R> entity = null;
        if (request != null) {
            MultiValueMap<String, String> headerMap = new LinkedMultiValueMap();
            headerMap.setAll(headers);
            entity = new HttpEntity(request, headerMap);
        }
        try {
            final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

            requestFactory.setConnectTimeout(6000);
            requestFactory.setReadTimeout(5000);

            final RestTemplate restTemplate = new RestTemplate(requestFactory);

            final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            messageConverters.add(new GsonHttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);
            switch (method) {
                case GET:
                    responseEntity = restTemplate.getForEntity(url, resultClass);
                    break;
                case POST:
                    responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, resultClass);
                    break;
                case PUT:
                    responseEntity = restTemplate.exchange(url, HttpMethod.PUT, entity, resultClass);
                    break;
                default:
                    break;
            }
            if (responseEntity != null && responseEntity.getStatusCode() != null && responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                response = responseEntity.getBody();
            } else {

                throw new Exception((String) responseEntity.getBody());
            }
        } catch (Exception e) {

            throw e;
        }
        return response;
    }

}
