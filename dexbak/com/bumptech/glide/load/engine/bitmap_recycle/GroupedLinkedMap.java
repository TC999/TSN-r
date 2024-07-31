package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a */
    private final C3581a<K, V> f13563a = new C3581a<>();

    /* renamed from: b */
    private final Map<K, C3581a<K, V>> f13564b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.h$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3581a<K, V> {

        /* renamed from: a */
        final K f13565a;

        /* renamed from: b */
        private List<V> f13566b;

        /* renamed from: c */
        C3581a<K, V> f13567c;

        /* renamed from: d */
        C3581a<K, V> f13568d;

        C3581a() {
            this(null);
        }

        /* renamed from: a */
        public void m45403a(V v) {
            if (this.f13566b == null) {
                this.f13566b = new ArrayList();
            }
            this.f13566b.add(v);
        }

        @Nullable
        /* renamed from: b */
        public V m45402b() {
            int m45401c = m45401c();
            if (m45401c > 0) {
                return this.f13566b.remove(m45401c - 1);
            }
            return null;
        }

        /* renamed from: c */
        public int m45401c() {
            List<V> list = this.f13566b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        C3581a(K k) {
            this.f13568d = this;
            this.f13567c = this;
            this.f13565a = k;
        }
    }

    /* renamed from: b */
    private void m45409b(C3581a<K, V> c3581a) {
        m45406e(c3581a);
        C3581a<K, V> c3581a2 = this.f13563a;
        c3581a.f13568d = c3581a2;
        c3581a.f13567c = c3581a2.f13567c;
        m45404g(c3581a);
    }

    /* renamed from: c */
    private void m45408c(C3581a<K, V> c3581a) {
        m45406e(c3581a);
        C3581a<K, V> c3581a2 = this.f13563a;
        c3581a.f13568d = c3581a2.f13568d;
        c3581a.f13567c = c3581a2;
        m45404g(c3581a);
    }

    /* renamed from: e */
    private static <K, V> void m45406e(C3581a<K, V> c3581a) {
        C3581a<K, V> c3581a2 = c3581a.f13568d;
        c3581a2.f13567c = c3581a.f13567c;
        c3581a.f13567c.f13568d = c3581a2;
    }

    /* renamed from: g */
    private static <K, V> void m45404g(C3581a<K, V> c3581a) {
        c3581a.f13567c.f13568d = c3581a;
        c3581a.f13568d.f13567c = c3581a;
    }

    @Nullable
    /* renamed from: a */
    public V m45410a(K k) {
        C3581a<K, V> c3581a = this.f13564b.get(k);
        if (c3581a == null) {
            c3581a = new C3581a<>(k);
            this.f13564b.put(k, c3581a);
        } else {
            k.mo45342a();
        }
        m45409b(c3581a);
        return c3581a.m45402b();
    }

    /* renamed from: d */
    public void m45407d(K k, V v) {
        C3581a<K, V> c3581a = this.f13564b.get(k);
        if (c3581a == null) {
            c3581a = new C3581a<>(k);
            m45408c(c3581a);
            this.f13564b.put(k, c3581a);
        } else {
            k.mo45342a();
        }
        c3581a.m45403a(v);
    }

    @Nullable
    /* renamed from: f */
    public V m45405f() {
        for (C3581a c3581a = this.f13563a.f13568d; !c3581a.equals(this.f13563a); c3581a = c3581a.f13568d) {
            V v = (V) c3581a.m45402b();
            if (v != null) {
                return v;
            }
            m45406e(c3581a);
            this.f13564b.remove(c3581a.f13565a);
            ((Poolable) c3581a.f13565a).mo45342a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (C3581a c3581a = this.f13563a.f13567c; !c3581a.equals(this.f13563a); c3581a = c3581a.f13567c) {
            z = true;
            sb.append('{');
            sb.append(c3581a.f13565a);
            sb.append(':');
            sb.append(c3581a.m45401c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
