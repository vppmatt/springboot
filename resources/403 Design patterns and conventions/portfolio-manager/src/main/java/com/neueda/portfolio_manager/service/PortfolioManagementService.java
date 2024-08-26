package com.neueda.portfolio_manager.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PortfolioManagementService {

    private Map<String, Integer> portfolio = new HashMap<>();

    public Map<String,Integer> getPortfolio() {
        return portfolio;
    }

    public void addShares(String share, Integer volume) {
        Integer currentVolume = portfolio.get(share);
        if (currentVolume == null) currentVolume = 0;
        portfolio.put(share, currentVolume + volume);
    }

    public void removeShares(String share, Integer volume) {
        Integer currentVolume = portfolio.get(share);
        if (currentVolume == null) currentVolume = 0;
        portfolio.put(share, currentVolume - volume);
    }
}
