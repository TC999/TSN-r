package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ExceptionsConstuctor.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a1\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b2\u0014\b\u0004\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0007H\u0082\b\u001a\u0018\u0010\u000f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u001b\u0010\u0011\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0082\u0010\"\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\"\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\":\u0010\u001a\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019*(\b\u0002\u0010\u001b\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007\u00a8\u0006\u001c"}, d2 = {"", "E", "exception", "f", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "a", "block", "e", "Ljava/lang/Class;", "", "defaultValue", "d", "accumulator", "b", "I", "throwableFields", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ExceptionsConstuctorKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f60337a = d(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f60338b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, d2.l<Throwable, Throwable>> f60339c = new WeakHashMap<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Comparisons.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$d", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t3, T t4) {
            int g4;
            g4 = kotlin.comparisons.b.g(Integer.valueOf(((Constructor) t4).getParameterTypes().length), Integer.valueOf(((Constructor) t3).getParameterTypes().length));
            return g4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ExceptionsConstuctor.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "E", "it", "", "a", "(Ljava/lang/Throwable;)Ljava/lang/Void;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f60340a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ExceptionsConstuctor.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "E", "it", "", "a", "(Ljava/lang/Throwable;)Ljava/lang/Void;"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f60341a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull Throwable th) {
            return null;
        }
    }

    private static final d2.l<Throwable, Throwable> a(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && kotlin.jvm.internal.f0.g(parameterTypes[0], String.class) && kotlin.jvm.internal.f0.g(parameterTypes[1], Throwable.class)) {
                    return new d2.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // d2.l
                        @Nullable
                        public final Throwable invoke(@NotNull Throwable th) {
                            Object m119constructorimpl;
                            Object newInstance;
                            try {
                                Result.a aVar = Result.Companion;
                                newInstance = constructor.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.a aVar2 = Result.Companion;
                                m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th2));
                            }
                            if (newInstance != null) {
                                m119constructorimpl = Result.m119constructorimpl((Throwable) newInstance);
                                if (Result.m125isFailureimpl(m119constructorimpl)) {
                                    m119constructorimpl = null;
                                }
                                return (Throwable) m119constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (kotlin.jvm.internal.f0.g(cls, Throwable.class)) {
                return new d2.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // d2.l
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th) {
                        Object m119constructorimpl;
                        Object newInstance;
                        try {
                            Result.a aVar = Result.Companion;
                            newInstance = constructor.newInstance(th);
                        } catch (Throwable th2) {
                            Result.a aVar2 = Result.Companion;
                            m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th2));
                        }
                        if (newInstance != null) {
                            m119constructorimpl = Result.m119constructorimpl((Throwable) newInstance);
                            if (Result.m125isFailureimpl(m119constructorimpl)) {
                                m119constructorimpl = null;
                            }
                            return (Throwable) m119constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            if (kotlin.jvm.internal.f0.g(cls, String.class)) {
                return new d2.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // d2.l
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th) {
                        Object m119constructorimpl;
                        Object newInstance;
                        try {
                            Result.a aVar = Result.Companion;
                            newInstance = constructor.newInstance(th.getMessage());
                        } catch (Throwable th2) {
                            Result.a aVar2 = Result.Companion;
                            m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th2));
                        }
                        if (newInstance != null) {
                            Throwable th3 = (Throwable) newInstance;
                            th3.initCause(th);
                            m119constructorimpl = Result.m119constructorimpl(th3);
                            if (Result.m125isFailureimpl(m119constructorimpl)) {
                                m119constructorimpl = null;
                            }
                            return (Throwable) m119constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            return null;
        }
        return new d2.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // d2.l
            @Nullable
            public final Throwable invoke(@NotNull Throwable th) {
                Object m119constructorimpl;
                Object newInstance;
                try {
                    Result.a aVar = Result.Companion;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Result.a aVar2 = Result.Companion;
                    m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th2));
                }
                if (newInstance != null) {
                    Throwable th3 = (Throwable) newInstance;
                    th3.initCause(th);
                    m119constructorimpl = Result.m119constructorimpl(th3);
                    if (Result.m125isFailureimpl(m119constructorimpl)) {
                        m119constructorimpl = null;
                    }
                    return (Throwable) m119constructorimpl;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    private static final int b(Class<?> cls, int i4) {
        do {
            int i5 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i5++;
                }
            }
            i4 += i5;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i4;
    }

    static /* synthetic */ int c(Class cls, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        return b(cls, i4);
    }

    private static final int d(Class<?> cls, int i4) {
        Integer m119constructorimpl;
        c2.a.g(cls);
        try {
            Result.a aVar = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th));
        }
        Integer valueOf = Integer.valueOf(i4);
        if (Result.m125isFailureimpl(m119constructorimpl)) {
            m119constructorimpl = valueOf;
        }
        return ((Number) m119constructorimpl).intValue();
    }

    private static final d2.l<Throwable, Throwable> e(final d2.l<? super Throwable, ? extends Throwable> lVar) {
        return new d2.l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$safeCtor$1
            {
                super(1);
            }

            @Override // d2.l
            @Nullable
            public final Throwable invoke(@NotNull Throwable th) {
                Object m119constructorimpl;
                try {
                    Result.a aVar = Result.Companion;
                    m119constructorimpl = Result.m119constructorimpl((Throwable) d2.l.this.invoke(th));
                } catch (Throwable th2) {
                    Result.a aVar2 = Result.Companion;
                    m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th2));
                }
                if (Result.m125isFailureimpl(m119constructorimpl)) {
                    m119constructorimpl = null;
                }
                return (Throwable) m119constructorimpl;
            }
        };
    }

    @Nullable
    public static final <E extends Throwable> E f(@NotNull E e4) {
        Object m119constructorimpl;
        List hv;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e4 instanceof kotlinx.coroutines.j0) {
            try {
                Result.a aVar = Result.Companion;
                m119constructorimpl = Result.m119constructorimpl(((kotlinx.coroutines.j0) e4).createCopy());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th));
            }
            return (E) (Result.m125isFailureimpl(m119constructorimpl) ? null : m119constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f60338b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            d2.l<Throwable, Throwable> lVar = f60339c.get(e4.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(e4);
            }
            int i4 = 0;
            if (f60337a != d(e4.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i5 = 0; i5 < readHoldCount; i5++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f60339c.put(e4.getClass(), b.f60340a);
                    f1 f1Var = f1.f55527a;
                    return null;
                } finally {
                    while (i4 < readHoldCount) {
                        readLock.lock();
                        i4++;
                    }
                    writeLock.unlock();
                }
            }
            hv = kotlin.collections.p.hv(e4.getClass().getConstructors(), new a());
            Iterator it = hv.iterator();
            d2.l<Throwable, Throwable> lVar2 = null;
            while (it.hasNext() && (lVar2 = a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f60338b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i6 = 0; i6 < readHoldCount; i6++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f60339c.put(e4.getClass(), lVar2 != null ? lVar2 : c.f60341a);
                f1 f1Var2 = f1.f55527a;
                while (i4 < readHoldCount) {
                    readLock.lock();
                    i4++;
                }
                writeLock.unlock();
                if (lVar2 != null) {
                    return (E) lVar2.invoke(e4);
                }
                return null;
            } finally {
                while (i4 < readHoldCount) {
                    readLock.lock();
                    i4++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
