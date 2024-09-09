package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.f1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockBasedStorageManager.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f implements kotlin.reflect.jvm.internal.impl.storage.n {

    /* renamed from: d  reason: collision with root package name */
    private static final String f58215d;

    /* renamed from: e  reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.storage.n f58216e;

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ boolean f58217f = false;

    /* renamed from: a  reason: collision with root package name */
    protected final kotlin.reflect.jvm.internal.impl.storage.k f58218a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC1178f f58219b;

    /* renamed from: c  reason: collision with root package name */
    private final String f58220c;

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a extends f {
        a(String str, InterfaceC1178f interfaceC1178f, kotlin.reflect.jvm.internal.impl.storage.k kVar) {
            super(str, interfaceC1178f, kVar, null);
        }

        private static /* synthetic */ void j(int i4) {
            String str = i4 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 1 ? 3 : 2];
            if (i4 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i4 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i4 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i4 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f
        @NotNull
        protected <K, V> o<V> p(@NotNull String str, K k4) {
            if (str == null) {
                j(0);
            }
            o<V> a4 = o.a();
            if (a4 == null) {
                j(1);
            }
            return a4;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b<T> extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f58221e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, d2.a aVar, Object obj) {
            super(fVar, aVar);
            this.f58221e = obj;
        }

        private static /* synthetic */ void a(int i4) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h
        @NotNull
        protected o<T> c(boolean z3) {
            o<T> d4 = o.d(this.f58221e);
            if (d4 == null) {
                a(0);
            }
            return d4;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c<T> extends k<T> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ d2.l f58223f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ d2.l f58224g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, d2.a aVar, d2.l lVar, d2.l lVar2) {
            super(fVar, aVar);
            this.f58223f = lVar;
            this.f58224g = lVar2;
        }

        private static /* synthetic */ void a(int i4) {
            String str = i4 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i4 != 2 ? 2 : 3];
            if (i4 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i4 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i4 == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i4 == 2) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h
        @NotNull
        protected o<T> c(boolean z3) {
            d2.l lVar = this.f58223f;
            if (lVar == null) {
                o<T> c4 = super.c(z3);
                if (c4 == null) {
                    a(0);
                }
                return c4;
            }
            o<T> d4 = o.d(lVar.invoke(Boolean.valueOf(z3)));
            if (d4 == null) {
                a(1);
            }
            return d4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.i
        protected void d(@NotNull T t3) {
            if (t3 == null) {
                a(2);
            }
            this.f58224g.invoke(t3);
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class d<K, V> extends e<K, V> implements kotlin.reflect.jvm.internal.impl.storage.a<K, V> {

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ boolean f58226d = false;

        /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i4) {
            String str = i4 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 3 ? 3 : 2];
            if (i4 == 1) {
                objArr[0] = "map";
            } else if (i4 == 2) {
                objArr[0] = "computation";
            } else if (i4 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i4 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i4 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i4 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.e, kotlin.reflect.jvm.internal.impl.storage.a
        @NotNull
        public V a(K k4, @NotNull d2.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            V v3 = (V) super.a(k4, aVar);
            if (v3 == null) {
                b(3);
            }
            return v3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(@NotNull f fVar, @NotNull ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, null);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class e<K, V> extends l<g<K, V>, V> implements kotlin.reflect.jvm.internal.impl.storage.b<K, V> {

        /* compiled from: LockBasedStorageManager.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a implements d2.l<g<K, V>, V> {
            a() {
            }

            @Override // d2.l
            /* renamed from: a */
            public V invoke(g<K, V> gVar) {
                return (V) ((g) gVar).f58229b.invoke();
            }
        }

        /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "map";
            } else if (i4 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i4 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Nullable
        public V a(K k4, @NotNull d2.a<? extends V> aVar) {
            if (aVar == null) {
                b(2);
            }
            return invoke(new g(k4, aVar));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(@NotNull f fVar, @NotNull ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.storage.f$f  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface InterfaceC1178f {

        /* renamed from: a  reason: collision with root package name */
        public static final InterfaceC1178f f58227a = new a();

        /* compiled from: LockBasedStorageManager.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.storage.f$f$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a implements InterfaceC1178f {
            a() {
            }

            private static /* synthetic */ void b(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.f.InterfaceC1178f
            @NotNull
            public RuntimeException a(@NotNull Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw kotlin.reflect.jvm.internal.impl.utils.c.b(th);
            }
        }

        @NotNull
        RuntimeException a(@NotNull Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class g<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final K f58228a;

        /* renamed from: b  reason: collision with root package name */
        private final d2.a<? extends V> f58229b;

        public g(K k4, d2.a<? extends V> aVar) {
            this.f58228a = k4;
            this.f58229b = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f58228a.equals(((g) obj).f58228a);
        }

        public int hashCode() {
            return this.f58228a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class h<T> implements kotlin.reflect.jvm.internal.impl.storage.j<T> {

        /* renamed from: a  reason: collision with root package name */
        private final f f58230a;

        /* renamed from: b  reason: collision with root package name */
        private final d2.a<? extends T> f58231b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private volatile Object f58232c;

        public h(@NotNull f fVar, @NotNull d2.a<? extends T> aVar) {
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f58232c = n.NOT_COMPUTED;
            this.f58230a = fVar;
            this.f58231b = aVar;
        }

        private static /* synthetic */ void a(int i4) {
            String str = (i4 == 2 || i4 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 2 || i4 == 3) ? 2 : 3];
            if (i4 == 1) {
                objArr[0] = "computable";
            } else if (i4 == 2 || i4 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i4 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i4 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i4 != 2 && i4 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 != 2 && i4 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        protected void b(T t3) {
        }

        @NotNull
        protected o<T> c(boolean z3) {
            o<T> p3 = this.f58230a.p("in a lazy value", null);
            if (p3 == null) {
                a(2);
            }
            return p3;
        }

        @Override // d2.a
        public T invoke() {
            T invoke;
            Object obj = this.f58232c;
            if (obj instanceof n) {
                this.f58230a.f58218a.lock();
                try {
                    Object obj2 = this.f58232c;
                    if (obj2 instanceof n) {
                        n nVar = n.COMPUTING;
                        if (obj2 == nVar) {
                            this.f58232c = n.RECURSION_WAS_DETECTED;
                            o<T> c4 = c(true);
                            if (!c4.c()) {
                                invoke = c4.b();
                            }
                        }
                        if (obj2 == n.RECURSION_WAS_DETECTED) {
                            o<T> c5 = c(false);
                            if (!c5.c()) {
                                invoke = c5.b();
                            }
                        }
                        this.f58232c = nVar;
                        invoke = this.f58231b.invoke();
                        b(invoke);
                        this.f58232c = invoke;
                    } else {
                        invoke = (T) WrappedValues.f(obj2);
                    }
                    return invoke;
                } finally {
                    this.f58230a.f58218a.unlock();
                }
            }
            return (T) WrappedValues.f(obj);
        }

        public boolean r() {
            return (this.f58232c == n.NOT_COMPUTED || this.f58232c == n.COMPUTING) ? false : true;
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static abstract class i<T> extends h<T> {
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private volatile kotlin.reflect.jvm.internal.impl.storage.l<T> f58233d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull f fVar, @NotNull d2.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
            this.f58233d = null;
        }

        private static /* synthetic */ void a(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h
        protected final void b(T t3) {
            this.f58233d = new kotlin.reflect.jvm.internal.impl.storage.l<>(t3);
            try {
                d(t3);
            } finally {
                this.f58233d = null;
            }
        }

        protected abstract void d(T t3);

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h, d2.a
        public T invoke() {
            kotlin.reflect.jvm.internal.impl.storage.l<T> lVar = this.f58233d;
            if (lVar != null && lVar.b()) {
                return lVar.a();
            }
            return (T) super.invoke();
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class j<T> extends h<T> implements kotlin.reflect.jvm.internal.impl.storage.i<T> {

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ boolean f58234d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@NotNull f fVar, @NotNull d2.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i4) {
            String str = i4 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 2 ? 3 : 2];
            if (i4 == 1) {
                objArr[0] = "computable";
            } else if (i4 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i4 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i4 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h, d2.a
        @NotNull
        public T invoke() {
            T t3 = (T) super.invoke();
            if (t3 == null) {
                a(2);
            }
            return t3;
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static abstract class k<T> extends i<T> implements kotlin.reflect.jvm.internal.impl.storage.i<T> {

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ boolean f58235e = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@NotNull f fVar, @NotNull d2.a<? extends T> aVar) {
            super(fVar, aVar);
            if (fVar == null) {
                a(0);
            }
            if (aVar == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i4) {
            String str = i4 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 2 ? 3 : 2];
            if (i4 == 1) {
                objArr[0] = "computable";
            } else if (i4 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i4 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i4 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.i, kotlin.reflect.jvm.internal.impl.storage.f.h, d2.a
        @NotNull
        public T invoke() {
            T t3 = (T) super.invoke();
            if (t3 == null) {
                a(2);
            }
            return t3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class l<K, V> implements kotlin.reflect.jvm.internal.impl.storage.h<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final f f58236a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentMap<K, Object> f58237b;

        /* renamed from: c  reason: collision with root package name */
        private final d2.l<? super K, ? extends V> f58238c;

        public l(@NotNull f fVar, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull d2.l<? super K, ? extends V> lVar) {
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
            this.f58236a = fVar;
            this.f58237b = concurrentMap;
            this.f58238c = lVar;
        }

        private static /* synthetic */ void b(int i4) {
            String str = (i4 == 3 || i4 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 3 || i4 == 4) ? 2 : 3];
            if (i4 == 1) {
                objArr[0] = "map";
            } else if (i4 == 2) {
                objArr[0] = "compute";
            } else if (i4 == 3 || i4 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i4 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i4 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i4 != 3 && i4 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 != 3 && i4 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @NotNull
        private AssertionError d(K k4, Object obj) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + k4 + ". Old value is " + obj + " under " + this.f58236a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        protected f c() {
            return this.f58236a;
        }

        @NotNull
        protected o<V> e(K k4, boolean z3) {
            o<V> p3 = this.f58236a.p("", k4);
            if (p3 == null) {
                b(3);
            }
            return p3;
        }

        @Override // d2.l
        @Nullable
        public V invoke(K k4) {
            V v3;
            Object obj = this.f58237b.get(k4);
            if (obj == null || obj == n.COMPUTING) {
                this.f58236a.f58218a.lock();
                try {
                    Object obj2 = this.f58237b.get(k4);
                    n nVar = n.COMPUTING;
                    if (obj2 == nVar) {
                        obj2 = n.RECURSION_WAS_DETECTED;
                        o<V> e4 = e(k4, true);
                        if (!e4.c()) {
                            v3 = e4.b();
                            return v3;
                        }
                    }
                    if (obj2 == n.RECURSION_WAS_DETECTED) {
                        o<V> e5 = e(k4, false);
                        if (!e5.c()) {
                            v3 = e5.b();
                            return v3;
                        }
                    }
                    if (obj2 != null) {
                        v3 = (V) WrappedValues.d(obj2);
                        return v3;
                    }
                    this.f58237b.put(k4, nVar);
                    V invoke = this.f58238c.invoke(k4);
                    Object put = this.f58237b.put(k4, WrappedValues.b(invoke));
                    if (put == nVar) {
                        return invoke;
                    }
                    throw d(k4, put);
                } finally {
                    this.f58236a.f58218a.unlock();
                }
            }
            return (V) WrappedValues.d(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.h
        public boolean u(K k4) {
            Object obj = this.f58237b.get(k4);
            return (obj == null || obj == n.COMPUTING) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class m<K, V> extends l<K, V> implements kotlin.reflect.jvm.internal.impl.storage.g<K, V> {

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ boolean f58239d = false;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@NotNull f fVar, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull d2.l<? super K, ? extends V> lVar) {
            super(fVar, concurrentMap, lVar);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (lVar == null) {
                b(2);
            }
        }

        private static /* synthetic */ void b(int i4) {
            String str = i4 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i4 != 3 ? 3 : 2];
            if (i4 == 1) {
                objArr[0] = "map";
            } else if (i4 == 2) {
                objArr[0] = "compute";
            } else if (i4 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i4 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i4 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i4 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.l, d2.l
        @NotNull
        public V invoke(K k4) {
            V v3 = (V) super.invoke(k4);
            if (v3 == null) {
                b(3);
            }
            return v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class o<T> {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f58244c = false;

        /* renamed from: a  reason: collision with root package name */
        private final T f58245a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f58246b;

        private o(T t3, boolean z3) {
            this.f58245a = t3;
            this.f58246b = z3;
        }

        @NotNull
        public static <T> o<T> a() {
            return new o<>(null, true);
        }

        @NotNull
        public static <T> o<T> d(T t3) {
            return new o<>(t3, false);
        }

        public T b() {
            return this.f58245a;
        }

        public boolean c() {
            return this.f58246b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.f58245a);
        }
    }

    static {
        String z5;
        z5 = x.z5(f.class.getCanonicalName(), ".", "");
        f58215d = z5;
        f58216e = new a("NO_LOCKS", InterfaceC1178f.f58227a, kotlin.reflect.jvm.internal.impl.storage.e.f58214b);
    }

    /* synthetic */ f(String str, InterfaceC1178f interfaceC1178f, kotlin.reflect.jvm.internal.impl.storage.k kVar, a aVar) {
        this(str, interfaceC1178f, kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void j(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.f.j(int):void");
    }

    static /* synthetic */ InterfaceC1178f k(f fVar) {
        return fVar.f58219b;
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static <T extends Throwable> T q(@NotNull T t3) {
        if (t3 == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t3.getStackTrace();
        int length = stackTrace.length;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (!stackTrace[i5].getClassName().startsWith(f58215d)) {
                i4 = i5;
                break;
            } else {
                i5++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i4, length);
        t3.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    public <T> T a(@NotNull d2.a<? extends T> aVar) {
        if (aVar == null) {
            j(34);
        }
        this.f58218a.lock();
        try {
            return aVar.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.a<K, V> b() {
        return new d(this, m(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.g<K, V> c(@NotNull d2.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(9);
        }
        kotlin.reflect.jvm.internal.impl.storage.g<K, V> n4 = n(lVar, m());
        if (n4 == null) {
            j(10);
        }
        return n4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.b<K, V> d() {
        return new e(this, m(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.h<K, V> e(@NotNull d2.l<? super K, ? extends V> lVar) {
        if (lVar == null) {
            j(19);
        }
        kotlin.reflect.jvm.internal.impl.storage.h<K, V> o4 = o(lVar, m());
        if (o4 == null) {
            j(20);
        }
        return o4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.i<T> f(@NotNull d2.a<? extends T> aVar, d2.l<? super Boolean, ? extends T> lVar, @NotNull d2.l<? super T, f1> lVar2) {
        if (aVar == null) {
            j(28);
        }
        if (lVar2 == null) {
            j(29);
        }
        return new c(this, aVar, lVar, lVar2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.i<T> g(@NotNull d2.a<? extends T> aVar) {
        if (aVar == null) {
            j(23);
        }
        return new j(this, aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.i<T> h(@NotNull d2.a<? extends T> aVar, @NotNull T t3) {
        if (aVar == null) {
            j(26);
        }
        if (t3 == null) {
            j(27);
        }
        return new b(this, aVar, t3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.j<T> i(@NotNull d2.a<? extends T> aVar) {
        if (aVar == null) {
            j(30);
        }
        return new h(this, aVar);
    }

    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.g<K, V> n(@NotNull d2.l<? super K, ? extends V> lVar, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, lVar);
    }

    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.h<K, V> o(@NotNull d2.l<? super K, ? extends V> lVar, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (lVar == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, lVar);
    }

    @NotNull
    protected <K, V> o<V> p(@NotNull String str, K k4) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k4 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k4;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) q(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f58220c + ")";
    }

    private f(@NotNull String str, @NotNull InterfaceC1178f interfaceC1178f, @NotNull kotlin.reflect.jvm.internal.impl.storage.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC1178f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f58218a = kVar;
        this.f58219b = interfaceC1178f;
        this.f58220c = str;
    }

    public f(String str) {
        this(str, (Runnable) null, (d2.l<InterruptedException, f1>) null);
    }

    public f(String str, @Nullable Runnable runnable, @Nullable d2.l<InterruptedException, f1> lVar) {
        this(str, InterfaceC1178f.f58227a, kotlin.reflect.jvm.internal.impl.storage.k.f58247a.a(runnable, lVar));
    }
}
