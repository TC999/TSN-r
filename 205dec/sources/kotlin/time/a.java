package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSources.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lkotlin/time/a;", "Lkotlin/time/n;", "", "c", "Lkotlin/time/m;", "a", "Lkotlin/time/DurationUnit;", "b", "Lkotlin/time/DurationUnit;", "()Lkotlin/time/DurationUnit;", "unit", "<init>", "(Lkotlin/time/DurationUnit;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a implements n {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final DurationUnit f58983b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: TimeSources.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0003\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"Lkotlin/time/a$a;", "Lkotlin/time/m;", "Lkotlin/time/d;", "a", "()J", "duration", "e", "(J)Lkotlin/time/m;", "", "D", "startedAt", "Lkotlin/time/a;", "b", "Lkotlin/time/a;", "timeSource", "c", "J", "offset", "<init>", "(DLkotlin/time/a;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.time.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class C1195a extends m {

        /* renamed from: a  reason: collision with root package name */
        private final double f58984a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final a f58985b;

        /* renamed from: c  reason: collision with root package name */
        private final long f58986c;

        private C1195a(double d4, a aVar, long j4) {
            this.f58984a = d4;
            this.f58985b = aVar;
            this.f58986c = j4;
        }

        public /* synthetic */ C1195a(double d4, a aVar, long j4, u uVar) {
            this(d4, aVar, j4);
        }

        @Override // kotlin.time.m
        public long a() {
            return d.h0(f.l0(this.f58985b.c() - this.f58984a, this.f58985b.b()), this.f58986c);
        }

        @Override // kotlin.time.m
        @NotNull
        public m e(long j4) {
            return new C1195a(this.f58984a, this.f58985b, d.i0(this.f58986c, j4), null);
        }
    }

    public a(@NotNull DurationUnit unit) {
        f0.p(unit, "unit");
        this.f58983b = unit;
    }

    @Override // kotlin.time.n
    @NotNull
    public m a() {
        return new C1195a(c(), this, d.f58993b.W(), null);
    }

    @NotNull
    protected final DurationUnit b() {
        return this.f58983b;
    }

    protected abstract double c();
}
