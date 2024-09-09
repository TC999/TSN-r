package com.bumptech.glide.util;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.g;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.request.target.r;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ViewPreloadSizeProvider.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class l<T> implements g.b<T>, o {

    /* renamed from: a  reason: collision with root package name */
    private int[] f18085a;

    /* renamed from: b  reason: collision with root package name */
    private a f18086b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewPreloadSizeProvider.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class a extends r<View, Object> {
        a(@NonNull View view, @NonNull o oVar) {
            super(view);
            q(oVar);
        }

        @Override // com.bumptech.glide.request.target.p
        public void k(@NonNull Object obj, @Nullable com.bumptech.glide.request.transition.f<? super Object> fVar) {
        }
    }

    public l() {
    }

    @Override // com.bumptech.glide.g.b
    @Nullable
    public int[] a(@NonNull T t3, int i4, int i5) {
        int[] iArr = this.f18085a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void b(@NonNull View view) {
        if (this.f18085a == null && this.f18086b == null) {
            this.f18086b = new a(view, this);
        }
    }

    @Override // com.bumptech.glide.request.target.o
    public void e(int i4, int i5) {
        this.f18085a = new int[]{i4, i5};
        this.f18086b = null;
    }

    public l(@NonNull View view) {
        this.f18086b = new a(view, this);
    }
}
