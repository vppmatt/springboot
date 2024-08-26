package com.neueda.portfolio_manager.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PortfolioManagementService {

    private Map<String, Integer> portfolio = new ConcurrentHashMap<>();

    public Map<String,Integer> getPortfolio() {
        return Map.copyOf(portfolio);
    }

    public synchronized void addShares(String share, Integer volume) {
        Integer currentVolume = portfolio.get(share);
        if (currentVolume == null) currentVolume = 0;
        portfolio.put(share, currentVolume + volume);
    }

    public synchronized void removeShares(String share, Integer volume) {
        Integer currentVolume = portfolio.get(share);
        if (currentVolume == null) currentVolume = 0;
        portfolio.put(share, currentVolume - volume);
    }
}
