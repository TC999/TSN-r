package com.bytedance.sdk.component.r.w.c.c;

import com.bytedance.sdk.component.r.c.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static String f30058c = "com.bytedance.openadsdk";

    /* renamed from: w  reason: collision with root package name */
    private static String f30059w = "content://" + f30058c + ".TTMultiProvider";

    public static String c(ux uxVar) {
        if (uxVar.getContext() != null) {
            f30058c = uxVar.getContext().getPackageName();
            f30059w = "content://" + f30058c + ".TTMultiProvider";
        }
        return f30059w;
    }
}
