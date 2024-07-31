package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m12616d2 = {"Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "J", "Lkotlinx/coroutines/f0;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/y1;", "Lkotlin/f1;", "dispose", "d", "Lkotlinx/coroutines/e2;", "job", "", "isActive", "()Z", "Lkotlinx/coroutines/q2;", "h", "()Lkotlinx/coroutines/q2;", "list", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.k2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15119k2<J extends Job> extends CompletionHandler implements InterfaceC15064i1, InterfaceC15259y1 {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: d */
    public final J f43146d;

    public AbstractC15119k2(@NotNull J j) {
        this.f43146d = j;
    }

    @Override // kotlinx.coroutines.InterfaceC15064i1
    public void dispose() {
        J j = this.f43146d;
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((C15125l2) j).m4053X0(this);
    }

    @Override // kotlinx.coroutines.InterfaceC15259y1
    @Nullable
    /* renamed from: h */
    public C15159q2 mo3496h() {
        return null;
    }

    @Override // kotlinx.coroutines.InterfaceC15259y1
    public boolean isActive() {
        return true;
    }
}
