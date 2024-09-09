package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import d2.p;
import java.time.Duration;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001aa\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2/\b\u0001\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\u0002\b\u0010\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001aa\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142/\b\u0001\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\u0002\b\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018*`\b\u0000\u0010\u0019\u001a\u0004\b\u0000\u0010\u0000\")\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\u0002\b\u00102)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\u0002\b\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"T", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", "source", "Landroidx/lifecycle/EmittedSource;", "addDisposableSource", "(Landroidx/lifecycle/MediatorLiveData;Landroidx/lifecycle/LiveData;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "block", "liveData", "(Lkotlin/coroutines/f;JLd2/p;)Landroidx/lifecycle/LiveData;", "Ljava/time/Duration;", "timeout", "(Lkotlin/coroutines/f;Ljava/time/Duration;Ld2/p;)Landroidx/lifecycle/LiveData;", "DEFAULT_TIMEOUT", "J", "Block", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    @Nullable
    public static final <T> Object addDisposableSource(@NotNull MediatorLiveData<T> mediatorLiveData, @NotNull LiveData<T> liveData, @NotNull c<? super EmittedSource> cVar) {
        return h.i(f1.e().q(), new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, null), cVar);
    }

    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull f context, long j4, @BuilderInference @NotNull p<? super LiveDataScope<T>, ? super c<? super kotlin.f1>, ? extends Object> block) {
        f0.p(context, "context");
        f0.p(block, "block");
        return new CoroutineLiveData(context, j4, block);
    }

    public static /* synthetic */ LiveData liveData$default(f fVar, long j4, p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i4 & 2) != 0) {
            j4 = 5000;
        }
        return liveData(fVar, j4, pVar);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull f context, @NotNull Duration timeout, @BuilderInference @NotNull p<? super LiveDataScope<T>, ? super c<? super kotlin.f1>, ? extends Object> block) {
        f0.p(context, "context");
        f0.p(timeout, "timeout");
        f0.p(block, "block");
        return new CoroutineLiveData(context, timeout.toMillis(), block);
    }

    public static /* synthetic */ LiveData liveData$default(f fVar, Duration duration, p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        return liveData(fVar, duration, pVar);
    }
}
