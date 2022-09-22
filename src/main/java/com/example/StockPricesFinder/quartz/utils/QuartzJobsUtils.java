package com.example.StockPricesFinder.quartz.utils;

import com.example.StockPricesFinder.quartz.jobs.PricesUpdaterJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class QuartzJobsUtils {
    @Bean
    public static JobDetail pricesUpdaterJobDetail() {
        return JobBuilder.newJob().ofType(PricesUpdaterJob.class)
                .storeDurably()
                .withIdentity("Prices_Updater_Job_Detail")
                .withDescription("Invoke Sample Job service.")
                .build();
    }

    @Bean
    public static JobDetailFactoryBean pricesUpdaterJobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(PricesUpdaterJob.class);
        jobDetailFactory.setDescription("Invoke Sample Job service...");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    @Bean
    public static Trigger pricesUpdaterJobTrigger() {
        return TriggerBuilder.newTrigger().forJob(pricesUpdaterJobDetail())
                .withIdentity("Prices_Updater_Job_Trigger")
                .withDescription("Sample trigger")
                .withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(10))
                .build();
    }

    @Bean
    public static Scheduler pricesUpdaterJobScheduler(SchedulerFactoryBean factory)
            throws SchedulerException {
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(pricesUpdaterJobDetail(), pricesUpdaterJobTrigger());
        scheduler.start();
        return scheduler;
    }
}
