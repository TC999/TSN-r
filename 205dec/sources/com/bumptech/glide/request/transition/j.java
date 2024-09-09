package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ViewPropertyTransition.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class j<R> implements f<R> {

    /* renamed from: a  reason: collision with root package name */
    private final a f18040a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewPropertyTransition.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.f18040a = aVar;
    }

    @Override // com.bumptech.glide.request.transition.f
    public boolean a(R r3, f.a aVar) {
        if (aVar.getView() != null) {
            this.f18040a.a(aVar.getView());
            return false;
        }
        return false;
    }
}
