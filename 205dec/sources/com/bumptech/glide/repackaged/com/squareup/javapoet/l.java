package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;

/* compiled from: TypeName.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class l {

    /* renamed from: d  reason: collision with root package name */
    public static final l f17850d = new l("void");

    /* renamed from: e  reason: collision with root package name */
    public static final l f17851e = new l("boolean");

    /* renamed from: f  reason: collision with root package name */
    public static final l f17852f = new l("byte");

    /* renamed from: g  reason: collision with root package name */
    public static final l f17853g = new l("short");

    /* renamed from: h  reason: collision with root package name */
    public static final l f17854h = new l("int");

    /* renamed from: i  reason: collision with root package name */
    public static final l f17855i = new l("long");

    /* renamed from: j  reason: collision with root package name */
    public static final l f17856j = new l("char");

    /* renamed from: k  reason: collision with root package name */
    public static final l f17857k = new l("float");

    /* renamed from: l  reason: collision with root package name */
    public static final l f17858l = new l("double");

    /* renamed from: m  reason: collision with root package name */
    public static final c f17859m = c.w("java.lang", "Object", new String[0]);

    /* renamed from: n  reason: collision with root package name */
    private static final c f17860n = c.w("java.lang", "Void", new String[0]);

    /* renamed from: o  reason: collision with root package name */
    private static final c f17861o = c.w("java.lang", "Boolean", new String[0]);

    /* renamed from: p  reason: collision with root package name */
    private static final c f17862p = c.w("java.lang", "Byte", new String[0]);

    /* renamed from: q  reason: collision with root package name */
    private static final c f17863q = c.w("java.lang", "Short", new String[0]);

    /* renamed from: r  reason: collision with root package name */
    private static final c f17864r = c.w("java.lang", "Integer", new String[0]);

    /* renamed from: s  reason: collision with root package name */
    private static final c f17865s = c.w("java.lang", "Long", new String[0]);

    /* renamed from: t  reason: collision with root package name */
    private static final c f17866t = c.w("java.lang", "Character", new String[0]);

    /* renamed from: u  reason: collision with root package name */
    private static final c f17867u = c.w("java.lang", "Float", new String[0]);

    /* renamed from: v  reason: collision with root package name */
    private static final c f17868v = c.w("java.lang", "Double", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final String f17869a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f17870b;

    /* renamed from: c  reason: collision with root package name */
    private String f17871c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeName.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public final class a extends SimpleTypeVisitor7<l, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f17872a;

        a(Map map) {
            this.f17872a = map;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public l b(TypeMirror typeMirror, Void r4) {
            throw new IllegalArgumentException("Unexpected type mirror: " + typeMirror);
        }

        /* renamed from: c */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.b d(ArrayType arrayType, Void r22) {
            return com.bumptech.glide.repackaged.com.squareup.javapoet.b.s(arrayType, this.f17872a);
        }

        /* renamed from: e */
        public l f(DeclaredType declaredType, Void r7) {
            c y3 = c.y(declaredType.asElement());
            TypeMirror enclosingType = declaredType.getEnclosingType();
            l lVar = (enclosingType.getKind() == TypeKind.NONE || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) ? null : (l) enclosingType.accept(this, (Object) null);
            if (!declaredType.getTypeArguments().isEmpty() || (lVar instanceof k)) {
                ArrayList arrayList = new ArrayList();
                for (TypeMirror typeMirror : declaredType.getTypeArguments()) {
                    arrayList.add(l.k(typeMirror, this.f17872a));
                }
                if (lVar instanceof k) {
                    return ((k) lVar).t(y3.E(), arrayList);
                }
                return new k(null, y3, arrayList);
            }
            return y3;
        }

        /* renamed from: g */
        public l h(ErrorType errorType, Void r22) {
            return f(errorType, r22);
        }

        /* renamed from: i */
        public l j(NoType noType, Void r4) {
            return noType.getKind() == TypeKind.VOID ? l.f17850d : (l) super.visitUnknown(noType, r4);
        }

        /* renamed from: k */
        public l l(PrimitiveType primitiveType, Void r22) {
            switch (b.f17873a[primitiveType.getKind().ordinal()]) {
                case 1:
                    return l.f17851e;
                case 2:
                    return l.f17852f;
                case 3:
                    return l.f17853g;
                case 4:
                    return l.f17854h;
                case 5:
                    return l.f17855i;
                case 6:
                    return l.f17856j;
                case 7:
                    return l.f17857k;
                case 8:
                    return l.f17858l;
                default:
                    throw new AssertionError();
            }
        }

        /* renamed from: m */
        public l n(TypeVariable typeVariable, Void r22) {
            return m.w(typeVariable, this.f17872a);
        }

        /* renamed from: o */
        public l p(WildcardType wildcardType, Void r22) {
            return o.s(wildcardType, this.f17872a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeName.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17873a;

        static {
            int[] iArr = new int[TypeKind.values().length];
            f17873a = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17873a[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17873a[TypeKind.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17873a[TypeKind.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17873a[TypeKind.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17873a[TypeKind.CHAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17873a[TypeKind.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17873a[TypeKind.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private l(String str) {
        this(str, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l d(l lVar) {
        if (lVar instanceof com.bumptech.glide.repackaged.com.squareup.javapoet.b) {
            return ((com.bumptech.glide.repackaged.com.squareup.javapoet.b) lVar).f17760w;
        }
        return null;
    }

    public static l h(Type type) {
        return i(type, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l i(Type type, Map<Type, m> map) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return type == Void.TYPE ? f17850d : type == Boolean.TYPE ? f17851e : type == Byte.TYPE ? f17852f : type == Short.TYPE ? f17853g : type == Integer.TYPE ? f17854h : type == Long.TYPE ? f17855i : type == Character.TYPE ? f17856j : type == Float.TYPE ? f17857k : type == Double.TYPE ? f17858l : cls.isArray() ? com.bumptech.glide.repackaged.com.squareup.javapoet.b.t(i(cls.getComponentType(), map)) : c.u(cls);
        } else if (type instanceof ParameterizedType) {
            return k.s((ParameterizedType) type, map);
        } else {
            if (type instanceof java.lang.reflect.WildcardType) {
                return o.r((java.lang.reflect.WildcardType) type, map);
            }
            if (type instanceof java.lang.reflect.TypeVariable) {
                return m.s((java.lang.reflect.TypeVariable) type, map);
            }
            if (type instanceof GenericArrayType) {
                return com.bumptech.glide.repackaged.com.squareup.javapoet.b.r((GenericArrayType) type, map);
            }
            throw new IllegalArgumentException("unexpected type: " + type);
        }
    }

    public static l j(TypeMirror typeMirror) {
        return k(typeMirror, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l k(TypeMirror typeMirror, Map<TypeParameterElement, m> map) {
        return (l) typeMirror.accept(new a(map), (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<l> o(Type[] typeArr, Map<Type, m> map) {
        ArrayList arrayList = new ArrayList(typeArr.length);
        for (Type type : typeArr) {
            arrayList.add(i(type, map));
        }
        return arrayList;
    }

    public l a(List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        n.c(list, "annotations == null", new Object[0]);
        return new l(this.f17869a, e(list));
    }

    public final l b(com.bumptech.glide.repackaged.com.squareup.javapoet.a... aVarArr) {
        return a(Arrays.asList(aVarArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> e(List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        ArrayList arrayList = new ArrayList(this.f17870b);
        arrayList.addAll(list);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e f(e eVar) throws IOException {
        String str = this.f17869a;
        if (str != null) {
            return eVar.d(str);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e g(e eVar) throws IOException {
        for (com.bumptech.glide.repackaged.com.squareup.javapoet.a aVar : this.f17870b) {
            aVar.c(eVar, true);
            eVar.b(" ");
        }
        return eVar;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public boolean l() {
        return !this.f17870b.isEmpty();
    }

    public boolean m() {
        return equals(f17861o) || equals(f17862p) || equals(f17863q) || equals(f17864r) || equals(f17865s) || equals(f17866t) || equals(f17867u) || equals(f17868v);
    }

    public boolean n() {
        return (this.f17869a == null || this == f17850d) ? false : true;
    }

    public l p() {
        return new l(this.f17869a);
    }

    public final String toString() {
        String str = this.f17871c;
        if (str == null) {
            try {
                StringBuilder sb = new StringBuilder();
                e eVar = new e(sb);
                g(eVar);
                f(eVar);
                String sb2 = sb.toString();
                this.f17871c = sb2;
                return sb2;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }
        return str;
    }

    private l(String str, List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        this.f17869a = str;
        this.f17870b = n.f(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        this(null, list);
    }
}
