package org.sweetycode.tij4.c21.producerconsumerio;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by tiantian on 2019/4/12.
 */
public class Producer implements Runnable{
    private BlockingQueue<DataItem> dataQue;
    private CountDownLatch countDownLatch;
    private File file;

    public Producer(BlockingQueue<DataItem> dataQue, CountDownLatch countDownLatch, File file) {
        this.dataQue = dataQue;
        this.countDownLatch = countDownLatch;
        this.file = file;
    }

    @Override
    public void run() {
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String line;
            String[] arr ;

            while ((line = br.readLine()) != null) {
                arr = line.split("，");
                DataItem dataItem = new DataItem(arr[0], arr[1], Float.valueOf(arr[2]));
                dataQue.add(dataItem);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Exception while reading a file.");
        } finally {
            countDownLatch.countDown();
        }

    }
}
