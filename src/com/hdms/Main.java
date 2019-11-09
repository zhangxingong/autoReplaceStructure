package com.hdms;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) throws IOException {
        log.info("auto replace is ready... ");
        String workSpace = com.hdms.util.FileUtils.getWorkSpace();
        log.info("1. current directory is :" + workSpace);
        File[] listFiles = com.hdms.util.FileUtils.getListFiles(workSpace);
        log.info("2. need handle file size:"+listFiles.length);
        for (File listFile : listFiles) {

        }

    }
}
