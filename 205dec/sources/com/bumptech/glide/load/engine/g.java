package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DecodeHelper.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class g<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f17031a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f17032b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.f f17033c;

    /* renamed from: d  reason: collision with root package name */
    private Object f17034d;

    /* renamed from: e  reason: collision with root package name */
    private int f17035e;

    /* renamed from: f  reason: collision with root package name */
    private int f17036f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f17037g;

    /* renamed from: h  reason: collision with root package name */
    private h.e f17038h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.load.f f17039i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.i<?>> f17040j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f17041k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17042l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17043m;

    /* renamed from: n  reason: collision with root package name */
    private com.bumptech.glide.load.c f17044n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f17045o;

    /* renamed from: p  reason: collision with root package name */
    private j f17046p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f17047q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f17048r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f17033c = null;
        this.f17034d = null;
        this.f17044n = null;
        this.f17037g = null;
        this.f17041k = null;
        this.f17039i = null;
        this.f17045o = null;
        this.f17040j = null;
        this.f17046p = null;
        this.f17031a.clear();
        this.f17042l = false;
        this.f17032b.clear();
        this.f17043m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f17033c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.c> c() {
        if (!this.f17043m) {
            this.f17043m = true;
            this.f17032b.clear();
            List<n.a<?>> g4 = g();
            int size = g4.size();
            for (int i4 = 0; i4 < size; i4++) {
                n.a<?> aVar = g4.get(i4);
                if (!this.f17032b.contains(aVar.f17316a)) {
                    this.f17032b.add(aVar.f17316a);
                }
                for (int i5 = 0; i5 < aVar.f17317b.size(); i5++) {
                    if (!this.f17032b.contains(aVar.f17317b.get(i5))) {
                        this.f17032b.add(aVar.f17317b.get(i5));
                    }
                }
            }
        }
        return this.f17032b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.engine.cache.a d() {
        return this.f17038h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j e() {
        return this.f17046p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f17036f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.f17042l) {
            this.f17042l = true;
            this.f17031a.clear();
            List i4 = this.f17033c.h().i(this.f17034d);
            int size = i4.size();
            for (int i5 = 0; i5 < size; i5++) {
                n.a<?> b4 = ((com.bumptech.glide.load.model.n) i4.get(i5)).b(this.f17034d, this.f17035e, this.f17036f, this.f17039i);
                if (b4 != null) {
                    this.f17031a.add(b4);
                }
            }
        }
        return this.f17031a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f17033c.h().h(cls, this.f17037g, this.f17041k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f17034d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.model.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f17033c.h().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.f k() {
        return this.f17039i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority l() {
        return this.f17045o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f17033c.h().j(this.f17034d.getClass(), this.f17037g, this.f17041k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.h<Z> n(u<Z> uVar) {
        return this.f17033c.h().k(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.c o() {
        return this.f17044n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.a<X> p(X x3) throws Registry.NoSourceEncoderAvailableException {
        return this.f17033c.h().m(x3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return (Class<Transcode>) this.f17041k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.i<Z> r(Class<Z> cls) {
        com.bumptech.glide.load.i<Z> iVar = (com.bumptech.glide.load.i<Z>) this.f17040j.get(cls);
        if (iVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.i<?>>> it = this.f17040j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.i<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    iVar = (com.bumptech.glide.load.i<Z>) next.getValue();
                    break;
                }
            }
        }
        if (iVar == null) {
            if (this.f17040j.isEmpty() && this.f17047q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return com.bumptech.glide.load.resource.b.c();
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f17035e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(com.bumptech.glide.f fVar, Object obj, com.bumptech.glide.load.c cVar, int i4, int i5, j jVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.f fVar2, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z3, boolean z4, h.e eVar) {
        this.f17033c = fVar;
        this.f17034d = obj;
        this.f17044n = cVar;
        this.f17035e = i4;
        this.f17036f = i5;
        this.f17046p = jVar;
        this.f17037g = cls;
        this.f17038h = eVar;
        this.f17041k = cls2;
        this.f17045o = priority;
        this.f17039i = fVar2;
        this.f17040j = map;
        this.f17047q = z3;
        this.f17048r = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(u<?> uVar) {
        return this.f17033c.h().n(uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f17048r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(com.bumptech.glide.load.c cVar) {
        List<n.a<?>> g4 = g();
        int size = g4.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (g4.get(i4).f17316a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }
}
