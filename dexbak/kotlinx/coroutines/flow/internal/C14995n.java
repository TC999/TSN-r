package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.InterfaceC14722n;
import kotlinx.coroutines.channels.Produce;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowCoroutine.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/n;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/a0;", "", "cause", "", "h0", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14995n<T> extends Produce<T> {
    public C14995n(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14722n<T> interfaceC14722n) {
        super(coroutineContext, interfaceC14722n);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: h0 */
    public boolean mo4034h0(@NotNull Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return m4044c0(th);
    }
}