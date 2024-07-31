package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* renamed from: com.bumptech.glide.load.resource.bitmap.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    @NonNull
    /* renamed from: m */
    public static BitmapTransitionOptions m44971m(@NonNull TransitionFactory<Bitmap> transitionFactory) {
        return new BitmapTransitionOptions().m45484f(transitionFactory);
    }

    @NonNull
    /* renamed from: n */
    public static BitmapTransitionOptions m44970n() {
        return new BitmapTransitionOptions().m44976h();
    }

    @NonNull
    /* renamed from: o */
    public static BitmapTransitionOptions m44969o(int i) {
        return new BitmapTransitionOptions().m44975i(i);
    }

    @NonNull
    /* renamed from: p */
    public static BitmapTransitionOptions m44968p(@NonNull DrawableCrossFadeFactory.C3757a c3757a) {
        return new BitmapTransitionOptions().m44974j(c3757a);
    }

    @NonNull
    /* renamed from: q */
    public static BitmapTransitionOptions m44967q(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().m44973k(drawableCrossFadeFactory);
    }

    @NonNull
    /* renamed from: r */
    public static BitmapTransitionOptions m44966r(@NonNull TransitionFactory<Drawable> transitionFactory) {
        return new BitmapTransitionOptions().m44972l(transitionFactory);
    }

    @NonNull
    /* renamed from: h */
    public BitmapTransitionOptions m44976h() {
        return m44974j(new DrawableCrossFadeFactory.C3757a());
    }

    @NonNull
    /* renamed from: i */
    public BitmapTransitionOptions m44975i(int i) {
        return m44974j(new DrawableCrossFadeFactory.C3757a(i));
    }

    @NonNull
    /* renamed from: j */
    public BitmapTransitionOptions m44974j(@NonNull DrawableCrossFadeFactory.C3757a c3757a) {
        return m44972l(c3757a.m44449a());
    }

    @NonNull
    /* renamed from: k */
    public BitmapTransitionOptions m44973k(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return m44972l(drawableCrossFadeFactory);
    }

    @NonNull
    /* renamed from: l */
    public BitmapTransitionOptions m44972l(@NonNull TransitionFactory<Drawable> transitionFactory) {
        return m45484f(new BitmapTransitionFactory(transitionFactory));
    }
}
