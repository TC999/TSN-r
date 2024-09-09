package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class WrappedValues {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f58529a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f58530b = false;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a {
        a() {
        }

        public String toString() {
            return "NULL_VALUE";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Throwable f58531a;

        /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        private static /* synthetic */ void a(int i4) {
            String str = i4 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 1 ? 3 : 2];
            if (i4 != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i4 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i4 != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @NotNull
        public Throwable b() {
            Throwable th = this.f58531a;
            if (th == null) {
                a(1);
            }
            return th;
        }

        public String toString() {
            return this.f58531a.toString();
        }

        private b(@NotNull Throwable th) {
            if (th == null) {
                a(0);
            }
            this.f58531a = th;
        }
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 1 || i4 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 1 || i4 == 2) ? 2 : 3];
        if (i4 == 1 || i4 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i4 != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i4 == 1 || i4 == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i4 != 1 && i4 != 2) {
            if (i4 == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i4 != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        if (i4 != 1 && i4 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static <V> Object b(@Nullable V v3) {
        if (v3 == null && (v3 = (V) f58529a) == null) {
            a(1);
        }
        return v3;
    }

    @NotNull
    public static Object c(@NotNull Throwable th) {
        if (th == null) {
            a(3);
        }
        return new b(th, null);
    }

    @Nullable
    public static <V> V d(@NotNull Object obj) {
        if (obj == null) {
            a(4);
        }
        return (V) e(f(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V e(@NotNull Object obj) {
        if (obj == 0) {
            a(0);
        }
        if (obj == f58529a) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <V> V f(@Nullable Object obj) {
        if (obj instanceof b) {
            Throwable b4 = ((b) obj).b();
            if (f58530b && c.a(b4)) {
                throw new WrappedProcessCanceledException(b4);
            }
            throw c.b(b4);
        }
        return obj;
    }
}
