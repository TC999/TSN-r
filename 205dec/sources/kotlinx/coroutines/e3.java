package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.common.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/e3;", "Lkotlinx/coroutines/a;", "Lkotlin/f1;", "", "exception", "", "z0", "Lkotlin/coroutines/f;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/f;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e3 extends a<kotlin.f1> {
    public e3(@NotNull kotlin.coroutines.f fVar, boolean z3) {
        super(fVar, z3);
    }

    @Override // kotlinx.coroutines.l2
    protected boolean z0(@NotNull Throwable th) {
        n0.b(getContext(), th);
        return true;
    }
}
