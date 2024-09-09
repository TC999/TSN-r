package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CustomTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class e<T> implements p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17964a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17965b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.request.d f17966c;

    public e() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.p
    public final void b(@NonNull o oVar) {
    }

    @Override // com.bumptech.glide.request.target.p
    public void h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public final com.bumptech.glide.request.d i() {
        return this.f17966c;
    }

    @Override // com.bumptech.glide.request.target.p
    public final void m(@Nullable com.bumptech.glide.request.d dVar) {
        this.f17966c = dVar;
    }

    @Override // com.bumptech.glide.request.target.p
    public void n(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.p
    public final void q(@NonNull o oVar) {
        oVar.e(this.f17964a, this.f17965b);
    }

    public e(int i4, int i5) {
        if (com.bumptech.glide.util.k.v(i4, i5)) {
            this.f17964a = i4;
            this.f17965b = i5;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i4 + " and height: " + i5);
    }
}
