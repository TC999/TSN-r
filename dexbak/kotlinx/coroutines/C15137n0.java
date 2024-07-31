package kotlinx.coroutines;

import kotlin.C14305i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a%\u0010\f\u001a\u00020\u000b2\u001a\b\u0004\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tH\u0086\b¨\u0006\r"}, m12616d2 = {"Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "b", "originalException", "thrownException", "c", "Lkotlin/Function2;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15137n0 {

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, m12616d2 = {"kotlinx/coroutines/n0$a", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.n0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15138a extends AbstractC14266a implements CoroutineExceptionHandler {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15284p f43190a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15138a(InterfaceC15284p interfaceC15284p, CoroutineContext.InterfaceC14277c interfaceC14277c) {
            super(interfaceC14277c);
            this.f43190a = interfaceC15284p;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
            this.f43190a.invoke(coroutineContext, th);
        }
    }

    @NotNull
    /* renamed from: a */
    public static final CoroutineExceptionHandler m3970a(@NotNull InterfaceC15284p<? super CoroutineContext, ? super Throwable, Unit> interfaceC15284p) {
        return new C15138a(interfaceC15284p, CoroutineExceptionHandler.f41684l0);
    }

    @InternalCoroutinesApi
    /* renamed from: b */
    public static final void m3969b(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.f41684l0);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                CoroutineExceptionHandlerImpl.m3997a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImpl.m3997a(coroutineContext, m3968c(th, th2));
        }
    }

    @NotNull
    /* renamed from: c */
    public static final Throwable m3968c(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        C14305i.m8548a(runtimeException, th);
        return runtimeException;
    }
}
