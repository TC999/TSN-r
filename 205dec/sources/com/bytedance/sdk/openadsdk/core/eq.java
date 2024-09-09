package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class eq {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f33187c = false;

    /* renamed from: f  reason: collision with root package name */
    public static String f33188f = "main";

    /* renamed from: r  reason: collision with root package name */
    public static boolean f33189r = false;
    public static int sr = 999;
    public static boolean ux = true;

    /* renamed from: w  reason: collision with root package name */
    public static int f33190w = 6106;
    public static String xv = "6.1.0.6";

    public static String c(Context context) {
        return "";
    }

    public static boolean c() {
        return true;
    }

    public static boolean sr() {
        return TextUtils.equals("internal", f33188f);
    }

    public static boolean w() {
        return com.bytedance.sdk.component.k.w.w.u();
    }

    public static String xv() {
        StringBuilder sb = new StringBuilder();
        sb.append(f33188f);
        sb.append(c() ? "_plugin" : "");
        sb.append(f33189r ? "_open" : "_close");
        return sb.toString();
    }
}
