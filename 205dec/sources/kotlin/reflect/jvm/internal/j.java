package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.c;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.d;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KFunctionImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B\u0019\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\bB\u0010CB7\b\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u00109\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bB\u0010EB+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u00109\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u0016\u0012\b\u00103\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bB\u0010FJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010\u000e\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001f\u0010-\u001a\u0006\u0012\u0002\b\u00030(8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R!\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010(8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u0016\u00103\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u00105R\u0014\u0010>\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u00105R\u0014\u0010?\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u00105R\u0014\u0010@\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u00105R\u0014\u0010A\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u00105\u00a8\u0006G"}, d2 = {"Lkotlin/reflect/jvm/internal/j;", "Lkotlin/reflect/jvm/internal/f;", "", "Lkotlin/reflect/i;", "Lkotlin/jvm/internal/b0;", "Lkotlin/reflect/jvm/internal/c;", "Ljava/lang/reflect/Method;", "member", "Lkotlin/reflect/jvm/internal/calls/d$h;", "T", "S", "R", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/d;", "Q", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "e", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "G", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "f", "Ljava/lang/String;", "signature", "g", "Ljava/lang/Object;", "rawBoundReceiver", "h", "Lkotlin/reflect/jvm/internal/y$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "Lkotlin/reflect/jvm/internal/calls/c;", "i", "Lkotlin/reflect/jvm/internal/y$b;", "F", "()Lkotlin/reflect/jvm/internal/calls/c;", "caller", "j", "H", "defaultCaller", "U", "()Ljava/lang/Object;", "boundReceiver", "K", "()Z", "isBound", "getName", "()Ljava/lang/String;", "name", "getArity", "()I", "arity", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j extends f<Object> implements kotlin.jvm.internal.b0<Object>, kotlin.reflect.i<Object>, kotlin.reflect.jvm.internal.c {

    /* renamed from: k  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f58560k = {n0.u(new PropertyReference1Impl(n0.d(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), n0.u(new PropertyReference1Impl(n0.d(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final KDeclarationContainerImpl f58561e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f58562f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Object f58563g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final y.a f58564h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final y.b f58565i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final y.b f58566j;

    /* compiled from: KFunctionImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/c;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/calls/c;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.calls.c<? extends Member>> {
        a() {
            super(0);
        }

        @Override // d2.a
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.calls.c<Member> invoke() {
            int Z;
            Object b4;
            kotlin.reflect.jvm.internal.calls.c T;
            int Z2;
            d g4 = b0.f55877a.g(j.this.I());
            if (g4 instanceof d.C1114d) {
                if (j.this.J()) {
                    Class<?> d4 = j.this.G().d();
                    List<KParameter> parameters = j.this.getParameters();
                    Z2 = kotlin.collections.y.Z(parameters, 10);
                    ArrayList arrayList = new ArrayList(Z2);
                    for (KParameter kParameter : parameters) {
                        String name = kParameter.getName();
                        kotlin.jvm.internal.f0.m(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(d4, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                }
                b4 = j.this.G().s(((d.C1114d) g4).b());
            } else if (g4 instanceof d.e) {
                d.e eVar = (d.e) g4;
                b4 = j.this.G().G(eVar.c(), eVar.b());
            } else if (g4 instanceof d.c) {
                b4 = ((d.c) g4).b();
            } else if (!(g4 instanceof d.b)) {
                if (g4 instanceof d.a) {
                    List<Method> b5 = ((d.a) g4).b();
                    Class<?> d5 = j.this.G().d();
                    Z = kotlin.collections.y.Z(b5, 10);
                    ArrayList arrayList2 = new ArrayList(Z);
                    for (Method method : b5) {
                        arrayList2.add(method.getName());
                    }
                    return new AnnotationConstructorCaller(d5, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, b5);
                }
                throw new NoWhenBranchMatchedException();
            } else {
                b4 = ((d.b) g4).b();
            }
            if (b4 instanceof Constructor) {
                j jVar = j.this;
                T = jVar.Q((Constructor) b4, jVar.I());
            } else if (b4 instanceof Method) {
                Method method2 = (Method) b4;
                if (!Modifier.isStatic(method2.getModifiers())) {
                    T = j.this.R(method2);
                } else if (j.this.I().getAnnotations().b(f0.j()) != null) {
                    T = j.this.S(method2);
                } else {
                    T = j.this.T(method2);
                }
            } else {
                throw new KotlinReflectionInternalError("Could not compute caller for function: " + j.this.I() + " (member = " + b4 + ')');
            }
            return kotlin.reflect.jvm.internal.calls.g.c(T, j.this.I(), false, 2, null);
        }
    }

    /* compiled from: KFunctionImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/c;", "a", "()Lkotlin/reflect/jvm/internal/calls/c;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<kotlin.reflect.jvm.internal.calls.c<? extends Member>> {
        b() {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.reflect.Member, java.lang.Object] */
        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.calls.c<Member> invoke() {
            GenericDeclaration genericDeclaration;
            int Z;
            int Z2;
            kotlin.reflect.jvm.internal.calls.c cVar;
            ?? b4;
            d g4 = b0.f55877a.g(j.this.I());
            if (g4 instanceof d.e) {
                KDeclarationContainerImpl G = j.this.G();
                d.e eVar = (d.e) g4;
                String c4 = eVar.c();
                String b5 = eVar.b();
                kotlin.jvm.internal.f0.m(j.this.F().b());
                genericDeclaration = G.x(c4, b5, !Modifier.isStatic(b4.getModifiers()));
            } else if (g4 instanceof d.C1114d) {
                if (j.this.J()) {
                    Class<?> d4 = j.this.G().d();
                    List<KParameter> parameters = j.this.getParameters();
                    Z2 = kotlin.collections.y.Z(parameters, 10);
                    ArrayList arrayList = new ArrayList(Z2);
                    for (KParameter kParameter : parameters) {
                        String name = kParameter.getName();
                        kotlin.jvm.internal.f0.m(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(d4, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                }
                genericDeclaration = j.this.G().u(((d.C1114d) g4).b());
            } else if (g4 instanceof d.a) {
                List<Method> b6 = ((d.a) g4).b();
                Class<?> d5 = j.this.G().d();
                Z = kotlin.collections.y.Z(b6, 10);
                ArrayList arrayList2 = new ArrayList(Z);
                for (Method method : b6) {
                    arrayList2.add(method.getName());
                }
                return new AnnotationConstructorCaller(d5, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, b6);
            } else {
                genericDeclaration = null;
            }
            if (genericDeclaration instanceof Constructor) {
                j jVar = j.this;
                cVar = jVar.Q((Constructor) genericDeclaration, jVar.I());
            } else if (!(genericDeclaration instanceof Method)) {
                cVar = null;
            } else if (j.this.I().getAnnotations().b(f0.j()) != null && !((kotlin.reflect.jvm.internal.impl.descriptors.d) j.this.I().b()).a0()) {
                cVar = j.this.S((Method) genericDeclaration);
            } else {
                cVar = j.this.T((Method) genericDeclaration);
            }
            if (cVar == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.calls.g.b(cVar, j.this.I(), true);
        }
    }

    /* compiled from: KFunctionImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/w;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.w> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f58570b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.f58570b = str;
        }

        @Override // d2.a
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.w invoke() {
            return j.this.G().F(this.f58570b, j.this.f58562f);
        }
    }

    /* synthetic */ j(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.w wVar, Object obj, int i4, kotlin.jvm.internal.u uVar) {
        this(kDeclarationContainerImpl, str, str2, wVar, (i4 & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.calls.d<Constructor<?>> Q(Constructor<?> constructor, kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        if (kotlin.reflect.jvm.internal.impl.resolve.jvm.b.f(wVar)) {
            if (K()) {
                return new d.a(constructor, U());
            }
            return new d.b(constructor);
        } else if (K()) {
            return new d.c(constructor, U());
        } else {
            return new d.e(constructor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.h R(Method method) {
        return K() ? new d.h.a(method, U()) : new d.h.C1112d(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.h S(Method method) {
        return K() ? new d.h.b(method) : new d.h.e(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d.h T(Method method) {
        return K() ? new d.h.c(method, U()) : new d.h.f(method);
    }

    private final Object U() {
        return kotlin.reflect.jvm.internal.calls.g.a(this.f58563g, I());
    }

    @Override // kotlin.reflect.jvm.internal.f
    @NotNull
    public kotlin.reflect.jvm.internal.calls.c<?> F() {
        Object b4 = this.f58565i.b(this, f58560k[1]);
        kotlin.jvm.internal.f0.o(b4, "<get-caller>(...)");
        return (kotlin.reflect.jvm.internal.calls.c) b4;
    }

    @Override // kotlin.reflect.jvm.internal.f
    @NotNull
    public KDeclarationContainerImpl G() {
        return this.f58561e;
    }

    @Override // kotlin.reflect.jvm.internal.f
    @Nullable
    public kotlin.reflect.jvm.internal.calls.c<?> H() {
        return (kotlin.reflect.jvm.internal.calls.c) this.f58566j.b(this, f58560k[2]);
    }

    @Override // kotlin.reflect.jvm.internal.f
    public boolean K() {
        return !kotlin.jvm.internal.f0.g(this.f58563g, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.jvm.internal.f
    @NotNull
    /* renamed from: V */
    public kotlin.reflect.jvm.internal.impl.descriptors.w I() {
        Object b4 = this.f58564h.b(this, f58560k[0]);
        kotlin.jvm.internal.f0.o(b4, "<get-descriptor>(...)");
        return (kotlin.reflect.jvm.internal.impl.descriptors.w) b4;
    }

    public boolean equals(@Nullable Object obj) {
        j c4 = f0.c(obj);
        return c4 != null && kotlin.jvm.internal.f0.g(G(), c4.G()) && kotlin.jvm.internal.f0.g(getName(), c4.getName()) && kotlin.jvm.internal.f0.g(this.f58562f, c4.f58562f) && kotlin.jvm.internal.f0.g(this.f58563g, c4.f58563g);
    }

    @Override // kotlin.jvm.internal.b0
    public int getArity() {
        return kotlin.reflect.jvm.internal.calls.e.a(F());
    }

    @Override // kotlin.reflect.c
    @NotNull
    public String getName() {
        String b4 = I().getName().b();
        kotlin.jvm.internal.f0.o(b4, "descriptor.name.asString()");
        return b4;
    }

    public int hashCode() {
        return (((G().hashCode() * 31) + getName().hashCode()) * 31) + this.f58562f.hashCode();
    }

    @Override // d2.a
    @Nullable
    public Object invoke() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.i
    public boolean isExternal() {
        return I().isExternal();
    }

    @Override // kotlin.reflect.i
    public boolean isInfix() {
        return I().isInfix();
    }

    @Override // kotlin.reflect.i
    public boolean isInline() {
        return I().isInline();
    }

    @Override // kotlin.reflect.i
    public boolean isOperator() {
        return I().isOperator();
    }

    @Override // kotlin.reflect.c
    public boolean isSuspend() {
        return I().isSuspend();
    }

    @NotNull
    public String toString() {
        return a0.f55871a.d(I());
    }

    @Override // d2.l
    @Nullable
    public Object invoke(@Nullable Object obj) {
        return c.a.b(this, obj);
    }

    private j(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, kotlin.reflect.jvm.internal.impl.descriptors.w wVar, Object obj) {
        this.f58561e = kDeclarationContainerImpl;
        this.f58562f = str2;
        this.f58563g = obj;
        this.f58564h = y.d(wVar, new c(str));
        this.f58565i = y.b(new a());
        this.f58566j = y.b(new b());
    }

    @Override // d2.p
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
        return c.a.c(this, obj, obj2);
    }

    @Override // d2.q
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return c.a.d(this, obj, obj2, obj3);
    }

    @Override // d2.r
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        return c.a.e(this, obj, obj2, obj3, obj4);
    }

    @Override // d2.s
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        return c.a.f(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // d2.t
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        return c.a.g(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // d2.u
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7) {
        return c.a.h(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // d2.v
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8) {
        return c.a.i(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
    }

    @Override // d2.w
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9) {
        return c.a.j(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.w r11) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.f0.p(r10, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.f0.p(r11, r0)
            kotlin.reflect.jvm.internal.impl.name.f r0 = r11.getName()
            java.lang.String r3 = r0.b()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.jvm.internal.f0.o(r3, r0)
            kotlin.reflect.jvm.internal.b0 r0 = kotlin.reflect.jvm.internal.b0.f55877a
            kotlin.reflect.jvm.internal.d r0 = r0.g(r11)
            java.lang.String r4 = r0.a()
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r2 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.j.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.w):void");
    }

    @Override // d2.b
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10) {
        return c.a.k(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // d2.c
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11) {
        return c.a.l(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // d2.d
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12) {
        return c.a.m(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // d2.e
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13) {
        return c.a.n(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // d2.f
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14) {
        return c.a.o(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // d2.g
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15) {
        return c.a.p(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // d2.h
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16) {
        return c.a.q(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // d2.i
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17) {
        return c.a.r(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // d2.j
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18) {
        return c.a.s(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // d2.k
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19) {
        return c.a.t(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // d2.m
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20) {
        return c.a.u(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // d2.n
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21) {
        return c.a.v(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // d2.o
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21, @Nullable Object obj22) {
        return c.a.w(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
