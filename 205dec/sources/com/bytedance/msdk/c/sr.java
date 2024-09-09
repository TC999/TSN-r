package com.bytedance.msdk.c;

import android.text.TextUtils;
import com.bytedance.msdk.f.m;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    public static final String f27665c = m.sr();

    /* renamed from: w  reason: collision with root package name */
    public static boolean f27666w = true;

    public static int c() {
        return Integer.parseInt(w().replace(".", ""));
    }

    public static String sr() {
        return com.bytedance.sdk.gromore.init.c.sr();
    }

    public static String w() {
        return com.bytedance.sdk.gromore.init.c.xv();
    }

    public static String xv() {
        if (TextUtils.isEmpty(w())) {
            return "";
        }
        String[] split = w().split("\\.");
        if (split.length >= 4) {
            return split[0] + "." + split[1] + "." + split[2];
        }
        return "";
    }
}
