package com.kwad.sdk.pngencrypt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class p {
    int aKT;
    int aKW;
    int aKX;
    int aKY;
    int aKZ;
    public final e aKn;
    public final boolean aLL;
    int aLM;
    int aLN;
    int aLO;
    int aLP;
    int aLQ;
    int aLR;
    int aLS;
    public final k aLj;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.aLj = kVar;
        this.aKn = eVar;
        this.aLL = eVar != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h(byte[] bArr, int i4) {
        this.buf = bArr;
        this.aLS = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void update(int i4) {
        this.aLM = i4;
        if (this.aLL) {
            this.aKT = this.aKn.JU();
            e eVar = this.aKn;
            this.aKX = eVar.aKX;
            this.aKW = eVar.aKW;
            this.aKZ = eVar.aKZ;
            this.aKY = eVar.aKY;
            this.aLN = eVar.JT();
            this.aLO = this.aKn.JS();
            this.aLP = this.aKn.JV();
            int JW = this.aKn.JW();
            this.aLQ = JW;
            this.aLR = ((this.aLj.aLt * JW) + 7) / 8;
            return;
        }
        this.aKT = 1;
        this.aKW = 1;
        this.aKX = 1;
        this.aKY = 0;
        this.aKZ = 0;
        this.aLO = i4;
        this.aLN = i4;
        k kVar = this.aLj;
        this.aLP = kVar.aKU;
        this.aLQ = kVar.aKV;
        this.aLR = kVar.aLv;
    }
}
