package com.hdms.processor;

import com.hdms.processor.base.BaseHandler;
import com.hdms.util.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class TitleHandler extends BaseHandler {
    @Override
    public void handle(Node node, Document doc) {
        String value = "";
        Element element = doc.createElement("hdms:title");
        Elements definition = doc.getElementsByAttributeValue("definition", "coboHDMS.admin.title");
        Elements elementsByTag = doc.getElementsByTag("hdms:title");
        Element targetEl = null;
        if (definition != null && definition.size()>0) {
            targetEl = definition.get(0);
            Elements beanMessage = targetEl.getElementsByTag("bean:message");
            if (beanMessage.size()>0) {
                value = beanMessage.attr("key");
            } else {
                Elements tilesAdd = targetEl.getElementsByTag("tiles:add");
                if (tilesAdd.size() > 0) {
                    Element last = tilesAdd.last();
                    value = last.text();
                }
            }
        } else if (elementsByTag != null && elementsByTag.size() > 0) {
            targetEl = elementsByTag.get(0);
            String text = targetEl.attr("text");
            if (StringUtils.isBlank(text)) {
                Elements beanMessage = targetEl.getElementsByTag("bean:message");
                if (beanMessage != null && beanMessage.size() > 0) {
                    value = beanMessage.attr("key");
                }else{
                    value = targetEl.text();
                }
            }
        }
        String html = "<hdms:title text=\"" + value + "\"/>";
        Element title = element.attr("text", value);
        targetEl.after(html).remove();
    }
}
