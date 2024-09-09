package kotlinx.coroutines.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.g0;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ConcurrentLinkedList.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005\u00a8\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/g0;", "S", "Lkotlinx/coroutines/internal/g;", "", "r", "()Z", "n", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "()V", "", "c", "J", "o", "()J", "id", "", "p", "()I", "maxSlots", "g", "removed", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/g0;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g0<S extends g0<S>> extends g<S> {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60360d = AtomicIntegerFieldUpdater.newUpdater(g0.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    private final long f60361c;
    private volatile int cleanedAndPointers;

    public g0(long j4, @Nullable S s3, int i4) {
        super(s3);
        this.f60361c = j4;
        this.cleanedAndPointers = i4 << 16;
    }

    @Override // kotlinx.coroutines.internal.g
    public boolean g() {
        return this.cleanedAndPointers == p() && !i();
    }

    public final boolean n() {
        return f60360d.addAndGet(this, -65536) == p() && !i();
    }

    public final long o() {
        return this.f60361c;
    }

    public abstract int p();

    public final void q() {
        if (f60360d.incrementAndGet(this) != p() || i()) {
            return;
        }
        l();
    }

    public final boolean r() {
        int i4;
        do {
            i4 = this.cleanedAndPointers;
            if (!(i4 != p() || i())) {
                return false;
            }
        } while (!f60360d.compareAndSet(this, i4, 65536 + i4));
        return true;
    }
}
