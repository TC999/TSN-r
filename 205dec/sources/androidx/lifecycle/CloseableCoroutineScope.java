package androidx.lifecycle;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewModel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "close", "Lkotlin/coroutines/f;", "coroutineContext", "Lkotlin/coroutines/f;", "getCoroutineContext", "()Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlin/coroutines/f;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CloseableCoroutineScope implements Closeable, q0 {
    @NotNull
    private final f coroutineContext;

    public CloseableCoroutineScope(@NotNull f context) {
        f0.p(context, "context");
        this.coroutineContext = context;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        j2.j(getCoroutineContext(), null, 1, null);
    }

    @Override // kotlinx.coroutines.q0
    @NotNull
    public f getCoroutineContext() {
        return this.coroutineContext;
    }
}
