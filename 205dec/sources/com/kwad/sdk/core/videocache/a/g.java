package com.kwad.sdk.core.videocache.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j4) {
        if (j4 > 0) {
            this.maxSize = j4;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    protected final boolean au(long j4) {
        return j4 <= this.maxSize;
    }
}
