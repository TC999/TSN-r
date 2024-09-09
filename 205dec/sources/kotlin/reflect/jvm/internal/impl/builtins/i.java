package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.x;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.u;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.r0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectionTypes.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final f0 f56060a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final p f56061b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final a f56062c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final a f56063d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final a f56064e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final a f56065f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final a f56066g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final a f56067h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final a f56068i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final a f56069j;

    /* renamed from: l  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56059l = {n0.u(new PropertyReference1Impl(n0.d(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"))};
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final b f56058k = new b(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReflectionTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f56070a;

        public a(int i4) {
            this.f56070a = i4;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull i types, @NotNull n<?> property) {
            kotlin.jvm.internal.f0.p(types, "types");
            kotlin.jvm.internal.f0.p(property, "property");
            return types.b(s2.a.a(property.getName()), this.f56070a);
        }
    }

    /* compiled from: ReflectionTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @Nullable
        public final e0 a(@NotNull d0 module) {
            Object S4;
            List l4;
            kotlin.jvm.internal.f0.p(module, "module");
            kotlin.reflect.jvm.internal.impl.descriptors.d a4 = v.a(module, j.a.f56118n0);
            if (a4 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
            List<a1> parameters = a4.j().getParameters();
            kotlin.jvm.internal.f0.o(parameters, "kPropertyClass.typeConstructor.parameters");
            S4 = kotlin.collections.f0.S4(parameters);
            kotlin.jvm.internal.f0.o(S4, "kPropertyClass.typeConstructor.parameters.single()");
            l4 = x.l(new r0((a1) S4));
            return kotlin.reflect.jvm.internal.impl.types.f0.g(b4, a4, l4);
        }
    }

    /* compiled from: ReflectionTypes.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0 f56071a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d0 d0Var) {
            super(0);
            this.f56071a = d0Var;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
            return this.f56071a.j0(j.f56081j).p();
        }
    }

    public i(@NotNull d0 module, @NotNull f0 notFoundClasses) {
        p c4;
        kotlin.jvm.internal.f0.p(module, "module");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        this.f56060a = notFoundClasses;
        c4 = r.c(LazyThreadSafetyMode.PUBLICATION, new c(module));
        this.f56061b = c4;
        this.f56062c = new a(1);
        this.f56063d = new a(1);
        this.f56064e = new a(1);
        this.f56065f = new a(2);
        this.f56066g = new a(3);
        this.f56067h = new a(1);
        this.f56068i = new a(2);
        this.f56069j = new a(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(String str, int i4) {
        List<Integer> l4;
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(str);
        kotlin.jvm.internal.f0.o(f4, "identifier(className)");
        kotlin.reflect.jvm.internal.impl.descriptors.f h4 = d().h(f4, NoLookupLocation.FROM_REFLECTION);
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) h4 : null;
        if (dVar == null) {
            f0 f0Var = this.f56060a;
            kotlin.reflect.jvm.internal.impl.name.b bVar = new kotlin.reflect.jvm.internal.impl.name.b(j.f56081j, f4);
            l4 = x.l(Integer.valueOf(i4));
            return f0Var.d(bVar, l4);
        }
        return dVar;
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h d() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.h) this.f56061b.getValue();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d c() {
        return this.f56062c.a(this, f56059l[0]);
    }
}
