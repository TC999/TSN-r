package master.flame.danmaku.danmaku.model;

/* renamed from: master.flame.danmaku.danmaku.model.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class R2LDanmaku extends BaseDanmaku {

    /* renamed from: c0 */
    protected static final long f43923c0 = 100;

    /* renamed from: d0 */
    protected static final long f43924d0 = 40;

    /* renamed from: Y */
    protected int f43927Y;

    /* renamed from: a0 */
    protected float f43929a0;

    /* renamed from: b0 */
    protected long f43930b0;

    /* renamed from: W */
    protected float f43925W = 0.0f;

    /* renamed from: X */
    protected float f43926X = -1.0f;

    /* renamed from: Z */
    protected float[] f43928Z = null;

    public R2LDanmaku(C15347g c15347g) {
        this.f43876r = c15347g;
    }

    /* renamed from: H */
    protected float mo3007H(IDisplayer iDisplayer, long j) {
        long m3088b = j - m3088b();
        if (m3088b >= this.f43876r.f43889c) {
            return -this.f43874p;
        }
        return iDisplayer.getWidth() - (((float) m3088b) * this.f43929a0);
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: d */
    public float mo3000d() {
        return this.f43926X + this.f43875q;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: g */
    public float mo2999g() {
        return this.f43925W;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public int getType() {
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: h */
    public float[] mo2998h(IDisplayer iDisplayer, long j) {
        if (m3078q()) {
            float mo3007H = mo3007H(iDisplayer, j);
            if (this.f43928Z == null) {
                this.f43928Z = new float[4];
            }
            float[] fArr = this.f43928Z;
            fArr[0] = mo3007H;
            float f = this.f43926X;
            fArr[1] = f;
            fArr[2] = mo3007H + this.f43874p;
            fArr[3] = f + this.f43875q;
            return fArr;
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: i */
    public float mo2997i() {
        return this.f43925W + this.f43874p;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: l */
    public float mo2996l() {
        return this.f43926X;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: y */
    public void mo2995y(IDisplayer iDisplayer, float f, float f2) {
        DanmakuTimer danmakuTimer = this.f43852E;
        if (danmakuTimer != null) {
            long j = danmakuTimer.f43885a;
            long m3088b = j - m3088b();
            if (m3088b > 0 && m3088b < this.f43876r.f43889c) {
                this.f43925W = mo3007H(iDisplayer, j);
                if (!mo3071v()) {
                    this.f43926X = f2;
                    m3090G(true);
                }
                this.f43930b0 = j;
                return;
            }
            this.f43930b0 = j;
        }
        m3090G(false);
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: z */
    public void mo3006z(IDisplayer iDisplayer, boolean z) {
        super.mo3006z(iDisplayer, z);
        int width = (int) (iDisplayer.getWidth() + this.f43874p);
        this.f43927Y = width;
        this.f43929a0 = width / ((float) this.f43876r.f43889c);
    }
}
