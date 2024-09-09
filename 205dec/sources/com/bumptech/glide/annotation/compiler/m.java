package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestOptionsExtensionGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.l f16550a;

    /* renamed from: b  reason: collision with root package name */
    private i f16551b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, i iVar) {
        this.f16550a = lVar;
        this.f16551b = iVar;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.i b(ExecutableElement executableElement) {
        String str;
        if (executableElement.getReturnType().getKind() != TypeKind.VOID) {
            int w3 = this.f16551b.w(executableElement);
            String obj = executableElement.getSimpleName().toString();
            i.b l4 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(obj).u(Modifier.PUBLIC).s(this.f16551b.q(executableElement)).H(executableElement.isVarArgs()).F(this.f16550a).l(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "unchecked").f());
            List<? extends VariableElement> subList = executableElement.getParameters().subList(1, executableElement.getParameters().size());
            List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> y3 = i.y(subList);
            l4.x(y3);
            if (w3 == 1) {
                l4.s(this.f16551b.p(this.f16550a, obj, subList)).n(Override.class);
                ArrayList arrayList = new ArrayList();
                arrayList.add(executableElement.getSimpleName().toString());
                StringBuilder sb = new StringBuilder();
                if (!y3.isEmpty()) {
                    for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : y3) {
                        sb.append("$L, ");
                        arrayList.add(jVar.f17839a);
                    }
                    sb = new StringBuilder(sb.substring(0, sb.length() - 2));
                }
                d.b a4 = com.bumptech.glide.repackaged.com.squareup.javapoet.d.a();
                str = a4.b("super.$N(" + ((Object) sb) + ")", arrayList.toArray(new Object[0])).j().toString();
            } else {
                str = "this";
            }
            ArrayList arrayList2 = new ArrayList();
            StringBuilder sb2 = new StringBuilder("return ($T) $T.$L($L, ");
            arrayList2.add(this.f16550a);
            arrayList2.add(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(executableElement.getEnclosingElement().asType()));
            arrayList2.add(executableElement.getSimpleName().toString());
            arrayList2.add(str);
            if (!y3.isEmpty()) {
                for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar2 : y3) {
                    sb2.append("$L, ");
                    arrayList2.add(jVar2.f17839a);
                }
            }
            l4.y(sb2.substring(0, sb2.length() - 2) + ")", arrayList2.toArray(new Object[0]));
            l4.m(i.d()).m(i.H());
            return l4.C();
        }
        throw new IllegalArgumentException("The " + executableElement.getSimpleName() + " method annotated with @GlideOption in the " + executableElement.getEnclosingElement().getSimpleName() + " @GlideExtension is using a legacy format that is no longer supported. Please change your method definition so that your @GlideModule annotated methods return BaseRequestOptions<?> objects instead of null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> a(Set<String> set) {
        List<ExecutableElement> c4 = c(set);
        ArrayList arrayList = new ArrayList(c4.size());
        for (ExecutableElement executableElement : c4) {
            arrayList.add(b(executableElement));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExecutableElement> c(Set<String> set) {
        return this.f16551b.h(set, GlideOption.class);
    }
}
