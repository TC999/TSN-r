package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15061h3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m12616d2 = {"", "JOB_KEY", "Ljava/lang/String;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/q0;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/q0;", "viewModelScope", "lifecycle-viewmodel-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 1})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    @NotNull
    public static final CoroutineScope getViewModelScope(@NotNull ViewModel viewModelScope) {
        C14342f0.m8184p(viewModelScope, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModelScope.getTag(JOB_KEY);
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = viewModelScope.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(C15061h3.m4411c(null, 1, null).plus(Dispatchers.m5034e().mo3875p())));
        C14342f0.m8185o(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
