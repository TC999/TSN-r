package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ActivityViewModelLazy.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0087\b\u00a8\u0006\b"}, d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/activity/ComponentActivity;", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factoryProducer", "Lkotlin/p;", "viewModels", "activity-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ActivityViewModelLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <VM extends ViewModel> p<VM> viewModels(@NotNull ComponentActivity viewModels, @Nullable a<? extends ViewModelProvider.Factory> aVar) {
        f0.q(viewModels, "$this$viewModels");
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        f0.y(4, "VM");
        return new ViewModelLazy(n0.d(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(viewModels), aVar);
    }

    public static /* synthetic */ p viewModels$default(ComponentActivity viewModels, a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = null;
        }
        f0.q(viewModels, "$this$viewModels");
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        f0.y(4, "VM");
        return new ViewModelLazy(n0.d(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(viewModels), aVar);
    }
}
