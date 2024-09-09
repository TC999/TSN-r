package com.bytedance.msdk.xv;

import android.content.Context;
import com.bytedance.msdk.f.ck;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static int f28579c = -1;

    /* renamed from: w  reason: collision with root package name */
    private static long f28580w;

    public static int c(Context context) {
        if (f28579c != -1 && System.currentTimeMillis() - f28580w <= 60000) {
            return f28579c;
        }
        f28579c = ck.xv(context);
        f28580w = System.currentTimeMillis();
        return f28579c;
    }

    public static int w(Context context) {
        return ck.c(c(context));
    }

    public static String xv(Context context) {
        return ck.w(c(context));
    }
}
