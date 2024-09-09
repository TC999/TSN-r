package w2;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.time.ExperimentalTime;
import kotlin.time.d;

/* compiled from: DurationConversions.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0006"}, d2 = {"Ljava/time/Duration;", "Lkotlin/time/d;", "b", "(Ljava/time/Duration;)J", "a", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.time")
@JvmName(name = "DurationConversionsJDK8Kt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    private static final Duration a(long j4) {
        Duration ofSeconds = Duration.ofSeconds(d.Q(j4), d.U(j4));
        f0.o(ofSeconds, "toComponents { seconds, \u2026, nanoseconds.toLong()) }");
        return ofSeconds;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    private static final long b(Duration duration) {
        d.a aVar = d.f58993b;
        return d.i0(aVar.s0(duration.getSeconds()), aVar.k0(duration.getNano()));
    }
}
