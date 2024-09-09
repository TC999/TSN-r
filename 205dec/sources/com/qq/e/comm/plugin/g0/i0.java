package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    private int f43586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(JSONObject jSONObject) {
        this.f43586a = jSONObject.optInt("priority");
    }

    public int a() {
        return this.f43586a;
    }
}
