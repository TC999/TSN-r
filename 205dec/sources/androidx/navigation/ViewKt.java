package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/view/View;", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewKt {
    @NotNull
    public static final NavController findNavController(@NotNull View findNavController) {
        f0.q(findNavController, "$this$findNavController");
        NavController findNavController2 = Navigation.findNavController(findNavController);
        f0.h(findNavController2, "Navigation.findNavController(this)");
        return findNavController2;
    }
}