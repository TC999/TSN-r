package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

/* compiled from: TypeVariableName.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class m extends l {

    /* renamed from: w  reason: collision with root package name */
    public final String f17874w;

    /* renamed from: x  reason: collision with root package name */
    public final List<l> f17875x;

    private m(String str, List<l> list) {
        this(str, list, new ArrayList());
    }

    public static m r(String str) {
        return y(str, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m s(TypeVariable<?> typeVariable, Map<Type, m> map) {
        m mVar = map.get(typeVariable);
        if (mVar == null) {
            ArrayList arrayList = new ArrayList();
            m mVar2 = new m(typeVariable.getName(), Collections.unmodifiableList(arrayList));
            map.put(typeVariable, mVar2);
            for (Type type : typeVariable.getBounds()) {
                arrayList.add(l.i(type, map));
            }
            arrayList.remove(l.f17859m);
            return mVar2;
        }
        return mVar;
    }

    public static m t(TypeParameterElement typeParameterElement) {
        String obj = typeParameterElement.getSimpleName().toString();
        List<TypeMirror> bounds = typeParameterElement.getBounds();
        ArrayList arrayList = new ArrayList();
        for (TypeMirror typeMirror : bounds) {
            arrayList.add(l.j(typeMirror));
        }
        return y(obj, arrayList);
    }

    public static m u(javax.lang.model.type.TypeVariable typeVariable) {
        return t(typeVariable.asElement());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m w(javax.lang.model.type.TypeVariable typeVariable, Map<TypeParameterElement, m> map) {
        TypeParameterElement typeParameterElement = (TypeParameterElement) typeVariable.asElement();
        m mVar = map.get(typeParameterElement);
        if (mVar == null) {
            ArrayList arrayList = new ArrayList();
            m mVar2 = new m(typeParameterElement.getSimpleName().toString(), Collections.unmodifiableList(arrayList));
            map.put(typeParameterElement, mVar2);
            for (TypeMirror typeMirror : typeParameterElement.getBounds()) {
                arrayList.add(l.k(typeMirror, map));
            }
            arrayList.remove(l.f17859m);
            return mVar2;
        }
        return mVar;
    }

    private static m y(String str, List<l> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.remove(l.f17859m);
        return new m(str, Collections.unmodifiableList(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public e f(e eVar) throws IOException {
        return eVar.d(this.f17874w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l p() {
        return new m(this.f17874w, this.f17875x);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: q */
    public m a(List<a> list) {
        return new m(this.f17874w, this.f17875x, list);
    }

    private m(String str, List<l> list, List<a> list2) {
        super(list2);
        this.f17874w = (String) n.c(str, "name == null", new Object[0]);
        this.f17875x = list;
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            l next = it.next();
            n.b((next.n() || next == l.f17850d) ? false : true, "invalid bound: %s", next);
        }
    }
}
