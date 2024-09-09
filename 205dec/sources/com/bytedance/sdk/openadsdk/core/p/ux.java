package com.bytedance.sdk.openadsdk.core.p;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.ev.w.w] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.ev.w.xv] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.ev.w.sr] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void c(int i4, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        ?? xv;
        if (i4 == 0) {
            xv = com.bytedance.sdk.openadsdk.core.q.ux.c().w().xv();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    xv.c(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i4 != 1) {
            xv = 0;
        } else {
            xv = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue().toString());
            }
            xv.c(hashMap);
        }
        if (xv != 0) {
            xv.c(str);
            c(xv.c(), iTTHttpCallback);
        }
    }

    public static void c(String str, byte[] bArr, String str2, int i4, ITTHttpCallback iTTHttpCallback) {
        if (bArr == null) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception("request data is null"));
                return;
            }
            return;
        }
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        w3.c(str);
        w3.c(str2, bArr);
        c(w3.c(), iTTHttpCallback);
    }

    private static void c(com.bytedance.sdk.component.ev.w wVar, ITTHttpCallback iTTHttpCallback) {
        String valueOf;
        if (wVar != null && wVar.ev()) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onResponse(wVar.sr());
                return;
            }
            return;
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(wVar != null && wVar.w() != null ? wVar.w() : null);
        if (iTTHttpCallback != null) {
            if (isEmpty) {
                valueOf = wVar.w();
            } else {
                valueOf = wVar != null ? String.valueOf(wVar.c()) : "";
            }
            iTTHttpCallback.onError(new Exception(valueOf));
        }
    }
}
