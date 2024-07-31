package kotlin.time;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0001\u001a(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0001\u001a(\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003H\u0001*\u001e\b\u0007\u0010\u000e\"\u00020\u00022\u00020\u0002B\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fB\u0002\b\r¨\u0006\u000f"}, m12616d2 = {"", DomainCampaignEx.LOOPBACK_VALUE, "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "b", "", "d", "c", "Lkotlin/SinceKotlin;", ConstantHelper.LOG_VS, "1.3", "Lkotlin/time/ExperimentalTime;", "DurationUnit", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/time/DurationUnitKt")
/* renamed from: kotlin.time.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class DurationUnitJvm {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: a */
    public static /* synthetic */ void m6001a() {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    /* renamed from: b */
    public static final double m6000b(double d, @NotNull TimeUnit sourceUnit, @NotNull TimeUnit targetUnit) {
        C14342f0.m8184p(sourceUnit, "sourceUnit");
        C14342f0.m8184p(targetUnit, "targetUnit");
        long convert = targetUnit.convert(1L, sourceUnit);
        if (convert > 0) {
            double d2 = convert;
            Double.isNaN(d2);
            return d * d2;
        }
        double convert2 = sourceUnit.convert(1L, targetUnit);
        Double.isNaN(convert2);
        return d / convert2;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalTime
    /* renamed from: c */
    public static final long m5999c(long j, @NotNull TimeUnit sourceUnit, @NotNull TimeUnit targetUnit) {
        C14342f0.m8184p(sourceUnit, "sourceUnit");
        C14342f0.m8184p(targetUnit, "targetUnit");
        return targetUnit.convert(j, sourceUnit);
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalTime
    /* renamed from: d */
    public static final long m5998d(long j, @NotNull TimeUnit sourceUnit, @NotNull TimeUnit targetUnit) {
        C14342f0.m8184p(sourceUnit, "sourceUnit");
        C14342f0.m8184p(targetUnit, "targetUnit");
        return targetUnit.convert(j, sourceUnit);
    }
}
