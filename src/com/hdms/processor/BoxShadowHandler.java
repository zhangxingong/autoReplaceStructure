package com.hdms.processor;

import com.hdms.processor.base.BaseHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class BoxShadowHandler extends BaseHandler {

    @Override
    public void handle(Node node, Document document) {
        Elements frams = document.getElementsByAttributeValue("id", "frame");
        Element boxShaow = document.createElement("hdms:boxShadow");
        if (frams.size() > 0) {
            Element element = frams.get(0);
            String html = element.html();
            boxShaow.html(html);
            element.wrap(boxShaow.toString()).remove();
        }
    }
}
