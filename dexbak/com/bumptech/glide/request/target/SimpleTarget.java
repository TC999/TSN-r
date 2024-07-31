package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.C3771k;

@Deprecated
/* renamed from: com.bumptech.glide.request.target.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {

    /* renamed from: b */
    private final int f14484b;

    /* renamed from: c */
    private final int f14485c;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: b */
    public void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: q */
    public final void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (C3771k.m44369v(this.f14484b, this.f14485c)) {
            sizeReadyCallback.mo44365e(this.f14484b, this.f14485c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f14484b + " and height: " + this.f14485c + ", either provide dimensions in the constructor or call override()");
    }

    public SimpleTarget(int i, int i2) {
        this.f14484b = i;
        this.f14485c = i2;
    }
}
