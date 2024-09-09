package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.v;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l extends p implements kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h, v, m2.g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f56600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a extends FunctionReference implements d2.l<Member, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56601a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final Boolean invoke(@NotNull Member p02) {
            f0.p(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(Member.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "isSynthetic()Z";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b extends FunctionReference implements d2.l<Constructor<?>, o> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56602a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final o invoke(@NotNull Constructor<?> p02) {
            f0.p(p02, "p0");
            return new o(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(o.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class c extends FunctionReference implements d2.l<Member, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f56603a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final Boolean invoke(@NotNull Member p02) {
            f0.p(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(Member.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "isSynthetic()Z";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class d extends FunctionReference implements d2.l<Field, r> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56604a = new d();

        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final r invoke(@NotNull Field p02) {
            f0.p(p02, "p0");
            return new r(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(r.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements d2.l<Class<?>, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f56605a = new e();

        e() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            f0.o(simpleName, "it.simpleName");
            return Boolean.valueOf(simpleName.length() == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends Lambda implements d2.l<Class<?>, kotlin.reflect.jvm.internal.impl.name.f> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f56606a = new f();

        f() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.name.f invoke(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!kotlin.reflect.jvm.internal.impl.name.f.h(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.name.f.f(simpleName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g extends Lambda implements d2.l<Method, Boolean> {
        g() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
            if (r0.Y(r5) == false) goto L4;
         */
        @Override // d2.l
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(java.lang.reflect.Method r5) {
            /*
                r4 = this;
                boolean r0 = r5.isSynthetic()
                r1 = 1
                r2 = 0
                if (r0 == 0) goto La
            L8:
                r1 = 0
                goto L1f
            La:
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l.this
                boolean r0 = r0.v()
                if (r0 == 0) goto L1f
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l r0 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l.this
                java.lang.String r3 = "method"
                kotlin.jvm.internal.f0.o(r5, r3)
                boolean r5 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l.P(r0, r5)
                if (r5 != 0) goto L8
            L1f:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l.g.invoke(java.lang.reflect.Method):java.lang.Boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class h extends FunctionReference implements d2.l<Method, u> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f56608a = new h();

        h() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final u invoke(@NotNull Method p02) {
            f0.p(p02, "p0");
            return new u(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(u.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }
    }

    public l(@NotNull Class<?> klass) {
        f0.p(klass, "klass");
        this.f56600a = klass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y(Method method) {
        String name = method.getName();
        if (f0.g(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            f0.o(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (f0.g(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // m2.g
    @NotNull
    public Collection<m2.j> A() {
        List F;
        Class<?>[] c4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f56568a.c(this.f56600a);
        if (c4 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        ArrayList arrayList = new ArrayList(c4.length);
        int i4 = 0;
        int length = c4.length;
        while (i4 < length) {
            Class<?> cls = c4[i4];
            i4++;
            arrayList.add(new n(cls));
        }
        return arrayList;
    }

    @Override // m2.d
    public boolean B() {
        return h.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.v
    public int F() {
        return this.f56600a.getModifiers();
    }

    @Override // m2.g
    public boolean H() {
        return this.f56600a.isInterface();
    }

    @Override // m2.g
    @Nullable
    public LightClassOriginKind I() {
        return null;
    }

    @Override // m2.s
    public boolean O() {
        return v.a.d(this);
    }

    @Override // m2.d
    @Nullable
    /* renamed from: Q */
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // m2.d
    @NotNull
    /* renamed from: R */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // m2.g
    @NotNull
    /* renamed from: S */
    public List<o> g() {
        kotlin.sequences.m h5;
        kotlin.sequences.m n02;
        kotlin.sequences.m d12;
        List<o> V2;
        Constructor<?>[] declaredConstructors = this.f56600a.getDeclaredConstructors();
        f0.o(declaredConstructors, "klass.declaredConstructors");
        h5 = kotlin.collections.p.h5(declaredConstructors);
        n02 = SequencesKt___SequencesKt.n0(h5, a.f56601a);
        d12 = SequencesKt___SequencesKt.d1(n02, b.f56602a);
        V2 = SequencesKt___SequencesKt.V2(d12);
        return V2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h
    @NotNull
    /* renamed from: T */
    public Class<?> r() {
        return this.f56600a;
    }

    @Override // m2.g
    @NotNull
    /* renamed from: U */
    public List<r> w() {
        kotlin.sequences.m h5;
        kotlin.sequences.m n02;
        kotlin.sequences.m d12;
        List<r> V2;
        Field[] declaredFields = this.f56600a.getDeclaredFields();
        f0.o(declaredFields, "klass.declaredFields");
        h5 = kotlin.collections.p.h5(declaredFields);
        n02 = SequencesKt___SequencesKt.n0(h5, c.f56603a);
        d12 = SequencesKt___SequencesKt.d1(n02, d.f56604a);
        V2 = SequencesKt___SequencesKt.V2(d12);
        return V2;
    }

    @Override // m2.g
    @NotNull
    /* renamed from: V */
    public List<kotlin.reflect.jvm.internal.impl.name.f> y() {
        kotlin.sequences.m h5;
        kotlin.sequences.m n02;
        kotlin.sequences.m i12;
        List<kotlin.reflect.jvm.internal.impl.name.f> V2;
        Class<?>[] declaredClasses = this.f56600a.getDeclaredClasses();
        f0.o(declaredClasses, "klass.declaredClasses");
        h5 = kotlin.collections.p.h5(declaredClasses);
        n02 = SequencesKt___SequencesKt.n0(h5, e.f56605a);
        i12 = SequencesKt___SequencesKt.i1(n02, f.f56606a);
        V2 = SequencesKt___SequencesKt.V2(i12);
        return V2;
    }

    @Override // m2.g
    @NotNull
    /* renamed from: W */
    public List<u> z() {
        kotlin.sequences.m h5;
        kotlin.sequences.m i02;
        kotlin.sequences.m d12;
        List<u> V2;
        Method[] declaredMethods = this.f56600a.getDeclaredMethods();
        f0.o(declaredMethods, "klass.declaredMethods");
        h5 = kotlin.collections.p.h5(declaredMethods);
        i02 = SequencesKt___SequencesKt.i0(h5, new g());
        d12 = SequencesKt___SequencesKt.d1(i02, h.f56608a);
        V2 = SequencesKt___SequencesKt.V2(d12);
        return V2;
    }

    @Override // m2.g
    @Nullable
    /* renamed from: X */
    public l f() {
        Class<?> declaringClass = this.f56600a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new l(declaringClass);
    }

    @Override // m2.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        kotlin.reflect.jvm.internal.impl.name.c b4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(this.f56600a).b();
        f0.o(b4, "klass.classId.asSingleFqName()");
        return b4;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof l) && f0.g(this.f56600a, ((l) obj).f56600a);
    }

    @Override // m2.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(this.f56600a.getSimpleName());
        f0.o(f4, "identifier(klass.simpleName)");
        return f4;
    }

    @Override // m2.z
    @NotNull
    public List<a0> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f56600a.getTypeParameters();
        f0.o(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i4 = 0;
        while (i4 < length) {
            TypeVariable<Class<?>> typeVariable = typeParameters[i4];
            i4++;
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // m2.s
    @NotNull
    public i1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return this.f56600a.hashCode();
    }

    @Override // m2.g
    @NotNull
    public Collection<m2.w> i() {
        Object[] d4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f56568a.d(this.f56600a);
        int i4 = 0;
        if (d4 == null) {
            d4 = new Object[0];
        }
        ArrayList arrayList = new ArrayList(d4.length);
        int length = d4.length;
        while (i4 < length) {
            Object obj = d4[i4];
            i4++;
            arrayList.add(new y(obj));
        }
        return arrayList;
    }

    @Override // m2.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // m2.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // m2.g
    @NotNull
    public Collection<m2.j> j() {
        Class cls;
        List<Type> M;
        int Z;
        List F;
        cls = Object.class;
        if (f0.g(this.f56600a, cls)) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        r0 r0Var = new r0(2);
        Object genericSuperclass = this.f56600a.getGenericSuperclass();
        r0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.f56600a.getGenericInterfaces();
        f0.o(genericInterfaces, "klass.genericInterfaces");
        r0Var.b(genericInterfaces);
        M = CollectionsKt__CollectionsKt.M(r0Var.d(new Type[r0Var.c()]));
        Z = kotlin.collections.y.Z(M, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (Type type : M) {
            arrayList.add(new n(type));
        }
        return arrayList;
    }

    @Override // m2.g
    public boolean m() {
        return this.f56600a.isAnnotation();
    }

    @Override // m2.g
    public boolean o() {
        Boolean e4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f56568a.e(this.f56600a);
        if (e4 == null) {
            return false;
        }
        return e4.booleanValue();
    }

    @Override // m2.g
    public boolean p() {
        Boolean f4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f56568a.f(this.f56600a);
        if (f4 == null) {
            return false;
        }
        return f4.booleanValue();
    }

    @Override // m2.g
    public boolean q() {
        return false;
    }

    @NotNull
    public String toString() {
        return l.class.getName() + ": " + this.f56600a;
    }

    @Override // m2.g
    public boolean v() {
        return this.f56600a.isEnum();
    }
}
