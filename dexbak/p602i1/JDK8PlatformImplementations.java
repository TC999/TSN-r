package p602i1;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.random.Random;
import kotlin.ranges.C14413k;
import kotlin.text.C14564h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p598h1.JDK7PlatformImplementations;
import p627o1.PlatformThreadLocalRandom;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, m12616d2 = {"Li1/a;", "Lh1/a;", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/h;", "c", "Lkotlin/random/Random;", "b", "<init>", "()V", "kotlin-stdlib-jdk8"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: i1.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {
    @Override // kotlin.internal.PlatformImplementations
    @NotNull
    /* renamed from: b */
    public Random mo8537b() {
        return new PlatformThreadLocalRandom();
    }

    @Override // kotlin.internal.PlatformImplementations
    @Nullable
    /* renamed from: c */
    public C14564h mo8536c(@NotNull MatchResult matchResult, @NotNull String name) {
        C14342f0.m8184p(matchResult, "matchResult");
        C14342f0.m8184p(name, "name");
        if (!(matchResult instanceof Matcher)) {
            matchResult = null;
        }
        Matcher matcher = (Matcher) matchResult;
        if (matcher != null) {
            C14413k c14413k = new C14413k(matcher.start(name), matcher.end(name) - 1);
            if (c14413k.getStart().intValue() >= 0) {
                String group = matcher.group(name);
                C14342f0.m8185o(group, "matcher.group(name)");
                return new C14564h(group, c14413k);
            }
            return null;
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
