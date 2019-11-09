package com.hdms.processor.base;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

/**
 * Created by xgzhang on 2019/11/9.
 */
public abstract class BaseHandler {
    protected BaseHandler nextHandler;
    public abstract void handle(Node node, Document parent);

    public BaseHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
