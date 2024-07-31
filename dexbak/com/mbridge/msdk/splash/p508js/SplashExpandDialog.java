package com.mbridge.msdk.splash.p508js;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.mbridge.msdk.click.p461b.DspFilterUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.mraid.CallMraidJS;
import com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge;
import com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.p457c.p459b.MraidJSController;
import com.mbridge.msdk.splash.p505d.SplashBridgeListener;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.js.SplashExpandDialog */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SplashExpandDialog extends Dialog {

    /* renamed from: a */
    private final String f31934a;

    /* renamed from: b */
    private String f31935b;

    /* renamed from: c */
    private boolean f31936c;

    /* renamed from: d */
    private FrameLayout f31937d;

    /* renamed from: e */
    private WindVaneWebView f31938e;

    /* renamed from: f */
    private TextView f31939f;

    /* renamed from: g */
    private String f31940g;

    /* renamed from: h */
    private List<CampaignEx> f31941h;

    /* renamed from: i */
    private SplashBridgeListener f31942i;

    /* renamed from: j */
    private IMraidJSBridge f31943j;

    public SplashExpandDialog(Context context, Bundle bundle, SplashBridgeListener splashBridgeListener) {
        super(context);
        this.f31934a = "SplashExpandDialog";
        this.f31943j = new IMraidJSBridge() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.4
            @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
            public final void close() {
                SplashExpandDialog.this.dismiss();
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
            public final void expand(String str, boolean z) {
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
            public final CampaignEx getMraidCampaign() {
                return null;
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
            public final void open(String str) {
                try {
                    if (SplashExpandDialog.this.f31938e == null || System.currentTimeMillis() - SplashExpandDialog.this.f31938e.lastTouchTime <= DspFilterUtils.f30068c || !DspFilterUtils.m23081a((CampaignEx) SplashExpandDialog.this.f31941h.get(0), SplashExpandDialog.this.f31938e.getUrl(), DspFilterUtils.f30066a)) {
                        SameLogTool.m21733d("SplashExpandDialog", str);
                        if (SplashExpandDialog.this.f31941h.size() > 1) {
                            MBSDKContext.m22865f().m22861j().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (SplashExpandDialog.this.f31942i != null) {
                            SplashExpandDialog.this.f31942i.mo21114a(true, str);
                        }
                    }
                } catch (Throwable th) {
                    SameLogTool.m21735b("SplashExpandDialog", "open", th);
                }
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
            public final void useCustomClose(boolean z) {
                try {
                    SplashExpandDialog.this.f31939f.setVisibility(z ? 4 : 0);
                } catch (Throwable th) {
                    SameLogTool.m21735b("SplashExpandDialog", "useCustomClose", th);
                }
            }
        };
        if (bundle != null) {
            this.f31935b = bundle.getString("url");
            this.f31936c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f31942i = splashBridgeListener;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f31937d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.f31938e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f31937d.addView(this.f31938e);
        TextView textView = new TextView(getContext());
        this.f31939f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f31939f.setLayoutParams(layoutParams);
        this.f31939f.setVisibility(this.f31936c ? 4 : 0);
        this.f31939f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashExpandDialog.this.dismiss();
            }
        });
        this.f31937d.addView(this.f31939f);
        setContentView(this.f31937d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 19 ? 4615 : 519);
        }
        this.f31938e.setWebViewListener(new DefaultWebViewListener() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.2
            @Override // com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener, com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
            /* renamed from: a */
            public final void mo21037a(WebView webView, String str) {
                super.mo21037a(webView, str);
                StringBuilder sb = new StringBuilder("javascript:");
                sb.append(MraidJSController.m23231a().m23228b());
                if (Build.VERSION.SDK_INT <= 19) {
                    webView.loadUrl(sb.toString());
                } else {
                    webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.2.1
                        @Override // android.webkit.ValueCallback
                        public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                SplashExpandDialog.m21045a(SplashExpandDialog.this);
            }
        });
        this.f31938e.setObject(this.f31943j);
        this.f31938e.loadUrl(this.f31935b);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (SplashExpandDialog.this.f31942i != null) {
                    SplashExpandDialog.this.f31942i.mo21115a(false);
                    SplashExpandDialog.this.f31942i.mo21120a();
                }
                SplashExpandDialog.this.f31938e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                SplashExpandDialog.this.f31937d.removeView(SplashExpandDialog.this.f31938e);
                SplashExpandDialog.this.f31938e.release();
                SplashExpandDialog.this.f31938e = null;
                SplashExpandDialog.this.f31942i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f31940g = str;
        this.f31941h = list;
    }

    /* renamed from: a */
    static /* synthetic */ void m21045a(SplashExpandDialog splashExpandDialog) {
        try {
            int i = MBSDKContext.m22865f().m22861j().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i == 2 ? "landscape" : i == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            HashMap m21761z = SameDiTool.m21761z(MBSDKContext.m22865f().m22861j());
            int intValue = ((Integer) m21761z.get("width")).intValue();
            int intValue2 = ((Integer) m21761z.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", ExploreConstants.SCENE_INTERSTITIAL);
            hashMap.put("state", "expanded");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            splashExpandDialog.f31938e.getLocationInWindow(iArr);
            CallMraidJS m21430a = CallMraidJS.m21430a();
            WindVaneWebView windVaneWebView = splashExpandDialog.f31938e;
            m21430a.m21426a(windVaneWebView, iArr[0], iArr[1], windVaneWebView.getWidth(), splashExpandDialog.f31938e.getHeight());
            CallMraidJS m21430a2 = CallMraidJS.m21430a();
            WindVaneWebView windVaneWebView2 = splashExpandDialog.f31938e;
            m21430a2.m21421b(windVaneWebView2, iArr[0], iArr[1], windVaneWebView2.getWidth(), splashExpandDialog.f31938e.getHeight());
            CallMraidJS.m21430a().m21422b(splashExpandDialog.f31938e, SameDiTool.m21765x(MBSDKContext.m22865f().m22861j()), SameDiTool.m21763y(MBSDKContext.m22865f().m22861j()));
            CallMraidJS.m21430a().m21419c(splashExpandDialog.f31938e, intValue, intValue2);
            CallMraidJS.m21430a().m21423a(splashExpandDialog.f31938e, hashMap);
            CallMraidJS.m21430a().m21429a(splashExpandDialog.f31938e);
        } catch (Throwable th) {
            SameLogTool.m21735b("SplashExpandDialog", "notifyMraid", th);
        }
    }
}
