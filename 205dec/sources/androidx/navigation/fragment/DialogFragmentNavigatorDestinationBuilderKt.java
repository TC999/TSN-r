package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import d2.l;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DialogFragmentNavigatorDestinationBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0086\b\u001a<\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0002\b\tH\u0086\b\u00a8\u0006\u000b"}, d2 = {"Landroidx/fragment/app/DialogFragment;", "F", "Landroidx/navigation/NavGraphBuilder;", "", "id", "Lkotlin/f1;", "dialog", "Lkotlin/Function1;", "Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class DialogFragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder dialog, @IdRes int i4, @NotNull l<? super DialogFragmentNavigatorDestinationBuilder, f1> builder) {
        f0.q(dialog, "$this$dialog");
        f0.q(builder, "builder");
        Navigator navigator = dialog.getProvider().getNavigator(DialogFragmentNavigator.class);
        f0.h(navigator, "getNavigator(clazz.java)");
        f0.y(4, "F");
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i4, n0.d(DialogFragment.class));
        builder.invoke(dialogFragmentNavigatorDestinationBuilder);
        dialog.destination(dialogFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder dialog, @IdRes int i4) {
        f0.q(dialog, "$this$dialog");
        Navigator navigator = dialog.getProvider().getNavigator(DialogFragmentNavigator.class);
        f0.h(navigator, "getNavigator(clazz.java)");
        f0.y(4, "F");
        dialog.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i4, n0.d(DialogFragment.class)));
    }
}
