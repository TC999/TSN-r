package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\r\u001a\u00020\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0014"}, m12616d2 = {"Lkotlinx/coroutines/g2;", "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/b0;", "", "k1", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "exception", "c", "b", "Z", "u0", "()Z", "handlesException", "v0", "onCancelComplete", "Lkotlinx/coroutines/e2;", "parent", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.g2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15055g2 extends C15125l2 implements CompletableJob {

    /* renamed from: b */
    private final boolean f43018b;

    public C15055g2(@Nullable Job job) {
        super(true);
        m4078B0(job);
        this.f43018b = m4454k1();
    }

    /* renamed from: k1 */
    private final boolean m4454k1() {
        C15125l2 c15125l2;
        InterfaceC15235u m4015x0 = m4015x0();
        if (!(m4015x0 instanceof C15241v)) {
            m4015x0 = null;
        }
        C15241v c15241v = (C15241v) m4015x0;
        if (c15241v != null && (c15125l2 = (C15125l2) c15241v.f43146d) != null) {
            while (!c15125l2.mo4017u0()) {
                InterfaceC15235u m4015x02 = c15125l2.m4015x0();
                if (!(m4015x02 instanceof C15241v)) {
                    m4015x02 = null;
                }
                C15241v c15241v2 = (C15241v) m4015x02;
                if (c15241v2 != null) {
                    c15125l2 = (C15125l2) c15241v2.f43146d;
                    if (c15125l2 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CompletableJob
    /* renamed from: c */
    public boolean mo4455c(@NotNull Throwable th) {
        return m4070J0(new CompletionState(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return m4070J0(Unit.f41048a);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: u0 */
    public boolean mo4017u0() {
        return this.f43018b;
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: v0 */
    public boolean mo3489v0() {
        return true;
    }
}
