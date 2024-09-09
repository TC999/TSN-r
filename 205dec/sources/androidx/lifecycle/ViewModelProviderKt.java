package androidx.lifecycle;

import androidx.annotation.MainThread;
import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewModelProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {f3.f5657f, "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider;", "(Landroidx/lifecycle/ViewModelProvider;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider get) {
        f0.p(get, "$this$get");
        f0.y(4, "VM");
        VM vm = (VM) get.get(ViewModel.class);
        f0.o(vm, "get(VM::class.java)");
        return vm;
    }
}
