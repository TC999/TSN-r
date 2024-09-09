package androidx.navigation;

import androidx.annotation.IdRes;
import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavGraph.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0017\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u00a8\u0006\f"}, d2 = {"Landroidx/navigation/NavGraph;", "", "id", "Landroidx/navigation/NavDestination;", f3.f5657f, "", "contains", "node", "Lkotlin/f1;", "plusAssign", "other", "minusAssign", "navigation-common-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavGraphKt {
    public static final boolean contains(@NotNull NavGraph contains, @IdRes int i4) {
        f0.q(contains, "$this$contains");
        return contains.findNode(i4) != null;
    }

    @NotNull
    public static final NavDestination get(@NotNull NavGraph get, @IdRes int i4) {
        f0.q(get, "$this$get");
        NavDestination findNode = get.findNode(i4);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i4 + " was found in " + get);
    }

    public static final void minusAssign(@NotNull NavGraph minusAssign, @NotNull NavDestination node) {
        f0.q(minusAssign, "$this$minusAssign");
        f0.q(node, "node");
        minusAssign.remove(node);
    }

    public static final void plusAssign(@NotNull NavGraph plusAssign, @NotNull NavDestination node) {
        f0.q(plusAssign, "$this$plusAssign");
        f0.q(node, "node");
        plusAssign.addDestination(node);
    }

    public static final void plusAssign(@NotNull NavGraph plusAssign, @NotNull NavGraph other) {
        f0.q(plusAssign, "$this$plusAssign");
        f0.q(other, "other");
        plusAssign.addAll(other);
    }
}
