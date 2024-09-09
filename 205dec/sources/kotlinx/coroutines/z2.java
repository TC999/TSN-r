package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Executors.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/z2;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/f1;", "run", "Lkotlinx/coroutines/l0;", "a", "Lkotlinx/coroutines/l0;", "dispatcher", "Lkotlinx/coroutines/o;", "b", "Lkotlinx/coroutines/o;", "continuation", "<init>", "(Lkotlinx/coroutines/l0;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class z2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final l0 f60777a;

    /* renamed from: b  reason: collision with root package name */
    private final o<kotlin.f1> f60778b;

    /* JADX WARN: Multi-variable type inference failed */
    public z2(@NotNull l0 l0Var, @NotNull o<? super kotlin.f1> oVar) {
        this.f60777a = l0Var;
        this.f60778b = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f60778b.G(this.f60777a, kotlin.f1.f55527a);
    }
}
