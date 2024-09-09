package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: context.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final i f58138a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f58139b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f58140c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g f58141d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h f58142e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f58143f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f f58144g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final b0 f58145h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final u f58146i;

    public k(@NotNull i components, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h versionRequirementTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f fVar, @Nullable b0 b0Var, @NotNull List<ProtoBuf.TypeParameter> typeParameters) {
        f0.p(components, "components");
        f0.p(nameResolver, "nameResolver");
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(typeTable, "typeTable");
        f0.p(versionRequirementTable, "versionRequirementTable");
        f0.p(metadataVersion, "metadataVersion");
        f0.p(typeParameters, "typeParameters");
        this.f58138a = components;
        this.f58139b = nameResolver;
        this.f58140c = containingDeclaration;
        this.f58141d = typeTable;
        this.f58142e = versionRequirementTable;
        this.f58143f = metadataVersion;
        this.f58144g = fVar;
        this.f58145h = new b0(this, b0Var, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + '\"', fVar == null ? "[container not found]" : fVar.a());
        this.f58146i = new u(this);
    }

    public static /* synthetic */ k b(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, List list, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.a aVar, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            cVar = kVar.f58139b;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar2 = cVar;
        if ((i4 & 8) != 0) {
            gVar = kVar.f58141d;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar2 = gVar;
        if ((i4 & 16) != 0) {
            hVar = kVar.f58142e;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar2 = hVar;
        if ((i4 & 32) != 0) {
            aVar = kVar.f58143f;
        }
        return kVar.a(kVar2, list, cVar2, gVar2, hVar2, aVar);
    }

    @NotNull
    public final k a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k descriptor, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion) {
        f0.p(descriptor, "descriptor");
        f0.p(typeParameterProtos, "typeParameterProtos");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h versionRequirementTable = hVar;
        f0.p(versionRequirementTable, "versionRequirementTable");
        f0.p(metadataVersion, "metadataVersion");
        i iVar = this.f58138a;
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.i.b(metadataVersion)) {
            versionRequirementTable = this.f58142e;
        }
        return new k(iVar, nameResolver, descriptor, typeTable, versionRequirementTable, metadataVersion, this.f58144g, this.f58145h, typeParameterProtos);
    }

    @NotNull
    public final i c() {
        return this.f58138a;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f d() {
        return this.f58144g;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.k e() {
        return this.f58140c;
    }

    @NotNull
    public final u f() {
        return this.f58146i;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c g() {
        return this.f58139b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.storage.n h() {
        return this.f58138a.u();
    }

    @NotNull
    public final b0 i() {
        return this.f58145h;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g j() {
        return this.f58141d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.h k() {
        return this.f58142e;
    }
}
