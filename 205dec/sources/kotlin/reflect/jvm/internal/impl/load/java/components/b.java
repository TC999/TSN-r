package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.storage.m;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.load.java.descriptors.g {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56680f = {n0.u(new PropertyReference1Impl(n0.d(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.c f56681a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final v0 f56682b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56683c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final m2.b f56684d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f56685e;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<m0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.lazy.h f56686a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f56687b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, b bVar) {
            super(0);
            this.f56686a = hVar;
            this.f56687b = bVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final m0 invoke() {
            m0 q3 = this.f56686a.d().k().o(this.f56687b.e()).q();
            f0.o(q3, "c.module.builtIns.getBui\u2026qName(fqName).defaultType");
            return q3;
        }
    }

    public b(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @Nullable m2.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        v0 NO_SOURCE;
        Object p22;
        m2.b bVar;
        f0.p(c4, "c");
        f0.p(fqName, "fqName");
        this.f56681a = fqName;
        if (aVar == null) {
            NO_SOURCE = v0.f56634a;
            f0.o(NO_SOURCE, "NO_SOURCE");
        } else {
            NO_SOURCE = c4.a().t().a(aVar);
        }
        this.f56682b = NO_SOURCE;
        this.f56683c = c4.e().g(new a(c4, this));
        if (aVar == null) {
            bVar = null;
        } else {
            p22 = kotlin.collections.f0.p2(aVar.getArguments());
            bVar = (m2.b) p22;
        }
        this.f56684d = bVar;
        boolean z3 = false;
        if (aVar != null && aVar.d()) {
            z3 = true;
        }
        this.f56685e = z3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> z3;
        z3 = z0.z();
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final m2.b b() {
        return this.f56684d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.g
    public boolean d() {
        return this.f56685e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c e() {
        return this.f56681a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public v0 getSource() {
        return this.f56682b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public m0 getType() {
        return (m0) m.a(this.f56683c, this, f56680f[0]);
    }
}
