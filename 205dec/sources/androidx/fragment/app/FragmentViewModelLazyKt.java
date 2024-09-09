package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.p;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FragmentViewModelLazy.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\b\u001a1\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\b\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007\u00a8\u0006\u0010"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStoreOwner;", "ownerProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/p;", "viewModels", "activityViewModels", "Lkotlin/reflect/d;", "viewModelClass", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "createViewModelLazy", "fragment-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class FragmentViewModelLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> p<VM> activityViewModels(@NotNull Fragment activityViewModels, @Nullable a<? extends ViewModelProvider.Factory> aVar) {
        f0.q(activityViewModels, "$this$activityViewModels");
        f0.y(4, "VM");
        d d4 = n0.d(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, d4, fragmentViewModelLazyKt$activityViewModels$1, aVar);
    }

    public static /* synthetic */ p activityViewModels$default(Fragment activityViewModels, a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = null;
        }
        f0.q(activityViewModels, "$this$activityViewModels");
        f0.y(4, "VM");
        d d4 = n0.d(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, d4, fragmentViewModelLazyKt$activityViewModels$1, aVar);
    }

    @MainThread
    @NotNull
    public static final <VM extends ViewModel> p<VM> createViewModelLazy(@NotNull final Fragment createViewModelLazy, @NotNull d<VM> viewModelClass, @NotNull a<? extends ViewModelStore> storeProducer, @Nullable a<? extends ViewModelProvider.Factory> aVar) {
        f0.q(createViewModelLazy, "$this$createViewModelLazy");
        f0.q(viewModelClass, "viewModelClass");
        f0.q(storeProducer, "storeProducer");
        if (aVar == null) {
            aVar = new a<ViewModelProvider.Factory>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d2.a
                @NotNull
                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory defaultViewModelProviderFactory = Fragment.this.getDefaultViewModelProviderFactory();
                    f0.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, aVar);
    }

    public static /* synthetic */ p createViewModelLazy$default(Fragment fragment, d dVar, a aVar, a aVar2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, dVar, aVar, aVar2);
    }

    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> p<VM> viewModels(@NotNull Fragment viewModels, @NotNull a<? extends ViewModelStoreOwner> ownerProducer, @Nullable a<? extends ViewModelProvider.Factory> aVar) {
        f0.q(viewModels, "$this$viewModels");
        f0.q(ownerProducer, "ownerProducer");
        f0.y(4, "VM");
        return createViewModelLazy(viewModels, n0.d(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), aVar);
    }

    public static /* synthetic */ p viewModels$default(final Fragment viewModels, a ownerProducer, a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            ownerProducer = new a<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d2.a
                @NotNull
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i4 & 2) != 0) {
            aVar = null;
        }
        f0.q(viewModels, "$this$viewModels");
        f0.q(ownerProducer, "ownerProducer");
        f0.y(4, "VM");
        return createViewModelLazy(viewModels, n0.d(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), aVar);
    }
}
