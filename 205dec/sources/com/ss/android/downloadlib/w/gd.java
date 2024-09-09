package com.ss.android.downloadlib.w;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd {
    public static boolean c(@NonNull com.ss.android.downloadad.api.c.c cVar) {
        return com.ss.android.socialbase.appdownloader.f.ux.ux() && Build.VERSION.SDK_INT < 29 && k.a() != null && k.a().c() && com.ss.android.downloadlib.r.ux.c(cVar).w("invoke_app_form_background_switch") == 1 && cVar.ia();
    }
}
