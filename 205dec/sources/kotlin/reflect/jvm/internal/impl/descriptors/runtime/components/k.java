package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: RuntimeModuleData.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f56557c = new a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.i f56558a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a f56559b;

    /* compiled from: RuntimeModuleData.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @NotNull
        public final k a(@NotNull ClassLoader classLoader) {
            f0.p(classLoader, "classLoader");
            g gVar = new g(classLoader);
            d.a aVar = kotlin.reflect.jvm.internal.impl.load.kotlin.d.f57183b;
            ClassLoader classLoader2 = f1.class.getClassLoader();
            f0.o(classLoader2, "Unit::class.java.classLoader");
            d.a.C1149a a4 = aVar.a(gVar, new g(classLoader2), new d(classLoader), f0.C("runtime module for ", classLoader), j.f56556b, l.f56560a);
            return new k(a4.a().a(), new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a(a4.b(), gVar), null);
        }
    }

    private k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.i iVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a aVar) {
        this.f56558a = iVar;
        this.f56559b = aVar;
    }

    public /* synthetic */ k(kotlin.reflect.jvm.internal.impl.serialization.deserialization.i iVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a aVar, u uVar) {
        this(iVar, aVar);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.i a() {
        return this.f56558a;
    }

    @NotNull
    public final d0 b() {
        return this.f56558a.p();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.a c() {
        return this.f56559b;
    }
}
