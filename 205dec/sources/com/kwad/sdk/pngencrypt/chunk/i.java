package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i extends p {
    private int aKU;
    private int aKV;
    private int aMp;
    private int aMq;
    private int aMr;
    private int aMs;
    private int aMt;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Kt();
        }
    }

    private int JV() {
        return this.aKU;
    }

    private int JW() {
        return this.aKV;
    }

    private int Kp() {
        return this.aMp;
    }

    private int Kq() {
        return this.aMq;
    }

    private int Kr() {
        return this.aMt;
    }

    private void Kt() {
        dP(this.aLj.aKV);
        dQ(this.aLj.aKU);
        dR(this.aLj.aLn);
        com.kwad.sdk.pngencrypt.k kVar = this.aLj;
        int i4 = kVar.aLp ? 4 : 0;
        if (kVar.aLr) {
            i4++;
        }
        if (!kVar.aLq) {
            i4 += 2;
        }
        dS(i4);
        dT(0);
        dU(0);
        dV(0);
    }

    private void Kv() {
        if (this.aKV > 0 && this.aKU > 0 && this.aMr == 0 && this.aMs == 0) {
            int i4 = this.aMp;
            if (i4 != 1 && i4 != 2 && i4 != 4 && i4 != 8 && i4 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
            int i5 = this.aMt;
            if (i5 >= 0 && i5 <= 1) {
                int i6 = this.aMq;
                if (i6 != 0) {
                    if (i6 != 6 && i6 != 2) {
                        if (i6 == 3) {
                            if (i4 == 16) {
                                throw new PngjException("bad IHDR: bitdepth invalid");
                            }
                            return;
                        } else if (i6 != 4) {
                            throw new PngjException("bad IHDR: invalid colormodel");
                        }
                    }
                    if (i4 != 8 && i4 != 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                }
                return;
            }
            throw new PngjException("bad IHDR: interlace invalid");
        }
        throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
    }

    private void dP(int i4) {
        this.aKV = i4;
    }

    private void dQ(int i4) {
        this.aKU = i4;
    }

    private void dR(int i4) {
        this.aMp = i4;
    }

    private void dS(int i4) {
        this.aMq = i4;
    }

    private void dT(int i4) {
        this.aMr = 0;
    }

    private void dU(int i4) {
        this.aMs = 0;
    }

    private void dV(int i4) {
        this.aMt = 0;
    }

    public final boolean Ks() {
        return Kr() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Ku() {
        Kv();
        return new com.kwad.sdk.pngencrypt.k(JW(), JV(), Kp(), (Kq() & 4) != 0, Kq() == 0 || Kq() == 4, (Kq() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 13) {
            ByteArrayInputStream Kl = dVar.Kl();
            this.aKV = com.kwad.sdk.pngencrypt.n.f(Kl);
            this.aKU = com.kwad.sdk.pngencrypt.n.f(Kl);
            this.aMp = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMq = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMr = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMs = com.kwad.sdk.pngencrypt.n.e(Kl);
            this.aMt = com.kwad.sdk.pngencrypt.n.e(Kl);
            return;
        }
        throw new PngjException("Bad IDHR len " + dVar.len);
    }
}
