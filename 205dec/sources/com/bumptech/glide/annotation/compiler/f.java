package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlideGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final ProcessingEnvironment f16480a;

    /* renamed from: b  reason: collision with root package name */
    private final i f16481b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeElement f16482c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeElement f16483d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GlideGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f16484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TypeSpec f16485b;

        a(String str, TypeSpec typeSpec) {
            this.f16484a = str;
            this.f16485b = typeSpec;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.i apply(ExecutableElement executableElement) {
            if (f.this.h(executableElement)) {
                return f.this.j(this.f16484a, this.f16485b, executableElement);
            }
            return f.this.i(executableElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16480a = processingEnvironment;
        this.f16481b = iVar;
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.f16483d = elementUtils.getTypeElement("com.bumptech.glide.RequestManager");
        this.f16482c = elementUtils.getTypeElement("com.bumptech.glide.Glide");
    }

    private i.b d(i.b bVar, ExecutableElement executableElement) {
        Elements elementUtils = this.f16480a.getElementUtils();
        TypeElement typeElement = elementUtils.getTypeElement("androidx.annotation.VisibleForTesting");
        if (typeElement == null) {
            typeElement = elementUtils.getTypeElement("androidx.annotation.VisibleForTesting");
        }
        String obj = typeElement.toString();
        for (AnnotationMirror annotationMirror : executableElement.getAnnotationMirrors()) {
            bVar.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror));
            if (annotationMirror.getAnnotationType().toString().equals(obj)) {
                bVar.l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.annotation", "SuppressLint", new String[0])).d("value", "$S", "VisibleForTests").f());
            }
        }
        return bVar;
    }

    private List<ExecutableElement> e() {
        return this.f16481b.l(this.f16482c);
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> g(String str, TypeSpec typeSpec) {
        return com.bumptech.glide.repackaged.com.google.common.collect.o.i(e(), new a(str, typeSpec));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(ExecutableElement executableElement) {
        return this.f16481b.F(executableElement, this.f16483d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i i(ExecutableElement executableElement) {
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> z3 = i.z(executableElement);
        TypeElement asElement = this.f16480a.getTypeUtils().asElement(executableElement.getReturnType());
        i.b x3 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f16481b.q(executableElement)).x(z3);
        d(x3, executableElement);
        boolean z4 = asElement != null;
        if (z4) {
            x3.F(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(asElement));
        }
        StringBuilder sb = new StringBuilder(z4 ? "return " : "");
        sb.append("$T.$N(");
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16482c));
        arrayList.add(executableElement.getSimpleName());
        if (!z3.isEmpty()) {
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : z3) {
                sb.append("$L, ");
                arrayList.add(jVar.f17839a);
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")");
        x3.y(sb.toString(), arrayList.toArray(new Object[0]));
        return x3.C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.i j(String str, TypeSpec typeSpec, ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c w3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, typeSpec.f17724b, new String[0]);
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> z3 = i.z(executableElement);
        com.bumptech.glide.repackaged.com.google.common.base.d.f(z3.size() == 1, "Expected size of 1, but got %s", executableElement);
        return d(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f16481b.q(executableElement)).x(z3).F(w3).y("return ($T) $T.$N($L)", w3, this.f16482c, executableElement.getSimpleName().toString(), z3.iterator().next().f17839a), executableElement).C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec f(String str, String str2, TypeSpec typeSpec) {
        return TypeSpec.a(str2).u("The entry point for interacting with Glide for Applications\n\n<p>Includes all generated APIs from all\n{@link $T}s in source and dependent libraries.\n\n<p>This class is generated and should not be modified\n@see $T\n", GlideExtension.class, this.f16482c).x(Modifier.PUBLIC, Modifier.FINAL).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.a().u(Modifier.PRIVATE).C()).w(g(str, typeSpec)).B();
    }
}
