package com.kwad.sdk.pngencrypt.chunk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k aLj;
    public final boolean aMj;
    public final boolean aMk;
    public final boolean aMl;
    protected d aMm;
    private boolean aMn = false;
    protected int aMo = -1;
    public final String ahi;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i4, boolean z3) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i4 < 4 : this == BEFORE_PLTE_AND_IDAT ? i4 < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z3 ? i4 < 4 : i4 < 4 && i4 > 2 : this == AFTER_IDAT && i4 > 4;
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

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.ahi = str;
        this.aLj = kVar;
        this.aMj = b.gj(str);
        this.aMk = b.gk(str);
        this.aMl = b.gl(str);
    }

    private long Km() {
        d dVar = this.aMm;
        if (dVar != null) {
            return dVar.Km();
        }
        return -1L;
    }

    private int Ko() {
        d dVar = this.aMm;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(d dVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(d dVar) {
        this.aMm = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dO(int i4) {
        this.aMo = i4;
    }

    public String toString() {
        return "chunk id= " + this.ahi + " (len=" + Ko() + " offset=" + Km() + ")";
    }
}
