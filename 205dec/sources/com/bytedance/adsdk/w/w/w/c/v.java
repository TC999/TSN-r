package com.bytedance.adsdk.w.w.w.c;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class v implements r0.a {

    /* renamed from: a  reason: collision with root package name */
    private Number f26464a;

    public v(String str) {
        if (str.indexOf(46) > -1) {
            Float valueOf = Float.valueOf(str);
            this.f26464a = valueOf;
            if (Float.isInfinite(valueOf.floatValue())) {
                this.f26464a = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.f26464a = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.f26464a = Long.valueOf(str);
        }
    }

    public Object c(Map<String, JSONObject> map) {
        return this.f26464a;
    }

    public String toString() {
        return w();
    }

    public String w() {
        return this.f26464a.toString();
    }

    public p0.a c() {
        return com.bytedance.adsdk.w.w.sr.f.NUMBER;
    }
}
