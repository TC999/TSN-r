package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(m12615k = 3, m12614mv = {1, 5, 1})
/* renamed from: kotlin.time.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C14598f {

    /* renamed from: a */
    public static final /* synthetic */ int[] f41664a;

    static {
        int[] iArr = new int[TimeUnit.values().length];
        f41664a = iArr;
        iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
        iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
        iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
        iArr[TimeUnit.SECONDS.ordinal()] = 4;
        iArr[TimeUnit.MINUTES.ordinal()] = 5;
        iArr[TimeUnit.HOURS.ordinal()] = 6;
        iArr[TimeUnit.DAYS.ordinal()] = 7;
    }
}
