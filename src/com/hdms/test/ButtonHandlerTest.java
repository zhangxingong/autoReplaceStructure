package com.hdms.test;

import com.hdms.processor.ButtonHandler;
import com.hdms.processor.TitleHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class ButtonHandlerTest {
    private static final Log log = LogFactory.getLog(ButtonHandlerTest.class);

    static String testHtml = "";
    TitleHandler titleHandler = null;
    Document doc = null;
    @Before
    public void setUp() throws Exception {
        testHtml = "     <tiles:insert definition=\"coboHDMS.buttons\" flush=\"false\">\n" +
                "                        <tiles:putList name=\"buttons\" >\n" +
                "                            <tiles:add>\n" +
                "                                <bean:message key=\"coboHDMS.util.select\" />$$$submitForm('report',['filter_type','action'],['101','accesstimesReport'])\n" +
                "                            </tiles:add>\n" +
                "                            <tiles:add>back</tiles:add>\n" +
                "                        </tiles:putList>\n" +
                "                    </tiles:insert>";
        titleHandler = new TitleHandler();
        doc = Jsoup.parse(testHtml,"", Parser.xmlParser());
    }

    @Test
    public void buttonTest() {
        ButtonHandler buttonHandler = new ButtonHandler();
        buttonHandler.handle(null, doc);
        log.info(doc);
    }
}
