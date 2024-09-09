package com.amap.api.col.p0003l;

import android.os.SystemClock;
import com.amap.api.col.p0003l.h8;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FpsCollector.java */
/* renamed from: com.amap.api.col.3l.i8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i8 {

    /* renamed from: g  reason: collision with root package name */
    private static volatile i8 f8132g;

    /* renamed from: h  reason: collision with root package name */
    private static Object f8133h = new Object();

    /* renamed from: c  reason: collision with root package name */
    private long f8136c;

    /* renamed from: d  reason: collision with root package name */
    private j9 f8137d;

    /* renamed from: f  reason: collision with root package name */
    private j9 f8139f = new j9();

    /* renamed from: a  reason: collision with root package name */
    private h8 f8134a = new h8();

    /* renamed from: b  reason: collision with root package name */
    private j8 f8135b = new j8();

    /* renamed from: e  reason: collision with root package name */
    private e8 f8138e = new e8();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: FpsCollector.java */
    /* renamed from: com.amap.api.col.3l.i8$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public j9 f8140a;

        /* renamed from: b  reason: collision with root package name */
        public List<k9> f8141b;

        /* renamed from: c  reason: collision with root package name */
        public long f8142c;

        /* renamed from: d  reason: collision with root package name */
        public long f8143d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8144e;

        /* renamed from: f  reason: collision with root package name */
        public long f8145f;

        /* renamed from: g  reason: collision with root package name */
        public byte f8146g;

        /* renamed from: h  reason: collision with root package name */
        public String f8147h;

        /* renamed from: i  reason: collision with root package name */
        public List<ko> f8148i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f8149j;
    }

    private i8() {
    }

    public static i8 a() {
        if (f8132g == null) {
            synchronized (f8133h) {
                if (f8132g == null) {
                    f8132g = new i8();
                }
            }
        }
        return f8132g;
    }

    public final k8 b(a aVar) {
        k8 k8Var = null;
        if (aVar == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        j9 j9Var = this.f8137d;
        if (j9Var == null || aVar.f8140a.a(j9Var) >= 10.0d) {
            h8.a a4 = this.f8134a.a(aVar.f8140a, aVar.f8149j, aVar.f8146g, aVar.f8147h, aVar.f8148i);
            List<k9> a5 = this.f8135b.a(aVar.f8140a, aVar.f8141b, aVar.f8144e, aVar.f8143d, currentTimeMillis);
            if (a4 != null || a5 != null) {
                g9.a(this.f8139f, aVar.f8140a, aVar.f8145f, currentTimeMillis);
                k8Var = new k8(0, this.f8138e.f(this.f8139f, a4, aVar.f8142c, a5));
            }
            this.f8137d = aVar.f8140a;
            this.f8136c = elapsedRealtime;
        }
        return k8Var;
    }
}
