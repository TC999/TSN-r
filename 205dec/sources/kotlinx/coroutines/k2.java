package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: JobSupport.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00028\u00008\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/e2;", "J", "Lkotlinx/coroutines/f0;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/y1;", "Lkotlin/f1;", "dispose", "d", "Lkotlinx/coroutines/e2;", "job", "", "isActive", "()Z", "Lkotlinx/coroutines/q2;", "f", "()Lkotlinx/coroutines/q2;", "list", "<init>", "(Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k2<J extends e2> extends f0 implements i1, y1 {
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final J f60463d;

    public k2(@NotNull J j4) {
        this.f60463d = j4;
    }

    @Override // kotlinx.coroutines.i1
    public void dispose() {
        J j4 = this.f60463d;
        if (j4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((l2) j4).X0(this);
    }

    @Override // kotlinx.coroutines.y1
    @Nullable
    public q2 f() {
        return null;
    }

    @Override // kotlinx.coroutines.y1
    public boolean isActive() {
        return true;
    }
}
