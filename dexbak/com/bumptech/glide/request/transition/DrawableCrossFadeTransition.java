package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.transition.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawableCrossFadeTransition implements InterfaceC3759f<Drawable> {

    /* renamed from: a */
    private final int f14512a;

    /* renamed from: b */
    private final boolean f14513b;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f14512a = i;
        this.f14513b = z;
    }

    @Override // com.bumptech.glide.request.transition.InterfaceC3759f
    /* renamed from: b */
    public boolean mo44440a(Drawable drawable, InterfaceC3759f.InterfaceC3760a interfaceC3760a) {
        Drawable mo44443c = interfaceC3760a.mo44443c();
        if (mo44443c == null) {
            mo44443c = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{mo44443c, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f14513b);
        transitionDrawable.startTransition(this.f14512a);
        interfaceC3760a.mo44444a(transitionDrawable);
        return true;
    }
}
