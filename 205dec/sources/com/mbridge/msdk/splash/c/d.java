package com.mbridge.msdk.splash.c;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.p;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbjscommon.windvane.h;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SplashShowManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    private CampaignEx f40597c;

    /* renamed from: d  reason: collision with root package name */
    private MBSplashView f40598d;

    /* renamed from: e  reason: collision with root package name */
    private com.mbridge.msdk.splash.d.d f40599e;

    /* renamed from: f  reason: collision with root package name */
    private com.mbridge.msdk.click.b f40600f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f40601g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f40602h;

    /* renamed from: i  reason: collision with root package name */
    private View f40603i;

    /* renamed from: j  reason: collision with root package name */
    private String f40604j;

    /* renamed from: k  reason: collision with root package name */
    private String f40605k;

    /* renamed from: l  reason: collision with root package name */
    private MBridgeIds f40606l;

    /* renamed from: n  reason: collision with root package name */
    private String f40608n;

    /* renamed from: o  reason: collision with root package name */
    private String f40609o;

    /* renamed from: p  reason: collision with root package name */
    private String f40610p;

    /* renamed from: q  reason: collision with root package name */
    private String f40611q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f40612r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f40613s;

    /* renamed from: t  reason: collision with root package name */
    private Context f40614t;

    /* renamed from: b  reason: collision with root package name */
    private String f40596b = "SplashShowManager";

    /* renamed from: m  reason: collision with root package name */
    private int f40607m = 5;

    /* renamed from: u  reason: collision with root package name */
    private View.OnClickListener f40615u = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.c.d.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (d.this.f40601g) {
                d.this.b(1);
                d.b(d.this, -1);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Handler f40595a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.d.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 != 2 || d.this.f40597c == null || !d.this.f40597c.isActiveOm() || d.this.f40598d == null || (splashWebview = d.this.f40598d.getSplashWebview()) == null) {
                    return;
                }
                try {
                    com.iab.omid.library.mmadbridge.adsession.b adSession = splashWebview.getAdSession();
                    if (adSession != null) {
                        com.iab.omid.library.mmadbridge.adsession.a.a(adSession).b();
                    }
                    x.a("OMSDK", "adSession.impressionOccurred()");
                    return;
                } catch (Throwable th) {
                    x.a("OMSDK", th.getMessage());
                    if (d.this.f40597c != null) {
                        String requestId = d.this.f40597c.getRequestId();
                        String requestIdNotice = d.this.f40597c.getRequestIdNotice();
                        String id = d.this.f40597c.getId();
                        com.mbridge.msdk.foundation.same.report.d dVar = new com.mbridge.msdk.foundation.same.report.d(splashWebview.getContext());
                        String str = d.this.f40604j;
                        dVar.a(requestId, requestIdNotice, id, str, "fetch OM failed, exception" + th.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (!d.this.f40613s) {
                d.this.g();
            }
            if (d.this.f40607m <= 0) {
                d.this.b(2);
                return;
            }
            d.e(d.this);
            d dVar2 = d.this;
            d.b(dVar2, dVar2.f40607m);
            d.this.f40595a.removeMessages(1);
            sendEmptyMessageDelayed(1, 1000L);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private com.mbridge.msdk.splash.d.a f40616v = new com.mbridge.msdk.splash.d.a() { // from class: com.mbridge.msdk.splash.c.d.3
        @Override // com.mbridge.msdk.splash.d.a
        public final void a(int i4) {
            if (d.this.f40598d != null) {
                d.this.f40598d.changeCloseBtnState(i4);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void b(int i4) {
            String str = d.this.f40596b;
            x.d(str, "resetCountdown" + i4);
            d.this.f40607m = i4;
            d.this.f40595a.removeMessages(1);
            d.this.f40595a.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(Object obj, String str) {
            d.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(CampaignEx campaignEx) {
            d.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(int i4, int i5) {
            if (i4 == 1) {
                d.this.f40595a.removeMessages(1);
            }
            if (i4 == 2) {
                d.this.f40607m = i5;
                d.this.f40595a.removeMessages(1);
                d.this.f40595a.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a() {
            d.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(boolean z3) {
            if (z3) {
                d.this.f40595a.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(boolean z3, String str) {
            try {
                if (d.this.f40599e != null) {
                    if (TextUtils.isEmpty(str)) {
                        d.this.f40599e.b(d.this.f40606l);
                    } else {
                        CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(d.this.f40597c));
                        parseCampaignWithBackData.setClickURL(str);
                        d.this.a(parseCampaignWithBackData, true, str);
                    }
                }
            } catch (Exception e4) {
                x.d(d.this.f40596b, e4.getMessage());
            }
        }
    };

    public d(Context context, String str, String str2) {
        this.f40608n = "\u70b9\u51fb\u8df3\u8fc7|";
        this.f40609o = "\u70b9\u51fb\u8df3\u8fc7|";
        this.f40610p = "\u79d2";
        this.f40611q = "\u79d2\u540e\u81ea\u52a8\u5173\u95ed";
        this.f40604j = str2;
        this.f40605k = str;
        this.f40606l = new MBridgeIds(str, str2);
        this.f40614t = context;
        if (this.f40602h == null) {
            TextView textView = new TextView(context);
            this.f40602h = textView;
            textView.setGravity(1);
            this.f40602h.setTextIsSelectable(false);
            this.f40602h.setPadding(ac.b(context, 5.0f), ac.b(context, 5.0f), ac.b(context, 5.0f), ac.b(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f40602h.getLayoutParams();
            this.f40602h.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(ac.b(context, 100.0f), ac.b(context, 50.0f)) : layoutParams);
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 != null) {
                String d4 = com.mbridge.msdk.foundation.controller.a.f().d();
                int identifier = j4.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", d4);
                int identifier2 = j4.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", d4);
                int identifier3 = j4.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", d4);
                this.f40609o = j4.getResources().getString(identifier);
                String string = j4.getResources().getString(identifier2);
                this.f40611q = string;
                this.f40608n = string;
                this.f40610p = j4.getResources().getString(identifier3);
                this.f40602h.setBackgroundResource(j4.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
                this.f40602h.setTextColor(j4.getResources().getColor(j4.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", "color", d4)));
            }
        }
    }

    static /* synthetic */ int e(d dVar) {
        int i4 = dVar.f40607m;
        dVar.f40607m = i4 - 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.f40597c == null) {
            return;
        }
        boolean z3 = true;
        this.f40613s = true;
        if (this.f40599e != null && this.f40598d != null) {
            Context context = this.f40614t;
            if (context != null && (context instanceof Activity) && ((Activity) context).isFinishing()) {
                this.f40599e.a(this.f40606l, "Activity is finishing");
                return;
            } else if (this.f40598d.isShown()) {
                this.f40599e.a(this.f40606l);
            } else {
                this.f40599e.a(this.f40606l, "SplashView or container is not visibility");
            }
        }
        if (!this.f40597c.isReport()) {
            if (!this.f40598d.isDynamicView()) {
                CampaignEx campaignEx = this.f40597c;
                if (campaignEx.isHasMBTplMark()) {
                    z3 = false;
                } else {
                    c(campaignEx, com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                    campaignEx.setReport(true);
                    com.mbridge.msdk.foundation.same.a.d.a(this.f40604j, campaignEx, "splash");
                }
                if (z3) {
                    b(campaignEx, com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                    a(campaignEx, com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                }
            } else {
                CampaignEx campaignEx2 = this.f40597c;
                b(campaignEx2, com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                c(campaignEx2, com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                a(campaignEx2, com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                campaignEx2.setReport(true);
                com.mbridge.msdk.foundation.same.a.d.a(this.f40604j, campaignEx2, "splash");
            }
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            CampaignEx campaignEx3 = this.f40597c;
            String str = this.f40604j;
            if (campaignEx3 != null) {
                try {
                    if (campaignEx3.isMraid()) {
                        p pVar = new p();
                        pVar.k(campaignEx3.getRequestId());
                        pVar.l(campaignEx3.getRequestIdNotice());
                        pVar.n(campaignEx3.getId());
                        pVar.a(campaignEx3.isMraid() ? p.f39346a : p.f39347b);
                        com.mbridge.msdk.foundation.same.report.c.a(pVar, StubApp.getOrigApplicationContext(j4.getApplicationContext()), str);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private void h() {
        String str;
        if (this.f40601g) {
            str = this.f40609o + this.f40607m + this.f40610p;
        } else {
            str = this.f40607m + this.f40611q;
        }
        this.f40602h.setText(str);
    }

    public final String b() {
        CampaignEx campaignEx = this.f40597c;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.f40597c.getRequestId();
    }

    public final void d() {
        Handler handler;
        if (this.f40612r || com.mbridge.msdk.foundation.b.b.f39072c) {
            return;
        }
        if (this.f40607m > 0 && (handler = this.f40595a) != null) {
            handler.removeMessages(1);
            this.f40595a.sendEmptyMessageDelayed(1, 1000L);
        }
        MBSplashView mBSplashView = this.f40598d;
        if (mBSplashView != null) {
            mBSplashView.onResume();
            MBSplashWebview splashWebview = this.f40598d.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.js.c.a(splashWebview, "onSystemResume", "");
        }
    }

    public final void e() {
        Handler handler;
        if (this.f40607m > 0 && (handler = this.f40595a) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.f40598d;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.f40598d.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.js.c.a(splashWebview, "onSystemPause", "");
        }
    }

    public final void f() {
        MBSplashWebview splashWebview;
        Handler handler;
        this.f40612r = false;
        if (this.f40607m > 0 && (handler = this.f40595a) != null) {
            handler.removeMessages(1);
            this.f40595a.sendEmptyMessageDelayed(1, 1000L);
        }
        MBSplashView mBSplashView = this.f40598d;
        if (mBSplashView == null || (splashWebview = mBSplashView.getSplashWebview()) == null || splashWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.splash.js.c.a(splashWebview, "onInstallAlertHide", "");
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        com.mbridge.msdk.foundation.controller.a.f().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.d.7
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l.a(i.a(context)).b(campaignEx.getId());
                    } catch (Exception unused) {
                        x.d(d.this.f40596b, "campain can't insert db");
                    }
                }
            }).start();
            com.mbridge.msdk.click.b.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f38807g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
            return;
        }
        com.mbridge.msdk.click.b.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().l(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CampaignEx campaignEx, boolean z3, String str) {
        if (this.f40600f == null) {
            this.f40600f = new com.mbridge.msdk.click.b(com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
        }
        campaignEx.setCampaignUnitId(this.f40604j);
        this.f40600f.c(campaignEx);
        if (!this.f40597c.isReportClick()) {
            this.f40597c.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx);
        }
        com.mbridge.msdk.splash.d.d dVar = this.f40599e;
        if (dVar != null) {
            dVar.b(this.f40606l);
            b(3);
        }
        if (!z3 || TextUtils.isEmpty(str)) {
            return;
        }
        com.mbridge.msdk.splash.e.a.a(campaignEx, this.f40604j, str);
    }

    public final void a(com.mbridge.msdk.splash.d.d dVar) {
        this.f40599e = dVar;
    }

    public final void a(int i4) {
        this.f40607m = i4;
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.f40615u);
        }
        this.f40603i = viewGroup;
    }

    public final com.mbridge.msdk.splash.d.a a() {
        return this.f40616v;
    }

    public final void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        MBSplashWebview splashWebview;
        a(this.f40601g);
        this.f40597c = campaignEx;
        this.f40598d = mBSplashView;
        com.mbridge.msdk.splash.js.b splashJSBridgeImpl = mBSplashView.getSplashJSBridgeImpl();
        if (splashJSBridgeImpl == null) {
            splashJSBridgeImpl = new com.mbridge.msdk.splash.js.b(mBSplashView.getContext(), this.f40605k, this.f40604j);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashJSBridgeImpl.a(arrayList);
        }
        splashJSBridgeImpl.b(this.f40607m);
        splashJSBridgeImpl.a(this.f40601g ? 1 : 0);
        splashJSBridgeImpl.a(this.f40616v);
        mBSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
        boolean isHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.f40603i;
        if (view == null) {
            if (isHasMBTplMark) {
                this.f40602h.setVisibility(8);
            }
            h();
            a(this.f40602h);
            mBSplashView.setCloseView(this.f40602h);
        } else {
            if (isHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.f40603i);
            mBSplashView.setCloseView(this.f40603i);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.f40597c;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                com.iab.omid.library.mmadbridge.adsession.b a4 = com.mbridge.msdk.a.b.a(com.mbridge.msdk.foundation.controller.a.f().j(), splashWebview, splashWebview.getUrl(), this.f40597c);
                if (a4 != null) {
                    splashWebview.setAdSession(a4);
                    a4.g(splashWebview);
                    a4.k();
                    x.a("OMSDK", "adSession.start()");
                }
            } catch (Throwable th) {
                x.a("OMSDK", th.getMessage());
                CampaignEx campaignEx3 = this.f40597c;
                if (campaignEx3 != null) {
                    String requestId = campaignEx3.getRequestId();
                    String requestIdNotice = this.f40597c.getRequestIdNotice();
                    String id = this.f40597c.getId();
                    com.mbridge.msdk.foundation.same.report.d dVar = new com.mbridge.msdk.foundation.same.report.d(splashWebview.getContext());
                    String str = this.f40604j;
                    dVar.a(requestId, requestIdNotice, id, str, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        b.a(this.f40604j);
        b.b(this.f40597c.getImageUrl());
        this.f40595a.removeMessages(1);
        this.f40595a.sendEmptyMessageDelayed(1, 1000L);
        this.f40595a.sendEmptyMessageDelayed(2, 1000L);
        if (com.mbridge.msdk.foundation.b.b.a().b() && !this.f40598d.isDynamicView()) {
            com.mbridge.msdk.foundation.b.b.a().a(this.f40604j, new com.mbridge.msdk.foundation.b.a() { // from class: com.mbridge.msdk.splash.c.d.4
                @Override // com.mbridge.msdk.foundation.b.a
                public final void a() {
                    String str2;
                    d.this.e();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                            jSONObject.put("status", 1);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th2) {
                        x.b(d.this.f40596b, th2.getMessage(), th2);
                        str2 = "";
                    }
                    h.a().a((WebView) d.this.f40598d.getSplashWebview(), AbsFeedBackForH5.WEBVIEW_EVENT_DIALOG_METHOD_NAME, Base64.encodeToString(str2.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.b.a
                public final void b() {
                    String str2;
                    d.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th2) {
                        x.b(d.this.f40596b, th2.getMessage(), th2);
                        str2 = "";
                    }
                    h.a().a((WebView) d.this.f40598d.getSplashWebview(), AbsFeedBackForH5.WEBVIEW_EVENT_DIALOG_METHOD_NAME, Base64.encodeToString(str2.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.b.a
                public final void a(String str2) {
                    String str3;
                    d.this.d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.f().j() != null) {
                            jSONObject.put("status", 2);
                        }
                        str3 = jSONObject.toString();
                    } catch (Throwable th2) {
                        x.b(d.this.f40596b, th2.getMessage(), th2);
                        str3 = "";
                    }
                    h.a().a((WebView) d.this.f40598d.getSplashWebview(), AbsFeedBackForH5.WEBVIEW_EVENT_DIALOG_METHOD_NAME, Base64.encodeToString(str3.getBytes(), 2));
                }
            });
            FeedBackButton b4 = com.mbridge.msdk.foundation.b.b.a().b(this.f40604j);
            if (b4 != null) {
                RelativeLayout.LayoutParams layoutParams = null;
                try {
                    layoutParams = (RelativeLayout.LayoutParams) b4.getLayoutParams();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.b.b.f39070a, com.mbridge.msdk.foundation.b.b.f39071b);
                }
                layoutParams.topMargin = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 10.0f);
                layoutParams.leftMargin = ac.b(com.mbridge.msdk.foundation.controller.a.f().j(), 10.0f);
                ViewGroup viewGroup = (ViewGroup) b4.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(b4);
                }
                this.f40598d.addView(b4, layoutParams);
            }
            this.f40597c.setCampaignUnitId(this.f40604j);
            com.mbridge.msdk.foundation.b.b.a().a(this.f40604j, this.f40597c);
        }
    }

    public final void c() {
        if (this.f40599e != null) {
            this.f40599e = null;
        }
        if (this.f40616v != null) {
            this.f40616v = null;
        }
        if (this.f40615u != null) {
            this.f40615u = null;
        }
        MBSplashView mBSplashView = this.f40598d;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.b.b.a().c(this.f40604j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        com.mbridge.msdk.splash.a.b bVar;
        MBSplashWebview splashWebview;
        com.mbridge.msdk.splash.d.d dVar = this.f40599e;
        if (dVar != null) {
            dVar.a(this.f40606l, i4);
            this.f40599e = null;
            com.mbridge.msdk.splash.e.a.a(this.f40604j, this.f40597c);
        }
        this.f40613s = false;
        if (this.f40597c != null) {
            bVar = com.mbridge.msdk.splash.a.b.a().b(this.f40604j).d(this.f40597c.getRequestId()).g(this.f40597c.getRequestIdNotice()).c(this.f40597c.getId()).e(this.f40597c.getCreativeId() + "").a(this.f40597c.isBidCampaign());
        } else {
            bVar = null;
        }
        com.mbridge.msdk.splash.e.a.a(bVar, this.f40604j, i4);
        MBSplashView mBSplashView = this.f40598d;
        if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        Handler handler = this.f40595a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.b.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f38808h);
            } catch (Throwable th) {
                x.d(this.f40596b, th.getMessage());
            }
        }
    }

    static /* synthetic */ void b(d dVar, int i4) {
        MBSplashView mBSplashView = dVar.f40598d;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i4);
            if (dVar.f40598d.getSplashJSBridgeImpl() != null) {
                dVar.f40598d.getSplashJSBridgeImpl().c(i4);
            }
        }
        if (i4 < 0) {
            dVar.f40607m = i4;
            return;
        }
        com.mbridge.msdk.splash.d.d dVar2 = dVar.f40599e;
        if (dVar2 != null) {
            dVar2.a(dVar.f40606l, i4 * 1000);
        }
        if (dVar.f40603i == null) {
            dVar.h();
        }
    }

    public final void a(boolean z3) {
        this.f40601g = z3;
        if (z3) {
            this.f40608n = this.f40609o;
        } else {
            this.f40608n = this.f40611q;
        }
    }

    public final void a(final CampaignEx campaignEx, final boolean z3, final String str) {
        MBSplashWebview splashWebview;
        Handler handler;
        if (campaignEx != null) {
            try {
                if (campaignEx.needShowIDialog()) {
                    final com.mbridge.msdk.widget.dialog.a aVar = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.splash.c.d.5
                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void a() {
                            d.this.b(campaignEx, z3, str);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void b() {
                            d.this.f();
                        }

                        @Override // com.mbridge.msdk.widget.dialog.a
                        public final void c() {
                            a();
                        }
                    };
                    if (this.f40598d != null && com.mbridge.msdk.click.c.a(campaignEx) && campaignEx.needShowIDialog() && !this.f40612r) {
                        if (this.f40600f == null) {
                            this.f40600f = new com.mbridge.msdk.click.b(com.mbridge.msdk.foundation.controller.a.f().j(), this.f40604j);
                        }
                        final Context context = this.f40598d.getContext();
                        this.f40598d.post(new Runnable() { // from class: com.mbridge.msdk.splash.c.d.6
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (!d.this.f40600f.b(campaignEx)) {
                                    Context context2 = context;
                                    if (context2 != StubApp.getOrigApplicationContext(context2.getApplicationContext())) {
                                        com.mbridge.msdk.mbjscommon.confirmation.e.a().a("", campaignEx, context, d.this.f40604j, aVar);
                                        return;
                                    } else {
                                        com.mbridge.msdk.mbjscommon.confirmation.e.a().a("", campaignEx, d.this.f40614t, d.this.f40604j, aVar);
                                        return;
                                    }
                                }
                                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), campaignEx);
                                if (d.this.f40599e != null) {
                                    d.this.f40599e.b(d.this.f40606l);
                                    d.this.b(3);
                                }
                            }
                        });
                        this.f40612r = true;
                        if (this.f40607m > 0 && (handler = this.f40595a) != null) {
                            handler.removeMessages(1);
                        }
                        MBSplashView mBSplashView = this.f40598d;
                        if (mBSplashView == null || (splashWebview = mBSplashView.getSplashWebview()) == null || splashWebview.isDestoryed()) {
                            return;
                        }
                        com.mbridge.msdk.splash.js.c.a(splashWebview, "onInstallAlertShow", "");
                        return;
                    }
                }
            } catch (Throwable th) {
                x.a(this.f40596b, th.getMessage());
            }
        }
        if (campaignEx != null) {
            b(campaignEx, z3, str);
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.f40615u);
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                for (String str2 : pv_urls) {
                    com.mbridge.msdk.click.b.a(context, campaignEx, str, str2, false, true);
                }
            } catch (Throwable th) {
                x.d(this.f40596b, th.getMessage());
            }
        }
    }
}
