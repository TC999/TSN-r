package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* renamed from: com.bumptech.glide.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    @NonNull
    /* renamed from: h */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> m45757h(int i) {
        return new GenericTransitionOptions().m45485e(i);
    }

    @NonNull
    /* renamed from: i */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> m45756i(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        return new GenericTransitionOptions().m45484f(transitionFactory);
    }

    @NonNull
    /* renamed from: j */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> m45755j(@NonNull ViewPropertyTransition.InterfaceC3763a interfaceC3763a) {
        return new GenericTransitionOptions().m45483g(interfaceC3763a);
    }

    @NonNull
    /* renamed from: k */
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> m45754k() {
        return new GenericTransitionOptions().m45488b();
    }
}
