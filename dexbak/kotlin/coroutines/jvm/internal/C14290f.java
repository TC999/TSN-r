package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugMetadata.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, m12616d2 = {"Lkotlin/coroutines/jvm/internal/f;", "", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "continuation", "Lkotlin/coroutines/jvm/internal/f$a;", "a", "", "b", "Lkotlin/coroutines/jvm/internal/f$a;", "notOnJava9", "cache", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.jvm.internal.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14290f {

    /* renamed from: b */
    private static C14291a f41035b;
    @NotNull

    /* renamed from: c */
    public static final C14290f f41036c = new C14290f();

    /* renamed from: a */
    private static final C14291a f41034a = new C14291a(null, null, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DebugMetadata.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, m12616d2 = {"Lkotlin/coroutines/jvm/internal/f$a;", "", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "getModuleMethod", "b", "getDescriptorMethod", "c", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.coroutines.jvm.internal.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14291a {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: a */
        public final Method f41037a;
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: b */
        public final Method f41038b;
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: c */
        public final Method f41039c;

        public C14291a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f41037a = method;
            this.f41038b = method2;
            this.f41039c = method3;
        }
    }

    private C14290f() {
    }

    /* renamed from: a */
    private final C14291a m8615a(BaseContinuationImpl baseContinuationImpl) {
        try {
            C14291a c14291a = new C14291a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f41035b = c14291a;
            return c14291a;
        } catch (Exception unused) {
            C14291a c14291a2 = f41034a;
            f41035b = c14291a2;
            return c14291a2;
        }
    }

    @Nullable
    /* renamed from: b */
    public final String m8614b(@NotNull BaseContinuationImpl continuation) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        C14342f0.m8184p(continuation, "continuation");
        C14291a c14291a = f41035b;
        if (c14291a == null) {
            c14291a = m8615a(continuation);
        }
        if (c14291a == f41034a || (method = c14291a.f41037a) == null || (invoke = method.invoke(continuation.getClass(), new Object[0])) == null || (method2 = c14291a.f41038b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = c14291a.f41039c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        return invoke3 instanceof String ? invoke3 : null;
    }
}
