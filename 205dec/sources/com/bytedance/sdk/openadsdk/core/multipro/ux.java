package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    public static String f33972c = "com.bytedance.openadsdk";

    /* renamed from: w  reason: collision with root package name */
    public static String f33973w = "content://" + f33972c + ".TTMultiProvider";

    static {
        c();
    }

    public static void c() {
        if (ls.getContext() != null) {
            f33972c = ls.getContext().getPackageName();
            f33973w = "content://" + f33972c + ".TTMultiProvider";
        }
    }
}
