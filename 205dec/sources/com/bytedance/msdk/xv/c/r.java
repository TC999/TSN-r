package com.bytedance.msdk.xv.c;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends ev {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile r f28481c;

    private r(Context context) {
        super(context);
    }

    public static r c(Context context) {
        if (f28481c == null) {
            synchronized (r.class) {
                if (f28481c == null) {
                    f28481c = new r(context);
                }
            }
        }
        return f28481c;
    }
}
