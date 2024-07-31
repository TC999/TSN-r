package com.mbridge.msdk.splash.view;

import android.content.Context;
import com.iab.omid.library.mmadbridge.adsession.AbstractC7075b;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBSplashWebview extends WindVaneWebView {

    /* renamed from: e */
    private static final String f32079e = MBSplashWebview.class.getSimpleName();

    /* renamed from: f */
    private String f32080f;

    /* renamed from: g */
    private AbstractC7075b f32081g;

    public MBSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            AbstractC7075b abstractC7075b = this.f32081g;
            if (abstractC7075b != null) {
                abstractC7075b.mo34804d();
                this.f32081g = null;
                SameLogTool.m21738a("OMSDK", "finish adSession");
            }
        } catch (Exception e) {
            SameLogTool.m21738a("OMSDK", e.getMessage());
        }
    }

    public AbstractC7075b getAdSession() {
        return this.f32081g;
    }

    public String getRequestId() {
        return this.f32080f;
    }

    public void setAdSession(AbstractC7075b abstractC7075b) {
        this.f32081g = abstractC7075b;
    }

    public void setRequestId(String str) {
        this.f32080f = str;
    }
}
