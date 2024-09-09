package com.qq.e.comm.plugin.d0.d;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends b {

    /* renamed from: b  reason: collision with root package name */
    private Map<String, JSONObject> f42241b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str, String str2) {
        JSONObject jSONObject = this.f42241b.get(str2);
        if (jSONObject != null) {
            return jSONObject.opt(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f42241b.remove(str);
        } else {
            this.f42241b.put(str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f42241b.get(str);
    }
}
