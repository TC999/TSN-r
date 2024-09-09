package com.alibaba.fastjson.support.spring;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FastJsonContainer {
    private PropertyPreFilters filters;
    private Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastJsonContainer(Object obj) {
        this.value = obj;
    }

    public PropertyPreFilters getFilters() {
        return this.filters;
    }

    public Object getValue() {
        return this.value;
    }

    public void setFilters(PropertyPreFilters propertyPreFilters) {
        this.filters = propertyPreFilters;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
