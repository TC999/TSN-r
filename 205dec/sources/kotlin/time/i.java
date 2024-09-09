package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DurationUnit.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0001\u001a\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0001\u00a8\u0006\n"}, d2 = {"Lkotlin/time/DurationUnit;", "", "h", "shortName", "g", "", "isoChar", "", "isTimeComponent", "f", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/time/DurationUnitKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class i extends h {

    /* compiled from: DurationUnit.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59005a;

        static {
            int[] iArr = new int[DurationUnit.values().length];
            iArr[DurationUnit.NANOSECONDS.ordinal()] = 1;
            iArr[DurationUnit.MICROSECONDS.ordinal()] = 2;
            iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            iArr[DurationUnit.SECONDS.ordinal()] = 4;
            iArr[DurationUnit.MINUTES.ordinal()] = 5;
            iArr[DurationUnit.HOURS.ordinal()] = 6;
            iArr[DurationUnit.DAYS.ordinal()] = 7;
            f59005a = iArr;
        }
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final DurationUnit f(char c4, boolean z3) {
        if (!z3) {
            if (c4 == 'D') {
                return DurationUnit.DAYS;
            }
            throw new IllegalArgumentException(f0.C("Invalid or unsupported duration ISO non-time unit: ", Character.valueOf(c4)));
        } else if (c4 == 'H') {
            return DurationUnit.HOURS;
        } else {
            if (c4 == 'M') {
                return DurationUnit.MINUTES;
            }
            if (c4 == 'S') {
                return DurationUnit.SECONDS;
            }
            throw new IllegalArgumentException(f0.C("Invalid duration ISO time unit: ", Character.valueOf(c4)));
        }
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final DurationUnit g(@NotNull String shortName) {
        f0.p(shortName, "shortName");
        int hashCode = shortName.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && shortName.equals("us")) {
                                    return DurationUnit.MICROSECONDS;
                                }
                            } else if (shortName.equals("ns")) {
                                return DurationUnit.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return DurationUnit.MILLISECONDS;
                        }
                    } else if (shortName.equals("s")) {
                        return DurationUnit.SECONDS;
                    }
                } else if (shortName.equals("m")) {
                    return DurationUnit.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return DurationUnit.HOURS;
            }
        } else if (shortName.equals("d")) {
            return DurationUnit.DAYS;
        }
        throw new IllegalArgumentException(f0.C("Unknown duration unit short name: ", shortName));
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final String h(@NotNull DurationUnit durationUnit) {
        f0.p(durationUnit, "<this>");
        switch (a.f59005a[durationUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "m";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new IllegalStateException(f0.C("Unknown unit: ", durationUnit).toString());
        }
    }
}
