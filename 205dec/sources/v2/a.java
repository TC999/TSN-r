package v2;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.text.h;
import kotlin.text.i;
import kotlin.text.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RegexExtensions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0002\u00a8\u0006\u0005"}, d2 = {"Lkotlin/text/i;", "", "name", "Lkotlin/text/h;", "a", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 5, 1}, pn = "kotlin.text")
@JvmName(name = "RegexExtensionsJDK8Kt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final h a(@NotNull i get, @NotNull String name) {
        f0.p(get, "$this$get");
        f0.p(name, "name");
        if (!(get instanceof j)) {
            get = null;
        }
        j jVar = (j) get;
        if (jVar != null) {
            return jVar.get(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
