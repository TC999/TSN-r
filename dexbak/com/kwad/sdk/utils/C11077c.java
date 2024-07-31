package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;

/* renamed from: com.kwad.sdk.utils.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11077c {
    /* renamed from: bF */
    public static boolean m23839bF(@NonNull Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
                if (!Environment.isExternalStorageLegacy()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
