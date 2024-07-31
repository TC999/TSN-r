package com.amap.api.col.p047s;

/* compiled from: LogJsonDataStrategy.java */
/* renamed from: com.amap.api.col.s.m3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2095m3 extends AbstractC2117p3 {

    /* renamed from: c */
    private StringBuilder f6292c;

    /* renamed from: d */
    private boolean f6293d;

    public C2095m3() {
        this.f6292c = new StringBuilder();
        this.f6293d = true;
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: b */
    protected final byte[] mo52644b(byte[] bArr) {
        byte[] m52862o = C2079j1.m52862o(this.f6292c.toString());
        this.f6367b = m52862o;
        this.f6293d = true;
        StringBuilder sb = this.f6292c;
        sb.delete(0, sb.length());
        return m52862o;
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: c */
    public final void mo52692c(byte[] bArr) {
        String m52870g = C2079j1.m52870g(bArr);
        if (this.f6293d) {
            this.f6293d = false;
        } else {
            this.f6292c.append(",");
        }
        StringBuilder sb = this.f6292c;
        sb.append("{\"log\":\"");
        sb.append(m52870g);
        sb.append("\"}");
    }

    public C2095m3(AbstractC2117p3 abstractC2117p3) {
        super(abstractC2117p3);
        this.f6292c = new StringBuilder();
        this.f6293d = true;
    }
}
