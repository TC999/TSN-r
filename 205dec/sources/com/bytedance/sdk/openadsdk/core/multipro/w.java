package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.eq.ba;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f33974c;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f33975w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        static final com.bytedance.sdk.component.f.c f33976c = ba.c("sp_multi_info");
    }

    public static void c() {
        if (!f33975w) {
            c.f33976c.c("is_support_multi_process", true);
        }
        f33974c = true;
        f33975w = true;
    }

    public static void w() {
        if (f33975w) {
            c.f33976c.c("is_support_multi_process", false);
        }
        f33974c = false;
    }

    public static boolean xv() {
        if (!f33975w) {
            f33974c = c.f33976c.w("is_support_multi_process", false);
            f33975w = true;
        }
        return f33974c;
    }
}
