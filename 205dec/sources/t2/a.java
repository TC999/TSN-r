package t2;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.utils.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: scopeUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <T> Collection<T> a(@Nullable Collection<? extends T> collection, @NotNull Collection<? extends T> collection2) {
        f0.p(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    @NotNull
    public static final e<h> b(@NotNull Iterable<? extends h> scopes) {
        f0.p(scopes, "scopes");
        e<h> eVar = new e<>();
        for (h hVar : scopes) {
            h hVar2 = hVar;
            if ((hVar2 == null || hVar2 == h.c.f57931b) ? false : true) {
                eVar.add(hVar);
            }
        }
        return eVar;
    }
}
