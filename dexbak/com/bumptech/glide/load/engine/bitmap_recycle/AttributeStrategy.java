package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3771k;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class AttributeStrategy implements LruPoolStrategy {

    /* renamed from: a */
    private final C3580b f13554a = new C3580b();

    /* renamed from: b */
    private final GroupedLinkedMap<C3579a, Bitmap> f13555b = new GroupedLinkedMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3579a implements Poolable {

        /* renamed from: a */
        private final C3580b f13556a;

        /* renamed from: b */
        private int f13557b;

        /* renamed from: c */
        private int f13558c;

        /* renamed from: d */
        private Bitmap.Config f13559d;

        public C3579a(C3580b c3580b) {
            this.f13556a = c3580b;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        /* renamed from: a */
        public void mo45342a() {
            this.f13556a.m45413c(this);
        }

        /* renamed from: b */
        public void m45417b(int i, int i2, Bitmap.Config config) {
            this.f13557b = i;
            this.f13558c = i2;
            this.f13559d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3579a) {
                C3579a c3579a = (C3579a) obj;
                return this.f13557b == c3579a.f13557b && this.f13558c == c3579a.f13558c && this.f13559d == c3579a.f13559d;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f13557b * 31) + this.f13558c) * 31;
            Bitmap.Config config = this.f13559d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.m45419f(this.f13557b, this.f13558c, this.f13559d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3580b extends BaseKeyPool<C3579a> {
        C3580b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: d */
        public C3579a mo45340a() {
            return new C3579a(this);
        }

        /* renamed from: e */
        C3579a m45415e(int i, int i2, Bitmap.Config config) {
            C3579a m45414b = m45414b();
            m45414b.m45417b(i, i2, config);
            return m45414b;
        }
    }

    /* renamed from: f */
    static String m45419f(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    /* renamed from: g */
    private static String m45418g(Bitmap bitmap) {
        return m45419f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: a */
    public String mo45350a(Bitmap bitmap) {
        return m45418g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: b */
    public String mo45349b(int i, int i2, Bitmap.Config config) {
        return m45419f(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: c */
    public int mo45348c(Bitmap bitmap) {
        return C3771k.m44383h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: d */
    public void mo45347d(Bitmap bitmap) {
        this.f13555b.m45407d(this.f13554a.m45415e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: e */
    public Bitmap mo45346e(int i, int i2, Bitmap.Config config) {
        return this.f13555b.m45410a(this.f13554a.m45415e(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.f13555b.m45405f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f13555b;
    }
}
