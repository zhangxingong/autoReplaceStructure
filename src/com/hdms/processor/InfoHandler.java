package com.hdms.processor;

import com.hdms.processor.base.BaseHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class InfoHandler extends BaseHandler {
    @Override
    public void handle(Node node, Document document) {
        Elements definition = document.getElementsByAttributeValue("definition", "coboHDMS.info_classic");
        if (definition.size() > 0) {
            String idStr = "";
            String classStr = "";
            String cols = "";
            Element el = definition.get(0);
            Element infoEl = document.createElement("hdms:info");
            Elements colsEl = el.getElementsByAttributeValue("name", "cols");
            Elements idEl = el.getElementsByAttributeValue("name", "styleId");
            Elements classEl = el.getElementsByAttributeValue("name", "styleClass");
            if (colsEl.size() > 0) {
                cols = colsEl.get(0).attr("value");
                infoEl.attr("cols", cols);
            }
            if (idEl.size() > 0) {
                idStr = idEl.get(0).attr("value");
                infoEl.attr("styleId", idStr);
            }
            if (classEl.size() > 0) {
                classStr = classEl.get(0).attr("value");
                infoEl.attr("styleClass", classStr);
            }
            Elements propertiesEl = el.getElementsByAttributeValue("name", "properties");
            if (propertiesEl.size() > 0) {
                Elements tilesAddEl = propertiesEl.get(0).getElementsByTag("tiles:add");
                for (Element tiles : tilesAddEl) {
                    String textStr = tiles.text();
                    Element infoCellEl = document.createElement("hdms:infoCell");
                    Elements messageEl = tiles.getElementsByTag("bean:message");
                    String text = "";
                    if (messageEl.size() > 0) {
                        text = messageEl.get(0).attr("key");
                    }else{
                        String[] arr = textStr.split("\\$\\$\\$");
                        text = arr[0];
                    }
                    infoCellEl.attr("text", text);
                    String html = tiles.html();
                    String[] arr3 = html.split("\\$\\$\\$");
                    infoCellEl.html(arr3[arr3.length-1]);
                    infoEl.appendChild(infoCellEl);
                }
            }

            Elements bottomEl = el.getElementsByAttributeValue("name", "bottom");
            if (bottomEl.size() > 0) {
                Element btns = document.createElement("hdms:includedBtns");
                btns.html(bottomEl.html());
                infoEl.appendChild(btns);
            }
            el.after(infoEl).remove();
        }
        if (getNextHandler() != null) {
            getNextHandler().handle(node, document);
        }
    }
}
