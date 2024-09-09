package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.storage.m;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h extends b {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56703h = {n0.u(new PropertyReference1Impl(n0.d(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56704g;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> z3;
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a4 = d.f56694a.a(h.this.b());
            Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> k4 = a4 == null ? null : y0.k(l0.a(c.f56688a.c(), a4));
            if (k4 == null) {
                z3 = z0.z();
                return z3;
            }
            return k4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull m2.a annotation, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4) {
        super(c4, annotation, j.a.I);
        f0.p(annotation, "annotation");
        f0.p(c4, "c");
        this.f56704g = c4.e().g(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) m.a(this.f56704g, this, f56703h[0]);
    }
}
