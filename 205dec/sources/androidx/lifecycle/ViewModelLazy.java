package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewModelProvider.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B1\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lkotlin/p;", "", "isInitialized", "cached", "Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/d;", "viewModelClass", "Lkotlin/reflect/d;", "getValue", "()Landroidx/lifecycle/ViewModel;", "value", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "<init>", "(Lkotlin/reflect/d;Ld2/a;Ld2/a;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewModelLazy<VM extends ViewModel> implements p<VM> {
    private VM cached;
    private final a<ViewModelProvider.Factory> factoryProducer;
    private final a<ViewModelStore> storeProducer;
    private final d<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull d<VM> viewModelClass, @NotNull a<? extends ViewModelStore> storeProducer, @NotNull a<? extends ViewModelProvider.Factory> factoryProducer) {
        f0.p(viewModelClass, "viewModelClass");
        f0.p(storeProducer, "storeProducer");
        f0.p(factoryProducer, "factoryProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
    }

    @Override // kotlin.p
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.p
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm == null) {
            VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(c2.a.c(this.viewModelClass));
            this.cached = vm2;
            f0.o(vm2, "ViewModelProvider(store,\u2026ed = it\n                }");
            return vm2;
        }
        return vm;
    }
}
