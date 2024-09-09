package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

/* compiled from: ArrayTypeName.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class b extends l {

    /* renamed from: w  reason: collision with root package name */
    public final l f17760w;

    private b(l lVar) {
        this(lVar, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b r(GenericArrayType genericArrayType, Map<Type, m> map) {
        return t(l.i(genericArrayType.getGenericComponentType(), map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b s(ArrayType arrayType, Map<TypeParameterElement, m> map) {
        return new b(l.k(arrayType.getComponentType(), map));
    }

    public static b t(l lVar) {
        return new b(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public e f(e eVar) throws IOException {
        return eVar.c("$T[]", this.f17760w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l p() {
        return new b(this.f17760w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: q */
    public b a(List<a> list) {
        return new b(this.f17760w, e(list));
    }

    private b(l lVar, List<a> list) {
        super(list);
        this.f17760w = (l) n.c(lVar, "rawType == null", new Object[0]);
    }
}
