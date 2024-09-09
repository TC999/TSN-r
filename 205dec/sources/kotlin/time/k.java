package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MonoTimeSource.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c1\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lkotlin/time/k;", "Lkotlin/time/b;", "Lkotlin/time/n;", "", "c", "", "toString", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k extends b implements n {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final k f59006c = new k();

    private k() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.b
    protected long c() {
        return System.nanoTime();
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
