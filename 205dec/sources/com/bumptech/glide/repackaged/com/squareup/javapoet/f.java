package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* compiled from: FieldSpec.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final l f17785a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17786b;

    /* renamed from: c  reason: collision with root package name */
    public final d f17787c;

    /* renamed from: d  reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17788d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<Modifier> f17789e;

    /* renamed from: f  reason: collision with root package name */
    public final d f17790f;

    /* compiled from: FieldSpec.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final l f17791a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17792b;

        /* renamed from: c  reason: collision with root package name */
        private final d.b f17793c;

        /* renamed from: d  reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17794d;

        /* renamed from: e  reason: collision with root package name */
        private final List<Modifier> f17795e;

        /* renamed from: f  reason: collision with root package name */
        private d f17796f;

        public b g(Modifier... modifierArr) {
            Collections.addAll(this.f17795e, modifierArr);
            return this;
        }

        public f h() {
            return new f(this);
        }

        private b(l lVar, String str) {
            this.f17793c = d.a();
            this.f17794d = new ArrayList();
            this.f17795e = new ArrayList();
            this.f17796f = null;
            this.f17791a = lVar;
            this.f17792b = str;
        }
    }

    public static b a(l lVar, String str, Modifier... modifierArr) {
        n.c(lVar, "type == null", new Object[0]);
        n.b(SourceVersion.isName(str), "not a valid name: %s", str);
        return new b(lVar, str).g(modifierArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, Set<Modifier> set) throws IOException {
        eVar.h(this.f17787c);
        eVar.e(this.f17788d, false);
        eVar.k(this.f17789e, set);
        eVar.c("$T $L", this.f17785a, this.f17786b);
        if (!this.f17790f.b()) {
            eVar.b(" = ");
            eVar.a(this.f17790f);
        }
        eVar.b(";\n");
    }

    public boolean c(Modifier modifier) {
        return this.f17789e.contains(modifier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
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
            b(new e(stringWriter), Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private f(b bVar) {
        d dVar;
        this.f17785a = (l) n.c(bVar.f17791a, "type == null", new Object[0]);
        this.f17786b = (String) n.c(bVar.f17792b, "name == null", new Object[0]);
        this.f17787c = bVar.f17793c.j();
        this.f17788d = n.f(bVar.f17794d);
        this.f17789e = n.i(bVar.f17795e);
        if (bVar.f17796f == null) {
            dVar = d.a().j();
        } else {
            dVar = bVar.f17796f;
        }
        this.f17790f = dVar;
    }
}
