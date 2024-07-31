package master.flame.danmaku.danmaku.model;

/* renamed from: master.flame.danmaku.danmaku.model.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class FTDanmaku extends BaseDanmaku {

    /* renamed from: W */
    private float f43890W = 0.0f;

    /* renamed from: X */
    protected float f43891X = -1.0f;

    /* renamed from: Y */
    private float[] f43892Y = null;

    /* renamed from: Z */
    private float f43893Z;

    /* renamed from: a0 */
    private float f43894a0;

    /* renamed from: b0 */
    private int f43895b0;

    public FTDanmaku(C15347g c15347g) {
        this.f43876r = c15347g;
    }

    /* renamed from: H */
    protected float m3066H(IDisplayer iDisplayer) {
        if (this.f43895b0 == iDisplayer.getWidth() && this.f43894a0 == this.f43874p) {
            return this.f43893Z;
        }
        float width = (iDisplayer.getWidth() - this.f43874p) / 2.0f;
        this.f43895b0 = iDisplayer.getWidth();
        this.f43894a0 = this.f43874p;
        this.f43893Z = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: d */
    public float mo3000d() {
        return this.f43891X + this.f43875q;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: g */
    public float mo2999g() {
        return this.f43890W;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    public int getType() {
        return 5;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: h */
    public float[] mo2998h(IDisplayer iDisplayer, long j) {
        if (m3078q()) {
            float m3066H = m3066H(iDisplayer);
            if (this.f43892Y == null) {
                this.f43892Y = new float[4];
            }
            float[] fArr = this.f43892Y;
            fArr[0] = m3066H;
            float f = this.f43891X;
            fArr[1] = f;
            fArr[2] = m3066H + this.f43874p;
            fArr[3] = f + this.f43875q;
            return fArr;
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: i */
    public float mo2997i() {
        return this.f43890W + this.f43874p;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: l */
    public float mo2996l() {
        return this.f43891X;
    }

    @Override // master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: y */
    public void mo2995y(IDisplayer iDisplayer, float f, float f2) {
        DanmakuTimer danmakuTimer = this.f43852E;
        if (danmakuTimer != null) {
            long m3088b = danmakuTimer.f43885a - m3088b();
            if (m3088b > 0 && m3088b < this.f43876r.f43889c) {
                if (mo3071v()) {
                    return;
                }
                this.f43890W = m3066H(iDisplayer);
                this.f43891X = f2;
                m3090G(true);
                return;
            }
            m3090G(false);
            this.f43891X = -1.0f;
            this.f43890W = iDisplayer.getWidth();
        }
    }
}
