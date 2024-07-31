package com.kwad.sdk.core.network.idc.p407a;

/* renamed from: com.kwad.sdk.core.network.idc.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10431a {
    private final long awK;
    private volatile boolean awL = false;

    public C10431a(long j, boolean z) {
        this.awK = j;
    }

    /* renamed from: DY */
    public final boolean m26081DY() {
        return this.awL;
    }

    /* renamed from: DZ */
    public final long m26080DZ() {
        return this.awK;
    }

    /* renamed from: bm */
    public final C10431a m26079bm(boolean z) {
        this.awL = true;
        return this;
    }
}
