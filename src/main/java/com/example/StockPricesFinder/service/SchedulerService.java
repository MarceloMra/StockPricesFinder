package com.example.StockPricesFinder.service;

import com.example.StockPricesFinder.quartz.utils.QuartzJobsUtils;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class SchedulerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);

    private final Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
        schedule();
    }

    @PostConstruct
    public void init(){
        try {
            LOGGER.info("[ STARTING JOBS ]");
            scheduler.start();

        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @PreDestroy
    public void preDestroy(){
        try {
            LOGGER.info("[ SHUTDOWN JOBS ]");
            scheduler.shutdown();
        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void schedule(){
        JobDetail jobDetail = QuartzJobsUtils.pricesUpdaterJobDetail();
        Trigger trigger = QuartzJobsUtils.pricesUpdaterJobTrigger();

        try {
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
