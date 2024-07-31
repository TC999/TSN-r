package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C15137n0;
import kotlinx.coroutines.C15163r1;
import kotlinx.coroutines.DebugStrings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/channels/d;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/o;", "Lkotlinx/coroutines/channels/f;", "", "cause", "Lkotlin/f1;", "R0", "exception", "", "z0", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "active", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class Actor<E> extends ChannelCoroutine<E> implements InterfaceC14699f<E> {
    public Actor(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14722n<E> interfaceC14722n, boolean z) {
        super(coroutineContext, interfaceC14722n, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: R0 */
    protected void mo4063R0(@Nullable Throwable th) {
        InterfaceC14722n<E> m5393s1 = m5393s1();
        if (th != null) {
            r1 = th instanceof CancellationException ? th : null;
            if (r1 == null) {
                r1 = C15163r1.m3833a(DebugStrings.m3554a(this) + " was cancelled", th);
            }
        }
        m5393s1.mo5474b(r1);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: z0 */
    protected boolean mo4013z0(@NotNull Throwable th) {
        C15137n0.m3969b(getContext(), th);
        return true;
    }
}
