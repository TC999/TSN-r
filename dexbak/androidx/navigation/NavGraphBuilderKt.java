package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: NavGraphBuilder.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\n\u001a\u00020\u0006*\u00020\u00052\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u000b"}, m12616d2 = {"Landroidx/navigation/NavigatorProvider;", "", "id", "startDestination", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/navigation/NavGraph;", NotificationCompat.CATEGORY_NAVIGATION, "navigation-common-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavGraphBuilderKt {
    @NotNull
    public static final NavGraph navigation(@NotNull NavigatorProvider navigation, @IdRes int i, @IdRes int i2, @NotNull InterfaceC15280l<? super NavGraphBuilder, Unit> builder) {
        C14342f0.m8183q(navigation, "$this$navigation");
        C14342f0.m8183q(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigation, int i, int i2, InterfaceC15280l builder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        C14342f0.m8183q(navigation, "$this$navigation");
        C14342f0.m8183q(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i, i2);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(@NotNull NavGraphBuilder navigation, @IdRes int i, @IdRes int i2, @NotNull InterfaceC15280l<? super NavGraphBuilder, Unit> builder) {
        C14342f0.m8183q(navigation, "$this$navigation");
        C14342f0.m8183q(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation.getProvider(), i, i2);
        builder.invoke(navGraphBuilder);
        navigation.destination(navGraphBuilder);
    }
}
