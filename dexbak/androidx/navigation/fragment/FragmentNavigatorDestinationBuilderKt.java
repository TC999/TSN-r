package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: FragmentNavigatorDestinationBuilder.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0086\b\u001a<\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0086\b¨\u0006\u000b"}, m12616d2 = {"Landroidx/fragment/app/Fragment;", "F", "Landroidx/navigation/NavGraphBuilder;", "", "id", "Lkotlin/f1;", "fragment", "Lkotlin/Function1;", "Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "navigation-fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends Fragment> void fragment(@NotNull NavGraphBuilder fragment, @IdRes int i, @NotNull InterfaceC15280l<? super FragmentNavigatorDestinationBuilder, Unit> builder) {
        C14342f0.m8183q(fragment, "$this$fragment");
        C14342f0.m8183q(builder, "builder");
        Navigator navigator = fragment.getProvider().getNavigator(FragmentNavigator.class);
        C14342f0.m8192h(navigator, "getNavigator(clazz.java)");
        C14342f0.m8175y(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i, Reflection.m8123d(Fragment.class));
        builder.invoke(fragmentNavigatorDestinationBuilder);
        fragment.destination(fragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(@NotNull NavGraphBuilder fragment, @IdRes int i) {
        C14342f0.m8183q(fragment, "$this$fragment");
        Navigator navigator = fragment.getProvider().getNavigator(FragmentNavigator.class);
        C14342f0.m8192h(navigator, "getNavigator(clazz.java)");
        C14342f0.m8175y(4, "F");
        fragment.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i, Reflection.m8123d(Fragment.class)));
    }
}
