package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: TimeSources.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001:\u0001\u0005B\u0013\u0012\n\u0010\u000b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001e\u0010\u000b\u001a\u00060\u0006j\u0002`\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n¨\u0006\u000e"}, m12616d2 = {"Lkotlin/time/b;", "Lkotlin/time/o;", "", "c", "Lkotlin/time/n;", "a", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "b", "Ljava/util/concurrent/TimeUnit;", "()Ljava/util/concurrent/TimeUnit;", "unit", "<init>", "(Ljava/util/concurrent/TimeUnit;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14594b implements InterfaceC14602o {
    @NotNull

    /* renamed from: b */
    private final TimeUnit f41649b;

    /* compiled from: TimeSources.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0003\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000f\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0013"}, m12616d2 = {"Lkotlin/time/b$a;", "Lkotlin/time/n;", "Lkotlin/time/d;", "a", "()J", "duration", "e", "(J)Lkotlin/time/n;", "", "J", "startedAt", "Lkotlin/time/b;", "b", "Lkotlin/time/b;", "timeSource", "c", IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, "<init>", "(JLkotlin/time/b;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.time.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C14595a extends AbstractC14601n {

        /* renamed from: a */
        private final long f41650a;

        /* renamed from: b */
        private final AbstractC14594b f41651b;

        /* renamed from: c */
        private final long f41652c;

        private C14595a(long j, AbstractC14594b abstractC14594b, long j2) {
            this.f41650a = j;
            this.f41651b = abstractC14594b;
            this.f41652c = j2;
        }

        @Override // kotlin.time.AbstractC14601n
        /* renamed from: a */
        public long mo5984a() {
            return Duration.m6130j0(C14597e.m6013o0(this.f41651b.mo5987c() - this.f41650a, this.f41651b.m6180b()), this.f41652c);
        }

        @Override // kotlin.time.AbstractC14601n
        @NotNull
        /* renamed from: e */
        public AbstractC14601n mo5980e(long j) {
            return new C14595a(this.f41650a, this.f41651b, Duration.m6128k0(this.f41652c, j));
        }

        public /* synthetic */ C14595a(long j, AbstractC14594b abstractC14594b, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractC14594b, j2);
        }
    }

    public AbstractC14594b(@NotNull TimeUnit unit) {
        C14342f0.m8184p(unit, "unit");
        this.f41649b = unit;
    }

    @Override // kotlin.time.InterfaceC14602o
    @NotNull
    /* renamed from: a */
    public AbstractC14601n mo5979a() {
        return new C14595a(mo5987c(), this, Duration.f41658e.m6088g(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: b */
    public final TimeUnit m6180b() {
        return this.f41649b;
    }

    /* renamed from: c */
    protected abstract long mo5987c();
}
