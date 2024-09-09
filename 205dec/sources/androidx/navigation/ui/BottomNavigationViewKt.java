package androidx.navigation.ui;

import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BottomNavigationView.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "Landroidx/navigation/NavController;", "navController", "Lkotlin/f1;", "setupWithNavController", "navigation-ui-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class BottomNavigationViewKt {
    public static final void setupWithNavController(@NotNull BottomNavigationView setupWithNavController, @NotNull NavController navController) {
        f0.q(setupWithNavController, "$this$setupWithNavController");
        f0.q(navController, "navController");
        NavigationUI.setupWithNavController(setupWithNavController, navController);
    }
}
