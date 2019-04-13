package org.sweetycode.tij4.c21.producerconsumerio;

import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by tiantian on 2019/4/12.
 */
public class Consumer implements Runnable {
    private BlockingQueue<DataItem> dataQue;
    private CountDownLatch countDownLatch;
    private TreeMap<String, DataItem> treeMap;  // key = groupId

    public Consumer(BlockingQueue<DataItem> dataQue, CountDownLatch countDownLatch, TreeMap<String, DataItem> treeMap) {
        this.dataQue = dataQue;
        this.countDownLatch = countDownLatch;
        this.treeMap = treeMap;
    }

    @Override
    public void run() {
        DataItem dataItem;
        String groupId;
        while (true) {
            if (!dataQue.isEmpty()) {
                try {
                    dataItem = dataQue.take();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    continue;
                }
                groupId = dataItem.getGroupId();
                if (!treeMap.containsKey(groupId) || treeMap.get(groupId).getQuota() > dataItem.getQuota()) {
                    treeMap.put(groupId, dataItem);
                }
            } else {
                if (countDownLatch.getCount() <= 1) {
                    countDownLatch.countDown();
                    break;
                }
            }
        }
    }
}
