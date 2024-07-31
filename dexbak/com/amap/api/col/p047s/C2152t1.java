package com.amap.api.col.p047s;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: AdiuManager.java */
/* renamed from: com.amap.api.col.s.t1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2152t1 {

    /* renamed from: c */
    private static C2152t1 f6517c;

    /* renamed from: a */
    private final Context f6518a;

    /* renamed from: b */
    private final String f6519b = C2018a2.m53261d(C2079j1.m52857t("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private C2152t1(Context context) {
        this.f6518a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    public static C2152t1 m52445a(Context context) {
        if (f6517c == null) {
            synchronized (C2152t1.class) {
                if (f6517c == null) {
                    f6517c = new C2152t1(context);
                }
            }
        }
        return f6517c;
    }

    /* renamed from: b */
    public final synchronized void m52444b() {
        try {
            if (C2023c1.m53155s() == null) {
                C2023c1.m53162l(C2200x1.m52324a());
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public final void m52443c(String str) {
        C2160u1.m52436b(this.f6518a).m52434d(this.f6519b);
        C2160u1.m52436b(this.f6518a).m52431g(str);
    }
}
