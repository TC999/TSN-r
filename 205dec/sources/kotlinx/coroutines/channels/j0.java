package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00028\u0000`\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/j0;", "E", "Lkotlinx/coroutines/channels/i0;", "", "a0", "Lkotlin/f1;", "l0", "pollResult", "Lkotlinx/coroutines/o;", "cont", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/o;Ld2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j0<E> extends i0<E> {
    @JvmField
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final d2.l<E, f1> f59428f;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(E e4, @NotNull kotlinx.coroutines.o<? super f1> oVar, @NotNull d2.l<? super E, f1> lVar) {
        super(e4, oVar);
        this.f59428f = lVar;
    }

    @Override // kotlinx.coroutines.internal.s
    public boolean a0() {
        if (super.a0()) {
            l0();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.g0
    public void l0() {
        kotlinx.coroutines.internal.b0.b(this.f59428f, i0(), this.f59427e.getContext());
    }
}
