package com.bumptech.glide.annotation.compiler;

import com.acse.ottn.f3;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.d;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestOptionsGenerator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private int f16552a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.c f16553b = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w("com.bumptech.glide.request", "RequestOptions", new String[0]);

    /* renamed from: c  reason: collision with root package name */
    private final TypeElement f16554c;

    /* renamed from: d  reason: collision with root package name */
    private final i f16555d;

    /* renamed from: e  reason: collision with root package name */
    private final o f16556e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.c f16557f;

    /* compiled from: RequestOptionsGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.i, e> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public e apply(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            return new e(iVar);
        }
    }

    /* compiled from: RequestOptionsGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.a<ExecutableElement, e> {
        b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public e apply(ExecutableElement executableElement) {
            return n.this.f(executableElement);
        }
    }

    /* compiled from: RequestOptionsGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class c implements com.bumptech.glide.repackaged.com.google.common.base.e<ExecutableElement> {
        c() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a */
        public boolean apply(ExecutableElement executableElement) {
            return !n.n(executableElement);
        }
    }

    /* compiled from: RequestOptionsGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class d implements com.bumptech.glide.repackaged.com.google.common.base.a<e, f> {
        d() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a */
        public f apply(e eVar) {
            return new f(eVar.f16562a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestOptionsGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.squareup.javapoet.i f16562a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.squareup.javapoet.f f16563b;

        e(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            this(iVar, null);
        }

        e(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar, com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar) {
            this.f16562a = iVar;
            this.f16563b = fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestOptionsGenerator.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final com.bumptech.glide.repackaged.com.squareup.javapoet.l f16564a;

        /* renamed from: b  reason: collision with root package name */
        private final List<com.bumptech.glide.repackaged.com.squareup.javapoet.l> f16565b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f16566c;

        /* renamed from: d  reason: collision with root package name */
        private final String f16567d;

        /* compiled from: RequestOptionsGenerator.java */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        class a implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, com.bumptech.glide.repackaged.com.squareup.javapoet.l> {
            a() {
            }

            @Override // com.bumptech.glide.repackaged.com.google.common.base.a
            /* renamed from: a */
            public com.bumptech.glide.repackaged.com.squareup.javapoet.l apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
                return jVar.f17842d;
            }
        }

        f(com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
            this.f16567d = iVar.f17817a;
            this.f16566c = iVar.f17820d.contains(Modifier.STATIC);
            this.f16564a = iVar.f17822f;
            this.f16565b = com.bumptech.glide.repackaged.com.google.common.collect.o.i(iVar.f17823g, new a());
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return this.f16567d.equals(fVar.f16567d) && this.f16564a.equals(fVar.f16564a) && this.f16565b.equals(fVar.f16565b) && this.f16566c == fVar.f16566c;
            }
            return false;
        }

        public int hashCode() {
            return com.bumptech.glide.repackaged.com.google.common.base.c.b(this.f16567d, this.f16564a, this.f16565b, Boolean.valueOf(this.f16566c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f16555d = iVar;
        this.f16554c = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.request.RequestOptions");
        this.f16556e = new o(processingEnvironment, iVar);
    }

    private StringBuilder c(boolean z3, i.b bVar, String str, List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> list) {
        StringBuilder sb = new StringBuilder(str);
        if (!list.isEmpty()) {
            bVar.x(list);
            for (com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar : list) {
                sb.append(jVar.f17839a);
                if (z3 && k(jVar)) {
                    sb.append(".getApplicationContext()");
                }
                sb.append(", ");
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")");
        return sb;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.d e(Set<String> set) {
        d.b b4 = com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("Automatically generated from {@link $T} annotated classes.\n", GlideExtension.class).b("\n", new Object[0]).b("@see $T\n", this.f16553b);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            b4.b("@see $T\n", com.bumptech.glide.repackaged.com.squareup.javapoet.c.r(it.next()));
        }
        return b4.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e f(ExecutableElement executableElement) {
        String j4 = j(executableElement);
        String obj = executableElement.getSimpleName().toString();
        if (com.bumptech.glide.repackaged.com.google.common.base.g.b(j4)) {
            j4 = obj.startsWith("dont") ? "no" + obj.replace("dont", "") : obj + "Of";
        }
        boolean l4 = l(executableElement);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(j4);
        i.b F = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(j4).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f16555d.q(executableElement)).H(executableElement.isVarArgs()).F(this.f16557f);
        List parameters = executableElement.getParameters();
        if (!parameters.isEmpty()) {
            StringBuilder c4 = c(l4, F, "new $T().$L(", i.y(parameters.subList(1, parameters.size())));
            com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar = null;
            if (l4) {
                StringBuilder sb = new StringBuilder();
                sb.append(j4);
                int i4 = this.f16552a;
                this.f16552a = i4 + 1;
                sb.append(i4);
                String sb2 = sb.toString();
                fVar = com.bumptech.glide.repackaged.com.squareup.javapoet.f.a(this.f16557f, sb2, new Modifier[0]).g(Modifier.PRIVATE, Modifier.STATIC).h();
                Object obj2 = this.f16557f;
                F.B("if ($T.$N == null)", this.f16557f, sb2).y("$T.$N =\n" + ((Object) c4) + ".$N", obj2, sb2, obj2, obj, "autoClone()").D().y("return $T.$N", this.f16557f, sb2);
            } else {
                F.y("return " + ((Object) c4), this.f16557f, obj);
            }
            for (TypeParameterElement typeParameterElement : executableElement.getTypeParameters()) {
                F.z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.r(typeParameterElement.getSimpleName().toString()));
            }
            F.m(i.d());
            return new e(F.C(), fVar);
        }
        throw new IllegalArgumentException("Expected non-empty parameters for: " + executableElement);
    }

    private e g(ExecutableElement executableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar;
        boolean m4 = m(executableElement);
        String obj = executableElement.getSimpleName().toString();
        Object i4 = i(obj);
        i.b F = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(obj).u(Modifier.PUBLIC, Modifier.STATIC).s(this.f16555d.q(executableElement)).F(this.f16557f);
        StringBuilder c4 = c(m4, F, "new $T().$N(", i.z(executableElement));
        if (m4) {
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            int i5 = this.f16552a;
            this.f16552a = i5 + 1;
            sb.append(i5);
            String sb2 = sb.toString();
            fVar = com.bumptech.glide.repackaged.com.squareup.javapoet.f.a(this.f16557f, sb2, new Modifier[0]).g(Modifier.PRIVATE, Modifier.STATIC).h();
            Object obj2 = this.f16557f;
            F.B("if ($T.$N == null)", this.f16557f, sb2).y("$T.$N =\n" + ((Object) c4) + ".$N", obj2, sb2, obj2, i4, "autoClone()").D().y("return $T.$N", this.f16557f, sb2);
        } else {
            F.y("return " + ((Object) c4), this.f16557f, i4);
            fVar = null;
        }
        for (TypeParameterElement typeParameterElement : executableElement.getTypeParameters()) {
            F.z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.r(typeParameterElement.getSimpleName().toString()));
        }
        F.m(i.d()).m(i.H());
        return new e(F.C(), fVar);
    }

    private List<e> h() {
        i iVar = this.f16555d;
        TypeElement typeElement = this.f16554c;
        List<ExecutableElement> m4 = iVar.m(typeElement, typeElement);
        ArrayList arrayList = new ArrayList();
        for (ExecutableElement executableElement : m4) {
            if (executableElement.getAnnotation(Deprecated.class) == null) {
                arrayList.add(g(executableElement));
            }
        }
        return arrayList;
    }

    private static String i(String str) {
        if ("bitmapTransform".equals(str)) {
            return "transform";
        }
        if ("decodeTypeOf".equals(str)) {
            return "decode";
        }
        if (str.endsWith("Transform")) {
            return str.substring(0, str.length() - 9);
        }
        if (str.endsWith("Of")) {
            return str.substring(0, str.length() - 2);
        }
        if ("noTransformation".equals(str)) {
            return "dontTransform";
        }
        if ("noAnimation".equals(str)) {
            return "dontAnimate";
        }
        if (str.equals("option")) {
            return f3.f5659h;
        }
        throw new IllegalArgumentException("Unrecognized static method name: " + str);
    }

    private static String j(ExecutableElement executableElement) {
        GlideOption glideOption = (GlideOption) executableElement.getAnnotation(GlideOption.class);
        return com.bumptech.glide.repackaged.com.google.common.base.g.a(glideOption != null ? glideOption.staticMethodName() : null);
    }

    private boolean k(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
        return jVar.f17842d.toString().equals("android.content.Context");
    }

    private static boolean l(ExecutableElement executableElement) {
        GlideOption glideOption = (GlideOption) executableElement.getAnnotation(GlideOption.class);
        return glideOption != null && glideOption.memoizeStaticMethod();
    }

    private static boolean m(ExecutableElement executableElement) {
        return executableElement.getParameters().isEmpty() || (executableElement.getParameters().size() == 1 && ((VariableElement) executableElement.getParameters().get(0)).getSimpleName().toString().equals("android.content.Context"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(ExecutableElement executableElement) {
        GlideOption glideOption = (GlideOption) executableElement.getAnnotation(GlideOption.class);
        return glideOption != null && glideOption.skipStaticMethod();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeSpec d(String str, Set<String> set) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c w3 = com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(str, "GlideOptions", new String[0]);
        this.f16557f = w3;
        m mVar = new m(w3, this.f16555d);
        ImmutableList l4 = com.bumptech.glide.repackaged.com.google.common.collect.g.g(mVar.a(set)).n(new a()).l();
        ImmutableList l5 = com.bumptech.glide.repackaged.com.google.common.collect.g.g(mVar.c(set)).c(new c()).n(new b()).l();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(l4);
        arrayList.addAll(l5);
        ImmutableSet copyOf = ImmutableSet.copyOf(com.bumptech.glide.repackaged.com.google.common.collect.m.f(arrayList, new d()));
        List<e> h4 = h();
        List<com.bumptech.glide.repackaged.com.squareup.javapoet.i> b4 = this.f16556e.b(this.f16557f);
        ArrayList<e> arrayList2 = new ArrayList();
        for (e eVar : h4) {
            if (!copyOf.contains(new f(eVar.f16562a))) {
                arrayList2.add(eVar);
            }
        }
        for (com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar : b4) {
            if (!copyOf.contains(new f(iVar))) {
                arrayList2.add(new e(iVar));
            }
        }
        arrayList2.addAll(arrayList);
        TypeSpec.b C = TypeSpec.a("GlideOptions").q(com.bumptech.glide.repackaged.com.squareup.javapoet.a.b(SuppressWarnings.class).d("value", "$S", "deprecation").f()).t(e(set)).x(Modifier.FINAL).x(Modifier.PUBLIC).z(Cloneable.class).C(this.f16553b);
        for (e eVar2 : arrayList2) {
            com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar2 = eVar2.f16562a;
            if (iVar2 != null) {
                C.v(iVar2);
            }
            com.bumptech.glide.repackaged.com.squareup.javapoet.f fVar = eVar2.f16563b;
            if (fVar != null) {
                C.r(fVar);
            }
        }
        return C.B();
    }
}
