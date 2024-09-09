package com.bytedance.sdk.openadsdk.core.live.sr;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.k;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static com.bytedance.sdk.component.f.c f33856c;

    public static void c(String str) {
        w();
        try {
            com.bytedance.sdk.component.f.c cVar = f33856c;
            if (cVar != null) {
                int w3 = cVar.w("live_init_" + str, 0);
                com.bytedance.sdk.component.f.c cVar2 = f33856c;
                cVar2.c("live_init_" + str, w3 + 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void sr(String str) {
        c();
        w(str);
    }

    private static void w() {
        if (f33856c == null) {
            f33856c = ba.c("csj_live");
        }
    }

    public static boolean xv(String str) {
        int i4;
        w();
        com.bytedance.sdk.component.f.c cVar = f33856c;
        if (cVar != null) {
            i4 = cVar.w("live_init_" + str, 0);
        } else {
            i4 = 0;
        }
        return i4 < 5;
    }

    public static void w(String str) {
        w();
        try {
            com.bytedance.sdk.component.f.c cVar = f33856c;
            if (cVar != null) {
                cVar.c("live_init_" + str, 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c() {
        try {
            Bridge f4 = k.sr().f(4);
            if (f4 != null) {
                f4.call(100, b.a().i(0, "com.byted.live.lite").l(), null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
