package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class NavAction {
    private Bundle mDefaultArguments;
    @IdRes
    private final int mDestinationId;
    private NavOptions mNavOptions;

    public NavAction(@IdRes int i4) {
        this(i4, null);
    }

    @Nullable
    public Bundle getDefaultArguments() {
        return this.mDefaultArguments;
    }

    public int getDestinationId() {
        return this.mDestinationId;
    }

    @Nullable
    public NavOptions getNavOptions() {
        return this.mNavOptions;
    }

    public void setDefaultArguments(@Nullable Bundle bundle) {
        this.mDefaultArguments = bundle;
    }

    public void setNavOptions(@Nullable NavOptions navOptions) {
        this.mNavOptions = navOptions;
    }

    public NavAction(@IdRes int i4, @Nullable NavOptions navOptions) {
        this(i4, navOptions, null);
    }

    public NavAction(@IdRes int i4, @Nullable NavOptions navOptions, @Nullable Bundle bundle) {
        this.mDestinationId = i4;
        this.mNavOptions = navOptions;
        this.mDefaultArguments = bundle;
    }
}
