package com.eva.project.service.impl;

import com.eva.project.dto.PortfolioDto;
import com.eva.project.entity.Portfolio;
import com.eva.project.entity.Share;
import com.eva.project.entity.User;
import com.eva.project.error.model.PortfolioErrorResponse;
import com.eva.project.model.TradeResponse;
import com.eva.project.repo.PortfolioRepository;
import com.eva.project.repo.ShareRepository;
import com.eva.project.repo.UserRepository;
import com.eva.project.service.TradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.sound.sampled.Port;
import java.util.List;

@Service
@AllArgsConstructor
public class TradeServiceImpl implements TradeService {

    private UserRepository userRepository;
    private ShareRepository shareRepository;
    private PortfolioRepository portfolioRepository;

    @Override
    @Transactional
    public TradeResponse buy(PortfolioDto portfolioDto) {
        TradeResponse tradeResponse = new TradeResponse();
        Portfolio portfolio = new Portfolio();

        try {
            if(portfolioDto.getRate() ==null) {
                throw new PortfolioErrorResponse("rate can not be empty");
            }

            User userDb = userRepository.getById(portfolioDto.getUserId());
            if(userDb.getName() ==null) {
                throw new PortfolioErrorResponse("user is not defined.");
            }

            Share shareDb = shareRepository.getById(portfolioDto.getShareId());
            if(shareDb.getName() == null) {
                throw new PortfolioErrorResponse("Share is not defined.");
            }

            portfolio.setShareId(shareDb.getId());
            portfolio.setRate(portfolioDto.getRate());

            //portfolio.setUser(userDb);

            Portfolio portfolioDb = portfolioRepository.saveAndFlush(portfolio);

            userDb.getPortfolios().add(portfolioDb);
            userRepository.save(userDb);
            portfolioDto.setId(portfolioDb.getId());

            tradeResponse.setPortfolio(portfolioDb);
            tradeResponse.setMessage("Your buying process is succesful.");
            tradeResponse.setAnswerCode("Success");

        }catch (PortfolioErrorResponse ex){
            tradeResponse.setMessage(ex.getErrorMessage());
            tradeResponse.setAnswerCode("Fail");
        }

        return tradeResponse;
    }

    @Override
    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    @Override
    @Transactional
    public TradeResponse sell(PortfolioDto portfolioDto) {
        TradeResponse tradeResponse = new TradeResponse();

        try {
            if(portfolioDto.getId() == null) {
                throw new PortfolioErrorResponse("portfolio Id can not be empty.");
            }
            Portfolio portfolioDb = portfolioRepository.getById(portfolioDto.getId());
            if(portfolioDb.getShareId()==null){
                throw new PortfolioErrorResponse("This portfolio is not suitable to sell");
            }

            User user = userRepository.getById(portfolioDto.getUserId());
            user.getPortfolios().remove(portfolioDb);
            userRepository.save(user);
            portfolioRepository.deleteById(portfolioDto.getId());

            tradeResponse.setPortfolio(portfolioDb);
            tradeResponse.setMessage("Your buying process is succesful.");
            tradeResponse.setAnswerCode("Success");

        }catch (PortfolioErrorResponse ex){
            tradeResponse.setMessage(ex.getErrorMessage());
            tradeResponse.setAnswerCode("Fail");
        }catch (EntityNotFoundException ex){
            tradeResponse.setMessage("Your portfolio is not found.");
            tradeResponse.setAnswerCode("Fail");
        }


        return tradeResponse;
    }
}
