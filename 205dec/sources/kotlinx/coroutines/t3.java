package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/t3;", "T", "Lkotlinx/coroutines/internal/f0;", "", "state", "Lkotlin/f1;", "k1", "Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t3<T> extends kotlinx.coroutines.internal.f0<T> {
    public t3(@NotNull kotlin.coroutines.f fVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        super(fVar, cVar);
    }

    @Override // kotlinx.coroutines.internal.f0, kotlinx.coroutines.a
    protected void k1(@Nullable Object obj) {
        Object a4 = i0.a(obj, this.f60357d);
        kotlin.coroutines.f context = this.f60357d.getContext();
        Object c4 = kotlinx.coroutines.internal.o0.c(context, null);
        try {
            this.f60357d.resumeWith(a4);
            kotlin.f1 f1Var = kotlin.f1.f55527a;
        } finally {
            kotlinx.coroutines.internal.o0.a(context, c4);
        }
    }
}
