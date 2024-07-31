package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ArrayQueue;
import org.jetbrains.annotations.NotNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: EventLoop.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tJ\u0010\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010!\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010#\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001a¨\u0006&"}, m12616d2 = {"Lkotlinx/coroutines/m1;", "Lkotlinx/coroutines/l0;", "", "unconfined", "", "r", "J", "K", "L", "Lkotlinx/coroutines/c1;", "task", "Lkotlin/f1;", "s", "C", "p", "shutdown", "a", "useCount", "b", "Z", "shared", "Lkotlinx/coroutines/internal/a;", "c", "Lkotlinx/coroutines/internal/a;", "unconfinedQueue", "G", "()Z", "isEmpty", "B", "()J", "nextTime", "isActive", "H", "isUnconfinedLoopActive", "I", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.m1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15133m1 extends CoroutineDispatcher {

    /* renamed from: a */
    private long f43177a;

    /* renamed from: b */
    private boolean f43178b;

    /* renamed from: c */
    private ArrayQueue<DispatchedTask<?>> f43179c;

    /* renamed from: F */
    public static /* synthetic */ void m3995F(AbstractC15133m1 abstractC15133m1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            abstractC15133m1.m3996C(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    /* renamed from: q */
    public static /* synthetic */ void m3990q(AbstractC15133m1 abstractC15133m1, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            abstractC15133m1.m3991p(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    /* renamed from: r */
    private final long m3989r(boolean z) {
        if (z) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B */
    public long mo3967B() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f43179c;
        return (arrayQueue == null || arrayQueue.m4384d()) ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: C */
    public final void m3996C(boolean z) {
        this.f43177a += m3989r(z);
        if (z) {
            return;
        }
        this.f43178b = true;
    }

    /* renamed from: G */
    protected boolean mo3966G() {
        return m3993I();
    }

    /* renamed from: H */
    public final boolean m3994H() {
        return this.f43177a >= m3989r(true);
    }

    /* renamed from: I */
    public final boolean m3993I() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f43179c;
        if (arrayQueue != null) {
            return arrayQueue.m4384d();
        }
        return true;
    }

    /* renamed from: J */
    public long mo3563J() {
        return !m3992K() ? Long.MAX_VALUE : 0L;
    }

    /* renamed from: K */
    public final boolean m3992K() {
        DispatchedTask<?> m4383e;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f43179c;
        if (arrayQueue == null || (m4383e = arrayQueue.m4383e()) == null) {
            return false;
        }
        m4383e.run();
        return true;
    }

    /* renamed from: L */
    public boolean mo3562L() {
        return false;
    }

    public final boolean isActive() {
        return this.f43177a > 0;
    }

    /* renamed from: p */
    public final void m3991p(boolean z) {
        long m3989r = this.f43177a - m3989r(z);
        this.f43177a = m3989r;
        if (m3989r <= 0 && this.f43178b) {
            shutdown();
        }
    }

    /* renamed from: s */
    public final void m3988s(@NotNull DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.f43179c;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.f43179c = arrayQueue;
        }
        arrayQueue.m4387a(dispatchedTask);
    }

    protected void shutdown() {
    }
}
