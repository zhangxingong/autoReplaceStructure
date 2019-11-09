package com.hdms.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.junit.Test;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class JsoupTestCase {
    @Test
    public  void handleTitle() {
        String src = "<tiles:insert definition=\"coboHDMS.admin.title\" >\n" +
                "\t<tiles:putList name=\"page_title\">\n" +
                "\t\t<tiles:add>icon0128</tiles:add>\n" +
                "\t\t<tiles:add><bean:message key=\"coboHDMS.admin.report.1030\" /></tiles:add>\n" +
                "\t</tiles:putList>\n" +
                "</tiles:insert>\n" +
                "<div id=\"frame\">\n" +
                "\t<tiles:insert definition=\"coboHDMS.table_classic\" flush=\"true\" >\n" +
                "\t\t<tiles:put name=\"icon\" value=\"coboHDMS_icon0108.gif\" />\n" +
                "\t\t<tiles:putList name=\"cols\" >\n" +
                "\t\t\t<logic:iterate id=\"eu\" name=\"ASPForm\"  property=\"list\" >\n" +
                "\t\t\t\t<tiles:add>\n" +
                "\t\t\t\t\t<bean:message key=\"coboHDMS.system.sort.name\" />$$$0$$$left$$$1$$$\n" +
                "\t\t\t\t\t<bean:write name=\"eu\" property=\"name\" />\n" +
                "\t\t\t\t</tiles:add>\n" +
                "\t\t\t\t<tiles:add>\n" +
                "\t\t\t\t\t<bean:message key=\"coboHDMS.admin.report.1005\" />$$$0$$$left$$$1$$$ <a onclick=\"submitForm('report',['parent_id','action'],['<bean:write name=\"eu\" property=\"domain_id\"  />','accesstimesReport'])\" > view</a>\n" +
                "\t\t\t\t</tiles:add>\n" +
                "\t\t\t\t<tiles:add>$end</tiles:add>\n" +
                "\t\t\t</logic:iterate>\n" +
                "\t\t</tiles:putList>\n" +
                "\t</tiles:insert>\n" +
                "\t\n" +
                "\t<html:form action=\"/report/ASP/BO.cobo\" styleId=\"report\">\n" +
                "\t\t<html:hidden property=\"action\" />\n" +
                "\t\t<html:hidden property=\"id\" />\n" +
                "\t\t<html:hidden property=\"parent_id\" />\n" +
                "\t</html:form>\n" +
                "</div>";

        Document doc = Jsoup.parse(src,"", Parser.xmlParser());


        Elements elements = doc.getElementsByAttributeValue("definition","coboHDMS.admin.title");
        Elements elementsByTag = elements.get(0).getElementsByTag("bean:message");
        String value = elementsByTag.attr("key");
        Element element = doc.createElement("hdms:title");
        String html = "<hdms:title text=\""+value+"\"/>";
        Element title = element.attr("text", value);
        elements.get(0).after(html).remove();

        System.out.println(doc);
    }
}
