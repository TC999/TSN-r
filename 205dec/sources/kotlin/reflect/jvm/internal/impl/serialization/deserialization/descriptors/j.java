package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.p;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j extends g0 implements c {
    @NotNull
    private final ProtoBuf.Function D;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c E;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g F;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h G;
    @Nullable
    private final f H;

    public /* synthetic */ j(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, kotlin.reflect.jvm.internal.impl.name.f fVar2, CallableMemberDescriptor.Kind kind, ProtoBuf.Function function, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, f fVar3, v0 v0Var, int i4, u uVar) {
        this(kVar, u0Var, fVar, fVar2, kind, function, cVar, gVar, hVar, fVar3, (i4 & 1024) != 0 ? null : v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.g G() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.g0, kotlin.reflect.jvm.internal.impl.descriptors.impl.p
    @NotNull
    protected p G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @Nullable w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull v0 source) {
        kotlin.reflect.jvm.internal.impl.name.f fVar2;
        f0.p(newOwner, "newOwner");
        f0.p(kind, "kind");
        f0.p(annotations, "annotations");
        f0.p(source, "source");
        u0 u0Var = (u0) wVar;
        if (fVar == null) {
            kotlin.reflect.jvm.internal.impl.name.f name = getName();
            f0.o(name, "name");
            fVar2 = name;
        } else {
            fVar2 = fVar;
        }
        j jVar = new j(newOwner, u0Var, annotations, fVar2, kind, d0(), J(), G(), l1(), K(), source);
        jVar.T0(L0());
        return jVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.c J() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @Nullable
    public f K() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    /* renamed from: k1 */
    public ProtoBuf.Function d0() {
        return this.D;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h l1() {
        return this.G;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @Nullable u0 u0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf.Function proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h versionRequirementTable, @Nullable f fVar, @Nullable v0 v0Var) {
        super(containingDeclaration, u0Var, annotations, name, kind, v0Var == null ? v0.f56634a : v0Var);
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(annotations, "annotations");
        f0.p(name, "name");
        f0.p(kind, "kind");
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        f0.p(versionRequirementTable, "versionRequirementTable");
        this.D = proto;
        this.E = nameResolver;
        this.F = typeTable;
        this.G = versionRequirementTable;
        this.H = fVar;
    }
}
