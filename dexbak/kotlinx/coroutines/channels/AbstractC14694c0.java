package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: AbstractChannel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&J%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/channels/c0;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/channels/t;", "closed", "Lkotlin/f1;", "h0", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function1;", "", "g0", "(Ljava/lang/Object;)Ll1/l;", "Lkotlinx/coroutines/internal/j0;", "f0", "()Lkotlinx/coroutines/internal/j0;", "offerResult", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14694c0<E> extends C15094s implements InterfaceC14698e0<E> {
    @Override // kotlinx.coroutines.channels.InterfaceC14698e0
    @NotNull
    /* renamed from: f0 */
    public Symbol mo5211d() {
        return C14685b.f42052e;
    }

    @Nullable
    /* renamed from: g0 */
    public InterfaceC15280l<Throwable, Unit> mo5477g0(E e) {
        return null;
    }

    /* renamed from: h0 */
    public abstract void mo5476h0(@NotNull C14731t<?> c14731t);
}
