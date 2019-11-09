package com.hdms.processor;

import com.hdms.processor.base.BaseHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class TableHandler extends BaseHandler {
    @Override
    public void handle(Node node, Document document) {
        Elements definition = document.getElementsByAttributeValue("definition", "coboHDMS.table_classic");
        if (definition.size() > 0) {
            String idStr = "";
            String titleStr = "";
            String cols = "";
            Element el = definition.get(0);
            Element tableEl = document.createElement("hdms:table");
            Elements idEl = el.getElementsByAttributeValue("name", "tableId");
            Elements titelEl = el.getElementsByAttributeValue("name", "tableTitle");
            if (idEl.size() > 0) {
                idStr = idEl.get(0).attr("value");
                tableEl.attr("styleId", idStr);
            }
            if (titelEl.size() > 0) {
                titleStr = titelEl.get(0).attr("value");
                Element alertEl = document.createElement("hdms:alert");
                alertEl.html(titleStr);
                tableEl.before(alertEl);
            }
            Elements colsEl = el.getElementsByAttributeValue("name", "cols");
            Elements logicList = el.getElementsByTag("logic:iterate");
            Elements newLogic = logicList.clone();
            Element logicEl = newLogic.empty().get(0);
            if (colsEl.size() > 0) {
                Elements tilesAddEl = colsEl.get(0).getElementsByTag("tiles:add");
                for (Element tiles : tilesAddEl) {
                    String textStr = tiles.text();
                    Element tableCellEl = document.createElement("hdms:tableCell");
                    Elements messageEl = tiles.getElementsByTag("bean:message");
                    String text = "";
                    if (messageEl.size() > 0) {
                        text = messageEl.get(0).attr("key");
                    }else{
                        String[] arr = textStr.split("\\$\\$\\$");
                        text = arr[0];
                    }
                    tableCellEl.attr("text", text);
                    String html = tiles.html();
                    String[] arr3 = html.split("\\$\\$\\$");
                    tableCellEl.html(arr3[arr3.length-1]);
                    logicEl.appendChild(tableCellEl);
                }
                logicEl.append("<hdms:tableRowEnd/>");
            }
            tableEl.appendChild(logicEl);
            el.after(tableEl).remove();
        }
        if (getNextHandler() != null) {
            getNextHandler().handle(node, document);
        }
    }
}
