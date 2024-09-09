package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.h0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Broadcast.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B%\u0012\u0006\u00104\u001a\u000203\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u00105\u001a\u00020\b\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010\f\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0014J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u0018\u001a\u00020\u00032#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0014H\u0097\u0001J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0001J\u001b\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fR \u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010.\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b-\u0010&R&\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'0/8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lkotlinx/coroutines/channels/l;", "E", "Lkotlinx/coroutines/a;", "Lkotlin/f1;", "Lkotlinx/coroutines/channels/b0;", "Lkotlinx/coroutines/channels/j;", "", "cause", "", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "d0", "value", "t1", "(Lkotlin/f1;)V", "handled", "n1", "K", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "f", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/d0;", "t", "O", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/channels/j;", "s1", "()Lkotlinx/coroutines/channels/j;", "_channel", "isActive", "()Z", "Lkotlinx/coroutines/channels/h0;", "getChannel", "()Lkotlinx/coroutines/channels/h0;", "channel", "P", "isClosedForSend", "p", "isFull", "Lkotlinx/coroutines/selects/e;", "r", "()Lkotlinx/coroutines/selects/e;", "onSend", "Lkotlin/coroutines/f;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/j;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l<E> extends kotlinx.coroutines.a<f1> implements b0<E>, j<E> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final j<E> f59430d;

    public l(@NotNull kotlin.coroutines.f fVar, @NotNull j<E> jVar, boolean z3) {
        super(fVar, z3);
        this.f59430d = jVar;
    }

    static /* synthetic */ Object u1(l lVar, Object obj, kotlin.coroutines.c cVar) {
        return lVar.f59430d.O(obj, cVar);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean K(@Nullable Throwable th) {
        boolean K = this.f59430d.K(th);
        start();
        return K;
    }

    @Override // kotlinx.coroutines.channels.h0
    @Nullable
    public Object O(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return u1(this, e4, cVar);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean P() {
        return this.f59430d.P();
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean a(@Nullable Throwable th) {
        if (th == null) {
            th = new JobCancellationException(g0(), null, this);
        }
        d0(th);
        return true;
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    public final void b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(g0(), null, this);
        }
        d0(cancellationException);
    }

    @Override // kotlinx.coroutines.l2
    public void d0(@NotNull Throwable th) {
        CancellationException d12 = l2.d1(this, th, null, 1, null);
        this.f59430d.b(d12);
        b0(d12);
    }

    @Override // kotlinx.coroutines.channels.h0
    @ExperimentalCoroutinesApi
    public void f(@NotNull d2.l<? super Throwable, f1> lVar) {
        this.f59430d.f(lVar);
    }

    @Override // kotlinx.coroutines.channels.b0
    @NotNull
    public h0<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.l2, kotlinx.coroutines.e2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    protected void n1(@NotNull Throwable th, boolean z3) {
        if (this.f59430d.K(th) || z3) {
            return;
        }
        n0.b(getContext(), th);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean offer(E e4) {
        return this.f59430d.offer(e4);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean p() {
        return this.f59430d.p();
    }

    @Override // kotlinx.coroutines.channels.h0
    @NotNull
    public kotlinx.coroutines.selects.e<E, h0<E>> r() {
        return this.f59430d.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final j<E> s1() {
        return this.f59430d;
    }

    @Override // kotlinx.coroutines.channels.j
    @NotNull
    public d0<E> t() {
        return this.f59430d.t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: t1 */
    public void o1(@NotNull f1 f1Var) {
        h0.a.a(this.f59430d, null, 1, null);
    }
}
