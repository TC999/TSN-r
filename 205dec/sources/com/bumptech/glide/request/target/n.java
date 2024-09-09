package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SimpleTarget.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class n<Z> extends b<Z> {

    /* renamed from: b  reason: collision with root package name */
    private final int f18002b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18003c;

    public n() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.p
    public void b(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.request.target.p
    public final void q(@NonNull o oVar) {
        if (com.bumptech.glide.util.k.v(this.f18002b, this.f18003c)) {
            oVar.e(this.f18002b, this.f18003c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f18002b + " and height: " + this.f18003c + ", either provide dimensions in the constructor or call override()");
    }

    public n(int i4, int i5) {
        this.f18002b = i4;
        this.f18003c = i5;
    }
}
