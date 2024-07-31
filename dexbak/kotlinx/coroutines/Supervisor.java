package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.internal.Scopes;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/f3;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/f0;", "", "cause", "", "h0", "Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.f3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class Supervisor<T> extends Scopes<T> {
    public Supervisor(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        super(coroutineContext, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: h0 */
    public boolean mo4034h0(@NotNull Throwable th) {
        return false;
    }
}
