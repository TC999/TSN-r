package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import kotlinx.coroutines.internal.ThreadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: ChannelFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a]\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/internal/e;", "b", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/f;", "emitContext", "e", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", DomainCampaignEx.LOOPBACK_VALUE, "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "c", "(Lkotlin/coroutines/f;Ljava/lang/Object;Ljava/lang/Object;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14983f {
    /* renamed from: a */
    public static final /* synthetic */ FlowCollector m4780a(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        return m4776e(flowCollector, coroutineContext);
    }

    @NotNull
    /* renamed from: b */
    public static final <T> ChannelFlow<T> m4779b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h) {
        ChannelFlow<T> channelFlow = (ChannelFlow) (!(interfaceC14958h instanceof ChannelFlow) ? null : interfaceC14958h);
        return channelFlow != null ? channelFlow : new C14986h(interfaceC14958h, null, 0, null, 14, null);
    }

    @Nullable
    /* renamed from: c */
    public static final <T, V> Object m4778c(@NotNull CoroutineContext coroutineContext, V v, @NotNull Object obj, @NotNull InterfaceC15284p<? super V, ? super InterfaceC14268c<? super T>, ? extends Object> interfaceC15284p, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        Object m8642h;
        Object m4253c = ThreadContext.m4253c(coroutineContext, obj);
        try {
            C15001u c15001u = new C15001u(interfaceC14268c, coroutineContext);
            if (interfaceC15284p != null) {
                Object invoke = ((InterfaceC15284p) TypeIntrinsics.m8010q(interfaceC15284p, 2)).invoke(v, c15001u);
                ThreadContext.m4255a(coroutineContext, m4253c);
                m8642h = C14287b.m8642h();
                if (invoke == m8642h) {
                    DebugProbes.m8616c(interfaceC14268c);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            ThreadContext.m4255a(coroutineContext, m4253c);
            throw th;
        }
    }

    /* renamed from: d */
    public static /* synthetic */ Object m4777d(CoroutineContext coroutineContext, Object obj, Object obj2, InterfaceC15284p interfaceC15284p, InterfaceC14268c interfaceC14268c, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContext.m4254b(coroutineContext);
        }
        return m4778c(coroutineContext, obj, obj2, interfaceC15284p, interfaceC14268c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public static final <T> FlowCollector<T> m4776e(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return ((flowCollector instanceof SendingCollector) || (flowCollector instanceof NopCollector)) ? flowCollector : new C15002v(flowCollector, coroutineContext);
    }
}
