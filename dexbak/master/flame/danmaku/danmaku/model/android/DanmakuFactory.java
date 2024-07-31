package master.flame.danmaku.danmaku.model.android;

import java.lang.reflect.Array;
import master.flame.danmaku.danmaku.model.AbsDisplayer;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.C15347g;
import master.flame.danmaku.danmaku.model.FBDanmaku;
import master.flame.danmaku.danmaku.model.FTDanmaku;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.L2RDanmaku;
import master.flame.danmaku.danmaku.model.R2LDanmaku;
import master.flame.danmaku.danmaku.model.SpecialDanmaku;

/* renamed from: master.flame.danmaku.danmaku.model.android.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuFactory {

    /* renamed from: l */
    public static final float f43780l = 539.0f;

    /* renamed from: m */
    public static final float f43781m = 682.0f;

    /* renamed from: n */
    public static final float f43782n = 385.0f;

    /* renamed from: o */
    public static final float f43783o = 438.0f;

    /* renamed from: p */
    public static final long f43784p = 3800;

    /* renamed from: q */
    public static final int f43785q = 25;

    /* renamed from: r */
    public static final long f43786r = 4000;

    /* renamed from: s */
    public static final long f43787s = 9000;

    /* renamed from: f */
    public C15347g f43793f;

    /* renamed from: g */
    public C15347g f43794g;

    /* renamed from: h */
    public C15347g f43795h;

    /* renamed from: j */
    public IDisplayer f43797j;

    /* renamed from: k */
    private DanmakuContext f43798k;

    /* renamed from: a */
    public int f43788a = 0;

    /* renamed from: b */
    public int f43789b = 0;

    /* renamed from: c */
    private float f43790c = 1.0f;

    /* renamed from: d */
    public long f43791d = f43784p;

    /* renamed from: e */
    public long f43792e = f43786r;

    /* renamed from: i */
    private IDanmakus f43796i = new Danmakus();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DanmakuFactory.java */
    /* renamed from: master.flame.danmaku.danmaku.model.android.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15345a extends IDanmakus.AbstractC15350c<BaseDanmaku> {

        /* renamed from: e */
        final /* synthetic */ float f43799e;

        /* renamed from: f */
        final /* synthetic */ float f43800f;

        C15345a(float f, float f2) {
            this.f43799e = f;
            this.f43800f = f2;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
        /* renamed from: e */
        public int mo2892a(BaseDanmaku baseDanmaku) {
            SpecialDanmaku specialDanmaku = (SpecialDanmaku) baseDanmaku;
            DanmakuFactory.this.m3150i(specialDanmaku, specialDanmaku.f43931W, specialDanmaku.f43932X, specialDanmaku.f43933Y, specialDanmaku.f43934Z, specialDanmaku.f43937c0, specialDanmaku.f43938d0, this.f43799e, this.f43800f);
            SpecialDanmaku.C15355a[] c15355aArr = specialDanmaku.f43949o0;
            if (c15355aArr != null && c15355aArr.length > 0) {
                int length = c15355aArr.length;
                float[][] fArr = (float[][]) Array.newInstance(float.class, length + 1, 2);
                int i = 0;
                while (i < length) {
                    fArr[i] = c15355aArr[i].m2994a();
                    int i2 = i + 1;
                    fArr[i2] = c15355aArr[i].m2992c();
                    i = i2;
                }
                DanmakuFactory.m3151h(specialDanmaku, fArr, this.f43799e, this.f43800f);
            }
            return 0;
        }
    }

    protected DanmakuFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static DanmakuFactory m3158a() {
        return new DanmakuFactory();
    }

    /* renamed from: h */
    public static void m3151h(BaseDanmaku baseDanmaku, float[][] fArr, float f, float f2) {
        if (baseDanmaku.getType() == 7 && fArr.length != 0 && fArr[0].length == 2) {
            for (int i = 0; i < fArr.length; i++) {
                float[] fArr2 = fArr[i];
                fArr2[0] = fArr2[0] * f;
                float[] fArr3 = fArr[i];
                fArr3[1] = fArr3[1] * f2;
            }
            ((SpecialDanmaku) baseDanmaku).m3003J(fArr);
        }
    }

    /* renamed from: n */
    private synchronized void m3145n(float f, float f2) {
        this.f43796i.mo3057a(new C15345a(f, f2));
    }

    /* renamed from: o */
    private void m3144o(BaseDanmaku baseDanmaku) {
        C15347g c15347g;
        C15347g c15347g2 = this.f43795h;
        if (c15347g2 == null || ((c15347g = baseDanmaku.f43876r) != null && c15347g.f43889c > c15347g2.f43889c)) {
            this.f43795h = baseDanmaku.f43876r;
            m3146m();
        }
    }

    /* renamed from: b */
    public BaseDanmaku m3157b(int i) {
        return m3153f(i, this.f43798k);
    }

    /* renamed from: c */
    public BaseDanmaku m3156c(int i, float f, float f2, float f3, float f4) {
        float f5;
        int i2 = this.f43788a;
        int i3 = this.f43789b;
        boolean m3143p = m3143p(f, f2, f3);
        C15347g c15347g = this.f43793f;
        if (c15347g == null) {
            C15347g c15347g2 = new C15347g(this.f43791d);
            this.f43793f = c15347g2;
            c15347g2.m3068a(f4);
        } else if (m3143p) {
            c15347g.m3067b(this.f43791d);
        }
        if (this.f43794g == null) {
            this.f43794g = new C15347g(f43784p);
        }
        if (m3143p && f > 0.0f) {
            m3146m();
            float f6 = 1.0f;
            if (i2 <= 0 || i3 <= 0) {
                f5 = 1.0f;
            } else {
                f6 = f / i2;
                f5 = f2 / i3;
            }
            if (f2 > 0.0f) {
                m3145n(f6, f5);
            }
        }
        if (i != 1) {
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            return null;
                        }
                        SpecialDanmaku specialDanmaku = new SpecialDanmaku();
                        this.f43796i.mo3049i(specialDanmaku);
                        return specialDanmaku;
                    }
                    return new L2RDanmaku(this.f43793f);
                }
                return new FTDanmaku(this.f43794g);
            }
            return new FBDanmaku(this.f43794g);
        }
        return new R2LDanmaku(this.f43793f);
    }

    /* renamed from: d */
    public BaseDanmaku m3155d(int i, int i2, int i3, float f, float f2) {
        return m3156c(i, i2, i3, f, f2);
    }

    /* renamed from: e */
    public BaseDanmaku m3154e(int i, IDisplayer iDisplayer, float f, float f2) {
        if (iDisplayer == null) {
            return null;
        }
        this.f43797j = iDisplayer;
        return m3155d(i, iDisplayer.getWidth(), iDisplayer.getHeight(), f, f2);
    }

    /* renamed from: f */
    public BaseDanmaku m3153f(int i, DanmakuContext danmakuContext) {
        if (danmakuContext == null) {
            return null;
        }
        this.f43798k = danmakuContext;
        AbsDisplayer m3221g = danmakuContext.m3221g();
        this.f43797j = m3221g;
        return m3155d(i, m3221g.getWidth(), this.f43797j.getHeight(), this.f43790c, danmakuContext.f43707l);
    }

    /* renamed from: g */
    public void m3152g(BaseDanmaku baseDanmaku, int i, int i2, long j) {
        if (baseDanmaku.getType() != 7) {
            return;
        }
        ((SpecialDanmaku) baseDanmaku).m3004I(i, i2, j);
        m3144o(baseDanmaku);
    }

    /* renamed from: i */
    public void m3150i(BaseDanmaku baseDanmaku, float f, float f2, float f3, float f4, long j, long j2, float f5, float f6) {
        if (baseDanmaku.getType() != 7) {
            return;
        }
        ((SpecialDanmaku) baseDanmaku).m3002K(f * f5, f2 * f6, f3 * f5, f4 * f6, j, j2);
        m3144o(baseDanmaku);
    }

    /* renamed from: j */
    public void m3149j(DanmakuContext danmakuContext) {
        this.f43798k = danmakuContext;
        this.f43797j = danmakuContext.m3221g();
        m3153f(1, danmakuContext);
    }

    /* renamed from: k */
    public void m3148k() {
        this.f43797j = null;
        this.f43789b = 0;
        this.f43788a = 0;
        this.f43796i.clear();
        this.f43793f = null;
        this.f43794g = null;
        this.f43795h = null;
        this.f43792e = f43786r;
    }

    /* renamed from: l */
    public void m3147l(float f) {
        C15347g c15347g = this.f43793f;
        if (c15347g == null || this.f43794g == null) {
            return;
        }
        c15347g.m3068a(f);
        m3146m();
    }

    /* renamed from: m */
    public void m3146m() {
        C15347g c15347g = this.f43793f;
        long j = c15347g == null ? 0L : c15347g.f43889c;
        C15347g c15347g2 = this.f43794g;
        long j2 = c15347g2 == null ? 0L : c15347g2.f43889c;
        C15347g c15347g3 = this.f43795h;
        long j3 = c15347g3 != null ? c15347g3.f43889c : 0L;
        long max = Math.max(j, j2);
        this.f43792e = max;
        long max2 = Math.max(max, j3);
        this.f43792e = max2;
        long max3 = Math.max((long) f43784p, max2);
        this.f43792e = max3;
        this.f43792e = Math.max(this.f43791d, max3);
    }

    /* renamed from: p */
    public boolean m3143p(float f, float f2, float f3) {
        int i = (int) f;
        if (this.f43788a == i && this.f43789b == ((int) f2) && this.f43790c == f3) {
            return false;
        }
        long j = ((f * f3) / 682.0f) * 3800.0f;
        this.f43791d = j;
        long min = Math.min((long) f43787s, j);
        this.f43791d = min;
        this.f43791d = Math.max((long) f43786r, min);
        this.f43788a = i;
        this.f43789b = (int) f2;
        this.f43790c = f3;
        return true;
    }
}
