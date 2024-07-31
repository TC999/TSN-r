package kotlin.time;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0012"}, m12616d2 = {"Lkotlin/time/c;", "Lkotlin/time/n;", "Lkotlin/time/d;", "a", "()J", "duration", "e", "(J)Lkotlin/time/n;", "Lkotlin/time/n;", "g", "()Lkotlin/time/n;", DomainCampaignEx.ROVER_KEY_MARK, "b", "J", "f", "adjustment", "<init>", "(Lkotlin/time/n;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class TimeSource extends AbstractC14601n {
    @NotNull

    /* renamed from: a */
    private final AbstractC14601n f41653a;

    /* renamed from: b */
    private final long f41654b;

    private TimeSource(AbstractC14601n abstractC14601n, long j) {
        this.f41653a = abstractC14601n;
        this.f41654b = j;
    }

    @Override // kotlin.time.AbstractC14601n
    /* renamed from: a */
    public long mo5984a() {
        return Duration.m6130j0(this.f41653a.mo5984a(), this.f41654b);
    }

    @Override // kotlin.time.AbstractC14601n
    @NotNull
    /* renamed from: e */
    public AbstractC14601n mo5980e(long j) {
        return new TimeSource(this.f41653a, Duration.m6128k0(this.f41654b, j));
    }

    /* renamed from: f */
    public final long m6179f() {
        return this.f41654b;
    }

    @NotNull
    /* renamed from: g */
    public final AbstractC14601n m6178g() {
        return this.f41653a;
    }

    public /* synthetic */ TimeSource(AbstractC14601n abstractC14601n, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(abstractC14601n, j);
    }
}
