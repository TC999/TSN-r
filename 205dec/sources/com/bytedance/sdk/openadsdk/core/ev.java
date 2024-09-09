package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends gd {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile ev f33372c;

    private ev(Context context) {
        super(context);
    }

    public static ev c(Context context) {
        if (f33372c == null) {
            synchronized (ev.class) {
                if (f33372c == null) {
                    f33372c = new ev(context);
                }
            }
        }
        return f33372c;
    }
}
