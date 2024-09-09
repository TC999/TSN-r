package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Type;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProcessorUtil.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class i {

    /* renamed from: e  reason: collision with root package name */
    private static final String f16490e = com.bumptech.glide.annotation.compiler.d.class.getPackage().getName();

    /* renamed from: f  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16491f = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.support.annotation", "NonNull", new String[0]);

    /* renamed from: g  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16492g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("org.jetbrains.annotations", "NotNull", new String[0]);

    /* renamed from: h  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16493h = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("androidx.annotation", "NonNull", new String[0]);

    /* renamed from: i  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16494i = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("android.support.annotation", "CheckResult", new String[0]);

    /* renamed from: j  reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16495j = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("androidx.annotation", "CheckResult", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final ProcessingEnvironment f16496a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeElement f16497b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeElement f16498c;

    /* renamed from: d  reason: collision with root package name */
    private int f16499d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProcessorUtil.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a implements com.bumptech.glide.repackaged.com.google.common.base.a<VariableElement, Object> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public Object apply(VariableElement variableElement) {
            return i.this.v(variableElement);
        }
    }

    /* compiled from: ProcessorUtil.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, Object> {
        b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public Object apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f17842d;
        }
    }

    /* compiled from: ProcessorUtil.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class c implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f17839a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProcessorUtil.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public enum e {
        STATIC,
        INSTANCE
    }

    /* compiled from: ProcessorUtil.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static final class f implements com.bumptech.glide.repackaged.com.google.common.base.a<Element, ExecutableElement> {
        private f() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public ExecutableElement apply(Element element) {
            return (ExecutableElement) element;
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ProcessingEnvironment processingEnvironment) {
        this.f16496a = processingEnvironment;
        this.f16497b = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.module.AppGlideModule");
        this.f16498c = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.module.LibraryGlideModule");
    }

    private static String A(VariableElement variableElement) {
        for (AnnotationMirror annotationMirror : variableElement.getAnnotationMirrors()) {
            String upperCase = annotationMirror.getAnnotationType().toString().toUpperCase();
            if (upperCase.endsWith("RES")) {
                return "id";
            }
            if (upperCase.endsWith("RANGE")) {
                return "value";
            }
        }
        return variableElement.getSimpleName().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G(ExecutableElement executableElement, TypeMirror typeMirror) {
        return this.f16496a.getTypeUtils().isAssignable(executableElement.getReturnType(), typeMirror);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bumptech.glide.repackaged.com.squareup.javapoet.c H() {
        try {
            com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar = f16493h;
            Class.forName(cVar.D());
            return cVar;
        } catch (ClassNotFoundException unused) {
            return f16491f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<com.bumptech.glide.repackaged.com.squareup.javapoet.c> I() {
        return Arrays.asList(f16491f, f16492g, f16493h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i.b J(ExecutableElement executableElement) {
        Modifier modifier;
        i.b n4 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).n(Override.class);
        LinkedHashSet linkedHashSet = new LinkedHashSet(executableElement.getModifiers());
        linkedHashSet.remove(Modifier.ABSTRACT);
        try {
            modifier = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
            modifier = null;
        }
        linkedHashSet.remove(modifier);
        i.b t3 = n4.t(linkedHashSet);
        for (TypeParameterElement typeParameterElement : executableElement.getTypeParameters()) {
            t3 = t3.z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.u(typeParameterElement.asType()));
        }
        i.b H = t3.F(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(executableElement.getReturnType())).x(z(executableElement)).H(executableElement.isVarArgs());
        for (TypeMirror typeMirror : executableElement.getThrownTypes()) {
            H = H.r(com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(typeMirror));
        }
        return H;
    }

    private static String c(String str) {
        return str.replace("[]", "s").replace(Class.class.getSimpleName(), "clazz").replace(Object.class.getSimpleName(), "o");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bumptech.glide.repackaged.com.squareup.javapoet.c d() {
        try {
            com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar = f16495j;
            Class.forName(cVar.D());
            return cVar;
        } catch (ClassNotFoundException unused) {
            return f16494i;
        }
    }

    private static String e(VariableElement variableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar) {
        boolean z3;
        String lVar2 = lVar.p().toString();
        if (!lVar.n() && !lVar.m()) {
            if (lVar2.contains("<") && lVar2.contains(">")) {
                String str = lVar2.split("<")[0];
                String[] split = lVar2.split(">");
                lVar2 = split.length > 1 ? str + split[split.length - 1] : str;
            }
            String[] split2 = lVar2.split("\\.");
            String c4 = c(split2[split2.length - 1]);
            char[] charArray = c4.toCharArray();
            int length = charArray.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z3 = true;
                    break;
                } else if (Character.isLowerCase(charArray[i4])) {
                    z3 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z3) {
                return c4.toLowerCase();
            }
            char[] charArray2 = c4.toCharArray();
            int length2 = charArray2.length;
            int i5 = 0;
            for (int i6 = 0; i6 < length2; i6++) {
                if (Character.isUpperCase(charArray2[i6])) {
                    i5 = i6;
                }
            }
            String substring = c4.substring(i5, c4.length());
            return Character.toLowerCase(substring.charAt(0)) + substring.substring(1, substring.length());
        }
        return A(variableElement);
    }

    private static List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> g(List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> list) {
        HashSet hashSet = new HashSet();
        boolean z3 = false;
        for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : list) {
            String str = jVar.f17839a;
            if (hashSet.contains(str)) {
                z3 = true;
            } else {
                hashSet.add(str);
            }
        }
        if (z3) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < list.size(); i4++) {
                com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar2 = list.get(i4);
                com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar = jVar2.f17842d;
                arrayList.add(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(lVar, jVar2.f17839a + i4, new Modifier[0]).g(jVar2.f17841c).f(jVar2.f17840b).i());
            }
            return arrayList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bumptech.glide.repackaged.com.squareup.javapoet.d n(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("return ($T) super.$N(", lVar, iVar.f17817a).b(com.bumptech.glide.repackaged.com.google.common.collect.g.g(iVar.f17823g).n(new c()).k(com.bumptech.glide.repackaged.com.google.common.base.b.f(",")), new Object[0]).b(");\n", new Object[0]).j();
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.d r(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, String str, List<Object> list) {
        StringBuilder sb = new StringBuilder("@see $T#$L(");
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        arrayList.add(str);
        for (Object obj : list) {
            sb.append("$T, ");
            arrayList.add(obj);
        }
        if (arrayList.size() > 2) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")\n");
        return com.bumptech.glide.repackaged.com.squareup.javapoet.d.c(sb.toString(), arrayList.toArray(new Object[0]));
    }

    private static List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> s(VariableElement variableElement) {
        ArrayList arrayList = new ArrayList();
        for (AnnotationMirror annotationMirror : variableElement.getAnnotationMirrors()) {
            arrayList.add(com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror));
        }
        return arrayList;
    }

    private static String u(Element element, Object obj) {
        if (!obj.getClass().getSimpleName().equals("UnresolvedClass")) {
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            if (declaredMethods != null && declaredMethods.length != 0) {
                for (Method method : declaredMethods) {
                    if (method.getName().equals("getValue")) {
                        try {
                            return method.invoke(obj, new Object[0]).toString();
                        } catch (IllegalAccessException | InvocationTargetException e4) {
                            throw new IllegalArgumentException("Failed to parse @Excludes for: " + element, e4);
                        }
                    }
                }
                throw new IllegalArgumentException("Failed to parse @Excludes for: " + element);
            }
            throw new IllegalArgumentException("Failed to parse @Excludes for: " + element + ", invalid exclude: " + obj);
        }
        throw new IllegalArgumentException("Failed to parse @Excludes for: " + element + ", one or more excluded Modules could not be found at compile time. Ensure that allexcluded Modules are included in your classpath.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.l v(Element element) {
        Types typeUtils = this.f16496a.getTypeUtils();
        TypeMirror asType = element.asType();
        if (typeUtils.asElement(asType) == null) {
            return com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(element.asType());
        }
        return com.bumptech.glide.repackaged.com.squareup.javapoet.c.r(typeUtils.asElement(asType).getSimpleName().toString());
    }

    private static com.bumptech.glide.repackaged.com.squareup.javapoet.j x(VariableElement variableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.l j4 = com.bumptech.glide.repackaged.com.squareup.javapoet.l.j(variableElement.asType());
        return com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(j4, e(variableElement, j4), new Modifier[0]).g(variableElement.getModifiers()).f(s(variableElement)).i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> y(List<? extends VariableElement> list) {
        ArrayList arrayList = new ArrayList();
        for (VariableElement variableElement : list) {
            arrayList.add(x(variableElement));
        }
        return g(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> z(ExecutableElement executableElement) {
        return y(executableElement.getParameters());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(String str) {
        Messager messager = this.f16496a.getMessager();
        Diagnostic.Kind kind = Diagnostic.Kind.NOTE;
        messager.printMessage(kind, "[" + this.f16499d + "] " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(TypeElement typeElement) {
        return this.f16496a.getTypeUtils().isAssignable(typeElement.asType(), this.f16497b.asType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D(TypeElement typeElement) {
        return typeElement.getAnnotation(GlideExtension.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(TypeElement typeElement) {
        return this.f16496a.getTypeUtils().isAssignable(typeElement.asType(), this.f16498c.asType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F(ExecutableElement executableElement, TypeElement typeElement) {
        return G(executableElement, typeElement.asType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        this.f16499d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(String str, TypeSpec typeSpec) {
        try {
            f("Writing class:\n" + typeSpec);
            com.bumptech.glide.repackaged.com.squareup.javapoet.g.a(str, typeSpec).g().d(this.f16496a.getFiler());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(TypeSpec typeSpec) {
        L(f16490e, typeSpec);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExecutableElement> h(Set<String> set, Class<? extends Annotation> cls) {
        ArrayList arrayList = new ArrayList();
        for (String str : set) {
            for (ExecutableElement executableElement : this.f16496a.getElementUtils().getTypeElement(str).getEnclosedElements()) {
                if (executableElement.getAnnotation(cls) != null) {
                    arrayList.add(executableElement);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> i(Element element, Class<? extends Annotation> cls) {
        String name = cls.getName();
        AnnotationValue annotationValue = null;
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (name.equals(annotationMirror.getAnnotationType().toString())) {
                Set entrySet = annotationMirror.getElementValues().entrySet();
                if (entrySet.size() == 1) {
                    annotationValue = (AnnotationValue) ((Map.Entry) entrySet.iterator().next()).getValue();
                    if (annotationValue == null || (annotationValue instanceof Attribute.UnresolvedClass)) {
                        throw new IllegalArgumentException("Failed to find value for: " + cls + " from mirrors: " + element.getAnnotationMirrors());
                    }
                } else {
                    throw new IllegalArgumentException("Expected single value, but found: " + entrySet);
                }
            }
        }
        if (annotationValue == null) {
            return Collections.emptySet();
        }
        Object value = annotationValue.getValue();
        if (value instanceof List) {
            List<Object> list = (List) value;
            HashSet hashSet = new HashSet(list.size());
            for (Object obj : list) {
                hashSet.add(u(element, obj));
            }
            return hashSet;
        }
        return Collections.singleton(((Type.ClassType) value).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExecutableElement> j(TypeElement typeElement, TypeElement typeElement2) {
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(typeElement.getEnclosedElements()).c(new d(this, typeElement2, e.INSTANCE)).n(new f(null)).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExecutableElement> k(TypeElement typeElement, TypeMirror typeMirror) {
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(typeElement.getEnclosedElements()).c(new d(typeMirror, e.INSTANCE)).n(new f(null)).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExecutableElement> l(TypeElement typeElement) {
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(typeElement.getEnclosedElements()).c(new d((TypeMirror) null, e.STATIC)).n(new f(null)).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ExecutableElement> m(TypeElement typeElement, TypeElement typeElement2) {
        return com.bumptech.glide.repackaged.com.google.common.collect.g.g(typeElement.getEnclosedElements()).c(new d(this, typeElement2, e.STATIC)).n(new f(null)).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.d o(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return r(lVar, iVar.f17817a, com.bumptech.glide.repackaged.com.google.common.collect.o.i(iVar.f17823g, new b()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.d p(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, String str, List<? extends VariableElement> list) {
        return r(lVar, str, com.bumptech.glide.repackaged.com.google.common.collect.o.i(list, new a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.d q(ExecutableElement executableElement) {
        return p(v(executableElement.getEnclosingElement()), executableElement.getSimpleName().toString(), executableElement.getParameters());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<TypeElement> t(Class<? extends Annotation> cls, RoundEnvironment roundEnvironment) {
        return ElementFilter.typesIn(roundEnvironment.getElementsAnnotatedWith(cls));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(ExecutableElement executableElement) {
        return ((GlideOption) executableElement.getAnnotation(GlideOption.class)).override();
    }

    /* compiled from: ProcessorUtil.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private final class d implements com.bumptech.glide.repackaged.com.google.common.base.e<Element> {

        /* renamed from: a  reason: collision with root package name */
        private final TypeMirror f16502a;

        /* renamed from: b  reason: collision with root package name */
        private final e f16503b;

        d(TypeMirror typeMirror, e eVar) {
            this.f16502a = typeMirror;
            this.f16503b = eVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(Element element) {
            if (element != null && element.getKind() == ElementKind.METHOD && element.getModifiers().contains(Modifier.PUBLIC)) {
                boolean contains = element.getModifiers().contains(Modifier.STATIC);
                e eVar = this.f16503b;
                if (eVar != e.STATIC || contains) {
                    if (eVar == e.INSTANCE && contains) {
                        return false;
                    }
                    ExecutableElement executableElement = (ExecutableElement) element;
                    TypeMirror typeMirror = this.f16502a;
                    return typeMirror == null || i.this.G(executableElement, typeMirror);
                }
                return false;
            }
            return false;
        }

        d(i iVar, TypeElement typeElement, e eVar) {
            this(typeElement != null ? typeElement.asType() : null, eVar);
        }
    }
}
