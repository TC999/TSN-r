package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¨\u0006\u0007"}, m12616d2 = {"", "name", "Lkotlinx/coroutines/s1;", "b", "", "nThreads", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.m3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15135m3 {
    @ObsoleteCoroutinesApi
    @NotNull
    /* renamed from: a */
    public static final AbstractC15168s1 m3972a(int i, @NotNull String str) {
        if (i >= 1) {
            return new ThreadPoolDispatcher(i, str);
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
    }

    @ObsoleteCoroutinesApi
    @NotNull
    /* renamed from: b */
    public static final AbstractC15168s1 m3971b(@NotNull String str) {
        return m3972a(1, str);
    }
}
