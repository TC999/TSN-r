package com.amap.api.col.s;

import android.content.Context;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdiuManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class t1 {

    /* renamed from: c  reason: collision with root package name */
    private static t1 f10245c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f10246a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10247b = a2.d(j1.t("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private t1(Context context) {
        this.f10246a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static t1 a(Context context) {
        if (f10245c == null) {
            synchronized (t1.class) {
                if (f10245c == null) {
                    f10245c = new t1(context);
                }
            }
        }
        return f10245c;
    }

    public final synchronized void b() {
        try {
            if (c1.s() == null) {
                c1.l(x1.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        u1.b(this.f10246a).d(this.f10247b);
        u1.b(this.f10246a).g(str);
    }
}
