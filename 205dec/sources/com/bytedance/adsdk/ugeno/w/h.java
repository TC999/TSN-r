package com.bytedance.adsdk.ugeno.w;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.component.b f26383a;

    /* renamed from: b  reason: collision with root package name */
    private int f26384b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f26385c;

    /* renamed from: d  reason: collision with root package name */
    private h f26386d;

    /* renamed from: e  reason: collision with root package name */
    private h f26387e;

    public com.bytedance.adsdk.ugeno.component.b a() {
        return this.f26383a;
    }

    public void b(int i4) {
        this.f26384b = i4;
    }

    public void c(com.bytedance.adsdk.ugeno.component.b bVar) {
        this.f26383a = bVar;
    }

    public void d(h hVar) {
        this.f26386d = hVar;
    }

    public void e(JSONObject jSONObject) {
        this.f26385c = jSONObject;
    }

    public h f() {
        return this.f26386d;
    }

    public int g() {
        return this.f26384b;
    }

    public void h(h hVar) {
        this.f26387e = hVar;
    }

    public JSONObject i() {
        return this.f26385c;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.f26383a + ", mEventType=" + this.f26384b + ", mEvent=" + this.f26385c + '}';
    }
}
