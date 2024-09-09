package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {
    public static boolean c() {
        try {
            if (com.bytedance.sdk.openadsdk.core.k.sr().ba()) {
                return true;
            }
            Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
            if (context.getApplicationInfo() != null) {
                return (context.getApplicationInfo().flags & 2) != 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.ys.w.xv.c cVar) {
        try {
            if (!cVar.ev() || com.bytedance.sdk.component.utils.a.c()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.bytedance.sdk.component.utils.a.w();
                com.bykv.vk.openvk.component.video.api.f.xv.c();
                com.bytedance.sdk.component.ev.c.c();
                com.bytedance.sdk.openadsdk.tools.w.w();
                com.bytedance.sdk.component.k.w.c.c(true);
            }
        } catch (Exception unused) {
        }
    }
}
