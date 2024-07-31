package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;

/* renamed from: com.kwad.sdk.utils.ai */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11015ai {
    /* renamed from: LZ */
    public static boolean m24123LZ() {
        return isOrientationPortrait();
    }

    /* renamed from: b */
    public static void m24122b(Context context, boolean z) {
        try {
            Activity m24559dn = C10887l.m24559dn(context);
            if (m24559dn == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    m24559dn.getWindow().getDecorView().setSystemUiVisibility(8);
                } else {
                    m24559dn.getWindow().getDecorView().setSystemUiVisibility(1792);
                }
            } else if (Build.VERSION.SDK_INT < 19) {
                m24559dn.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                m24559dn.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: cl */
    public static boolean m24121cl(Context context) {
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null) {
            Window window = m24559dn.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    /* renamed from: cm */
    public static void m24120cm(Context context) {
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null) {
            m24559dn.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    /* renamed from: cn */
    public static void m24119cn(Context context) {
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null) {
            m24559dn.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    /* renamed from: co */
    public static void m24118co(Context context) {
        Activity m24559dn = C10887l.m24559dn(context);
        if (m24559dn != null) {
            m24559dn.setRequestedOrientation(1);
        }
    }

    public static boolean isOrientationPortrait() {
        return StubApp.getOrigApplicationContext(ServiceProvider.m24363KO().getApplicationContext()).getResources().getConfiguration().orientation == 1;
    }
}
