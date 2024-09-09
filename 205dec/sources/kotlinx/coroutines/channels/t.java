package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J#\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lkotlinx/coroutines/channels/t;", "E", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "k0", "Lkotlin/f1;", "h0", "value", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "i", "(Ljava/lang/Object;)V", "closed", "j0", "", "toString", "", "d", "Ljava/lang/Throwable;", "closeCause", "p0", "()Ljava/lang/Throwable;", "sendException", "o0", "receiveException", "m0", "()Lkotlinx/coroutines/channels/t;", "offerResult", "n0", "pollResult", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t<E> extends g0 implements e0<E> {
    @JvmField
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f59488d;

    public t(@Nullable Throwable th) {
        this.f59488d = th;
    }

    @Override // kotlinx.coroutines.channels.g0
    public void h0() {
    }

    @Override // kotlinx.coroutines.channels.e0
    public void i(E e4) {
    }

    @Override // kotlinx.coroutines.channels.g0
    public void j0(@NotNull t<?> tVar) {
    }

    @Override // kotlinx.coroutines.channels.g0
    @Nullable
    public kotlinx.coroutines.internal.j0 k0(@Nullable s.d dVar) {
        kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.q.f60535d;
        if (dVar != null) {
            dVar.d();
        }
        return j0Var;
    }

    @Override // kotlinx.coroutines.channels.e0
    @NotNull
    /* renamed from: m0 */
    public t<E> e() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.g0
    @NotNull
    /* renamed from: n0 */
    public t<E> i0() {
        return this;
    }

    @NotNull
    public final Throwable o0() {
        Throwable th = this.f59488d;
        return th != null ? th : new ClosedReceiveChannelException("Channel was closed");
    }

    @NotNull
    public final Throwable p0() {
        Throwable th = this.f59488d;
        return th != null ? th : new ClosedSendChannelException("Channel was closed");
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "Closed@" + u0.b(this) + '[' + this.f59488d + ']';
    }

    @Override // kotlinx.coroutines.channels.e0
    @Nullable
    public kotlinx.coroutines.internal.j0 y(E e4, @Nullable s.d dVar) {
        kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.q.f60535d;
        if (dVar != null) {
            dVar.d();
        }
        return j0Var;
    }
}
