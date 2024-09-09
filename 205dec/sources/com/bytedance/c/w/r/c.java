package com.bytedance.c.w.r;

import android.content.Context;
import com.bytedance.c.w.b;
import com.bytedance.c.w.ux.h;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f26545a;

    private c(Context context) {
        this.f26545a = context;
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i4) {
        try {
            if (!com.bytedance.c.w.d.a().c().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        com.bytedance.c.w.ux.d.b().postDelayed(new c(context), i4);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new h(this.f26545a).c(b.i.c(this.f26545a));
        } finally {
            try {
            } finally {
            }
        }
    }
}
