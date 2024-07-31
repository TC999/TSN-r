package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Ranges.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0002\u001a\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0002\u001aB\u0010\u0010\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u000b\"\u0018\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\b\u0012\u0004\u0012\u00028\u00000\u0003*\u00028\u00012\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0087\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¨\u0006\u0017"}, m12616d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "that", "Lkotlin/ranges/g;", "e", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/g;", "", "Lkotlin/ranges/f;", "c", "", "d", "", "", "R", "element", "", "b", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "isPositive", "", "step", "Lkotlin/f1;", "a", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/ranges/RangesKt")
/* renamed from: kotlin.ranges.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14421p {
    /* renamed from: a */
    public static final void m7572a(boolean z, @NotNull Number step) {
        C14342f0.m8184p(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lkotlin/ranges/g<TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: b */
    private static final boolean m7571b(Iterable contains, Object obj) {
        C14342f0.m8184p(contains, "$this$contains");
        return obj != null && ((InterfaceC14407g) contains).contains((Comparable) obj);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: c */
    public static final InterfaceC14405f<Double> m7570c(double d, double d2) {
        return new C14403d(d, d2);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: d */
    public static final InterfaceC14405f<Float> m7569d(float f, float f2) {
        return new C14404e(f, f2);
    }

    @NotNull
    /* renamed from: e */
    public static final <T extends Comparable<? super T>> InterfaceC14407g<T> m7568e(@NotNull T rangeTo, @NotNull T that) {
        C14342f0.m8184p(rangeTo, "$this$rangeTo");
        C14342f0.m8184p(that, "that");
        return new C14409h(rangeTo, that);
    }
}
