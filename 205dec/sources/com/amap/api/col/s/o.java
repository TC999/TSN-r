package com.amap.api.col.s;

import com.amap.api.col.s.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RequestCacheWorker.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10043a = true;

    /* renamed from: b  reason: collision with root package name */
    private long f10044b = 86400;

    /* renamed from: c  reason: collision with root package name */
    private int f10045c = 10;

    /* renamed from: d  reason: collision with root package name */
    private long f10046d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashMap<n.b, Object> f10047e = new LinkedHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final Object f10048f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private final LinkedHashMap<n.b, Object> f10049g = new LinkedHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Object f10050h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f10051i = new ArrayList<>();

    public o(String... strArr) {
        e(strArr);
    }

    private void b() {
        int size = this.f10047e.size();
        if (size <= 0 || size < this.f10045c) {
            return;
        }
        n.b bVar = null;
        Iterator<n.b> it = this.f10047e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n.b next = it.next();
            if (next != null) {
                bVar = next;
                break;
            }
        }
        k(this.f10047e, bVar);
    }

    private void e(String... strArr) {
        this.f10046d = System.currentTimeMillis();
        this.f10047e.clear();
        this.f10051i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.f10051i.add(str);
            }
        }
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.f10046d) / 1000 > this.f10044b) {
            this.f10047e.clear();
            this.f10046d = currentTimeMillis;
        }
    }

    private void i(n.b bVar, Object obj) {
        synchronized (this.f10048f) {
            b();
            h();
            this.f10047e.put(bVar, obj);
        }
    }

    public final n.c a(n.b bVar) {
        if (this.f10043a && bVar != null && j(bVar)) {
            h();
            synchronized (this.f10048f) {
                if (f(this.f10047e, bVar)) {
                    return new n.c(g(this.f10047e, bVar), true);
                }
                synchronized (this.f10050h) {
                    if (f(this.f10049g, bVar)) {
                        while (!f(this.f10047e, bVar) && f(this.f10049g, bVar)) {
                            try {
                                this.f10050h.wait(1000L);
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } else {
                        this.f10049g.put(bVar, null);
                    }
                }
                return new n.c(g(this.f10047e, bVar), false);
            }
        }
        return null;
    }

    public void c(n.a aVar) {
        if (aVar != null) {
            this.f10043a = aVar.e();
            this.f10044b = aVar.f();
            this.f10045c = aVar.g();
        }
    }

    public final void d(n.b bVar, Object obj) {
        if (this.f10043a && bVar != null && j(bVar)) {
            i(bVar, obj);
            synchronized (this.f10050h) {
                k(this.f10049g, bVar);
                this.f10050h.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object g(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    public final boolean j(n.b bVar) {
        if (bVar != null && bVar.f10028a != null) {
            Iterator<String> it = this.f10051i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && bVar.f10028a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object k(LinkedHashMap<n.b, Object> linkedHashMap, n.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }
}
