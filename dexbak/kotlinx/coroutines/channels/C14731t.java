package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.C15157q;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J#\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, m12616d2 = {"Lkotlinx/coroutines/channels/t;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "i0", "Lkotlin/f1;", "f0", DomainCampaignEx.LOOPBACK_VALUE, "v", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "j", "(Ljava/lang/Object;)V", "closed", "h0", "", "toString", "", "d", "Ljava/lang/Throwable;", "closeCause", "n0", "()Ljava/lang/Throwable;", "sendException", "m0", "receiveException", "k0", "()Lkotlinx/coroutines/channels/t;", "offerResult", "l0", "pollResult", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14731t<E> extends AbstractC14702g0 implements InterfaceC14698e0<E> {
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: d */
    public final Throwable f42143d;

    public C14731t(@Nullable Throwable th) {
        this.f42143d = th;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    /* renamed from: f0 */
    public void mo5210f0() {
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    /* renamed from: h0 */
    public void mo5208h0(@NotNull C14731t<?> c14731t) {
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    @Nullable
    /* renamed from: i0 */
    public Symbol mo5207i0(@Nullable C15094s.C15098d c15098d) {
        Symbol symbol = C15157q.f43218d;
        if (c15098d != null) {
            c15098d.m4199d();
        }
        return symbol;
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14698e0
    /* renamed from: j */
    public void mo5206j(E e) {
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14698e0
    @NotNull
    /* renamed from: k0 */
    public C14731t<E> mo5211d() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    @NotNull
    /* renamed from: l0 */
    public C14731t<E> mo5209g0() {
        return this;
    }

    @NotNull
    /* renamed from: m0 */
    public final Throwable m5203m0() {
        Throwable th = this.f42143d;
        return th != null ? th : new Channel(C14729r.f42137a);
    }

    @NotNull
    /* renamed from: n0 */
    public final Throwable m5202n0() {
        Throwable th = this.f42143d;
        return th != null ? th : new ClosedSendChannelException(C14729r.f42137a);
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "Closed@" + DebugStrings.m3553b(this) + '[' + this.f42143d + ']';
    }

    @Override // kotlinx.coroutines.channels.InterfaceC14698e0
    @Nullable
    /* renamed from: v */
    public Symbol mo5201v(E e, @Nullable C15094s.C15098d c15098d) {
        Symbol symbol = C15157q.f43218d;
        if (c15098d != null) {
            c15098d.m4199d();
        }
        return symbol;
    }
}
