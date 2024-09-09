package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GroupedLinkedMap.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f16886a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f16887b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f16888a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f16889b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f16890c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f16891d;

        a() {
            this(null);
        }

        public void a(V v3) {
            if (this.f16889b == null) {
                this.f16889b = new ArrayList();
            }
            this.f16889b.add(v3);
        }

        @Nullable
        public V b() {
            int c4 = c();
            if (c4 > 0) {
                return this.f16889b.remove(c4 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f16889b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k4) {
            this.f16891d = this;
            this.f16890c = this;
            this.f16888a = k4;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f16886a;
        aVar.f16891d = aVar2;
        aVar.f16890c = aVar2.f16890c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f16886a;
        aVar.f16891d = aVar2.f16891d;
        aVar.f16890c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f16891d;
        aVar2.f16890c = aVar.f16890c;
        aVar.f16890c.f16891d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f16890c.f16891d = aVar;
        aVar.f16891d.f16890c = aVar;
    }

    @Nullable
    public V a(K k4) {
        a<K, V> aVar = this.f16887b.get(k4);
        if (aVar == null) {
            aVar = new a<>(k4);
            this.f16887b.put(k4, aVar);
        } else {
            k4.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k4, V v3) {
        a<K, V> aVar = this.f16887b.get(k4);
        if (aVar == null) {
            aVar = new a<>(k4);
            c(aVar);
            this.f16887b.put(k4, aVar);
        } else {
            k4.a();
        }
        aVar.a(v3);
    }

    @Nullable
    public V f() {
        for (a aVar = this.f16886a.f16891d; !aVar.equals(this.f16886a); aVar = aVar.f16891d) {
            V v3 = (V) aVar.b();
            if (v3 != null) {
                return v3;
            }
            e(aVar);
            this.f16887b.remove(aVar.f16888a);
            ((m) aVar.f16888a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z3 = false;
        for (a aVar = this.f16886a.f16890c; !aVar.equals(this.f16886a); aVar = aVar.f16890c) {
            z3 = true;
            sb.append('{');
            sb.append(aVar.f16888a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
        }
        if (z3) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
