package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.k;
import com.bumptech.glide.request.transition.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: TransitionOptions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private com.bumptech.glide.request.transition.g<? super TranscodeType> f16789a = com.bumptech.glide.request.transition.e.c();

    private CHILD d() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e4) {
            throw new RuntimeException(e4);
        }
    }

    @NonNull
    public final CHILD b() {
        return f(com.bumptech.glide.request.transition.e.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.bumptech.glide.request.transition.g<? super TranscodeType> c() {
        return this.f16789a;
    }

    @NonNull
    public final CHILD e(int i4) {
        return f(new com.bumptech.glide.request.transition.h(i4));
    }

    @NonNull
    public final CHILD f(@NonNull com.bumptech.glide.request.transition.g<? super TranscodeType> gVar) {
        this.f16789a = (com.bumptech.glide.request.transition.g) com.bumptech.glide.util.j.d(gVar);
        return d();
    }

    @NonNull
    public final CHILD g(@NonNull j.a aVar) {
        return f(new com.bumptech.glide.request.transition.i(aVar));
    }
}
