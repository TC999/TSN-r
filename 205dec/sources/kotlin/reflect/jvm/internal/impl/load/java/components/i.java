package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.List;
import java.util.Map;
import kotlin.collections.x;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.n;
import m2.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i extends b {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56706h = {n0.u(new PropertyReference1Impl(n0.d(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56707g;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<? extends Object>>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<Object>> invoke() {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar;
            List<? extends m2.b> l4;
            Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<Object>> z3;
            m2.b b4 = i.this.b();
            if (b4 instanceof m2.e) {
                gVar = d.f56694a.c(((m2.e) i.this.b()).c());
            } else if (b4 instanceof m) {
                d dVar = d.f56694a;
                l4 = x.l(i.this.b());
                gVar = dVar.c(l4);
            } else {
                gVar = null;
            }
            Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<Object>> k4 = gVar != null ? y0.k(l0.a(c.f56688a.d(), gVar)) : null;
            if (k4 == null) {
                z3 = z0.z();
                return z3;
            }
            return k4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull m2.a annotation, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4) {
        super(c4, annotation, j.a.F);
        f0.p(annotation, "annotation");
        f0.p(c4, "c");
        this.f56707g = c4.e().g(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<Object>> a() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f56707g, this, f56706h[0]);
    }
}
