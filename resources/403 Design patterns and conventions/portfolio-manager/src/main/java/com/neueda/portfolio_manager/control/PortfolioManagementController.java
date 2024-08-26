package com.neueda.portfolio_manager.control;

import com.neueda.portfolio_manager.dtos.InstructionDTO;
import com.neueda.portfolio_manager.dtos.InstructionType;
import com.neueda.portfolio_manager.service.PortfolioManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/portfolio")
public class PortfolioManagementController {

    @Autowired
    PortfolioManagementService portfolioManagementService;

    @GetMapping
    public Map<String, Integer> getPortfolio() {
        return portfolioManagementService.getPortfolio();
    }

    @PostMapping
    public void receiveInstruction(@RequestBody InstructionDTO instruction) {
        System.out.println(instruction);
        if (instruction.getType() == InstructionType.BUY) {
            for (int i = 0; i < instruction.getVolume(); i++)
            portfolioManagementService.addShares(instruction.getShare(), 1);
        }
        else {
            for (int i = 0; i < instruction.getVolume(); i++)
            portfolioManagementService.removeShares(instruction.getShare(), 1);
        }
    }

}
