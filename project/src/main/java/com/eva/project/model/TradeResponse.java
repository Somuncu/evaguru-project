package com.eva.project.model;

import com.eva.project.dto.PortfolioDto;
import com.eva.project.entity.Portfolio;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeResponse implements Serializable {

    private Portfolio portfolio;
    private String answerCode;
    private String message;

}
