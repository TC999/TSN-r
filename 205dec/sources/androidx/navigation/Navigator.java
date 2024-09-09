package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class Navigator<D extends NavDestination> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface Extras {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public @interface Name {
        String value();
    }

    @NonNull
    public abstract D createDestination();

    @Nullable
    public abstract NavDestination navigate(@NonNull D d4, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Extras extras);

    public void onRestoreState(@NonNull Bundle bundle) {
    }

    @Nullable
    public Bundle onSaveState() {
        return null;
    }

    public abstract boolean popBackStack();
}
