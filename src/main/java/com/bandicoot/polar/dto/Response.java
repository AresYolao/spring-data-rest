package com.bandicoot.polar.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response<T> {
    @JsonProperty(value = "_embedded")
    private Map<String, List<T>> data;
}
