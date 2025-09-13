package com.project.main.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto<T> {
    private T data;
    private String message;
    private Integer status;
}
