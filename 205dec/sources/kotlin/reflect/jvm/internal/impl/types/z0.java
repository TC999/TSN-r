package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitution.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class z0 extends d1 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f58460c = new a(null);

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: TypeSubstitution.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.z0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1186a extends z0 {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Map<y0, a1> f58461d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ boolean f58462e;

            /* JADX WARN: Multi-variable type inference failed */
            C1186a(Map<y0, ? extends a1> map, boolean z3) {
                this.f58461d = map;
                this.f58462e = z3;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.d1
            public boolean a() {
                return this.f58462e;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.d1
            public boolean f() {
                return this.f58461d.isEmpty();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.z0
            @Nullable
            public a1 k(@NotNull y0 key) {
                kotlin.jvm.internal.f0.p(key, "key");
                return this.f58461d.get(key);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ z0 e(a aVar, Map map, boolean z3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                z3 = false;
            }
            return aVar.d(map, z3);
        }

        @JvmStatic
        @NotNull
        public final d1 a(@NotNull e0 kotlinType) {
            kotlin.jvm.internal.f0.p(kotlinType, "kotlinType");
            return b(kotlinType.H0(), kotlinType.G0());
        }

        @JvmStatic
        @NotNull
        public final d1 b(@NotNull y0 typeConstructor, @NotNull List<? extends a1> arguments) {
            Object g32;
            int Z;
            List T5;
            Map B0;
            kotlin.jvm.internal.f0.p(typeConstructor, "typeConstructor");
            kotlin.jvm.internal.f0.p(arguments, "arguments");
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = typeConstructor.getParameters();
            kotlin.jvm.internal.f0.o(parameters, "typeConstructor.parameters");
            g32 = kotlin.collections.f0.g3(parameters);
            kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var = (kotlin.reflect.jvm.internal.impl.descriptors.a1) g32;
            if (a1Var != null && a1Var.S()) {
                List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters2 = typeConstructor.getParameters();
                kotlin.jvm.internal.f0.o(parameters2, "typeConstructor.parameters");
                Z = kotlin.collections.y.Z(parameters2, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var2 : parameters2) {
                    arrayList.add(a1Var2.j());
                }
                T5 = kotlin.collections.f0.T5(arrayList, arguments);
                B0 = kotlin.collections.z0.B0(T5);
                return e(this, B0, false, 2, null);
            }
            return new c0(parameters, arguments);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final z0 c(@NotNull Map<y0, ? extends a1> map) {
            kotlin.jvm.internal.f0.p(map, "map");
            return e(this, map, false, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final z0 d(@NotNull Map<y0, ? extends a1> map, boolean z3) {
            kotlin.jvm.internal.f0.p(map, "map");
            return new C1186a(map, z3);
        }
    }

    @JvmStatic
    @NotNull
    public static final d1 i(@NotNull y0 y0Var, @NotNull List<? extends a1> list) {
        return f58460c.b(y0Var, list);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final z0 j(@NotNull Map<y0, ? extends a1> map) {
        return f58460c.c(map);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @Nullable
    public a1 e(@NotNull e0 key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return k(key.H0());
    }

    @Nullable
    public abstract a1 k(@NotNull y0 y0Var);
}
