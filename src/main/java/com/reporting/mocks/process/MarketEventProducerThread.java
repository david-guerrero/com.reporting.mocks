package com.reporting.mocks.process;

import com.reporting.mocks.model.MarketEnv;
import com.reporting.mocks.model.MarketEnvType;
import com.reporting.mocks.process.intraday.IntradayEvent;
import com.reporting.mocks.process.intraday.IntradayEventType;

import java.util.concurrent.BlockingQueue;

public class MarketEventProducerThread implements Runnable {

    protected BlockingQueue<IntradayEvent<?>> marketEventQueue;
    protected int marketPeriodicity;
    protected boolean run = true;

    public MarketEventProducerThread(int marketPeriodicity, BlockingQueue<IntradayEvent<?>> marketEventQueue) {
        this.marketPeriodicity = marketPeriodicity;
        this.marketEventQueue = marketEventQueue;
    }


    public boolean isRun() {
        System.out.println("MarketEventProducerThread created");
        return run;
    }

    public void setRun(boolean run) {
        System.out.println("MarketEventProducerThread created");
        this.run = run;
    }

    @Override
    public void run() {
        System.out.println("MarketEventProducerThread created");
        try {
            while(run)
            {
                this.marketEventQueue.put(new IntradayEvent<>(IntradayEventType.Market, new MarketEnv(MarketEnvType.IND)));
                Thread.sleep(marketPeriodicity);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
