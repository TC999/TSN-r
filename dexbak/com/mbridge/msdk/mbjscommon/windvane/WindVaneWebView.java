package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.base.BaseWebView;
import com.mbridge.msdk.mbjscommon.base.BaseWebViewClient;
import com.mbridge.msdk.mbjscommon.base.IntentFilter;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WindVaneWebView extends BaseWebView {

    /* renamed from: b */
    protected WindVaneWebViewChromeClient f31542b;

    /* renamed from: c */
    protected IJsBridge f31543c;

    /* renamed from: d */
    protected WindVaneApiManager f31544d;

    /* renamed from: e */
    private Object f31545e;

    /* renamed from: f */
    private Object f31546f;

    /* renamed from: g */
    private String f31547g;

    /* renamed from: h */
    private IWebViewListener f31548h;

    /* renamed from: i */
    private String f31549i;

    /* renamed from: j */
    private boolean f31550j;

    /* renamed from: k */
    private float f31551k;

    /* renamed from: l */
    private float f31552l;

    public WindVaneWebView(Context context) {
        super(context);
        this.f31550j = false;
        this.f31551k = 0.0f;
        this.f31552l = 0.0f;
    }

    public void clearWebView() {
        if (this.f31550j) {
            return;
        }
        loadUrl("about:blank");
    }

    public String getCampaignId() {
        return this.f31547g;
    }

    public IJsBridge getJsBridge() {
        return this.f31543c;
    }

    public Object getJsObject(String str) {
        WindVaneApiManager windVaneApiManager = this.f31544d;
        if (windVaneApiManager == null) {
            return null;
        }
        return windVaneApiManager.m21389a(str);
    }

    public Object getMraidObject() {
        return this.f31546f;
    }

    public Object getObject() {
        return this.f31545e;
    }

    public String getRid() {
        return this.f31549i;
    }

    public IWebViewListener getWebViewListener() {
        return this.f31548h;
    }

    public boolean isDestoryed() {
        return this.f31550j;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        BaseWebViewClient baseWebViewClient = this.mWebViewClient;
        if (baseWebViewClient != null && (baseWebViewClient.m21525b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f31551k = motionEvent.getRawX();
                    this.f31552l = motionEvent.getRawY();
                } else {
                    int m22001b = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 15.0f);
                    float rawX = motionEvent.getRawX() - this.f31551k;
                    float y = motionEvent.getY() - this.f31552l;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= m22001b) && ((rawX <= 0.0f || rawX <= m22001b) && ((y >= 0.0f || (-1.0f) * y <= m22001b) && (y <= 0.0f || y <= m22001b)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        WindVaneApiManager windVaneApiManager = this.f31544d;
        if (windVaneApiManager == null) {
            return;
        }
        windVaneApiManager.m21391a(cls);
    }

    public void release() {
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener(null);
            this.f31545e = null;
            int m21968m = SameTool.m21968m(getContext());
            if (m21968m == 0) {
                this.f31550j = true;
                destroy();
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindVaneWebView.this.f31550j = true;
                        WindVaneWebView.this.destroy();
                    }
                }, m21968m * 1000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        WindVaneApiManager windVaneApiManager = this.f31544d;
        if (windVaneApiManager != null) {
            windVaneApiManager.m21392a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        WindVaneApiManager windVaneApiManager = this.f31544d;
        if (windVaneApiManager != null) {
            windVaneApiManager.m21390a(obj);
        }
    }

    public void setCampaignId(String str) {
        this.f31547g = str;
    }

    public void setJsBridge(IJsBridge iJsBridge) {
        this.f31543c = iJsBridge;
        iJsBridge.mo21381a(this);
    }

    public void setMraidObject(Object obj) {
        this.f31546f = obj;
    }

    public void setObject(Object obj) {
        this.f31545e = obj;
    }

    public void setRid(String str) {
        this.f31549i = str;
    }

    public void setWebViewChromeClient(WindVaneWebViewChromeClient windVaneWebViewChromeClient) {
        this.f31542b = windVaneWebViewChromeClient;
        setWebChromeClient(windVaneWebViewChromeClient);
    }

    public void setWebViewListener(IWebViewListener iWebViewListener) {
        this.f31548h = iWebViewListener;
        WindVaneWebViewChromeClient windVaneWebViewChromeClient = this.f31542b;
        if (windVaneWebViewChromeClient != null) {
            windVaneWebViewChromeClient.m21372a(iWebViewListener);
        }
        BaseWebViewClient baseWebViewClient = this.mWebViewClient;
        if (baseWebViewClient != null) {
            baseWebViewClient.m21526a(iWebViewListener);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.mbjscommon.base.BaseWebView
    /* renamed from: a */
    public final void mo21402a() {
        super.mo21402a();
        getSettings().setSavePassword(false);
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f31542b == null) {
            this.f31542b = new WindVaneWebViewChromeClient(this);
        }
        setWebViewChromeClient(this.f31542b);
        WindVaneWebViewClient windVaneWebViewClient = new WindVaneWebViewClient();
        this.mWebViewClient = windVaneWebViewClient;
        setWebViewClient(windVaneWebViewClient);
        if (this.f31543c == null) {
            IJsBridge windVaneJsBridge = new WindVaneJsBridge(this.f31427a);
            this.f31543c = windVaneJsBridge;
            setJsBridge(windVaneJsBridge);
        }
        this.f31544d = new WindVaneApiManager(this.f31427a, this);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31550j = false;
        this.f31551k = 0.0f;
        this.f31552l = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31550j = false;
        this.f31551k = 0.0f;
        this.f31552l = 0.0f;
    }
}
