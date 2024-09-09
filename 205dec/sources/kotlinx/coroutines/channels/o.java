package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.f1;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.l2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ChannelCoroutine.kt */
@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B%\u0012\u0006\u0010>\u001a\u00020=\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010?\u001a\u00020\b\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010\f\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J.\u0010\u0013\u001a\u00020\u00032#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u000fH\u0097\u0001J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0003J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0096\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0097A\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u0000H\u0097A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u001cJ\u001b\u0010 \u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!R \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F\u00a2\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010+\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010.\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u00100\u001a\u00020\b8\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b/\u0010*R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000018\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b2\u00103R#\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d018\u0016X\u0097\u0005\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b5\u00103R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000018\u0016X\u0097\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0001\u00103R&\u0010<\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000009088\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006B"}, d2 = {"Lkotlinx/coroutines/channels/o;", "E", "Lkotlinx/coroutines/a;", "Lkotlin/f1;", "Lkotlinx/coroutines/channels/n;", "cancel", "", "cause", "", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "d0", "K", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "f", "Lkotlinx/coroutines/channels/p;", "iterator", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "J", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/m0;", "w", "F", "O", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "d", "Lkotlinx/coroutines/channels/n;", "s1", "()Lkotlinx/coroutines/channels/n;", "_channel", "getChannel", "channel", "g", "()Z", "isClosedForReceive", "P", "isClosedForSend", "isEmpty", "p", "isFull", "Lkotlinx/coroutines/selects/d;", "C", "()Lkotlinx/coroutines/selects/d;", "onReceive", "L", "onReceiveOrClosed", "onReceiveOrNull", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "r", "()Lkotlinx/coroutines/selects/e;", "onSend", "Lkotlin/coroutines/f;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o<E> extends kotlinx.coroutines.a<f1> implements n<E> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final n<E> f59477d;

    public o(@NotNull kotlin.coroutines.f fVar, @NotNull n<E> nVar, boolean z3) {
        super(fVar, z3);
        this.f59477d = nVar;
    }

    static /* synthetic */ Object t1(o oVar, kotlin.coroutines.c cVar) {
        return oVar.f59477d.J(cVar);
    }

    static /* synthetic */ Object u1(o oVar, kotlin.coroutines.c cVar) {
        return oVar.f59477d.w(cVar);
    }

    static /* synthetic */ Object v1(o oVar, kotlin.coroutines.c cVar) {
        return oVar.f59477d.F(cVar);
    }

    static /* synthetic */ Object w1(o oVar, Object obj, kotlin.coroutines.c cVar) {
        return oVar.f59477d.O(obj, cVar);
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public kotlinx.coroutines.selects.d<E> C() {
        return this.f59477d.C();
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public kotlinx.coroutines.selects.d<E> E() {
        return this.f59477d.E();
    }

    @Override // kotlinx.coroutines.channels.d0
    @ObsoleteCoroutinesApi
    @Nullable
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    @LowPriorityInOverloadResolution
    public Object F(@NotNull kotlin.coroutines.c<? super E> cVar) {
        return v1(this, cVar);
    }

    @Override // kotlinx.coroutines.channels.d0
    @Nullable
    public Object J(@NotNull kotlin.coroutines.c<? super E> cVar) {
        return t1(this, cVar);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean K(@Nullable Throwable th) {
        return this.f59477d.K(th);
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public kotlinx.coroutines.selects.d<m0<E>> L() {
        return this.f59477d.L();
    }

    @Override // kotlinx.coroutines.channels.h0
    @Nullable
    public Object O(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return w1(this, e4, cVar);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean P() {
        return this.f59477d.P();
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean a(@Nullable Throwable th) {
        d0(new JobCancellationException(g0(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.j
    public final void b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(g0(), null, this);
        }
        d0(cancellationException);
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2, kotlinx.coroutines.channels.d0
    public /* synthetic */ void cancel() {
        d0(new JobCancellationException(g0(), null, this));
    }

    @Override // kotlinx.coroutines.l2
    public void d0(@NotNull Throwable th) {
        CancellationException d12 = l2.d1(this, th, null, 1, null);
        this.f59477d.b(d12);
        b0(d12);
    }

    @Override // kotlinx.coroutines.channels.h0
    @ExperimentalCoroutinesApi
    public void f(@NotNull d2.l<? super Throwable, f1> lVar) {
        this.f59477d.f(lVar);
    }

    @Override // kotlinx.coroutines.channels.d0
    public boolean g() {
        return this.f59477d.g();
    }

    @NotNull
    public final n<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.d0
    public boolean isEmpty() {
        return this.f59477d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public p<E> iterator() {
        return this.f59477d.iterator();
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean offer(E e4) {
        return this.f59477d.offer(e4);
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean p() {
        return this.f59477d.p();
    }

    @Override // kotlinx.coroutines.channels.d0
    @Nullable
    public E poll() {
        return this.f59477d.poll();
    }

    @Override // kotlinx.coroutines.channels.h0
    @NotNull
    public kotlinx.coroutines.selects.e<E, h0<E>> r() {
        return this.f59477d.r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final n<E> s1() {
        return this.f59477d;
    }

    @Override // kotlinx.coroutines.channels.d0
    @InternalCoroutinesApi
    @Nullable
    public Object w(@NotNull kotlin.coroutines.c<? super m0<? extends E>> cVar) {
        return u1(this, cVar);
    }
}
