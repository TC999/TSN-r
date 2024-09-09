package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f56568a = new b();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static a f56569b;

    /* compiled from: ReflectJavaClass.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Method f56570a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Method f56571b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final Method f56572c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final Method f56573d;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3, @Nullable Method method4) {
            this.f56570a = method;
            this.f56571b = method2;
            this.f56572c = method3;
            this.f56573d = method4;
        }

        @Nullable
        public final Method a() {
            return this.f56571b;
        }

        @Nullable
        public final Method b() {
            return this.f56573d;
        }

        @Nullable
        public final Method c() {
            return this.f56572c;
        }

        @Nullable
        public final Method d() {
            return this.f56570a;
        }
    }

    private b() {
    }

    private final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    private final a b() {
        a aVar = f56569b;
        if (aVar == null) {
            a a4 = a();
            f56569b = a4;
            return a4;
        }
        return aVar;
    }

    @Nullable
    public final Class<?>[] c(@NotNull Class<?> clazz) {
        f0.p(clazz, "clazz");
        Method a4 = b().a();
        if (a4 == null) {
            return null;
        }
        Object invoke = a4.invoke(clazz, new Object[0]);
        if (invoke != null) {
            return (Class[]) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
    }

    @Nullable
    public final Object[] d(@NotNull Class<?> clazz) {
        f0.p(clazz, "clazz");
        Method b4 = b().b();
        if (b4 == null) {
            return null;
        }
        return (Object[]) b4.invoke(clazz, new Object[0]);
    }

    @Nullable
    public final Boolean e(@NotNull Class<?> clazz) {
        f0.p(clazz, "clazz");
        Method c4 = b().c();
        if (c4 == null) {
            return null;
        }
        Object invoke = c4.invoke(clazz, new Object[0]);
        if (invoke != null) {
            return Boolean.valueOf(((Boolean) invoke).booleanValue());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Nullable
    public final Boolean f(@NotNull Class<?> clazz) {
        f0.p(clazz, "clazz");
        Method d4 = b().d();
        if (d4 == null) {
            return null;
        }
        Object invoke = d4.invoke(clazz, new Object[0]);
        if (invoke != null) {
            return Boolean.valueOf(((Boolean) invoke).booleanValue());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
