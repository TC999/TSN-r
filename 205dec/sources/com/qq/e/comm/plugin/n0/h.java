package com.qq.e.comm.plugin.n0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends b {
    public h(String str) {
        super(str);
    }

    public h b(long j4) {
        a("du", Long.valueOf(j4));
        return this;
    }

    @Override // com.qq.e.comm.plugin.n0.b
    protected String d() {
        return "pi";
    }

    public h(int i4) {
        super(i4);
    }

    public h b(int i4) {
        a("rs", Integer.valueOf(i4));
        return this;
    }

    public void a(com.qq.e.comm.plugin.d0.e.d dVar) {
        if (dVar != null) {
            a("ct", Integer.valueOf(dVar.a()));
        }
    }
}
