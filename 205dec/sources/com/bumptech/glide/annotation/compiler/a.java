package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.Excludes;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppModuleGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final i f16456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(i iVar) {
        this.f16456a = iVar;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i b(com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar, Collection<String> collection, Collection<String> collection2) {
        i.b a4 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.a();
        a4.y("appGlideModule = new $T()", cVar);
        com.bumptech.glide.repackaged.com.squareup.javapoet.c w3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.util", "Log", new String[0]);
        a4.B("if ($T.isLoggable($S, $T.DEBUG))", w3, "Glide", w3);
        a4.y("$T.d($S, $S)", w3, "Glide", "Discovered AppGlideModule from annotation: " + cVar);
        for (String str : collection) {
            if (collection2.contains(str)) {
                a4.y("$T.d($S, $S)", w3, "Glide", "AppGlideModule excludes LibraryGlideModule from annotation: " + str);
            } else {
                a4.y("$T.d($S, $S)", w3, "Glide", "Discovered LibraryGlideModule from annotation: " + str);
            }
        }
        a4.D();
        return a4.C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i c(Collection<String> collection) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r3 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(Class.class), com.bumptech.glide.repackaged.com.squareup.javapoet.o.u(Object.class));
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r4 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(Set.class), r3);
        com.bumptech.glide.repackaged.com.squareup.javapoet.k r5 = com.bumptech.glide.repackaged.com.squareup.javapoet.k.r(com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(HashSet.class), r3);
        i.b F = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("getExcludedModuleClasses").u(Modifier.PUBLIC).n(Override.class).m(i.H()).F(r4);
        if (collection.isEmpty()) {
            F.y("return $T.emptySet()", Collections.class);
        } else {
            F.y("$T excludedClasses = new $T()", r4, r5);
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                F.y("excludedClasses.add($L.class)", it.next());
            }
            F.y("return excludedClasses", new Object[0]);
        }
        return F.C();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i d(Collection<String> collection, Collection<String> collection2) {
        i.b v3 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("registerComponents").u(Modifier.PUBLIC).n(Override.class).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.content", "Context", new String[0]), "context", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "Glide", new String[0]), "glide", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "Registry", new String[0]), "registry", new Modifier[0]).e(i.H()).i());
        for (String str : collection) {
            if (!collection2.contains(str)) {
                v3.y("new $T().registerComponents(context, glide, registry)", com.bumptech.glide.repackaged.com.squareup.javapoet.c.r(str));
            }
        }
        v3.y("appGlideModule.registerComponents(context, glide, registry)", new Object[0]);
        return v3.C();
    }

    private List<String> e(TypeElement typeElement) {
        ArrayList arrayList = new ArrayList(this.f16456a.i(typeElement, Excludes.class));
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec a(TypeElement typeElement, Set<String> set) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c y3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(typeElement);
        List<String> e4 = e(typeElement);
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        com.bumptech.glide.repackaged.com.squareup.javapoet.i b4 = b(y3, arrayList, e4);
        com.bumptech.glide.repackaged.com.squareup.javapoet.i d4 = d(arrayList, e4);
        TypeSpec.b v3 = TypeSpec.a("GeneratedAppGlideModuleImpl").x(Modifier.FINAL).q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "deprecation").f()).C(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "GeneratedAppGlideModule", new String[0])).s(y3, "appGlideModule", Modifier.PRIVATE, Modifier.FINAL).v(b4).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("applyOptions").u(Modifier.PUBLIC).n(Override.class).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.content", "Context", new String[0]), "context", new Modifier[0]).e(i.H()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "GlideBuilder", new String[0]), "builder", new Modifier[0]).e(i.H()).i()).y("appGlideModule.applyOptions(context, builder)", typeElement).C()).v(d4).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("isManifestParsingEnabled").u(Modifier.PUBLIC).n(Override.class).G(Boolean.TYPE).y("return appGlideModule.isManifestParsingEnabled()", typeElement).C()).v(c(e4));
        com.bumptech.glide.repackaged.com.squareup.javapoet.c w3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide", "GeneratedRequestManagerFactory", new String[0]);
        v3.v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("getRequestManagerFactory").n(Override.class).m(i.H()).F(w3).y("return new $T()", w3).C());
        return v3.B();
    }
}
