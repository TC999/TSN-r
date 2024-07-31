package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3770j;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LruArrayPool implements ArrayPool {

    /* renamed from: h */
    private static final int f13570h = 4194304;
    @VisibleForTesting

    /* renamed from: i */
    static final int f13571i = 8;

    /* renamed from: j */
    private static final int f13572j = 2;

    /* renamed from: b */
    private final GroupedLinkedMap<C3582a, Object> f13573b;

    /* renamed from: c */
    private final C3583b f13574c;

    /* renamed from: d */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f13575d;

    /* renamed from: e */
    private final Map<Class<?>, ArrayAdapterInterface<?>> f13576e;

    /* renamed from: f */
    private final int f13577f;

    /* renamed from: g */
    private int f13578g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3582a implements Poolable {

        /* renamed from: a */
        private final C3583b f13579a;

        /* renamed from: b */
        int f13580b;

        /* renamed from: c */
        private Class<?> f13581c;

        C3582a(C3583b c3583b) {
            this.f13579a = c3583b;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        /* renamed from: a */
        public void mo45342a() {
            this.f13579a.m45413c(this);
        }

        /* renamed from: b */
        void m45379b(int i, Class<?> cls) {
            this.f13580b = i;
            this.f13581c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3582a) {
                C3582a c3582a = (C3582a) obj;
                return this.f13580b == c3582a.f13580b && this.f13581c == c3582a.f13581c;
            }
            return false;
        }

        public int hashCode() {
            int i = this.f13580b * 31;
            Class<?> cls = this.f13581c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f13580b + "array=" + this.f13581c + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.j$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3583b extends BaseKeyPool<C3582a> {
        C3583b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: d */
        public C3582a mo45340a() {
            return new C3582a(this);
        }

        /* renamed from: e */
        C3582a m45377e(int i, Class<?> cls) {
            C3582a m45414b = m45414b();
            m45414b.m45379b(i, cls);
            return m45414b;
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.f13573b = new GroupedLinkedMap<>();
        this.f13574c = new C3583b();
        this.f13575d = new HashMap();
        this.f13576e = new HashMap();
        this.f13577f = 4194304;
    }

    /* renamed from: f */
    private void m45391f(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> m45383n = m45383n(cls);
        Integer num = (Integer) m45383n.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                m45383n.remove(Integer.valueOf(i));
                return;
            } else {
                m45383n.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    /* renamed from: g */
    private void m45390g() {
        m45389h(this.f13577f);
    }

    /* renamed from: h */
    private void m45389h(int i) {
        while (this.f13578g > i) {
            Object m45405f = this.f13573b.m45405f();
            C3770j.m44392d(m45405f);
            ArrayAdapterInterface m45388i = m45388i(m45405f);
            this.f13578g -= m45388i.mo45399b(m45405f) * m45388i.mo45400a();
            m45391f(m45388i.mo45399b(m45405f), m45405f.getClass());
            if (Log.isLoggable(m45388i.getTag(), 2)) {
                Log.v(m45388i.getTag(), "evicted: " + m45388i.mo45399b(m45405f));
            }
        }
    }

    /* renamed from: i */
    private <T> ArrayAdapterInterface<T> m45388i(T t) {
        return m45387j(t.getClass());
    }

    /* renamed from: j */
    private <T> ArrayAdapterInterface<T> m45387j(Class<T> cls) {
        IntegerArrayAdapter integerArrayAdapter = (ArrayAdapterInterface<T>) this.f13576e.get(cls);
        if (integerArrayAdapter == null) {
            if (cls.equals(int[].class)) {
                integerArrayAdapter = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                integerArrayAdapter = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f13576e.put(cls, integerArrayAdapter);
        }
        return integerArrayAdapter;
    }

    @Nullable
    /* renamed from: k */
    private <T> T m45386k(C3582a c3582a) {
        return (T) this.f13573b.m45410a(c3582a);
    }

    /* renamed from: m */
    private <T> T m45384m(C3582a c3582a, Class<T> cls) {
        ArrayAdapterInterface<T> m45387j = m45387j(cls);
        T t = (T) m45386k(c3582a);
        if (t != null) {
            this.f13578g -= m45387j.mo45399b(t) * m45387j.mo45400a();
            m45391f(m45387j.mo45399b(t), cls);
        }
        if (t == null) {
            if (Log.isLoggable(m45387j.getTag(), 2)) {
                Log.v(m45387j.getTag(), "Allocated " + c3582a.f13580b + " bytes");
            }
            return m45387j.newArray(c3582a.f13580b);
        }
        return t;
    }

    /* renamed from: n */
    private NavigableMap<Integer, Integer> m45383n(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f13575d.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f13575d.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    /* renamed from: o */
    private boolean m45382o() {
        int i = this.f13578g;
        return i == 0 || this.f13577f / i >= 2;
    }

    /* renamed from: p */
    private boolean m45381p(int i) {
        return i <= this.f13577f / 2;
    }

    /* renamed from: q */
    private boolean m45380q(int i, Integer num) {
        return num != null && (m45382o() || num.intValue() <= i * 8);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    /* renamed from: a */
    public synchronized void mo45396a(int i) {
        try {
            if (i >= 40) {
                mo45395b();
            } else if (i >= 20 || i == 15) {
                m45389h(this.f13577f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    /* renamed from: b */
    public synchronized void mo45395b() {
        m45389h(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    /* renamed from: c */
    public synchronized <T> T mo45394c(int i, Class<T> cls) {
        C3582a m45377e;
        Integer ceilingKey = m45383n(cls).ceilingKey(Integer.valueOf(i));
        if (m45380q(i, ceilingKey)) {
            m45377e = this.f13574c.m45377e(ceilingKey.intValue(), cls);
        } else {
            m45377e = this.f13574c.m45377e(i, cls);
        }
        return (T) m45384m(m45377e, cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    /* renamed from: d */
    public synchronized <T> T mo45393d(int i, Class<T> cls) {
        return (T) m45384m(this.f13574c.m45377e(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    /* renamed from: e */
    public <T> void mo45392e(T t, Class<T> cls) {
        put(t);
    }

    /* renamed from: l */
    int m45385l() {
        int i = 0;
        for (Class<?> cls : this.f13575d.keySet()) {
            for (Integer num : this.f13575d.get(cls).keySet()) {
                i += num.intValue() * ((Integer) this.f13575d.get(cls).get(num)).intValue() * m45387j(cls).mo45400a();
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        ArrayAdapterInterface<T> m45387j = m45387j(cls);
        int mo45399b = m45387j.mo45399b(t);
        int mo45400a = m45387j.mo45400a() * mo45399b;
        if (m45381p(mo45400a)) {
            C3582a m45377e = this.f13574c.m45377e(mo45399b, cls);
            this.f13573b.m45407d(m45377e, t);
            NavigableMap<Integer, Integer> m45383n = m45383n(cls);
            Integer num = (Integer) m45383n.get(Integer.valueOf(m45377e.f13580b));
            Integer valueOf = Integer.valueOf(m45377e.f13580b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            m45383n.put(valueOf, Integer.valueOf(i));
            this.f13578g += mo45400a;
            m45390g();
        }
    }

    public LruArrayPool(int i) {
        this.f13573b = new GroupedLinkedMap<>();
        this.f13574c = new C3583b();
        this.f13575d = new HashMap();
        this.f13576e = new HashMap();
        this.f13577f = i;
    }
}
