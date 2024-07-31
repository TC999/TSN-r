package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections._Arrays;
import kotlin.comparisons.Comparisons;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.InterfaceC15112j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p612k1.JvmClassMapping;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a1\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b2\u0014\b\u0004\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0007H\u0082\b\u001a\u0018\u0010\u000f\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u001b\u0010\u0011\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\f2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0082\u0010\"\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012\"\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015\":\u0010\u001a\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007j\u0002`\b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019*(\b\u0002\u0010\u001b\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007¨\u0006\u001c"}, m12616d2 = {"", ExifInterface.LONGITUDE_EAST, "exception", "f", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Ljava/lang/reflect/Constructor;", "constructor", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "a", "block", "e", "Ljava/lang/Class;", "", "defaultValue", "d", "accumulator", "b", "I", "throwableFields", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "Ctor", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.ExceptionsConstuctorKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ExceptionsConstuctor {

    /* renamed from: a */
    private static final int f43020a = m4393d(Throwable.class, -1);

    /* renamed from: b */
    private static final ReentrantReadWriteLock f43021b = new ReentrantReadWriteLock();

    /* renamed from: c */
    private static final WeakHashMap<Class<? extends Throwable>, InterfaceC15280l<Throwable, Throwable>> f43022c = new WeakHashMap<>();

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$d", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.ExceptionsConstuctorKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15066a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            m8803g = Comparisons.m8803g(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            return m8803g;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", ExifInterface.LONGITUDE_EAST, "it", "", "a", "(Ljava/lang/Throwable;)Ljava/lang/Void;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.ExceptionsConstuctorKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15067b extends Lambda implements InterfaceC15280l {

        /* renamed from: a */
        public static final C15067b f43023a = new C15067b();

        C15067b() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull Throwable th) {
            return null;
        }
    }

    /* compiled from: ExceptionsConstuctor.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", ExifInterface.LONGITUDE_EAST, "it", "", "a", "(Ljava/lang/Throwable;)Ljava/lang/Void;"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.internal.ExceptionsConstuctorKt$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15068c extends Lambda implements InterfaceC15280l {

        /* renamed from: a */
        public static final C15068c f43024a = new C15068c();

        C15068c() {
            super(1);
        }

        @Override // p617l1.InterfaceC15280l
        @Nullable
        /* renamed from: a */
        public final Void invoke(@NotNull Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static final InterfaceC15280l<Throwable, Throwable> m4396a(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && C14342f0.m8193g(parameterTypes[0], String.class) && C14342f0.m8193g(parameterTypes[1], Throwable.class)) {
                    return new InterfaceC15280l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // p617l1.InterfaceC15280l
                        @Nullable
                        public final Throwable invoke(@NotNull Throwable th) {
                            Object m60148constructorimpl;
                            Object newInstance;
                            try {
                                Result.C14124a c14124a = Result.Companion;
                                newInstance = constructor.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.C14124a c14124a2 = Result.Companion;
                                m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th2));
                            }
                            if (newInstance != null) {
                                m60148constructorimpl = Result.m60148constructorimpl((Throwable) newInstance);
                                if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                                    m60148constructorimpl = null;
                                }
                                return (Throwable) m60148constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (C14342f0.m8193g(cls, Throwable.class)) {
                return new InterfaceC15280l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // p617l1.InterfaceC15280l
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th) {
                        Object m60148constructorimpl;
                        Object newInstance;
                        try {
                            Result.C14124a c14124a = Result.Companion;
                            newInstance = constructor.newInstance(th);
                        } catch (Throwable th2) {
                            Result.C14124a c14124a2 = Result.Companion;
                            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th2));
                        }
                        if (newInstance != null) {
                            m60148constructorimpl = Result.m60148constructorimpl((Throwable) newInstance);
                            if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                                m60148constructorimpl = null;
                            }
                            return (Throwable) m60148constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            if (C14342f0.m8193g(cls, String.class)) {
                return new InterfaceC15280l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // p617l1.InterfaceC15280l
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th) {
                        Object m60148constructorimpl;
                        Object newInstance;
                        try {
                            Result.C14124a c14124a = Result.Companion;
                            newInstance = constructor.newInstance(th.getMessage());
                        } catch (Throwable th2) {
                            Result.C14124a c14124a2 = Result.Companion;
                            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th2));
                        }
                        if (newInstance != null) {
                            Throwable th3 = (Throwable) newInstance;
                            th3.initCause(th);
                            m60148constructorimpl = Result.m60148constructorimpl(th3);
                            if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                                m60148constructorimpl = null;
                            }
                            return (Throwable) m60148constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            return null;
        }
        return new InterfaceC15280l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            @Nullable
            public final Throwable invoke(@NotNull Throwable th) {
                Object m60148constructorimpl;
                Object newInstance;
                try {
                    Result.C14124a c14124a = Result.Companion;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Result.C14124a c14124a2 = Result.Companion;
                    m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th2));
                }
                if (newInstance != null) {
                    Throwable th3 = (Throwable) newInstance;
                    th3.initCause(th);
                    m60148constructorimpl = Result.m60148constructorimpl(th3);
                    if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                        m60148constructorimpl = null;
                    }
                    return (Throwable) m60148constructorimpl;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    /* renamed from: b */
    private static final int m4395b(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m4394c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return m4395b(cls, i);
    }

    /* renamed from: d */
    private static final int m4393d(Class<?> cls, int i) {
        Integer m60148constructorimpl;
        JvmClassMapping.m12622g(cls);
        try {
            Result.C14124a c14124a = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(Integer.valueOf(m4394c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m60154isFailureimpl(m60148constructorimpl)) {
            m60148constructorimpl = valueOf;
        }
        return ((Number) m60148constructorimpl).intValue();
    }

    /* renamed from: e */
    private static final InterfaceC15280l<Throwable, Throwable> m4392e(final InterfaceC15280l<? super Throwable, ? extends Throwable> interfaceC15280l) {
        return new InterfaceC15280l<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$safeCtor$1
            {
                super(1);
            }

            @Override // p617l1.InterfaceC15280l
            @Nullable
            public final Throwable invoke(@NotNull Throwable th) {
                Object m60148constructorimpl;
                try {
                    Result.C14124a c14124a = Result.Companion;
                    m60148constructorimpl = Result.m60148constructorimpl((Throwable) InterfaceC15280l.this.invoke(th));
                } catch (Throwable th2) {
                    Result.C14124a c14124a2 = Result.Companion;
                    m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th2));
                }
                if (Result.m60154isFailureimpl(m60148constructorimpl)) {
                    m60148constructorimpl = null;
                }
                return (Throwable) m60148constructorimpl;
            }
        };
    }

    @Nullable
    /* renamed from: f */
    public static final <E extends Throwable> E m4391f(@NotNull E e) {
        Object m60148constructorimpl;
        List m10391hv;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e instanceof InterfaceC15112j0) {
            try {
                Result.C14124a c14124a = Result.Companion;
                m60148constructorimpl = Result.m60148constructorimpl(((InterfaceC15112j0) e).createCopy());
            } catch (Throwable th) {
                Result.C14124a c14124a2 = Result.Companion;
                m60148constructorimpl = Result.m60148constructorimpl(C14294d0.m8609a(th));
            }
            return (E) (Result.m60154isFailureimpl(m60148constructorimpl) ? null : m60148constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f43021b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            InterfaceC15280l<Throwable, Throwable> interfaceC15280l = f43022c.get(e.getClass());
            if (interfaceC15280l != null) {
                return (E) interfaceC15280l.invoke(e);
            }
            int i = 0;
            if (f43020a != m4393d(e.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f43022c.put(e.getClass(), C15067b.f43023a);
                    Unit unit = Unit.f41048a;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            m10391hv = _Arrays.m10391hv(e.getClass().getConstructors(), new C15066a());
            Iterator it = m10391hv.iterator();
            InterfaceC15280l<Throwable, Throwable> interfaceC15280l2 = null;
            while (it.hasNext() && (interfaceC15280l2 = m4396a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = f43021b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                f43022c.put(e.getClass(), interfaceC15280l2 != null ? interfaceC15280l2 : C15068c.f43024a);
                Unit unit2 = Unit.f41048a;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                if (interfaceC15280l2 != null) {
                    return (E) interfaceC15280l2.invoke(e);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
