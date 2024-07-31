package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\n"}, m12616d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "l0", "b", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.InterfaceC14275b {

    /* renamed from: l0 */
    public static final C14616b f41684l0 = C14616b.f41685a;

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14615a {
        /* renamed from: a */
        public static <R> R m5764a(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(coroutineExceptionHandler, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: b */
        public static <E extends CoroutineContext.InterfaceC14275b> E m5763b(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) CoroutineContext.InterfaceC14275b.C14276a.m8660b(coroutineExceptionHandler, interfaceC14277c);
        }

        @NotNull
        /* renamed from: c */
        public static CoroutineContext m5762c(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return CoroutineContext.InterfaceC14275b.C14276a.m8659c(coroutineExceptionHandler, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static CoroutineContext m5761d(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC14275b.C14276a.m8658d(coroutineExceptionHandler, coroutineContext);
        }
    }

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$b;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14616b implements CoroutineContext.InterfaceC14277c<CoroutineExceptionHandler> {

        /* renamed from: a */
        static final /* synthetic */ C14616b f41685a = new C14616b();

        private C14616b() {
        }
    }

    void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th);
}
