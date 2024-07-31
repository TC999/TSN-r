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
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.foundation.tools.ViewUtil;
import com.mbridge.msdk.mbjscommon.mraid.CallMraidJS;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.splash.p508js.SplashJSBridgeImpl;
import com.mbridge.msdk.splash.p508js.SplashJsUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MBSplashView extends RelativeLayout {

    /* renamed from: a */
    private static String f32061a = "MBSplashView";

    /* renamed from: b */
    private int f32062b;

    /* renamed from: c */
    private MBSplashWebview f32063c;

    /* renamed from: d */
    private ViewGroup f32064d;

    /* renamed from: e */
    private View f32065e;

    /* renamed from: f */
    private View f32066f;

    /* renamed from: g */
    private int f32067g;

    /* renamed from: h */
    private boolean f32068h;

    /* renamed from: i */
    private boolean f32069i;

    /* renamed from: j */
    private ViewGroup f32070j;

    /* renamed from: k */
    private boolean f32071k;

    /* renamed from: l */
    private View f32072l;

    /* renamed from: m */
    private boolean f32073m;

    /* renamed from: n */
    private boolean f32074n;

    /* renamed from: o */
    private RelativeLayout.LayoutParams f32075o;

    /* renamed from: p */
    private SplashJSBridgeImpl f32076p;

    /* renamed from: q */
    private DyCountDownListener f32077q;

    public MBSplashView(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m20948b() {
        setBackgroundColor(0);
        this.f32062b = getResources().getConfiguration().orientation;
    }

    /* renamed from: c */
    private void m20947c() {
        MBSplashWebview mBSplashWebview = this.f32063c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(this.f32076p);
            this.f32063c.post(new Runnable() { // from class: com.mbridge.msdk.splash.view.MBSplashView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        SameLogTool.m21738a(MBSplashView.f32061a, "webviewshow");
                        int[] iArr = new int[2];
                        MBSplashView.this.f32063c.getLocationOnScreen(iArr);
                        String str = MBSplashView.f32061a;
                        SameLogTool.m21733d(str, "coordinate:" + iArr[0] + "--" + iArr[1]);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("startX", SameTool.m22021a(MBSDKContext.m22865f().m22861j(), (float) iArr[0]));
                        jSONObject.put("startY", SameTool.m22021a(MBSDKContext.m22865f().m22861j(), (float) iArr[1]));
                        String jSONObject2 = jSONObject.toString();
                        int[] iArr2 = new int[2];
                        MBSplashView.this.f32063c.getLocationInWindow(iArr2);
                        MBSplashView.transInfoForMraid(MBSplashView.this.f32063c, iArr2[0], iArr2[1], MBSplashView.this.f32063c.getWidth(), MBSplashView.this.f32063c.getHeight());
                        WindVaneCallJs.m21387a().m21385a((WebView) MBSplashView.this.f32063c, "webviewshow", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void transInfoForMraid(WebView webView, int i, int i2, int i3, int i4) {
        SameLogTool.m21733d(f32061a, "transInfoForMraid");
        try {
            int i5 = MBSDKContext.m22865f().m22861j().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i5 == 2 ? "landscape" : i5 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            float m21765x = SameDiTool.m21765x(MBSDKContext.m22865f().m22861j());
            float m21763y = SameDiTool.m21763y(MBSDKContext.m22865f().m22861j());
            HashMap m21761z = SameDiTool.m21761z(MBSDKContext.m22865f().m22861j());
            int intValue = ((Integer) m21761z.get("width")).intValue();
            int intValue2 = ((Integer) m21761z.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", ExploreConstants.SCENE_INTERSTITIAL);
            hashMap.put("state", "default");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f = i;
            float f2 = i2;
            float f3 = i3;
            float f4 = i4;
            CallMraidJS.m21430a().m21426a(webView, f, f2, f3, f4);
            CallMraidJS.m21430a().m21421b(webView, f, f2, f3, f4);
            CallMraidJS.m21430a().m21422b(webView, m21765x, m21763y);
            CallMraidJS.m21430a().m21419c(webView, intValue, intValue2);
            CallMraidJS.m21430a().m21423a(webView, hashMap);
            CallMraidJS.m21430a().m21429a(webView);
        } catch (Throwable th) {
            SameLogTool.m21735b(f32061a, "transInfoForMraid", th);
        }
    }

    public void changeCloseBtnState(int i) {
        View view = this.f32065e;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void clearResState() {
        this.f32071k = false;
        this.f32069i = false;
        this.f32068h = false;
    }

    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = this.f32070j;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        MBSplashWebview mBSplashWebview = this.f32063c;
        if (mBSplashWebview == null || mBSplashWebview.isDestoryed()) {
            return;
        }
        this.f32063c.release();
        SplashJsUtils.m21011a(this.f32063c, "onSystemDestory", "");
    }

    public View getCloseView() {
        return this.f32065e;
    }

    public ViewGroup getDevContainer() {
        return this.f32070j;
    }

    public View getIconVg() {
        return this.f32066f;
    }

    public SplashJSBridgeImpl getSplashJSBridgeImpl() {
        return this.f32076p;
    }

    public MBSplashWebview getSplashWebview() {
        return this.f32063c;
    }

    public boolean isAttach() {
        return this.f32074n;
    }

    public boolean isDynamicView() {
        return this.f32073m;
    }

    public boolean isH5Ready() {
        return this.f32068h;
    }

    public boolean isImageReady() {
        return this.f32071k;
    }

    public boolean isVideoReady() {
        return this.f32069i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f32074n = true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m20948b();
    }

    public void onPause() {
        View view = this.f32072l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(true);
    }

    public void onResume() {
        View view = this.f32072l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setIsPause(false);
    }

    public void resetLoadState() {
        this.f32069i = false;
        this.f32068h = false;
    }

    public void setCloseView(View view) {
        this.f32065e = view;
        if (view != null) {
            view.setContentDescription("closeButton");
        }
    }

    public void setDevContainer(ViewGroup viewGroup) {
        this.f32070j = viewGroup;
    }

    public void setDyCountDownListener(DyCountDownListener dyCountDownListener) {
        this.f32077q = dyCountDownListener;
    }

    public void setDynamicView(boolean z) {
        this.f32073m = z;
    }

    public void setH5Ready(boolean z) {
        this.f32068h = z;
    }

    public void setIconVg(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f32066f = view;
        this.f32075o = layoutParams;
    }

    public void setImageReady(boolean z) {
        this.f32071k = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        View view = this.f32072l;
        if (view == null || !(view instanceof MBSplashNativeView)) {
            return;
        }
        ((MBSplashNativeView) view).setNotchPadding(i, i2, i3, i4);
    }

    public void setSplashJSBridgeImpl(SplashJSBridgeImpl splashJSBridgeImpl) {
        this.f32076p = splashJSBridgeImpl;
        MBSplashWebview mBSplashWebview = this.f32063c;
        if (mBSplashWebview != null) {
            mBSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setSplashNativeView(View view) {
        if (view != null) {
            this.f32072l = view;
        }
    }

    public void setSplashWebview(MBSplashWebview mBSplashWebview) {
        this.f32063c = mBSplashWebview;
        SplashJSBridgeImpl splashJSBridgeImpl = this.f32076p;
        if (splashJSBridgeImpl != null) {
            mBSplashWebview.setObject(splashJSBridgeImpl);
        }
    }

    public void setVideoReady(boolean z) {
        this.f32069i = z;
    }

    public void show() {
        View view;
        View view2;
        View view3;
        ViewGroup viewGroup;
        if (this.f32076p != null && (viewGroup = this.f32070j) != null && (viewGroup.getContext() instanceof Activity)) {
            this.f32076p.m21034a(this.f32070j.getContext());
        }
        if (this.f32066f == null) {
            if (this.f32073m && (view3 = this.f32072l) != null) {
                if (view3.getParent() != null) {
                    ViewUtil.m21933a(this.f32072l);
                }
                addView(this.f32072l, new ViewGroup.LayoutParams(-1, -1));
            } else {
                MBSplashWebview mBSplashWebview = this.f32063c;
                if (mBSplashWebview != null && mBSplashWebview.getParent() == null) {
                    addView(this.f32063c, new ViewGroup.LayoutParams(-1, -1));
                }
                m20947c();
            }
        } else {
            if (this.f32064d == null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                this.f32064d = relativeLayout;
                relativeLayout.setId(2147482647);
            }
            if (this.f32062b == 2) {
                this.f32067g = SameTool.m21978h(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(0, this.f32064d.getId());
                if (this.f32073m && (view2 = this.f32072l) != null) {
                    if (view2.getParent() != null) {
                        ViewUtil.m21933a(this.f32072l);
                    }
                    addView(this.f32072l, layoutParams);
                } else {
                    MBSplashWebview mBSplashWebview2 = this.f32063c;
                    if (mBSplashWebview2 != null && mBSplashWebview2.getParent() == null) {
                        addView(this.f32063c, layoutParams);
                    }
                    m20947c();
                }
                ViewGroup viewGroup2 = this.f32064d;
                if (viewGroup2 != null && viewGroup2.getParent() == null) {
                    int i = this.f32075o.width;
                    int i2 = this.f32067g;
                    if (i > i2 / 4) {
                        i = i2 / 4;
                    }
                    this.f32064d.addView(this.f32066f, i, -1);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, -1);
                    layoutParams2.addRule(11);
                    layoutParams2.addRule(13);
                    addView(this.f32064d, layoutParams2);
                }
            } else {
                this.f32067g = SameTool.m21980g(getContext());
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams3.addRule(2, this.f32064d.getId());
                if (this.f32073m && (view = this.f32072l) != null) {
                    if (view.getParent() != null) {
                        ViewUtil.m21933a(this.f32072l);
                    }
                    addView(this.f32072l, layoutParams3);
                } else {
                    MBSplashWebview mBSplashWebview3 = this.f32063c;
                    if (mBSplashWebview3 != null && mBSplashWebview3.getParent() == null) {
                        addView(this.f32063c, layoutParams3);
                    }
                    m20947c();
                }
                ViewGroup viewGroup3 = this.f32064d;
                if (viewGroup3 != null && viewGroup3.getParent() == null) {
                    int i3 = this.f32075o.height;
                    int i4 = this.f32067g;
                    if (i3 > i4 / 4) {
                        i3 = i4 / 4;
                    }
                    this.f32064d.addView(this.f32066f, -1, i3);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i3);
                    layoutParams4.addRule(12);
                    addView(this.f32064d, layoutParams4);
                }
            }
        }
        View view4 = this.f32065e;
        if (view4 != null) {
            if (view4.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(SameTool.m22001b(getContext(), 100.0f), SameTool.m22001b(getContext(), 30.0f));
                layoutParams5.addRule(10);
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = SameTool.m22001b(getContext(), 10.0f);
                layoutParams5.topMargin = SameTool.m22001b(getContext(), 10.0f);
                addView(this.f32065e, layoutParams5);
            } else {
                bringChildToFront(this.f32065e);
            }
        }
        clearResState();
    }

    public void updateCountdown(int i) {
        DyCountDownListener dyCountDownListener;
        View view;
        if (this.f32063c != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("countdown", i);
                WindVaneCallJs.m21387a().m21385a((WebView) this.f32063c, "updateCountdown", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.f32073m && (view = this.f32072l) != null && (view instanceof MBSplashNativeView)) {
                ((MBSplashNativeView) view).updateCountDown(i);
            }
            if (!this.f32073m || (dyCountDownListener = this.f32077q) == null) {
                return;
            }
            dyCountDownListener.getCountDownValue(i);
        }
    }

    public MBSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20948b();
    }
}
