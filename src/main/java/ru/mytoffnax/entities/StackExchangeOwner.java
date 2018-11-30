package ru.mytoffnax.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


/**
 * Информация об авторе запроса 
 */
@Getter
@Setter
public class StackExchangeOwner {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("accept_rate")
    private Long acceptRate;
    @JsonProperty("reputation")
    private Long reputation;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("link")
    private String link;

}
