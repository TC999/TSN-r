package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.y0;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProtoBasedClassDataFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f58186a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f58187b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d2.l<kotlin.reflect.jvm.internal.impl.name.b, v0> f58188c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.b, ProtoBuf.Class> f58189d;

    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull ProtoBuf.PackageFragment proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.b, ? extends v0> classSource) {
        int Z;
        int j4;
        int n4;
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(metadataVersion, "metadataVersion");
        f0.p(classSource, "classSource");
        this.f58186a = nameResolver;
        this.f58187b = metadataVersion;
        this.f58188c = classSource;
        List<ProtoBuf.Class> class_List = proto.getClass_List();
        f0.o(class_List, "proto.class_List");
        Z = kotlin.collections.y.Z(class_List, 10);
        j4 = y0.j(Z);
        n4 = kotlin.ranges.q.n(j4, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
        for (Object obj : class_List) {
            linkedHashMap.put(v.a(this.f58186a, ((ProtoBuf.Class) obj).getFqName()), obj);
        }
        this.f58189d = linkedHashMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    @Nullable
    public e a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        f0.p(classId, "classId");
        ProtoBuf.Class r02 = this.f58189d.get(classId);
        if (r02 == null) {
            return null;
        }
        return new e(this.f58186a, r02, this.f58187b, this.f58188c.invoke(classId));
    }

    @NotNull
    public final Collection<kotlin.reflect.jvm.internal.impl.name.b> b() {
        return this.f58189d.keySet();
    }
}
