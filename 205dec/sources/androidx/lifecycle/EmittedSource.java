package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0013\u0010\u0004\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "removeSource", "disposeNow", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "dispose", "", "disposed", "Z", "Landroidx/lifecycle/LiveData;", "source", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MediatorLiveData;", "mediator", "Landroidx/lifecycle/MediatorLiveData;", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class EmittedSource implements i1 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(@NotNull LiveData<?> source, @NotNull MediatorLiveData<?> mediator) {
        f0.p(source, "source");
        f0.p(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // kotlinx.coroutines.i1
    public void dispose() {
        j.f(r0.a(f1.e().q()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    @Nullable
    public final Object disposeNow(@NotNull c<? super kotlin.f1> cVar) {
        Object h4;
        Object i4 = h.i(f1.e().q(), new EmittedSource$disposeNow$2(this, null), cVar);
        h4 = b.h();
        return i4 == h4 ? i4 : kotlin.f1.f55527a;
    }
}
