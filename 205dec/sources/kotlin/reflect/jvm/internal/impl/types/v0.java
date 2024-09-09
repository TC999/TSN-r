package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeAliasExpansion.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v0 {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f58437e = new a(null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final v0 f58438a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.z0 f58439b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<a1> f58440c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.a1, a1> f58441d;

    /* compiled from: TypeAliasExpansion.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final v0 a(@Nullable v0 v0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 typeAliasDescriptor, @NotNull List<? extends a1> arguments) {
            int Z;
            List T5;
            Map B0;
            kotlin.jvm.internal.f0.p(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.f0.p(arguments, "arguments");
            List<kotlin.reflect.jvm.internal.impl.descriptors.a1> parameters = typeAliasDescriptor.j().getParameters();
            kotlin.jvm.internal.f0.o(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            Z = kotlin.collections.y.Z(parameters, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var : parameters) {
                arrayList.add(a1Var.a());
            }
            T5 = kotlin.collections.f0.T5(arrayList, arguments);
            B0 = kotlin.collections.z0.B0(T5);
            return new v0(v0Var, typeAliasDescriptor, arguments, B0, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private v0(v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var, List<? extends a1> list, Map<kotlin.reflect.jvm.internal.impl.descriptors.a1, ? extends a1> map) {
        this.f58438a = v0Var;
        this.f58439b = z0Var;
        this.f58440c = list;
        this.f58441d = map;
    }

    public /* synthetic */ v0(v0 v0Var, kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var, List list, Map map, kotlin.jvm.internal.u uVar) {
        this(v0Var, z0Var, list, map);
    }

    @NotNull
    public final List<a1> a() {
        return this.f58440c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.z0 b() {
        return this.f58439b;
    }

    @Nullable
    public final a1 c(@NotNull y0 constructor) {
        kotlin.jvm.internal.f0.p(constructor, "constructor");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = constructor.b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1) {
            return this.f58441d.get(b4);
        }
        return null;
    }

    public final boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 descriptor) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        if (!kotlin.jvm.internal.f0.g(this.f58439b, descriptor)) {
            v0 v0Var = this.f58438a;
            if (!(v0Var == null ? false : v0Var.d(descriptor))) {
                return false;
            }
        }
        return true;
    }
}
