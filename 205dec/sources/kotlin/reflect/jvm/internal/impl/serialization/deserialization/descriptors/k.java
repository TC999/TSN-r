package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.i0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k extends kotlin.reflect.jvm.internal.impl.descriptors.impl.d implements g {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final n f58088h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final ProtoBuf.TypeAlias f58089i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f58090j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g f58091k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f58092l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final f f58093m;

    /* renamed from: n  reason: collision with root package name */
    private Collection<? extends i0> f58094n;

    /* renamed from: o  reason: collision with root package name */
    private m0 f58095o;

    /* renamed from: p  reason: collision with root package name */
    private m0 f58096p;

    /* renamed from: q  reason: collision with root package name */
    private List<? extends a1> f58097q;

    /* renamed from: r  reason: collision with root package name */
    private m0 f58098r;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.storage.n r13, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.k r14, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f r15, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r16, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.s r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c r19, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g r20, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h r21, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f r22) {
        /*
            r12 = this;
            r6 = r12
            r7 = r13
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            java.lang.String r0 = "storageManager"
            kotlin.jvm.internal.f0.p(r13, r0)
            java.lang.String r0 = "containingDeclaration"
            r1 = r14
            kotlin.jvm.internal.f0.p(r14, r0)
            java.lang.String r0 = "annotations"
            r2 = r15
            kotlin.jvm.internal.f0.p(r15, r0)
            java.lang.String r0 = "name"
            r3 = r16
            kotlin.jvm.internal.f0.p(r3, r0)
            java.lang.String r0 = "visibility"
            r5 = r17
            kotlin.jvm.internal.f0.p(r5, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.f0.p(r8, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.f0.p(r9, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.f0.p(r10, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.f0.p(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.v0 r4 = kotlin.reflect.jvm.internal.impl.descriptors.v0.f56634a
            java.lang.String r0 = "NO_SOURCE"
            kotlin.jvm.internal.f0.o(r4, r0)
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f58088h = r7
            r6.f58089i = r8
            r6.f58090j = r9
            r6.f58091k = r10
            r6.f58092l = r11
            r0 = r22
            r6.f58093m = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k.<init>(kotlin.reflect.jvm.internal.impl.storage.n, kotlin.reflect.jvm.internal.impl.descriptors.k, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f, kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.s, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.g G() {
        return this.f58091k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.d
    @NotNull
    protected List<a1> H0() {
        List list = this.f58097q;
        if (list == null) {
            f0.S("typeConstructorParameters");
            return null;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    @NotNull
    public m0 I() {
        m0 m0Var = this.f58096p;
        if (m0Var != null) {
            return m0Var;
        }
        f0.S("expandedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.c J() {
        return this.f58090j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    /* renamed from: J0 */
    public ProtoBuf.TypeAlias d0() {
        return this.f58089i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @Nullable
    public f K() {
        return this.f58093m;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h K0() {
        return this.f58092l;
    }

    public final void L0(@NotNull List<? extends a1> declaredTypeParameters, @NotNull m0 underlyingType, @NotNull m0 expandedType) {
        f0.p(declaredTypeParameters, "declaredTypeParameters");
        f0.p(underlyingType, "underlyingType");
        f0.p(expandedType, "expandedType");
        I0(declaredTypeParameters);
        this.f58095o = underlyingType;
        this.f58096p = expandedType;
        this.f58097q = b1.d(this);
        this.f58098r = C0();
        this.f58094n = G0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    @NotNull
    /* renamed from: M0 */
    public z0 c(@NotNull f1 substitutor) {
        f0.p(substitutor, "substitutor");
        if (substitutor.k()) {
            return this;
        }
        n N = N();
        kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration = b();
        f0.o(containingDeclaration, "containingDeclaration");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = getAnnotations();
        f0.o(annotations, "annotations");
        kotlin.reflect.jvm.internal.impl.name.f name = getName();
        f0.o(name, "name");
        k kVar = new k(N, containingDeclaration, annotations, name, getVisibility(), d0(), J(), G(), K0(), K());
        List<a1> r3 = r();
        m0 r02 = r0();
        Variance variance = Variance.INVARIANT;
        e0 n4 = substitutor.n(r02, variance);
        f0.o(n4, "substitutor.safeSubstitu\u2026Type, Variance.INVARIANT)");
        m0 a4 = e1.a(n4);
        e0 n5 = substitutor.n(I(), variance);
        f0.o(n5, "substitutor.safeSubstitu\u2026Type, Variance.INVARIANT)");
        kVar.L0(r3, a4, e1.a(n5));
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.d
    @NotNull
    protected n N() {
        return this.f58088h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public m0 q() {
        m0 m0Var = this.f58098r;
        if (m0Var == null) {
            f0.S("defaultTypeImpl");
            return null;
        }
        return m0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    @NotNull
    public m0 r0() {
        m0 m0Var = this.f58095o;
        if (m0Var != null) {
            return m0Var;
        }
        f0.S("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d w() {
        if (g0.a(I())) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = I().H0().b();
        if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
        }
        return null;
    }
}
