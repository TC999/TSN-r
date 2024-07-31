package master.flame.danmaku.danmaku.model;

/* renamed from: master.flame.danmaku.danmaku.model.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SpecialDanmaku extends BaseDanmaku {

    /* renamed from: W */
    public float f43931W;

    /* renamed from: X */
    public float f43932X;

    /* renamed from: Y */
    public float f43933Y;

    /* renamed from: Z */
    public float f43934Z;

    /* renamed from: a0 */
    public float f43935a0;

    /* renamed from: b0 */
    public float f43936b0;

    /* renamed from: c0 */
    public long f43937c0;

    /* renamed from: d0 */
    public long f43938d0;

    /* renamed from: f0 */
    public int f43940f0;

    /* renamed from: g0 */
    public int f43941g0;

    /* renamed from: h0 */
    public int f43942h0;

    /* renamed from: i0 */
    public long f43943i0;

    /* renamed from: j0 */
    public float f43944j0;

    /* renamed from: k0 */
    public float f43945k0;

    /* renamed from: l0 */
    public float f43946l0;

    /* renamed from: m0 */
    public float f43947m0;

    /* renamed from: o0 */
    public C15355a[] f43949o0;

    /* renamed from: e0 */
    public boolean f43939e0 = false;

    /* renamed from: n0 */
    private float[] f43948n0 = new float[4];

    /* compiled from: SpecialDanmaku.java */
    /* renamed from: master.flame.danmaku.danmaku.model.r$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15355a {

        /* renamed from: a */
        C15356b f43950a;

        /* renamed from: b */
        C15356b f43951b;

        /* renamed from: c */
        public long f43952c;

        /* renamed from: d */
        public long f43953d;

        /* renamed from: e */
        public long f43954e;

        /* renamed from: f */
        float f43955f;

        /* renamed from: g */
        float f43956g;

        public C15355a() {
        }

        /* renamed from: a */
        public float[] m2994a() {
            C15356b c15356b = this.f43950a;
            return new float[]{c15356b.f43958a, c15356b.f43959b};
        }

        /* renamed from: b */
        public float m2993b() {
            return this.f43951b.m2990a(this.f43950a);
        }

        /* renamed from: c */
        public float[] m2992c() {
            C15356b c15356b = this.f43951b;
            return new float[]{c15356b.f43958a, c15356b.f43959b};
        }

        /* renamed from: d */
        public void m2991d(C15356b c15356b, C15356b c15356b2) {
            this.f43950a = c15356b;
            this.f43951b = c15356b2;
            this.f43955f = c15356b2.f43958a - c15356b.f43958a;
            this.f43956g = c15356b2.f43959b - c15356b.f43959b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpecialDanmaku.java */
    /* renamed from: master.flame.danmaku.danmaku.model.r$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15356b {

        /* renamed from: a */
        float f43958a;

        /* renamed from: b */
        float f43959b;

        public C15356b(float f, float f2) {
            this.f43958a = f;
            this.f43959b = f2;
        }

        /* renamed from: a */
        public float m2990a(C15356b c15356b) {
            float abs = Math.abs(this.f43958a - c15356b.f43958a);
            float abs2 = Math.abs(this.f43959b - c15356b.f43959b);
            return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
    }

    /* renamed from: H */
    private static final float m3005H(long j, long j2) {
        float f = ((float) j) / ((float) j2);
        return (-1.0f) * f * (f - 2.0f);
    }

    /* renamed from: I */
    public void m3004I(int i, int i2, long j) {
        this.f43940f0 = i;
        this.f43941g0 = i2;
        this.f43942h0 = i2 - i;
        this.f43943i0 = j;
        if (i != AlphaValue.f43835a) {
            this.f43853F = i;
        }
    }

    /* renamed from: J */
    public void m3003J(float[][] fArr) {
        C15355a[] c15355aArr;
        if (fArr != null) {
            int length = fArr.length;
            int i = 0;
            this.f43931W = fArr[0][0];
            this.f43932X = fArr[0][1];
            int i2 = length - 1;
            this.f43933Y = fArr[i2][0];
            this.f43934Z = fArr[i2][1];
            if (fArr.length > 1) {
                this.f43949o0 = new C15355a[fArr.length - 1];
                int i3 = 0;
                while (true) {
                    c15355aArr = this.f43949o0;
                    if (i3 >= c15355aArr.length) {
                        break;
                    }
                    c15355aArr[i3] = new C15355a();
                    i3++;
                    this.f43949o0[i3].m2991d(new C15356b(fArr[i3][0], fArr[i3][1]), new C15356b(fArr[i3][0], fArr[i3][1]));
                }
                float f = 0.0f;
                for (C15355a c15355a : c15355aArr) {
                    f += c15355a.m2993b();
                }
                C15355a c15355a2 = null;
                C15355a[] c15355aArr2 = this.f43949o0;
                int length2 = c15355aArr2.length;
                while (i < length2) {
                    C15355a c15355a3 = c15355aArr2[i];
                    long m2993b = (c15355a3.m2993b() / f) * ((float) this.f43937c0);
                    c15355a3.f43952c = m2993b;
                    long j = c15355a2 == null ? 0L : c15355a2.f43954e;
                    c15355a3.f43953d = j;
                    c15355a3.f43954e = j + m2993b;
                    i++;
                    c15355a2 = c15355a3;
                }
            }
        }
    }

    /* renamed from: K */
    public void m3002K(float f, float f2, float f3, float f4, long j, long j2) {
        this.f43931W = f;
        this.f43932X = f2;
        this.f43933Y = f3;
        this.f43934Z = f4;
        this.f43935a0 = f3 - f;
        this.f43936b0 = f4 - f2;
        this.f43937c0 = j;
        this.f43938d0 = j2;
    }

    /* renamed from: L */
    public void m3001L(float f) {
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: d */
    public float mo3000d() {
        return this.f43948n0[3];
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: g */
    public float mo2999g() {
        return this.f43948n0[0];
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public int getType() {
        return 7;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: h */
    public float[] mo2998h(IDisplayer iDisplayer, long j) {
        int i;
        C15355a c15355a = null;
        if (m3078q()) {
            long m3088b = j - m3088b();
            long j2 = this.f43943i0;
            if (j2 > 0 && (i = this.f43942h0) != 0) {
                if (m3088b >= j2) {
                    this.f43853F = this.f43941g0;
                } else {
                    this.f43853F = this.f43940f0 + ((int) (i * (((float) m3088b) / ((float) j2))));
                }
            }
            float f = this.f43931W;
            float f2 = this.f43932X;
            long j3 = m3088b - this.f43938d0;
            long j4 = this.f43937c0;
            if (j4 > 0 && j3 >= 0 && j3 <= j4) {
                C15355a[] c15355aArr = this.f43949o0;
                if (c15355aArr != null) {
                    int length = c15355aArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        C15355a c15355a2 = c15355aArr[i2];
                        if (j3 >= c15355a2.f43953d && j3 < c15355a2.f43954e) {
                            c15355a = c15355a2;
                            break;
                        }
                        C15356b c15356b = c15355a2.f43951b;
                        float f3 = c15356b.f43958a;
                        i2++;
                        f2 = c15356b.f43959b;
                        f = f3;
                    }
                    if (c15355a != null) {
                        float f4 = c15355a.f43955f;
                        float f5 = c15355a.f43956g;
                        float f6 = ((float) (m3088b - c15355a.f43953d)) / ((float) c15355a.f43952c);
                        C15356b c15356b2 = c15355a.f43950a;
                        float f7 = c15356b2.f43958a;
                        float f8 = c15356b2.f43959b;
                        if (f4 != 0.0f) {
                            f = f7 + (f4 * f6);
                        }
                        if (f5 != 0.0f) {
                            f2 = f8 + (f5 * f6);
                        }
                    }
                } else {
                    float m3005H = this.f43939e0 ? m3005H(j3, j4) : ((float) j3) / ((float) j4);
                    float f9 = this.f43935a0;
                    if (f9 != 0.0f) {
                        f = this.f43931W + (f9 * m3005H);
                    }
                    float f10 = this.f43936b0;
                    if (f10 != 0.0f) {
                        f2 = this.f43932X + (f10 * m3005H);
                    }
                }
            } else if (j3 > j4) {
                f = this.f43933Y;
                f2 = this.f43934Z;
            }
            float[] fArr = this.f43948n0;
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f + this.f43874p;
            fArr[3] = f2 + this.f43875q;
            m3090G(!m3076s());
            return this.f43948n0;
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: i */
    public float mo2997i() {
        return this.f43948n0[2];
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: l */
    public float mo2996l() {
        return this.f43948n0[1];
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: y */
    public void mo2995y(IDisplayer iDisplayer, float f, float f2) {
        mo2998h(iDisplayer, this.f43852E.f43885a);
    }
}
