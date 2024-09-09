package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.collections.i1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: c */
    public static final b f58107c = new b(null);
    @NotNull

    /* renamed from: d */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.b> f58108d;
    @NotNull

    /* renamed from: a */
    private final i f58109a;
    @NotNull

    /* renamed from: b */
    private final d2.l<a, kotlin.reflect.jvm.internal.impl.descriptors.d> f58110b;

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a */
        private final kotlin.reflect.jvm.internal.impl.name.b f58111a;
        @Nullable

        /* renamed from: b */
        private final e f58112b;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @Nullable e eVar) {
            f0.p(classId, "classId");
            this.f58111a = classId;
            this.f58112b = eVar;
        }

        @Nullable
        public final e a() {
            return this.f58112b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b b() {
            return this.f58111a;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && f0.g(this.f58111a, ((a) obj).f58111a);
        }

        public int hashCode() {
            return this.f58111a.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final Set<kotlin.reflect.jvm.internal.impl.name.b> a() {
            return g.f58108d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<a, kotlin.reflect.jvm.internal.impl.descriptors.d> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            g.this = r1;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke(@NotNull a key) {
            f0.p(key, "key");
            return g.this.c(key);
        }
    }

    static {
        Set<kotlin.reflect.jvm.internal.impl.name.b> f4;
        f4 = i1.f(kotlin.reflect.jvm.internal.impl.name.b.m(j.a.f56097d.l()));
        f58108d = f4;
    }

    public g(@NotNull i components) {
        f0.p(components, "components");
        this.f58109a = components;
        this.f58110b = components.u().e(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00b9 A[EDGE_INSN: B:104:0x00b9->B:96:0x00b9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d c(kotlin.reflect.jvm.internal.impl.serialization.deserialization.g.a r13) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.g.c(kotlin.reflect.jvm.internal.impl.serialization.deserialization.g$a):kotlin.reflect.jvm.internal.impl.descriptors.d");
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d e(g gVar, kotlin.reflect.jvm.internal.impl.name.b bVar, e eVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            eVar = null;
        }
        return gVar.d(bVar, eVar);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @Nullable e eVar) {
        f0.p(classId, "classId");
        return this.f58110b.invoke(new a(classId, eVar));
    }
}
