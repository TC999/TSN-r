package com.alibaba.fastjson;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class JSONStreamContext {
    static final int ArrayValue = 1005;
    static final int PropertyKey = 1002;
    static final int PropertyValue = 1003;
    static final int StartArray = 1004;
    static final int StartObject = 1001;
    protected final JSONStreamContext parent;
    protected int state;

    public JSONStreamContext(JSONStreamContext jSONStreamContext, int i4) {
        this.parent = jSONStreamContext;
        this.state = i4;
    }
}
