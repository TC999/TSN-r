package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.AbstractC15076g0;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentLinkedList.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u001a"}, m12616d2 = {"Lkotlinx/coroutines/internal/g0;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/internal/g;", "", "r", "()Z", "n", "Lkotlin/f1;", CampaignEx.JSON_KEY_AD_Q, "()V", "", "c", "J", "o", "()J", "id", "", "p", "()I", "maxSlots", "g", "removed", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/internal/g0;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.g0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15076g0<S extends AbstractC15076g0<S>> extends AbstractC15075g<S> {

    /* renamed from: d */
    private static final AtomicIntegerFieldUpdater f43043d = AtomicIntegerFieldUpdater.newUpdater(AbstractC15076g0.class, "cleanedAndPointers");

    /* renamed from: c */
    private final long f43044c;
    private volatile int cleanedAndPointers;

    public AbstractC15076g0(long j, @Nullable S s, int i) {
        super(s);
        this.f43044c = j;
        this.cleanedAndPointers = i << 16;
    }

    @Override // kotlinx.coroutines.internal.AbstractC15075g
    /* renamed from: g */
    public boolean mo4346g() {
        return this.cleanedAndPointers == mo3605p() && !m4351i();
    }

    /* renamed from: n */
    public final boolean m4345n() {
        return f43043d.addAndGet(this, SupportMenu.CATEGORY_MASK) == mo3605p() && !m4351i();
    }

    /* renamed from: o */
    public final long m4344o() {
        return this.f43044c;
    }

    /* renamed from: p */
    public abstract int mo3605p();

    /* renamed from: q */
    public final void m4343q() {
        if (f43043d.incrementAndGet(this) != mo3605p() || m4351i()) {
            return;
        }
        m4348l();
    }

    /* renamed from: r */
    public final boolean m4342r() {
        int i;
        do {
            i = this.cleanedAndPointers;
            if (!(i != mo3605p() || m4351i())) {
                return false;
            }
        } while (!f43043d.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
