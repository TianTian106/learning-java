package org.sweetycode.util;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: sweetycode
 * @Date: 2018/11/1
 * @Description:
 */
public class MyFileWriter {

    static public void clearFile(String fileName) {
        // clear ori file
        try {
            FileWriter fw = new FileWriter(fileName, false);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void writeFile(String content, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(content);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clearWriteHashMap (HashMap<String,Integer> wordIndex, String fileName) {
        String word;
        Integer count;
        Iterator iter = wordIndex.entrySet().iterator();
        clearFile(fileName);
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            word = (String)entry.getKey();
            count = (Integer)entry.getValue();
            String writeString= word +"\t" + count +"\n";
            writeFile(writeString, fileName);
        }
    }
}
