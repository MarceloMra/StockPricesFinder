package com.example.StockPricesFinder.quartz.jobs;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PricesUpdaterJob implements Job {
    private OkHttpClient client = new OkHttpClient();
    private static final Logger LOGGER = LoggerFactory.getLogger(PricesUpdaterJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Request request = new Request.Builder()
                .url("https://alpha-vantage.p.rapidapi.com/query?interval=5min&function=TIME_SERIES_INTRADAY&symbol=NU&datatype=json&output_size=compact")
                .get()
                .addHeader("X-RapidAPI-Key", "5fef067de6msha450f97b16ad232p18c644jsn6e6d90d2e171")
                .addHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                .build();

        LOGGER.info("-------------------> TEST <-------------------");
        /*try {
            LOGGER.info("-------------------> TEST <-------------------");
            Response response = client.newCall(request).execute();
            String bodyResponse = response.body().string();
            LOGGER.info(bodyResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

}
