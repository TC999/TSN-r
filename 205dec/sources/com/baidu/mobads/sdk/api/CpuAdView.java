package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.cv;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class CpuAdView extends RelativeLayout {
    private cv mAdProd;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    protected boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        View w3 = this.mAdProd.w();
        if (w3 instanceof WebView) {
            ((WebView) w3).destroy();
        }
    }

    public boolean onKeyBackDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    public void onPause() {
        View w3 = this.mAdProd.w();
        if (w3 instanceof WebView) {
            ((WebView) w3).onPause();
        }
    }

    public void onResume() {
        View w3 = this.mAdProd.w();
        if (w3 instanceof WebView) {
            ((WebView) w3).onResume();
        }
    }

    public void requestData() {
        cv cvVar = this.mAdProd;
        if (cvVar != null) {
            cvVar.a();
        }
    }

    public CpuAdView(Context context, String str, int i4, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        ct ctVar = new ct(context);
        this.mAdProd = new cv(context, ctVar, str, i4, cPUWebAdRequestParam);
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i4, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        ct ctVar = new ct(context);
        cv cvVar = new cv(context, ctVar, str, i4, cPUWebAdRequestParam);
        this.mAdProd = cvVar;
        cvVar.a(cpuAdViewInternalStatusListener);
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }
}
