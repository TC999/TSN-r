package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SpecialDanmaku.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r extends d {
    public float W;
    public float X;
    public float Y;
    public float Z;

    /* renamed from: a0  reason: collision with root package name */
    public float f61210a0;

    /* renamed from: b0  reason: collision with root package name */
    public float f61211b0;

    /* renamed from: c0  reason: collision with root package name */
    public long f61212c0;

    /* renamed from: d0  reason: collision with root package name */
    public long f61213d0;

    /* renamed from: f0  reason: collision with root package name */
    public int f61215f0;

    /* renamed from: g0  reason: collision with root package name */
    public int f61216g0;

    /* renamed from: h0  reason: collision with root package name */
    public int f61217h0;

    /* renamed from: i0  reason: collision with root package name */
    public long f61218i0;

    /* renamed from: j0  reason: collision with root package name */
    public float f61219j0;

    /* renamed from: k0  reason: collision with root package name */
    public float f61220k0;

    /* renamed from: l0  reason: collision with root package name */
    public float f61221l0;

    /* renamed from: m0  reason: collision with root package name */
    public float f61222m0;

    /* renamed from: o0  reason: collision with root package name */
    public a[] f61224o0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f61214e0 = false;

    /* renamed from: n0  reason: collision with root package name */
    private float[] f61223n0 = new float[4];

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SpecialDanmaku.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        b f61225a;

        /* renamed from: b  reason: collision with root package name */
        b f61226b;

        /* renamed from: c  reason: collision with root package name */
        public long f61227c;

        /* renamed from: d  reason: collision with root package name */
        public long f61228d;

        /* renamed from: e  reason: collision with root package name */
        public long f61229e;

        /* renamed from: f  reason: collision with root package name */
        float f61230f;

        /* renamed from: g  reason: collision with root package name */
        float f61231g;

        public a() {
        }

        public float[] a() {
            b bVar = this.f61225a;
            return new float[]{bVar.f61233a, bVar.f61234b};
        }

        public float b() {
            return this.f61226b.a(this.f61225a);
        }

        public float[] c() {
            b bVar = this.f61226b;
            return new float[]{bVar.f61233a, bVar.f61234b};
        }

        public void d(b bVar, b bVar2) {
            this.f61225a = bVar;
            this.f61226b = bVar2;
            this.f61230f = bVar2.f61233a - bVar.f61233a;
            this.f61231g = bVar2.f61234b - bVar.f61234b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SpecialDanmaku.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        float f61233a;

        /* renamed from: b  reason: collision with root package name */
        float f61234b;

        public b(float f4, float f5) {
            this.f61233a = f4;
            this.f61234b = f5;
        }

        public float a(b bVar) {
            float abs = Math.abs(this.f61233a - bVar.f61233a);
            float abs2 = Math.abs(this.f61234b - bVar.f61234b);
            return (float) Math.sqrt((abs * abs) + (abs2 * abs2));
        }
    }

    private static final float H(long j4, long j5) {
        float f4 = ((float) j4) / ((float) j5);
        return (-1.0f) * f4 * (f4 - 2.0f);
    }

    public void I(int i4, int i5, long j4) {
        this.f61215f0 = i4;
        this.f61216g0 = i5;
        this.f61217h0 = i5 - i4;
        this.f61218i0 = j4;
        if (i4 != c.f61143a) {
            this.F = i4;
        }
    }

    public void J(float[][] fArr) {
        a[] aVarArr;
        if (fArr != null) {
            int length = fArr.length;
            int i4 = 0;
            this.W = fArr[0][0];
            this.X = fArr[0][1];
            int i5 = length - 1;
            this.Y = fArr[i5][0];
            this.Z = fArr[i5][1];
            if (fArr.length > 1) {
                this.f61224o0 = new a[fArr.length - 1];
                int i6 = 0;
                while (true) {
                    aVarArr = this.f61224o0;
                    if (i6 >= aVarArr.length) {
                        break;
                    }
                    aVarArr[i6] = new a();
                    i6++;
                    this.f61224o0[i6].d(new b(fArr[i6][0], fArr[i6][1]), new b(fArr[i6][0], fArr[i6][1]));
                }
                float f4 = 0.0f;
                for (a aVar : aVarArr) {
                    f4 += aVar.b();
                }
                a aVar2 = null;
                a[] aVarArr2 = this.f61224o0;
                int length2 = aVarArr2.length;
                while (i4 < length2) {
                    a aVar3 = aVarArr2[i4];
                    long b4 = (aVar3.b() / f4) * ((float) this.f61212c0);
                    aVar3.f61227c = b4;
                    long j4 = aVar2 == null ? 0L : aVar2.f61229e;
                    aVar3.f61228d = j4;
                    aVar3.f61229e = j4 + b4;
                    i4++;
                    aVar2 = aVar3;
                }
            }
        }
    }

    public void K(float f4, float f5, float f6, float f7, long j4, long j5) {
        this.W = f4;
        this.X = f5;
        this.Y = f6;
        this.Z = f7;
        this.f61210a0 = f6 - f4;
        this.f61211b0 = f7 - f5;
        this.f61212c0 = j4;
        this.f61213d0 = j5;
    }

    public void L(float f4) {
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float d() {
        return this.f61223n0[3];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float g() {
        return this.f61223n0[0];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 7;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] h(n nVar, long j4) {
        int i4;
        a aVar = null;
        if (q()) {
            long b4 = j4 - b();
            long j5 = this.f61218i0;
            if (j5 > 0 && (i4 = this.f61217h0) != 0) {
                if (b4 >= j5) {
                    this.F = this.f61216g0;
                } else {
                    this.F = this.f61215f0 + ((int) (i4 * (((float) b4) / ((float) j5))));
                }
            }
            float f4 = this.W;
            float f5 = this.X;
            long j6 = b4 - this.f61213d0;
            long j7 = this.f61212c0;
            if (j7 > 0 && j6 >= 0 && j6 <= j7) {
                a[] aVarArr = this.f61224o0;
                if (aVarArr != null) {
                    int length = aVarArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        a aVar2 = aVarArr[i5];
                        if (j6 >= aVar2.f61228d && j6 < aVar2.f61229e) {
                            aVar = aVar2;
                            break;
                        }
                        b bVar = aVar2.f61226b;
                        float f6 = bVar.f61233a;
                        i5++;
                        f5 = bVar.f61234b;
                        f4 = f6;
                    }
                    if (aVar != null) {
                        float f7 = aVar.f61230f;
                        float f8 = aVar.f61231g;
                        float f9 = ((float) (b4 - aVar.f61228d)) / ((float) aVar.f61227c);
                        b bVar2 = aVar.f61225a;
                        float f10 = bVar2.f61233a;
                        float f11 = bVar2.f61234b;
                        if (f7 != 0.0f) {
                            f4 = f10 + (f7 * f9);
                        }
                        if (f8 != 0.0f) {
                            f5 = f11 + (f8 * f9);
                        }
                    }
                } else {
                    float H = this.f61214e0 ? H(j6, j7) : ((float) j6) / ((float) j7);
                    float f12 = this.f61210a0;
                    if (f12 != 0.0f) {
                        f4 = this.W + (f12 * H);
                    }
                    float f13 = this.f61211b0;
                    if (f13 != 0.0f) {
                        f5 = this.X + (f13 * H);
                    }
                }
            } else if (j6 > j7) {
                f4 = this.Y;
                f5 = this.Z;
            }
            float[] fArr = this.f61223n0;
            fArr[0] = f4;
            fArr[1] = f5;
            fArr[2] = f4 + this.f61161p;
            fArr[3] = f5 + this.f61162q;
            G(!s());
            return this.f61223n0;
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float i() {
        return this.f61223n0[2];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float l() {
        return this.f61223n0[1];
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void y(n nVar, float f4, float f5) {
        h(nVar, this.E.f61172a);
    }
}
