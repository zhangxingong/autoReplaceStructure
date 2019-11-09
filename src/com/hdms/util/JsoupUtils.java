package com.hdms.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.*;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class JsoupUtils {
    public Document fileToDoc(File file) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        return Jsoup.parse(inputStream, "UTF-8", "", Parser.xmlParser());
    }
}
