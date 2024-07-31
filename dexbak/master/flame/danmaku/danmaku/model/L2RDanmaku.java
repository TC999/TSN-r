package master.flame.danmaku.danmaku.model;

/* renamed from: master.flame.danmaku.danmaku.model.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class L2RDanmaku extends R2LDanmaku {
    public L2RDanmaku(C15347g c15347g) {
        super(c15347g);
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku
    /* renamed from: H */
    protected float mo3007H(IDisplayer iDisplayer, long j) {
        long m3088b = j - m3088b();
        if (m3088b >= this.f43876r.f43889c) {
            return iDisplayer.getWidth();
        }
        return (this.f43929a0 * ((float) m3088b)) - this.f43874p;
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: d */
    public float mo3000d() {
        return this.f43926X + this.f43875q;
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: g */
    public float mo2999g() {
        return this.f43925W;
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
    public int getType() {
        return 6;
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
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

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: i */
    public float mo2997i() {
        return this.f43925W + this.f43874p;
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
    /* renamed from: l */
    public float mo2996l() {
        return this.f43926X;
    }

    @Override // master.flame.danmaku.danmaku.model.R2LDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku
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
}
