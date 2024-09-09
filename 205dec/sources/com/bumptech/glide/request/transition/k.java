package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ViewTransition.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k<R> implements f<R> {

    /* renamed from: a  reason: collision with root package name */
    private final a f18041a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewTransition.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    interface a {
        Animation a(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.f18041a = aVar;
    }

    @Override // com.bumptech.glide.request.transition.f
    public boolean a(R r3, f.a aVar) {
        View view = aVar.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.f18041a.a(view.getContext()));
            return false;
        }
        return false;
    }
}
