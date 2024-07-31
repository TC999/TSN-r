package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC10915p extends PngChunk {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC10915p(String str, C10931k c10931k) {
        super(str, c10931k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC10915p abstractC10915p = (AbstractC10915p) obj;
            String str = this.ahi;
            if (str == null) {
                if (abstractC10915p.ahi != null) {
                    return false;
                }
            } else if (!str.equals(abstractC10915p.ahi)) {
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
