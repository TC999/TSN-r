package androidx.navigation;

import androidx.annotation.IdRes;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavHost.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007H\u0086\b\u00a8\u0006\u000b"}, d2 = {"Landroidx/navigation/NavHost;", "", "id", "startDestination", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/navigation/NavGraph;", "createGraph", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavHostKt {
    @NotNull
    public static final NavGraph createGraph(@NotNull NavHost createGraph, @IdRes int i4, @IdRes int i5, @NotNull l<? super NavGraphBuilder, f1> builder) {
        f0.q(createGraph, "$this$createGraph");
        f0.q(builder, "builder");
        NavController navController = createGraph.getNavController();
        f0.h(navController, "navController");
        NavigatorProvider navigatorProvider = navController.getNavigatorProvider();
        f0.h(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i4, i5);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost createGraph, int i4, int i5, l builder, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        f0.q(createGraph, "$this$createGraph");
        f0.q(builder, "builder");
        NavController navController = createGraph.getNavController();
        f0.h(navController, "navController");
        NavigatorProvider navigatorProvider = navController.getNavigatorProvider();
        f0.h(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i4, i5);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
