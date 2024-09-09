package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseTarget.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class b<Z> implements p<Z> {

    /* renamed from: a  reason: collision with root package name */
    private com.bumptech.glide.request.d f17963a;

    @Override // com.bumptech.glide.request.target.p
    public void h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    @Nullable
    public com.bumptech.glide.request.d i() {
        return this.f17963a;
    }

    @Override // com.bumptech.glide.request.target.p
    public void j(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.p
    public void m(@Nullable com.bumptech.glide.request.d dVar) {
        this.f17963a = dVar;
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
}
