package com.mbridge.msdk.splash.view;

import android.content.Context;
import com.iab.omid.library.mmadbridge.adsession.b;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBSplashWebview extends WindVaneWebView {

    /* renamed from: e  reason: collision with root package name */
    private static final String f40830e = MBSplashWebview.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private String f40831f;

    /* renamed from: g  reason: collision with root package name */
    private b f40832g;

    public MBSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            b bVar = this.f40832g;
            if (bVar != null) {
                bVar.d();
                this.f40832g = null;
                x.a("OMSDK", "finish adSession");
            }
        } catch (Exception e4) {
            x.a("OMSDK", e4.getMessage());
        }
    }

    public b getAdSession() {
        return this.f40832g;
    }

    public String getRequestId() {
        return this.f40831f;
    }

    public void setAdSession(b bVar) {
        this.f40832g = bVar;
    }

    public void setRequestId(String str) {
        this.f40831f = str;
    }
}
