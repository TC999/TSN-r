package kotlin.time;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\" \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\r"}, m12616d2 = {"", "decimals", "Ljava/text/DecimalFormat;", "a", "", DomainCampaignEx.LOOPBACK_VALUE, "", "b", "c", "", "Ljava/lang/ThreadLocal;", "[Ljava/lang/ThreadLocal;", "precisionFormats", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.time.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class formatToDecimals {

    /* renamed from: a */
    private static final ThreadLocal<DecimalFormat>[] f41665a;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal<>();
        }
        f41665a = threadLocalArr;
    }

    /* renamed from: a */
    private static final DecimalFormat m5994a(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i > 0) {
            decimalFormat.setMinimumFractionDigits(i);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @NotNull
    /* renamed from: b */
    public static final String m5993b(double d, int i) {
        DecimalFormat m5994a;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f41665a;
        if (i < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = m5994a(i);
                threadLocal.set(decimalFormat);
            }
            m5994a = decimalFormat;
        } else {
            m5994a = m5994a(i);
        }
        String format = m5994a.format(d);
        C14342f0.m8185o(format, "format.format(value)");
        return format;
    }

    @NotNull
    /* renamed from: c */
    public static final String m5992c(double d, int i) {
        DecimalFormat m5994a = m5994a(0);
        m5994a.setMaximumFractionDigits(i);
        String format = m5994a.format(d);
        C14342f0.m8185o(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }
}
