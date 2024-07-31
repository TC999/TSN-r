package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3771k;
import java.util.NavigableMap;

@RequiresApi(19)
/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class SizeStrategy implements LruPoolStrategy {

    /* renamed from: d */
    private static final int f13608d = 8;

    /* renamed from: a */
    private final C3591b f13609a = new C3591b();

    /* renamed from: b */
    private final GroupedLinkedMap<C3590a, Bitmap> f13610b = new GroupedLinkedMap<>();

    /* renamed from: c */
    private final NavigableMap<Integer, Integer> f13611c = new PrettyPrintTreeMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3590a implements Poolable {

        /* renamed from: a */
        private final C3591b f13612a;

        /* renamed from: b */
        int f13613b;

        C3590a(C3591b c3591b) {
            this.f13612a = c3591b;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        /* renamed from: a */
        public void mo45342a() {
            this.f13612a.m45413c(this);
        }

        /* renamed from: b */
        public void m45341b(int i) {
            this.f13613b = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C3590a) && this.f13613b == ((C3590a) obj).f13613b;
        }

        public int hashCode() {
            return this.f13613b;
        }

        public String toString() {
            return SizeStrategy.m45344g(this.f13613b);
        }
    }

    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.p$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3591b extends BaseKeyPool<C3590a> {
        C3591b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: d */
        public C3590a mo45340a() {
            return new C3590a(this);
        }

        /* renamed from: e */
        public C3590a m45338e(int i) {
            C3590a c3590a = (C3590a) super.m45414b();
            c3590a.m45341b(i);
            return c3590a;
        }
    }

    SizeStrategy() {
    }

    /* renamed from: f */
    private void m45345f(Integer num) {
        Integer num2 = (Integer) this.f13611c.get(num);
        if (num2.intValue() == 1) {
            this.f13611c.remove(num);
        } else {
            this.f13611c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* renamed from: g */
    static String m45344g(int i) {
        return "[" + i + "]";
    }

    /* renamed from: h */
    private static String m45343h(Bitmap bitmap) {
        return m45344g(C3771k.m44383h(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: a */
    public String mo45350a(Bitmap bitmap) {
        return m45343h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: b */
    public String mo45349b(int i, int i2, Bitmap.Config config) {
        return m45344g(C3771k.m44384g(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: c */
    public int mo45348c(Bitmap bitmap) {
        return C3771k.m44383h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: d */
    public void mo45347d(Bitmap bitmap) {
        C3590a m45338e = this.f13609a.m45338e(C3771k.m44383h(bitmap));
        this.f13610b.m45407d(m45338e, bitmap);
        Integer num = (Integer) this.f13611c.get(Integer.valueOf(m45338e.f13613b));
        this.f13611c.put(Integer.valueOf(m45338e.f13613b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    /* renamed from: e */
    public Bitmap mo45346e(int i, int i2, Bitmap.Config config) {
        int m44384g = C3771k.m44384g(i, i2, config);
        C3590a m45338e = this.f13609a.m45338e(m44384g);
        Integer ceilingKey = this.f13611c.ceilingKey(Integer.valueOf(m44384g));
        if (ceilingKey != null && ceilingKey.intValue() != m44384g && ceilingKey.intValue() <= m44384g * 8) {
            this.f13609a.m45413c(m45338e);
            m45338e = this.f13609a.m45338e(ceilingKey.intValue());
        }
        Bitmap m45410a = this.f13610b.m45410a(m45338e);
        if (m45410a != null) {
            m45410a.reconfigure(i, i2, config);
            m45345f(ceilingKey);
        }
        return m45410a;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap removeLast() {
        Bitmap m45405f = this.f13610b.m45405f();
        if (m45405f != null) {
            m45345f(Integer.valueOf(C3771k.m44383h(m45405f)));
        }
        return m45405f;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f13610b + "\n  SortedSizes" + this.f13611c;
    }
}
