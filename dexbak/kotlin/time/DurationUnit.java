package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0001\u001a\u0014\u0010\u0005\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0001\u001a\u001c\u0010\n\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0001¨\u0006\u000b"}, m12616d2 = {"Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "", "g", "shortName", "f", "", "isoChar", "", "isTimeComponent", "e", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/time/DurationUnitKt")
/* renamed from: kotlin.time.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class DurationUnit extends DurationUnitJvm {
    @SinceKotlin(version = "1.5")
    @ExperimentalTime
    @NotNull
    /* renamed from: e */
    public static final TimeUnit m5997e(char c, boolean z) {
        if (!z) {
            if (c == 'D') {
                return TimeUnit.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c);
        } else if (c != 'H') {
            if (c != 'M') {
                if (c == 'S') {
                    return TimeUnit.SECONDS;
                }
                throw new IllegalArgumentException("Invalid duration ISO time unit: " + c);
            }
            return TimeUnit.MINUTES;
        } else {
            return TimeUnit.HOURS;
        }
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalTime
    @NotNull
    /* renamed from: f */
    public static final TimeUnit m5996f(@NotNull String shortName) {
        C14342f0.m8184p(shortName, "shortName");
        int hashCode = shortName.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && shortName.equals("us")) {
                                    return TimeUnit.MICROSECONDS;
                                }
                            } else if (shortName.equals("ns")) {
                                return TimeUnit.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return TimeUnit.MILLISECONDS;
                        }
                    } else if (shortName.equals("s")) {
                        return TimeUnit.SECONDS;
                    }
                } else if (shortName.equals("m")) {
                    return TimeUnit.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return TimeUnit.HOURS;
            }
        } else if (shortName.equals("d")) {
            return TimeUnit.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + shortName);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @NotNull
    /* renamed from: g */
    public static final String m5995g(@NotNull TimeUnit shortName) {
        C14342f0.m8184p(shortName, "$this$shortName");
        switch (C14598f.f41664a[shortName.ordinal()]) {
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
                throw new IllegalStateException(("Unknown unit: " + shortName).toString());
        }
    }
}
