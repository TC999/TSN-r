package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

/* compiled from: FragmentViewModelLazy.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m12616d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, m12615k = 3, m12614mv = {1, 1, 15})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentViewModelLazyKt$activityViewModels$1 extends Lambda implements InterfaceC15269a<ViewModelStore> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p617l1.InterfaceC15269a
    @NotNull
    public final ViewModelStore invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        C14342f0.m8192h(requireActivity, "requireActivity()");
        ViewModelStore viewModelStore = requireActivity.getViewModelStore();
        C14342f0.m8192h(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}