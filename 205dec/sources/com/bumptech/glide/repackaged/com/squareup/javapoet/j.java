package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: ParameterSpec.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f17839a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17840b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Modifier> f17841c;

    /* renamed from: d  reason: collision with root package name */
    public final l f17842d;

    /* compiled from: ParameterSpec.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final l f17843a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17844b;

        /* renamed from: c  reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17845c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Modifier> f17846d;

        public b e(c cVar) {
            this.f17845c.add(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(cVar).f());
            return this;
        }

        public b f(Iterable<com.bumptech.glide.repackaged.com.squareup.javapoet.a> iterable) {
            n.b(iterable != null, "annotationSpecs == null", new Object[0]);
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar : iterable) {
                this.f17845c.add(aVar);
            }
            return this;
        }

        public b g(Iterable<Modifier> iterable) {
            n.c(iterable, "modifiers == null", new Object[0]);
            for (Modifier modifier : iterable) {
                this.f17846d.add(modifier);
            }
            return this;
        }

        public b h(Modifier... modifierArr) {
            Collections.addAll(this.f17846d, modifierArr);
            return this;
        }

        public j i() {
            return new j(this);
        }

        private b(l lVar, String str) {
            this.f17845c = new ArrayList();
            this.f17846d = new ArrayList();
            this.f17843a = lVar;
            this.f17844b = str;
        }
    }

    public static b a(l lVar, String str, Modifier... modifierArr) {
        n.c(lVar, "type == null", new Object[0]);
        n.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(lVar, str).h(modifierArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, boolean z3) throws IOException {
        eVar.e(this.f17840b, true);
        eVar.j(this.f17841c);
        if (z3) {
            eVar.c("$T... $L", l.d(this.f17842d), this.f17839a);
        } else {
            eVar.c("$T $L", this.f17842d, this.f17839a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
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
            b(new e(stringWriter), false);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private j(b bVar) {
        this.f17839a = (String) n.c(bVar.f17844b, "name == null", new Object[0]);
        this.f17840b = n.f(bVar.f17845c);
        this.f17841c = n.i(bVar.f17846d);
        this.f17842d = (l) n.c(bVar.f17843a, "type == null", new Object[0]);
    }
}
