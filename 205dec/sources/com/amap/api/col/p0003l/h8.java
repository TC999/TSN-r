package com.amap.api.col.p0003l;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CellCollector.java */
/* renamed from: com.amap.api.col.3l.h8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h8 {

    /* renamed from: a  reason: collision with root package name */
    private ko f8016a;

    /* renamed from: b  reason: collision with root package name */
    private ko f8017b;

    /* renamed from: c  reason: collision with root package name */
    private j9 f8018c;

    /* renamed from: d  reason: collision with root package name */
    private a f8019d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final List<ko> f8020e = new ArrayList(3);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CellCollector.java */
    /* renamed from: com.amap.api.col.3l.h8$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f8021a;

        /* renamed from: b  reason: collision with root package name */
        public String f8022b;

        /* renamed from: c  reason: collision with root package name */
        public ko f8023c;

        /* renamed from: d  reason: collision with root package name */
        public ko f8024d;

        /* renamed from: e  reason: collision with root package name */
        public ko f8025e;

        /* renamed from: f  reason: collision with root package name */
        public List<ko> f8026f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        public List<ko> f8027g = new ArrayList();

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
            this.f8021a = (byte) 0;
            this.f8022b = "";
            this.f8023c = null;
            this.f8024d = null;
            this.f8025e = null;
            this.f8026f.clear();
            this.f8027g.clear();
        }

        public final void b(byte b4, String str, List<ko> list) {
            a();
            this.f8021a = b4;
            this.f8022b = str;
            if (list != null) {
                this.f8026f.addAll(list);
                for (ko koVar : this.f8026f) {
                    boolean z3 = koVar.f8269i;
                    if (!z3 && koVar.f8268h) {
                        this.f8024d = koVar;
                    } else if (z3 && koVar.f8268h) {
                        this.f8025e = koVar;
                    }
                }
            }
            ko koVar2 = this.f8024d;
            if (koVar2 == null) {
                koVar2 = this.f8025e;
            }
            this.f8023c = koVar2;
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f8021a) + ", operator='" + this.f8022b + "', mainCell=" + this.f8023c + ", mainOldInterCell=" + this.f8024d + ", mainNewInterCell=" + this.f8025e + ", cells=" + this.f8026f + ", historyMainCellList=" + this.f8027g + '}';
        }
    }

    private void b(a aVar) {
        synchronized (this.f8020e) {
            for (ko koVar : aVar.f8026f) {
                if (koVar != null && koVar.f8268h) {
                    ko clone = koVar.clone();
                    clone.f8265e = SystemClock.elapsedRealtime();
                    c(clone);
                }
            }
            this.f8019d.f8027g.clear();
            this.f8019d.f8027g.addAll(this.f8020e);
        }
    }

    private void c(ko koVar) {
        if (koVar == null) {
            return;
        }
        int size = this.f8020e.size();
        if (size == 0) {
            this.f8020e.add(koVar);
            return;
        }
        long j4 = Long.MAX_VALUE;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i4 >= size) {
                i5 = i6;
                break;
            }
            ko koVar2 = this.f8020e.get(i4);
            if (koVar.equals(koVar2)) {
                int i7 = koVar.f8263c;
                if (i7 != koVar2.f8263c) {
                    koVar2.f8265e = i7;
                    koVar2.f8263c = i7;
                }
            } else {
                j4 = Math.min(j4, koVar2.f8265e);
                if (j4 == koVar2.f8265e) {
                    i6 = i4;
                }
                i4++;
            }
        }
        if (i5 >= 0) {
            if (size < 3) {
                this.f8020e.add(koVar);
            } else if (koVar.f8265e <= j4 || i5 >= size) {
            } else {
                this.f8020e.remove(i5);
                this.f8020e.add(koVar);
            }
        }
    }

    private boolean d(j9 j9Var) {
        float f4 = j9Var.f8156g;
        return j9Var.a(this.f8018c) > ((double) ((f4 > 10.0f ? 1 : (f4 == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f4 > 2.0f ? 1 : (f4 == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a a(j9 j9Var, boolean z3, byte b4, String str, List<ko> list) {
        if (z3) {
            this.f8019d.a();
            return null;
        }
        this.f8019d.b(b4, str, list);
        if (this.f8019d.f8023c == null) {
            return null;
        }
        if (this.f8018c == null || d(j9Var) || !a.c(this.f8019d.f8024d, this.f8016a) || !a.c(this.f8019d.f8025e, this.f8017b)) {
            a aVar = this.f8019d;
            this.f8016a = aVar.f8024d;
            this.f8017b = aVar.f8025e;
            this.f8018c = j9Var;
            e9.c(aVar.f8026f);
            b(this.f8019d);
            return this.f8019d;
        }
        return null;
    }
}
