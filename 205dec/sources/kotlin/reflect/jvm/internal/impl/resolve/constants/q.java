package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q extends g<b> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f57853b = new a(null);

    /* compiled from: constantValues.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @Nullable
        public final g<?> a(@NotNull e0 argumentType) {
            Object S4;
            f0.p(argumentType, "argumentType");
            if (g0.a(argumentType)) {
                return null;
            }
            e0 e0Var = argumentType;
            int i4 = 0;
            while (kotlin.reflect.jvm.internal.impl.builtins.h.c0(e0Var)) {
                S4 = kotlin.collections.f0.S4(e0Var.G0());
                e0Var = ((a1) S4).getType();
                f0.o(e0Var, "type.arguments.single().type");
                i4++;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
            if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                kotlin.reflect.jvm.internal.impl.name.b h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(b4);
                return h4 == null ? new q(new b.a(argumentType)) : new q(h4, i4);
            } else if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
                kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.f56093b.l());
                f0.o(m4, "topLevel(StandardNames.FqNames.any.toSafe())");
                return new q(m4, 0);
            } else {
                return null;
            }
        }
    }

    /* compiled from: constantValues.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class b {

        /* compiled from: constantValues.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final e0 f57854a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull e0 type) {
                super(null);
                f0.p(type, "type");
                this.f57854a = type;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && f0.g(this.f57854a, ((a) obj).f57854a);
            }

            @NotNull
            public final e0 getType() {
                return this.f57854a;
            }

            public int hashCode() {
                return this.f57854a.hashCode();
            }

            @NotNull
            public String toString() {
                return "LocalClass(type=" + this.f57854a + ')';
            }
        }

        /* compiled from: constantValues.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.constants.q$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1167b extends b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final f f57855a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1167b(@NotNull f value) {
                super(null);
                f0.p(value, "value");
                this.f57855a = value;
            }

            public final int a() {
                return this.f57855a.c();
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.name.b b() {
                return this.f57855a.d();
            }

            @NotNull
            public final f c() {
                return this.f57855a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1167b) && f0.g(this.f57855a, ((C1167b) obj).f57855a);
            }

            public int hashCode() {
                return this.f57855a.hashCode();
            }

            @NotNull
            public String toString() {
                return "NormalClass(value=" + this.f57855a + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull b value) {
        super(value);
        f0.p(value, "value");
    }

    @NotNull
    public final e0 b(@NotNull d0 module) {
        f0.p(module, "module");
        b a4 = a();
        if (a4 instanceof b.a) {
            return ((b.a) a()).getType();
        }
        if (a4 instanceof b.C1167b) {
            f c4 = ((b.C1167b) a()).c();
            kotlin.reflect.jvm.internal.impl.name.b a5 = c4.a();
            int b4 = c4.b();
            kotlin.reflect.jvm.internal.impl.descriptors.d a6 = kotlin.reflect.jvm.internal.impl.descriptors.v.a(module, a5);
            if (a6 == null) {
                m0 j4 = kotlin.reflect.jvm.internal.impl.types.w.j("Unresolved type: " + a5 + " (arrayDimensions=" + b4 + ')');
                f0.o(j4, "createErrorType(\"Unresol\u2026sions=$arrayDimensions)\")");
                return j4;
            }
            m0 q3 = a6.q();
            f0.o(q3, "descriptor.defaultType");
            e0 t3 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.t(q3);
            int i4 = 0;
            while (i4 < b4) {
                i4++;
                t3 = module.k().l(Variance.INVARIANT, t3);
                f0.o(t3, "module.builtIns.getArray\u2026Variance.INVARIANT, type)");
            }
            return t3;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public e0 getType(@NotNull d0 module) {
        List l4;
        f0.p(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d E = module.k().E();
        f0.o(E, "module.builtIns.kClass");
        l4 = kotlin.collections.x.l(new c1(b(module)));
        return kotlin.reflect.jvm.internal.impl.types.f0.g(b4, E, l4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(@NotNull f value) {
        this(new b.C1167b(value));
        f0.p(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, int i4) {
        this(new f(classId, i4));
        f0.p(classId, "classId");
    }
}
