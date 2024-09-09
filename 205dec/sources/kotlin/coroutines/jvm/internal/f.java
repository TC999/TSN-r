package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DebugMetadata.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lkotlin/coroutines/jvm/internal/f;", "", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "continuation", "Lkotlin/coroutines/jvm/internal/f$a;", "a", "", "b", "Lkotlin/coroutines/jvm/internal/f$a;", "notOnJava9", "c", "cache", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final f f55513a = new f();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final a f55514b = new a(null, null, null);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static a f55515c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DebugMetadata.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/f$a;", "", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "getModuleMethod", "b", "getDescriptorMethod", "c", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @JvmField
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Method f55516a;
        @JvmField
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final Method f55517b;
        @JvmField
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final Method f55518c;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.f55516a = method;
            this.f55517b = method2;
            this.f55518c = method3;
        }
    }

    private f() {
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f55515c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f55514b;
            f55515c = aVar2;
            return aVar2;
        }
    }

    @Nullable
    public final String b(@NotNull BaseContinuationImpl continuation) {
        f0.p(continuation, "continuation");
        a aVar = f55515c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == f55514b) {
            return null;
        }
        Method method = aVar.f55516a;
        Object invoke = method == null ? null : method.invoke(continuation.getClass(), new Object[0]);
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f55517b;
        Object invoke2 = method2 == null ? null : method2.invoke(invoke, new Object[0]);
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f55518c;
        Object invoke3 = method3 == null ? null : method3.invoke(invoke2, new Object[0]);
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
