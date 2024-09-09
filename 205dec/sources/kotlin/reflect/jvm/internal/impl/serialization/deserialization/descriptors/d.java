package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.descriptors.impl.f implements c {
    @NotNull
    private final ProtoBuf.Constructor F;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c G;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g H;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h I;
    @Nullable
    private final f J;

    public /* synthetic */ d(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, kotlin.reflect.jvm.internal.impl.descriptors.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, CallableMemberDescriptor.Kind kind, ProtoBuf.Constructor constructor, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, f fVar2, v0 v0Var, int i4, u uVar) {
        this(dVar, jVar, fVar, z3, kind, constructor, cVar, gVar, hVar, fVar2, (i4 & 1024) != 0 ? null : v0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean E() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.g G() {
        return this.H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.c J() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @Nullable
    public f K() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.p, kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isSuspend() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.f
    @NotNull
    /* renamed from: m1 */
    public d i1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @Nullable w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull v0 source) {
        f0.p(newOwner, "newOwner");
        f0.p(kind, "kind");
        f0.p(annotations, "annotations");
        f0.p(source, "source");
        d dVar = new d((kotlin.reflect.jvm.internal.impl.descriptors.d) newOwner, (kotlin.reflect.jvm.internal.impl.descriptors.j) wVar, annotations, this.D, kind, d0(), J(), G(), o1(), K(), source);
        dVar.T0(L0());
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    /* renamed from: n1 */
    public ProtoBuf.Constructor d0() {
        return this.F;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h o1() {
        return this.I;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingDeclaration, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.j jVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, boolean z3, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf.Constructor proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h versionRequirementTable, @Nullable f fVar, @Nullable v0 v0Var) {
        super(containingDeclaration, jVar, annotations, z3, kind, v0Var == null ? v0.f56634a : v0Var);
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(annotations, "annotations");
        f0.p(kind, "kind");
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        f0.p(versionRequirementTable, "versionRequirementTable");
        this.F = proto;
        this.G = nameResolver;
        this.H = typeTable;
        this.I = versionRequirementTable;
        this.J = fVar;
    }
}
