package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: RssiManager.java */
/* renamed from: com.amap.api.col.3l.e9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e9 {

    /* compiled from: RssiManager.java */
    /* renamed from: com.amap.api.col.3l.e9$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements c9 {

        /* renamed from: a  reason: collision with root package name */
        private int f7502a;

        /* renamed from: b  reason: collision with root package name */
        private int f7503b;

        /* renamed from: c  reason: collision with root package name */
        private int f7504c;

        a(int i4, int i5, int i6) {
            this.f7502a = i4;
            this.f7503b = i5;
            this.f7504c = i6;
        }

        @Override // com.amap.api.col.p0003l.c9
        public final long a() {
            return e9.a(this.f7502a, this.f7503b);
        }

        @Override // com.amap.api.col.p0003l.c9
        public final int b() {
            return this.f7504c;
        }
    }

    /* compiled from: RssiManager.java */
    /* renamed from: com.amap.api.col.3l.e9$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b implements c9 {

        /* renamed from: a  reason: collision with root package name */
        private long f7505a;

        /* renamed from: b  reason: collision with root package name */
        private int f7506b;

        b(long j4, int i4) {
            this.f7505a = j4;
            this.f7506b = i4;
        }

        @Override // com.amap.api.col.p0003l.c9
        public final long a() {
            return this.f7505a;
        }

        @Override // com.amap.api.col.p0003l.c9
        public final int b() {
            return this.f7506b;
        }
    }

    public static long a(int i4, int i5) {
        return (i5 & 4294967295L) | ((i4 & 4294967295L) << 32);
    }

    public static synchronized short b(long j4) {
        short b4;
        synchronized (e9.class) {
            b4 = d9.a().b(j4);
        }
        return b4;
    }

    public static synchronized void c(List<ko> list) {
        synchronized (e9.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ko koVar : list) {
                        if (koVar instanceof kq) {
                            kq kqVar = (kq) koVar;
                            arrayList.add(new a(kqVar.f8275j, kqVar.f8276k, kqVar.f8263c));
                        } else if (koVar instanceof kr) {
                            kr krVar = (kr) koVar;
                            arrayList.add(new a(krVar.f8281j, krVar.f8282k, krVar.f8263c));
                        } else if (koVar instanceof ks) {
                            ks ksVar = (ks) koVar;
                            arrayList.add(new a(ksVar.f8286j, ksVar.f8287k, ksVar.f8263c));
                        } else if (koVar instanceof kp) {
                            kp kpVar = (kp) koVar;
                            arrayList.add(new a(kpVar.f8271k, kpVar.f8272l, kpVar.f8263c));
                        }
                    }
                    d9.a().d(arrayList);
                }
            }
        }
    }

    public static synchronized short d(long j4) {
        short g4;
        synchronized (e9.class) {
            g4 = d9.a().g(j4);
        }
        return g4;
    }

    public static synchronized void e(List<k9> list) {
        synchronized (e9.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (k9 k9Var : list) {
                        arrayList.add(new b(k9Var.f8253a, k9Var.f8255c));
                    }
                    d9.a().h(arrayList);
                }
            }
        }
    }
}
