package com.kwad.components.ad.reward.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements g {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public int getPriority() {
        return 0;
    }
}
