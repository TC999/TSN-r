package kotlinx.coroutines;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.InterfaceC15263z0;
import kotlinx.coroutines.internal.Concurrent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Executors.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010\u0011J*\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u000f\u0010\u0010\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010 \u001a\u00020\u001fH\u0016R\u0016\u0010#\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006%"}, m12616d2 = {"Lkotlinx/coroutines/t1;", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/z0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/f;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "s", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "r", "()V", "dispatch", "Lkotlinx/coroutines/o;", "continuation", "d", "Lkotlinx/coroutines/i1;", "e", "close", "", "toString", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "b", "Z", "removesFutureOnCancellation", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.t1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15226t1 extends AbstractC15168s1 implements InterfaceC15263z0 {

    /* renamed from: b */
    private boolean f43406b;

    /* renamed from: q */
    private final void m3593q(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        C15060h2.m4433g(coroutineContext, C15163r1.m3833a("The task was rejected", rejectedExecutionException));
    }

    /* renamed from: s */
    private final ScheduledFuture<?> m3591s(Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            Executor mo3514p = mo3514p();
            if (!(mo3514p instanceof ScheduledExecutorService)) {
                mo3514p = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) mo3514p;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (RejectedExecutionException e) {
            m3593q(coroutineContext, e);
            return null;
        }
    }

    @Override // kotlinx.coroutines.AbstractC15168s1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor mo3514p = mo3514p();
        if (!(mo3514p instanceof ExecutorService)) {
            mo3514p = null;
        }
        ExecutorService executorService = (ExecutorService) mo3514p;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    /* renamed from: d */
    public void mo3487d(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
        ScheduledFuture<?> m3591s = this.f43406b ? m3591s(new RunnableC15266z2(this, interfaceC15146o), interfaceC15146o.getContext(), j) : null;
        if (m3591s != null) {
            C15060h2.m4416x(interfaceC15146o, m3591s);
        } else {
            DefaultExecutor.f43436m.mo3487d(j, interfaceC15146o);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor mo3514p = mo3514p();
            InterfaceC15152o3 m3872b = C15156p3.m3872b();
            if (m3872b == null || (runnable2 = m3872b.m3926g(runnable)) == null) {
                runnable2 = runnable;
            }
            mo3514p.execute(runnable2);
        } catch (RejectedExecutionException e) {
            InterfaceC15152o3 m3872b2 = C15156p3.m3872b();
            if (m3872b2 != null) {
                m3872b2.m3931b();
            }
            m3593q(coroutineContext, e);
            Dispatchers.m5036c().dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @NotNull
    /* renamed from: e */
    public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        ScheduledFuture<?> m3591s = this.f43406b ? m3591s(runnable, coroutineContext, j) : null;
        if (m3591s != null) {
            return new C15059h1(m3591s);
        }
        return DefaultExecutor.f43436m.mo3486e(j, runnable, coroutineContext);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof AbstractC15226t1) && ((AbstractC15226t1) obj).mo3514p() == mo3514p();
    }

    public int hashCode() {
        return System.identityHashCode(mo3514p());
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @Nullable
    /* renamed from: k */
    public Object mo3485k(long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return InterfaceC15263z0.C15264a.m3484a(this, j, interfaceC14268c);
    }

    /* renamed from: r */
    public final void m3592r() {
        this.f43406b = Concurrent.m4367c(mo3514p());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return mo3514p().toString();
    }
}
