package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AttributeStrategy.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f16877a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f16878b = new h<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f16879a;

        /* renamed from: b  reason: collision with root package name */
        private int f16880b;

        /* renamed from: c  reason: collision with root package name */
        private int f16881c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f16882d;

        public a(b bVar) {
            this.f16879a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f16879a.c(this);
        }

        public void b(int i4, int i5, Bitmap.Config config) {
            this.f16880b = i4;
            this.f16881c = i5;
            this.f16882d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f16880b == aVar.f16880b && this.f16881c == aVar.f16881c && this.f16882d == aVar.f16882d;
            }
            return false;
        }

        public int hashCode() {
            int i4 = ((this.f16880b * 31) + this.f16881c) * 31;
            Bitmap.Config config = this.f16882d;
            return i4 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.f(this.f16880b, this.f16881c, this.f16882d);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i4, int i5, Bitmap.Config config) {
            a b4 = b();
            b4.b(i4, i5, config);
            return b4;
        }
    }

    static String f(int i4, int i5, Bitmap.Config config) {
        return "[" + i4 + "x" + i5 + "], " + config;
    }

    private static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String a(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String b(int i4, int i5, Bitmap.Config config) {
        return f(i4, i5, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.k.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void d(Bitmap bitmap) {
        this.f16878b.d(this.f16877a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public Bitmap e(int i4, int i5, Bitmap.Config config) {
        return this.f16878b.a(this.f16877a.e(i4, i5, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public Bitmap removeLast() {
        return this.f16878b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f16878b;
    }
}
