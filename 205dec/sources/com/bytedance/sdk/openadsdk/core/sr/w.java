package com.bytedance.sdk.openadsdk.core.sr;

import com.bytedance.sdk.openadsdk.core.ls;
import java.util.Random;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile Random f34577c;

    /* renamed from: w  reason: collision with root package name */
    private static volatile boolean f34578w;

    public static boolean c() {
        return f34578w;
    }

    public static void w() {
        c(ls.w().y(), true);
    }

    private static Random xv() {
        if (f34577c != null) {
            return f34577c;
        }
        f34577c = com.bytedance.sdk.component.utils.c.xv();
        return f34577c;
    }

    public static boolean c(float f4, boolean z3) {
        if (f4 <= 0.0f) {
            if (z3) {
                f34578w = false;
            }
            return false;
        }
        int nextInt = xv().nextInt(100);
        int i4 = (int) (f4 * 100.0f);
        if (z3) {
            f34578w = nextInt < i4;
        }
        return nextInt < i4;
    }
}
