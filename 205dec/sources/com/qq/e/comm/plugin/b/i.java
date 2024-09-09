package com.qq.e.comm.plugin.b;

import android.content.Context;
import android.os.Build;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42007a = Build.BRAND;

    /* renamed from: b  reason: collision with root package name */
    public static final String f42008b = Build.DEVICE;

    /* renamed from: c  reason: collision with root package name */
    public static final String f42009c = Build.FINGERPRINT;

    /* renamed from: d  reason: collision with root package name */
    public static final String f42010d = Build.HARDWARE;

    /* renamed from: e  reason: collision with root package name */
    public static final String f42011e = Build.PRODUCT;

    public static boolean a(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
