package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: ViewModelProvider.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"get", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider;", "(Landroidx/lifecycle/ViewModelProvider;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 1})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider get) {
        C14342f0.m8184p(get, "$this$get");
        C14342f0.m8175y(4, "VM");
        VM vm = (VM) get.get(ViewModel.class);
        C14342f0.m8185o(vm, "get(VM::class.java)");
        return vm;
    }
}
