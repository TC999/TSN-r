package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/channels/f0;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/a;", "", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "u", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "Lkotlin/Function1;", "Lkotlin/f1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.f0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class RendezvousChannel<E> extends AbstractChannel<E> {
    public RendezvousChannel(@Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        super(interfaceC15280l);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: Z */
    protected final boolean mo5174Z() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: a0 */
    protected final boolean mo5173a0() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: u */
    protected final boolean mo5172u() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: w */
    protected final boolean mo5171w() {
        return true;
    }
}
