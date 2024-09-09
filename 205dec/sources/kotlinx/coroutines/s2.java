package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Job.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/s2;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/u;", "Lkotlin/f1;", "dispose", "", "cause", "", "g", "", "toString", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s2 implements i1, u {

    /* renamed from: a  reason: collision with root package name */
    public static final s2 f60556a = new s2();

    private s2() {
    }

    @Override // kotlinx.coroutines.i1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.u
    public boolean g(@NotNull Throwable th) {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
