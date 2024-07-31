package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

/* renamed from: com.bumptech.glide.load.resource.drawable.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    @NonNull
    /* renamed from: l */
    public static DrawableTransitionOptions m44873l(@NonNull TransitionFactory<Drawable> transitionFactory) {
        return new DrawableTransitionOptions().m45484f(transitionFactory);
    }

    @NonNull
    /* renamed from: m */
    public static DrawableTransitionOptions m44872m() {
        return new DrawableTransitionOptions().m44877h();
    }

    @NonNull
    /* renamed from: n */
    public static DrawableTransitionOptions m44871n(int i) {
        return new DrawableTransitionOptions().m44876i(i);
    }

    @NonNull
    /* renamed from: o */
    public static DrawableTransitionOptions m44870o(@NonNull DrawableCrossFadeFactory.C3757a c3757a) {
        return new DrawableTransitionOptions().m44875j(c3757a);
    }

    @NonNull
    /* renamed from: p */
    public static DrawableTransitionOptions m44869p(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new DrawableTransitionOptions().m44874k(drawableCrossFadeFactory);
    }

    @NonNull
    /* renamed from: h */
    public DrawableTransitionOptions m44877h() {
        return m44875j(new DrawableCrossFadeFactory.C3757a());
    }

    @NonNull
    /* renamed from: i */
    public DrawableTransitionOptions m44876i(int i) {
        return m44875j(new DrawableCrossFadeFactory.C3757a(i));
    }

    @NonNull
    /* renamed from: j */
    public DrawableTransitionOptions m44875j(@NonNull DrawableCrossFadeFactory.C3757a c3757a) {
        return m44874k(c3757a.m44449a());
    }

    @NonNull
    /* renamed from: k */
    public DrawableTransitionOptions m44874k(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return m45484f(drawableCrossFadeFactory);
    }
}
