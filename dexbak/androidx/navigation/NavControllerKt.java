package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: NavController.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u000b"}, m12616d2 = {"Landroidx/navigation/NavController;", "", "id", "startDestination", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/navigation/NavGraph;", "createGraph", "navigation-runtime-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavControllerKt {
    @NotNull
    public static final NavGraph createGraph(@NotNull NavController createGraph, @IdRes int i, @IdRes int i2, @NotNull InterfaceC15280l<? super NavGraphBuilder, Unit> builder) {
        C14342f0.m8183q(createGraph, "$this$createGraph");
        C14342f0.m8183q(builder, "builder");
        NavigatorProvider navigatorProvider = createGraph.getNavigatorProvider();
        C14342f0.m8192h(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavController createGraph, int i, int i2, InterfaceC15280l builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        C14342f0.m8183q(createGraph, "$this$createGraph");
        C14342f0.m8183q(builder, "builder");
        NavigatorProvider navigatorProvider = createGraph.getNavigatorProvider();
        C14342f0.m8192h(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
