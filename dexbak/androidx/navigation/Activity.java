package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m12616d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroid/app/Activity;", "viewId", "", "navigation-runtime-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.navigation.ActivityKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Activity {
    @NotNull
    public static final NavController findNavController(@NotNull android.app.Activity findNavController, @IdRes int i) {
        C14342f0.m8183q(findNavController, "$this$findNavController");
        NavController findNavController2 = Navigation.findNavController(findNavController, i);
        C14342f0.m8192h(findNavController2, "Navigation.findNavController(this, viewId)");
        return findNavController2;
    }
}
