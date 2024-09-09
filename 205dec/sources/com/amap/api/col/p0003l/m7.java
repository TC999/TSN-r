package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LogJsonDataStrategy.java */
/* renamed from: com.amap.api.col.3l.m7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m7 extends p7 {

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f8357c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8358d;

    public m7() {
        this.f8357c = new StringBuilder();
        this.f8358d = true;
    }

    @Override // com.amap.api.col.p0003l.p7
    protected final byte[] b(byte[] bArr) {
        byte[] o4 = q4.o(this.f8357c.toString());
        this.f8647b = o4;
        this.f8358d = true;
        StringBuilder sb = this.f8357c;
        sb.delete(0, sb.length());
        return o4;
    }

    @Override // com.amap.api.col.p0003l.p7
    public final void c(byte[] bArr) {
        String g4 = q4.g(bArr);
        if (this.f8358d) {
            this.f8358d = false;
        } else {
            this.f8357c.append(",");
        }
        StringBuilder sb = this.f8357c;
        sb.append("{\"log\":\"");
        sb.append(g4);
        sb.append("\"}");
    }

    public m7(p7 p7Var) {
        super(p7Var);
        this.f8357c = new StringBuilder();
        this.f8358d = true;
    }
}
