package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.C2671cq;
import com.baidu.mobads.sdk.internal.C2674cs;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CpuAdView extends RelativeLayout {
    private C2674cs mAdProd;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
            WebView webView = (WebView) this.mAdProd.mo50557w();
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
            WebView webView = (WebView) this.mAdProd.mo50557w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void onDestroy() {
        View mo50557w = this.mAdProd.mo50557w();
        if (mo50557w instanceof WebView) {
            ((WebView) mo50557w).destroy();
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i == 4 && canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    public void onPause() {
        View mo50557w = this.mAdProd.mo50557w();
        if (mo50557w instanceof WebView) {
            ((WebView) mo50557w).onPause();
        }
    }

    public void onResume() {
        View mo50557w = this.mAdProd.mo50557w();
        if (mo50557w instanceof WebView) {
            ((WebView) mo50557w).onResume();
        }
    }

    public void requestData() {
        C2674cs c2674cs = this.mAdProd;
        if (c2674cs != null) {
            c2674cs.mo50356a();
        }
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        C2671cq c2671cq = new C2671cq(context);
        this.mAdProd = new C2674cs(context, c2671cq, str, i, cPUWebAdRequestParam);
        addView(c2671cq, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        C2671cq c2671cq = new C2671cq(context);
        C2674cs c2674cs = new C2674cs(context, c2671cq, str, i, cPUWebAdRequestParam);
        this.mAdProd = c2674cs;
        c2674cs.m50585a(cpuAdViewInternalStatusListener);
        addView(c2671cq, new ViewGroup.LayoutParams(-1, -1));
    }
}
