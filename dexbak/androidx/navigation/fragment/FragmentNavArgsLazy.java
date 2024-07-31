package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavArgsLazy;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0087\b¨\u0006\u0005"}, m12616d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroidx/fragment/app/Fragment;", "navigation-fragment-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.navigation.fragment.FragmentNavArgsLazyKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class FragmentNavArgsLazy {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull final Fragment navArgs) {
        C14342f0.m8183q(navArgs, "$this$navArgs");
        C14342f0.m8175y(4, "Args");
        return new NavArgsLazy<>(Reflection.m8123d(NavArgs.class), new InterfaceC15269a<Bundle>() { // from class: androidx.navigation.fragment.FragmentNavArgsLazyKt$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p617l1.InterfaceC15269a
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
