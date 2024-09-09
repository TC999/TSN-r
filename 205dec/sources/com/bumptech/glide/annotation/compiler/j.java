package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.a;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestBuilderGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class j {

    /* renamed from: i  reason: collision with root package name */
    private static final ImmutableSet<String> f16508i = ImmutableSet.of("clone", "apply", "autoLock", "lock", "autoClone");

    /* renamed from: j  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.a f16509j = com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(i.H()).f();

    /* renamed from: k  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.a f16510k = com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(i.d()).f();

    /* renamed from: a  reason: collision with root package name */
    private final ProcessingEnvironment f16511a;

    /* renamed from: b  reason: collision with root package name */
    private final i f16512b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.m f16513c = com.bumptech.glide.repackaged.com.squareup.javapoet.m.r("TranscodeType");

    /* renamed from: d  reason: collision with root package name */
    private final TypeElement f16514d;

    /* renamed from: e  reason: collision with root package name */
    private final TypeElement f16515e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f16516f;

    /* renamed from: g  reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f16517g;

    /* renamed from: h  reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.k f16518h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.i, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return j.this.h(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class b implements com.bumptech.glide.repackaged.com.google.common.base.e<com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f16520a;

        b(List list) {
            this.f16520a = list;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return j.this.m(this.f16520a, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class c implements com.bumptech.glide.repackaged.com.google.common.base.e<com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.squareup.javapoet.i f16522a;

        c(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            this.f16522a = iVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return iVar.f17817a.equals(this.f16522a.f17817a) && iVar.f17823g.equals(this.f16522a.f17823g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class d implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        d() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f17839a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class e implements com.bumptech.glide.repackaged.com.google.common.base.e<com.bumptech.glide.repackaged.com.squareup.javapoet.a> {
        e() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar) {
            return (aVar.f17755a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.h(Override.class)) || aVar.f17755a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.h(SafeVarargs.class)) || aVar.f17755a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.h(SuppressWarnings.class))) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class f implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.d, String> {
        f() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.d dVar) {
            return dVar.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class g implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        g() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return j.this.j(executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilderGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class h implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        h() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f17839a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16511a = processingEnvironment;
        this.f16512b = iVar;
        this.f16515e = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.RequestBuilder");
        this.f16514d = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.a d(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        HashSet hashSet = new HashSet();
        if (iVar.f17819c.contains(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).f())) {
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar : iVar.f17819c) {
                if (aVar.f17755a.equals(com.bumptech.glide.repackaged.com.squareup.javapoet.l.h(SuppressWarnings.class))) {
                    hashSet.addAll(com.bumptech.glide.repackaged.com.google.common.collect.g.g(aVar.f17756b.get("value")).n(new f()).m());
                }
            }
        }
        if (iVar.f17819c.contains(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SafeVarargs.class).f())) {
            hashSet.add("unchecked");
            hashSet.add("varargs");
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        a.b b4 = com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b4.d("value", "$S", (String) it.next());
        }
        return b4.f();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> f() {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(Class.class), this.f16513c);
        return ImmutableList.of(com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(r3, "transcodeClass", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16515e), com.bumptech.glide.repackaged.com.squareup.javapoet.o.u(Object.class)), "other", new Modifier[0]).e(i.H()).i()).y("super($N, $N)", "transcodeClass", "other").C(), com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "Glide", new String[0]), "glide", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "RequestManager", new String[0]), "requestManager", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(r3, "transcodeClass", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.content", "Context", new String[0]), "context", new Modifier[0]).e(i.H()).i()).y("super($N, $N ,$N, $N)", "glide", "requestManager", "transcodeClass", "context").C());
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i g() {
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("getDownloadOnlyRequest").n(Override.class).l(f16510k).l(f16509j).F(com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(this.f16516f, com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(File.class))).u(Modifier.PROTECTED).y("return new $T<>($T.class, $N).apply($N)", this.f16516f, File.class, "this", "DOWNLOAD_ONLY_OPTIONS").C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i h(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        i.b p3 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(iVar.f17817a).s(this.f16512b.o(this.f16517g, iVar)).u(Modifier.PUBLIC).H(iVar.f17824h).o(com.bumptech.glide.repackaged.com.google.common.collect.g.g(iVar.f17819c).c(new e()).l()).A(iVar.f17821e).x(iVar.f17823g).F(this.f16518h).q("return ($T) super", this.f16518h).p(com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b(".$N(", iVar.f17817a).b(com.bumptech.glide.repackaged.com.google.common.collect.g.g(iVar.f17823g).n(new d()).k(com.bumptech.glide.repackaged.com.google.common.base.b.f(", ")), new Object[0]).b(");\n", new Object[0]).j());
        com.bumptech.glide.repackaged.com.squareup.javapoet.a d4 = d(iVar);
        if (d4 != null) {
            p3.l(d4);
        }
        return p3.C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> i(List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> list, TypeSpec typeSpec) {
        if (typeSpec == null) {
            return Collections.emptyList();
        }
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(typeSpec.f17736n).c(new b(list)).n(new a()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i j(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(this.f16516f, com.bumptech.glide.repackaged.com.squareup.javapoet.l.j((TypeMirror) executableElement.getReturnType().getTypeArguments().get(0)));
        i.b F = i.J(executableElement).F(r3);
        F.p(com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("return ($T) super.$N(", r3, executableElement.getSimpleName()).b(com.bumptech.glide.repackaged.com.google.common.collect.g.g(F.C().f17823g).n(new h()).k(com.bumptech.glide.repackaged.com.google.common.base.b.f(", ")), new Object[0]).b(");\n", new Object[0]).j());
        for (AnnotationMirror annotationMirror : executableElement.getAnnotationMirrors()) {
            F = F.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror));
        }
        if (executableElement.isVarArgs()) {
            F = F.u(Modifier.FINAL).n(SafeVarargs.class).l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "varargs").f());
        }
        return F.C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> k() {
        return com.bumptech.glide.repackaged.com.google.common.collect.o.i(this.f16512b.k(this.f16515e, this.f16511a.getTypeUtils().erasure(this.f16515e.asType())), new g());
    }

    private boolean l(List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> list, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(list).a(new c(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> list, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return (f16508i.contains(iVar.f17817a) || !iVar.c(Modifier.PUBLIC) || iVar.c(Modifier.STATIC) || !iVar.f17822f.toString().equals(this.f16517g.toString()) || l(list, iVar)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec e(String str, Set<String> set, TypeSpec typeSpec) {
        if (typeSpec != null) {
            this.f16517g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, typeSpec.f17724b, new String[0]);
        } else {
            this.f16517g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide.request", "BaseRequestOptions", new String[0]);
        }
        com.bumptech.glide.repackaged.com.squareup.javapoet.c w3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, "GlideRequest", new String[0]);
        this.f16516f = w3;
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(w3, this.f16513c);
        this.f16518h = r3;
        m mVar = new m(r3, this.f16512b);
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r4 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "RequestBuilder", new String[0]), this.f16513c);
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> a4 = mVar.a(set);
        return TypeSpec.a("GlideRequest").u("Contains all public methods from {@link $T}, all options from\n", this.f16515e).u("{@link $T} and all generated options from\n", this.f16514d).u("{@link $T} in annotated methods in\n", GlideOption.class).u("{@link $T} annotated classes.\n", GlideExtension.class).u("\n", new Object[0]).u("<p>Generated code, do not modify.\n", new Object[0]).u("\n", new Object[0]).u("@see $T\n", this.f16515e).u("@see $T\n", this.f16514d).q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "unused").d("value", "$S", "deprecation").f()).x(Modifier.PUBLIC).A(this.f16513c).C(r4).z(Cloneable.class).w(f()).v(g()).w(i(a4, typeSpec)).w(k()).w(a4).B();
    }
}
