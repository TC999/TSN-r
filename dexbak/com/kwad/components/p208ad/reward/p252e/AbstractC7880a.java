package com.kwad.components.p208ad.reward.p252e;

/* renamed from: com.kwad.components.ad.reward.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7880a implements InterfaceC7886g {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC7886g interfaceC7886g) {
        return getPriority() - interfaceC7886g.getPriority();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    public int getPriority() {
        return 0;
    }
}
