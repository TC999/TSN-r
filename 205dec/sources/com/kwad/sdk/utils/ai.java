package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ai {
    public static boolean LZ() {
        return isOrientationPortrait();
    }

    public static void b(Context context, boolean z3) {
        try {
            Activity dn = com.kwad.sdk.n.l.dn(context);
            if (dn == null) {
                return;
            }
            if (z3) {
                if (Build.VERSION.SDK_INT < 19) {
                    dn.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    dn.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                dn.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                dn.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean cl(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            Window window = dn.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void cm(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            dn.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cn(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            dn.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void co(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            dn.setRequestedOrientation(1);
        }
    }

    public static boolean isOrientationPortrait() {
        return StubApp.getOrigApplicationContext(ServiceProvider.KO().getApplicationContext()).getResources().getConfiguration().orientation == 1;
    }
}
