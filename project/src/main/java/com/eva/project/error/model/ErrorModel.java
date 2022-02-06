package com.eva.project.error.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {
    private String fieldName;
    private Object rejectedValue;
    private String messageError;
}
