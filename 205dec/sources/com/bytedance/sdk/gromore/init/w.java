package com.bytedance.sdk.gromore.init;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static com.bytedance.msdk.api.sr.f c(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar) {
        if (xvVar != null) {
            com.bytedance.msdk.api.sr.f fVar = new com.bytedance.msdk.api.sr.f();
            fVar.c(xvVar.w());
            fVar.sr(xvVar.f());
            fVar.w(xvVar.xv());
            fVar.xv(xvVar.sr());
            fVar.c(xvVar.ux());
            fVar.ux(xvVar.r());
            fVar.c(xvVar.c());
            return fVar;
        }
        return null;
    }

    public static Map<String, String> c(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }
}
