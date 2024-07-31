package com.kwad.sdk.core.videocache.p416d;

import com.kwad.sdk.core.videocache.C10582n;
import java.util.HashMap;

/* renamed from: com.kwad.sdk.core.videocache.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10565b implements InterfaceC10566c {
    private HashMap<String, C10582n> aCE = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.p416d.InterfaceC10566c
    /* renamed from: a */
    public final void mo25461a(String str, C10582n c10582n) {
        this.aCE.put(str, c10582n);
    }

    @Override // com.kwad.sdk.core.videocache.p416d.InterfaceC10566c
    /* renamed from: eJ */
    public final C10582n mo25460eJ(String str) {
        if (this.aCE.containsKey(str)) {
            return this.aCE.get(str);
        }
        return null;
    }
}
