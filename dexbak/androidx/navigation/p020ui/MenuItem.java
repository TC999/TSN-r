package androidx.navigation.p020ui;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m12616d2 = {"onNavDestinationSelected", "", "Landroid/view/MenuItem;", "navController", "Landroidx/navigation/NavController;", "navigation-ui-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.navigation.ui.MenuItemKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class MenuItem {
    public static final boolean onNavDestinationSelected(@NotNull android.view.MenuItem onNavDestinationSelected, @NotNull NavController navController) {
        C14342f0.m8183q(onNavDestinationSelected, "$this$onNavDestinationSelected");
        C14342f0.m8183q(navController, "navController");
        return NavigationUI.onNavDestinationSelected(onNavDestinationSelected, navController);
    }
}
