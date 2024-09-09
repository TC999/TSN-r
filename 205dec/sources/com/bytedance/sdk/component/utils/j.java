package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f30195c;

    public static String c() {
        if (!TextUtils.isEmpty(f30195c)) {
            return f30195c;
        }
        f30195c = Build.MODEL;
        return f30195c;
    }
}
