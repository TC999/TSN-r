package com.mbridge.msdk.out;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.splash.d.c;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBSplashHandler {
    private static boolean canSkip = true;
    private static int defCountDownS = 5;
    private static int logoSizeH = 0;
    private static int logoSizeW = 0;
    private static int orientation = 1;
    private c splashProvider;

    public MBSplashHandler(String str, String str2) {
        this(str, str2, canSkip, defCountDownS);
    }

    public void allowClickSplash(boolean z3) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d(z3);
        }
    }

    public ViewGroup createZoomOutByType(ZoomOutTypeEnum zoomOutTypeEnum) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.a(zoomOutTypeEnum);
        }
        return null;
    }

    public String getRequestId() {
        c cVar = this.splashProvider;
        return cVar != null ? cVar.e() : "";
    }

    public boolean isReady() {
        return isReady("");
    }

    public void loadAndShow(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("", viewGroup);
        }
    }

    public void loadAndShowByToken(String str, ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str, viewGroup);
        }
    }

    public void onDestroy() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.j();
        }
    }

    public void onPause() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void onResume() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.h();
        }
    }

    public void preLoad() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("");
        }
    }

    public void preLoadByToken(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setDevCloseView(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(viewGroup);
        }
    }

    public void setLoadTimeOut(long j4) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(j4);
        }
    }

    public void setLogoView(View view, int i4, int i5) {
        if (this.splashProvider != null) {
            this.splashProvider.a(view, new RelativeLayout.LayoutParams(i4, i5));
        }
    }

    public void setOrientation(int i4) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(i4);
        }
    }

    public void setSplashLoadListener(MBSplashLoadListener mBSplashLoadListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashLoadListener);
        }
    }

    public void setSplashShowListener(MBSplashShowListener mBSplashShowListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashShowListener);
        }
    }

    public void setSupportZoomOut(boolean z3) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(z3);
        }
    }

    public void show(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d("", viewGroup);
        }
    }

    public void zoomOutAttacked() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void zoomOutPlayFinish() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.g();
        }
    }

    public MBSplashHandler(Activity activity, String str, String str2) {
        this(activity, str, str2, canSkip, defCountDownS);
    }

    public boolean isReady(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }

    public MBSplashHandler(String str, String str2, boolean z3, int i4) {
        this(str, str2, z3, i4, orientation, logoSizeH, logoSizeW);
    }

    public void show(ViewGroup viewGroup, String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(str, viewGroup);
        }
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z3, int i4) {
        this(activity, str, str2, z3, i4, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(String str, String str2, boolean z3, int i4, int i5, int i6, int i7) {
        String f4 = ac.f(str2);
        if (!TextUtils.isEmpty(f4)) {
            ac.a(str2, f4);
        }
        c cVar = new c(null, str, str2);
        this.splashProvider = cVar;
        cVar.b(z3);
        this.splashProvider.b(i4);
        this.splashProvider.a(i5);
        this.splashProvider.a(i6, i7);
    }

    public MBSplashHandler(Activity activity, String str, String str2, boolean z3, int i4, int i5, int i6, int i7) {
        String f4 = ac.f(str2);
        if (!TextUtils.isEmpty(f4)) {
            ac.a(str2, f4);
        }
        c cVar = new c(activity, str, str2);
        this.splashProvider = cVar;
        cVar.b(z3);
        this.splashProvider.b(i4);
        this.splashProvider.a(i5);
        this.splashProvider.a(i6, i7);
    }
}
