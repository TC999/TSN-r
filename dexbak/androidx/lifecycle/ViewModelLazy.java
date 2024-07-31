package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import p612k1.JvmClassMapping;
import p617l1.InterfaceC15269a;

/* compiled from: ViewModelProvider.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B1\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m12616d2 = {"Landroidx/lifecycle/ViewModelLazy;", "Landroidx/lifecycle/ViewModel;", "VM", "Lkotlin/o;", "", "isInitialized", "cached", "Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/d;", "viewModelClass", "Lkotlin/reflect/d;", "getValue", "()Landroidx/lifecycle/ViewModel;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "storeProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "<init>", "(Lkotlin/reflect/d;Ll1/a;Ll1/a;)V", "lifecycle-viewmodel-ktx_release"}, m12615k = 1, m12614mv = {1, 4, 1})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ViewModelLazy<VM extends ViewModel> implements InterfaceC14378o<VM> {
    private VM cached;
    private final InterfaceC15269a<ViewModelProvider.Factory> factoryProducer;
    private final InterfaceC15269a<ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull KClass<VM> viewModelClass, @NotNull InterfaceC15269a<? extends ViewModelStore> storeProducer, @NotNull InterfaceC15269a<? extends ViewModelProvider.Factory> factoryProducer) {
        C14342f0.m8184p(viewModelClass, "viewModelClass");
        C14342f0.m8184p(storeProducer, "storeProducer");
        C14342f0.m8184p(factoryProducer, "factoryProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
    }

    @Override // kotlin.InterfaceC14378o
    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.InterfaceC14378o
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm == null) {
            VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(JvmClassMapping.m12626c(this.viewModelClass));
            this.cached = vm2;
            C14342f0.m8185o(vm2, "ViewModelProvider(store,…ed = it\n                }");
            return vm2;
        }
        return vm;
    }
}
