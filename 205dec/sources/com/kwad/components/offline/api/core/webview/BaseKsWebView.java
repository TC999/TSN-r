package com.kwad.components.offline.api.core.webview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.h;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class BaseKsWebView extends FrameLayout {
    private boolean enableScroll;
    public DeepLinkListener mDeeplinkListener;
    protected String mUniqueId;
    private h mViewRCHelper;
    public WebLoadListener mWebLoadListener;
    protected WebViewStateListener mWebViewStateListener;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface DeepLinkListener {
        void onFailed();

        void onSuccess();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface WebLoadListener {
        void onDownloadStart(String str, String str2, String str3, String str4, long j4);

        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i4, String str, String str2);

        boolean shouldOverrideUrlLoading(WebView webView, String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface WebViewStateListener {
        void onFocusChanged(boolean z3, int i4, Rect rect);

        void onScrollChanged(int i4, int i5, int i6, int i7);

        void onSizeChanged(int i4, int i5, int i6, int i7);

        void onVisibilityChanged(View view, int i4);

        void onWindowFocusChanged(boolean z3);
    }

    public BaseKsWebView(@NonNull Context context) {
        super(context);
        this.enableScroll = true;
        init(context, null);
    }

    private float[] getRadius(float f4, float f5, float f6, float f7) {
        return new float[]{f4, f4, f5, f5, f6, f6, f7, f7};
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    public abstract void addJavascriptInterface(Object obj, String str);

    public abstract void callJs(String str);

    public abstract void callJs(String str, String str2);

    public abstract boolean canGoBack();

    public abstract boolean canGoForward();

    public abstract void destroy();

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public String getUniqueId() {
        if (this.mUniqueId == null) {
            this.mUniqueId = UUID.randomUUID().toString();
        }
        return this.mUniqueId;
    }

    public abstract void goBack();

    public abstract void goForward();

    public abstract void loadUrl(String str);

    @Override // android.view.View
    protected void onFocusChanged(boolean z3, int i4, Rect rect) {
        super.onFocusChanged(z3, i4, rect);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onFocusChanged(z3, i4, rect);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onScrollChanged(i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.mViewRCHelper.onSizeChanged(i4, i5);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onSizeChanged(i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onVisibilityChanged(view, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        WebViewStateListener webViewStateListener = this.mWebViewStateListener;
        if (webViewStateListener != null) {
            webViewStateListener.onWindowFocusChanged(z3);
        }
    }

    @Override // android.view.View
    public abstract void scrollBy(int i4, int i5);

    @Override // android.view.View
    public abstract void scrollTo(int i4, int i5);

    public abstract void setAcceptThirdPartyCookies(boolean z3);

    public abstract void setAdCacheId(int i4, String str);

    public abstract void setAdTemplateString(String str);

    public abstract void setAllowContentAccess(boolean z3);

    public abstract void setAllowFileAccess(boolean z3);

    public abstract void setAllowFileAccessFromFileURLs(boolean z3);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z3);

    public abstract void setCacheMode(int i4);

    public abstract void setContextUniqId(int i4);

    public abstract void setDebugEnabled(boolean z3);

    public abstract void setDeeplinkEnabled(boolean z3);

    public void setDeeplinkListener(DeepLinkListener deepLinkListener) {
        this.mDeeplinkListener = deepLinkListener;
    }

    public abstract void setEnableScroll(boolean z3);

    public abstract void setEnableWebCache(boolean z3);

    public abstract void setInnerDownloadEnabled(boolean z3);

    public abstract void setJavaScriptEnabled(boolean z3);

    public abstract void setMixedContentMode(int i4);

    public void setRadius(float f4, float f5, float f6, float f7) {
        this.mViewRCHelper.setRadius(getRadius(f4, f5, f6, f7));
        postInvalidate();
    }

    public abstract void setSavePassword(boolean z3);

    public abstract void setTextZoom(int i4);

    public void setWebLoadListener(WebLoadListener webLoadListener) {
        this.mWebLoadListener = webLoadListener;
    }

    public void setWebViewStateListener(WebViewStateListener webViewStateListener) {
        this.mWebViewStateListener = webViewStateListener;
    }

    public BaseKsWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enableScroll = true;
        init(context, attributeSet);
    }

    public BaseKsWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.enableScroll = true;
        init(context, attributeSet);
    }
}
