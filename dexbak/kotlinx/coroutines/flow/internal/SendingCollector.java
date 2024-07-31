package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/t;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/h0;", "a", "Lkotlinx/coroutines/channels/h0;", "channel", "<init>", "(Lkotlinx/coroutines/channels/h0;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SendingCollector<T> implements FlowCollector<T> {

    /* renamed from: a */
    private final InterfaceC14704h0<T> f42854a;

    /* JADX WARN: Multi-variable type inference failed */
    public SendingCollector(@NotNull InterfaceC14704h0<? super T> interfaceC14704h0) {
        this.f42854a = interfaceC14704h0;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object mo5177P = this.f42854a.mo5177P(t, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo5177P == m8642h ? mo5177P : Unit.f41048a;
    }
}
