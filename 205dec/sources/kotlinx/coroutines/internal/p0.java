package kotlinx.coroutines.internal;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
import kotlinx.coroutines.i3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadContext.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u001a\u001a\u00028\u0000\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00020\u00032\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016J*\u0010\u0010\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u000f*\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001e\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lkotlinx/coroutines/internal/p0;", "T", "Lkotlinx/coroutines/i3;", "Lkotlin/coroutines/f;", "context", "Q", "(Lkotlin/coroutines/f;)Ljava/lang/Object;", "oldState", "Lkotlin/f1;", "u", "(Lkotlin/coroutines/f;Ljava/lang/Object;)V", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "minusKey", "Lkotlin/coroutines/f$b;", "E", f3.f5657f, "(Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "", "toString", "a", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", "b", "Ljava/lang/Object;", "value", "Ljava/lang/ThreadLocal;", "c", "Ljava/lang/ThreadLocal;", "threadLocal", "<init>", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p0<T> implements i3<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final f.c<?> f60391a;

    /* renamed from: b  reason: collision with root package name */
    private final T f60392b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadLocal<T> f60393c;

    public p0(T t3, @NotNull ThreadLocal<T> threadLocal) {
        this.f60392b = t3;
        this.f60393c = threadLocal;
        this.f60391a = new q0(threadLocal);
    }

    @Override // kotlinx.coroutines.i3
    public T Q(@NotNull kotlin.coroutines.f fVar) {
        T t3 = this.f60393c.get();
        this.f60393c.set(this.f60392b);
        return t3;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) i3.a.a(this, r3, pVar);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> cVar) {
        if (kotlin.jvm.internal.f0.g(getKey(), cVar)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.f.b
    @NotNull
    public f.c<?> getKey() {
        return this.f60391a;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f minusKey(@NotNull f.c<?> cVar) {
        return kotlin.jvm.internal.f0.g(getKey(), cVar) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f plus(@NotNull kotlin.coroutines.f fVar) {
        return i3.a.d(this, fVar);
    }

    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.f60392b + ", threadLocal = " + this.f60393c + ')';
    }

    @Override // kotlinx.coroutines.i3
    public void u(@NotNull kotlin.coroutines.f fVar, T t3) {
        this.f60393c.set(t3);
    }
}
