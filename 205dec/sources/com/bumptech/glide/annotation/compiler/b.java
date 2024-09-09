package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* compiled from: AppModuleProcessor.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class b {

    /* renamed from: j  reason: collision with root package name */
    private static final String f16457j = d.class.getPackage().getName();

    /* renamed from: a  reason: collision with root package name */
    private final ProcessingEnvironment f16458a;

    /* renamed from: b  reason: collision with root package name */
    private final i f16459b;

    /* renamed from: c  reason: collision with root package name */
    private final List<TypeElement> f16460c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final n f16461d;

    /* renamed from: e  reason: collision with root package name */
    private final l f16462e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bumptech.glide.annotation.compiler.a f16463f;

    /* renamed from: g  reason: collision with root package name */
    private final j f16464g;

    /* renamed from: h  reason: collision with root package name */
    private final k f16465h;

    /* renamed from: i  reason: collision with root package name */
    private final f f16466i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppModuleProcessor.java */
    /* renamed from: com.bumptech.glide.annotation.compiler.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class C0162b {

        /* renamed from: a  reason: collision with root package name */
        private final Set<String> f16467a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<String> f16468b;

        private C0162b(Set<String> set, Set<String> set2) {
            this.f16467a = set;
            this.f16468b = set2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16458a = processingEnvironment;
        this.f16459b = iVar;
        this.f16463f = new com.bumptech.glide.annotation.compiler.a(iVar);
        this.f16461d = new n(processingEnvironment, iVar);
        this.f16462e = new l(processingEnvironment, iVar);
        this.f16465h = new k(processingEnvironment);
        this.f16466i = new f(processingEnvironment, iVar);
        this.f16464g = new j(processingEnvironment, iVar);
    }

    private String a(TypeElement typeElement) {
        return ((GlideModule) typeElement.getAnnotation(GlideModule.class)).glideName();
    }

    private C0162b b(PackageElement packageElement) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Element element : packageElement.getEnclosedElements()) {
            Index index = (Index) element.getAnnotation(Index.class);
            if (index != null) {
                Collections.addAll(hashSet, index.modules());
                Collections.addAll(hashSet2, index.extensions());
            }
        }
        i iVar = this.f16459b;
        iVar.f("Found GlideModules: " + hashSet);
        return new C0162b(hashSet, hashSet2);
    }

    private void e(TypeSpec typeSpec) {
        this.f16459b.L("com.bumptech.glide", typeSpec);
    }

    private void f(String str, TypeSpec typeSpec) {
        this.f16459b.L(str, typeSpec);
    }

    private void g(String str, TypeSpec typeSpec) {
        this.f16459b.L(str, typeSpec);
    }

    private void h(String str, TypeSpec typeSpec) {
        this.f16459b.L(str, typeSpec);
    }

    private void i(TypeSpec typeSpec) {
        this.f16459b.L("com.bumptech.glide", typeSpec);
    }

    private void j(String str, TypeSpec typeSpec) {
        this.f16459b.L(str, typeSpec);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        if (this.f16460c.isEmpty()) {
            return false;
        }
        TypeElement typeElement = this.f16460c.get(0);
        i iVar = this.f16459b;
        iVar.f("Processing app module: " + typeElement);
        C0162b b4 = b(this.f16458a.getElementUtils().getPackageElement(f16457j));
        String obj = typeElement.getEnclosingElement().toString();
        TypeSpec d4 = this.f16461d.d(obj, b4.f16468b);
        j(obj, d4);
        TypeSpec e4 = this.f16464g.e(obj, b4.f16468b, d4);
        g(obj, e4);
        TypeSpec d5 = this.f16462e.d(obj, d4, e4, b4.f16468b);
        h(obj, d5);
        i(this.f16465h.a(obj, d5));
        f(obj, this.f16466i.f(obj, a(typeElement), d5));
        e(this.f16463f.a(typeElement, b4.f16467a));
        i iVar2 = this.f16459b;
        iVar2.B("Wrote GeneratedAppGlideModule with: " + b4.f16467a);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement typeElement : this.f16459b.t(GlideModule.class, roundEnvironment)) {
            if (this.f16459b.C(typeElement)) {
                this.f16460c.add(typeElement);
            }
        }
        i iVar = this.f16459b;
        iVar.f("got app modules: " + this.f16460c);
        if (this.f16460c.size() <= 1) {
            return;
        }
        throw new IllegalStateException("You cannot have more than one AppGlideModule, found: " + this.f16460c);
    }
}
