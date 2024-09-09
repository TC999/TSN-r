package com.bytedance.sdk.openadsdk.f;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr extends c {

    /* renamed from: c  reason: collision with root package name */
    public static xv f35859c;

    public static String c(com.bytedance.sdk.component.ev.w.xv xvVar, String str) {
        Map map;
        xv w3 = w.w("net");
        if (w3 == null || (map = (Map) w3.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                xvVar.w(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    @Override // com.bytedance.sdk.openadsdk.f.c
    public String c() {
        return "net";
    }

    public static void c(com.bytedance.sdk.openadsdk.core.ck.w wVar) {
        try {
            xv w3 = w.w("net");
            if (w3 == null) {
                return;
            }
            String jSONObject = com.bytedance.sdk.component.utils.c.c(wVar.c().toString()).toString();
            HashMap hashMap = new HashMap();
            hashMap.put("body", jSONObject);
            w3.call(2, hashMap);
        } catch (Throwable unused) {
        }
    }

    public static void c(String str) {
        try {
            xv w3 = w.w("net");
            if (w3 == null) {
                return;
            }
            String jSONObject = com.bytedance.sdk.component.utils.c.c(str).toString();
            HashMap hashMap = new HashMap();
            hashMap.put("body", jSONObject);
            w3.call(3, hashMap);
        } catch (Throwable unused) {
        }
    }
}
