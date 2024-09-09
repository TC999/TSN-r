package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.m;
import master.flame.danmaku.danmaku.model.n;
import master.flame.danmaku.danmaku.model.p;
import master.flame.danmaku.danmaku.model.q;
import master.flame.danmaku.danmaku.model.r;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DanmakuFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class d {

    /* renamed from: l  reason: collision with root package name */
    public static final float f61088l = 539.0f;

    /* renamed from: m  reason: collision with root package name */
    public static final float f61089m = 682.0f;

    /* renamed from: n  reason: collision with root package name */
    public static final float f61090n = 385.0f;

    /* renamed from: o  reason: collision with root package name */
    public static final float f61091o = 438.0f;

    /* renamed from: p  reason: collision with root package name */
    public static final long f61092p = 3800;

    /* renamed from: q  reason: collision with root package name */
    public static final int f61093q = 25;

    /* renamed from: r  reason: collision with root package name */
    public static final long f61094r = 4000;

    /* renamed from: s  reason: collision with root package name */
    public static final long f61095s = 9000;

    /* renamed from: f  reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.g f61101f;

    /* renamed from: g  reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.g f61102g;

    /* renamed from: h  reason: collision with root package name */
    public master.flame.danmaku.danmaku.model.g f61103h;

    /* renamed from: j  reason: collision with root package name */
    public n f61105j;

    /* renamed from: k  reason: collision with root package name */
    private DanmakuContext f61106k;

    /* renamed from: a  reason: collision with root package name */
    public int f61096a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f61097b = 0;

    /* renamed from: c  reason: collision with root package name */
    private float f61098c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public long f61099d = 3800;

    /* renamed from: e  reason: collision with root package name */
    public long f61100e = 4000;

    /* renamed from: i  reason: collision with root package name */
    private m f61104i = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFactory.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends m.c<master.flame.danmaku.danmaku.model.d> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f61107e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ float f61108f;

        a(float f4, float f5) {
            this.f61107e = f4;
            this.f61108f = f5;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e */
        public int a(master.flame.danmaku.danmaku.model.d dVar) {
            r rVar = (r) dVar;
            d.this.i(rVar, rVar.W, rVar.X, rVar.Y, rVar.Z, rVar.f61212c0, rVar.f61213d0, this.f61107e, this.f61108f);
            r.a[] aVarArr = rVar.f61224o0;
            if (aVarArr != null && aVarArr.length > 0) {
                int length = aVarArr.length;
                float[][] fArr = (float[][]) Array.newInstance(float.class, length + 1, 2);
                int i4 = 0;
                while (i4 < length) {
                    fArr[i4] = aVarArr[i4].a();
                    int i5 = i4 + 1;
                    fArr[i5] = aVarArr[i4].c();
                    i4 = i5;
                }
                d.h(rVar, fArr, this.f61107e, this.f61108f);
            }
            return 0;
        }
    }

    protected d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        return new d();
    }

    public static void h(master.flame.danmaku.danmaku.model.d dVar, float[][] fArr, float f4, float f5) {
        if (dVar.getType() == 7 && fArr.length != 0 && fArr[0].length == 2) {
            for (int i4 = 0; i4 < fArr.length; i4++) {
                float[] fArr2 = fArr[i4];
                fArr2[0] = fArr2[0] * f4;
                float[] fArr3 = fArr[i4];
                fArr3[1] = fArr3[1] * f5;
            }
            ((r) dVar).J(fArr);
        }
    }

    private synchronized void n(float f4, float f5) {
        this.f61104i.a(new a(f4, f5));
    }

    private void o(master.flame.danmaku.danmaku.model.d dVar) {
        master.flame.danmaku.danmaku.model.g gVar;
        master.flame.danmaku.danmaku.model.g gVar2 = this.f61103h;
        if (gVar2 == null || ((gVar = dVar.f61163r) != null && gVar.f61176c > gVar2.f61176c)) {
            this.f61103h = dVar.f61163r;
            m();
        }
    }

    public master.flame.danmaku.danmaku.model.d b(int i4) {
        return f(i4, this.f61106k);
    }

    public master.flame.danmaku.danmaku.model.d c(int i4, float f4, float f5, float f6, float f7) {
        float f8;
        int i5 = this.f61096a;
        int i6 = this.f61097b;
        boolean p3 = p(f4, f5, f6);
        master.flame.danmaku.danmaku.model.g gVar = this.f61101f;
        if (gVar == null) {
            master.flame.danmaku.danmaku.model.g gVar2 = new master.flame.danmaku.danmaku.model.g(this.f61099d);
            this.f61101f = gVar2;
            gVar2.a(f7);
        } else if (p3) {
            gVar.b(this.f61099d);
        }
        if (this.f61102g == null) {
            this.f61102g = new master.flame.danmaku.danmaku.model.g(3800L);
        }
        if (p3 && f4 > 0.0f) {
            m();
            float f9 = 1.0f;
            if (i5 <= 0 || i6 <= 0) {
                f8 = 1.0f;
            } else {
                f9 = f4 / i5;
                f8 = f5 / i6;
            }
            if (f5 > 0.0f) {
                n(f9, f8);
            }
        }
        if (i4 != 1) {
            if (i4 != 4) {
                if (i4 != 5) {
                    if (i4 != 6) {
                        if (i4 != 7) {
                            return null;
                        }
                        r rVar = new r();
                        this.f61104i.i(rVar);
                        return rVar;
                    }
                    return new p(this.f61101f);
                }
                return new master.flame.danmaku.danmaku.model.i(this.f61102g);
            }
            return new master.flame.danmaku.danmaku.model.h(this.f61102g);
        }
        return new q(this.f61101f);
    }

    public master.flame.danmaku.danmaku.model.d d(int i4, int i5, int i6, float f4, float f5) {
        return c(i4, i5, i6, f4, f5);
    }

    public master.flame.danmaku.danmaku.model.d e(int i4, n nVar, float f4, float f5) {
        if (nVar == null) {
            return null;
        }
        this.f61105j = nVar;
        return d(i4, nVar.getWidth(), nVar.getHeight(), f4, f5);
    }

    public master.flame.danmaku.danmaku.model.d f(int i4, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.f61106k = danmakuContext;
        master.flame.danmaku.danmaku.model.b g4 = danmakuContext.g();
        this.f61105j = g4;
        return d(i4, g4.getWidth(), this.f61105j.getHeight(), this.f61098c, danmakuContext.f61017l);
    }

    public void g(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, long j4) {
        if (dVar.getType() != 7) {
            return;
        }
        ((r) dVar).I(i4, i5, j4);
        o(dVar);
    }

    public void i(master.flame.danmaku.danmaku.model.d dVar, float f4, float f5, float f6, float f7, long j4, long j5, float f8, float f9) {
        if (dVar.getType() != 7) {
            return;
        }
        ((r) dVar).K(f4 * f8, f5 * f9, f6 * f8, f7 * f9, j4, j5);
        o(dVar);
    }

    public void j(DanmakuContext danmakuContext) {
        this.f61106k = danmakuContext;
        this.f61105j = danmakuContext.g();
        f(1, danmakuContext);
    }

    public void k() {
        this.f61105j = null;
        this.f61097b = 0;
        this.f61096a = 0;
        this.f61104i.clear();
        this.f61101f = null;
        this.f61102g = null;
        this.f61103h = null;
        this.f61100e = 4000L;
    }

    public void l(float f4) {
        master.flame.danmaku.danmaku.model.g gVar = this.f61101f;
        if (gVar == null || this.f61102g == null) {
            return;
        }
        gVar.a(f4);
        m();
    }

    public void m() {
        master.flame.danmaku.danmaku.model.g gVar = this.f61101f;
        long j4 = gVar == null ? 0L : gVar.f61176c;
        master.flame.danmaku.danmaku.model.g gVar2 = this.f61102g;
        long j5 = gVar2 == null ? 0L : gVar2.f61176c;
        master.flame.danmaku.danmaku.model.g gVar3 = this.f61103h;
        long j6 = gVar3 != null ? gVar3.f61176c : 0L;
        long max = Math.max(j4, j5);
        this.f61100e = max;
        long max2 = Math.max(max, j6);
        this.f61100e = max2;
        long max3 = Math.max(3800L, max2);
        this.f61100e = max3;
        this.f61100e = Math.max(this.f61099d, max3);
    }

    public boolean p(float f4, float f5, float f6) {
        int i4 = (int) f4;
        if (this.f61096a == i4 && this.f61097b == ((int) f5) && this.f61098c == f6) {
            return false;
        }
        long j4 = ((f4 * f6) / 682.0f) * 3800.0f;
        this.f61099d = j4;
        long min = Math.min(9000L, j4);
        this.f61099d = min;
        this.f61099d = Math.max(4000L, min);
        this.f61096a = i4;
        this.f61097b = (int) f5;
        this.f61098c = f6;
        return true;
    }
}
