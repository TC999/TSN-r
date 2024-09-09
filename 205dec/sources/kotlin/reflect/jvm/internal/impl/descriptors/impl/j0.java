package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeAliasConstructorDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j0 extends p implements i0 {
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.n D;
    @NotNull
    private final z0 E;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.j F;
    @NotNull
    private kotlin.reflect.jvm.internal.impl.descriptors.c G;
    static final /* synthetic */ kotlin.reflect.n<Object>[] I = {kotlin.jvm.internal.n0.u(new PropertyReference1Impl(kotlin.jvm.internal.n0.d(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    @NotNull
    public static final a H = new a(null);

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f1 c(z0 z0Var) {
            if (z0Var.w() == null) {
                return null;
            }
            return f1.f(z0Var.I());
        }

        @Nullable
        public final i0 b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull z0 typeAliasDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.c constructor) {
            kotlin.reflect.jvm.internal.impl.descriptors.c c4;
            kotlin.jvm.internal.f0.p(storageManager, "storageManager");
            kotlin.jvm.internal.f0.p(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.f0.p(constructor, "constructor");
            f1 c5 = c(typeAliasDescriptor);
            if (c5 == null || (c4 = constructor.c(c5)) == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = constructor.getAnnotations();
            CallableMemberDescriptor.Kind i4 = constructor.i();
            kotlin.jvm.internal.f0.o(i4, "constructor.kind");
            v0 source = typeAliasDescriptor.getSource();
            kotlin.jvm.internal.f0.o(source, "typeAliasDescriptor.source");
            j0 j0Var = new j0(storageManager, typeAliasDescriptor, c4, null, annotations, i4, source, null);
            List<d1> J0 = p.J0(j0Var, constructor.h(), c5);
            if (J0 == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.types.m0 c6 = kotlin.reflect.jvm.internal.impl.types.b0.c(c4.getReturnType().K0());
            kotlin.reflect.jvm.internal.impl.types.m0 q3 = typeAliasDescriptor.q();
            kotlin.jvm.internal.f0.o(q3, "typeAliasDescriptor.defaultType");
            kotlin.reflect.jvm.internal.impl.types.m0 j4 = p0.j(c6, q3);
            s0 M = constructor.M();
            j0Var.M0(M != null ? kotlin.reflect.jvm.internal.impl.resolve.c.f(j0Var, c5.n(M.getType(), Variance.INVARIANT), kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b()) : null, null, typeAliasDescriptor.r(), J0, j4, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return j0Var;
        }
    }

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<j0> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.c f56388b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.reflect.jvm.internal.impl.descriptors.c cVar) {
            super(0);
            this.f56388b = cVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final j0 invoke() {
            kotlin.reflect.jvm.internal.impl.storage.n N = j0.this.N();
            z0 j12 = j0.this.j1();
            kotlin.reflect.jvm.internal.impl.descriptors.c cVar = this.f56388b;
            j0 j0Var = j0.this;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = cVar.getAnnotations();
            CallableMemberDescriptor.Kind i4 = this.f56388b.i();
            kotlin.jvm.internal.f0.o(i4, "underlyingConstructorDescriptor.kind");
            v0 source = j0.this.j1().getSource();
            kotlin.jvm.internal.f0.o(source, "typeAliasDescriptor.source");
            j0 j0Var2 = new j0(N, j12, cVar, j0Var, annotations, i4, source, null);
            j0 j0Var3 = j0.this;
            kotlin.reflect.jvm.internal.impl.descriptors.c cVar2 = this.f56388b;
            f1 c4 = j0.H.c(j0Var3.j1());
            if (c4 == null) {
                return null;
            }
            s0 M = cVar2.M();
            j0Var2.M0(null, M == null ? null : M.c(c4), j0Var3.j1().r(), j0Var3.h(), j0Var3.getReturnType(), Modality.FINAL, j0Var3.j1().getVisibility());
            return j0Var2;
        }
    }

    private j0(kotlin.reflect.jvm.internal.impl.storage.n nVar, z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, i0 i0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, CallableMemberDescriptor.Kind kind, v0 v0Var) {
        super(z0Var, i0Var, fVar, kotlin.reflect.jvm.internal.impl.name.h.f57585i, kind, v0Var);
        this.D = nVar;
        this.E = z0Var;
        Q0(j1().X());
        this.F = nVar.i(new b(cVar));
        this.G = cVar;
    }

    public /* synthetic */ j0(kotlin.reflect.jvm.internal.impl.storage.n nVar, z0 z0Var, kotlin.reflect.jvm.internal.impl.descriptors.c cVar, i0 i0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, CallableMemberDescriptor.Kind kind, v0 v0Var, kotlin.jvm.internal.u uVar) {
        this(nVar, z0Var, cVar, i0Var, fVar, kind, v0Var);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n N() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.i0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.c T() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    public boolean b0() {
        return T().b0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d c0() {
        kotlin.reflect.jvm.internal.impl.descriptors.d c02 = T().c0();
        kotlin.jvm.internal.f0.o(c02, "underlyingConstructorDescriptor.constructedClass");
        return c02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: f1 */
    public i0 P(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s visibility, @NotNull CallableMemberDescriptor.Kind kind, boolean z3) {
        kotlin.jvm.internal.f0.p(newOwner, "newOwner");
        kotlin.jvm.internal.f0.p(modality, "modality");
        kotlin.jvm.internal.f0.p(visibility, "visibility");
        kotlin.jvm.internal.f0.p(kind, "kind");
        kotlin.reflect.jvm.internal.impl.descriptors.w build = x().q(newOwner).k(modality).h(visibility).r(kind).o(z3).build();
        if (build != null) {
            return (i0) build;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    /* renamed from: g1 */
    public j0 G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull v0 source) {
        kotlin.jvm.internal.f0.p(newOwner, "newOwner");
        kotlin.jvm.internal.f0.p(kind, "kind");
        kotlin.jvm.internal.f0.p(annotations, "annotations");
        kotlin.jvm.internal.f0.p(source, "source");
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind != kind2) {
            CallableMemberDescriptor.Kind kind3 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new j0(this.D, j1(), T(), this, annotations, kind2, source);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.e0 returnType = super.getReturnType();
        kotlin.jvm.internal.f0.m(returnType);
        kotlin.jvm.internal.f0.o(returnType, "super.getReturnType()!!");
        return returnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: h1 */
    public z0 b() {
        return j1();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: i1 */
    public i0 h0() {
        return (i0) super.h0();
    }

    @NotNull
    public z0 j1() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.x0
    @Nullable
    /* renamed from: k1 */
    public i0 c(@NotNull f1 substitutor) {
        kotlin.jvm.internal.f0.p(substitutor, "substitutor");
        kotlin.reflect.jvm.internal.impl.descriptors.w c4 = super.c(substitutor);
        if (c4 != null) {
            j0 j0Var = (j0) c4;
            f1 f4 = f1.f(j0Var.getReturnType());
            kotlin.jvm.internal.f0.o(f4, "create(substitutedTypeAliasConstructor.returnType)");
            kotlin.reflect.jvm.internal.impl.descriptors.c c5 = T().a().c(f4);
            if (c5 == null) {
                return null;
            }
            j0Var.G = c5;
            return j0Var;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
    }
}
