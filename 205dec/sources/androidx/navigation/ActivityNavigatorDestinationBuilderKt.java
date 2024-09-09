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
/* compiled from: ActivityNavigatorDestinationBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006H\u0086\b\u00a8\u0006\t"}, d2 = {"Landroidx/navigation/NavGraphBuilder;", "", "id", "Lkotlin/Function1;", "Landroidx/navigation/ActivityNavigatorDestinationBuilder;", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builder", "activity", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ActivityNavigatorDestinationBuilderKt {
    public static final void activity(@NotNull NavGraphBuilder activity, @IdRes int i4, @NotNull l<? super ActivityNavigatorDestinationBuilder, f1> builder) {
        f0.q(activity, "$this$activity");
        f0.q(builder, "builder");
        Navigator navigator = activity.getProvider().getNavigator(ActivityNavigator.class);
        f0.h(navigator, "getNavigator(clazz.java)");
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) navigator, i4);
        builder.invoke(activityNavigatorDestinationBuilder);
        activity.destination(activityNavigatorDestinationBuilder);
    }
}
