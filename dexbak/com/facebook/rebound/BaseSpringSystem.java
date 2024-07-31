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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BaseSpringSystem {

    /* renamed from: c */
    private final SpringLooper f23426c;

    /* renamed from: a */
    private final Map<String, Spring> f23424a = new HashMap();

    /* renamed from: b */
    private final Set<Spring> f23425b = new CopyOnWriteArraySet();

    /* renamed from: d */
    private final CopyOnWriteArraySet<SpringSystemListener> f23427d = new CopyOnWriteArraySet<>();

    /* renamed from: e */
    private boolean f23428e = true;

    public BaseSpringSystem(SpringLooper springLooper) {
        if (springLooper != null) {
            this.f23426c = springLooper;
            springLooper.m35556a(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m35641a(String str) {
        Spring spring = this.f23424a.get(str);
        if (spring != null) {
            this.f23425b.add(spring);
            if (m35635g()) {
                this.f23428e = false;
                this.f23426c.mo35549b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
    }

    /* renamed from: b */
    public void m35640b(SpringSystemListener springSystemListener) {
        if (springSystemListener != null) {
            this.f23427d.add(springSystemListener);
            return;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    /* renamed from: c */
    void m35639c(double d) {
        for (Spring spring : this.f23425b) {
            if (spring.m35599D()) {
                spring.m35596b(d / 1000.0d);
            } else {
                this.f23425b.remove(spring);
            }
        }
    }

    /* renamed from: d */
    public Spring m35638d() {
        Spring spring = new Spring(this);
        m35632j(spring);
        return spring;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m35637e(Spring spring) {
        if (spring != null) {
            this.f23425b.remove(spring);
            this.f23424a.remove(spring.m35589i());
            return;
        }
        throw new IllegalArgumentException("spring is required");
    }

    /* renamed from: f */
    public List<Spring> m35636f() {
        List arrayList;
        Collection<Spring> values = this.f23424a.values();
        if (values instanceof List) {
            arrayList = (List) values;
        } else {
            arrayList = new ArrayList(values);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: g */
    public boolean m35635g() {
        return this.f23428e;
    }

    /* renamed from: h */
    public Spring m35634h(String str) {
        if (str != null) {
            return this.f23424a.get(str);
        }
        throw new IllegalArgumentException("id is required");
    }

    /* renamed from: i */
    public void m35633i(double d) {
        Iterator<SpringSystemListener> it = this.f23427d.iterator();
        while (it.hasNext()) {
            it.next().m35554a(this);
        }
        m35639c(d);
        if (this.f23425b.isEmpty()) {
            this.f23428e = true;
        }
        Iterator<SpringSystemListener> it2 = this.f23427d.iterator();
        while (it2.hasNext()) {
            it2.next().m35553b(this);
        }
        if (this.f23428e) {
            this.f23426c.mo35548c();
        }
    }

    /* renamed from: j */
    void m35632j(Spring spring) {
        if (spring != null) {
            if (!this.f23424a.containsKey(spring.m35589i())) {
                this.f23424a.put(spring.m35589i(), spring);
                return;
            }
            throw new IllegalArgumentException("spring is already registered");
        }
        throw new IllegalArgumentException("spring is required");
    }

    /* renamed from: k */
    public void m35631k() {
        this.f23427d.clear();
    }

    /* renamed from: l */
    public void m35630l(SpringSystemListener springSystemListener) {
        if (springSystemListener != null) {
            this.f23427d.remove(springSystemListener);
            return;
        }
        throw new IllegalArgumentException("listenerToRemove is required");
    }
}
