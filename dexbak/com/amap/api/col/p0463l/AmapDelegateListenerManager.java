package com.amap.api.col.p0463l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.amap.api.col.3l.y9 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AmapDelegateListenerManager {

    /* renamed from: a */
    private ConcurrentHashMap<Integer, C2008a> f5790a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AmapDelegateListenerManager.java */
    /* renamed from: com.amap.api.col.3l.y9$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2008a<T> {

        /* renamed from: a */
        public List<T> f5791a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b */
        public T f5792b = null;

        public C2008a() {
        }
    }

    /* renamed from: a */
    public final <T> List<T> m53384a(int i) {
        try {
            C2008a c2008a = this.f5790a.get(Integer.valueOf(i));
            if (c2008a != null) {
                return c2008a.f5791a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public final <T> void m53383b() {
        ConcurrentHashMap<Integer, C2008a> concurrentHashMap = this.f5790a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            for (Map.Entry<Integer, C2008a> entry : concurrentHashMap.entrySet()) {
                C2008a value = entry.getValue();
                value.f5791a.clear();
                value.f5792b = null;
            }
            this.f5790a.clear();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public final <T> void m53382c(int i, T t) {
        ConcurrentHashMap<Integer, C2008a> concurrentHashMap = this.f5790a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            C2008a c2008a = concurrentHashMap.get(Integer.valueOf(i));
            if (c2008a == null) {
                c2008a = new C2008a();
                this.f5790a.putIfAbsent(Integer.valueOf(i), c2008a);
            }
            if (c2008a.f5792b == t) {
                return;
            }
            m53379f(Integer.valueOf(i), c2008a.f5792b);
            c2008a.f5792b = t;
            m53380e(Integer.valueOf(i), t);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public final <T> void m53381d(Integer num) {
        C2008a c2008a;
        List<T> list;
        try {
            if (!this.f5790a.containsKey(num) || (c2008a = this.f5790a.get(num)) == null || (list = c2008a.f5791a) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public final <T> void m53380e(Integer num, T t) {
        ConcurrentHashMap<Integer, C2008a> concurrentHashMap;
        if (t != null && (concurrentHashMap = this.f5790a) != null) {
            try {
                C2008a c2008a = concurrentHashMap.get(num);
                if (c2008a == null) {
                    c2008a = new C2008a();
                    this.f5790a.putIfAbsent(num, c2008a);
                }
                List<T> list = c2008a.f5791a;
                if (list == null || list.contains(t)) {
                    return;
                }
                c2008a.f5791a.add(t);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: f */
    public final <T> void m53379f(Integer num, T t) {
        ConcurrentHashMap<Integer, C2008a> concurrentHashMap;
        C2008a c2008a;
        List<T> list;
        if (t != null && (concurrentHashMap = this.f5790a) != null) {
            try {
                if (!concurrentHashMap.containsKey(num) || (c2008a = this.f5790a.get(num)) == null || (list = c2008a.f5791a) == null || !list.contains(t)) {
                    return;
                }
                c2008a.f5791a.remove(t);
            } catch (Throwable unused) {
            }
        }
    }
}
