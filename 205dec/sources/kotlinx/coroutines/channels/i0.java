package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00028\u00008\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/i0;", "E", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "k0", "Lkotlin/f1;", "h0", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "", "toString", "d", "Ljava/lang/Object;", "i0", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/o;", "e", "Lkotlinx/coroutines/o;", "cont", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i0<E> extends g0 {

    /* renamed from: d  reason: collision with root package name */
    private final E f59426d;
    @JvmField
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final kotlinx.coroutines.o<f1> f59427e;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(E e4, @NotNull kotlinx.coroutines.o<? super f1> oVar) {
        this.f59426d = e4;
        this.f59427e = oVar;
    }

    @Override // kotlinx.coroutines.channels.g0
    public void h0() {
        this.f59427e.S(kotlinx.coroutines.q.f60535d);
    }

    @Override // kotlinx.coroutines.channels.g0
    public E i0() {
        return this.f59426d;
    }

    @Override // kotlinx.coroutines.channels.g0
    public void j0(@NotNull t<?> tVar) {
        kotlinx.coroutines.o<f1> oVar = this.f59427e;
        Throwable p02 = tVar.p0();
        Result.a aVar = Result.Companion;
        oVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(p02)));
    }

    @Override // kotlinx.coroutines.channels.g0
    @Nullable
    public kotlinx.coroutines.internal.j0 k0(@Nullable s.d dVar) {
        if (this.f59427e.d(f1.f55527a, dVar != null ? dVar.f60410c : null) != null) {
            if (dVar != null) {
                dVar.d();
            }
            return kotlinx.coroutines.q.f60535d;
        }
        return null;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return u0.a(this) + '@' + u0.b(this) + '(' + i0() + ')';
    }
}
