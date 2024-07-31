package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class PngChunk {
    protected final C10931k aLj;
    public final boolean aMj;
    public final boolean aMk;
    public final boolean aMl;
    protected C10901d aMm;
    private boolean aMn = false;
    protected int aMo = -1;
    public final String ahi;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, C10931k c10931k) {
        this.ahi = str;
        this.aLj = c10931k;
        this.aMj = C10899b.m24496gj(str);
        this.aMk = C10899b.m24495gk(str);
        this.aMl = C10899b.m24494gl(str);
    }

    /* renamed from: Km */
    private long m24508Km() {
        C10901d c10901d = this.aMm;
        if (c10901d != null) {
            return c10901d.m24487Km();
        }
        return -1L;
    }

    /* renamed from: Ko */
    private int m24507Ko() {
        C10901d c10901d = this.aMm;
        if (c10901d != null) {
            return c10901d.len;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo24458a(C10901d c10901d);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m24506b(C10901d c10901d) {
        this.aMm = c10901d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dO */
    public final void m24505dO(int i) {
        this.aMo = i;
    }

    public String toString() {
        return "chunk id= " + this.ahi + " (len=" + m24507Ko() + " offset=" + m24508Km() + ")";
    }
}
