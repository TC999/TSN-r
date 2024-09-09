package com.qq.e.comm.plugin.b;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private int f42002a;

    /* renamed from: b  reason: collision with root package name */
    private int f42003b;

    /* renamed from: c  reason: collision with root package name */
    private int f42004c;

    /* renamed from: d  reason: collision with root package name */
    private int f42005d;

    /* renamed from: e  reason: collision with root package name */
    private String f42006e;

    public h(boolean z3, int i4, int i5, int i6, int i7, String str) {
        this.f42002a = i4;
        this.f42003b = i5;
        this.f42004c = i6;
        this.f42005d = i7;
        this.f42006e = str;
    }

    public Object a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("width", Integer.valueOf(this.f42002a));
        jSONObject.putOpt("height", Integer.valueOf(this.f42003b));
        jSONObject.putOpt("visibleWidth", Integer.valueOf(this.f42004c));
        jSONObject.putOpt("visibleHeight", Integer.valueOf(this.f42005d));
        jSONObject.putOpt("description", this.f42006e);
        return jSONObject;
    }
}
