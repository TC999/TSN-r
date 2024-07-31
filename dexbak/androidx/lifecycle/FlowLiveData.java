package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.flow.C15006k;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0006\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/f;", "context", "", "timeoutInMs", "Landroidx/lifecycle/LiveData;", "asLiveData", "asFlow", "Ljava/time/Duration;", "timeout", "lifecycle-livedata-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 1})
@JvmName(name = "FlowLiveDataConversions")
/* renamed from: androidx.lifecycle.FlowLiveDataConversions */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FlowLiveData {
    @NotNull
    public static final <T> InterfaceC14958h<T> asFlow(@NotNull LiveData<T> asFlow) {
        C14342f0.m8184p(asFlow, "$this$asFlow");
        return C15006k.m4707N0(new FlowLiveDataConversions$asFlow$1(asFlow, null));
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        return asLiveData$default(interfaceC14958h, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull CoroutineContext coroutineContext) {
        return asLiveData$default(interfaceC14958h, coroutineContext, 0L, 2, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull InterfaceC14958h<? extends T> asLiveData, @NotNull CoroutineContext context, long j) {
        C14342f0.m8184p(asLiveData, "$this$asLiveData");
        C14342f0.m8184p(context, "context");
        return CoroutineLiveDataKt.liveData(context, j, new FlowLiveDataConversions$asLiveData$1(asLiveData, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC14958h interfaceC14958h, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(interfaceC14958h, coroutineContext, j);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull InterfaceC14958h<? extends T> asLiveData, @NotNull CoroutineContext context, @NotNull Duration timeout) {
        C14342f0.m8184p(asLiveData, "$this$asLiveData");
        C14342f0.m8184p(context, "context");
        C14342f0.m8184p(timeout, "timeout");
        return asLiveData(asLiveData, context, timeout.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC14958h interfaceC14958h, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(interfaceC14958h, coroutineContext, duration);
    }
}
