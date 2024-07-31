package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.transition.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewPropertyTransition<R> implements InterfaceC3759f<R> {

    /* renamed from: a */
    private final InterfaceC3763a f14522a;

    /* compiled from: ViewPropertyTransition.java */
    /* renamed from: com.bumptech.glide.request.transition.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3763a {
        /* renamed from: a */
        void m44441a(View view);
    }

    public ViewPropertyTransition(InterfaceC3763a interfaceC3763a) {
        this.f14522a = interfaceC3763a;
    }

    @Override // com.bumptech.glide.request.transition.InterfaceC3759f
    /* renamed from: a */
    public boolean mo44440a(R r, InterfaceC3759f.InterfaceC3760a interfaceC3760a) {
        if (interfaceC3760a.getView() != null) {
            this.f14522a.m44441a(interfaceC3760a.getView());
            return false;
        }
        return false;
    }
}
