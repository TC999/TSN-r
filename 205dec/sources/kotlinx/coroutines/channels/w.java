package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Actor.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003BO\u0012\u0006\u0010!\u001a\u00020 \u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"\u0012-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014\u00a2\u0006\u0002\b%\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016JX\u0010\u0018\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0013\u001a\u00028\u00002(\u0010\u0017\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lkotlinx/coroutines/channels/w;", "E", "Lkotlinx/coroutines/channels/d;", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/f1;", "p1", "element", "O", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "", "cause", "K", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "D", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "e", "Lkotlin/coroutines/c;", "continuation", "r", "()Lkotlinx/coroutines/selects/e;", "onSend", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "Lkotlinx/coroutines/channels/f;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class w<E> extends d<E> implements kotlinx.coroutines.selects.e<E, h0<? super E>> {

    /* renamed from: e  reason: collision with root package name */
    private kotlin.coroutines.c<? super f1> f59503e;

    public w(@NotNull kotlin.coroutines.f fVar, @NotNull n<E> nVar, @NotNull d2.p<? super f<E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        super(fVar, nVar, false);
        kotlin.coroutines.c<? super f1> c4;
        c4 = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
        this.f59503e = c4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.e
    public <R> void D(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, E e4, @NotNull d2.p<? super h0<? super E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        start();
        super.r().D(fVar, e4, pVar);
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.h0
    public boolean K(@Nullable Throwable th) {
        boolean K = super.K(th);
        start();
        return K;
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.h0
    @Nullable
    public Object O(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        start();
        Object O = super.O(e4, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return O == h4 ? O : f1.f55527a;
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.h0
    public boolean offer(E e4) {
        start();
        return super.offer(e4);
    }

    @Override // kotlinx.coroutines.a
    protected void p1() {
        z2.a.d(this.f59503e, this);
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.h0
    @NotNull
    public kotlinx.coroutines.selects.e<E, h0<E>> r() {
        return this;
    }
}
