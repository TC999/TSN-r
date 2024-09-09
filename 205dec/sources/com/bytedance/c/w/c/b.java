package com.bytedance.c.w.c;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f26502b;

    /* renamed from: a  reason: collision with root package name */
    private final f f26503a;

    private b(@NonNull Context context) {
        this.f26503a = new f(context);
    }

    public static b a(Context context) {
        if (f26502b == null) {
            synchronized (b.class) {
                if (f26502b == null) {
                    f26502b = new b(context);
                }
            }
        }
        return f26502b;
    }

    public void b() {
        this.f26503a.c();
    }
}
