package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.channels.h0;
import kotlinx.coroutines.n0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Produce.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/a0;", "E", "Lkotlinx/coroutines/channels/o;", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "value", "x1", "(Lkotlin/f1;)V", "", "cause", "", "handled", "n1", "isActive", "()Z", "Lkotlin/coroutines/f;", "parentContext", "Lkotlinx/coroutines/channels/n;", "channel", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/channels/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a0<E> extends o<E> implements b0<E> {
    public a0(@NotNull kotlin.coroutines.f fVar, @NotNull n<E> nVar) {
        super(fVar, nVar, true);
    }

    @Override // kotlinx.coroutines.channels.b0
    public /* bridge */ /* synthetic */ h0 getChannel() {
        return getChannel();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.l2, kotlinx.coroutines.e2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    protected void n1(@NotNull Throwable th, boolean z3) {
        if (s1().K(th) || z3) {
            return;
        }
        n0.b(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* renamed from: x1 */
    public void o1(@NotNull f1 f1Var) {
        h0.a.a(s1(), null, 1, null);
    }
}
