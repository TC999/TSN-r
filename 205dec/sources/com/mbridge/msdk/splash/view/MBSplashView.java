package com.mbridge.msdk.splash.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.h;
import com.mbridge.msdk.splash.js.b;
import com.mbridge.msdk.splash.js.c;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MBSplashView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static String f40812a = "MBSplashView";

    /* renamed from: b  reason: collision with root package name */
    private int f40813b;

    /* renamed from: c  reason: collision with root package name */
    private MBSplashWebview f40814c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f40815d;

    /* renamed from: e  reason: collision with root package name */
    private View f40816e;

    /* renamed from: f  reason: collision with root package name */
    private View f40817f;

    /* renamed from: g  reason: collision with root package name */
    private int f40818g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f40819h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f40820i;

    /* renamed from: j  reason: collision with root package name */
    private ViewGroup f40821j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f40822k;

    /* renamed from: l  reason: collision with root package name */
    private View f40823l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f40824m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f40825n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout.LayoutParams f40826o;

    /* renamed from: p  reason: collision with root package name */
    private b f40827p;

    /* renamed from: q  reason: collision with root package name */
    private DyCountDownListener f40828q;

    public MBSplashView(Context context) {
        this(context, null);
    }

    private void b() {
        setBackgroundColor(0);
        this.f40813b = getResources().getConfiguration().orientation;
    }

    private void c() {
        MBSplashWebview mBSplashWebview = this.f40814c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(this.f40827p);
            this.f40814c.post(new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        x.a(MBSplashView.f40812a, "webviewshow");
                        int[] iArr = new int[2];
                        MBSplashView.this.f40814c.getLocationOnScreen(iArr);
                        String str = MBSplashView.f40812a;
                        x.d(str, "coordinate:" + iArr[0] + "--" + iArr[1]);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("startX", ac.a(com.mbridge.msdk.foundation.controller.a.f().j(), (float) iArr[0]));
                        jSONObject.put("startY", ac.a(com.mbridge.msdk.foundation.controller.a.f().j(), (float) iArr[1]));
                        String jSONObject2 = jSONObject.toString();
                        int[] iArr2 = new int[2];
                        MBSplashView.this.f40814c.getLocationInWindow(iArr2);
                        MBSplashView.transInfoForMraid(MBSplashView.this.f40814c, iArr2[0], iArr2[1], MBSplashView.this.f40814c.getWidth(), MBSplashView.this.f40814c.getHeight());
                        h.a().a((WebView) MBSplashView.this.f40814c, "webviewshow", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }
    }

    public static void transInfoForMraid(WebView webView, int i4, int i5, int i6, int i7) {
        x.d(f40812a, "transInfoForMraid");
        try {
            int i8 = com.mbridge.msdk.foundation.controller.a.f().j().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i8 == 2 ? "landscape" : i8 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            float x3 = t.x(com.mbridge.msdk.foundation.controller.a.f().j());
            float y3 = t.y(com.mbridge.msdk.foundation.controller.a.f().j());
            HashMap z3 = t.z(com.mbridge.msdk.foundation.controller.a.f().j());
            int intValue = ((Integer) z3.get("width")).intValue();
            int intValue2 = ((Integer) z3.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "Interstitial");
            hashMap.put("state", "default");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f4 = i4;
            float f5 = i5;
            float f6 = i6;
            float f7 = i7;
            com.mbridge.msdk.mbjscommon.mraid.a.a().a(webView, f4, f5, f6, f7);
            com.mbridge.msdk.mbjscommon.mraid.a.a().b(webView, f4, f5, f6, f7);
            com.mbridge.msdk.mbjscommon.mraid.a.a().b(webView, x3, y3);
            com.mbridge.msdk.mbjscommon.mraid.a.a().c(webView, intValue, intValue2);
            com.mbridge.msdk.mbjscommon.mraid.a.a().a(webView, hashMap);
            com.mbridge.msdk.mbjscommon.mraid.a.a().a(webView);
        } catch (Throwable th) {
            x.b(f40812a, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i4) {
        View view = this.f40816e;
        if (view != null) {
            if (i4 == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f40822k = false;
        this.f40820i = false;
        this.f40819h = false;
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.f40821j;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.f40814c;
        if (mBSplashWebview == null || mBSplashWebview.isDestoryed()) {
            return;
        }
        this.f40814c.release();
        c.a(this.f40814c, "onSystemDestory", "");
    }

    public View getCloseView() {
        return this.f40816e;
    }

    public ViewGroup getDevContainer() {
        return this.f40821j;
    }

    public View getIconVg() {
        return this.f40817f;
    }

    public b getSplashJSBridgeImpl() {
        return this.f40827p;
    }

    public MBSplashWebview getSplashWebview() {
        return this.f40814c;
    }

    public boolean isAttach() {
        return this.f40825n;
    }

    public boolean isDynamicView() {
        return this.f40824m;
    }

    public boolean isH5Ready() {
        return this.f40819h;
    }

    public boolean isImageReady() {
        return this.f40822k;
    }

    public boolean isVideoReady() {
        return this.f40820i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f40825n = true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void onPause() {
        View view = this.f40823l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.f40823l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.f40820i = false;
        this.f40819h = false;
    }

    public void setCloseView(View view) {
        this.f40816e = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.f40821j = viewGroup;
    }

    public void setDyCountDownListener(DyCountDownListener dyCountDownListener) {
        this.f40828q = dyCountDownListener;
    }

    public void setDynamicView(boolean z3) {
        this.f40824m = z3;
    }

    public void setH5Ready(boolean z3) {
        this.f40819h = z3;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f40817f = view;
        this.f40826o = layoutParams;
    }

    public void setImageReady(boolean z3) {
        this.f40822k = z3;
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7) {
        View view = this.f40823l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setNotchPadding(i4, i5, i6, i7);
    }

    public void setSplashJSBridgeImpl(b bVar) {
        this.f40827p = bVar;
        MBSplashWebview mBSplashWebview = this.f40814c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(bVar);
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.f40823l = view;
        }
    }

    public void setSplashWebview(MBSplashWebview mBSplashWebview) {
        this.f40814c = mBSplashWebview;
        b bVar = this.f40827p;
        if (bVar != null) {
            mBSplashWebview.setObject(bVar);
        }
    }

    public void setVideoReady(boolean z3) {
        this.f40820i = z3;
    }

    public void show() {
        View view;
        View view2;
        View view3;
        ViewGroup viewGroup;
        if (this.f40827p != null && (viewGroup = this.f40821j) != null && (viewGroup.getContext() instanceof Activity)) {
            this.f40827p.a(this.f40821j.getContext());
        }
        if (this.f40817f == null) {
            if (this.f40824m && (view3 = this.f40823l) != null) {
                if (view3.getParent() != null) {
                    al.a(this.f40823l);
                }
                addView(this.f40823l, new ViewGroup.LayoutParams(-1, -1));
            } else {
                MBSplashWebview mBSplashWebview = this.f40814c;
                if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                    addView(this.f40814c, new ViewGroup.LayoutParams(-1, -1));
                }
                c();
            }
        } else {
            if (this.f40815d == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.f40815d = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.f40813b == 2) {
                this.f40818g = ac.h(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f40815d.getId());
                if (this.f40824m && (view2 = this.f40823l) != null) {
                    if (view2.getParent() != null) {
                        al.a(this.f40823l);
                    }
                    addView(this.f40823l, layoutParams);
                } else {
                    MBSplashWebview mBSplashWebview2 = this.f40814c;
                    if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                        addView(this.f40814c, layoutParams);
                    }
                    c();
                }
                ViewGroup viewGroup2 = this.f40815d;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i4 = this.f40826o.width;
                    int i5 = this.f40818g;
                    if (i4 > i5 / 4) {
                        i4 = i5 / 4;
                    }
                    this.f40815d.addView(this.f40817f, i4, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f40815d, layoutParams2);
                }
            } else {
                this.f40818g = ac.g(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f40815d.getId());
                if (this.f40824m && (view = this.f40823l) != null) {
                    if (view.getParent() != null) {
                        al.a(this.f40823l);
                    }
                    addView(this.f40823l, layoutParams3);
                } else {
                    MBSplashWebview mBSplashWebview3 = this.f40814c;
                    if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                        addView(this.f40814c, layoutParams3);
                    }
                    c();
                }
                ViewGroup viewGroup3 = this.f40815d;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i6 = this.f40826o.height;
                    int i7 = this.f40818g;
                    if (i6 > i7 / 4) {
                        i6 = i7 / 4;
                    }
                    this.f40815d.addView(this.f40817f, -1, i6);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i6);
                    layoutParams4.addRule(12);
                    addView(this.f40815d, layoutParams4);
                }
            }
        }
        View view4 = this.f40816e;
        if (view4 != null) {
            if (view4.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ac.b(getContext(), 100.0f), ac.b(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = ac.b(getContext(), 10.0f);
                layoutParams5.topMargin = ac.b(getContext(), 10.0f);
                addView(this.f40816e, layoutParams5);
            } else {
                bringChildToFront(this.f40816e);
            }
        }
        clearResState();
    }

    public void updateCountdown(int i4) {
        DyCountDownListener dyCountDownListener;
        View view;
        if (this.f40814c != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i4);
                h.a().a((WebView) this.f40814c, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (this.f40824m && (view = this.f40823l) != null && (view instanceof MBSplashNativeView)) {
                ((MBSplashNativeView) view).updateCountDown(i4);
            }
            if (!this.f40824m || (dyCountDownListener = this.f40828q) == null) {
                return;
            }
            dyCountDownListener.getCountDownValue(i4);
        }
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        b();
    }
}
