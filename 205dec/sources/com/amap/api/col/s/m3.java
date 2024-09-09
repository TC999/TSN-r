package com.amap.api.col.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LogJsonDataStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m3 extends p3 {

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f10020c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10021d;

    public m3() {
        this.f10020c = new StringBuilder();
        this.f10021d = true;
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        byte[] o4 = j1.o(this.f10020c.toString());
        this.f10095b = o4;
        this.f10021d = true;
        StringBuilder sb = this.f10020c;
        sb.delete(0, sb.length());
        return o4;
    }

    @Override // com.amap.api.col.s.p3
    public final void c(byte[] bArr) {
        String g4 = j1.g(bArr);
        if (this.f10021d) {
            this.f10021d = false;
        } else {
            this.f10020c.append(",");
        }
        StringBuilder sb = this.f10020c;
        sb.append("{\"log\":\"");
        sb.append(g4);
        sb.append("\"}");
    }

    public m3(p3 p3Var) {
        super(p3Var);
        this.f10020c = new StringBuilder();
        this.f10021d = true;
    }
}
