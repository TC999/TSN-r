package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.InterfaceC14446n;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

/* compiled from: NavGraphViewModelLazy.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m12616d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, m12615k = 3, m12614mv = {1, 1, 16})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements InterfaceC15269a<ViewModelProvider.Factory> {
    final /* synthetic */ InterfaceC14378o $backStackEntry;
    final /* synthetic */ InterfaceC14446n $backStackEntry$metadata;
    final /* synthetic */ InterfaceC15269a $factoryProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(InterfaceC15269a interfaceC15269a, InterfaceC14378o interfaceC14378o, InterfaceC14446n interfaceC14446n) {
        super(0);
        this.$factoryProducer = interfaceC15269a;
        this.$backStackEntry = interfaceC14378o;
        this.$backStackEntry$metadata = interfaceC14446n;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p617l1.InterfaceC15269a
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory factory;
        InterfaceC15269a interfaceC15269a = this.$factoryProducer;
        if (interfaceC15269a == null || (factory = (ViewModelProvider.Factory) interfaceC15269a.invoke()) == null) {
            NavBackStackEntry backStackEntry = (NavBackStackEntry) this.$backStackEntry.getValue();
            C14342f0.m8192h(backStackEntry, "backStackEntry");
            ViewModelProvider.Factory defaultViewModelProviderFactory = backStackEntry.getDefaultViewModelProviderFactory();
            C14342f0.m8192h(defaultViewModelProviderFactory, "backStackEntry.defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
        return factory;
    }
}
