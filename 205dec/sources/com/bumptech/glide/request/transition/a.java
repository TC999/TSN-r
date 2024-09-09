package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapContainerTransitionFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class a<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final g<Drawable> f18021a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BitmapContainerTransitionFactory.java */
    /* renamed from: com.bumptech.glide.request.transition.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private final class C0184a implements f<R> {

        /* renamed from: a  reason: collision with root package name */
        private final f<Drawable> f18022a;

        C0184a(f<Drawable> fVar) {
            this.f18022a = fVar;
        }

        @Override // com.bumptech.glide.request.transition.f
        public boolean a(R r3, f.a aVar) {
            return this.f18022a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.b(r3)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f18021a = gVar;
    }

    @Override // com.bumptech.glide.request.transition.g
    public f<R> a(DataSource dataSource, boolean z3) {
        return new C0184a(this.f18021a.a(dataSource, z3));
    }

    protected abstract Bitmap b(R r3);
}
