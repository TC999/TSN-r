package androidx.navigation;

import androidx.annotation.IdRes;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: NavGraph.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n¨\u0006\f"}, m12616d2 = {"Landroidx/navigation/NavGraph;", "", "id", "Landroidx/navigation/NavDestination;", "get", "", "contains", "node", "Lkotlin/f1;", "plusAssign", AdnName.OTHER, "minusAssign", "navigation-common-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavGraphKt {
    public static final boolean contains(@NotNull NavGraph contains, @IdRes int i) {
        C14342f0.m8183q(contains, "$this$contains");
        return contains.findNode(i) != null;
    }

    @NotNull
    public static final NavDestination get(@NotNull NavGraph get, @IdRes int i) {
        C14342f0.m8183q(get, "$this$get");
        NavDestination findNode = get.findNode(i);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i + " was found in " + get);
    }

    public static final void minusAssign(@NotNull NavGraph minusAssign, @NotNull NavDestination node) {
        C14342f0.m8183q(minusAssign, "$this$minusAssign");
        C14342f0.m8183q(node, "node");
        minusAssign.remove(node);
    }

    public static final void plusAssign(@NotNull NavGraph plusAssign, @NotNull NavDestination node) {
        C14342f0.m8183q(plusAssign, "$this$plusAssign");
        C14342f0.m8183q(node, "node");
        plusAssign.addDestination(node);
    }

    public static final void plusAssign(@NotNull NavGraph plusAssign, @NotNull NavGraph other) {
        C14342f0.m8183q(plusAssign, "$this$plusAssign");
        C14342f0.m8183q(other, "other");
        plusAssign.addAll(other);
    }
}
