package com.hdms.processor;

import com.hdms.processor.base.BaseHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Created by xgzhang on 2019/11/9.
 */
public class ButtonHandler extends BaseHandler {

    @Override
    public void handle(Node node, Document document) {
        Elements definition = document.getElementsByAttributeValue("definition", "coboHDMS.buttons");
        if (definition.size() > 0) {
            Element targetEl = definition.get(0);
            Elements tilesAdd = targetEl.getElementsByTag("tiles:add");
            if (tilesAdd.size() > 0) {
                for (Element btnEl : tilesAdd) {
                    String elText = btnEl.text();
                    if ("cancel".equalsIgnoreCase(elText.trim())
                            ||"back".equalsIgnoreCase(elText.trim())) {
                        targetEl.after("<hdms:btn click=\"window.history.back()\" text=\"coboHDMS.uitl.back\" />");
                    } else if ("winClose".equalsIgnoreCase(elText.trim())) {
                        targetEl.after("<hdms.btn click=\"window.close()\" text=\"coboHDMS.util.close\" />");
                    }else{
                        String[] arr = elText.split("\\$\\$\\$");
                        Elements nameBtn = btnEl.getElementsByTag("bean:message");
                        String text ="";
                        String click ="";
                        if (nameBtn.size() > 0) {
                            text = nameBtn.get(0).attr("key");
                            click = elText.replaceAll("\\$","");
                        }else{
                            text = arr[0];
                            click = arr[1];
                        }
                        targetEl.before("<hdms:btn text=\""+text+"\" btnPrimary=\"true\" click=\""+click+"\"/>");
                    }
                }
                targetEl.remove();
            }
        }

    }
}
