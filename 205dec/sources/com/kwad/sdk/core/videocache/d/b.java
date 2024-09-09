package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements c {
    private HashMap<String, n> aCE = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.aCE.put(str, nVar);
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eJ(String str) {
        if (this.aCE.containsKey(str)) {
            return this.aCE.get(str);
        }
        return null;
    }
}
