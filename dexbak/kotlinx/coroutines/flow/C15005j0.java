package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogate;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

/* compiled from: StateFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0000\"\u001a\u0010\u0015\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0018\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u0012\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlinx/coroutines/flow/t;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/t;", "", "delta", "Lkotlin/f1;", "g", "Lkotlinx/coroutines/flow/h0;", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "d", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "getNONE$annotations", "()V", "NONE", "b", "getPENDING$annotations", "PENDING", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.j0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15005j0 {

    /* renamed from: a */
    private static final Symbol f42865a = new Symbol("NONE");

    /* renamed from: b */
    private static final Symbol f42866b = new Symbol("PENDING");

    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC15044t<T> m4754a(T t) {
        if (t == null) {
            t = (T) NullSurrogate.f42850a;
        }
        return new C14959i0(t);
    }

    @NotNull
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4751d(@NotNull StateFlow<? extends T> stateFlow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return (((i < 0 || 1 < i) && i != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? SharedFlow.m4828e(stateFlow, coroutineContext, i, bufferOverflow) : stateFlow;
    }

    /* renamed from: e */
    private static /* synthetic */ void m4750e() {
    }

    /* renamed from: f */
    private static /* synthetic */ void m4749f() {
    }

    /* renamed from: g */
    public static final void m4748g(@NotNull InterfaceC15044t<Integer> interfaceC15044t, int i) {
        int intValue;
        do {
            intValue = interfaceC15044t.getValue().intValue();
        } while (!interfaceC15044t.compareAndSet(Integer.valueOf(intValue), Integer.valueOf(intValue + i)));
    }
}
