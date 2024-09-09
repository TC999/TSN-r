package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NoTransition.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e<R> implements f<R> {

    /* renamed from: a  reason: collision with root package name */
    static final e<?> f18032a = new e<>();

    /* renamed from: b  reason: collision with root package name */
    private static final g<?> f18033b = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: NoTransition.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a<R> implements g<R> {
        @Override // com.bumptech.glide.request.transition.g
        public f<R> a(DataSource dataSource, boolean z3) {
            return e.f18032a;
        }
    }

    public static <R> f<R> b() {
        return f18032a;
    }

    public static <R> g<R> c() {
        return (g<R>) f18033b;
    }

    @Override // com.bumptech.glide.request.transition.f
    public boolean a(Object obj, f.a aVar) {
        return false;
    }
}
