package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h3;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewModel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"", "JOB_KEY", "Ljava/lang/String;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/q0;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/q0;", "viewModelScope", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final q0 getViewModelScope(@NotNull ViewModel viewModelScope) {
        f0.p(viewModelScope, "$this$viewModelScope");
        q0 q0Var = (q0) viewModelScope.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (q0Var != null) {
            return q0Var;
        }
        Object tagIfAbsent = viewModelScope.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new CloseableCoroutineScope(h3.c(null, 1, null).plus(f1.e().q())));
        f0.o(tagIfAbsent, "setTagIfAbsent(\n        \u2026Main.immediate)\n        )");
        return (q0) tagIfAbsent;
    }
}
