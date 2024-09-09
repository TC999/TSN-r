package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaRecordComponent.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56563a = new a();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static C1131a f56564b;

    /* compiled from: ReflectJavaRecordComponent.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1131a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Method f56565a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Method f56566b;

        public C1131a(@Nullable Method method, @Nullable Method method2) {
            this.f56565a = method;
            this.f56566b = method2;
        }

        @Nullable
        public final Method a() {
            return this.f56566b;
        }

        @Nullable
        public final Method b() {
            return this.f56565a;
        }
    }

    private a() {
    }

    private final C1131a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C1131a(cls.getMethod("getType", new Class[0]), cls.getMethod("getAccessor", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new C1131a(null, null);
        }
    }

    private final C1131a b(Object obj) {
        C1131a c1131a = f56564b;
        if (c1131a == null) {
            C1131a a4 = a(obj);
            f56564b = a4;
            return a4;
        }
        return c1131a;
    }

    @Nullable
    public final Method c(@NotNull Object recordComponent) {
        f0.p(recordComponent, "recordComponent");
        Method a4 = b(recordComponent).a();
        if (a4 == null) {
            return null;
        }
        Object invoke = a4.invoke(recordComponent, new Object[0]);
        if (invoke != null) {
            return (Method) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Method");
    }

    @Nullable
    public final Class<?> d(@NotNull Object recordComponent) {
        f0.p(recordComponent, "recordComponent");
        Method b4 = b(recordComponent).b();
        if (b4 == null) {
            return null;
        }
        Object invoke = b4.invoke(recordComponent, new Object[0]);
        if (invoke != null) {
            return (Class) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    }
}
