package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.transition.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewTransition<R> implements InterfaceC3759f<R> {

    /* renamed from: a */
    private final InterfaceC3764a f14523a;

    /* compiled from: ViewTransition.java */
    /* renamed from: com.bumptech.glide.request.transition.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    interface InterfaceC3764a {
        /* renamed from: a */
        Animation mo44439a(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTransition(InterfaceC3764a interfaceC3764a) {
        this.f14523a = interfaceC3764a;
    }

    @Override // com.bumptech.glide.request.transition.InterfaceC3759f
    /* renamed from: a */
    public boolean mo44440a(R r, InterfaceC3759f.InterfaceC3760a interfaceC3760a) {
        View view = interfaceC3760a.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.f14523a.mo44439a(view.getContext()));
            return false;
        }
        return false;
    }
}
