package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FTDanmaku.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i extends d {
    private float W = 0.0f;
    protected float X = -1.0f;
    private float[] Y = null;
    private float Z;

    /* renamed from: a0  reason: collision with root package name */
    private float f61177a0;

    /* renamed from: b0  reason: collision with root package name */
    private int f61178b0;

    public i(g gVar) {
        this.f61163r = gVar;
    }

    protected float H(n nVar) {
        if (this.f61178b0 == nVar.getWidth() && this.f61177a0 == this.f61161p) {
            return this.Z;
        }
        float width = (nVar.getWidth() - this.f61161p) / 2.0f;
        this.f61178b0 = nVar.getWidth();
        this.f61177a0 = this.f61161p;
        this.Z = width;
        return width;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float d() {
        return this.X + this.f61162q;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float g() {
        return this.W;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 5;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] h(n nVar, long j4) {
        if (q()) {
            float H = H(nVar);
            if (this.Y == null) {
                this.Y = new float[4];
            }
            float[] fArr = this.Y;
            fArr[0] = H;
            float f4 = this.X;
            fArr[1] = f4;
            fArr[2] = H + this.f61161p;
            fArr[3] = f4 + this.f61162q;
            return fArr;
        }
        return null;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float i() {
        return this.W + this.f61161p;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float l() {
        return this.X;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void y(n nVar, float f4, float f5) {
        f fVar = this.E;
        if (fVar != null) {
            long b4 = fVar.f61172a - b();
            if (b4 > 0 && b4 < this.f61163r.f61176c) {
                if (v()) {
                    return;
                }
                this.W = H(nVar);
                this.X = f5;
                G(true);
                return;
            }
            G(false);
            this.X = -1.0f;
            this.W = nVar.getWidth();
        }
    }
}
