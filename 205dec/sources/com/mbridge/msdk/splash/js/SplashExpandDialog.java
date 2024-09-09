package com.mbridge.msdk.splash.js;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SplashExpandDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final String f40701a;

    /* renamed from: b  reason: collision with root package name */
    private String f40702b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40703c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f40704d;

    /* renamed from: e  reason: collision with root package name */
    private WindVaneWebView f40705e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f40706f;

    /* renamed from: g  reason: collision with root package name */
    private String f40707g;

    /* renamed from: h  reason: collision with root package name */
    private List<CampaignEx> f40708h;

    /* renamed from: i  reason: collision with root package name */
    private com.mbridge.msdk.splash.d.a f40709i;

    /* renamed from: j  reason: collision with root package name */
    private com.mbridge.msdk.mbjscommon.mraid.b f40710j;

    public SplashExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.splash.d.a aVar) {
        super(context);
        this.f40701a = "SplashExpandDialog";
        this.f40710j = new com.mbridge.msdk.mbjscommon.mraid.b() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.4
            @Override // com.mbridge.msdk.mbjscommon.mraid.b
            public final void close() {
                SplashExpandDialog.this.dismiss();
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.b
            public final void expand(String str, boolean z3) {
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.b
            public final CampaignEx getMraidCampaign() {
                return null;
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.b
            public final void open(String str) {
                try {
                    if (SplashExpandDialog.this.f40705e == null || System.currentTimeMillis() - SplashExpandDialog.this.f40705e.lastTouchTime <= com.mbridge.msdk.click.b.a.f38895c || !com.mbridge.msdk.click.b.a.a((CampaignEx) SplashExpandDialog.this.f40708h.get(0), SplashExpandDialog.this.f40705e.getUrl(), com.mbridge.msdk.click.b.a.f38893a)) {
                        x.d("SplashExpandDialog", str);
                        if (SplashExpandDialog.this.f40708h.size() > 1) {
                            com.mbridge.msdk.foundation.controller.a.f().j().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            str = null;
                        }
                        if (SplashExpandDialog.this.f40709i != null) {
                            SplashExpandDialog.this.f40709i.a(true, str);
                        }
                    }
                } catch (Throwable th) {
                    x.b("SplashExpandDialog", "open", th);
                }
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.b
            public final void unload() {
                close();
            }

            @Override // com.mbridge.msdk.mbjscommon.mraid.b
            public final void useCustomClose(boolean z3) {
                try {
                    SplashExpandDialog.this.f40706f.setVisibility(z3 ? 4 : 0);
                } catch (Throwable th) {
                    x.b("SplashExpandDialog", "useCustomClose", th);
                }
            }
        };
        if (bundle != null) {
            this.f40702b = bundle.getString("url");
            this.f40703c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f40709i = aVar;
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
        this.f40704d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.f40705e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f40704d.addView(this.f40705e);
        TextView textView = new TextView(getContext());
        this.f40706f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f40706f.setLayoutParams(layoutParams);
        this.f40706f.setVisibility(this.f40703c ? 4 : 0);
        this.f40706f.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashExpandDialog.this.dismiss();
            }
        });
        this.f40704d.addView(this.f40706f);
        setContentView(this.f40704d);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            int i4 = Build.VERSION.SDK_INT;
            int i5 = MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX;
            if (i4 >= 19) {
                i5 = 4615;
            }
            getWindow().getDecorView().setSystemUiVisibility(i5);
        }
        this.f40705e.setWebViewListener(new com.mbridge.msdk.mbjscommon.c.b() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.2
            @Override // com.mbridge.msdk.mbjscommon.c.b, com.mbridge.msdk.mbjscommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                StringBuilder sb = new StringBuilder("javascript:");
                sb.append(com.mbridge.msdk.c.b.b.a().b());
                if (Build.VERSION.SDK_INT <= 19) {
                    webView.loadUrl(sb.toString());
                } else {
                    webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.2.1
                        @Override // android.webkit.ValueCallback
                        public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                SplashExpandDialog.a(SplashExpandDialog.this);
            }
        });
        this.f40705e.setObject(this.f40710j);
        this.f40705e.loadUrl(this.f40702b);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mbridge.msdk.splash.js.SplashExpandDialog.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                if (SplashExpandDialog.this.f40709i != null) {
                    SplashExpandDialog.this.f40709i.a(false);
                    SplashExpandDialog.this.f40709i.a();
                }
                SplashExpandDialog.this.f40705e.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
                SplashExpandDialog.this.f40704d.removeView(SplashExpandDialog.this.f40705e);
                SplashExpandDialog.this.f40705e.release();
                SplashExpandDialog.this.f40705e = null;
                SplashExpandDialog.this.f40709i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f40707g = str;
        this.f40708h = list;
    }

    static /* synthetic */ void a(SplashExpandDialog splashExpandDialog) {
        try {
            int i4 = com.mbridge.msdk.foundation.controller.a.f().j().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i4 == 2 ? "landscape" : i4 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            HashMap z3 = t.z(com.mbridge.msdk.foundation.controller.a.f().j());
            int intValue = ((Integer) z3.get("width")).intValue();
            int intValue2 = ((Integer) z3.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "Interstitial");
            hashMap.put("state", "expanded");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            int[] iArr = new int[2];
            splashExpandDialog.f40705e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbjscommon.mraid.a a4 = com.mbridge.msdk.mbjscommon.mraid.a.a();
            WindVaneWebView windVaneWebView = splashExpandDialog.f40705e;
            a4.a(windVaneWebView, iArr[0], iArr[1], windVaneWebView.getWidth(), splashExpandDialog.f40705e.getHeight());
            com.mbridge.msdk.mbjscommon.mraid.a a5 = com.mbridge.msdk.mbjscommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = splashExpandDialog.f40705e;
            a5.b(windVaneWebView2, iArr[0], iArr[1], windVaneWebView2.getWidth(), splashExpandDialog.f40705e.getHeight());
            com.mbridge.msdk.mbjscommon.mraid.a.a().b(splashExpandDialog.f40705e, t.x(com.mbridge.msdk.foundation.controller.a.f().j()), t.y(com.mbridge.msdk.foundation.controller.a.f().j()));
            com.mbridge.msdk.mbjscommon.mraid.a.a().c(splashExpandDialog.f40705e, intValue, intValue2);
            com.mbridge.msdk.mbjscommon.mraid.a.a().a(splashExpandDialog.f40705e, hashMap);
            com.mbridge.msdk.mbjscommon.mraid.a.a().a(splashExpandDialog.f40705e);
        } catch (Throwable th) {
            x.b("SplashExpandDialog", "notifyMraid", th);
        }
    }
}
