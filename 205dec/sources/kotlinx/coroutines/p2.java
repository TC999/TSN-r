package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MainCoroutineDispatcher.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0005R\u0014\u0010\u0007\u001a\u00020\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/p2;", "Lkotlinx/coroutines/l0;", "", "toString", "r", CampaignEx.JSON_KEY_AD_Q, "()Lkotlinx/coroutines/p2;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class p2 extends l0 {
    @NotNull
    public abstract p2 q();

    /* JADX INFO: Access modifiers changed from: protected */
    @InternalCoroutinesApi
    @Nullable
    public final String r() {
        p2 p2Var;
        p2 e4 = f1.e();
        if (this == e4) {
            return "Dispatchers.Main";
        }
        try {
            p2Var = e4.q();
        } catch (UnsupportedOperationException unused) {
            p2Var = null;
        }
        if (this == p2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.l0
    @NotNull
    public String toString() {
        String r3 = r();
        if (r3 != null) {
            return r3;
        }
        return u0.a(this) + '@' + u0.b(this);
    }
}
