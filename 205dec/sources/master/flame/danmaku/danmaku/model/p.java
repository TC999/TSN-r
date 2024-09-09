package master.flame.danmaku.danmaku.model;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: L2RDanmaku.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class p extends q {
    public p(g gVar) {
        super(gVar);
    }

    @Override // master.flame.danmaku.danmaku.model.q
    protected float H(n nVar, long j4) {
        long b4 = j4 - b();
        if (b4 >= this.f61163r.f61176c) {
            return nVar.getWidth();
        }
        return (this.f61208a0 * ((float) b4)) - this.f61161p;
    }

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
    public float d() {
        return this.X + this.f61162q;
    }

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
    public float g() {
        return this.W;
    }

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
    public int getType() {
        return 6;
    }

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
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

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
    public float i() {
        return this.W + this.f61161p;
    }

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
    public float l() {
        return this.X;
    }

    @Override // master.flame.danmaku.danmaku.model.q, master.flame.danmaku.danmaku.model.d
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
}
