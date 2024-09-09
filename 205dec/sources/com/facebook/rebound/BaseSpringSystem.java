package com.facebook.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BaseSpringSystem {

    /* renamed from: c  reason: collision with root package name */
    private final SpringLooper f37022c;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Spring> f37020a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Spring> f37021b = new CopyOnWriteArraySet();

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<SpringSystemListener> f37023d = new CopyOnWriteArraySet<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f37024e = true;

    public BaseSpringSystem(SpringLooper springLooper) {
        if (springLooper != null) {
            this.f37022c = springLooper;
            springLooper.a(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        Spring spring = this.f37020a.get(str);
        if (spring != null) {
            this.f37021b.add(spring);
            if (g()) {
                this.f37024e = false;
                this.f37022c.b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }

    public void b(SpringSystemListener springSystemListener) {
        if (springSystemListener != null) {
            this.f37023d.add(springSystemListener);
            return;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    void c(double d4) {
        for (Spring spring : this.f37021b) {
            if (spring.D()) {
                spring.b(d4 / 1000.0d);
            } else {
                this.f37021b.remove(spring);
            }
        }
    }

    public Spring d() {
        Spring spring = new Spring(this);
        j(spring);
        return spring;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Spring spring) {
        if (spring != null) {
            this.f37021b.remove(spring);
            this.f37020a.remove(spring.i());
            return;
        }
        throw new IllegalArgumentException("spring is required");
    }

    public List<Spring> f() {
        List arrayList;
        Collection<Spring> values = this.f37020a.values();
        if (values instanceof List) {
            arrayList = (List) values;
        } else {
            arrayList = new ArrayList(values);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean g() {
        return this.f37024e;
    }

    public Spring h(String str) {
        if (str != null) {
            return this.f37020a.get(str);
        }
        throw new IllegalArgumentException("id is required");
    }

    public void i(double d4) {
        Iterator<SpringSystemListener> it = this.f37023d.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        c(d4);
        if (this.f37021b.isEmpty()) {
            this.f37024e = true;
        }
        Iterator<SpringSystemListener> it2 = this.f37023d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this);
        }
        if (this.f37024e) {
            this.f37022c.c();
        }
    }

    void j(Spring spring) {
        if (spring != null) {
            if (!this.f37020a.containsKey(spring.i())) {
                this.f37020a.put(spring.i(), spring);
                return;
            }
            throw new IllegalArgumentException("spring is already registered");
        }
        throw new IllegalArgumentException("spring is required");
    }

    public void k() {
        this.f37023d.clear();
    }

    public void l(SpringSystemListener springSystemListener) {
        if (springSystemListener != null) {
            this.f37023d.remove(springSystemListener);
            return;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }
}
