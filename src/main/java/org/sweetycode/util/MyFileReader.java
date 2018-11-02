package org.sweetycode.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: sweetycode
 * @Date: 2018/11/1
 * @Description:
 */
public class MyFileReader {
    public static List<String> readList(String fileName) {
        List<String> wordList = new ArrayList<>();
        String item;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/" + fileName), "UTF-8"));
            while((item = br.readLine())!=null) {
                wordList.add(item);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

}
