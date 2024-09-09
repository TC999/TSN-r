package com.bytedance.adsdk.w.w.w.c;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g implements r0.b {

    /* renamed from: a  reason: collision with root package name */
    private r0.a f26450a;

    /* renamed from: b  reason: collision with root package name */
    private r0.a f26451b;

    /* renamed from: c  reason: collision with root package name */
    private r0.a f26452c;

    public void a(r0.a aVar) {
        this.f26450a = aVar;
    }

    public void b(r0.a aVar) {
        this.f26451b = aVar;
    }

    public Object c(Map<String, JSONObject> map) {
        Object c4 = this.f26450a.c(map);
        if (c4 == null) {
            return null;
        }
        if (((Boolean) c4).booleanValue()) {
            return this.f26451b.c(map);
        }
        return this.f26452c.c(map);
    }

    public String toString() {
        return w();
    }

    public String w() {
        return this.f26450a.w() + "?" + this.f26451b.w() + ":" + this.f26452c.w();
    }

    public p0.a c() {
        return com.bytedance.adsdk.w.w.sr.f.OPERATOR_RESULT;
    }

    public void c(r0.a aVar) {
        this.f26452c = aVar;
    }
}
