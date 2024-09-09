package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.mbjscommon.base.BaseWebView;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class WindVaneWebView extends BaseWebView {

    /* renamed from: b  reason: collision with root package name */
    protected l f40314b;

    /* renamed from: c  reason: collision with root package name */
    protected b f40315c;

    /* renamed from: d  reason: collision with root package name */
    protected g f40316d;

    /* renamed from: e  reason: collision with root package name */
    private Object f40317e;

    /* renamed from: f  reason: collision with root package name */
    private Object f40318f;

    /* renamed from: g  reason: collision with root package name */
    private String f40319g;

    /* renamed from: h  reason: collision with root package name */
    private d f40320h;

    /* renamed from: i  reason: collision with root package name */
    private String f40321i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f40322j;

    /* renamed from: k  reason: collision with root package name */
    private float f40323k;

    /* renamed from: l  reason: collision with root package name */
    private float f40324l;

    public WindVaneWebView(Context context) {
        super(context);
        this.f40322j = false;
        this.f40323k = 0.0f;
        this.f40324l = 0.0f;
    }

    public void clearWebView() {
        if (this.f40322j) {
            return;
        }
        loadUrl("about:blank");
    }

    public String getCampaignId() {
        return this.f40319g;
    }

    public b getJsBridge() {
        return this.f40315c;
    }

    public Object getJsObject(String str) {
        g gVar = this.f40316d;
        if (gVar == null) {
            return null;
        }
        return gVar.a(str);
    }

    public Object getMraidObject() {
        return this.f40318f;
    }

    public Object getObject() {
        return this.f40317e;
    }

    public String getRid() {
        return this.f40321i;
    }

    public d getWebViewListener() {
        return this.f40320h;
    }

    public boolean isDestoryed() {
        return this.f40322j;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.mbridge.msdk.mbjscommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof com.mbridge.msdk.mbjscommon.base.c)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f40323k = motionEvent.getRawX();
                    this.f40324l = motionEvent.getRawY();
                } else {
                    int b4 = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 15.0f);
                    float rawX = motionEvent.getRawX() - this.f40323k;
                    float y3 = motionEvent.getY() - this.f40324l;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= b4) && ((rawX <= 0.0f || rawX <= b4) && ((y3 >= 0.0f || (-1.0f) * y3 <= b4) && (y3 <= 0.0f || y3 <= b4)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        g gVar = this.f40316d;
        if (gVar == null) {
            return;
        }
        gVar.a(cls);
    }

    public void release() {
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener(null);
            this.f40317e = null;
            int m4 = ac.m(getContext());
            if (m4 == 0) {
                this.f40322j = true;
                destroy();
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindVaneWebView.this.f40322j = true;
                        WindVaneWebView.this.destroy();
                    }
                }, m4 * 1000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        g gVar = this.f40316d;
        if (gVar != null) {
            gVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        g gVar = this.f40316d;
        if (gVar != null) {
            gVar.a(obj);
        }
    }

    public void setCampaignId(String str) {
        this.f40319g = str;
    }

    public void setJsBridge(b bVar) {
        this.f40315c = bVar;
        bVar.a(this);
    }

    public void setMraidObject(Object obj) {
        this.f40318f = obj;
    }

    public void setObject(Object obj) {
        this.f40317e = obj;
    }

    public void setRid(String str) {
        this.f40321i = str;
    }

    public void setWebViewChromeClient(l lVar) {
        this.f40314b = lVar;
        setWebChromeClient(lVar);
    }

    public void setWebViewListener(d dVar) {
        this.f40320h = dVar;
        l lVar = this.f40314b;
        if (lVar != null) {
            lVar.a(dVar);
        }
        com.mbridge.msdk.mbjscommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.mbjscommon.base.BaseWebView
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f40314b == null) {
            this.f40314b = new l(this);
        }
        setWebViewChromeClient(this.f40314b);
        m mVar = new m();
        this.mWebViewClient = mVar;
        setWebViewClient(mVar);
        if (this.f40315c == null) {
            b iVar = new i(this.f40199a);
            this.f40315c = iVar;
            setJsBridge(iVar);
        }
        this.f40316d = new g(this.f40199a, this);
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40322j = false;
        this.f40323k = 0.0f;
        this.f40324l = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f40322j = false;
        this.f40323k = 0.0f;
        this.f40324l = 0.0f;
    }
}
