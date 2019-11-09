package com.hdms.test;

import com.hdms.processor.ButtonHandler;
import com.hdms.processor.InfoHandler;
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
public class InfoHandlerTest {
    private static final Log log = LogFactory.getLog(InfoHandlerTest.class);

    static String testHtml="";
    TitleHandler titleHandler = null;
    Document doc = null;
    @Before
    public void setUp() throws Exception {
       testHtml = "<tiles:insert definition=\"coboHDMS.info_classic\" flush=\"true\" >\n" +
               "\t\t\t<tiles:put name=\"cols\" value=\"1\" />\n" +
               "\t\t\t<tiles:putList name=\"properties\" >\n" +
               "\t\t\t\t<tiles:add>\n" +
               "\t\t\t\t\t<bean:message key=\"coboHDMS.system.sort.name\" />$$$true$$$1$$$\n" +
               "\t\t\t\t\t<html:text property=\"conf.name\"/>\n" +
               "\t\t\t\t</tiles:add>\n" +
               "\t\t\t\t<tiles:add>\n" +
               "\t\t\t\t\t<bean:message key=\"coboHDMS.admin.additive.1005\" />$$$true$$$1$$$<html:text property=\"conf.srcClass\"/>\n" +
               "\t\t\t\t</tiles:add>\n" +
               "\t\t\t\t<tiles:add>\n" +
               "\t\t\t\t\t<bean:message key=\"coboHDMS.util.description\" />$$$false$$$1$$$\n" +
               "\t\t\t\t\t<html:textarea property=\"conf.description\" rows=\"3\" cols=\"60\" />\n" +
               "\t\t\t\t</tiles:add>\n" +
               "\t\t\t</tiles:putList>\n" +
               "\t\t\t<tiles:put name=\"bottom\">\n" +
               "\t\t\t\t<html:hidden property=\"id\" />\n" +
               "\t\t\t\t<html:hidden property=\"action\" />\n" +
               "\t\t\t\t<html:hidden property=\"parent_id\" />\n" +
               "\t\t\t\t<html:hidden property=\"domain_id\" />\n" +
               "\t\t\t\t<html:hidden property=\"class_name\" value=\"com.cobocn.hdms.additive.ClassAdditiveConf\" />\n" +
               "\t\t\t\t<html:hidden property=\"conf.creator_id\" />\n" +
               "\t\t\t\t<html:hidden property=\"conf.id\" />\n" +
               "\t\t\t\t<tiles:insert definition=\"coboHDMS.buttons\" flush=\"false\">\n" +
               "\t\t\t\t\t<tiles:putList name=\"buttons\" >\n" +
               "\t\t\t\t\t\t<tiles:add>\n" +
               "\t\t\t\t\t\t\t<bean:message key=\"coboHDMS.util.save\" />$$$submitForm('AdditiveConfForm',['action'],['save'])\n" +
               "\t\t\t\t\t\t</tiles:add>\n" +
               "\t\t\t\t\t\t<tiles:add>cancel</tiles:add>\n" +
               "\t\t\t\t\t</tiles:putList>\n" +
               "\t\t\t\t</tiles:insert>\n" +
               "\t\t\t</tiles:put>\n" +
               "\t\t</tiles:insert>";
        titleHandler = new TitleHandler();
        doc = Jsoup.parse(testHtml,"", Parser.xmlParser());
    }

    @Test
    public void infoTest() {
        ButtonHandler buttonHandler = new ButtonHandler();
        InfoHandler infoHandler = new InfoHandler();
        infoHandler.setNextHandler(buttonHandler);
        infoHandler.handle(null, doc);
        log.info(doc);
    }
}
