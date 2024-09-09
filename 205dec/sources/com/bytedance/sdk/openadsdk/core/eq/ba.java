package com.bytedance.sdk.openadsdk.core.eq;

import android.annotation.SuppressLint;
import com.bytedance.sdk.component.f.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ba {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f33195c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: c  reason: collision with root package name */
        static final sr.c f33196c = ba.xv();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class w {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: c  reason: collision with root package name */
        static final sr.c f33197c = ba.xv();
    }

    public static com.bytedance.sdk.component.f.c c(String str) {
        return c.f33196c.c(w(str)).c();
    }

    private static sr.c sr() {
        com.bytedance.sdk.openadsdk.core.z.r w3 = com.bytedance.sdk.openadsdk.core.ls.w();
        w3.qu();
        return new sr.c().c(com.bytedance.sdk.openadsdk.core.ls.getContext()).c(1).w(w3.cf()).w(f33195c);
    }

    public static int w() {
        return 3;
    }

    private static String w(String str) {
        if (f33195c || com.bytedance.sdk.component.utils.s.c(com.bytedance.sdk.openadsdk.core.ls.getContext())) {
            return str;
        }
        return str + com.bytedance.sdk.component.utils.s.w(com.bytedance.sdk.openadsdk.core.ls.getContext());
    }

    static /* synthetic */ sr.c xv() {
        return sr();
    }

    public static com.bytedance.sdk.component.f.c c(String str, boolean z3) {
        return w.f33197c.c(w(str)).c(z3).c();
    }

    public static void c() {
        f33195c = true;
    }
}
