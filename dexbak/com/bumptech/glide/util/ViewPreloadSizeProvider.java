package com.bumptech.glide.util;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.InterfaceC3759f;
import java.util.Arrays;

/* renamed from: com.bumptech.glide.util.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.InterfaceC3551b<T>, SizeReadyCallback {

    /* renamed from: a */
    private int[] f14567a;

    /* renamed from: b */
    private C3773a f14568b;

    /* compiled from: ViewPreloadSizeProvider.java */
    /* renamed from: com.bumptech.glide.util.l$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3773a extends ViewTarget<View, Object> {
        C3773a(@NonNull View view, @NonNull SizeReadyCallback sizeReadyCallback) {
            super(view);
            mo44466q(sizeReadyCallback);
        }

        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: k */
        public void mo44364k(@NonNull Object obj, @Nullable InterfaceC3759f<? super Object> interfaceC3759f) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Override // com.bumptech.glide.ListPreloader.InterfaceC3551b
    @Nullable
    /* renamed from: a */
    public int[] mo44367a(@NonNull T t, int i, int i2) {
        int[] iArr = this.f14567a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    /* renamed from: b */
    public void m44366b(@NonNull View view) {
        if (this.f14567a == null && this.f14568b == null) {
            this.f14568b = new C3773a(view, this);
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    /* renamed from: e */
    public void mo44365e(int i, int i2) {
        this.f14567a = new int[]{i, i2};
        this.f14568b = null;
    }

    public ViewPreloadSizeProvider(@NonNull View view) {
        this.f14568b = new C3773a(view, this);
    }
}
