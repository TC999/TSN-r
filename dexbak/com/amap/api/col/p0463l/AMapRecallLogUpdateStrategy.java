package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.b5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AMapRecallLogUpdateStrategy extends UpdateStrategy {

    /* renamed from: h */
    private static int f3682h = 10000000;

    /* renamed from: b */
    protected int f3683b;

    /* renamed from: c */
    protected long f3684c;

    /* renamed from: d */
    private boolean f3685d;

    /* renamed from: e */
    private boolean f3686e;

    /* renamed from: f */
    private int f3687f;

    /* renamed from: g */
    private long f3688g;

    public AMapRecallLogUpdateStrategy(boolean z, UpdateStrategy updateStrategy, long j, int i) {
        super(updateStrategy);
        this.f3686e = false;
        this.f3685d = z;
        this.f3683b = 600000;
        this.f3688g = j;
        this.f3687f = i;
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: a */
    public final int mo53646a() {
        return 320000;
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: d */
    protected final boolean mo53576d() {
        if (!this.f3686e || this.f3688g > this.f3687f) {
            if (this.f3685d && this.f3688g < this.f3687f) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f3684c < this.f3683b) {
                    return false;
                }
                this.f3684c = currentTimeMillis;
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final void m55544f(int i) {
        if (i <= 0) {
            return;
        }
        this.f3688g += i;
    }

    /* renamed from: g */
    public final void m55543g(boolean z) {
        this.f3686e = z;
    }

    /* renamed from: h */
    public final long m55542h() {
        return this.f3688g;
    }
}
