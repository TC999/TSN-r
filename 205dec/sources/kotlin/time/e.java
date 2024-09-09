package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DurationJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\"\u001a\u0010\r\u001a\u00020\t8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\" \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"", "decimals", "Ljava/text/DecimalFormat;", "a", "", "value", "", "b", "c", "", "Z", "d", "()Z", "durationAssertionsEnabled", "", "Ljava/lang/ThreadLocal;", "[Ljava/lang/ThreadLocal;", "precisionFormats", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f58998a = false;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f58999b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i4 = 0; i4 < 4; i4++) {
            threadLocalArr[i4] = new ThreadLocal<>();
        }
        f58999b = threadLocalArr;
    }

    private static final DecimalFormat a(int i4) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i4 > 0) {
            decimalFormat.setMinimumFractionDigits(i4);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @NotNull
    public static final String b(double d4, int i4) {
        DecimalFormat a4;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f58999b;
        if (i4 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i4];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = a(i4);
                threadLocal.set(decimalFormat);
            }
            a4 = decimalFormat;
        } else {
            a4 = a(i4);
        }
        String format = a4.format(d4);
        f0.o(format, "format.format(value)");
        return format;
    }

    @NotNull
    public static final String c(double d4, int i4) {
        DecimalFormat a4 = a(0);
        a4.setMaximumFractionDigits(i4);
        String format = a4.format(d4);
        f0.o(format, "createFormatForDecimals(\u2026 }\n        .format(value)");
        return format;
    }

    public static final boolean d() {
        return f58998a;
    }
}
