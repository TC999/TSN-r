package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/* compiled from: AnnotationSpec.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final l f17755a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<d>> f17756b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnotationSpec.java */
    /* renamed from: com.bumptech.glide.repackaged.com.squareup.javapoet.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public final class C0183a implements Comparator<Method> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Method method, Method method2) {
            return method.getName().compareTo(method2.getName());
        }
    }

    /* compiled from: AnnotationSpec.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final l f17757a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, List<d>> f17758b;

        /* synthetic */ b(l lVar, C0183a c0183a) {
            this(lVar);
        }

        public b c(String str, d dVar) {
            List<d> list = this.f17758b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f17758b.put(str, list);
            }
            list.add(dVar);
            return this;
        }

        public b d(String str, String str2, Object... objArr) {
            return c(str, d.c(str2, objArr));
        }

        b e(String str, Object obj) {
            n.c(str, "memberName == null", new Object[0]);
            n.c(obj, "value == null, constant non-null value expected for %s", str);
            if (obj instanceof Class) {
                return d(str, "$T.class", obj);
            }
            if (obj instanceof Enum) {
                return d(str, "$T.$L", obj.getClass(), ((Enum) obj).name());
            }
            if (obj instanceof String) {
                return d(str, "$S", obj);
            }
            if (obj instanceof Float) {
                return d(str, "$Lf", obj);
            }
            return obj instanceof Character ? d(str, "'$L'", n.a(((Character) obj).charValue())) : d(str, "$L", obj);
        }

        public a f() {
            return new a(this, null);
        }

        private b(l lVar) {
            this.f17758b = new LinkedHashMap();
            this.f17757a = lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnnotationSpec.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class c extends SimpleAnnotationValueVisitor7<b, String> {

        /* renamed from: a  reason: collision with root package name */
        final b f17759a;

        c(b bVar) {
            super(bVar);
            this.f17759a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public b b(Object obj, String str) {
            return this.f17759a.e(str, obj);
        }

        /* renamed from: c */
        public b d(AnnotationMirror annotationMirror, String str) {
            return this.f17759a.d(str, "$L", a.e(annotationMirror));
        }

        /* renamed from: e */
        public b f(List<? extends AnnotationValue> list, String str) {
            for (AnnotationValue annotationValue : list) {
                annotationValue.accept(this, str);
            }
            return this.f17759a;
        }

        /* renamed from: g */
        public b h(VariableElement variableElement, String str) {
            return this.f17759a.d(str, "$T.$L", variableElement.asType(), variableElement.getSimpleName());
        }

        /* renamed from: i */
        public b j(TypeMirror typeMirror, String str) {
            return this.f17759a.d(str, "$T.class", typeMirror);
        }
    }

    /* synthetic */ a(b bVar, C0183a c0183a) {
        this(bVar);
    }

    public static b a(com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar) {
        n.c(cVar, "type == null", new Object[0]);
        return new b(cVar, null);
    }

    public static b b(Class<?> cls) {
        return a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.u(cls));
    }

    private void d(e eVar, String str, String str2, List<d> list) throws IOException {
        boolean z3 = true;
        if (list.size() == 1) {
            eVar.s(2);
            eVar.a(list.get(0));
            eVar.C(2);
            return;
        }
        eVar.b("{" + str);
        eVar.s(2);
        for (d dVar : list) {
            if (!z3) {
                eVar.b(str2);
            }
            eVar.a(dVar);
            z3 = false;
        }
        eVar.C(2);
        eVar.b(str + "}");
    }

    public static a e(AnnotationMirror annotationMirror) {
        b a4 = a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(annotationMirror.getAnnotationType().asElement()));
        c cVar = new c(a4);
        for (ExecutableElement executableElement : annotationMirror.getElementValues().keySet()) {
            ((AnnotationValue) annotationMirror.getElementValues().get(executableElement)).accept(cVar, executableElement.getSimpleName().toString());
        }
        return a4.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(e eVar, boolean z3) throws IOException {
        String str = z3 ? "" : "\n";
        String str2 = z3 ? ", " : ",\n";
        if (this.f17756b.isEmpty()) {
            eVar.c("@$T", this.f17755a);
        } else if (this.f17756b.size() == 1 && this.f17756b.containsKey("value")) {
            eVar.c("@$T(", this.f17755a);
            d(eVar, str, str2, this.f17756b.get("value"));
            eVar.b(")");
        } else {
            eVar.c("@$T(" + str, this.f17755a);
            eVar.s(2);
            Iterator<Map.Entry<String, List<d>>> it = this.f17756b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<d>> next = it.next();
                eVar.c("$L = ", next.getKey());
                d(eVar, str, str2, next.getValue());
                if (it.hasNext()) {
                    eVar.b(str2);
                }
            }
            eVar.C(2);
            eVar.b(str + ")");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new e(stringWriter).c("$L", this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private a(b bVar) {
        this.f17755a = bVar.f17757a;
        this.f17756b = n.h(bVar.f17758b);
    }
}
