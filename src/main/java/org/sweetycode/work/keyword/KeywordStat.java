package org.sweetycode.work.keyword;

import com.hankcs.hanlp.algorithm.ahocorasick.trie.Emit;
import com.hankcs.hanlp.algorithm.ahocorasick.trie.Trie;
import org.sweetycode.util.MyFileWriter;

import java.io.*;
import java.util.*;

/**
 * @Auther: sweetycode
 * @Date: 2018/11/2
 * @Description: trie tree application.
 * 1. Whether a word contains any of the keywords.
 * 2. Make statistical report.
 */
public class KeywordStat {
    private Trie trie = new Trie();
    private String encodings = "UTF-8";
    private String pathPrefix = "src/main/resources/work/keyword/";
    private boolean isCaseSensitive = false;

    public void setCaseSensitive(boolean caseSensitive) {
        isCaseSensitive = caseSensitive;
    }

    public KeywordStat() {
    }

    public KeywordStat(String dicFileName) {
        String data;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathPrefix + "dic/" + dicFileName), encodings));
            while ((data = br.readLine()) != null) {
                if (data.length() > 0) {
                    if (isCaseSensitive) {
                        trie.addKeyword(data);
                    } else {
                        trie.addKeyword(data.toLowerCase());
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gengerateReport(String testFileName) {
        String reportA = testFileName.split("\\.")[0] + "_reportA(keywordCount).txt";
        String reportB = testFileName.split("\\.")[0] + "_reportB(matchList).txt";
        String name;
        String mapKey;
        Collection<Emit> matchList;
        HashMap<String,Integer> keywordCounter = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathPrefix + "inspection/" + testFileName), encodings));
            FileWriter fw = new FileWriter(reportB, false);
            while ((name = br.readLine()) != null) {
                if (isCaseSensitive) {
                    matchList = trie.parseText(name);
                } else {
                    matchList = trie.parseText(name.toLowerCase());
                }
                if (matchList.size() > 0) {
                    fw.write(name + "\n");
                    for (Emit emit: matchList) {
                        mapKey = emit.getKeyword();
                        keywordCounter.computeIfPresent(mapKey, (k, v) -> v + 1);
                        keywordCounter.putIfAbsent(mapKey, 1);
                    }
                }
            }

            br.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MyFileWriter.clearWriteHashMap(keywordCounter, reportA);

    }

//    public static void main(String[] args) {
//        KeywordStat keywordStat = new KeywordStat("dic_sample.txt");
//        keywordStat.gengerateReport("inspection_sample.txt");
//    }
}