package com.bandicoot.polar.error;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ValidacionError extends SubErrorResponse{

	private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ValidacionError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
