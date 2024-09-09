package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public final File aBG;
    public final com.kwad.sdk.core.videocache.a.c aBH;
    public final com.kwad.sdk.core.videocache.a.a aBI;
    public final com.kwad.sdk.core.videocache.d.c aBJ;
    public final com.kwad.sdk.core.videocache.b.b aBK;
    public final int aBL;
    public final int aBM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i4, int i5) {
        this.aBG = file;
        this.aBH = cVar;
        this.aBI = aVar;
        this.aBJ = cVar2;
        this.aBK = bVar;
        this.aBL = i4;
        this.aBM = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File ex(String str) {
        return new File(this.aBG, this.aBH.generate(str));
    }
}
