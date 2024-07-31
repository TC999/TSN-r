package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import kotlin.InterfaceC14378o;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0087\b¨\u0006\b"}, m12616d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/o;", "viewModels", "activity-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.activity.ActivityViewModelLazyKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ActivityViewModelLazy {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> InterfaceC14378o<VM> viewModels(@NotNull ComponentActivity viewModels, @Nullable InterfaceC15269a<? extends ViewModelProvider.Factory> interfaceC15269a) {
        C14342f0.m8183q(viewModels, "$this$viewModels");
        if (interfaceC15269a == null) {
            interfaceC15269a = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        C14342f0.m8175y(4, "VM");
        return new ViewModelLazy(Reflection.m8123d(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(viewModels), interfaceC15269a);
    }

    public static /* synthetic */ InterfaceC14378o viewModels$default(ComponentActivity viewModels, InterfaceC15269a interfaceC15269a, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC15269a = null;
        }
        C14342f0.m8183q(viewModels, "$this$viewModels");
        if (interfaceC15269a == null) {
            interfaceC15269a = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        C14342f0.m8175y(4, "VM");
        return new ViewModelLazy(Reflection.m8123d(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(viewModels), interfaceC15269a);
    }
}
