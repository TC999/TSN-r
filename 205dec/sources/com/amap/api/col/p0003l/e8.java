package com.amap.api.col.p0003l;

import android.os.SystemClock;
import com.amap.api.col.p0003l.h8;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FpsBufferBuilder.java */
/* renamed from: com.amap.api.col.3l.e8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e8 extends d8 {
    public e8() {
        super(2048);
    }

    private int b(long j4, List<k9> list) {
        g(list);
        int size = list.size();
        if (size > 0) {
            int[] iArr = new int[size];
            for (int i4 = 0; i4 < size; i4++) {
                k9 k9Var = list.get(i4);
                int b4 = this.f7439a.b(k9Var.f8254b);
                long j5 = k9Var.f8253a;
                iArr[i4] = b9.b(this.f7439a, j5 == j4 && j5 != -1, j5, (short) k9Var.f8255c, b4, k9Var.f8259g, (short) k9Var.f8256d);
            }
            return a9.b(this.f7439a, a9.c(this.f7439a, iArr));
        }
        return -1;
    }

    private int c(h8.a aVar) {
        int i4;
        int i5;
        int i6;
        byte b4;
        int i7;
        int c4;
        int c5;
        e(aVar.f8026f);
        int size = aVar.f8026f.size();
        int[] iArr = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            ko koVar = aVar.f8026f.get(i8);
            if (koVar instanceof kq) {
                kq kqVar = (kq) koVar;
                if (!kqVar.f8269i) {
                    c5 = v8.b(this.f7439a, kqVar.f8275j, kqVar.f8276k, kqVar.f8263c, kqVar.f8277l);
                } else {
                    c5 = v8.c(this.f7439a, kqVar.b(), kqVar.c(), kqVar.f8275j, kqVar.f8276k, kqVar.f8263c, kqVar.f8278m, kqVar.f8279n, kqVar.f8264d, kqVar.f8277l);
                }
                i7 = c5;
                i6 = -1;
                b4 = 1;
            } else if (koVar instanceof kr) {
                kr krVar = (kr) koVar;
                i7 = w8.b(this.f7439a, krVar.b(), krVar.c(), krVar.f8281j, krVar.f8282k, krVar.f8283l, krVar.f8263c, krVar.f8284m, krVar.f8264d);
                i6 = -1;
                b4 = 3;
            } else if (koVar instanceof kp) {
                kp kpVar = (kp) koVar;
                if (!kpVar.f8269i) {
                    c4 = o8.b(this.f7439a, kpVar.f8270j, kpVar.f8271k, kpVar.f8272l, kpVar.f8273m, kpVar.f8274n, kpVar.f8263c);
                } else {
                    c4 = o8.c(this.f7439a, kpVar.f8270j, kpVar.f8271k, kpVar.f8272l, kpVar.f8273m, kpVar.f8274n, kpVar.f8263c, kpVar.f8264d);
                }
                i7 = c4;
                i6 = -1;
                b4 = 2;
            } else if (koVar instanceof ks) {
                ks ksVar = (ks) koVar;
                i7 = z8.b(this.f7439a, ksVar.b(), ksVar.c(), ksVar.f8286j, ksVar.f8287k, ksVar.f8288l, ksVar.f8263c, ksVar.f8289m, ksVar.f8264d);
                i6 = -1;
                b4 = 4;
            } else {
                i6 = -1;
                b4 = 0;
                i7 = -1;
            }
            if (i7 == i6) {
                return i6;
            }
            iArr[i8] = r8.b(this.f7439a, koVar.f8268h ? (byte) 1 : (byte) 0, koVar.f8269i ? (byte) 1 : (byte) 0, (short) koVar.f8267g, b4, i7);
        }
        int b5 = this.f7439a.b(aVar.f8022b);
        int c6 = p8.c(this.f7439a, iArr);
        int size2 = aVar.f8027g.size();
        int[] iArr2 = new int[size2];
        for (int i9 = 0; i9 < size2; i9++) {
            ko koVar2 = aVar.f8027g.get(i9);
            long elapsedRealtime = (SystemClock.elapsedRealtime() - koVar2.f8265e) / 1000;
            elapsedRealtime = (elapsedRealtime > 32767 || elapsedRealtime < 0) ? 32767L : 32767L;
            if (koVar2 instanceof kq) {
                kq kqVar2 = (kq) koVar2;
                i4 = y8.a(this.f7439a, kqVar2.f8275j, kqVar2.f8276k, (short) elapsedRealtime);
            } else if (koVar2 instanceof kr) {
                kr krVar2 = (kr) koVar2;
                i4 = y8.a(this.f7439a, krVar2.f8281j, krVar2.f8282k, (short) elapsedRealtime);
            } else {
                if (koVar2 instanceof kp) {
                    kp kpVar2 = (kp) koVar2;
                    i4 = x8.a(this.f7439a, kpVar2.f8270j, kpVar2.f8271k, kpVar2.f8272l, (short) elapsedRealtime);
                    i5 = 2;
                } else if (koVar2 instanceof ks) {
                    ks ksVar2 = (ks) koVar2;
                    i4 = y8.a(this.f7439a, ksVar2.f8286j, ksVar2.f8287k, (short) elapsedRealtime);
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                iArr2[i9] = q8.b(this.f7439a, (byte) i5, i4);
            }
            i5 = 1;
            iArr2[i9] = q8.b(this.f7439a, (byte) i5, i4);
        }
        return p8.b(this.f7439a, b5, aVar.f8021a, c6, p8.f(this.f7439a, iArr2));
    }

    private int d(j9 j9Var) {
        long j4 = j9Var.f8227k;
        int i4 = (int) j9Var.f8158i;
        int i5 = (int) j9Var.f8156g;
        short s3 = (short) j9Var.f8157h;
        byte b4 = j9Var.f8228l;
        return u8.b(this.f7439a, j9Var.f8152c, j4, (int) (j9Var.f8154e * 1000000.0d), (int) (j9Var.f8153d * 1000000.0d), (int) j9Var.f8155f, i4, i5, s3, b4);
    }

    private static void e(List<ko> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ko koVar : list) {
            if (koVar instanceof kq) {
                kq kqVar = (kq) koVar;
                koVar.f8267g = e9.b(e9.a(kqVar.f8275j, kqVar.f8276k));
            } else if (koVar instanceof kr) {
                kr krVar = (kr) koVar;
                koVar.f8267g = e9.b(e9.a(krVar.f8281j, krVar.f8282k));
            } else if (koVar instanceof ks) {
                ks ksVar = (ks) koVar;
                koVar.f8267g = e9.b(e9.a(ksVar.f8286j, ksVar.f8287k));
            } else if (koVar instanceof kp) {
                kp kpVar = (kp) koVar;
                koVar.f8267g = e9.b(e9.a(kpVar.f8271k, kpVar.f8272l));
            }
        }
    }

    private static void g(List<k9> list) {
        for (k9 k9Var : list) {
            k9Var.f8259g = e9.d(k9Var.f8253a);
        }
    }

    public final byte[] f(j9 j9Var, h8.a aVar, long j4, List<k9> list) {
        List<ko> list2;
        super.a();
        try {
            int d4 = d(j9Var);
            int i4 = -1;
            int c4 = (aVar == null || (list2 = aVar.f8026f) == null || list2.size() <= 0) ? -1 : c(aVar);
            if (list != null && list.size() > 0) {
                i4 = b(j4, list);
            }
            m8.a(this.f7439a);
            m8.b(this.f7439a, d4);
            if (c4 > 0) {
                m8.e(this.f7439a, c4);
            }
            if (i4 > 0) {
                m8.d(this.f7439a, i4);
            }
            this.f7439a.w(m8.c(this.f7439a));
            return this.f7439a.z();
        } catch (Throwable th) {
            n9.a(th);
            return null;
        }
    }
}
