package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0012"}, m12616d2 = {"Lkotlin/math/a;", "", "", "a", "D", "LN2", "b", "epsilon", "c", "taylor_2_bound", "d", "taylor_n_bound", "e", "upper_taylor_2_bound", "f", "upper_taylor_n_bound", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.math.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class MathJVM {
    @JvmPlatformAnnotations

    /* renamed from: b */
    public static final double f41233b;
    @JvmPlatformAnnotations

    /* renamed from: c */
    public static final double f41234c;
    @JvmPlatformAnnotations

    /* renamed from: d */
    public static final double f41235d;
    @JvmPlatformAnnotations

    /* renamed from: e */
    public static final double f41236e;
    @JvmPlatformAnnotations

    /* renamed from: f */
    public static final double f41237f;
    @NotNull

    /* renamed from: g */
    public static final MathJVM f41238g = new MathJVM();
    @JvmPlatformAnnotations

    /* renamed from: a */
    public static final double f41232a = Math.log(2.0d);

    static {
        double ulp = Math.ulp(1.0d);
        f41233b = ulp;
        double sqrt = Math.sqrt(ulp);
        f41234c = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f41235d = sqrt2;
        double d = 1;
        Double.isNaN(d);
        f41236e = d / sqrt;
        Double.isNaN(d);
        f41237f = d / sqrt2;
    }

    private MathJVM() {
    }
}
