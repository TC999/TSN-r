package com.amap.api.col.p0463l;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* renamed from: com.amap.api.col.3l.c9 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RssiInfoManager {

    /* renamed from: g */
    private static volatile RssiInfoManager f3748g;

    /* renamed from: h */
    private static Object f3749h = new Object();

    /* renamed from: e */
    private Object f3754e = new Object();

    /* renamed from: f */
    private Object f3755f = new Object();

    /* renamed from: a */
    private LongSparseArray<C1757a> f3750a = new LongSparseArray<>();

    /* renamed from: b */
    private LongSparseArray<C1757a> f3751b = new LongSparseArray<>();

    /* renamed from: c */
    private LongSparseArray<C1757a> f3752c = new LongSparseArray<>();

    /* renamed from: d */
    private LongSparseArray<C1757a> f3753d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RssiInfoManager.java */
    /* renamed from: com.amap.api.col.3l.c9$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1757a {

        /* renamed from: a */
        int f3756a;

        /* renamed from: b */
        long f3757b;

        /* renamed from: c */
        boolean f3758c;

        private C1757a() {
        }

        /* synthetic */ C1757a(byte b) {
            this();
        }
    }

    private RssiInfoManager() {
    }

    /* renamed from: a */
    public static RssiInfoManager m55445a() {
        if (f3748g == null) {
            synchronized (f3749h) {
                if (f3748g == null) {
                    f3748g = new RssiInfoManager();
                }
            }
        }
        return f3748g;
    }

    /* renamed from: c */
    private static short m55443c(LongSparseArray<C1757a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            C1757a c1757a = longSparseArray.get(j);
            if (c1757a == null) {
                return (short) 0;
            }
            short max = (short) Math.max(1L, Math.min(32767L, (m55440f() - c1757a.f3757b) / 1000));
            if (!c1757a.f3758c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    /* renamed from: e */
    private static void m55441e(List<IRssiInfo> list, LongSparseArray<C1757a> longSparseArray, LongSparseArray<C1757a> longSparseArray2) {
        long m55440f = m55440f();
        if (longSparseArray.size() == 0) {
            for (IRssiInfo iRssiInfo : list) {
                C1757a c1757a = new C1757a((byte) 0);
                c1757a.f3756a = iRssiInfo.mo55266b();
                c1757a.f3757b = m55440f;
                c1757a.f3758c = false;
                longSparseArray2.put(iRssiInfo.mo55267a(), c1757a);
            }
            return;
        }
        for (IRssiInfo iRssiInfo2 : list) {
            long mo55267a = iRssiInfo2.mo55267a();
            C1757a c1757a2 = longSparseArray.get(mo55267a);
            if (c1757a2 == null) {
                c1757a2 = new C1757a((byte) 0);
                c1757a2.f3756a = iRssiInfo2.mo55266b();
                c1757a2.f3757b = m55440f;
                c1757a2.f3758c = true;
            } else if (c1757a2.f3756a != iRssiInfo2.mo55266b()) {
                c1757a2.f3756a = iRssiInfo2.mo55266b();
                c1757a2.f3757b = m55440f;
                c1757a2.f3758c = true;
            }
            longSparseArray2.put(mo55267a, c1757a2);
        }
    }

    /* renamed from: f */
    private static long m55440f() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final short m55444b(long j) {
        return m55443c(this.f3750a, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m55442d(List<IRssiInfo> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f3754e) {
            m55441e(list, this.f3750a, this.f3751b);
            LongSparseArray<C1757a> longSparseArray = this.f3750a;
            this.f3750a = this.f3751b;
            this.f3751b = longSparseArray;
            longSparseArray.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final short m55439g(long j) {
        return m55443c(this.f3752c, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final void m55438h(List<IRssiInfo> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f3755f) {
            m55441e(list, this.f3752c, this.f3753d);
            LongSparseArray<C1757a> longSparseArray = this.f3752c;
            this.f3752c = this.f3753d;
            this.f3753d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
