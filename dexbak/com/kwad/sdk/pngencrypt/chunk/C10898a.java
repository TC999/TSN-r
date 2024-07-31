package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import com.kwad.sdk.pngencrypt.InterfaceC10926g;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10898a implements InterfaceC10926g {
    boolean aLT;

    public C10898a() {
        this(true);
    }

    /* renamed from: b */
    private static PngChunk m24503b(String str, C10931k c10931k) {
        return new C10920u(str, c10931k);
    }

    /* renamed from: c */
    private static PngChunk m24502c(String str, C10931k c10931k) {
        if (str.equals("oFFs")) {
            return new C10911l(c10931k);
        }
        if (str.equals("sTER")) {
            return new C10914o(c10931k);
        }
        return null;
    }

    @Override // com.kwad.sdk.pngencrypt.InterfaceC10926g
    /* renamed from: a */
    public final PngChunk mo24440a(C10901d c10901d, C10931k c10931k) {
        PngChunk m24504a = m24504a(c10901d.ahi, c10931k);
        if (m24504a == null) {
            m24504a = m24502c(c10901d.ahi, c10931k);
        }
        if (m24504a == null) {
            m24504a = m24503b(c10901d.ahi, c10931k);
        }
        m24504a.m24506b(c10901d);
        if (this.aLT && c10901d.data != null) {
            m24504a.mo24458a(c10901d);
        }
        return m24504a;
    }

    private C10898a(boolean z) {
        this.aLT = true;
    }

    /* renamed from: a */
    private static PngChunk m24504a(String str, C10931k c10931k) {
        if (str.equals("IDAT")) {
            return new C10906g(c10931k);
        }
        if (str.equals("IHDR")) {
            return new C10908i(c10931k);
        }
        if (str.equals("PLTE")) {
            return new C10912m(c10931k);
        }
        if (str.equals("IEND")) {
            return new C10907h(c10931k);
        }
        if (str.equals("tEXt")) {
            return new C10916q(c10931k);
        }
        if (str.equals("iTXt")) {
            return new C10909j(c10931k);
        }
        if (str.equals("zTXt")) {
            return new C10921v(c10931k);
        }
        if (str.equals("tIME")) {
            return new C10917r(c10931k);
        }
        if (str.equals("tRNS")) {
            return new C10918s(c10931k);
        }
        if (str.equals("sPLT")) {
            return new C10913n(c10931k);
        }
        return null;
    }
}
