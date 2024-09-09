package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static void c(Context context, me meVar) {
        if (u.xv(meVar)) {
            com.bytedance.sdk.openadsdk.core.a.xv.p(meVar, "playable_preload", "preload_start", null);
        }
    }

    public static void c(Context context, me meVar, long j4, long j5) {
        if (u.xv(meVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("loadzip_success_time", Long.valueOf(j4));
            hashMap.put("unzip_success_time", Long.valueOf(j5));
            com.bytedance.sdk.openadsdk.core.a.xv.p(meVar, "playable_preload", "preload_success", hashMap);
        }
    }

    public static void c(Context context, me meVar, int i4, String str) {
        if (u.xv(meVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_code", Integer.valueOf(i4));
            hashMap.put("error_reason", str);
            com.bytedance.sdk.openadsdk.core.a.xv.p(meVar, "playable_preload", "preload_fail", hashMap);
        }
    }
}
