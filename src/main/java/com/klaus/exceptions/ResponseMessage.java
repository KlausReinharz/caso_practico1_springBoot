package com.klaus.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {
    private Integer code;
    private Object data;

    public ResponseMessage(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}
