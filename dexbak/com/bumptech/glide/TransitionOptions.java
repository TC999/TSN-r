package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    private TransitionFactory<? super TranscodeType> f13466a = NoTransition.m44445c();

    /* renamed from: d */
    private CHILD m45486d() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    /* renamed from: b */
    public final CHILD m45488b() {
        return m45484f(NoTransition.m44445c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final TransitionFactory<? super TranscodeType> m45487c() {
        return this.f13466a;
    }

    @NonNull
    /* renamed from: e */
    public final CHILD m45485e(int i) {
        return m45484f(new ViewAnimationFactory(i));
    }

    @NonNull
    /* renamed from: f */
    public final CHILD m45484f(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        this.f13466a = (TransitionFactory) C3770j.m44392d(transitionFactory);
        return m45486d();
    }

    @NonNull
    /* renamed from: g */
    public final CHILD m45483g(@NonNull ViewPropertyTransition.InterfaceC3763a interfaceC3763a) {
        return m45484f(new ViewPropertyAnimationFactory(interfaceC3763a));
    }
}
