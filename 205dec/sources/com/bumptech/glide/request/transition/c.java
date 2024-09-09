package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c implements g<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f18024a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18025b;

    /* renamed from: c  reason: collision with root package name */
    private d f18026c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DrawableCrossFadeFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        private static final int f18027c = 300;

        /* renamed from: a  reason: collision with root package name */
        private final int f18028a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f18029b;

        public a() {
            this(300);
        }

        public c a() {
            return new c(this.f18028a, this.f18029b);
        }

        public a b(boolean z3) {
            this.f18029b = z3;
            return this;
        }

        public a(int i4) {
            this.f18028a = i4;
        }
    }

    protected c(int i4, boolean z3) {
        this.f18024a = i4;
        this.f18025b = z3;
    }

    private f<Drawable> b() {
        if (this.f18026c == null) {
            this.f18026c = new d(this.f18024a, this.f18025b);
        }
        return this.f18026c;
    }

    @Override // com.bumptech.glide.request.transition.g
    public f<Drawable> a(DataSource dataSource, boolean z3) {
        return dataSource == DataSource.MEMORY_CACHE ? e.b() : b();
    }
}
