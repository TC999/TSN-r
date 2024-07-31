package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: TimeSource.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000e"}, m12616d2 = {"Lkotlin/time/n;", "", "Lkotlin/time/d;", "a", "()J", "duration", "e", "(J)Lkotlin/time/n;", "d", "", "c", "b", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14601n {
    /* renamed from: a */
    public abstract long mo5984a();

    /* renamed from: b */
    public final boolean m5983b() {
        return Duration.m6134h0(mo5984a());
    }

    /* renamed from: c */
    public final boolean m5982c() {
        return !Duration.m6134h0(mo5984a());
    }

    @NotNull
    /* renamed from: d */
    public AbstractC14601n m5981d(long j) {
        return mo5980e(Duration.m6176A0(j));
    }

    @NotNull
    /* renamed from: e */
    public AbstractC14601n mo5980e(long j) {
        return new TimeSource(this, j, null);
    }
}
