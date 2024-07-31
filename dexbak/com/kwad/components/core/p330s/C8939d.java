package com.kwad.components.core.p330s;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11027at;
import com.kwad.sdk.utils.C11124s;

/* renamed from: com.kwad.components.core.s.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8939d {
    /* renamed from: a */
    public static void m29564a(@NonNull Activity activity, int i, boolean z) {
        m29563a(activity, 0, true, true);
    }

    /* renamed from: b */
    private static void m29561b(@NonNull Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = PredefinedCaptureConfigurations.f24405o;
        if (i2 < 21) {
            if (i2 >= 19) {
                window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
                return;
            }
            return;
        }
        if (z && i2 >= 23) {
            i3 = 9472;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (C11027at.m24079Me()) {
                m29562a(activity, true);
            } else if (C11027at.m24078Mf()) {
                C8948k.m29544b(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i3);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    /* renamed from: rc */
    public static boolean m29560rc() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: a */
    public static void m29563a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        if (m29560rc()) {
            m29561b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(16908290).setPadding(0, C10751a.getStatusBarHeight(activity), 0, 0);
        }
    }

    /* renamed from: a */
    private static boolean m29562a(@NonNull Activity activity, boolean z) {
        try {
            int intValue = ((Integer) C11124s.m23702aq("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            C11124s.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
