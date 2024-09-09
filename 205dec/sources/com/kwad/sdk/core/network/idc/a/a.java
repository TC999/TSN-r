package com.kwad.sdk.core.network.idc.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private final long awK;
    private volatile boolean awL = false;

    public a(long j4, boolean z3) {
        this.awK = j4;
    }

    public final boolean DY() {
        return this.awL;
    }

    public final long DZ() {
        return this.awK;
    }

    public final a bm(boolean z3) {
        this.awL = true;
        return this;
    }
}
