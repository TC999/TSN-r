package com.bytedance.sdk.component.f.xv.c;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    public static String f29798c = "com.bytedance.openadsdk";

    /* renamed from: w  reason: collision with root package name */
    public static String f29799w = "content://" + f29798c + ".TTMultiProvider";

    static {
        c();
    }

    public static void c() {
        Context context = w.getContext();
        if (context == null) {
            context = com.bytedance.sdk.component.f.xv.getContext();
        }
        if (context != null) {
            f29798c = context.getPackageName();
            f29799w = "content://" + f29798c + ".TTMultiProvider";
        }
    }
}
