package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.c.w;
import com.bytedance.sdk.openadsdk.core.widget.c.xv;
import com.bytedance.sdk.openadsdk.core.xk;
import com.bytedance.sdk.openadsdk.core.ys.sr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PageWebView extends FrameLayout implements sr {

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<WeakReference<DownloadListener>> f35061c = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private g f35062f;
    private me sr;
    private xk ux;

    /* renamed from: w  reason: collision with root package name */
    private SSWebView f35063w;
    private Context xv;

    public PageWebView(@NonNull Context context) {
        super(context);
        this.xv = context;
        SSWebView sSWebView = new SSWebView(context);
        this.f35063w = sSWebView;
        addView(sSWebView);
    }

    public static void c(JSONObject jSONObject, DownloadListener downloadListener) {
        if (downloadListener == null || jSONObject == null) {
            return;
        }
        f35061c.put(jSONObject.hashCode(), new WeakReference<>(downloadListener));
    }

    @Override // com.bytedance.sdk.openadsdk.core.ys.sr
    public void c(boolean z3, JSONArray jSONArray) {
    }

    public void setMeta(me meVar) {
        this.sr = meVar;
    }

    public void setUGenContext(g gVar) {
        this.f35062f = gVar;
    }

    public void w(JSONObject jSONObject) {
        WeakReference<DownloadListener> weakReference;
        w.c(this.xv).c(false).w(false).c(this.f35063w.getWebView());
        SSWebView sSWebView = this.f35063w;
        if (sSWebView != null) {
            sSWebView.setUserAgentString(fz.c(sSWebView.getWebView(), eq.f33190w, me.f(this.sr)));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f35063w.setMixedContentMode(0);
        }
        if (jSONObject == null || (weakReference = f35061c.get(jSONObject.hashCode())) == null || weakReference.get() == null) {
            return;
        }
        this.f35063w.setDownloadListener(weakReference.get());
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            f35061c.remove(jSONObject.hashCode());
        }
    }

    public void c() {
        Map<String, Object> e4;
        SSWebView sSWebView = this.f35063w;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.sr);
        this.ux = new xk(this.xv);
        g gVar = this.f35062f;
        if (gVar != null && (e4 = gVar.e()) != null && e4.containsKey("key_reward_page")) {
            Object obj = e4.get("key_reward_page");
            if (obj instanceof Map) {
                this.ux.c((Map) obj);
            }
        }
        this.ux.w(this.f35063w).c(this.sr).xv(arrayList).w(this.sr.jr()).xv(this.sr.cf()).xv(7).sr(wv.t(this.sr)).c(this.f35063w).c(true).w(k.c(this.sr)).c((sr) this);
        this.f35063w.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.xv, this.ux, this.sr.jr(), new com.bytedance.sdk.openadsdk.core.a.sr(this.sr, this.f35063w.getWebView()), null));
        this.f35063w.setWebChromeClient(new xv(this.ux));
    }

    public void c(String str) {
        SSWebView sSWebView = this.f35063w;
        if (sSWebView != null) {
            sSWebView.c(str);
        }
    }
}
