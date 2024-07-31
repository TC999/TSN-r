package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.C15157q;
import kotlinx.coroutines.DebugStrings;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.internal.C15094s;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, m12616d2 = {"Lkotlinx/coroutines/channels/i0;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "i0", "Lkotlin/f1;", "f0", "Lkotlinx/coroutines/channels/t;", "closed", "h0", "", "toString", "d", "Ljava/lang/Object;", "g0", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/o;", "e", "Lkotlinx/coroutines/o;", "cont", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.i0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14706i0<E> extends AbstractC14702g0 {

    /* renamed from: d */
    private final E f42081d;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: e */
    public final InterfaceC15146o<Unit> f42082e;

    /* JADX WARN: Multi-variable type inference failed */
    public C14706i0(E e, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
        this.f42081d = e;
        this.f42082e = interfaceC15146o;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    /* renamed from: f0 */
    public void mo5210f0() {
        this.f42082e.mo3906T(C15157q.f43218d);
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    /* renamed from: g0 */
    public E mo5209g0() {
        return this.f42081d;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    /* renamed from: h0 */
    public void mo5208h0(@NotNull C14731t<?> c14731t) {
        InterfaceC15146o<Unit> interfaceC15146o = this.f42082e;
        Throwable m5202n0 = c14731t.m5202n0();
        Result.C14124a c14124a = Result.Companion;
        interfaceC15146o.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(m5202n0)));
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    @Nullable
    /* renamed from: i0 */
    public Symbol mo5207i0(@Nullable C15094s.C15098d c15098d) {
        if (this.f42082e.mo3901f(Unit.f41048a, c15098d != null ? c15098d.f43093c : null) != null) {
            if (c15098d != null) {
                c15098d.m4199d();
            }
            return C15157q.f43218d;
        }
        return null;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return DebugStrings.m3554a(this) + '@' + DebugStrings.m3553b(this) + '(' + mo5209g0() + ')';
    }
}
