package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ParameterizedTypeName.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class k extends l {

    /* renamed from: w  reason: collision with root package name */
    private final k f17847w;

    /* renamed from: x  reason: collision with root package name */
    public final c f17848x;

    /* renamed from: y  reason: collision with root package name */
    public final List<l> f17849y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(k kVar, c cVar, List<l> list) {
        this(kVar, cVar, list, new ArrayList());
    }

    public static k r(c cVar, l... lVarArr) {
        return new k(null, cVar, Arrays.asList(lVarArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k s(ParameterizedType parameterizedType, Map<Type, m> map) {
        c u3 = c.u((Class) parameterizedType.getRawType());
        ParameterizedType parameterizedType2 = (!(parameterizedType.getOwnerType() instanceof ParameterizedType) || Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) ? null : (ParameterizedType) parameterizedType.getOwnerType();
        List<l> o4 = l.o(parameterizedType.getActualTypeArguments(), map);
        if (parameterizedType2 != null) {
            return s(parameterizedType2, map).t(u3.E(), o4);
        }
        return new k(null, u3, o4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public e f(e eVar) throws IOException {
        k kVar = this.f17847w;
        if (kVar != null) {
            kVar.g(eVar);
            this.f17847w.f(eVar);
            eVar.b("." + this.f17848x.E());
        } else {
            this.f17848x.g(eVar);
            this.f17848x.f(eVar);
        }
        if (!this.f17849y.isEmpty()) {
            eVar.d("<");
            boolean z3 = true;
            for (l lVar : this.f17849y) {
                if (!z3) {
                    eVar.d(", ");
                }
                lVar.g(eVar);
                lVar.f(eVar);
                z3 = false;
            }
            eVar.d(">");
        }
        return eVar;
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l p() {
        return new k(this.f17847w, this.f17848x, this.f17849y, new ArrayList());
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: q */
    public k a(List<a> list) {
        return new k(this.f17847w, this.f17848x, this.f17849y, e(list));
    }

    public k t(String str, List<l> list) {
        n.c(str, "name == null", new Object[0]);
        return new k(this, this.f17848x.B(str), list, new ArrayList());
    }

    private k(k kVar, c cVar, List<l> list, List<a> list2) {
        super(list2);
        this.f17848x = (c) n.c(cVar, "rawType == null", new Object[0]);
        this.f17847w = kVar;
        List<l> f4 = n.f(list);
        this.f17849y = f4;
        n.b((f4.isEmpty() && kVar == null) ? false : true, "no type arguments: %s", cVar);
        Iterator<l> it = f4.iterator();
        while (it.hasNext()) {
            l next = it.next();
            n.b((next.n() || next == l.f17850d) ? false : true, "invalid type parameter: %s", next);
        }
    }
}
