package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C15137n0;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, m12616d2 = {"Lkotlinx/coroutines/channels/a0;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/o;", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", DomainCampaignEx.LOOPBACK_VALUE, "x1", "(Lkotlin/f1;)V", "", "cause", "", "handled", "n1", "isActive", "()Z", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Produce<E> extends ChannelCoroutine<E> implements InterfaceC14686b0<E> {
    public Produce(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14722n<E> interfaceC14722n) {
        super(coroutineContext, interfaceC14722n, true);
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14686b0
    public /* bridge */ /* synthetic */ InterfaceC14704h0 getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.C15125l2, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: n1 */
    protected void mo5431n1(@NotNull Throwable th, boolean z) {
        if (m5393s1().mo5178L(th) || z) {
            return;
        }
        C15137n0.m3969b(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: x1 */
    public void mo5430o1(@NotNull Unit unit) {
        InterfaceC14704h0.C14705a.m5442a(m5393s1(), null, 1, null);
    }
}
