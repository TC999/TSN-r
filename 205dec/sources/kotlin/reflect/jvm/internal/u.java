package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KTypeImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010,\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u0011\u0010\u001dR!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010%R\u0014\u0010(\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010#\u00a8\u00060\u00b2\u0006\u0012\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f8\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/u;", "Lkotlin/jvm/internal/g0;", "Lkotlin/reflect/jvm/internal/impl/types/e0;", "type", "Lkotlin/reflect/g;", "e", "", "nullable", "h", "(Z)Lkotlin/reflect/jvm/internal/u;", "", "other", "equals", "", "hashCode", "", "toString", "a", "Lkotlin/reflect/jvm/internal/impl/types/e0;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "Lkotlin/reflect/jvm/internal/y$a;", "Ljava/lang/reflect/Type;", "b", "Lkotlin/reflect/jvm/internal/y$a;", "getComputeJavaType$annotations", "()V", "computeJavaType", "c", "()Lkotlin/reflect/g;", "classifier", "", "Lkotlin/reflect/t;", "d", "getArguments", "()Ljava/util/List;", "arguments", "()Ljava/lang/reflect/Type;", "javaType", "()Z", "isMarkedNullable", "", "getAnnotations", "annotations", "Lkotlin/Function0;", "<init>", "(Lorg/jetbrains/kotlin/types/KotlinType;Ld2/a;)V", "parameterizedTypeArguments", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u implements kotlin.jvm.internal.g0 {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f58660e = {n0.u(new PropertyReference1Impl(n0.d(u.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), n0.u(new PropertyReference1Impl(n0.d(u.class), "arguments", "getArguments()Ljava/util/List;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.e0 f58661a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final y.a<Type> f58662b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final y.a f58663c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final y.a f58664d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KTypeImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/t;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.a<List<? extends kotlin.reflect.t>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d2.a<Type> f58666b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KTypeImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.u$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1193a extends Lambda implements d2.a<Type> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ u f58667a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f58668b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ kotlin.p<List<Type>> f58669c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C1193a(u uVar, int i4, kotlin.p<? extends List<? extends Type>> pVar) {
                super(0);
                this.f58667a = uVar;
                this.f58668b = i4;
                this.f58669c = pVar;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Type invoke() {
                Object Kb;
                Object ob;
                Type c4 = this.f58667a.c();
                if (c4 instanceof Class) {
                    Class cls = (Class) c4;
                    Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    kotlin.jvm.internal.f0.o(componentType, "{\n                      \u2026                        }");
                    return componentType;
                } else if (c4 instanceof GenericArrayType) {
                    if (this.f58668b == 0) {
                        Type genericComponentType = ((GenericArrayType) c4).getGenericComponentType();
                        kotlin.jvm.internal.f0.o(genericComponentType, "{\n                      \u2026                        }");
                        return genericComponentType;
                    }
                    throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Array type has been queried for a non-0th argument: ", this.f58667a));
                } else if (c4 instanceof ParameterizedType) {
                    Type type = (Type) a.b(this.f58669c).get(this.f58668b);
                    if (type instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) type;
                        Type[] lowerBounds = wildcardType.getLowerBounds();
                        kotlin.jvm.internal.f0.o(lowerBounds, "argument.lowerBounds");
                        Kb = kotlin.collections.p.Kb(lowerBounds);
                        Type type2 = (Type) Kb;
                        if (type2 == null) {
                            Type[] upperBounds = wildcardType.getUpperBounds();
                            kotlin.jvm.internal.f0.o(upperBounds, "argument.upperBounds");
                            ob = kotlin.collections.p.ob(upperBounds);
                            type = (Type) ob;
                        } else {
                            type = type2;
                        }
                    }
                    kotlin.jvm.internal.f0.o(type, "{\n                      \u2026                        }");
                    return type;
                } else {
                    throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Non-generic type has been queried for arguments: ", this.f58667a));
                }
            }
        }

        /* compiled from: KTypeImpl.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f58670a;

            static {
                int[] iArr = new int[Variance.values().length];
                iArr[Variance.INVARIANT.ordinal()] = 1;
                iArr[Variance.IN_VARIANCE.ordinal()] = 2;
                iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
                f58670a = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KTypeImpl.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends Lambda implements d2.a<List<? extends Type>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ u f58671a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(u uVar) {
                super(0);
                this.f58671a = uVar;
            }

            @Override // d2.a
            @NotNull
            public final List<? extends Type> invoke() {
                Type c4 = this.f58671a.c();
                kotlin.jvm.internal.f0.m(c4);
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.d(c4);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(d2.a<? extends Type> aVar) {
            super(0);
            this.f58666b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List<Type> b(kotlin.p<? extends List<? extends Type>> pVar) {
            return (List) pVar.getValue();
        }

        @Override // d2.a
        public final List<? extends kotlin.reflect.t> invoke() {
            kotlin.p c4;
            int Z;
            kotlin.reflect.t e4;
            List<? extends kotlin.reflect.t> F;
            List<a1> G0 = u.this.getType().G0();
            if (G0.isEmpty()) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(u.this));
            d2.a<Type> aVar = this.f58666b;
            u uVar = u.this;
            Z = kotlin.collections.y.Z(G0, 10);
            ArrayList arrayList = new ArrayList(Z);
            int i4 = 0;
            for (Object obj : G0) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.X();
                }
                a1 a1Var = (a1) obj;
                if (a1Var.b()) {
                    e4 = kotlin.reflect.t.f58685c.c();
                } else {
                    kotlin.reflect.jvm.internal.impl.types.e0 type = a1Var.getType();
                    kotlin.jvm.internal.f0.o(type, "typeProjection.type");
                    u uVar2 = new u(type, aVar == null ? null : new C1193a(uVar, i4, c4));
                    int i6 = b.f58670a[a1Var.c().ordinal()];
                    if (i6 == 1) {
                        e4 = kotlin.reflect.t.f58685c.e(uVar2);
                    } else if (i6 == 2) {
                        e4 = kotlin.reflect.t.f58685c.a(uVar2);
                    } else if (i6 != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        e4 = kotlin.reflect.t.f58685c.b(uVar2);
                    }
                }
                arrayList.add(e4);
                i4 = i5;
            }
            return arrayList;
        }
    }

    /* compiled from: KTypeImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/reflect/g;", "a", "()Lkotlin/reflect/g;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<kotlin.reflect.g> {
        b() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.g invoke() {
            u uVar = u.this;
            return uVar.e(uVar.getType());
        }
    }

    public u(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 type, @Nullable d2.a<? extends Type> aVar) {
        kotlin.jvm.internal.f0.p(type, "type");
        this.f58661a = type;
        y.a<Type> aVar2 = null;
        y.a<Type> aVar3 = aVar instanceof y.a ? (y.a) aVar : null;
        if (aVar3 != null) {
            aVar2 = aVar3;
        } else if (aVar != null) {
            aVar2 = y.c(aVar);
        }
        this.f58662b = aVar2;
        this.f58663c = y.c(new b());
        this.f58664d = y.c(new a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.g e(kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        Object V4;
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            Class<?> p3 = f0.p((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
            if (p3 == null) {
                return null;
            }
            if (p3.isArray()) {
                V4 = kotlin.collections.f0.V4(e0Var.G0());
                a1 a1Var = (a1) V4;
                if (a1Var == null) {
                    return new h(p3);
                }
                kotlin.reflect.jvm.internal.impl.types.e0 type = a1Var.getType();
                kotlin.jvm.internal.f0.o(type, "type.arguments.singleOrN\u2026return KClassImpl(jClass)");
                kotlin.reflect.g e4 = e(type);
                if (e4 != null) {
                    return new h(f0.f(c2.a.c(kotlin.reflect.jvm.c.a(e4))));
                }
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Cannot determine classifier for array element type: ", this));
            } else if (!h1.m(e0Var)) {
                Class<?> e5 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.e(p3);
                if (e5 != null) {
                    p3 = e5;
                }
                return new h(p3);
            } else {
                return new h(p3);
            }
        } else if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            return new v(null, (kotlin.reflect.jvm.internal.impl.descriptors.a1) b4);
        } else {
            if (b4 instanceof z0) {
                throw new NotImplementedError(kotlin.jvm.internal.f0.C("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
    }

    @Override // kotlin.reflect.r
    @Nullable
    public kotlin.reflect.g a() {
        return (kotlin.reflect.g) this.f58663c.b(this, f58660e[0]);
    }

    @Override // kotlin.reflect.r
    public boolean b() {
        return this.f58661a.I0();
    }

    @Override // kotlin.jvm.internal.g0
    @Nullable
    public Type c() {
        y.a<Type> aVar = this.f58662b;
        if (aVar == null) {
            return null;
        }
        return aVar.invoke();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof u) && kotlin.jvm.internal.f0.g(this.f58661a, ((u) obj).f58661a);
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        return f0.e(this.f58661a);
    }

    @Override // kotlin.reflect.r
    @NotNull
    public List<kotlin.reflect.t> getArguments() {
        Object b4 = this.f58664d.b(this, f58660e[1]);
        kotlin.jvm.internal.f0.o(b4, "<get-arguments>(...)");
        return (List) b4;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.types.e0 getType() {
        return this.f58661a;
    }

    @NotNull
    public final u h(boolean z3) {
        if (kotlin.reflect.jvm.internal.impl.types.b0.b(this.f58661a) || b() != z3) {
            kotlin.reflect.jvm.internal.impl.types.e0 q3 = h1.q(this.f58661a, z3);
            kotlin.jvm.internal.f0.o(q3, "makeNullableAsSpecified(type, nullable)");
            return new u(q3, this.f58662b);
        }
        return this;
    }

    public int hashCode() {
        return this.f58661a.hashCode();
    }

    @NotNull
    public String toString() {
        return a0.f55871a.h(this.f58661a);
    }

    public /* synthetic */ u(kotlin.reflect.jvm.internal.impl.types.e0 e0Var, d2.a aVar, int i4, kotlin.jvm.internal.u uVar) {
        this(e0Var, (i4 & 2) != 0 ? null : aVar);
    }
}
