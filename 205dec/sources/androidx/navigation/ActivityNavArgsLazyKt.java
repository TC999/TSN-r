package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ActivityNavArgsLazy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0087\b\u00a8\u0006\u0005"}, d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroid/app/Activity;", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ActivityNavArgsLazyKt {
    @MainThread
    @NotNull
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(@NotNull final Activity navArgs) {
        f0.q(navArgs, "$this$navArgs");
        f0.y(4, "Args");
        return new NavArgsLazy<>(n0.d(NavArgs.class), new a<Bundle>() { // from class: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d2.a
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
