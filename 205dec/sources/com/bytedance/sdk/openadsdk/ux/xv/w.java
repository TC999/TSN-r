package com.bytedance.sdk.openadsdk.ux.xv;

import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.ux.xv.sr;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w<T extends sr> {

    /* renamed from: c  reason: collision with root package name */
    private me f36344c;
    private T sr;
    private boolean ux = false;

    /* renamed from: w  reason: collision with root package name */
    private String f36345w;
    private JSONObject xv;

    public w(me meVar, String str, JSONObject jSONObject, T t3) {
        this.f36344c = meVar;
        this.f36345w = str;
        this.xv = jSONObject;
        this.sr = t3;
    }

    public me c() {
        return this.f36344c;
    }

    public T sr() {
        return this.sr;
    }

    public boolean ux() {
        return this.ux;
    }

    public String w() {
        return this.f36345w;
    }

    public JSONObject xv() {
        if (this.xv == null) {
            this.xv = new JSONObject();
        }
        return this.xv;
    }

    public void c(boolean z3) {
        this.ux = z3;
    }
}
