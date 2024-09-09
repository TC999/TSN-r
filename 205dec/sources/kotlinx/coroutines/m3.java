package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u00a8\u0006\u0007"}, d2 = {"", "name", "Lkotlinx/coroutines/s1;", "b", "", "nThreads", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m3 {
    @ObsoleteCoroutinesApi
    @NotNull
    public static final s1 a(int i4, @NotNull String str) {
        if (i4 >= 1) {
            return new l3(i4, str);
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i4 + " specified").toString());
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final s1 b(@NotNull String str) {
        return a(1, str);
    }
}
