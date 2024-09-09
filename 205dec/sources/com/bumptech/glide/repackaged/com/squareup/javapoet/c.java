package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* compiled from: ClassName.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class c extends l implements Comparable<c> {

    /* renamed from: y  reason: collision with root package name */
    public static final c f17761y = u(Object.class);

    /* renamed from: w  reason: collision with root package name */
    final List<String> f17762w;

    /* renamed from: x  reason: collision with root package name */
    final String f17763x;

    private c(List<String> list) {
        this(list, new ArrayList());
    }

    private static boolean A(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    public static c r(String str) {
        String[] split;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < str.length() && Character.isLowerCase(str.codePointAt(i4))) {
            i4 = str.indexOf(46, i4) + 1;
            n.b(i4 != 0, "couldn't make a guess for %s", str);
        }
        arrayList.add(i4 != 0 ? str.substring(0, i4 - 1) : "");
        for (String str2 : str.substring(i4).split("\\.", -1)) {
            n.b(!str2.isEmpty() && Character.isUpperCase(str2.codePointAt(0)), "couldn't make a guess for %s", str);
            arrayList.add(str2);
        }
        n.b(arrayList.size() >= 2, "couldn't make a guess for %s", str);
        return new c(arrayList);
    }

    public static c u(Class<?> cls) {
        n.c(cls, "clazz == null", new Object[0]);
        n.b(!cls.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        n.b(!Void.TYPE.equals(cls), "'void' type cannot be represented as a ClassName", new Object[0]);
        n.b(!cls.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (cls.isAnonymousClass()) {
                int lastIndexOf = cls.getName().lastIndexOf(46);
                if (lastIndexOf != -1) {
                    String substring = cls.getName().substring(lastIndexOf + 1);
                    arrayList.add(substring.substring(substring.lastIndexOf(36)));
                }
            } else {
                arrayList.add(cls.getSimpleName());
            }
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null) {
                break;
            }
            cls = enclosingClass;
        }
        int lastIndexOf2 = cls.getName().lastIndexOf(46);
        if (lastIndexOf2 != -1) {
            arrayList.add(cls.getName().substring(0, lastIndexOf2));
        }
        Collections.reverse(arrayList);
        return new c(arrayList);
    }

    public static c w(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        Collections.addAll(arrayList, strArr);
        return new c(arrayList);
    }

    public static c y(TypeElement typeElement) {
        n.c(typeElement, "element == null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (TypeElement typeElement2 = typeElement; A(typeElement2); typeElement2 = typeElement2.getEnclosingElement()) {
            n.b(typeElement.getNestingKind() == NestingKind.TOP_LEVEL || typeElement.getNestingKind() == NestingKind.MEMBER, "unexpected type testing", new Object[0]);
            arrayList.add(typeElement2.getSimpleName().toString());
        }
        arrayList.add(z(typeElement).getQualifiedName().toString());
        Collections.reverse(arrayList);
        return new c(arrayList);
    }

    private static PackageElement z(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public c B(String str) {
        n.c(str, "name == null", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f17762w.size() + 1);
        arrayList.addAll(this.f17762w);
        arrayList.add(str);
        return new c(arrayList);
    }

    public String C() {
        return this.f17762w.get(0);
    }

    public String D() {
        if (this.f17762w.size() == 2) {
            String C = C();
            if (C.isEmpty()) {
                return this.f17762w.get(1);
            }
            return C + "." + this.f17762w.get(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(G());
        for (String str : F().subList(1, F().size())) {
            sb.append('$');
            sb.append(str);
        }
        return sb.toString();
    }

    public String E() {
        List<String> list = this.f17762w;
        return list.get(list.size() - 1);
    }

    public List<String> F() {
        List<String> list = this.f17762w;
        return list.subList(1, list.size());
    }

    public c G() {
        return new c(this.f17762w.subList(0, 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public e f(e eVar) throws IOException {
        return eVar.d(eVar.t(this));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l p() {
        return new c(this.f17762w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: q */
    public c a(List<a> list) {
        return new c(this.f17762w, e(list));
    }

    @Override // java.lang.Comparable
    /* renamed from: s */
    public int compareTo(c cVar) {
        return this.f17763x.compareTo(cVar.f17763x);
    }

    public c t() {
        if (this.f17762w.size() == 2) {
            return null;
        }
        List<String> list = this.f17762w;
        return new c(list.subList(0, list.size() - 1));
    }

    private c(List<String> list, List<a> list2) {
        super(list2);
        String j4;
        for (int i4 = 1; i4 < list.size(); i4++) {
            n.b(SourceVersion.isName(list.get(i4)), "part '%s' is keyword", list.get(i4));
        }
        this.f17762w = n.f(list);
        if (list.get(0).isEmpty()) {
            j4 = n.j(".", list.subList(1, list.size()));
        } else {
            j4 = n.j(".", list);
        }
        this.f17763x = j4.replace(".$", "$");
    }
}
