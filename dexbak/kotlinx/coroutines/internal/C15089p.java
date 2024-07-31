package kotlinx.coroutines.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocalAtomics.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\".\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00028À\u0002@À\u0002X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {"Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlinx/coroutines/internal/LocalAtomicInt;", "", DomainCampaignEx.LOOPBACK_VALUE, "a", "(Ljava/util/concurrent/atomic/AtomicInteger;)I", "b", "(Ljava/util/concurrent/atomic/AtomicInteger;I)V", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15089p {
    /* renamed from: a */
    public static final int m4248a(@NotNull AtomicInteger atomicInteger) {
        return atomicInteger.get();
    }

    /* renamed from: b */
    public static final void m4247b(@NotNull AtomicInteger atomicInteger, int i) {
        atomicInteger.set(i);
    }
}
