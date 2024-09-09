package com.qq.e.comm.plugin.b0;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private File f42077a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f42078b;

    /* renamed from: c  reason: collision with root package name */
    private Movie f42079c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f42080d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f42081e;

    /* renamed from: f  reason: collision with root package name */
    private int f42082f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f42083g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f42084h;

    public File d() {
        return this.f42077a;
    }

    public Movie e() {
        return this.f42079c;
    }

    public int f() {
        return this.f42082f;
    }

    public boolean g() {
        return this.f42084h;
    }

    public boolean h() {
        return this.f42083g;
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        private f f42085a = new f();

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a(com.qq.e.lib.a.b.a aVar) {
            this.f42085a.f42080d = aVar;
            this.f42085a.f42082f = 3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b b(boolean z3) {
            this.f42085a.f42081e = z3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(boolean z3) {
            this.f42085a.f42083g = z3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a(Movie movie) {
            this.f42085a.f42079c = movie;
            this.f42085a.f42082f = 2;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a(Bitmap bitmap) {
            this.f42085a.f42078b = bitmap;
            this.f42085a.f42082f = 1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a(File file) {
            this.f42085a.f42077a = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b a(boolean z3) {
            this.f42085a.f42084h = z3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f a() {
            return this.f42085a;
        }
    }

    private f() {
        this.f42082f = 0;
    }

    public Bitmap b() {
        return this.f42078b;
    }

    public Drawable c() {
        return this.f42080d;
    }

    public boolean a() {
        return this.f42081e;
    }
}
