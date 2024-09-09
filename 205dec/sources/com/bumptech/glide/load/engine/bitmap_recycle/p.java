package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.NavigableMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SizeStrategy.java */
@RequiresApi(19)
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class p implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final int f16931d = 8;

    /* renamed from: a  reason: collision with root package name */
    private final b f16932a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f16933b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f16934c = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SizeStrategy.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f16935a;

        /* renamed from: b  reason: collision with root package name */
        int f16936b;

        a(b bVar) {
            this.f16935a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f16935a.c(this);
        }

        public void b(int i4) {
            this.f16936b = i4;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f16936b == ((a) obj).f16936b;
        }

        public int hashCode() {
            return this.f16936b;
        }

        public String toString() {
            return p.g(this.f16936b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SizeStrategy.java */
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

        public a e(int i4) {
            a aVar = (a) super.b();
            aVar.b(i4);
            return aVar;
        }
    }

    p() {
    }

    private void f(Integer num) {
        Integer num2 = (Integer) this.f16934c.get(num);
        if (num2.intValue() == 1) {
            this.f16934c.remove(num);
        } else {
            this.f16934c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String g(int i4) {
        return "[" + i4 + "]";
    }

    private static String h(Bitmap bitmap) {
        return g(com.bumptech.glide.util.k.h(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String a(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String b(int i4, int i5, Bitmap.Config config) {
        return g(com.bumptech.glide.util.k.g(i4, i5, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.k.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void d(Bitmap bitmap) {
        a e4 = this.f16932a.e(com.bumptech.glide.util.k.h(bitmap));
        this.f16933b.d(e4, bitmap);
        Integer num = (Integer) this.f16934c.get(Integer.valueOf(e4.f16936b));
        this.f16934c.put(Integer.valueOf(e4.f16936b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap e(int i4, int i5, Bitmap.Config config) {
        int g4 = com.bumptech.glide.util.k.g(i4, i5, config);
        a e4 = this.f16932a.e(g4);
        Integer ceilingKey = this.f16934c.ceilingKey(Integer.valueOf(g4));
        if (ceilingKey != null && ceilingKey.intValue() != g4 && ceilingKey.intValue() <= g4 * 8) {
            this.f16932a.c(e4);
            e4 = this.f16932a.e(ceilingKey.intValue());
        }
        Bitmap a4 = this.f16933b.a(e4);
        if (a4 != null) {
            a4.reconfigure(i4, i5, config);
            f(ceilingKey);
        }
        return a4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap f4 = this.f16933b.f();
        if (f4 != null) {
            f(Integer.valueOf(com.bumptech.glide.util.k.h(f4)));
        }
        return f4;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f16933b + "\n  SortedSizes" + this.f16934c;
    }
}
