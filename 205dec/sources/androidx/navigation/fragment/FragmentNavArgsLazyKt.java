package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavArgsLazy;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FragmentNavArgsLazy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0087\b\u00a8\u0006\u0005"}, d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroidx/fragment/app/Fragment;", "navigation-fragment-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class FragmentNavArgsLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull final Fragment navArgs) {
        f0.q(navArgs, "$this$navArgs");
        f0.y(4, "Args");
        return new NavArgsLazy<>(n0.d(NavArgs.class), new a<Bundle>() { // from class: androidx.navigation.fragment.FragmentNavArgsLazyKt$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d2.a
            @NotNull
            public final Bundle invoke() {
                Bundle arguments = Fragment.this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + Fragment.this + " has null arguments");
            }
        });
    }
}
