package com.example.StockPricesFinder.controller;

import com.example.StockPricesFinder.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PricesUpdaterJobsController")
public class PricesUpdaterJobsController {
    private SchedulerService schedulerService;

    @Autowired
    public PricesUpdaterJobsController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostMapping("/StartJobs")
    public void startJobs(){
        schedulerService.schedule();
    }
}
