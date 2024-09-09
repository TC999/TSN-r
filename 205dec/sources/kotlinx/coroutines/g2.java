package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\r\u001a\u00020\u00038\u0010X\u0090\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00038PX\u0090\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/g2;", "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/b0;", "", "k1", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "exception", "c", "b", "Z", "u0", "()Z", "handlesException", "v0", "onCancelComplete", "Lkotlinx/coroutines/e2;", "parent", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class g2 extends l2 implements b0 {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f60335b;

    public g2(@Nullable e2 e2Var) {
        super(true);
        B0(e2Var);
        this.f60335b = k1();
    }

    private final boolean k1() {
        l2 l2Var;
        u x02 = x0();
        if (!(x02 instanceof v)) {
            x02 = null;
        }
        v vVar = (v) x02;
        if (vVar != null && (l2Var = (l2) vVar.f60463d) != null) {
            while (!l2Var.u0()) {
                u x03 = l2Var.x0();
                if (!(x03 instanceof v)) {
                    x03 = null;
                }
                v vVar2 = (v) x03;
                if (vVar2 != null) {
                    l2Var = (l2) vVar2.f60463d;
                    if (l2Var == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.b0
    public boolean c(@NotNull Throwable th) {
        return J0(new d0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.b0
    public boolean complete() {
        return J0(kotlin.f1.f55527a);
    }

    @Override // kotlinx.coroutines.l2
    public boolean u0() {
        return this.f60335b;
    }

    @Override // kotlinx.coroutines.l2
    public boolean v0() {
        return true;
    }
}
