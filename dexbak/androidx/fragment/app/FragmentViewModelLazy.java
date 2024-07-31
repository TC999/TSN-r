package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u000e\b\n\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\b\u001a1\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0087\b\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0007¨\u0006\u0010"}, m12616d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStoreOwner;", "ownerProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/o;", "viewModels", "activityViewModels", "Lkotlin/reflect/d;", "viewModelClass", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "createViewModelLazy", "fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.fragment.app.FragmentViewModelLazyKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentViewModelLazy {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC14378o<VM> activityViewModels(@NotNull Fragment activityViewModels, @Nullable InterfaceC15269a<? extends ViewModelProvider.Factory> interfaceC15269a) {
        C14342f0.m8183q(activityViewModels, "$this$activityViewModels");
        C14342f0.m8175y(4, "VM");
        KClass m8123d = Reflection.m8123d(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (interfaceC15269a == null) {
            interfaceC15269a = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, m8123d, fragmentViewModelLazyKt$activityViewModels$1, interfaceC15269a);
    }

    public static /* synthetic */ InterfaceC14378o activityViewModels$default(Fragment activityViewModels, InterfaceC15269a interfaceC15269a, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC15269a = null;
        }
        C14342f0.m8183q(activityViewModels, "$this$activityViewModels");
        C14342f0.m8175y(4, "VM");
        KClass m8123d = Reflection.m8123d(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (interfaceC15269a == null) {
            interfaceC15269a = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, m8123d, fragmentViewModelLazyKt$activityViewModels$1, interfaceC15269a);
    }

    @MainThread
    @NotNull
    public static final <VM extends ViewModel> InterfaceC14378o<VM> createViewModelLazy(@NotNull final Fragment createViewModelLazy, @NotNull KClass<VM> viewModelClass, @NotNull InterfaceC15269a<? extends ViewModelStore> storeProducer, @Nullable InterfaceC15269a<? extends ViewModelProvider.Factory> interfaceC15269a) {
        C14342f0.m8183q(createViewModelLazy, "$this$createViewModelLazy");
        C14342f0.m8183q(viewModelClass, "viewModelClass");
        C14342f0.m8183q(storeProducer, "storeProducer");
        if (interfaceC15269a == null) {
            interfaceC15269a = new InterfaceC15269a<ViewModelProvider.Factory>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // p617l1.InterfaceC15269a
                @NotNull
                public final ViewModelProvider.Factory invoke() {
                    ViewModelProvider.Factory defaultViewModelProviderFactory = Fragment.this.getDefaultViewModelProviderFactory();
                    C14342f0.m8192h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, interfaceC15269a);
    }

    public static /* synthetic */ InterfaceC14378o createViewModelLazy$default(Fragment fragment, KClass kClass, InterfaceC15269a interfaceC15269a, InterfaceC15269a interfaceC15269a2, int i, Object obj) {
        if ((i & 4) != 0) {
            interfaceC15269a2 = null;
        }
        return createViewModelLazy(fragment, kClass, interfaceC15269a, interfaceC15269a2);
    }

    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC14378o<VM> viewModels(@NotNull Fragment viewModels, @NotNull InterfaceC15269a<? extends ViewModelStoreOwner> ownerProducer, @Nullable InterfaceC15269a<? extends ViewModelProvider.Factory> interfaceC15269a) {
        C14342f0.m8183q(viewModels, "$this$viewModels");
        C14342f0.m8183q(ownerProducer, "ownerProducer");
        C14342f0.m8175y(4, "VM");
        return createViewModelLazy(viewModels, Reflection.m8123d(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), interfaceC15269a);
    }

    public static /* synthetic */ InterfaceC14378o viewModels$default(final Fragment viewModels, InterfaceC15269a ownerProducer, InterfaceC15269a interfaceC15269a, int i, Object obj) {
        if ((i & 1) != 0) {
            ownerProducer = new InterfaceC15269a<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // p617l1.InterfaceC15269a
                @NotNull
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i & 2) != 0) {
            interfaceC15269a = null;
        }
        C14342f0.m8183q(viewModels, "$this$viewModels");
        C14342f0.m8183q(ownerProducer, "ownerProducer");
        C14342f0.m8175y(4, "VM");
        return createViewModelLazy(viewModels, Reflection.m8123d(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), interfaceC15269a);
    }
}
