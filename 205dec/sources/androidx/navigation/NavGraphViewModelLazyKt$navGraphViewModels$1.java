package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: NavGraphViewModelLazy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements a<ViewModelProvider.Factory> {
    final /* synthetic */ p $backStackEntry;
    final /* synthetic */ n $backStackEntry$metadata;
    final /* synthetic */ a $factoryProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(a aVar, p pVar, n nVar) {
        super(0);
        this.$factoryProducer = aVar;
        this.$backStackEntry = pVar;
        this.$backStackEntry$metadata = nVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d2.a
    @NotNull
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory factory;
        a aVar = this.$factoryProducer;
        if (aVar == null || (factory = (ViewModelProvider.Factory) aVar.invoke()) == null) {
            NavBackStackEntry backStackEntry = (NavBackStackEntry) this.$backStackEntry.getValue();
            f0.h(backStackEntry, "backStackEntry");
            ViewModelProvider.Factory defaultViewModelProviderFactory = backStackEntry.getDefaultViewModelProviderFactory();
            f0.h(defaultViewModelProviderFactory, "backStackEntry.defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
        return factory;
    }
}
