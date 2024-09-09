package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DurationUnitJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a \u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0001\u001a \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0001\u001a \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0001\u00a8\u0006\f"}, d2 = {"Lkotlin/time/DurationUnit;", "Ljava/util/concurrent/TimeUnit;", "e", "d", "", "value", "sourceUnit", "targetUnit", "a", "", "c", "b", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/time/DurationUnitKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class h {

    /* compiled from: DurationUnitJvm.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59004a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            iArr[TimeUnit.SECONDS.ordinal()] = 4;
            iArr[TimeUnit.MINUTES.ordinal()] = 5;
            iArr[TimeUnit.HOURS.ordinal()] = 6;
            iArr[TimeUnit.DAYS.ordinal()] = 7;
            f59004a = iArr;
        }
    }

    @SinceKotlin(version = "1.3")
    public static final double a(double d4, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        f0.p(sourceUnit, "sourceUnit");
        f0.p(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        if (convert > 0) {
            double d5 = convert;
            Double.isNaN(d5);
            return d4 * d5;
        }
        double convert2 = sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
        Double.isNaN(convert2);
        return d4 / convert2;
    }

    @SinceKotlin(version = "1.5")
    public static final long b(long j4, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        f0.p(sourceUnit, "sourceUnit");
        f0.p(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j4, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.5")
    public static final long c(long j4, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
        f0.p(sourceUnit, "sourceUnit");
        f0.p(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j4, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @SinceKotlin(version = "1.6")
    @ExperimentalTime
    @NotNull
    public static final DurationUnit d(@NotNull TimeUnit timeUnit) {
        f0.p(timeUnit, "<this>");
        switch (a.f59004a[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @SinceKotlin(version = "1.6")
    @ExperimentalTime
    @NotNull
    public static final TimeUnit e(@NotNull DurationUnit durationUnit) {
        f0.p(durationUnit, "<this>");
        return durationUnit.getTimeUnit$kotlin_stdlib();
    }
}
