package com.kwad.sdk.pngencrypt.chunk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class p extends PngChunk {
    /* JADX INFO: Access modifiers changed from: protected */
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            p pVar = (p) obj;
            String str = this.ahi;
            if (str == null) {
                if (pVar.ahi != null) {
                    return false;
                }
            } else if (!str.equals(pVar.ahi)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.ahi;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
