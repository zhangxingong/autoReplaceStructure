package com.hdms.test;

import com.hdms.processor.BoxShadowHandler;
import com.hdms.processor.TitleHandler;
import com.sun.scenario.effect.BoxShadow;
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
public class BoxShadowTest {
    private static final Log log = LogFactory.getLog(BoxShadowTest.class);
    static String testHtml;
    TitleHandler titleHandler = null;
    Document doc = null;
    @Before
    public void setUp() throws Exception {
        testHtml = "<div id=\"frame\">\n" +
                "     <hdms:includedGroup text=\"1111111\">\n" +
                "         <hdms:btn click=\"ssss\" text=\"ddddddd\"></hdms:btn>\n" +
                "     </hdms:includedGroup>\n" +
                "</div>";
        titleHandler = new TitleHandler();
        doc = Jsoup.parse(testHtml,"", Parser.xmlParser());
    }

    @Test
    public void shaodwotest() {
        BoxShadowHandler handler = new BoxShadowHandler();
        handler.handle(null, doc);
        log.info(doc);
    }
}
