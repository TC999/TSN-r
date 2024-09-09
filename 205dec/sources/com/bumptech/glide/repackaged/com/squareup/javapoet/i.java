package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: MethodSpec.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f17817a;

    /* renamed from: b  reason: collision with root package name */
    public final d f17818b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17819c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Modifier> f17820d;

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f17821e;

    /* renamed from: f  reason: collision with root package name */
    public final l f17822f;

    /* renamed from: g  reason: collision with root package name */
    public final List<j> f17823g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f17824h;

    /* renamed from: i  reason: collision with root package name */
    public final List<l> f17825i;

    /* renamed from: j  reason: collision with root package name */
    public final d f17826j;

    /* renamed from: k  reason: collision with root package name */
    public final d f17827k;

    /* compiled from: MethodSpec.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f17828a;

        /* renamed from: b  reason: collision with root package name */
        private final d.b f17829b;

        /* renamed from: c  reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17830c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Modifier> f17831d;

        /* renamed from: e  reason: collision with root package name */
        private List<m> f17832e;

        /* renamed from: f  reason: collision with root package name */
        private l f17833f;

        /* renamed from: g  reason: collision with root package name */
        private final List<j> f17834g;

        /* renamed from: h  reason: collision with root package name */
        private final Set<l> f17835h;

        /* renamed from: i  reason: collision with root package name */
        private final d.b f17836i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f17837j;

        /* renamed from: k  reason: collision with root package name */
        private d f17838k;

        public b A(Iterable<m> iterable) {
            n.b(iterable != null, "typeVariables == null", new Object[0]);
            for (m mVar : iterable) {
                this.f17832e.add(mVar);
            }
            return this;
        }

        public b B(String str, Object... objArr) {
            this.f17836i.i(str, objArr);
            return this;
        }

        public i C() {
            return new i(this);
        }

        public b D() {
            this.f17836i.k();
            return this;
        }

        public b E(String str, Object... objArr) {
            this.f17836i.n(str, objArr);
            return this;
        }

        public b F(l lVar) {
            n.d(!this.f17828a.equals("<init>"), "constructor cannot have return type.", new Object[0]);
            this.f17833f = lVar;
            return this;
        }

        public b G(Type type) {
            return F(l.h(type));
        }

        public b H(boolean z3) {
            this.f17837j = z3;
            return this;
        }

        public b l(com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar) {
            this.f17830c.add(aVar);
            return this;
        }

        public b m(c cVar) {
            this.f17830c.add(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b n(Class<?> cls) {
            return m(c.u(cls));
        }

        public b o(Iterable<com.bumptech.glide.repackaged.com.squareup.javapoet.a> iterable) {
            n.b(iterable != null, "annotationSpecs == null", new Object[0]);
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar : iterable) {
                this.f17830c.add(aVar);
            }
            return this;
        }

        public b p(d dVar) {
            this.f17836i.a(dVar);
            return this;
        }

        public b q(String str, Object... objArr) {
            this.f17836i.b(str, objArr);
            return this;
        }

        public b r(l lVar) {
            this.f17835h.add(lVar);
            return this;
        }

        public b s(d dVar) {
            this.f17829b.a(dVar);
            return this;
        }

        public b t(Iterable<Modifier> iterable) {
            n.c(iterable, "modifiers == null", new Object[0]);
            for (Modifier modifier : iterable) {
                this.f17831d.add(modifier);
            }
            return this;
        }

        public b u(Modifier... modifierArr) {
            n.c(modifierArr, "modifiers == null", new Object[0]);
            Collections.addAll(this.f17831d, modifierArr);
            return this;
        }

        public b v(j jVar) {
            this.f17834g.add(jVar);
            return this;
        }

        public b w(l lVar, String str, Modifier... modifierArr) {
            return v(j.a(lVar, str, modifierArr).i());
        }

        public b x(Iterable<j> iterable) {
            n.b(iterable != null, "parameterSpecs == null", new Object[0]);
            for (j jVar : iterable) {
                this.f17834g.add(jVar);
            }
            return this;
        }

        public b y(String str, Object... objArr) {
            this.f17836i.d(str, objArr);
            return this;
        }

        public b z(m mVar) {
            this.f17832e.add(mVar);
            return this;
        }

        private b(String str) {
            this.f17829b = d.a();
            this.f17830c = new ArrayList();
            this.f17831d = new ArrayList();
            this.f17832e = new ArrayList();
            this.f17834g = new ArrayList();
            this.f17835h = new LinkedHashSet();
            this.f17836i = d.a();
            n.c(str, "name == null", new Object[0]);
            n.b(str.equals("<init>") || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f17828a = str;
            this.f17833f = str.equals("<init>") ? null : l.f17850d;
        }
    }

    public static b a() {
        return new b("<init>");
    }

    private boolean e(List<j> list) {
        return (list.isEmpty() || l.d(list.get(list.size() - 1).f17842d) == null) ? false : true;
    }

    public static b f(String str) {
        return new b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, String str, Set<Modifier> set) throws IOException {
        eVar.h(this.f17818b);
        eVar.e(this.f17819c, false);
        eVar.k(this.f17820d, set);
        if (!this.f17821e.isEmpty()) {
            eVar.m(this.f17821e);
            eVar.b(" ");
        }
        if (d()) {
            eVar.c("$L(", str);
        } else {
            eVar.c("$T $L(", this.f17822f, this.f17817a);
        }
        Iterator<j> it = this.f17823g.iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            j next = it.next();
            if (!z3) {
                eVar.b(",").n();
            }
            next.b(eVar, !it.hasNext() && this.f17824h);
            z3 = false;
        }
        eVar.b(")");
        d dVar = this.f17827k;
        if (dVar != null && !dVar.b()) {
            eVar.b(" default ");
            eVar.a(this.f17827k);
        }
        if (!this.f17825i.isEmpty()) {
            eVar.n().b("throws");
            boolean z4 = true;
            for (l lVar : this.f17825i) {
                if (!z4) {
                    eVar.b(",");
                }
                eVar.n().c("$T", lVar);
                z4 = false;
            }
        }
        if (c(Modifier.ABSTRACT)) {
            eVar.b(";\n");
        } else if (c(Modifier.NATIVE)) {
            eVar.a(this.f17826j);
            eVar.b(";\n");
        } else {
            eVar.b(" {\n");
            eVar.r();
            eVar.a(this.f17826j);
            eVar.B();
            eVar.b("}\n");
        }
    }

    public boolean c(Modifier modifier) {
        return this.f17820d.contains(modifier);
    }

    public boolean d() {
        return this.f17817a.equals("<init>");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            b(new e(stringWriter), "Constructor", Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private i(b bVar) {
        d j4 = bVar.f17836i.j();
        n.b(j4.b() || !bVar.f17831d.contains(Modifier.ABSTRACT), "abstract method %s cannot have code", bVar.f17828a);
        n.b(!bVar.f17837j || e(bVar.f17834g), "last parameter of varargs method %s must be an array", bVar.f17828a);
        this.f17817a = (String) n.c(bVar.f17828a, "name == null", new Object[0]);
        this.f17818b = bVar.f17829b.j();
        this.f17819c = n.f(bVar.f17830c);
        this.f17820d = n.i(bVar.f17831d);
        this.f17821e = n.f(bVar.f17832e);
        this.f17822f = bVar.f17833f;
        this.f17823g = n.f(bVar.f17834g);
        this.f17824h = bVar.f17837j;
        this.f17825i = n.f(bVar.f17835h);
        this.f17827k = bVar.f17838k;
        this.f17826j = j4;
    }
}
