package androidx.lifecycle;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, m12616d2 = {"findViewTreeViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/view/View;", "lifecycle-viewmodel-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.ViewTreeViewModelKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ViewTreeViewModel {
    @Nullable
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(@NotNull View findViewTreeViewModelStoreOwner) {
        C14342f0.m8184p(findViewTreeViewModelStoreOwner, "$this$findViewTreeViewModelStoreOwner");
        return ViewTreeViewModelStoreOwner.get(findViewTreeViewModelStoreOwner);
    }
}
