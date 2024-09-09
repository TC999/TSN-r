package com.qq.e.comm.plugin.d0.d;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final JSONObject f42240b = new JSONObject();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f42239a.opt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f42239a = jSONObject;
        } else {
            this.f42239a = f42240b;
        }
    }
}
