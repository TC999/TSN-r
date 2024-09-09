package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: RssiInfoManager.java */
/* renamed from: com.amap.api.col.3l.d9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d9 {

    /* renamed from: g  reason: collision with root package name */
    private static volatile d9 f7441g;

    /* renamed from: h  reason: collision with root package name */
    private static Object f7442h = new Object();

    /* renamed from: e  reason: collision with root package name */
    private Object f7447e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private Object f7448f = new Object();

    /* renamed from: a  reason: collision with root package name */
    private LongSparseArray<a> f7443a = new LongSparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private LongSparseArray<a> f7444b = new LongSparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private LongSparseArray<a> f7445c = new LongSparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private LongSparseArray<a> f7446d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: RssiInfoManager.java */
    /* renamed from: com.amap.api.col.3l.d9$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f7449a;

        /* renamed from: b  reason: collision with root package name */
        long f7450b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7451c;

        private a() {
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* compiled from: RssiManager.java */
    /* renamed from: com.amap.api.col.3l.d9$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class b implements b9 {

        /* renamed from: a  reason: collision with root package name */
        private long f7452a;

        /* renamed from: b  reason: collision with root package name */
        private int f7453b;

        b(long j4, int i4) {
            this.f7452a = j4;
            this.f7453b = i4;
        }

        public final long a() {
            return this.f7452a;
        }

        public final int b() {
            return this.f7453b;
        }
    }

    private d9() {
    }

    public static d9 a() {
        if (f7441g == null) {
            synchronized (f7442h) {
                if (f7441g == null) {
                    f7441g = new d9();
                }
            }
        }
        return f7441g;
    }

    private static short c(LongSparseArray<a> longSparseArray, long j4) {
        synchronized (longSparseArray) {
            a aVar = longSparseArray.get(j4);
            if (aVar == null) {
                return (short) 0;
            }
            short max = (short) Math.max(1L, Math.min(32767L, (f() - aVar.f7450b) / 1000));
            if (!aVar.f7451c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    private static void e(List<c9> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long f4 = f();
        if (longSparseArray.size() == 0) {
            for (c9 c9Var : list) {
                a aVar = new a((byte) 0);
                aVar.f7449a = c9Var.b();
                aVar.f7450b = f4;
                aVar.f7451c = false;
                longSparseArray2.put(c9Var.a(), aVar);
            }
            return;
        }
        for (c9 c9Var2 : list) {
            long a4 = c9Var2.a();
            a aVar2 = longSparseArray.get(a4);
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
                aVar2.f7449a = c9Var2.b();
                aVar2.f7450b = f4;
                aVar2.f7451c = true;
            } else if (aVar2.f7449a != c9Var2.b()) {
                aVar2.f7449a = c9Var2.b();
                aVar2.f7450b = f4;
                aVar2.f7451c = true;
            }
            longSparseArray2.put(a4, aVar2);
        }
    }

    private static long f() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short b(long j4) {
        return c(this.f7443a, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(List<c9> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f7447e) {
            e(list, this.f7443a, this.f7444b);
            LongSparseArray<a> longSparseArray = this.f7443a;
            this.f7443a = this.f7444b;
            this.f7444b = longSparseArray;
            longSparseArray.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short g(long j4) {
        return c(this.f7445c, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(List<c9> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f7448f) {
            e(list, this.f7445c, this.f7446d);
            LongSparseArray<a> longSparseArray = this.f7445c;
            this.f7445c = this.f7446d;
            this.f7446d = longSparseArray;
            longSparseArray.clear();
        }
    }
}
