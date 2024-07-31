package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\b\u001a\u00060\u0004j\u0002`\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, m12616d2 = {"Lkotlinx/coroutines/internal/e0;", "", "", "toString", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "a", "Lkotlinx/coroutines/internal/s;", "ref", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class LockFreeLinkedList {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public final C15094s f43037a;

    public LockFreeLinkedList(@NotNull C15094s c15094s) {
        this.f43037a = c15094s;
    }

    @NotNull
    public String toString() {
        return "Removed[" + this.f43037a + ']';
    }
}
