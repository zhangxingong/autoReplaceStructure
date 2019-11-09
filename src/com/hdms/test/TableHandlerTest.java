package com.hdms.test;

import com.hdms.processor.ButtonHandler;
import com.hdms.processor.TableHandler;
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
public class TableHandlerTest {
    private static final Log log = LogFactory.getLog(TableHandlerTest.class);

    static String testHtml = "";
    TitleHandler titleHandler = null;
    Document doc = null;
    @Before
    public void setUp() throws Exception {
        testHtml = "<tiles:insert definition=\"coboHDMS.table_classic\" flush=\"true\" >\n" +
                "\t<tiles:put name=\"sn\" value=\"true\" />\n" +
                "\t\t<tiles:putList name=\"cols\" >\n" +
                "\t\t<logic:iterate id=\"reference\" name=\"ReferenceForm\" property=\"list\">\n" +
                "\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.admin.base.1007\" /><bean:message key=\"coboHDMS.util.type\" />$$$50%$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"referenced\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.admin.base.1009\" /><bean:message key=\"coboHDMS.util.type\" />$$$50%$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"reference\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.admin.base.1009\" /><bean:message key=\"coboHDMS.util.type\" /><bean:message key=\"coboHDMS.admin.base.1002\" />$$$0$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"column\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.system.task.param\" />0$$$0$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"param0\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.system.task.param\" />1$$$0$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"param1\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.system.task.param\" />2$$$0$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"param2\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.system.task.param\" />3$$$0$$$left$$$1$$$\n" +
                "\t\t\t\t<bean:write name=\"reference\" property=\"param3\" />\n" +
                "\t\t\t</tiles:add>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.util.edit\" />$$$40$$$center$$$1$$$\n" +
                "\t\t\t\t<img src=\"<%=HDMSFilter.getJspContext().getImage_path()%>/images/coboHDMS_edit.gif\" onclick=\"submitForm('ref',['id','action'],[<bean:write name=\"reference\" property=\"id\" />,'edit'])\" >\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>\n" +
                "\t\t\t\t<bean:message key=\"coboHDMS.util.del\" />$$$40$$$center$$$1$$$\n" +
                "\t\t\t\t<img src=\"<%=HDMSFilter.getJspContext().getImage_path()%>/images/coboHDMS_delete.gif\" onclick=\"submitForm('ref',['id','action'],[<bean:write name=\"reference\" property=\"id\" />,'delete'])\" >\n" +
                "\t\t\t</tiles:add>\n" +
                "\t\t\t<tiles:add>$end</tiles:add>\n" +
                "\t\t</logic:iterate>\n" +
                "\t\t</tiles:putList>\n" +
                "\n" +
                "</tiles:insert>";
        titleHandler = new TitleHandler();
        doc = Jsoup.parse(testHtml,"", Parser.xmlParser());
    }

    @Test
    public void tabletest() {
        ButtonHandler buttonHandler = new ButtonHandler();
        TableHandler tableHandler = new TableHandler();
        tableHandler.setNextHandler(buttonHandler);
        tableHandler.handle(null, doc);
        log.info(doc);
    }
}
