package com.p521ss.android.downloadlib.p527a;

import android.os.Build;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12201n;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;

/* renamed from: com.ss.android.downloadlib.a.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12023q {
    /* renamed from: ok */
    public static boolean m19372ok(@NonNull InterfaceC11999ok interfaceC11999ok) {
        return C12317n.m18237n() && Build.VERSION.SDK_INT < 29 && C12128r.m18964j() != null && C12128r.m18964j().mo19656ok() && C12201n.m18737ok(interfaceC11999ok).m17607a("invoke_app_form_background_switch") == 1 && interfaceC11999ok.mo19288x();
    }
}
