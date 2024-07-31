package p636q1;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14564h;
import kotlin.text.InterfaceC14565j;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RegexExtensions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0002¨\u0006\u0005"}, m12616d2 = {"Lkotlin/text/i;", "", "name", "Lkotlin/text/h;", "a", "kotlin-stdlib-jdk8"}, m12615k = 2, m12614mv = {1, 5, 1}, m12613pn = "kotlin.text")
@JvmName(name = "RegexExtensionsJDK8Kt")
/* renamed from: q1.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15481a {
    @SinceKotlin(version = "1.2")
    @Nullable
    /* renamed from: a */
    public static final C14564h m2137a(@NotNull MatchResult get, @NotNull String name) {
        C14342f0.m8184p(get, "$this$get");
        C14342f0.m8184p(name, "name");
        if (!(get instanceof InterfaceC14565j)) {
            get = null;
        }
        InterfaceC14565j interfaceC14565j = (InterfaceC14565j) get;
        if (interfaceC14565j != null) {
            return interfaceC14565j.get(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
