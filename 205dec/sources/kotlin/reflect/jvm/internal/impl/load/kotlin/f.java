package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.i1;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedDescriptorResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f57187b = new a(null);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Set<KotlinClassHeader.Kind> f57188c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Set<KotlinClassHeader.Kind> f57189d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e f57190e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e f57191f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e f57192g;

    /* renamed from: a  reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.serialization.deserialization.i f57193a;

    /* compiled from: DeserializedDescriptorResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e a() {
            return f.f57192g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeserializedDescriptorResolver.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57194a = new b();

        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            List F;
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
    }

    static {
        Set<KotlinClassHeader.Kind> f4;
        Set<KotlinClassHeader.Kind> u3;
        f4 = i1.f(KotlinClassHeader.Kind.CLASS);
        f57188c = f4;
        u3 = j1.u(KotlinClassHeader.Kind.FILE_FACADE, KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        f57189d = u3;
        f57190e = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e(1, 1, 2);
        f57191f = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e(1, 1, 11);
        f57192g = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e(1, 1, 13);
    }

    private final DeserializedContainerAbiStability d(p pVar) {
        return e().g().d() ? DeserializedContainerAbiStability.STABLE : pVar.e().j() ? DeserializedContainerAbiStability.FIR_UNSTABLE : pVar.e().k() ? DeserializedContainerAbiStability.IR_UNSTABLE : DeserializedContainerAbiStability.STABLE;
    }

    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e> f(p pVar) {
        if (g() || pVar.e().d().h()) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.r<>(pVar.e().d(), kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.e.f57537i, pVar.getLocation(), pVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        return e().g().e();
    }

    private final boolean h(p pVar) {
        return !e().g().b() && pVar.e().i() && f0.g(pVar.e().d(), f57191f);
    }

    private final boolean i(p pVar) {
        return (e().g().f() && (pVar.e().i() || f0.g(pVar.e().d(), f57190e))) || h(pVar);
    }

    private final String[] k(p pVar, Set<? extends KotlinClassHeader.Kind> set) {
        KotlinClassHeader e4 = pVar.e();
        String[] a4 = e4.a();
        if (a4 == null) {
            a4 = e4.b();
        }
        if (a4 != null && set.contains(e4.c())) {
            return a4;
        }
        return null;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h c(@NotNull g0 descriptor, @NotNull p kotlinClass) {
        String[] g4;
        Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ProtoBuf.Package> pair;
        f0.p(descriptor, "descriptor");
        f0.p(kotlinClass, "kotlinClass");
        String[] k4 = k(kotlinClass, f57189d);
        if (k4 == null || (g4 = kotlinClass.e().g()) == null) {
            return null;
        }
        try {
            try {
                pair = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.m(k4, g4);
            } catch (InvalidProtocolBufferException e4) {
                throw new IllegalStateException(f0.C("Could not read data from ", kotlinClass.getLocation()), e4);
            }
        } catch (Throwable th) {
            if (g() || kotlinClass.e().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f component1 = pair.component1();
        ProtoBuf.Package component2 = pair.component2();
        j jVar = new j(kotlinClass, component2, component1, f(kotlinClass), i(kotlinClass), d(kotlinClass));
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.h(descriptor, component2, component1, kotlinClass.e().d(), jVar, e(), "scope for " + jVar + " in " + descriptor, b.f57194a);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.i e() {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.i iVar = this.f57193a;
        if (iVar != null) {
            return iVar;
        }
        f0.S("components");
        return null;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.e j(@NotNull p kotlinClass) {
        String[] g4;
        Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.f, ProtoBuf.Class> pair;
        f0.p(kotlinClass, "kotlinClass");
        String[] k4 = k(kotlinClass, f57188c);
        if (k4 == null || (g4 = kotlinClass.e().g()) == null) {
            return null;
        }
        try {
            try {
                pair = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.i(k4, g4);
            } catch (InvalidProtocolBufferException e4) {
                throw new IllegalStateException(f0.C("Could not read data from ", kotlinClass.getLocation()), e4);
            }
        } catch (Throwable th) {
            if (g() || kotlinClass.e().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.e(pair.component1(), pair.component2(), kotlinClass.e().d(), new r(kotlinClass, f(kotlinClass), i(kotlinClass), d(kotlinClass)));
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d l(@NotNull p kotlinClass) {
        f0.p(kotlinClass, "kotlinClass");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.e j4 = j(kotlinClass);
        if (j4 == null) {
            return null;
        }
        return e().f().d(kotlinClass.c(), j4);
    }

    public final void m(@NotNull d components) {
        f0.p(components, "components");
        n(components.a());
    }

    public final void n(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.i iVar) {
        f0.p(iVar, "<set-?>");
        this.f57193a = iVar;
    }
}
