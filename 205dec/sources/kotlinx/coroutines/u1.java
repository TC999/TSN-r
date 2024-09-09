package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Executors.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/u1;", "Lkotlinx/coroutines/t1;", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class u1 extends t1 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Executor f60742c;

    public u1(@NotNull Executor executor) {
        this.f60742c = executor;
        t();
    }

    @Override // kotlinx.coroutines.s1
    @NotNull
    public Executor q() {
        return this.f60742c;
    }
}
