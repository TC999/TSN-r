package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LruArrayPool.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class j implements com.bumptech.glide.load.engine.bitmap_recycle.b {

    /* renamed from: h  reason: collision with root package name */
    private static final int f16893h = 4194304;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final int f16894i = 8;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16895j = 2;

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Object> f16896b;

    /* renamed from: c  reason: collision with root package name */
    private final b f16897c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f16898d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.bitmap_recycle.a<?>> f16899e;

    /* renamed from: f  reason: collision with root package name */
    private final int f16900f;

    /* renamed from: g  reason: collision with root package name */
    private int f16901g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LruArrayPool.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f16902a;

        /* renamed from: b  reason: collision with root package name */
        int f16903b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f16904c;

        a(b bVar) {
            this.f16902a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f16902a.c(this);
        }

        void b(int i4, Class<?> cls) {
            this.f16903b = i4;
            this.f16904c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f16903b == aVar.f16903b && this.f16904c == aVar.f16904c;
            }
            return false;
        }

        public int hashCode() {
            int i4 = this.f16903b * 31;
            Class<?> cls = this.f16904c;
            return i4 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f16903b + "array=" + this.f16904c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LruArrayPool.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i4, Class<?> cls) {
            a b4 = b();
            b4.b(i4, cls);
            return b4;
        }
    }

    @VisibleForTesting
    public j() {
        this.f16896b = new h<>();
        this.f16897c = new b();
        this.f16898d = new HashMap();
        this.f16899e = new HashMap();
        this.f16900f = 4194304;
    }

    private void f(int i4, Class<?> cls) {
        NavigableMap<Integer, Integer> n4 = n(cls);
        Integer num = (Integer) n4.get(Integer.valueOf(i4));
        if (num != null) {
            if (num.intValue() == 1) {
                n4.remove(Integer.valueOf(i4));
                return;
            } else {
                n4.put(Integer.valueOf(i4), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i4 + ", this: " + this);
    }

    private void g() {
        h(this.f16900f);
    }

    private void h(int i4) {
        while (this.f16901g > i4) {
            Object f4 = this.f16896b.f();
            com.bumptech.glide.util.j.d(f4);
            com.bumptech.glide.load.engine.bitmap_recycle.a i5 = i(f4);
            this.f16901g -= i5.b(f4) * i5.a();
            f(i5.b(f4), f4.getClass());
            if (Log.isLoggable(i5.getTag(), 2)) {
                Log.v(i5.getTag(), "evicted: " + i5.b(f4));
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> i(T t3) {
        return j(t3.getClass());
    }

    private <T> com.bumptech.glide.load.engine.bitmap_recycle.a<T> j(Class<T> cls) {
        i iVar = (com.bumptech.glide.load.engine.bitmap_recycle.a<T>) this.f16899e.get(cls);
        if (iVar == null) {
            if (cls.equals(int[].class)) {
                iVar = new i();
            } else if (cls.equals(byte[].class)) {
                iVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f16899e.put(cls, iVar);
        }
        return iVar;
    }

    @Nullable
    private <T> T k(a aVar) {
        return (T) this.f16896b.a(aVar);
    }

    private <T> T m(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> j4 = j(cls);
        T t3 = (T) k(aVar);
        if (t3 != null) {
            this.f16901g -= j4.b(t3) * j4.a();
            f(j4.b(t3), cls);
        }
        if (t3 == null) {
            if (Log.isLoggable(j4.getTag(), 2)) {
                Log.v(j4.getTag(), "Allocated " + aVar.f16903b + " bytes");
            }
            return j4.newArray(aVar.f16903b);
        }
        return t3;
    }

    private NavigableMap<Integer, Integer> n(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f16898d.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f16898d.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean o() {
        int i4 = this.f16901g;
        return i4 == 0 || this.f16900f / i4 >= 2;
    }

    private boolean p(int i4) {
        return i4 <= this.f16900f / 2;
    }

    private boolean q(int i4, Integer num) {
        return num != null && (o() || num.intValue() <= i4 * 8);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized void a(int i4) {
        try {
            if (i4 >= 40) {
                b();
            } else if (i4 >= 20 || i4 == 15) {
                h(this.f16900f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T c(int i4, Class<T> cls) {
        a e4;
        Integer ceilingKey = n(cls).ceilingKey(Integer.valueOf(i4));
        if (q(i4, ceilingKey)) {
            e4 = this.f16897c.e(ceilingKey.intValue(), cls);
        } else {
            e4 = this.f16897c.e(i4, cls);
        }
        return (T) m(e4, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> T d(int i4, Class<T> cls) {
        return (T) m(this.f16897c.e(i4, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    @Deprecated
    public <T> void e(T t3, Class<T> cls) {
        put(t3);
    }

    int l() {
        int i4 = 0;
        for (Class<?> cls : this.f16898d.keySet()) {
            for (Integer num : this.f16898d.get(cls).keySet()) {
                i4 += num.intValue() * ((Integer) this.f16898d.get(cls).get(num)).intValue() * j(cls).a();
            }
        }
        return i4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
    public synchronized <T> void put(T t3) {
        Class<?> cls = t3.getClass();
        com.bumptech.glide.load.engine.bitmap_recycle.a<T> j4 = j(cls);
        int b4 = j4.b(t3);
        int a4 = j4.a() * b4;
        if (p(a4)) {
            a e4 = this.f16897c.e(b4, cls);
            this.f16896b.d(e4, t3);
            NavigableMap<Integer, Integer> n4 = n(cls);
            Integer num = (Integer) n4.get(Integer.valueOf(e4.f16903b));
            Integer valueOf = Integer.valueOf(e4.f16903b);
            int i4 = 1;
            if (num != null) {
                i4 = 1 + num.intValue();
            }
            n4.put(valueOf, Integer.valueOf(i4));
            this.f16901g += a4;
            g();
        }
    }

    public j(int i4) {
        this.f16896b = new h<>();
        this.f16897c = new b();
        this.f16898d = new HashMap();
        this.f16899e = new HashMap();
        this.f16900f = i4;
    }
}
