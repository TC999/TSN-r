package com.bytedance.sdk.openadsdk.n;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.q;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {
    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void w(com.bytedance.sdk.component.gd.p pVar) {
        com.bytedance.sdk.component.gd.ev.xv(pVar);
    }

    public static void c(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            q.f().post(runnable);
        }
    }

    public static void c(com.bytedance.sdk.component.gd.p pVar) {
        com.bytedance.sdk.component.gd.ev.w(pVar);
    }
}
