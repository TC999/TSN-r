package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a\t\u0010\u0004\u001a\u00020\u0000H\u0081\b\u001a\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000¨\u0006\n"}, m12616d2 = {"Lkotlin/random/Random;", "Ljava/util/Random;", "a", "b", "c", "", "hi26", "low27", "", "d", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.random.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14399e {
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: a */
    public static final java.util.Random m7656a(@NotNull Random asJavaRandom) {
        java.util.Random mo2810a;
        C14342f0.m8184p(asJavaRandom, "$this$asJavaRandom");
        PlatformRandom platformRandom = (PlatformRandom) (!(asJavaRandom instanceof PlatformRandom) ? null : asJavaRandom);
        return (platformRandom == null || (mo2810a = platformRandom.mo2810a()) == null) ? new C14395c(asJavaRandom) : mo2810a;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: b */
    public static final Random m7655b(@NotNull java.util.Random asKotlinRandom) {
        Random m7657a;
        C14342f0.m8184p(asKotlinRandom, "$this$asKotlinRandom");
        C14395c c14395c = (C14395c) (!(asKotlinRandom instanceof C14395c) ? null : asKotlinRandom);
        return (c14395c == null || (m7657a = c14395c.m7657a()) == null) ? new C14397d(asKotlinRandom) : m7657a;
    }

    @InlineOnly
    /* renamed from: c */
    private static final Random m7654c() {
        return C14307b.f41062a.mo8537b();
    }

    /* renamed from: d */
    public static final double m7653d(int i, int i2) {
        double d = (i << 27) + i2;
        double d2 = 9007199254740992L;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }
}
