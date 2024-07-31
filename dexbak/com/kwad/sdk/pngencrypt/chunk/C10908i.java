package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.C10936n;
import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10908i extends AbstractC10915p {
    private int aKU;
    private int aKV;
    private int aMp;
    private int aMq;
    private int aMr;
    private int aMs;
    private int aMt;

    public C10908i(C10931k c10931k) {
        super("IHDR", c10931k);
        if (c10931k != null) {
            m24472Kt();
        }
    }

    /* renamed from: JV */
    private int m24478JV() {
        return this.aKU;
    }

    /* renamed from: JW */
    private int m24477JW() {
        return this.aKV;
    }

    /* renamed from: Kp */
    private int m24476Kp() {
        return this.aMp;
    }

    /* renamed from: Kq */
    private int m24475Kq() {
        return this.aMq;
    }

    /* renamed from: Kr */
    private int m24474Kr() {
        return this.aMt;
    }

    /* renamed from: Kt */
    private void m24472Kt() {
        m24469dP(this.aLj.aKV);
        m24468dQ(this.aLj.aKU);
        m24467dR(this.aLj.aLn);
        C10931k c10931k = this.aLj;
        int i = c10931k.aLp ? 4 : 0;
        if (c10931k.aLr) {
            i++;
        }
        if (!c10931k.aLq) {
            i += 2;
        }
        m24466dS(i);
        m24465dT(0);
        m24464dU(0);
        m24463dV(0);
    }

    /* renamed from: Kv */
    private void m24470Kv() {
        if (this.aKV > 0 && this.aKU > 0 && this.aMr == 0 && this.aMs == 0) {
            int i = this.aMp;
            if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
            int i2 = this.aMt;
            if (i2 >= 0 && i2 <= 1) {
                int i3 = this.aMq;
                if (i3 != 0) {
                    if (i3 != 6 && i3 != 2) {
                        if (i3 == 3) {
                            if (i == 16) {
                                throw new PngjException("bad IHDR: bitdepth invalid");
                            }
                            return;
                        } else if (i3 != 4) {
                            throw new PngjException("bad IHDR: invalid colormodel");
                        }
                    }
                    if (i != 8 && i != 16) {
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

    /* renamed from: dP */
    private void m24469dP(int i) {
        this.aKV = i;
    }

    /* renamed from: dQ */
    private void m24468dQ(int i) {
        this.aKU = i;
    }

    /* renamed from: dR */
    private void m24467dR(int i) {
        this.aMp = i;
    }

    /* renamed from: dS */
    private void m24466dS(int i) {
        this.aMq = i;
    }

    /* renamed from: dT */
    private void m24465dT(int i) {
        this.aMr = 0;
    }

    /* renamed from: dU */
    private void m24464dU(int i) {
        this.aMs = 0;
    }

    /* renamed from: dV */
    private void m24463dV(int i) {
        this.aMt = 0;
    }

    /* renamed from: Ks */
    public final boolean m24473Ks() {
        return m24474Kr() == 1;
    }

    /* renamed from: Ku */
    public final C10931k m24471Ku() {
        m24470Kv();
        return new C10931k(m24477JW(), m24478JV(), m24476Kp(), (m24475Kq() & 4) != 0, m24475Kq() == 0 || m24475Kq() == 4, (m24475Kq() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    /* renamed from: a */
    public final void mo24458a(C10901d c10901d) {
        if (c10901d.len == 13) {
            ByteArrayInputStream m24488Kl = c10901d.m24488Kl();
            this.aKV = C10936n.m24422f(m24488Kl);
            this.aKU = C10936n.m24422f(m24488Kl);
            this.aMp = C10936n.m24424e(m24488Kl);
            this.aMq = C10936n.m24424e(m24488Kl);
            this.aMr = C10936n.m24424e(m24488Kl);
            this.aMs = C10936n.m24424e(m24488Kl);
            this.aMt = C10936n.m24424e(m24488Kl);
            return;
        }
        throw new PngjException("Bad IDHR len " + c10901d.len);
    }
}
