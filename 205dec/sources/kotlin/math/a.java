package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MathJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lkotlin/math/a;", "", "", "b", "D", "LN2", "c", "epsilon", "d", "taylor_2_bound", "e", "taylor_n_bound", "f", "upper_taylor_2_bound", "g", "upper_taylor_n_bound", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f55731a = new a();
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final double f55732b = Math.log(2.0d);
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final double f55733c;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final double f55734d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final double f55735e;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static final double f55736f;
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public static final double f55737g;

    static {
        double ulp = Math.ulp(1.0d);
        f55733c = ulp;
        double sqrt = Math.sqrt(ulp);
        f55734d = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        f55735e = sqrt2;
        double d4 = 1;
        Double.isNaN(d4);
        f55736f = d4 / sqrt;
        Double.isNaN(d4);
        f55737g = d4 / sqrt2;
    }

    private a() {
    }
}
