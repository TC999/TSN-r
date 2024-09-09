package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.k;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FlowLiveData.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u000b"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/f;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "asFlow", "Ljava/time/Duration;", "timeout", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "FlowLiveDataConversions")
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class FlowLiveDataConversions {
    @NotNull
    public static final <T> h<T> asFlow(@NotNull LiveData<T> asFlow) {
        f0.p(asFlow, "$this$asFlow");
        return k.N0(new FlowLiveDataConversions$asFlow$1(asFlow, null));
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull h<? extends T> hVar) {
        return asLiveData$default(hVar, (f) null, 0L, 3, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull h<? extends T> hVar, @NotNull f fVar) {
        return asLiveData$default(hVar, fVar, 0L, 2, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull h<? extends T> asLiveData, @NotNull f context, long j4) {
        f0.p(asLiveData, "$this$asLiveData");
        f0.p(context, "context");
        return CoroutineLiveDataKt.liveData(context, j4, new FlowLiveDataConversions$asLiveData$1(asLiveData, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(h hVar, f fVar, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i4 & 2) != 0) {
            j4 = 5000;
        }
        return asLiveData(hVar, fVar, j4);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull h<? extends T> asLiveData, @NotNull f context, @NotNull Duration timeout) {
        f0.p(asLiveData, "$this$asLiveData");
        f0.p(context, "context");
        f0.p(timeout, "timeout");
        return asLiveData(asLiveData, context, timeout.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(h hVar, f fVar, Duration duration, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(hVar, fVar, duration);
    }
}
