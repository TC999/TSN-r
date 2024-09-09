package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ValueParameterDescriptorImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class l0 extends m0 implements d1 {
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public static final a f56394m = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final int f56395g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f56396h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f56397i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f56398j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.e0 f56399k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final d1 f56400l;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final l0 a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, @Nullable d1 d1Var, int i4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.types.e0 outType, boolean z3, boolean z4, boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull v0 source, @Nullable d2.a<? extends List<? extends f1>> aVar) {
            kotlin.jvm.internal.f0.p(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.f0.p(annotations, "annotations");
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(outType, "outType");
            kotlin.jvm.internal.f0.p(source, "source");
            if (aVar == null) {
                return new l0(containingDeclaration, d1Var, i4, annotations, name, outType, z3, z4, z5, e0Var, source);
            }
            return new b(containingDeclaration, d1Var, i4, annotations, name, outType, z3, z4, z5, e0Var, source, aVar);
        }
    }

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends l0 {
        @NotNull

        /* renamed from: n  reason: collision with root package name */
        private final kotlin.p f56401n;

        /* compiled from: ValueParameterDescriptorImpl.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<List<? extends f1>> {
            a() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            public final List<? extends f1> invoke() {
                return b.this.J0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, @Nullable d1 d1Var, int i4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.types.e0 outType, boolean z3, boolean z4, boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull v0 source, @NotNull d2.a<? extends List<? extends f1>> destructuringVariables) {
            super(containingDeclaration, d1Var, i4, annotations, name, outType, z3, z4, z5, e0Var, source);
            kotlin.p a4;
            kotlin.jvm.internal.f0.p(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.f0.p(annotations, "annotations");
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(outType, "outType");
            kotlin.jvm.internal.f0.p(source, "source");
            kotlin.jvm.internal.f0.p(destructuringVariables, "destructuringVariables");
            a4 = kotlin.r.a(destructuringVariables);
            this.f56401n = a4;
        }

        @NotNull
        public final List<f1> J0() {
            return (List) this.f56401n.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l0, kotlin.reflect.jvm.internal.impl.descriptors.d1
        @NotNull
        public d1 Y(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, @NotNull kotlin.reflect.jvm.internal.impl.name.f newName, int i4) {
            kotlin.jvm.internal.f0.p(newOwner, "newOwner");
            kotlin.jvm.internal.f0.p(newName, "newName");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = getAnnotations();
            kotlin.jvm.internal.f0.o(annotations, "annotations");
            kotlin.reflect.jvm.internal.impl.types.e0 type = getType();
            kotlin.jvm.internal.f0.o(type, "type");
            boolean x02 = x0();
            boolean p02 = p0();
            boolean n02 = n0();
            kotlin.reflect.jvm.internal.impl.types.e0 t02 = t0();
            v0 NO_SOURCE = v0.f56634a;
            kotlin.jvm.internal.f0.o(NO_SOURCE, "NO_SOURCE");
            return new b(newOwner, null, i4, annotations, newName, type, x02, p02, n02, t02, NO_SOURCE, new a());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a containingDeclaration, @Nullable d1 d1Var, int i4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull kotlin.reflect.jvm.internal.impl.types.e0 outType, boolean z3, boolean z4, boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull v0 source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.f0.p(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(outType, "outType");
        kotlin.jvm.internal.f0.p(source, "source");
        this.f56395g = i4;
        this.f56396h = z3;
        this.f56397i = z4;
        this.f56398j = z5;
        this.f56399k = e0Var;
        this.f56400l = d1Var == null ? this : d1Var;
    }

    @JvmStatic
    @NotNull
    public static final l0 G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @Nullable d1 d1Var, int i4, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var, boolean z3, boolean z4, boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var2, @NotNull v0 v0Var, @Nullable d2.a<? extends List<? extends f1>> aVar2) {
        return f56394m.a(aVar, d1Var, i4, fVar, fVar2, e0Var, z3, z4, z5, e0Var2, v0Var, aVar2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> visitor, D d4) {
        kotlin.jvm.internal.f0.p(visitor, "visitor");
        return visitor.f(this, d4);
    }

    @Nullable
    public Void H0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    @NotNull
    /* renamed from: I0 */
    public d1 c(@NotNull kotlin.reflect.jvm.internal.impl.types.f1 substitutor) {
        kotlin.jvm.internal.f0.p(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean O() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    @NotNull
    public d1 Y(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a newOwner, @NotNull kotlin.reflect.jvm.internal.impl.name.f newName, int i4) {
        kotlin.jvm.internal.f0.p(newOwner, "newOwner");
        kotlin.jvm.internal.f0.p(newName, "newName");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = getAnnotations();
        kotlin.jvm.internal.f0.o(annotations, "annotations");
        kotlin.reflect.jvm.internal.impl.types.e0 type = getType();
        kotlin.jvm.internal.f0.o(type, "type");
        boolean x02 = x0();
        boolean p02 = p0();
        boolean n02 = n0();
        kotlin.reflect.jvm.internal.impl.types.e0 t02 = t0();
        v0 NO_SOURCE = v0.f56634a;
        kotlin.jvm.internal.f0.o(NO_SOURCE, "NO_SOURCE");
        return new l0(newOwner, null, i4, annotations, newName, type, x02, p02, n02, t02, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<d1> d() {
        int Z;
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> d4 = b().d();
        kotlin.jvm.internal.f0.o(d4, "containingDeclaration.overriddenDescriptors");
        Z = kotlin.collections.y.Z(d4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (kotlin.reflect.jvm.internal.impl.descriptors.a aVar : d4) {
            arrayList.add(aVar.h().get(f()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public int f() {
        return this.f56395g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.r.f56532f;
        kotlin.jvm.internal.f0.o(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.constants.g m0() {
        return (kotlin.reflect.jvm.internal.impl.resolve.constants.g) H0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public boolean n0() {
        return this.f56398j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public boolean p0() {
        return this.f56397i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.types.e0 t0() {
        return this.f56399k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean v0() {
        return d1.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d1
    public boolean x0() {
        return this.f56396h && ((CallableMemberDescriptor) b()).i().isReal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.a b() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) super.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: a */
    public d1 h0() {
        d1 d1Var = this.f56400l;
        return d1Var == this ? this : d1Var.a();
    }
}
