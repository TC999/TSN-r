package com.bytedance.adsdk.w.w.w.c;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n implements r0.a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f26461a;

    public n(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.f26461a = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.f26461a = Boolean.FALSE;
        } else if (str.equalsIgnoreCase("null")) {
            this.f26461a = null;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Object c(Map<String, JSONObject> map) {
        return this.f26461a;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.f26461a + "]";
    }

    public String w() {
        Object obj = this.f26461a;
        return obj != null ? obj.toString() : "NULL";
    }

    public p0.a c() {
        return com.bytedance.adsdk.w.w.sr.f.CONSTANT;
    }
}
