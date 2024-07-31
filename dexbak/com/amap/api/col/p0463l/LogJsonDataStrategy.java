package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.l7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LogJsonDataStrategy extends UpdateDataStrategy {

    /* renamed from: c */
    private StringBuilder f4661c;

    /* renamed from: d */
    private boolean f4662d;

    public LogJsonDataStrategy() {
        this.f4661c = new StringBuilder();
        this.f4662d = true;
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: b */
    protected final byte[] mo54164b(byte[] bArr) {
        byte[] m54189o = C1925p4.m54189o(this.f4661c.toString());
        this.f4808b = m54189o;
        this.f4662d = true;
        StringBuilder sb = this.f4661c;
        sb.delete(0, sb.length());
        return m54189o;
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: c */
    public final void mo54362c(byte[] bArr) {
        String m54197g = C1925p4.m54197g(bArr);
        if (this.f4662d) {
            this.f4662d = false;
        } else {
            this.f4661c.append(",");
        }
        StringBuilder sb = this.f4661c;
        sb.append("{\"log\":\"");
        sb.append(m54197g);
        sb.append("\"}");
    }

    public LogJsonDataStrategy(UpdateDataStrategy updateDataStrategy) {
        super(updateDataStrategy);
        this.f4661c = new StringBuilder();
        this.f4662d = true;
    }
}
