package com.eva.project.controller;

import com.eva.project.dto.PortfolioDto;
import com.eva.project.dto.ShareDto;
import com.eva.project.entity.Portfolio;
import com.eva.project.error.ErrorResponse;
import com.eva.project.error.model.ErrorModel;
import com.eva.project.model.TradeResponse;
import com.eva.project.service.ShareService;
import com.eva.project.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trade")
@RequiredArgsConstructor
public class TradeController {

    private final TradeService tradeService;

    @PostMapping("/buy")
    public ResponseEntity<TradeResponse> buy(@Valid @RequestBody PortfolioDto portfolioDto) {
        return ResponseEntity.ok(tradeService.buy(portfolioDto));
    }

    @GetMapping
    public ResponseEntity<List<Portfolio>> findAll() {
        return ResponseEntity.ok(tradeService.findAll());
    }

    @PostMapping("/sell")
    public ResponseEntity<TradeResponse> sell(@Valid @RequestBody PortfolioDto portfolioDto) {
        return ResponseEntity.ok(tradeService.sell(portfolioDto));
    }

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(MethodArgumentNotValidException exception) {

        List<ErrorModel> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(err -> new ErrorModel(err.getField(), err.getRejectedValue(), err.getDefaultMessage()))
                .distinct()
                .collect(Collectors.toList());
        return ErrorResponse.builder().errorMessage(errorMessages).build();
    }

}
