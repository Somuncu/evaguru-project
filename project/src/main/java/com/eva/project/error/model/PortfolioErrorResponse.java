package com.eva.project.error.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PortfolioErrorResponse extends Exception{

    public String errorMessage;

}
