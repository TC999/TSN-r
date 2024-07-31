package p639r1;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, m12616d2 = {"Ljava/time/Duration;", "Lkotlin/time/d;", "b", "(Ljava/time/Duration;)J", "a", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, m12615k = 2, m12614mv = {1, 5, 1}, m12613pn = "kotlin.time")
@JvmName(name = "DurationConversionsJDK8Kt")
/* renamed from: r1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DurationConversions {
    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: a */
    private static final Duration m2012a(long j) {
        Duration ofSeconds = Duration.ofSeconds(kotlin.time.Duration.m6157S(j), kotlin.time.Duration.m6153W(j));
        C14342f0.m8185o(ofSeconds, "toComponents { seconds, …, nanoseconds.toLong()) }");
        return ofSeconds;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    @ExperimentalTime
    /* renamed from: b */
    private static final long m2011b(Duration duration) {
        Duration.C14596a c14596a = kotlin.time.Duration.f41658e;
        return kotlin.time.Duration.m6128k0(c14596a.m6095C(duration.getSeconds()), c14596a.m6074u(duration.getNano()));
    }
}
