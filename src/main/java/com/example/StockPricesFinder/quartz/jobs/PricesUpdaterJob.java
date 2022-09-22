package com.example.StockPricesFinder.quartz.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PricesUpdaterJob implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(PricesUpdaterJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("-------------------> TEST <-------------------");
    }

}
