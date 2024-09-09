package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ViewPropertyAnimationFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f18038a;

    /* renamed from: b  reason: collision with root package name */
    private j<R> f18039b;

    public i(j.a aVar) {
        this.f18038a = aVar;
    }

    @Override // com.bumptech.glide.request.transition.g
    public f<R> a(DataSource dataSource, boolean z3) {
        if (dataSource != DataSource.MEMORY_CACHE && z3) {
            if (this.f18039b == null) {
                this.f18039b = new j<>(this.f18038a);
            }
            return this.f18039b;
        }
        return e.b();
    }
}
