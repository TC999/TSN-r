package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Transition.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface f<R> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Transition.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(Drawable drawable);

        @Nullable
        Drawable c();

        View getView();
    }

    boolean a(R r3, a aVar);
}
