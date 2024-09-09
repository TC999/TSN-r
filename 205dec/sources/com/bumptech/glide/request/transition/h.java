package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.k;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ViewAnimationFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class h<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final k.a f18034a;

    /* renamed from: b  reason: collision with root package name */
    private f<R> f18035b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewAnimationFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final Animation f18036a;

        a(Animation animation) {
            this.f18036a = animation;
        }

        @Override // com.bumptech.glide.request.transition.k.a
        public Animation a(Context context) {
            return this.f18036a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ViewAnimationFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f18037a;

        b(int i4) {
            this.f18037a = i4;
        }

        @Override // com.bumptech.glide.request.transition.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f18037a);
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    @Override // com.bumptech.glide.request.transition.g
    public f<R> a(DataSource dataSource, boolean z3) {
        if (dataSource != DataSource.MEMORY_CACHE && z3) {
            if (this.f18035b == null) {
                this.f18035b = new k(this.f18034a);
            }
            return this.f18035b;
        }
        return e.b();
    }

    public h(int i4) {
        this(new b(i4));
    }

    h(k.a aVar) {
        this.f18034a = aVar;
    }
}
