package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: UploadBufferBuilder.java */
/* renamed from: com.amap.api.col.3l.g8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g8 extends d8 {

    /* renamed from: c  reason: collision with root package name */
    private static g8 f7890c = new g8();

    /* compiled from: CellCollector.java */
    /* renamed from: com.amap.api.col.3l.g8$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f7891a;

        /* renamed from: b  reason: collision with root package name */
        public String f7892b;

        /* renamed from: c  reason: collision with root package name */
        public ko f7893c;

        /* renamed from: d  reason: collision with root package name */
        public ko f7894d;

        /* renamed from: e  reason: collision with root package name */
        public ko f7895e;

        /* renamed from: f  reason: collision with root package name */
        public List<ko> f7896f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public List<ko> f7897g = new ArrayList();

        public static boolean c(ko koVar, ko koVar2) {
            if (koVar == null || koVar2 == null) {
                return (koVar == null) == (koVar2 == null);
            } else if ((koVar instanceof kq) && (koVar2 instanceof kq)) {
                kq kqVar = (kq) koVar;
                kq kqVar2 = (kq) koVar2;
                return kqVar.f8275j == kqVar2.f8275j && kqVar.f8276k == kqVar2.f8276k;
            } else if ((koVar instanceof kp) && (koVar2 instanceof kp)) {
                kp kpVar = (kp) koVar;
                kp kpVar2 = (kp) koVar2;
                return kpVar.f8272l == kpVar2.f8272l && kpVar.f8271k == kpVar2.f8271k && kpVar.f8270j == kpVar2.f8270j;
            } else if ((koVar instanceof kr) && (koVar2 instanceof kr)) {
                kr krVar = (kr) koVar;
                kr krVar2 = (kr) koVar2;
                return krVar.f8281j == krVar2.f8281j && krVar.f8282k == krVar2.f8282k;
            } else {
                if ((koVar instanceof ks) && (koVar2 instanceof ks)) {
                    ks ksVar = (ks) koVar;
                    ks ksVar2 = (ks) koVar2;
                    if (ksVar.f8286j == ksVar2.f8286j && ksVar.f8287k == ksVar2.f8287k) {
                        return true;
                    }
                }
                return false;
            }
        }

        public final void a() {
            this.f7891a = (byte) 0;
            this.f7892b = "";
            this.f7893c = null;
            this.f7894d = null;
            this.f7895e = null;
            this.f7896f.clear();
            this.f7897g.clear();
        }

        public final void b(byte b4, String str, List<ko> list) {
            a();
            this.f7891a = b4;
            this.f7892b = str;
            if (list != null) {
                this.f7896f.addAll(list);
                for (ko koVar : this.f7896f) {
                    boolean z3 = koVar.f8269i;
                    if (!z3 && koVar.f8268h) {
                        this.f7894d = koVar;
                    } else if (z3 && koVar.f8268h) {
                        this.f7895e = koVar;
                    }
                }
            }
            ko koVar2 = this.f7894d;
            if (koVar2 == null) {
                koVar2 = this.f7895e;
            }
            this.f7893c = koVar2;
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f7891a) + ", operator='" + this.f7892b + "', mainCell=" + this.f7893c + ", mainOldInterCell=" + this.f7894d + ", mainNewInterCell=" + this.f7895e + ", cells=" + this.f7896f + ", historyMainCellList=" + this.f7897g + '}';
        }
    }

    private g8() {
        super(5120);
    }

    private static String b(String str) {
        return str == null ? "" : str;
    }

    public static g8 d() {
        return f7890c;
    }

    public final byte[] c(byte[] bArr, byte[] bArr2, List<? extends k8> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int c4 = n8.c(this.f7439a, bArr);
            int[] iArr = new int[size];
            for (int i4 = 0; i4 < size; i4++) {
                k8 k8Var = list.get(i4);
                iArr[i4] = s8.b(this.f7439a, (byte) k8Var.a(), s8.c(this.f7439a, k8Var.b()));
            }
            this.f7439a.w(n8.b(this.f7439a, c4, bArr2 != null ? n8.f(this.f7439a, bArr2) : 0, n8.d(this.f7439a, iArr)));
            return this.f7439a.z();
        } catch (Throwable th) {
            n9.a(th);
            return null;
        }
    }

    public final byte[] e() {
        super.a();
        try {
            this.f7439a.w(m9.b(this.f7439a, l9.a(), this.f7439a.b(l9.m()), this.f7439a.b(l9.g()), (byte) l9.A(), this.f7439a.b(l9.s()), this.f7439a.b(l9.q()), this.f7439a.b(b(l9.o())), this.f7439a.b(b(l9.u())), k9.a(l9.C()), this.f7439a.b(l9.y()), this.f7439a.b(l9.w()), this.f7439a.b(l9.i()), this.f7439a.b(l9.k())));
            return this.f7439a.z();
        } catch (Exception e4) {
            n9.a(e4);
            return null;
        }
    }
}
