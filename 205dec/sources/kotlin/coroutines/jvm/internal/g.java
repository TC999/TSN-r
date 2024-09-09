package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.d0;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RunSuspend.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0005\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0002R0\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"Lkotlin/coroutines/jvm/internal/g;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "b", "a", "Lkotlin/Result;", "c", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g implements kotlin.coroutines.c<f1> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Result<f1> f55519a;

    public final void b() {
        synchronized (this) {
            while (true) {
                Result<f1> c4 = c();
                if (c4 == null) {
                    wait();
                } else {
                    d0.n(c4.m128unboximpl());
                }
            }
        }
    }

    @Nullable
    public final Result<f1> c() {
        return this.f55519a;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        synchronized (this) {
            setResult(Result.m118boximpl(obj));
            notifyAll();
            f1 f1Var = f1.f55527a;
        }
    }

    public final void setResult(@Nullable Result<f1> result) {
        this.f55519a = result;
    }
}
