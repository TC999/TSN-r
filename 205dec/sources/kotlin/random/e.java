package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PlatformRandom.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a\t\u0010\u0004\u001a\u00020\u0000H\u0081\b\u001a\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u00a8\u0006\n"}, d2 = {"Lkotlin/random/Random;", "Ljava/util/Random;", "a", "b", "c", "", "hi26", "low27", "", "d", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final java.util.Random a(@NotNull Random random) {
        f0.p(random, "<this>");
        a aVar = random instanceof a ? (a) random : null;
        return aVar == null ? new c(random) : aVar.a();
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final Random b(@NotNull java.util.Random random) {
        f0.p(random, "<this>");
        c cVar = random instanceof c ? (c) random : null;
        return cVar == null ? new d(random) : cVar.a();
    }

    @InlineOnly
    private static final Random c() {
        return kotlin.internal.b.f55545a.b();
    }

    public static final double d(int i4, int i5) {
        double d4 = (i4 << 27) + i5;
        Double.isNaN(d4);
        return d4 / 9.007199254740992E15d;
    }
}
