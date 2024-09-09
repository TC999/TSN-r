package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.internal.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ConcurrentLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\"\u0010#J \u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00028\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u001b\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u001f\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010!\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0010\u00a8\u0006$"}, d2 = {"Lkotlinx/coroutines/internal/g;", "N", "", "Lkotlin/Function0;", "", "onClosedAction", "k", "(Ld2/a;)Lkotlinx/coroutines/internal/g;", "value", "", "m", "(Lkotlinx/coroutines/internal/g;)Z", "Lkotlin/f1;", "b", "()V", "j", "()Z", "l", "e", "()Ljava/lang/Object;", "nextOrClosed", "c", "()Lkotlinx/coroutines/internal/g;", "leftmostAliveNode", "h", "rightmostAliveNode", "d", "next", "i", "isTail", "f", "prev", "g", "removed", "<init>", "(Lkotlinx/coroutines/internal/g;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g<N extends g<N>> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60358a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60359b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");
    private volatile Object _next = null;
    private volatile Object _prev;

    public g(@Nullable N n4) {
        this._prev = n4;
    }

    private final N c() {
        N f4 = f();
        while (f4 != null && f4.g()) {
            f4 = (N) f4._prev;
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        N d4 = d();
        kotlin.jvm.internal.f0.m(d4);
        while (d4.g()) {
            d4 = (N) d4.d();
            kotlin.jvm.internal.f0.m(d4);
        }
        return d4;
    }

    public final void b() {
        f60359b.lazySet(this, null);
    }

    @Nullable
    public final N d() {
        Object e4 = e();
        if (e4 == f.b()) {
            return null;
        }
        return (N) e4;
    }

    @Nullable
    public final N f() {
        return (N) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final boolean j() {
        return io.netty.channel.a.a(f60358a, this, null, f.b());
    }

    @Nullable
    public final N k(@NotNull d2.a aVar) {
        Object e4 = e();
        if (e4 != f.b()) {
            return (N) e4;
        }
        aVar.invoke();
        throw new KotlinNothingValueException();
    }

    public final void l() {
        while (true) {
            N c4 = c();
            N h4 = h();
            h4._prev = c4;
            if (c4 != null) {
                c4._next = h4;
            }
            if (!h4.g() && (c4 == null || !c4.g())) {
                return;
            }
        }
    }

    public final boolean m(@NotNull N n4) {
        return io.netty.channel.a.a(f60358a, this, null, n4);
    }
}
