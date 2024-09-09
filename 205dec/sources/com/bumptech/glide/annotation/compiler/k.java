package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManagerFactoryGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class k {

    /* renamed from: f  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16529f = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.content", "Context", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final TypeElement f16530a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeElement f16531b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeElement f16532c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeElement f16533d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16534e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ProcessingEnvironment processingEnvironment) {
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.f16530a = elementUtils.getTypeElement("com.bumptech.glide.Glide");
        this.f16531b = elementUtils.getTypeElement("com.bumptech.glide.manager.Lifecycle");
        this.f16532c = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerTreeNode");
        this.f16533d = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory");
        this.f16534e = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(elementUtils.getTypeElement("com.bumptech.glide.RequestManager"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec a(String str, TypeSpec typeSpec) {
        return TypeSpec.a("GeneratedRequestManagerFactory").x(Modifier.FINAL).y(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16533d)).u("Generated code, do not modify\n", new Object[0]).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("build").u(Modifier.PUBLIC).n(Override.class).m(i.H()).F(this.f16534e).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16530a), "glide", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16531b), "lifecycle", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f16532c), "treeNode", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(f16529f, "context", new Modifier[0]).e(i.H()).i()).y("return new $T(glide, lifecycle, treeNode, context)", com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, typeSpec.f17724b, new String[0])).C()).B();
    }
}
