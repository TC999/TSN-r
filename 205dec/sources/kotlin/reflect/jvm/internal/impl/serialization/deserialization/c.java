package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c implements b<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final q2.a f57979a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d f57980b;

    /* compiled from: AnnotationAndConstantLoaderImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57981a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            f57981a = iArr;
        }
    }

    public c(@NotNull d0 module, @NotNull f0 notFoundClasses, @NotNull q2.a protocol) {
        kotlin.jvm.internal.f0.p(module, "module");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.f0.p(protocol, "protocol");
        this.f57979a = protocol;
        this.f57980b = new d(module, notFoundClasses);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> a(@NotNull x container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n callableProto, @NotNull AnnotatedCallableKind kind, int i4, @NotNull ProtoBuf.ValueParameter proto) {
        int Z;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(callableProto, "callableProto");
        kotlin.jvm.internal.f0.p(kind, "kind");
        kotlin.jvm.internal.f0.p(proto, "proto");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.f57979a.g());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.f57980b.a(annotation, container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b(@NotNull x.a container) {
        int Z;
        kotlin.jvm.internal.f0.p(container, "container");
        List<ProtoBuf.Annotation> list = (List) container.f().getExtension(this.f57979a.a());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.f57980b.a(annotation, container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> c(@NotNull ProtoBuf.Type proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        int Z;
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.f57979a.k());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.f57980b.a(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> d(@NotNull x container, @NotNull ProtoBuf.EnumEntry proto) {
        int Z;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(proto, "proto");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.f57979a.d());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.f57980b.a(annotation, container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> e(@NotNull x container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        List<ProtoBuf.Annotation> list;
        int Z;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(kind, "kind");
        if (proto instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) proto).getExtension(this.f57979a.c());
        } else if (proto instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) proto).getExtension(this.f57979a.f());
        } else if (!(proto instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(kotlin.jvm.internal.f0.C("Unknown message: ", proto).toString());
        } else {
            int i4 = a.f57981a[kind.ordinal()];
            if (i4 == 1) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.f57979a.h());
            } else if (i4 == 2) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.f57979a.i());
            } else if (i4 == 3) {
                list = (List) ((ProtoBuf.Property) proto).getExtension(this.f57979a.j());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.f57980b.a(annotation, container.b()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f(@NotNull ProtoBuf.TypeParameter proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        int Z;
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        List<ProtoBuf.Annotation> list = (List) proto.getExtension(this.f57979a.l());
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        Z = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation annotation : list) {
            arrayList.add(this.f57980b.a(annotation, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> h(@NotNull x container, @NotNull ProtoBuf.Property proto) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> F;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(proto, "proto");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> i(@NotNull x container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> F;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(kind, "kind");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> j(@NotNull x container, @NotNull ProtoBuf.Property proto) {
        List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> F;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(proto, "proto");
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @Nullable
    /* renamed from: k */
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> g(@NotNull x container, @NotNull ProtoBuf.Property proto, @NotNull e0 expectedType) {
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(expectedType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(proto, this.f57979a.b());
        if (value == null) {
            return null;
        }
        return this.f57980b.f(expectedType, value, container.b());
    }
}
