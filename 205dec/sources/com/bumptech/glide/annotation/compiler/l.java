package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManagerGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class l {

    /* renamed from: j  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16535j = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.content", "Context", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private ProcessingEnvironment f16536a;

    /* renamed from: b  reason: collision with root package name */
    private final i f16537b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16538c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeElement f16539d;

    /* renamed from: e  reason: collision with root package name */
    private final TypeElement f16540e;

    /* renamed from: f  reason: collision with root package name */
    private final TypeElement f16541f;

    /* renamed from: g  reason: collision with root package name */
    private final TypeElement f16542g;

    /* renamed from: h  reason: collision with root package name */
    private final TypeElement f16543h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f16544i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManagerGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16545a;

        a(String str) {
            this.f16545a = str;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return l.this.n(this.f16545a, executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManagerGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class b implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return l.this.l(executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManagerGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class c implements com.bumptech.glide.repackaged.com.google.common.base.e<ExecutableElement> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(ExecutableElement executableElement) {
            return !executableElement.getSimpleName().toString().equals("as");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestManagerGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class d implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {
        d() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return l.this.e(executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16536a = processingEnvironment;
        this.f16537b = iVar;
        Elements elementUtils = processingEnvironment.getElementUtils();
        TypeElement typeElement = elementUtils.getTypeElement("com.bumptech.glide.RequestManager");
        this.f16542g = typeElement;
        this.f16538c = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(typeElement);
        this.f16539d = elementUtils.getTypeElement("com.bumptech.glide.manager.Lifecycle");
        this.f16540e = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerTreeNode");
        this.f16543h = elementUtils.getTypeElement("com.bumptech.glide.RequestBuilder");
        this.f16541f = elementUtils.getTypeElement("com.bumptech.glide.Glide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i e(ExecutableElement executableElement) {
        if (executableElement.getReturnType().getKind() == TypeKind.VOID) {
            return f(executableElement);
        }
        return g(executableElement);
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i f(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.r(this.f16537b.i(executableElement, GlideType.class).iterator().next());
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r4 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(this.f16544i, r3);
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC).F(r4).s(this.f16537b.q(executableElement)).m(i.H()).m(i.d()).y("$T requestBuilder = this.as($T.class)", r4, r3).y("$T.$N(requestBuilder)", executableElement.getEnclosingElement(), executableElement.getSimpleName()).y("return requestBuilder", new Object[0]).C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i g(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.r(this.f16537b.i(executableElement, GlideType.class).iterator().next());
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r4 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(this.f16544i, r3);
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC).F(r4).s(this.f16537b.q(executableElement)).m(i.H()).m(i.d()).y("return ($T) $T.$N(this.as($T.class))", r4, executableElement.getEnclosingElement(), executableElement.getSimpleName(), r3).C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i h(String str, TypeSpec typeSpec) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.m r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.m.r("ResourceType");
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("as").u(Modifier.PUBLIC).n(Override.class).m(i.d()).m(i.H()).z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.r("ResourceType")).F(com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, typeSpec.f17724b, new String[0]), r3)).w(com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(Class.class), r3).b(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(i.H()).f()), "resourceClass", new Modifier[0]).y("return new $T<>(glide, this, resourceClass, context)", this.f16544i).C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i i() {
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().u(Modifier.PUBLIC).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16541f), "glide", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16539d), "lifecycle", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16540e), "treeNode", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(f16535j, "context", new Modifier[0]).e(i.H()).i()).y("super(glide, lifecycle, treeNode, context)", new Object[0]).C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> j(Set<String> set) {
        return com.bumptech.glide.repackaged.com.google.common.collect.o.i(this.f16537b.h(set, GlideType.class), new d());
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i k(String str, TypeSpec typeSpec) {
        if (typeSpec == null) {
            return null;
        }
        String str2 = str + "." + typeSpec.f17724b;
        return com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("setRequestOptions").n(Override.class).u(Modifier.PROTECTED).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16536a.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions")), "toSet", new Modifier[0]).e(i.H()).i()).B("if ($N instanceof $L)", "toSet", str2).y("super.$N($N)", "setRequestOptions", "toSet").E("else", new Object[0]).y("super.setRequestOptions(new $L().apply($N))", str2, "toSet").D().C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i l(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(this.f16544i, com.bumptech.glide.repackaged.com.squareup.javapoet.l.j((TypeMirror) executableElement.getReturnType().getTypeArguments().get(0)));
        i.b F = i.J(executableElement).F(r3);
        F.p(i.n(r3, F.C()));
        for (AnnotationMirror annotationMirror : executableElement.getAnnotationMirrors()) {
            F.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror));
        }
        return F.C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> m() {
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(this.f16537b.k(this.f16542g, this.f16536a.getTypeUtils().erasure(this.f16543h.asType()))).c(new c()).n(new b()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i n(String str, ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c w3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, "GlideRequests", new String[0]);
        i.b F = i.J(executableElement).m(i.H()).F(w3);
        return F.p(i.n(w3, F.C())).C();
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> o(String str) {
        i iVar = this.f16537b;
        TypeElement typeElement = this.f16542g;
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(iVar.j(typeElement, typeElement)).n(new a(str)).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec d(String str, TypeSpec typeSpec, TypeSpec typeSpec2, Set<String> set) {
        this.f16544i = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, typeSpec2.f17724b, new String[0]);
        return TypeSpec.a("GlideRequests").C(this.f16538c).u("Includes all additions from methods in {@link $T}s\nannotated with {@link $T}\n\n<p>Generated code, do not modify\n", GlideExtension.class, GlideType.class).q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "deprecation").f()).x(Modifier.PUBLIC).v(h(str, typeSpec2)).v(i()).w(j(set)).w(o(str)).w(m()).w(com.bumptech.glide.repackaged.com.google.common.collect.g.g(Collections.singletonList(k(str, typeSpec))).c(com.bumptech.glide.repackaged.com.google.common.base.f.a())).B();
    }
}
