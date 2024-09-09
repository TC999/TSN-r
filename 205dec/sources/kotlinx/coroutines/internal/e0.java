package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LockFreeLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u00060\u0004j\u0002`\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\b\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/internal/e0;", "", "", "toString", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "a", "Lkotlinx/coroutines/internal/s;", "ref", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0 {
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final s f60354a;

    public e0(@NotNull s sVar) {
        this.f60354a = sVar;
    }

    @NotNull
    public String toString() {
        return "Removed[" + this.f60354a + ']';
    }
}
