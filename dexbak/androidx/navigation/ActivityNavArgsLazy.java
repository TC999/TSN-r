package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0087\b¨\u0006\u0005"}, m12616d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroid/app/Activity;", "navigation-runtime-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.navigation.ActivityNavArgsLazyKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ActivityNavArgsLazy {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull final Activity navArgs) {
        C14342f0.m8183q(navArgs, "$this$navArgs");
        C14342f0.m8175y(4, "Args");
        return new NavArgsLazy<>(Reflection.m8123d(NavArgs.class), new InterfaceC15269a<Bundle>() { // from class: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p617l1.InterfaceC15269a
            @NotNull
            public final Bundle invoke() {
                Intent intent = navArgs.getIntent();
                if (intent != null) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        return extras;
                    }
                    throw new IllegalStateException("Activity " + navArgs + " has null extras in " + intent);
                }
                throw new IllegalStateException("Activity " + navArgs + " has a null Intent");
            }
        });
    }
}
