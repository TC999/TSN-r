package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.y0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;
import kotlin.reflect.jvm.internal.impl.storage.m;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends b {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f56698h = {n0.u(new PropertyReference1Impl(n0.d(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f56699g;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends v>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56700a = new a();

        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, v> invoke() {
            Map<kotlin.reflect.jvm.internal.impl.name.f, v> k4;
            k4 = y0.k(l0.a(c.f56688a.b(), new v("Deprecated in Java")));
            return k4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@Nullable m2.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4) {
        super(c4, aVar, j.a.f56139y);
        f0.p(c4, "c");
        this.f56699g = c4.e().g(a.f56700a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) m.a(this.f56699g, this, f56698h[0]);
    }
}
