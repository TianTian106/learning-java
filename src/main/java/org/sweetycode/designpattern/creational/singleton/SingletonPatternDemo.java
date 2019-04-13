package org.sweetycode.designpattern.creational.singleton;

import java.util.Objects;
import java.util.concurrent.*;

public class SingletonPatternDemo {
    public static void main(String[] args) throws Exception {
        EagerSingleObject object = EagerSingleObject.getInstance();
        object.showMessage();
        EnumSingleObject.INSTANCE.sayID();
        System.out.println(EnumSingleObject.INSTANCE == EnumSingleObject.INSTANCE);


        //测试验证50个线程获取单例是一个实例

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Future<Integer>[] future = new Future[50];
        for (int i = 0; i < 50; i ++) {
            future[i] = executorService.submit(() -> SISingleObject.getInstance().hashCode());
        }

        try {
            // Integer code = (int) future[0].get();
            Integer code = future[0].get();
            for (Future i: future) {
                if (!Objects.equals(code, i.get()))
                    //if (code != (int) i.get())
                    throw new Exception("It's not single!");
            }
        } finally {
            executorService.shutdown();
        }


    }
}
