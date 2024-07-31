package com.kwad.sdk.pngencrypt;

/* renamed from: com.kwad.sdk.pngencrypt.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10939p {
    int aKT;
    int aKW;
    int aKX;
    int aKY;
    int aKZ;
    public final C10924e aKn;
    public final boolean aLL;
    int aLM;
    int aLN;
    int aLO;
    int aLP;
    int aLQ;
    int aLR;
    int aLS;
    public final C10931k aLj;
    byte[] buf;

    public C10939p(C10931k c10931k, C10924e c10924e) {
        this.aLj = c10931k;
        this.aKn = c10924e;
        this.aLL = c10924e != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final void m24409h(byte[] bArr, int i) {
        this.buf = bArr;
        this.aLS = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void update(int i) {
        this.aLM = i;
        if (this.aLL) {
            this.aKT = this.aKn.m24449JU();
            C10924e c10924e = this.aKn;
            this.aKX = c10924e.aKX;
            this.aKW = c10924e.aKW;
            this.aKZ = c10924e.aKZ;
            this.aKY = c10924e.aKY;
            this.aLN = c10924e.m24450JT();
            this.aLO = this.aKn.m24451JS();
            this.aLP = this.aKn.m24448JV();
            int m24447JW = this.aKn.m24447JW();
            this.aLQ = m24447JW;
            this.aLR = ((this.aLj.aLt * m24447JW) + 7) / 8;
            return;
        }
        this.aKT = 1;
        this.aKW = 1;
        this.aKX = 1;
        this.aKY = 0;
        this.aKZ = 0;
        this.aLO = i;
        this.aLN = i;
        C10931k c10931k = this.aLj;
        this.aLP = c10931k.aKU;
        this.aLQ = c10931k.aKV;
        this.aLR = c10931k.aLv;
    }
}
