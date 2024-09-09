package com.kwad.components.core.s;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i4, boolean z3) {
        a(activity, 0, true, true);
    }

    private static void b(@NonNull Activity activity, int i4, boolean z3) {
        Window window = activity.getWindow();
        int i5 = Build.VERSION.SDK_INT;
        int i6 = 1280;
        if (i5 < 21) {
            if (i5 >= 19) {
                window.getDecorView().setSystemUiVisibility(1280);
                return;
            }
            return;
        }
        if (z3 && i5 >= 23) {
            i6 = 9472;
            window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
            window.addFlags(Integer.MIN_VALUE);
            if (at.Me()) {
                a(activity, true);
            } else if (at.Mf()) {
                k.b(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i6);
        window.setStatusBarColor(i4);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean rc() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void a(@NonNull Activity activity, int i4, boolean z3, boolean z4) {
        if (rc()) {
            b(activity, i4, z3);
            if (z4) {
                return;
            }
            activity.findViewById(16908290).setPadding(0, com.kwad.sdk.d.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z3) {
        try {
            int intValue = ((Integer) s.aq("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            s.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
