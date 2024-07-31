package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.request.transition.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapTransitionFactory extends BitmapContainerTransitionFactory<Bitmap> {
    public BitmapTransitionFactory(@NonNull TransitionFactory<Drawable> transitionFactory) {
        super(transitionFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    @NonNull
    /* renamed from: c */
    public Bitmap mo44452b(@NonNull Bitmap bitmap) {
        return bitmap;
    }
}
