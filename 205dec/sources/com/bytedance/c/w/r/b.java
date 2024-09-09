package com.bytedance.c.w.r;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f26542a;

    /* renamed from: b  reason: collision with root package name */
    private String f26543b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f26544c;

    public b(int i4) {
        this.f26542a = i4;
    }

    public boolean a() {
        return this.f26542a == 0;
    }

    public b(int i4, Throwable th) {
        this.f26542a = i4;
        if (th != null) {
            this.f26543b = th.getMessage();
        }
    }

    public b(int i4, String str) {
        this.f26542a = i4;
        this.f26543b = str;
    }

    public b(int i4, JSONObject jSONObject) {
        this.f26542a = i4;
        this.f26544c = jSONObject;
    }
}
