package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import p612k1.JvmClassMapping;

/* compiled from: FragmentNavigatorDestinationBuilder.kt */
@NavDestinationDsl
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, m12616d2 = {"Landroidx/navigation/fragment/FragmentNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "build", "Lkotlin/reflect/d;", "Landroidx/fragment/app/Fragment;", "fragmentClass", "Lkotlin/reflect/d;", "Landroidx/navigation/fragment/FragmentNavigator;", "navigator", "", "id", "<init>", "(Landroidx/navigation/fragment/FragmentNavigator;ILkotlin/reflect/d;)V", "navigation-fragment-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentNavigatorDestinationBuilder extends NavDestinationBuilder<FragmentNavigator.Destination> {
    private final KClass<? extends Fragment> fragmentClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavigatorDestinationBuilder(@NotNull FragmentNavigator navigator, @IdRes int i, @NotNull KClass<? extends Fragment> fragmentClass) {
        super(navigator, i);
        C14342f0.m8183q(navigator, "navigator");
        C14342f0.m8183q(fragmentClass, "fragmentClass");
        this.fragmentClass = fragmentClass;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public FragmentNavigator.Destination build() {
        FragmentNavigator.Destination destination = (FragmentNavigator.Destination) super.build();
        destination.setClassName(JvmClassMapping.m12626c(this.fragmentClass).getName());
        return destination;
    }
}
