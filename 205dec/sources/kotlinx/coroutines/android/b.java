package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.f1;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.z0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: HandlerDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0001\b\u00a8\u0006\t"}, d2 = {"Lkotlinx/coroutines/android/b;", "Lkotlinx/coroutines/p2;", "Lkotlinx/coroutines/z0;", "t", "()Lkotlinx/coroutines/android/b;", "immediate", "<init>", "()V", "Lkotlinx/coroutines/android/a;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b extends p2 implements z0 {
    private b() {
    }

    @NotNull
    public i1 f(long j4, @NotNull Runnable runnable, @NotNull f fVar) {
        return z0.a.b(this, j4, runnable, fVar);
    }

    @Override // kotlinx.coroutines.z0
    @Nullable
    public Object o(long j4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return z0.a.a(this, j4, cVar);
    }

    @NotNull
    public abstract b t();

    public /* synthetic */ b(u uVar) {
        this();
    }
}
