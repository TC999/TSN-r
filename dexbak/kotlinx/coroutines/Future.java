package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001¨\u0006\b"}, m12616d2 = {"Lkotlinx/coroutines/e2;", "Ljava/util/concurrent/Future;", "future", "Lkotlinx/coroutines/i1;", "b", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "a", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/JobKt")
/* renamed from: kotlinx.coroutines.i2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Future {
    /* renamed from: a */
    public static final void m4402a(@NotNull InterfaceC15146o<?> interfaceC15146o, @NotNull java.util.concurrent.Future<?> future) {
        interfaceC15146o.mo3902e(new C15116k(future));
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: b */
    public static final InterfaceC15064i1 m4401b(@NotNull Job job, @NotNull java.util.concurrent.Future<?> future) {
        return job.mo3818w(new C15121l(job, future));
    }
}
