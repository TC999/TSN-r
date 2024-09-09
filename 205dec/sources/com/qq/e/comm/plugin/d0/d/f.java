package com.qq.e.comm.plugin.d0.d;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str, String str2) {
        JSONObject optJSONObject = this.f42239a.optJSONObject(str2);
        if (optJSONObject != null) {
            return optJSONObject.opt(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        super(str);
    }
}
