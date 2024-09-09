package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

/* compiled from: WildcardTypeName.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class o extends l {

    /* renamed from: w  reason: collision with root package name */
    public final List<l> f17877w;

    /* renamed from: x  reason: collision with root package name */
    public final List<l> f17878x;

    private o(List<l> list, List<l> list2) {
        this(list, list2, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l r(WildcardType wildcardType, Map<Type, m> map) {
        return new o(l.o(wildcardType.getUpperBounds(), map), l.o(wildcardType.getLowerBounds(), map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l s(javax.lang.model.type.WildcardType wildcardType, Map<TypeParameterElement, m> map) {
        TypeMirror extendsBound = wildcardType.getExtendsBound();
        if (extendsBound == null) {
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return u(Object.class);
            }
            return w(l.k(superBound, map));
        }
        return t(l.k(extendsBound, map));
    }

    public static o t(l lVar) {
        return new o(Arrays.asList(lVar), Collections.emptyList());
    }

    public static o u(Type type) {
        return t(l.h(type));
    }

    public static o w(l lVar) {
        return new o(Arrays.asList(l.f17859m), Arrays.asList(lVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public e f(e eVar) throws IOException {
        return this.f17878x.size() == 1 ? eVar.c("? super $T", this.f17878x.get(0)) : this.f17877w.get(0).equals(l.f17859m) ? eVar.b("?") : eVar.c("? extends $T", this.f17877w.get(0));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l p() {
        return new o(this.f17877w, this.f17878x);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: q */
    public o a(List<a> list) {
        return new o(this.f17877w, this.f17878x, e(list));
    }

    private o(List<l> list, List<l> list2, List<a> list3) {
        super(list3);
        List<l> f4 = n.f(list);
        this.f17877w = f4;
        this.f17878x = n.f(list2);
        n.b(f4.size() == 1, "unexpected extends bounds: %s", list);
        Iterator<l> it = f4.iterator();
        while (it.hasNext()) {
            l next = it.next();
            n.b((next.n() || next == l.f17850d) ? false : true, "invalid upper bound: %s", next);
        }
        Iterator<l> it2 = this.f17878x.iterator();
        while (it2.hasNext()) {
            l next2 = it2.next();
            n.b((next2.n() || next2 == l.f17850d) ? false : true, "invalid lower bound: %s", next2);
        }
    }
}
