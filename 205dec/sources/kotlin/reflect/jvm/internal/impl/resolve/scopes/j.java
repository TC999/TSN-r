package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j {
    @Nullable
    public static final Set<kotlin.reflect.jvm.internal.impl.name.f> a(@NotNull Iterable<? extends h> iterable) {
        f0.p(iterable, "<this>");
        HashSet hashSet = new HashSet();
        for (h hVar : iterable) {
            Set<kotlin.reflect.jvm.internal.impl.name.f> g4 = hVar.g();
            if (g4 == null) {
                return null;
            }
            c0.o0(hashSet, g4);
        }
        return hashSet;
    }
}
