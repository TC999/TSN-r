package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedMemberDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i extends c0 implements c {
    @NotNull
    private final ProtoBuf.Property C;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c D;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g E;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h F;
    @Nullable
    private final f G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @Nullable p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations, @NotNull Modality modality, @NotNull s visibility, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull CallableMemberDescriptor.Kind kind, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h versionRequirementTable, @Nullable f fVar) {
        super(containingDeclaration, p0Var, annotations, modality, visibility, z3, name, kind, v0.f56634a, z4, z5, z8, false, z6, z7);
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(annotations, "annotations");
        f0.p(modality, "modality");
        f0.p(visibility, "visibility");
        f0.p(name, "name");
        f0.p(kind, "kind");
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        f0.p(versionRequirementTable, "versionRequirementTable");
        this.C = proto;
        this.D = nameResolver;
        this.E = typeTable;
        this.F = versionRequirementTable;
        this.G = fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.g G() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.c J() {
        return this.D;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @Nullable
    public f K() {
        return this.G;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0
    @NotNull
    protected c0 K0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k newOwner, @NotNull Modality newModality, @NotNull s newVisibility, @Nullable p0 p0Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull kotlin.reflect.jvm.internal.impl.name.f newName, @NotNull v0 source) {
        f0.p(newOwner, "newOwner");
        f0.p(newModality, "newModality");
        f0.p(newVisibility, "newVisibility");
        f0.p(kind, "kind");
        f0.p(newName, "newName");
        f0.p(source, "source");
        return new i(newOwner, p0Var, getAnnotations(), newModality, newVisibility, O(), newName, kind, v0(), isConst(), isExternal(), D(), i0(), d0(), J(), G(), Z0(), K());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g
    @NotNull
    /* renamed from: Y0 */
    public ProtoBuf.Property d0() {
        return this.C;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.h Z0() {
        return this.F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c0, kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.D.d(d0().getFlags());
        f0.o(d4, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return d4.booleanValue();
    }
}
