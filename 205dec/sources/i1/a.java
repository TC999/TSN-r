package i1;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.random.Random;
import kotlin.ranges.k;
import kotlin.text.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JDK8PlatformImplementations.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Li1/a;", "Lh1/a;", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/h;", "c", "Lkotlin/random/Random;", "b", "<init>", "()V", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends h1.a {
    /* JADX WARN: Type inference failed for: r0v0, types: [o1.a, kotlin.random.Random] */
    @Override // kotlin.internal.a
    @NotNull
    public Random b() {
        return new o1.a();
    }

    @Override // kotlin.internal.a
    @Nullable
    public h c(@NotNull MatchResult matchResult, @NotNull String name) {
        f0.p(matchResult, "matchResult");
        f0.p(name, "name");
        if (!(matchResult instanceof Matcher)) {
            matchResult = null;
        }
        Matcher matcher = (Matcher) matchResult;
        if (matcher != null) {
            k kVar = new k(matcher.start(name), matcher.end(name) - 1);
            if (kVar.j().intValue() >= 0) {
                String group = matcher.group(name);
                f0.o(group, "matcher.group(name)");
                return new h(group, kVar);
            }
            return null;
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
