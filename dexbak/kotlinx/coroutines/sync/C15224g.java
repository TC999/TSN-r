package kotlinx.coroutines.sync;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.AbstractC15076g0;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\t\u0010\nJ,\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, m12616d2 = {"Lkotlinx/coroutines/sync/g;", "Lkotlinx/coroutines/internal/g0;", "", "index", "", "u", "(I)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", IAdInterListener.AdReqParam.WIDTH, "(ILjava/lang/Object;)V", "expected", "", UMCommonContent.f37782aL, "(ILjava/lang/Object;Ljava/lang/Object;)Z", "v", "(ILjava/lang/Object;)Ljava/lang/Object;", "s", "(I)V", "", "toString", "()Ljava/lang/String;", "p", "()I", "maxSlots", "", "id", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/sync/g;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.sync.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15224g extends AbstractC15076g0<C15224g> {
    @NotNull

    /* renamed from: e */
    AtomicReferenceArray f43395e;

    public C15224g(long j, @Nullable C15224g c15224g, int i) {
        super(j, c15224g, i);
        int i2;
        i2 = Semaphore.f43358f;
        this.f43395e = new AtomicReferenceArray(i2);
    }

    @Override // kotlinx.coroutines.internal.AbstractC15076g0
    /* renamed from: p */
    public int mo3605p() {
        int i;
        i = Semaphore.f43358f;
        return i;
    }

    /* renamed from: s */
    public final void m3604s(int i) {
        Symbol symbol;
        symbol = Semaphore.f43357e;
        this.f43395e.set(i, symbol);
        m4343q();
    }

    /* renamed from: t */
    public final boolean m3603t(int i, @Nullable Object obj, @Nullable Object obj2) {
        return this.f43395e.compareAndSet(i, obj, obj2);
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + m4344o() + ", hashCode=" + hashCode() + ']';
    }

    @Nullable
    /* renamed from: u */
    public final Object m3602u(int i) {
        return this.f43395e.get(i);
    }

    @Nullable
    /* renamed from: v */
    public final Object m3601v(int i, @Nullable Object obj) {
        return this.f43395e.getAndSet(i, obj);
    }

    /* renamed from: w */
    public final void m3600w(int i, @Nullable Object obj) {
        this.f43395e.set(i, obj);
    }
}
