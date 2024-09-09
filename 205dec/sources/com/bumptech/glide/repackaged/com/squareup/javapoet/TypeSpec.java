package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class TypeSpec {

    /* renamed from: q  reason: collision with root package name */
    static final /* synthetic */ boolean f17722q = false;

    /* renamed from: a  reason: collision with root package name */
    public final Kind f17723a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17724b;

    /* renamed from: c  reason: collision with root package name */
    public final d f17725c;

    /* renamed from: d  reason: collision with root package name */
    public final d f17726d;

    /* renamed from: e  reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17727e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<Modifier> f17728f;

    /* renamed from: g  reason: collision with root package name */
    public final List<m> f17729g;

    /* renamed from: h  reason: collision with root package name */
    public final l f17730h;

    /* renamed from: i  reason: collision with root package name */
    public final List<l> f17731i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, TypeSpec> f17732j;

    /* renamed from: k  reason: collision with root package name */
    public final List<f> f17733k;

    /* renamed from: l  reason: collision with root package name */
    public final d f17734l;

    /* renamed from: m  reason: collision with root package name */
    public final d f17735m;

    /* renamed from: n  reason: collision with root package name */
    public final List<i> f17736n;

    /* renamed from: o  reason: collision with root package name */
    public final List<TypeSpec> f17737o;

    /* renamed from: p  reason: collision with root package name */
    public final List<Element> f17738p;

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public enum Kind {
        CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
        INTERFACE(n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), n.i(Arrays.asList(Modifier.STATIC))),
        ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
        ANNOTATION(n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.ABSTRACT)), n.i(Arrays.asList(Modifier.PUBLIC, Modifier.STATIC)), n.i(Arrays.asList(Modifier.STATIC)));
        
        private final Set<Modifier> asMemberModifiers;
        private final Set<Modifier> implicitFieldModifiers;
        private final Set<Modifier> implicitMethodModifiers;
        private final Set<Modifier> implicitTypeModifiers;

        Kind(Set set, Set set2, Set set3, Set set4) {
            this.implicitFieldModifiers = set;
            this.implicitMethodModifiers = set2;
            this.implicitTypeModifiers = set3;
            this.asMemberModifiers = set4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Kind f17739a;

        /* renamed from: b  reason: collision with root package name */
        private final String f17740b;

        /* renamed from: c  reason: collision with root package name */
        private final d f17741c;

        /* renamed from: d  reason: collision with root package name */
        private final d.b f17742d;

        /* renamed from: e  reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17743e;

        /* renamed from: f  reason: collision with root package name */
        private final List<Modifier> f17744f;

        /* renamed from: g  reason: collision with root package name */
        private final List<m> f17745g;

        /* renamed from: h  reason: collision with root package name */
        private l f17746h;

        /* renamed from: i  reason: collision with root package name */
        private final List<l> f17747i;

        /* renamed from: j  reason: collision with root package name */
        private final Map<String, TypeSpec> f17748j;

        /* renamed from: k  reason: collision with root package name */
        private final List<f> f17749k;

        /* renamed from: l  reason: collision with root package name */
        private final d.b f17750l;

        /* renamed from: m  reason: collision with root package name */
        private final d.b f17751m;

        /* renamed from: n  reason: collision with root package name */
        private final List<i> f17752n;

        /* renamed from: o  reason: collision with root package name */
        private final List<TypeSpec> f17753o;

        /* renamed from: p  reason: collision with root package name */
        private final List<Element> f17754p;

        public b A(m mVar) {
            n.d(this.f17741c == null, "forbidden on anonymous types.", new Object[0]);
            this.f17745g.add(mVar);
            return this;
        }

        public TypeSpec B() {
            boolean z3 = true;
            n.b((this.f17739a == Kind.ENUM && this.f17748j.isEmpty()) ? false : true, "at least one enum constant is required for %s", this.f17740b);
            boolean z4 = this.f17744f.contains(Modifier.ABSTRACT) || this.f17739a != Kind.CLASS;
            for (i iVar : this.f17752n) {
                n.b(z4 || !iVar.c(Modifier.ABSTRACT), "non-abstract type %s cannot declare abstract method %s", this.f17740b, iVar.f17817a);
            }
            int size = (!this.f17746h.equals(c.f17761y)) + this.f17747i.size();
            if (this.f17741c != null && size > 1) {
                z3 = false;
            }
            n.b(z3, "anonymous type has too many supertypes", new Object[0]);
            return new TypeSpec(this);
        }

        public b C(l lVar) {
            boolean z3 = this.f17739a == Kind.CLASS;
            n.d(z3, "only classes have super classes, not " + this.f17739a, new Object[0]);
            boolean z4 = this.f17746h == c.f17761y;
            n.d(z4, "superclass already set to " + this.f17746h, new Object[0]);
            n.b(lVar.n() ^ true, "superclass may not be a primitive", new Object[0]);
            this.f17746h = lVar;
            return this;
        }

        public b q(com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar) {
            this.f17743e.add(aVar);
            return this;
        }

        public b r(f fVar) {
            Kind kind = this.f17739a;
            if (kind == Kind.INTERFACE || kind == Kind.ANNOTATION) {
                n.k(fVar.f17789e, Modifier.PUBLIC, Modifier.PRIVATE);
                EnumSet of = EnumSet.of(Modifier.STATIC, Modifier.FINAL);
                n.d(fVar.f17789e.containsAll(of), "%s %s.%s requires modifiers %s", this.f17739a, this.f17740b, fVar.f17786b, of);
            }
            this.f17749k.add(fVar);
            return this;
        }

        public b s(l lVar, String str, Modifier... modifierArr) {
            return r(f.a(lVar, str, modifierArr).h());
        }

        public b t(d dVar) {
            this.f17742d.a(dVar);
            return this;
        }

        public b u(String str, Object... objArr) {
            this.f17742d.b(str, objArr);
            return this;
        }

        public b v(i iVar) {
            Kind kind = this.f17739a;
            Kind kind2 = Kind.INTERFACE;
            if (kind == kind2) {
                n.k(iVar.f17820d, Modifier.ABSTRACT, Modifier.STATIC, n.f17876a);
                n.k(iVar.f17820d, Modifier.PUBLIC, Modifier.PRIVATE);
            } else if (kind == Kind.ANNOTATION) {
                boolean equals = iVar.f17820d.equals(kind.implicitMethodModifiers);
                Kind kind3 = this.f17739a;
                n.d(equals, "%s %s.%s requires modifiers %s", kind3, this.f17740b, iVar.f17817a, kind3.implicitMethodModifiers);
            }
            Kind kind4 = this.f17739a;
            if (kind4 != Kind.ANNOTATION) {
                n.d(iVar.f17827k == null, "%s %s.%s cannot have a default value", kind4, this.f17740b, iVar.f17817a);
            }
            if (this.f17739a != kind2) {
                n.d(!n.e(iVar.f17820d), "%s %s.%s cannot be default", this.f17739a, this.f17740b, iVar.f17817a);
            }
            this.f17752n.add(iVar);
            return this;
        }

        public b w(Iterable<i> iterable) {
            n.b(iterable != null, "methodSpecs == null", new Object[0]);
            for (i iVar : iterable) {
                v(iVar);
            }
            return this;
        }

        public b x(Modifier... modifierArr) {
            n.d(this.f17741c == null, "forbidden on anonymous types.", new Object[0]);
            int length = modifierArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                Modifier modifier = modifierArr[i4];
                n.b(modifier != null, "modifiers contain null", new Object[0]);
                this.f17744f.add(modifier);
            }
            return this;
        }

        public b y(l lVar) {
            n.b(lVar != null, "superinterface == null", new Object[0]);
            this.f17747i.add(lVar);
            return this;
        }

        public b z(Type type) {
            return y(l.h(type));
        }

        private b(Kind kind, String str, d dVar) {
            this.f17742d = d.a();
            this.f17743e = new ArrayList();
            this.f17744f = new ArrayList();
            this.f17745g = new ArrayList();
            this.f17746h = c.f17761y;
            this.f17747i = new ArrayList();
            this.f17748j = new LinkedHashMap();
            this.f17749k = new ArrayList();
            this.f17750l = d.a();
            this.f17751m = d.a();
            this.f17752n = new ArrayList();
            this.f17753o = new ArrayList();
            this.f17754p = new ArrayList();
            n.b(str == null || SourceVersion.isName(str), "not a valid name: %s", str);
            this.f17739a = kind;
            this.f17740b = str;
            this.f17741c = dVar;
        }
    }

    public static b a(String str) {
        return new b(Kind.CLASS, (String) n.c(str, "name == null", new Object[0]), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, String str, Set<Modifier> set) throws IOException {
        List<l> singletonList;
        List<l> list;
        int i4 = eVar.f17784n;
        eVar.f17784n = -1;
        boolean z3 = true;
        try {
            if (str != null) {
                eVar.h(this.f17726d);
                eVar.e(this.f17727e, false);
                eVar.c("$L", str);
                if (!this.f17725c.f17766a.isEmpty()) {
                    eVar.b("(");
                    eVar.a(this.f17725c);
                    eVar.b(")");
                }
                if (this.f17733k.isEmpty() && this.f17736n.isEmpty() && this.f17737o.isEmpty()) {
                    return;
                }
                eVar.b(" {\n");
            } else if (this.f17725c != null) {
                eVar.c("new $T(", !this.f17731i.isEmpty() ? this.f17731i.get(0) : this.f17730h);
                eVar.a(this.f17725c);
                eVar.b(") {\n");
            } else {
                eVar.x(new TypeSpec(this));
                eVar.h(this.f17726d);
                eVar.e(this.f17727e, false);
                eVar.k(this.f17728f, n.m(set, this.f17723a.asMemberModifiers));
                Kind kind = this.f17723a;
                if (kind == Kind.ANNOTATION) {
                    eVar.c("$L $L", "@interface", this.f17724b);
                } else {
                    eVar.c("$L $L", kind.name().toLowerCase(Locale.US), this.f17724b);
                }
                eVar.m(this.f17729g);
                if (this.f17723a == Kind.INTERFACE) {
                    singletonList = this.f17731i;
                    list = Collections.emptyList();
                } else {
                    if (this.f17730h.equals(c.f17761y)) {
                        singletonList = Collections.emptyList();
                    } else {
                        singletonList = Collections.singletonList(this.f17730h);
                    }
                    list = this.f17731i;
                }
                if (!singletonList.isEmpty()) {
                    eVar.b(" extends");
                    boolean z4 = true;
                    for (l lVar : singletonList) {
                        if (!z4) {
                            eVar.b(",");
                        }
                        eVar.c(" $T", lVar);
                        z4 = false;
                    }
                }
                if (!list.isEmpty()) {
                    eVar.b(" implements");
                    boolean z5 = true;
                    for (l lVar2 : list) {
                        if (!z5) {
                            eVar.b(",");
                        }
                        eVar.c(" $T", lVar2);
                        z5 = false;
                    }
                }
                eVar.v();
                eVar.b(" {\n");
            }
            eVar.x(this);
            eVar.r();
            Iterator<Map.Entry<String, TypeSpec>> it = this.f17732j.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, TypeSpec> next = it.next();
                if (!z3) {
                    eVar.b("\n");
                }
                next.getValue().b(eVar, next.getKey(), Collections.emptySet());
                if (it.hasNext()) {
                    eVar.b(",\n");
                } else {
                    if (this.f17733k.isEmpty() && this.f17736n.isEmpty() && this.f17737o.isEmpty()) {
                        eVar.b("\n");
                    }
                    eVar.b(";\n");
                }
                z3 = false;
            }
            for (f fVar : this.f17733k) {
                if (fVar.c(Modifier.STATIC)) {
                    if (!z3) {
                        eVar.b("\n");
                    }
                    fVar.b(eVar, this.f17723a.implicitFieldModifiers);
                    z3 = false;
                }
            }
            if (!this.f17734l.b()) {
                if (!z3) {
                    eVar.b("\n");
                }
                eVar.a(this.f17734l);
                z3 = false;
            }
            for (f fVar2 : this.f17733k) {
                if (!fVar2.c(Modifier.STATIC)) {
                    if (!z3) {
                        eVar.b("\n");
                    }
                    fVar2.b(eVar, this.f17723a.implicitFieldModifiers);
                    z3 = false;
                }
            }
            if (!this.f17735m.b()) {
                if (!z3) {
                    eVar.b("\n");
                }
                eVar.a(this.f17735m);
                z3 = false;
            }
            for (i iVar : this.f17736n) {
                if (iVar.d()) {
                    if (!z3) {
                        eVar.b("\n");
                    }
                    iVar.b(eVar, this.f17724b, this.f17723a.implicitMethodModifiers);
                    z3 = false;
                }
            }
            for (i iVar2 : this.f17736n) {
                if (!iVar2.d()) {
                    if (!z3) {
                        eVar.b("\n");
                    }
                    iVar2.b(eVar, this.f17724b, this.f17723a.implicitMethodModifiers);
                    z3 = false;
                }
            }
            for (TypeSpec typeSpec : this.f17737o) {
                if (!z3) {
                    eVar.b("\n");
                }
                typeSpec.b(eVar, null, this.f17723a.implicitTypeModifiers);
                z3 = false;
            }
            eVar.B();
            eVar.v();
            eVar.b("}");
            if (str == null && this.f17725c == null) {
                eVar.b("\n");
            }
        } finally {
            eVar.f17784n = i4;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TypeSpec.class == obj.getClass()) {
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
            b(new e(stringWriter), null, Collections.emptySet());
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private TypeSpec(b bVar) {
        this.f17723a = bVar.f17739a;
        this.f17724b = bVar.f17740b;
        this.f17725c = bVar.f17741c;
        this.f17726d = bVar.f17742d.j();
        this.f17727e = n.f(bVar.f17743e);
        this.f17728f = n.i(bVar.f17744f);
        this.f17729g = n.f(bVar.f17745g);
        this.f17730h = bVar.f17746h;
        this.f17731i = n.f(bVar.f17747i);
        this.f17732j = n.g(bVar.f17748j);
        this.f17733k = n.f(bVar.f17749k);
        this.f17734l = bVar.f17750l.j();
        this.f17735m = bVar.f17751m.j();
        this.f17736n = n.f(bVar.f17752n);
        this.f17737o = n.f(bVar.f17753o);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(bVar.f17754p);
        for (TypeSpec typeSpec : bVar.f17753o) {
            arrayList.addAll(typeSpec.f17738p);
        }
        this.f17738p = n.f(arrayList);
    }

    private TypeSpec(TypeSpec typeSpec) {
        this.f17723a = typeSpec.f17723a;
        this.f17724b = typeSpec.f17724b;
        this.f17725c = null;
        this.f17726d = typeSpec.f17726d;
        this.f17727e = Collections.emptyList();
        this.f17728f = Collections.emptySet();
        this.f17729g = Collections.emptyList();
        this.f17730h = null;
        this.f17731i = Collections.emptyList();
        this.f17732j = Collections.emptyMap();
        this.f17733k = Collections.emptyList();
        this.f17734l = typeSpec.f17734l;
        this.f17735m = typeSpec.f17735m;
        this.f17736n = Collections.emptyList();
        this.f17737o = Collections.emptyList();
        this.f17738p = Collections.emptyList();
    }
}
