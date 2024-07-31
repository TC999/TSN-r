package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.InterfaceC14996o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0097Aø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00028\u00008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m12616d2 = {"Lkotlinx/coroutines/flow/v;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h0;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/internal/o;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "a", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "d", "()Ljava/util/List;", "replayCache", "getValue", "()Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "flow", "<init>", "(Lkotlinx/coroutines/flow/h0;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15046v<T> implements StateFlow<T>, InterfaceC14945c<T>, InterfaceC14996o<T> {

    /* renamed from: a */
    private final /* synthetic */ StateFlow<? extends T> f42993a;

    public C15046v(@NotNull StateFlow<? extends T> stateFlow) {
        this.f42993a = stateFlow;
    }

    @Override // kotlinx.coroutines.flow.internal.InterfaceC14996o
    @NotNull
    /* renamed from: a */
    public InterfaceC14958h<T> mo4473a(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return C15005j0.m4751d(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15048x
    @NotNull
    /* renamed from: d */
    public List<T> mo4471d() {
        return (List<? extends T>) this.f42993a.mo4471d();
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @InternalCoroutinesApi
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return this.f42993a.mo4470e(flowCollector, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.f42993a.getValue();
    }
}
