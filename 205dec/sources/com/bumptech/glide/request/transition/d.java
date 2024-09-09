package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableCrossFadeTransition.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d implements f<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f18030a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18031b;

    public d(int i4, boolean z3) {
        this.f18030a = i4;
        this.f18031b = z3;
    }

    @Override // com.bumptech.glide.request.transition.f
    /* renamed from: b */
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable c4 = aVar.c();
        if (c4 == null) {
            c4 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{c4, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f18031b);
        transitionDrawable.startTransition(this.f18030a);
        aVar.a(transitionDrawable);
        return true;
    }
}
