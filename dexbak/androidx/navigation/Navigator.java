package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class Navigator<D extends NavDestination> {

    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface Extras {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface Name {
        String value();
    }

    @NonNull
    public abstract D createDestination();

    @Nullable
    public abstract NavDestination navigate(@NonNull D d, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Extras extras);

    public void onRestoreState(@NonNull Bundle bundle) {
    }

    @Nullable
    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();
}
