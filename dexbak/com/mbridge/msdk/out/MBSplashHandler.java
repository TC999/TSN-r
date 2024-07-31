package com.mbridge.msdk.out;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.splash.p505d.SplashProvider;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class MBSplashHandler {
    private static boolean canSkip = true;
    private static int defCountDownS = 5;
    private static int logoSizeH = 0;
    private static int logoSizeW = 0;
    private static int orientation = 1;
    private SplashProvider splashProvider;

    public MBSplashHandler(String str, String str2) {
        this(str, str2, canSkip, defCountDownS);
    }

    public void allowClickSplash(boolean z) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21080d(z);
        }
    }

    public ViewGroup createZoomOutByType(ZoomOutTypeEnum zoomOutTypeEnum) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            return splashProvider.m21099a(zoomOutTypeEnum);
        }
        return null;
    }

    public String getRequestId() {
        SplashProvider splashProvider = this.splashProvider;
        return splashProvider != null ? splashProvider.m21079e() : "";
    }

    public boolean isReady() {
        return isReady("");
    }

    public void loadAndShow(ViewGroup viewGroup) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21088b("", viewGroup);
        }
    }

    public void loadAndShowByToken(String str, ViewGroup viewGroup) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21095a(str, viewGroup);
        }
    }

    public void onDestroy() {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21074j();
        }
    }

    public void onPause() {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21075i();
        }
    }

    public void onResume() {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21076h();
        }
    }

    public void preLoad() {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21089b("");
        }
    }

    public void preLoadByToken(String str) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21097a(str);
        }
    }

    public void setDevCloseView(ViewGroup viewGroup) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21103a(viewGroup);
        }
    }

    public void setLoadTimeOut(long j) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21105a(j);
        }
    }

    public void setLogoView(View view, int i, int i2) {
        if (this.splashProvider != null) {
            this.splashProvider.m21104a(view, new RelativeLayout.LayoutParams(i, i2));
        }
    }

    public void setOrientation(int i) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21107a(i);
        }
    }

    public void setSplashLoadListener(MBSplashLoadListener mBSplashLoadListener) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21101a(mBSplashLoadListener);
        }
    }

    public void setSplashShowListener(MBSplashShowListener mBSplashShowListener) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21100a(mBSplashShowListener);
        }
    }

    public void setSupportZoomOut(boolean z) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21083c(z);
        }
    }

    public void show(ViewGroup viewGroup) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21081d("", viewGroup);
        }
    }

    public void zoomOutAttacked() {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21078f();
        }
    }

    public void zoomOutPlayFinish() {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21077g();
        }
    }

    public MBSplashHandler(Activity activity, String str, String str2) {
        this(activity, str, str2, canSkip, defCountDownS);
    }

    public boolean isReady(String str) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            return splashProvider.m21085c(str);
        }
        return false;
    }

    public MBSplashHandler(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, orientation, logoSizeH, logoSizeW);
    }

    public void show(ViewGroup viewGroup, String str) {
        SplashProvider splashProvider = this.splashProvider;
        if (splashProvider != null) {
            splashProvider.m21084c(str, viewGroup);
        }
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z, int i) {
        this(activity, str, str2, z, i, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(String str, String str2, boolean z, int i, int i2, int i3, int i4) {
        String m21981f = SameTool.m21981f(str2);
        if (!TextUtils.isEmpty(m21981f)) {
            SameTool.m22008a(str2, m21981f);
        }
        SplashProvider splashProvider = new SplashProvider(null, str, str2);
        this.splashProvider = splashProvider;
        splashProvider.m21087b(z);
        this.splashProvider.m21092b(i);
        this.splashProvider.m21107a(i2);
        this.splashProvider.m21106a(i3, i4);
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z, int i, int i2, int i3, int i4) {
        String m21981f = SameTool.m21981f(str2);
        if (!TextUtils.isEmpty(m21981f)) {
            SameTool.m22008a(str2, m21981f);
        }
        SplashProvider splashProvider = new SplashProvider(activity, str, str2);
        this.splashProvider = splashProvider;
        splashProvider.m21087b(z);
        this.splashProvider.m21092b(i);
        this.splashProvider.m21107a(i2);
        this.splashProvider.m21106a(i3, i4);
    }
}
