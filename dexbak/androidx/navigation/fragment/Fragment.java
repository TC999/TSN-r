package androidx.navigation.fragment;

import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m12616d2 = {"findNavController", "Landroidx/navigation/NavController;", "Landroidx/fragment/app/Fragment;", "navigation-fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.navigation.fragment.FragmentKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Fragment {
    @NotNull
    public static final NavController findNavController(@NotNull androidx.fragment.app.Fragment findNavController) {
        C14342f0.m8183q(findNavController, "$this$findNavController");
        NavController findNavController2 = NavHostFragment.findNavController(findNavController);
        C14342f0.m8192h(findNavController2, "NavHostFragment.findNavController(this)");
        return findNavController2;
    }
}
