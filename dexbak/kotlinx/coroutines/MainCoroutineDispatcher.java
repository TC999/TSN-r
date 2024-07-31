package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0005R\u0014\u0010\u0007\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, m12616d2 = {"Lkotlinx/coroutines/p2;", "Lkotlinx/coroutines/l0;", "", "toString", CampaignEx.JSON_KEY_AD_Q, "p", "()Lkotlinx/coroutines/p2;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.p2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    @NotNull
    /* renamed from: p */
    public abstract MainCoroutineDispatcher mo3875p();

    /* JADX INFO: Access modifiers changed from: protected */
    @InternalCoroutinesApi
    @Nullable
    /* renamed from: q */
    public final String m3874q() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher m5034e = Dispatchers.m5034e();
        if (this == m5034e) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = m5034e.mo3875p();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String m3874q = m3874q();
        if (m3874q != null) {
            return m3874q;
        }
        return DebugStrings.m3554a(this) + '@' + DebugStrings.m3553b(this);
    }
}
