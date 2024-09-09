package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectProperties.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y {

    /* compiled from: ReflectProperties.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a<T> extends c<T> implements d2.a<T> {

        /* renamed from: b  reason: collision with root package name */
        private final d2.a<T> f58680b;

        /* renamed from: c  reason: collision with root package name */
        private volatile SoftReference<Object> f58681c;

        public a(@Nullable T t3, @NotNull d2.a<T> aVar) {
            if (aVar == null) {
                d(0);
            }
            this.f58681c = null;
            this.f58680b = aVar;
            if (t3 != null) {
                this.f58681c = new SoftReference<>(a(t3));
            }
        }

        private static /* synthetic */ void d(int i4) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.y.c, d2.a
        public T invoke() {
            Object obj;
            SoftReference<Object> softReference = this.f58681c;
            if (softReference != null && (obj = softReference.get()) != null) {
                return c(obj);
            }
            T invoke = this.f58680b.invoke();
            this.f58681c = new SoftReference<>(a(invoke));
            return invoke;
        }
    }

    /* compiled from: ReflectProperties.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<T> extends c<T> {

        /* renamed from: b  reason: collision with root package name */
        private final d2.a<T> f58682b;

        /* renamed from: c  reason: collision with root package name */
        private volatile Object f58683c;

        public b(@NotNull d2.a<T> aVar) {
            if (aVar == null) {
                d(0);
            }
            this.f58683c = null;
            this.f58682b = aVar;
        }

        private static /* synthetic */ void d(int i4) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
        }

        @Override // kotlin.reflect.jvm.internal.y.c, d2.a
        public T invoke() {
            Object obj = this.f58683c;
            if (obj != null) {
                return c(obj);
            }
            T invoke = this.f58682b.invoke();
            this.f58683c = a(invoke);
            return invoke;
        }
    }

    /* compiled from: ReflectProperties.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c<T> {

        /* renamed from: a  reason: collision with root package name */
        private static final Object f58684a = new a();

        /* compiled from: ReflectProperties.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a {
            a() {
            }
        }

        protected Object a(T t3) {
            return t3 == null ? f58684a : t3;
        }

        public final T b(Object obj, Object obj2) {
            return invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected T c(Object obj) {
            if (obj == f58684a) {
                return null;
            }
            return obj;
        }

        public abstract T invoke();
    }

    private static /* synthetic */ void a(int i4) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i4 == 1 || i4 == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @NotNull
    public static <T> b<T> b(@NotNull d2.a<T> aVar) {
        if (aVar == null) {
            a(0);
        }
        return new b<>(aVar);
    }

    @NotNull
    public static <T> a<T> c(@NotNull d2.a<T> aVar) {
        if (aVar == null) {
            a(2);
        }
        return d(null, aVar);
    }

    @NotNull
    public static <T> a<T> d(@Nullable T t3, @NotNull d2.a<T> aVar) {
        if (aVar == null) {
            a(1);
        }
        return new a<>(t3, aVar);
    }
}
