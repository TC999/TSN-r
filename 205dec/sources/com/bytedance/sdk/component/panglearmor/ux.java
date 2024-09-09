package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f30024c;

    public static void c(Context context) {
        if (f30024c || context == null) {
            return;
        }
        w(context);
        xv(context);
        sr(context);
        ux(context);
        f30024c = true;
    }

    private static void sr(Context context) {
        int i4;
        Configuration configuration = context.getResources().getConfiguration();
        f.c(f.ev, new Object[]{Boolean.valueOf(configuration == null || !((i4 = configuration.touchscreen) == 1 || i4 == 0))});
    }

    private static void ux(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        f.c(f.gd, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }

    private static void w(Context context) {
        boolean z3;
        int i4;
        double d4 = -0.1d;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z3 = registerReceiver.getBooleanExtra("present", false);
                try {
                    double intExtra = registerReceiver.getIntExtra("temperature", -1);
                    Double.isNaN(intExtra);
                    d4 = intExtra / 10.0d;
                    i4 = registerReceiver.getIntExtra("health", 1);
                } catch (Throwable unused) {
                    i4 = 1;
                    f.c(f.f30009f, new Object[]{Boolean.valueOf(z3), Double.valueOf(d4), Integer.valueOf(i4)});
                }
            } else {
                i4 = 1;
                z3 = true;
            }
        } catch (Throwable unused2) {
            z3 = true;
        }
        f.c(f.f30009f, new Object[]{Boolean.valueOf(z3), Double.valueOf(d4), Integer.valueOf(i4)});
    }

    private static void xv(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            int i5 = -1;
            int i6 = -2;
            if (cameraManager != null) {
                try {
                    int i7 = 0;
                    int i8 = 0;
                    for (String str : cameraManager.getCameraIdList()) {
                        int intValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                        if (intValue == 0) {
                            i7++;
                        } else if (intValue == 1) {
                            i8++;
                        }
                    }
                    i5 = i7;
                    i6 = i8;
                } catch (Throwable unused) {
                    i6 = -1;
                }
            } else {
                i5 = -2;
            }
            f.c(f.f30015r, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i5), Integer.valueOf(i6)});
            return;
        }
        f.c(f.f30015r, new Object[]{Integer.valueOf(i4), Integer.valueOf(Camera.getNumberOfCameras())});
    }
}
