package com.bytedance.sdk.component.widget;

import android.graphics.Canvas;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PangleWebView extends WebView {

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<String> f30455c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private boolean f30456w;
    private boolean xv;

    private void c() {
        if (this.f30456w) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        setOnClickListener(null);
        setOnTouchListener(null);
        Iterator<String> it = this.f30455c.iterator();
        while (it.hasNext()) {
            String next = it.next();
            a.w("TTAD.PangleWebView", "destroy: auto remove js obj " + next);
            super.removeJavascriptInterface(next);
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        a.w("TTAD.PangleWebView", "addJavascriptInterface: " + str + ", " + this);
        if (!this.f30456w && !this.sr) {
            super.addJavascriptInterface(obj, str);
            this.f30455c.add(str);
            return;
        }
        a.f("TTAD.PangleWebView", "addJavascriptInterface: has destroyed or has recycler");
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z3) {
        if (!this.f30456w && !this.sr) {
            super.clearCache(z3);
        } else {
            a.f("TTAD.PangleWebView", "clearCache: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        a.w("TTAD.PangleWebView", "destroy() called, " + this);
        if (this.f30456w) {
            return;
        }
        this.f30456w = true;
        c();
        super.destroy();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.f30456w && !this.sr) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            a.f("TTAD.PangleWebView", "evaluateJavascript: has destroyed or recycler, " + str);
            valueCallback.onReceiveValue("");
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (!this.f30456w && !this.sr) {
            super.goBack();
        } else {
            a.f("TTAD.PangleWebView", "goBack: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i4) {
        if (!this.f30456w && !this.sr) {
            super.goBackOrForward(i4);
        } else {
            a.f("TTAD.PangleWebView", "goBackOrForward: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (!this.f30456w && !this.sr) {
            super.goForward();
        } else {
            a.f("TTAD.PangleWebView", "goForward: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.f30456w && !this.sr) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            a.f("TTAD.PangleWebView", "loadDataWithBaseURL: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (!this.f30456w && !this.sr) {
            try {
                super.loadUrl(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e4) {
                a.xv("TTAD.PangleWebView", "loadUrl: ", e4);
                return;
            }
        }
        a.f("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a.w("TTAD.PangleWebView", "onAttachedToWindow: " + this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.w("TTAD.PangleWebView", "onDetachedFromWindow: " + this);
        if (this.xv) {
            destroy();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f30456w || this.sr) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (!this.f30456w && !this.sr) {
            super.onMeasure(i4, i5);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (!this.f30456w && !this.sr) {
            try {
                super.onPause();
                return;
            } catch (Exception e4) {
                a.xv("TTAD.PangleWebView", "onPause: ", e4);
                return;
            }
        }
        a.f("TTAD.PangleWebView", "onPause: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (!this.f30456w && !this.sr) {
            try {
                super.onResume();
                return;
            } catch (Exception e4) {
                a.xv("TTAD.PangleWebView", "onResume: ", e4);
                return;
            }
        }
        a.f("TTAD.PangleWebView", "onResume: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        a.w("TTAD.PangleWebView", "pauseTimers: ");
        if (this.f30456w || this.sr) {
            return;
        }
        super.pauseTimers();
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (!this.f30456w && !this.sr) {
            super.reload();
        } else {
            a.f("TTAD.PangleWebView", "reload: has destroyed or recycler");
        }
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (!this.f30456w && !this.sr) {
            super.removeJavascriptInterface(str);
            this.f30455c.remove(str);
            return;
        }
        a.w("TTAD.PangleWebView", "removeJavascriptInterface: has destroyed or recycler, name=" + str);
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        a.w("TTAD.PangleWebView", "resumeTimers: ");
        if (this.f30456w || this.sr) {
            return;
        }
        super.resumeTimers();
    }

    public void setDestroyOnDetached(boolean z3) {
        a.w("TTAD.PangleWebView", "setDestroyOnDetached() called with: destroyOnDetached = [" + z3 + "]");
        this.xv = z3;
    }

    public void setRecycler(boolean z3) {
        this.sr = z3;
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (!this.f30456w && !this.sr) {
            try {
                super.stopLoading();
                return;
            } catch (Exception e4) {
                a.xv("TTAD.PangleWebView", "stopLoading: ", e4);
                return;
            }
        }
        a.f("TTAD.PangleWebView", "stopLoading: has destroyed or recycler");
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (!this.f30456w && !this.sr) {
            try {
                super.loadUrl(str, map);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e4) {
                a.xv("TTAD.PangleWebView", "loadUrl: ", e4);
                return;
            }
        }
        a.f("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
    }
}
