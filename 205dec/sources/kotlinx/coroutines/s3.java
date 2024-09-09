package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Unconfined.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/s3;", "Lkotlinx/coroutines/l0;", "Lkotlin/coroutines/f;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/f1;", "dispatch", "", "toString", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s3 extends l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s3 f60557a = new s3();

    private s3() {
    }

    @Override // kotlinx.coroutines.l0
    public void dispatch(@NotNull kotlin.coroutines.f fVar, @NotNull Runnable runnable) {
        u3 u3Var = (u3) fVar.get(u3.f60743b);
        if (u3Var != null) {
            u3Var.f60744a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.l0
    public boolean isDispatchNeeded(@NotNull kotlin.coroutines.f fVar) {
        return false;
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
