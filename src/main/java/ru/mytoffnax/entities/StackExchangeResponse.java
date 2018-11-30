package ru.mytoffnax.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Общая структура ответа сервисав 
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeResponse {

    @JsonProperty(value = "items")
    private List<StackExchangeResponseItem> items;
    @JsonProperty(value = "has_more")
    private boolean hasMore;
    @JsonProperty(value = "quota_max")
    private Long quotaMax;
    @JsonProperty(value = "quota_remaining")
    private Long quotaRemaining;
    
}