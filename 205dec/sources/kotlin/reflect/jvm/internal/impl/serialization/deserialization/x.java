package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProtoContainer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class x {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f58190a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g f58191b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final v0 f58192c;

    /* compiled from: ProtoContainer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends x {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final ProtoBuf.Class f58193d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private final a f58194e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.b f58195f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        private final ProtoBuf.Class.Kind f58196g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f58197h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull ProtoBuf.Class classProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @Nullable v0 v0Var, @Nullable a aVar) {
            super(nameResolver, typeTable, v0Var, null);
            f0.p(classProto, "classProto");
            f0.p(nameResolver, "nameResolver");
            f0.p(typeTable, "typeTable");
            this.f58193d = classProto;
            this.f58194e = aVar;
            this.f58195f = v.a(nameResolver, classProto.getFqName());
            ProtoBuf.Class.Kind d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57456f.d(classProto.getFlags());
            this.f58196g = d4 == null ? ProtoBuf.Class.Kind.CLASS : d4;
            Boolean d5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57457g.d(classProto.getFlags());
            f0.o(d5, "IS_INNER.get(classProto.flags)");
            this.f58197h = d5.booleanValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.x
        @NotNull
        public kotlin.reflect.jvm.internal.impl.name.c a() {
            kotlin.reflect.jvm.internal.impl.name.c b4 = this.f58195f.b();
            f0.o(b4, "classId.asSingleFqName()");
            return b4;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b e() {
            return this.f58195f;
        }

        @NotNull
        public final ProtoBuf.Class f() {
            return this.f58193d;
        }

        @NotNull
        public final ProtoBuf.Class.Kind g() {
            return this.f58196g;
        }

        @Nullable
        public final a h() {
            return this.f58194e;
        }

        public final boolean i() {
            return this.f58197h;
        }
    }

    /* compiled from: ProtoContainer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends x {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.c f58198d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @Nullable v0 v0Var) {
            super(nameResolver, typeTable, v0Var, null);
            f0.p(fqName, "fqName");
            f0.p(nameResolver, "nameResolver");
            f0.p(typeTable, "typeTable");
            this.f58198d = fqName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.x
        @NotNull
        public kotlin.reflect.jvm.internal.impl.name.c a() {
            return this.f58198d;
        }
    }

    private x(kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, v0 v0Var) {
        this.f58190a = cVar;
        this.f58191b = gVar;
        this.f58192c = v0Var;
    }

    public /* synthetic */ x(kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, v0 v0Var, kotlin.jvm.internal.u uVar) {
        this(cVar, gVar, v0Var);
    }

    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.name.c a();

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c b() {
        return this.f58190a;
    }

    @Nullable
    public final v0 c() {
        return this.f58192c;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.g d() {
        return this.f58191b;
    }

    @NotNull
    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }
}
