package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.a;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* compiled from: IndexerGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private final i f16487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(i iVar) {
        this.f16487a = iVar;
    }

    private static TypeSpec b(List<TypeElement> list, Class<? extends Annotation> cls) {
        a.b b4 = com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(Index.class);
        String c4 = c(cls);
        Iterator<TypeElement> it = list.iterator();
        while (it.hasNext()) {
            b4.d(c4, "$S", com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(it.next()).toString());
        }
        StringBuilder sb = new StringBuilder("GlideIndexer_" + cls.getSimpleName() + "_");
        for (TypeElement typeElement : list) {
            sb.append(typeElement.getQualifiedName().toString().replace(".", "_"));
            sb.append("_");
        }
        return TypeSpec.a(new StringBuilder(sb.substring(0, sb.length() - 1)).toString()).q(b4.f()).x(Modifier.PUBLIC).B();
    }

    private static String c(Class<? extends Annotation> cls) {
        if (cls == GlideModule.class) {
            return "modules";
        }
        if (cls == GlideExtension.class) {
            return "extensions";
        }
        throw new IllegalArgumentException("Unrecognized annotation: " + cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec a(List<TypeElement> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TypeElement typeElement : list) {
            if (this.f16487a.D(typeElement)) {
                arrayList2.add(typeElement);
            } else if (this.f16487a.E(typeElement)) {
                arrayList.add(typeElement);
            } else {
                throw new IllegalArgumentException("Unrecognized type: " + typeElement);
            }
        }
        if (!arrayList.isEmpty() && !arrayList2.isEmpty()) {
            throw new IllegalArgumentException("Given both modules and extensions, expected one or the other. Modules: " + arrayList + " Extensions: " + arrayList2);
        } else if (!arrayList.isEmpty()) {
            return b(list, GlideModule.class);
        } else {
            return b(list, GlideExtension.class);
        }
    }
}
