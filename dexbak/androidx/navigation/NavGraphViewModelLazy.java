package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazy;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0087\b¨\u0006\n"}, m12616d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "", "navGraphId", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/o;", "navGraphViewModels", "navigation-fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.navigation.NavGraphViewModelLazyKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavGraphViewModelLazy {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC14378o<VM> navGraphViewModels(@NotNull Fragment navGraphViewModels, @IdRes int i, @Nullable InterfaceC15269a<? extends ViewModelProvider.Factory> interfaceC15269a) {
        InterfaceC14378o m7719c;
        C14342f0.m8183q(navGraphViewModels, "$this$navGraphViewModels");
        m7719c = C14389r.m7719c(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(navGraphViewModels, i));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(m7719c, null);
        C14342f0.m8175y(4, "VM");
        return FragmentViewModelLazy.createViewModelLazy(navGraphViewModels, Reflection.m8123d(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(interfaceC15269a, m7719c, null));
    }

    public static /* synthetic */ InterfaceC14378o navGraphViewModels$default(Fragment navGraphViewModels, int i, InterfaceC15269a interfaceC15269a, int i2, Object obj) {
        InterfaceC14378o m7719c;
        if ((i2 & 2) != 0) {
            interfaceC15269a = null;
        }
        C14342f0.m8183q(navGraphViewModels, "$this$navGraphViewModels");
        m7719c = C14389r.m7719c(new NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(navGraphViewModels, i));
        NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 = new NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(m7719c, null);
        C14342f0.m8175y(4, "VM");
        return FragmentViewModelLazy.createViewModelLazy(navGraphViewModels, Reflection.m8123d(ViewModel.class), navGraphViewModelLazyKt$navGraphViewModels$storeProducer$1, new NavGraphViewModelLazyKt$navGraphViewModels$1(interfaceC15269a, m7719c, null));
    }
}
