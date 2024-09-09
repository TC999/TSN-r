package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.load.java.v;
import kotlin.reflect.jvm.internal.impl.storage.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: context.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final c f56923a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final l f56924b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final p<v> f56925c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final p f56926d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b f56927e;

    public h(@NotNull c components, @NotNull l typeParameterResolver, @NotNull p<v> delegateForDefaultTypeQualifiers) {
        f0.p(components, "components");
        f0.p(typeParameterResolver, "typeParameterResolver");
        f0.p(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.f56923a = components;
        this.f56924b = typeParameterResolver;
        this.f56925c = delegateForDefaultTypeQualifiers;
        this.f56926d = delegateForDefaultTypeQualifiers;
        this.f56927e = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b(this, typeParameterResolver);
    }

    @NotNull
    public final c a() {
        return this.f56923a;
    }

    @Nullable
    public final v b() {
        return (v) this.f56926d.getValue();
    }

    @NotNull
    public final p<v> c() {
        return this.f56925c;
    }

    @NotNull
    public final d0 d() {
        return this.f56923a.m();
    }

    @NotNull
    public final n e() {
        return this.f56923a.u();
    }

    @NotNull
    public final l f() {
        return this.f56924b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b g() {
        return this.f56927e;
    }
}
