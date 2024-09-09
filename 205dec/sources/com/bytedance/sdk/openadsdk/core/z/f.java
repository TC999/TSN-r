package com.bytedance.sdk.openadsdk.core.z;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static AtomicInteger f35748c = new AtomicInteger(1);

    public static boolean c() {
        return f35748c.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(int i4) {
        boolean z3 = true;
        if (i4 == 1 || i4 == 2) {
            try {
                if (f35748c.get() != i4) {
                    try {
                        f35748c.set(i4);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        if (z3) {
                            return;
                        }
                        return;
                    }
                } else {
                    z3 = false;
                }
            } catch (Throwable th2) {
                th = th2;
                z3 = false;
            }
            if (z3 || c()) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.fz.w.ux();
        }
    }
}
