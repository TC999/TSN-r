package androidx.core.p018os;

import android.content.res.Configuration;
import android.os.Build;
import androidx.annotation.NonNull;

/* renamed from: androidx.core.os.ConfigurationCompat */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? LocaleListCompat.wrap(configuration.getLocales()) : LocaleListCompat.create(configuration.locale);
    }
}
