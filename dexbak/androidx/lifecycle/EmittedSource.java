package androidx.lifecycle;

import androidx.annotation.MainThread;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15057h;
import kotlinx.coroutines.C15111j;
import kotlinx.coroutines.C15162r0;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterfaceC15064i1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineLiveData.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0013\u0010\u0004\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "removeSource", "disposeNow", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "dispose", "", "disposed", "Z", "Landroidx/lifecycle/LiveData;", SocialConstants.PARAM_SOURCE, "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/MediatorLiveData;", "mediator", "Landroidx/lifecycle/MediatorLiveData;", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V", "lifecycle-livedata-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 1})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class EmittedSource implements InterfaceC15064i1 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(@NotNull LiveData<?> source, @NotNull MediatorLiveData<?> mediator) {
        C14342f0.m8184p(source, "source");
        C14342f0.m8184p(mediator, "mediator");
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

    @Override // kotlinx.coroutines.InterfaceC15064i1
    public void dispose() {
        C15111j.m4126f(C15162r0.m3846a(Dispatchers.m5034e().mo3875p()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    @Nullable
    public final Object disposeNow(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m4445i = C15057h.m4445i(Dispatchers.m5034e().mo3875p(), new EmittedSource$disposeNow$2(this, null), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4445i == m8642h ? m4445i : Unit.f41048a;
    }
}
