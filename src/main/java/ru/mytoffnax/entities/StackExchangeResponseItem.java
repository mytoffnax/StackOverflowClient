package ru.mytoffnax.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Объект-запрос 
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeResponseItem {

    @JsonProperty("question_id")
    private Long questionId;
    @JsonProperty("is_answered")
    private boolean answered;
    @JsonProperty("view_count")
    private Long viewCount;
    @JsonProperty("accepted_answer_id")
    private Long acceptedAnswerId;
    @JsonProperty("answer_count")
    private Long answerCount;
    @JsonProperty("score")
    private Long score;
    @JsonProperty("last_activity_date")
    private Long lastActivityDate;
    @JsonProperty("creation_date")
    private Long creationDate;
    @JsonProperty("last_edit_date")
    private Long lastEditDate;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
    @JsonProperty("owner")
    private StackExchangeOwner stackExchangeOwner;
    @JsonProperty("tags")
    private List<String> tags;

}
