package androidx.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: View.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m12616d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/view/View;", "navigation-runtime-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ViewKt {
    @NotNull
    public static final NavController findNavController(@NotNull View findNavController) {
        C14342f0.m8183q(findNavController, "$this$findNavController");
        NavController findNavController2 = Navigation.findNavController(findNavController);
        C14342f0.m8192h(findNavController2, "Navigation.findNavController(this)");
        return findNavController2;
    }
}
