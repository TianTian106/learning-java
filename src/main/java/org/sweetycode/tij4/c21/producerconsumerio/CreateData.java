package org.sweetycode.tij4.c21.producerconsumerio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tiantian on 2019/4/12.
 */
public class CreateData {
    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/files/";
        for (int i = 1; i < 100; i++) {
            File file = new File(path + i + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fileWriter);
            for (int j = 0; j < 5000; j++) {
                br.write(getRandomData());
                br.newLine();
            }
            br.close();
            fileWriter.close();

        }
        System.out.println("success");
    }

    private static String getRandomData() {
        Integer id = (int) (Math.random() * 1000000) + 1000000;
        Integer groupId = (int) (Math.random() * 1000) + 100;
        Float quota = (int) (Math.random() * 1000) / 10.0f + 60;
        return id + "，" + groupId + "，" + quota;
    }
}
