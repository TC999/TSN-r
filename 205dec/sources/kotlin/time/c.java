package kotlin.time;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSource.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0003\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\u00020\u00028\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0012"}, d2 = {"Lkotlin/time/c;", "Lkotlin/time/m;", "Lkotlin/time/d;", "a", "()J", "duration", "e", "(J)Lkotlin/time/m;", "Lkotlin/time/m;", "g", "()Lkotlin/time/m;", DomainCampaignEx.ROVER_KEY_MARK, "b", "J", "f", "adjustment", "<init>", "(Lkotlin/time/m;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m f58991a;

    /* renamed from: b  reason: collision with root package name */
    private final long f58992b;

    private c(m mVar, long j4) {
        this.f58991a = mVar;
        this.f58992b = j4;
    }

    public /* synthetic */ c(m mVar, long j4, u uVar) {
        this(mVar, j4);
    }

    @Override // kotlin.time.m
    public long a() {
        return d.h0(this.f58991a.a(), f());
    }

    @Override // kotlin.time.m
    @NotNull
    public m e(long j4) {
        return new c(this.f58991a, d.i0(f(), j4), null);
    }

    public final long f() {
        return this.f58992b;
    }

    @NotNull
    public final m g() {
        return this.f58991a;
    }
}
