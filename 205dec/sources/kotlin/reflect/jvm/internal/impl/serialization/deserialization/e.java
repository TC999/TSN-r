package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassData.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f58103a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProtoBuf.Class f58104b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f58105c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final v0 f58106d;

    public e(@NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull ProtoBuf.Class classProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull v0 sourceElement) {
        f0.p(nameResolver, "nameResolver");
        f0.p(classProto, "classProto");
        f0.p(metadataVersion, "metadataVersion");
        f0.p(sourceElement, "sourceElement");
        this.f58103a = nameResolver;
        this.f58104b = classProto;
        this.f58105c = metadataVersion;
        this.f58106d = sourceElement;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c a() {
        return this.f58103a;
    }

    @NotNull
    public final ProtoBuf.Class b() {
        return this.f58104b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a c() {
        return this.f58105c;
    }

    @NotNull
    public final v0 d() {
        return this.f58106d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return f0.g(this.f58103a, eVar.f58103a) && f0.g(this.f58104b, eVar.f58104b) && f0.g(this.f58105c, eVar.f58105c) && f0.g(this.f58106d, eVar.f58106d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f58103a.hashCode() * 31) + this.f58104b.hashCode()) * 31) + this.f58105c.hashCode()) * 31) + this.f58106d.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClassData(nameResolver=" + this.f58103a + ", classProto=" + this.f58104b + ", metadataVersion=" + this.f58105c + ", sourceElement=" + this.f58106d + ')';
    }
}
