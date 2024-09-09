package com.kwad.components.ad.splashscreen.presenter.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.webview.tachikoma.i;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class b extends i {
    public b(Context context, int i4, int i5) {
        super(context, i4, i5);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void f(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dt(tn()))) {
            return;
        }
        com.kwad.components.ad.splashscreen.monitor.b.kW().c(tn(), str2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.i
    public final void g(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dt(tn()))) {
            return;
        }
        com.kwad.components.ad.splashscreen.monitor.b.kW().d(tn(), str2);
    }
}
