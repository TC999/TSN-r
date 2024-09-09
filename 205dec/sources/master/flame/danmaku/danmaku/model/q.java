package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: R2LDanmaku.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q extends d {

    /* renamed from: c0  reason: collision with root package name */
    protected static final long f61206c0 = 100;

    /* renamed from: d0  reason: collision with root package name */
    protected static final long f61207d0 = 40;
    protected int Y;

    /* renamed from: a0  reason: collision with root package name */
    protected float f61208a0;

    /* renamed from: b0  reason: collision with root package name */
    protected long f61209b0;
    protected float W = 0.0f;
    protected float X = -1.0f;
    protected float[] Z = null;

    public q(g gVar) {
        this.f61163r = gVar;
    }

    protected float H(n nVar, long j4) {
        long b4 = j4 - b();
        if (b4 >= this.f61163r.f61176c) {
            return -this.f61161p;
        }
        return nVar.getWidth() - (((float) b4) * this.f61208a0);
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
        return 1;
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public float[] h(n nVar, long j4) {
        if (q()) {
            float H = H(nVar, j4);
            if (this.Z == null) {
                this.Z = new float[4];
            }
            float[] fArr = this.Z;
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
            long j4 = fVar.f61172a;
            long b4 = j4 - b();
            if (b4 > 0 && b4 < this.f61163r.f61176c) {
                this.W = H(nVar, j4);
                if (!v()) {
                    this.X = f5;
                    G(true);
                }
                this.f61209b0 = j4;
                return;
            }
            this.f61209b0 = j4;
        }
        G(false);
    }

    @Override // master.flame.danmaku.danmaku.model.d
    public void z(n nVar, boolean z3) {
        super.z(nVar, z3);
        int width = (int) (nVar.getWidth() + this.f61161p);
        this.Y = width;
        this.f61208a0 = width / ((float) this.f61163r.f61176c);
    }
}
