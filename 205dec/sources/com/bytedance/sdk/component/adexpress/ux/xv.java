package com.bytedance.sdk.component.adexpress.ux;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<w> f29412c;

    public xv(w wVar) {
        this.f29412c = new WeakReference<>(wVar);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<w> weakReference = this.f29412c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f29412c.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<w> weakReference = this.f29412c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f29412c.get().appInfo();
    }

    public void c(w wVar) {
        this.f29412c = new WeakReference<>(wVar);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<w> weakReference = this.f29412c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f29412c.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<w> weakReference = this.f29412c;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f29412c.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<w> weakReference = this.f29412c;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f29412c.get().skipVideo();
    }
}
