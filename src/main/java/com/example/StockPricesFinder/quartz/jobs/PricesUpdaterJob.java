package com.example.StockPricesFinder.quartz.jobs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PricesUpdaterJob implements Job {
    private OkHttpClient client = new OkHttpClient();
    private static final Logger LOGGER = LoggerFactory.getLogger(PricesUpdaterJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ObjectMapper mapper = new ObjectMapper();

        //String responseTest = "{\"results\":[{\"symbol\":\"PETR4\",\"currency\":\"BRL\",\"twoHundredDayAverage\":29.60455,\"twoHundredDayAverageChange\":6.8954506,\"twoHundredDayAverageChangePercent\":0.23291862,\"marketCap\":490698700000,\"shortName\":\"PETROBRAS   PN      N2\",\"longName\":\"Petróleo Brasileiro S.A. - Petrobras\",\"regularMarketChange\":-0.24000168,\"regularMarketChangePercent\":-0.65324354,\"regularMarketTime\":\"2023-11-21 21:50:08+00\",\"regularMarketPrice\":36.5,\"regularMarketDayHigh\":36.54,\"regularMarketDayRange\":\"35.91 - 36.54\",\"regularMarketDayLow\":35.91,\"regularMarketVolume\":49597800,\"regularMarketPreviousClose\":36.74,\"regularMarketOpen\":36.54,\"averageDailyVolume3Month\":50406500,\"averageDailyVolume10Day\":58636856,\"fiftyTwoWeekLowChange\":15.73,\"fiftyTwoWeekLowChangePercent\":0.7573423,\"fiftyTwoWeekRange\":\"20.77 - 38.86\",\"fiftyTwoWeekHighChange\":-2.3600006,\"fiftyTwoWeekHighChangePercent\":-0.060730845,\"fiftyTwoWeekLow\":20.77,\"fiftyTwoWeekHigh\":38.86,\"priceEarnings\":null,\"earningsPerShare\":null,\"logourl\":null,\"updatedAt\":\"2023-11-22 00:00:03.381+00\"}],\"requestedAt\":\"2023-11-22T00:05:15.469Z\",\"took\":\"73ms\"}";

        Request request = new Request.Builder()
                .url("https://brapi.dev/api/quote/PETR4?token=m9dLV14uvHDhbMTYWgbzYx")
                .build();

//        try {
//            LOGGER.info("-------------------> TEST <-------------------");
//            Response response = client.newCall(request).execute();
//
//            APIResult result = mapper.readValue(response.body().string(), APIResult.class);
//
//            LOGGER.info(response.body().string());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
