package com.alibaba.fastjson.support.spring;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MappingFastJsonValue {
    private String jsonpFunction;
    private Object value;

    public MappingFastJsonValue(Object obj) {
        this.value = obj;
    }

    public String getJsonpFunction() {
        return this.jsonpFunction;
    }

    public Object getValue() {
        return this.value;
    }

    public void setJsonpFunction(String str) {
        this.jsonpFunction = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
