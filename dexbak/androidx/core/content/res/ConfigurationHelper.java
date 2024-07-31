package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.NonNull;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(@NonNull Resources resources) {
        return resources.getConfiguration().densityDpi;
    }
}
