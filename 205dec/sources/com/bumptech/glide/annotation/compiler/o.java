package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestOptionsOverrideGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final TypeElement f16569a;

    /* renamed from: b  reason: collision with root package name */
    private i f16570b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestOptionsOverrideGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.squareup.javapoet.l f16571a;

        a(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar) {
            this.f16571a = lVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            return o.this.d(this.f16571a, executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestOptionsOverrideGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class b implements com.bumptech.glide.repackaged.com.google.common.base.e<ExecutableElement> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f16573a;

        b(Set set) {
            this.f16573a = set;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(ExecutableElement executableElement) {
            return !this.f16573a.contains(executableElement.getSimpleName().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestOptionsOverrideGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class c implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f17839a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16570b = iVar;
        this.f16569a = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i d(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, ExecutableElement executableElement) {
        i.b F = i.J(executableElement).F(lVar);
        F.p(com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("return ($T) super.$N(", lVar, executableElement.getSimpleName()).b(com.bumptech.glide.repackaged.com.google.common.collect.g.g(F.C().f17823g).n(new c()).k(com.bumptech.glide.repackaged.com.google.common.base.b.f(", ")), new Object[0]).b(");\n", new Object[0]).j());
        if (executableElement.getSimpleName().toString().contains("transform") && executableElement.isVarArgs()) {
            F.u(Modifier.FINAL).n(SafeVarargs.class).l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "varargs").f());
        }
        for (AnnotationMirror annotationMirror : executableElement.getAnnotationMirrors()) {
            F.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror));
        }
        return F.C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> b(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar) {
        return c(lVar, Collections.emptySet());
    }

    List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> c(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, Set<String> set) {
        i iVar = this.f16570b;
        TypeElement typeElement = this.f16569a;
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(iVar.j(typeElement, typeElement)).c(new b(set)).n(new a(lVar)).l();
    }
}
