package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.f;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a%\u0010\f\u001a\u00020\u000b2\u001a\b\u0004\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tH\u0086\b\u00a8\u0006\r"}, d2 = {"Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "b", "originalException", "thrownException", "c", "Lkotlin/Function2;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n0 {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"kotlinx/coroutines/n0$a", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.coroutines.a implements CoroutineExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.p f60507a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d2.p pVar, f.c cVar) {
            super(cVar);
            this.f60507a = pVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull kotlin.coroutines.f fVar, @NotNull Throwable th) {
            this.f60507a.invoke(fVar, th);
        }
    }

    @NotNull
    public static final CoroutineExceptionHandler a(@NotNull d2.p<? super kotlin.coroutines.f, ? super Throwable, kotlin.f1> pVar) {
        return new a(pVar, CoroutineExceptionHandler.f59029h0);
    }

    @InternalCoroutinesApi
    public static final void b(@NotNull kotlin.coroutines.f fVar, @NotNull Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) fVar.get(CoroutineExceptionHandler.f59029h0);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(fVar, th);
            } else {
                m0.a(fVar, th);
            }
        } catch (Throwable th2) {
            m0.a(fVar, c(th, th2));
        }
    }

    @NotNull
    public static final Throwable c(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.j.a(runtimeException, th);
        return runtimeException;
    }
}
