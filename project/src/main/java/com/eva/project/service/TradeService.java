package com.eva.project.service;

import com.eva.project.dto.PortfolioDto;
import com.eva.project.entity.Portfolio;
import com.eva.project.model.TradeResponse;

import java.util.List;

public interface TradeService {

    TradeResponse buy(PortfolioDto portfolioDto);

    List<Portfolio> findAll();

    TradeResponse sell(PortfolioDto portfolioDto);
}
