package androidx.navigation.p020ui;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, m12616d2 = {"Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "Landroidx/navigation/NavController;", "navController", "Lkotlin/f1;", "setupWithNavController", "navigation-ui-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.navigation.ui.BottomNavigationViewKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class BottomNavigationView {
    public static final void setupWithNavController(@NotNull com.google.android.material.bottomnavigation.BottomNavigationView setupWithNavController, @NotNull NavController navController) {
        C14342f0.m8183q(setupWithNavController, "$this$setupWithNavController");
        C14342f0.m8183q(navController, "navController");
        NavigationUI.setupWithNavController(setupWithNavController, navController);
    }
}
