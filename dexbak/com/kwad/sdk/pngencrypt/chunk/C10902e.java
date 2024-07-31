package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.C10931k;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10902e {
    final C10931k aKl;
    List<PngChunk> aMe = new ArrayList();
    boolean aMf = false;

    public C10902e(C10931k c10931k) {
        this.aKl = c10931k;
    }

    /* renamed from: a */
    private static List<PngChunk> m24481a(List<PngChunk> list, final String str, final String str2) {
        if (str2 == null) {
            return C10899b.m24501a(list, new InterfaceC10900c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
                @Override // com.kwad.sdk.pngencrypt.chunk.InterfaceC10900c
                /* renamed from: a */
                public final boolean mo24479a(PngChunk pngChunk) {
                    return pngChunk.ahi.equals(str);
                }
            });
        }
        return C10899b.m24501a(list, new InterfaceC10900c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.InterfaceC10900c
            /* renamed from: a */
            public final boolean mo24479a(PngChunk pngChunk) {
                if (pngChunk.ahi.equals(str)) {
                    if (!(pngChunk instanceof AbstractC10919t) || ((AbstractC10919t) pngChunk).getKey().equals(str2)) {
                        return !(pngChunk instanceof C10913n) || ((C10913n) pngChunk).m24460Kw().equals(str2);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    /* renamed from: Kn */
    public final List<PngChunk> m24483Kn() {
        return this.aMe;
    }

    /* renamed from: am */
    public final List<? extends PngChunk> m24480am(String str, String str2) {
        return m24481a(this.aMe, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.aMe.size();
    }

    /* renamed from: a */
    public final void m24482a(PngChunk pngChunk, int i) {
        pngChunk.m24505dO(i);
        this.aMe.add(pngChunk);
        if (pngChunk.ahi.equals("PLTE")) {
            this.aMf = true;
        }
    }
}
