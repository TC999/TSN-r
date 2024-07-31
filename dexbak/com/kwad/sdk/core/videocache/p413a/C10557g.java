package com.kwad.sdk.core.videocache.p413a;

/* renamed from: com.kwad.sdk.core.videocache.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10557g extends AbstractC10554e {
    private final long maxSize;

    public C10557g(long j) {
        if (j > 0) {
            this.maxSize = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.kwad.sdk.core.videocache.p413a.AbstractC10554e
    /* renamed from: au */
    protected final boolean mo25472au(long j) {
        return j <= this.maxSize;
    }
}
