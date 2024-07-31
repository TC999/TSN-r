package com.mbridge.msdk.splash.p504c;

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
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.iab.omid.library.mmadbridge.adsession.AbstractC7075b;
import com.iab.omid.library.mmadbridge.adsession.C7074a;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.click.p460a.RetryReportControl;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.VideoReportData;
import com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener;
import com.mbridge.msdk.foundation.p470b.FeedbackManager;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.same.report.PlayableReportUtils;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager;
import com.mbridge.msdk.mbjscommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.p454a.OmsdkUtils;
import com.mbridge.msdk.splash.p501a.C11567b;
import com.mbridge.msdk.splash.p505d.SplashBridgeListener;
import com.mbridge.msdk.splash.p505d.SplashShowListenerImpl;
import com.mbridge.msdk.splash.p506e.SplashReport;
import com.mbridge.msdk.splash.p508js.SplashJSBridgeImpl;
import com.mbridge.msdk.splash.p508js.SplashJsUtils;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialogListener;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SplashShowManager {

    /* renamed from: c */
    private CampaignEx f31825c;

    /* renamed from: d */
    private MBSplashView f31826d;

    /* renamed from: e */
    private SplashShowListenerImpl f31827e;

    /* renamed from: f */
    private CommonClickControl f31828f;

    /* renamed from: g */
    private boolean f31829g;

    /* renamed from: h */
    private TextView f31830h;

    /* renamed from: i */
    private View f31831i;

    /* renamed from: j */
    private String f31832j;

    /* renamed from: k */
    private String f31833k;

    /* renamed from: l */
    private MBridgeIds f31834l;

    /* renamed from: n */
    private String f31836n;

    /* renamed from: o */
    private String f31837o;

    /* renamed from: p */
    private String f31838p;

    /* renamed from: q */
    private String f31839q;

    /* renamed from: r */
    private boolean f31840r;

    /* renamed from: s */
    private boolean f31841s;

    /* renamed from: t */
    private Context f31842t;

    /* renamed from: b */
    private String f31824b = "SplashShowManager";

    /* renamed from: m */
    private int f31835m = 5;

    /* renamed from: u */
    private View.OnClickListener f31843u = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.c.d.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (SplashShowManager.this.f31829g) {
                SplashShowManager.this.m21167b(1);
                SplashShowManager.m21163b(SplashShowManager.this, -1);
            }
        }
    };

    /* renamed from: a */
    public Handler f31823a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.d.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2 || SplashShowManager.this.f31825c == null || !SplashShowManager.this.f31825c.isActiveOm() || SplashShowManager.this.f31826d == null || (splashWebview = SplashShowManager.this.f31826d.getSplashWebview()) == null) {
                    return;
                }
                try {
                    AbstractC7075b adSession = splashWebview.getAdSession();
                    if (adSession != null) {
                        C7074a.m34839a(adSession).m34838b();
                    }
                    SameLogTool.m21738a("OMSDK", "adSession.impressionOccurred()");
                    return;
                } catch (Throwable th) {
                    SameLogTool.m21738a("OMSDK", th.getMessage());
                    if (SplashShowManager.this.f31825c != null) {
                        String requestId = SplashShowManager.this.f31825c.getRequestId();
                        String requestIdNotice = SplashShowManager.this.f31825c.getRequestIdNotice();
                        String id = SplashShowManager.this.f31825c.getId();
                        ReportController reportController = new ReportController(splashWebview.getContext());
                        String str = SplashShowManager.this.f31832j;
                        reportController.m22093a(requestId, requestIdNotice, id, str, "fetch OM failed, exception" + th.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (!SplashShowManager.this.f31841s) {
                SplashShowManager.this.m21152g();
            }
            if (SplashShowManager.this.f31835m <= 0) {
                SplashShowManager.this.m21167b(2);
                return;
            }
            SplashShowManager.m21155e(SplashShowManager.this);
            SplashShowManager splashShowManager = SplashShowManager.this;
            SplashShowManager.m21163b(splashShowManager, splashShowManager.f31835m);
            SplashShowManager.this.f31823a.removeMessages(1);
            sendEmptyMessageDelayed(1, 1000L);
        }
    };

    /* renamed from: v */
    private SplashBridgeListener f31844v = new SplashBridgeListener() { // from class: com.mbridge.msdk.splash.c.d.3
        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21119a(int i) {
            if (SplashShowManager.this.f31826d != null) {
                SplashShowManager.this.f31826d.changeCloseBtnState(i);
            }
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: b */
        public final void mo21113b(int i) {
            String str = SplashShowManager.this.f31824b;
            SameLogTool.m21733d(str, "resetCountdown" + i);
            SplashShowManager.this.f31835m = i;
            SplashShowManager.this.f31823a.removeMessages(1);
            SplashShowManager.this.f31823a.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21116a(Object obj, String str) {
            SplashShowManager.this.m21167b(1);
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21117a(CampaignEx campaignEx) {
            SplashShowManager.this.m21174a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21118a(int i, int i2) {
            if (i == 1) {
                SplashShowManager.this.f31823a.removeMessages(1);
            }
            if (i == 2) {
                SplashShowManager.this.f31835m = i2;
                SplashShowManager.this.f31823a.removeMessages(1);
                SplashShowManager.this.f31823a.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21120a() {
            SplashShowManager.this.m21167b(1);
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21115a(boolean z) {
            if (z) {
                SplashShowManager.this.f31823a.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.p505d.SplashBridgeListener
        /* renamed from: a */
        public final void mo21114a(boolean z, String str) {
            try {
                if (SplashShowManager.this.f31827e != null) {
                    if (TextUtils.isEmpty(str)) {
                        SplashShowManager.this.f31827e.m21067b(SplashShowManager.this.f31834l);
                    } else {
                        CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(SplashShowManager.this.f31825c));
                        parseCampaignWithBackData.setClickURL(str);
                        SplashShowManager.this.m21174a(parseCampaignWithBackData, true, str);
                    }
                }
            } catch (Exception e) {
                SameLogTool.m21733d(SplashShowManager.this.f31824b, e.getMessage());
            }
        }
    };

    public SplashShowManager(Context context, String str, String str2) {
        this.f31836n = "点击跳过|";
        this.f31837o = "点击跳过|";
        this.f31838p = "秒";
        this.f31839q = "秒后自动关闭";
        this.f31832j = str2;
        this.f31833k = str;
        this.f31834l = new MBridgeIds(str, str2);
        this.f31842t = context;
        if (this.f31830h == null) {
            TextView textView = new TextView(context);
            this.f31830h = textView;
            textView.setGravity(1);
            this.f31830h.setTextIsSelectable(false);
            this.f31830h.setPadding(SameTool.m22001b(context, 5.0f), SameTool.m22001b(context, 5.0f), SameTool.m22001b(context, 5.0f), SameTool.m22001b(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f31830h.getLayoutParams();
            this.f31830h.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(SameTool.m22001b(context, 100.0f), SameTool.m22001b(context, 50.0f)) : layoutParams);
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j != null) {
                String m22869d = MBSDKContext.m22865f().m22869d();
                int identifier = m22861j.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", m22869d);
                int identifier2 = m22861j.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", m22869d);
                int identifier3 = m22861j.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", m22869d);
                this.f31837o = m22861j.getResources().getString(identifier);
                String string = m22861j.getResources().getString(identifier2);
                this.f31839q = string;
                this.f31836n = string;
                this.f31838p = m22861j.getResources().getString(identifier3);
                this.f31830h.setBackgroundResource(m22861j.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", MBSDKContext.m22865f().m22869d()));
                this.f31830h.setTextColor(m22861j.getResources().getColor(m22861j.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", "color", m22869d)));
            }
        }
    }

    /* renamed from: e */
    static /* synthetic */ int m21155e(SplashShowManager splashShowManager) {
        int i = splashShowManager.f31835m;
        splashShowManager.f31835m = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void m21152g() {
        if (this.f31825c == null) {
            return;
        }
        boolean z = true;
        this.f31841s = true;
        if (this.f31827e != null && this.f31826d != null) {
            Context context = this.f31842t;
            if (context != null && (context instanceof Activity) && ((Activity) context).isFinishing()) {
                this.f31827e.m21068a(this.f31834l, "Activity is finishing");
                return;
            } else if (this.f31826d.isShown()) {
                this.f31827e.m21072a(this.f31834l);
            } else {
                this.f31827e.m21068a(this.f31834l, "SplashView or container is not visibility");
            }
        }
        if (!this.f31825c.isReport()) {
            if (!this.f31826d.isDynamicView()) {
                CampaignEx campaignEx = this.f31825c;
                if (campaignEx.isHasMBTplMark()) {
                    z = false;
                } else {
                    m21161c(campaignEx, MBSDKContext.m22865f().m22861j(), this.f31832j);
                    campaignEx.setReport(true);
                    StaticDataPoll.m22375a(this.f31832j, campaignEx, MediationConstant.RIT_TYPE_SPLASH);
                }
                if (z) {
                    m21166b(campaignEx, MBSDKContext.m22865f().m22861j(), this.f31832j);
                    m21176a(campaignEx, MBSDKContext.m22865f().m22861j(), this.f31832j);
                }
            } else {
                CampaignEx campaignEx2 = this.f31825c;
                m21166b(campaignEx2, MBSDKContext.m22865f().m22861j(), this.f31832j);
                m21161c(campaignEx2, MBSDKContext.m22865f().m22861j(), this.f31832j);
                m21176a(campaignEx2, MBSDKContext.m22865f().m22861j(), this.f31832j);
                campaignEx2.setReport(true);
                StaticDataPoll.m22375a(this.f31832j, campaignEx2, MediationConstant.RIT_TYPE_SPLASH);
            }
            Context m22861j = MBSDKContext.m22865f().m22861j();
            CampaignEx campaignEx3 = this.f31825c;
            String str = this.f31832j;
            if (campaignEx3 != null) {
                try {
                    if (campaignEx3.isMraid()) {
                        VideoReportData videoReportData = new VideoReportData();
                        videoReportData.m22410k(campaignEx3.getRequestId());
                        videoReportData.m22408l(campaignEx3.getRequestIdNotice());
                        videoReportData.m22404n(campaignEx3.getId());
                        videoReportData.m22448a(campaignEx3.isMraid() ? VideoReportData.f30525a : VideoReportData.f30526b);
                        PlayableReportUtils.m22115a(videoReportData, StubApp.getOrigApplicationContext(m22861j.getApplicationContext()), str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: h */
    private void m21150h() {
        String str;
        if (this.f31829g) {
            str = this.f31837o + this.f31835m + this.f31838p;
        } else {
            str = this.f31835m + this.f31839q;
        }
        this.f31830h.setText(str);
    }

    /* renamed from: b */
    public final String m21168b() {
        CampaignEx campaignEx = this.f31825c;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.f31825c.getRequestId();
    }

    /* renamed from: d */
    public final void m21158d() {
        Handler handler;
        if (this.f31840r || FeedbackManager.f30245c) {
            return;
        }
        if (this.f31835m > 0 && (handler = this.f31823a) != null) {
            handler.removeMessages(1);
            this.f31823a.sendEmptyMessageDelayed(1, 1000L);
        }
        MBSplashView mBSplashView = this.f31826d;
        if (mBSplashView != null) {
            mBSplashView.onResume();
            MBSplashWebview splashWebview = this.f31826d.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            SplashJsUtils.m21011a(splashWebview, "onSystemResume", "");
        }
    }

    /* renamed from: e */
    public final void m21156e() {
        Handler handler;
        if (this.f31835m > 0 && (handler = this.f31823a) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.f31826d;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.f31826d.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            SplashJsUtils.m21011a(splashWebview, "onSystemPause", "");
        }
    }

    /* renamed from: f */
    public final void m21154f() {
        MBSplashWebview splashWebview;
        Handler handler;
        this.f31840r = false;
        if (this.f31835m > 0 && (handler = this.f31823a) != null) {
            handler.removeMessages(1);
            this.f31823a.sendEmptyMessageDelayed(1, 1000L);
        }
        MBSplashView mBSplashView = this.f31826d;
        if (mBSplashView == null || (splashWebview = mBSplashView.getSplashWebview()) == null || splashWebview.isDestoryed()) {
            return;
        }
        SplashJsUtils.m21011a(splashWebview, "onInstallAlertHide", "");
    }

    /* renamed from: c */
    private void m21161c(final CampaignEx campaignEx, final Context context, String str) {
        MBSDKContext.m22865f().m22886a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.d.7
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        FrequenceDao.m22703a(CommonSDKDBHelper.m22721a(context)).m22698b(campaignEx.getId());
                    } catch (Exception unused) {
                        SameLogTool.m21733d(SplashShowManager.this.f31824b, "campain can't insert db");
                    }
                }
            }).start();
            CommonClickControl.m23127a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, RetryReportControl.f29980g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().m22495l() == null) {
            return;
        }
        CommonClickControl.m23126a(context, campaignEx, str, campaignEx.getNativeVideoTracking().m22495l(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m21165b(CampaignEx campaignEx, boolean z, String str) {
        if (this.f31828f == null) {
            this.f31828f = new CommonClickControl(MBSDKContext.m22865f().m22861j(), this.f31832j);
        }
        campaignEx.setCampaignUnitId(this.f31832j);
        this.f31828f.m23094c(campaignEx);
        if (!this.f31825c.isReportClick()) {
            this.f31825c.setReportClick(true);
            SplashReport.m21066a(MBSDKContext.m22865f().m22861j(), campaignEx);
        }
        SplashShowListenerImpl splashShowListenerImpl = this.f31827e;
        if (splashShowListenerImpl != null) {
            splashShowListenerImpl.m21067b(this.f31834l);
            m21167b(3);
        }
        if (!z || TextUtils.isEmpty(str)) {
            return;
        }
        SplashReport.m21062a(campaignEx, this.f31832j, str);
    }

    /* renamed from: a */
    public final void m21170a(SplashShowListenerImpl splashShowListenerImpl) {
        this.f31827e = splashShowListenerImpl;
    }

    /* renamed from: a */
    public final void m21179a(int i) {
        this.f31835m = i;
    }

    /* renamed from: a */
    public final void m21177a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.f31843u);
        }
        this.f31831i = viewGroup;
    }

    /* renamed from: a */
    public final SplashBridgeListener m21180a() {
        return this.f31844v;
    }

    /* renamed from: a */
    public final void m21175a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        MBSplashWebview splashWebview;
        m21169a(this.f31829g);
        this.f31825c = campaignEx;
        this.f31826d = mBSplashView;
        SplashJSBridgeImpl splashJSBridgeImpl = mBSplashView.getSplashJSBridgeImpl();
        if (splashJSBridgeImpl == null) {
            splashJSBridgeImpl = new SplashJSBridgeImpl(mBSplashView.getContext(), this.f31833k, this.f31832j);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashJSBridgeImpl.m21030a(arrayList);
        }
        splashJSBridgeImpl.m21028b(this.f31835m);
        splashJSBridgeImpl.m21035a(this.f31829g ? 1 : 0);
        splashJSBridgeImpl.m21033a(this.f31844v);
        mBSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
        boolean isHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.f31831i;
        if (view == null) {
            if (isHasMBTplMark) {
                this.f31830h.setVisibility(8);
            }
            m21150h();
            m21178a(this.f31830h);
            mBSplashView.setCloseView(this.f31830h);
        } else {
            if (isHasMBTplMark) {
                view.setVisibility(8);
            }
            m21178a(this.f31831i);
            mBSplashView.setCloseView(this.f31831i);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.f31825c;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                AbstractC7075b m23471a = OmsdkUtils.m23471a(MBSDKContext.m22865f().m22861j(), splashWebview, splashWebview.getUrl(), this.f31825c);
                if (m23471a != null) {
                    splashWebview.setAdSession(m23471a);
                    m23471a.mo34801g(splashWebview);
                    m23471a.mo34797k();
                    SameLogTool.m21738a("OMSDK", "adSession.start()");
                }
            } catch (Throwable th) {
                SameLogTool.m21738a("OMSDK", th.getMessage());
                CampaignEx campaignEx3 = this.f31825c;
                if (campaignEx3 != null) {
                    String requestId = campaignEx3.getRequestId();
                    String requestIdNotice = this.f31825c.getRequestIdNotice();
                    String id = this.f31825c.getId();
                    ReportController reportController = new ReportController(splashWebview.getContext());
                    String str = this.f31832j;
                    reportController.m22093a(requestId, requestIdNotice, id, str, "fetch OM failed, exception" + th.getMessage());
                }
            }
        }
        ResManager.m21227a(this.f31832j);
        ResManager.m21225b(this.f31825c.getImageUrl());
        this.f31823a.removeMessages(1);
        this.f31823a.sendEmptyMessageDelayed(1, 1000L);
        this.f31823a.sendEmptyMessageDelayed(2, 1000L);
        if (FeedbackManager.m22907a().m22894b() && !this.f31826d.isDynamicView()) {
            FeedbackManager.m22907a().m22897a(this.f31832j, new FeedbackDialogEventListener() { // from class: com.mbridge.msdk.splash.c.d.4
                @Override // com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener
                /* renamed from: a */
                public final void mo20986a() {
                    String str2;
                    SplashShowManager.this.m21156e();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (MBSDKContext.m22865f().m22861j() != null) {
                            jSONObject.put("status", 1);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th2) {
                        SameLogTool.m21735b(SplashShowManager.this.f31824b, th2.getMessage(), th2);
                        str2 = "";
                    }
                    WindVaneCallJs.m21387a().m21385a((WebView) SplashShowManager.this.f31826d.getSplashWebview(), AbsFeedBackForH5.WEBVIEW_EVENT_DIALOG_METHOD_NAME, Base64.encodeToString(str2.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener
                /* renamed from: b */
                public final void mo20984b() {
                    String str2;
                    SplashShowManager.this.m21158d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (MBSDKContext.m22865f().m22861j() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th2) {
                        SameLogTool.m21735b(SplashShowManager.this.f31824b, th2.getMessage(), th2);
                        str2 = "";
                    }
                    WindVaneCallJs.m21387a().m21385a((WebView) SplashShowManager.this.f31826d.getSplashWebview(), AbsFeedBackForH5.WEBVIEW_EVENT_DIALOG_METHOD_NAME, Base64.encodeToString(str2.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.p470b.FeedbackDialogEventListener
                /* renamed from: a */
                public final void mo20985a(String str2) {
                    String str3;
                    SplashShowManager.this.m21158d();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (MBSDKContext.m22865f().m22861j() != null) {
                            jSONObject.put("status", 2);
                        }
                        str3 = jSONObject.toString();
                    } catch (Throwable th2) {
                        SameLogTool.m21735b(SplashShowManager.this.f31824b, th2.getMessage(), th2);
                        str3 = "";
                    }
                    WindVaneCallJs.m21387a().m21385a((WebView) SplashShowManager.this.f31826d.getSplashWebview(), AbsFeedBackForH5.WEBVIEW_EVENT_DIALOG_METHOD_NAME, Base64.encodeToString(str3.getBytes(), 2));
                }
            });
            FeedBackButton m22893b = FeedbackManager.m22907a().m22893b(this.f31832j);
            if (m22893b != null) {
                RelativeLayout.LayoutParams layoutParams = null;
                try {
                    layoutParams = (RelativeLayout.LayoutParams) m22893b.getLayoutParams();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(FeedbackManager.f30243a, FeedbackManager.f30244b);
                }
                layoutParams.topMargin = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 10.0f);
                layoutParams.leftMargin = SameTool.m22001b(MBSDKContext.m22865f().m22861j(), 10.0f);
                ViewGroup viewGroup = (ViewGroup) m22893b.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(m22893b);
                }
                this.f31826d.addView(m22893b, layoutParams);
            }
            this.f31825c.setCampaignUnitId(this.f31832j);
            FeedbackManager.m22907a().m22896a(this.f31832j, this.f31825c);
        }
    }

    /* renamed from: c */
    public final void m21162c() {
        if (this.f31827e != null) {
            this.f31827e = null;
        }
        if (this.f31844v != null) {
            this.f31844v = null;
        }
        if (this.f31843u != null) {
            this.f31843u = null;
        }
        MBSplashView mBSplashView = this.f31826d;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        FeedbackManager.m22907a().m22891c(this.f31832j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m21167b(int i) {
        C11567b c11567b;
        MBSplashWebview splashWebview;
        SplashShowListenerImpl splashShowListenerImpl = this.f31827e;
        if (splashShowListenerImpl != null) {
            splashShowListenerImpl.m21071a(this.f31834l, i);
            this.f31827e = null;
            SplashReport.m21059a(this.f31832j, this.f31825c);
        }
        this.f31841s = false;
        if (this.f31825c != null) {
            c11567b = C11567b.m21293a().m21287b(this.f31832j).m21285d(this.f31825c.getRequestId()).m21282g(this.f31825c.getRequestIdNotice()).m21286c(this.f31825c.getId()).m21284e(this.f31825c.getCreativeId() + "").m21290a(this.f31825c.isBidCampaign());
        } else {
            c11567b = null;
        }
        SplashReport.m21060a(c11567b, this.f31832j, i);
        MBSplashView mBSplashView = this.f31826d;
        if (mBSplashView != null && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        Handler handler = this.f31823a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: b */
    private void m21166b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                CommonClickControl.m23127a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, RetryReportControl.f29981h);
            } catch (Throwable th) {
                SameLogTool.m21733d(this.f31824b, th.getMessage());
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m21163b(SplashShowManager splashShowManager, int i) {
        MBSplashView mBSplashView = splashShowManager.f31826d;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i);
            if (splashShowManager.f31826d.getSplashJSBridgeImpl() != null) {
                splashShowManager.f31826d.getSplashJSBridgeImpl().m21026c(i);
            }
        }
        if (i < 0) {
            splashShowManager.f31835m = i;
            return;
        }
        SplashShowListenerImpl splashShowListenerImpl = splashShowManager.f31827e;
        if (splashShowListenerImpl != null) {
            splashShowListenerImpl.m21069a(splashShowManager.f31834l, i * 1000);
        }
        if (splashShowManager.f31831i == null) {
            splashShowManager.m21150h();
        }
    }

    /* renamed from: a */
    public final void m21169a(boolean z) {
        this.f31829g = z;
        if (z) {
            this.f31836n = this.f31837o;
        } else {
            this.f31836n = this.f31839q;
        }
    }

    /* renamed from: a */
    public final void m21174a(final CampaignEx campaignEx, final boolean z, final String str) {
        MBSplashWebview splashWebview;
        Handler handler;
        if (campaignEx != null) {
            try {
                if (campaignEx.needShowIDialog()) {
                    final MBAlertDialogListener mBAlertDialogListener = new MBAlertDialogListener() { // from class: com.mbridge.msdk.splash.c.d.5
                        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                        /* renamed from: a */
                        public final void mo20509a() {
                            SplashShowManager.this.m21165b(campaignEx, z, str);
                        }

                        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                        /* renamed from: b */
                        public final void mo20508b() {
                            SplashShowManager.this.m21154f();
                        }

                        @Override // com.mbridge.msdk.widget.dialog.MBAlertDialogListener
                        /* renamed from: c */
                        public final void mo20507c() {
                            mo20509a();
                        }
                    };
                    if (this.f31826d != null && CommonClickUtil.m23074a(campaignEx) && campaignEx.needShowIDialog() && !this.f31840r) {
                        if (this.f31828f == null) {
                            this.f31828f = new CommonClickControl(MBSDKContext.m22865f().m22861j(), this.f31832j);
                        }
                        final Context context = this.f31826d.getContext();
                        this.f31826d.post(new Runnable() { // from class: com.mbridge.msdk.splash.c.d.6
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (!SplashShowManager.this.f31828f.m23099b(campaignEx)) {
                                    Context context2 = context;
                                    if (context2 != StubApp.getOrigApplicationContext(context2.getApplicationContext())) {
                                        SecondaryConfirmationManager.m21474a().m21455a("", campaignEx, context, SplashShowManager.this.f31832j, mBAlertDialogListener);
                                        return;
                                    } else {
                                        SecondaryConfirmationManager.m21474a().m21455a("", campaignEx, SplashShowManager.this.f31842t, SplashShowManager.this.f31832j, mBAlertDialogListener);
                                        return;
                                    }
                                }
                                SplashReport.m21066a(MBSDKContext.m22865f().m22861j(), campaignEx);
                                if (SplashShowManager.this.f31827e != null) {
                                    SplashShowManager.this.f31827e.m21067b(SplashShowManager.this.f31834l);
                                    SplashShowManager.this.m21167b(3);
                                }
                            }
                        });
                        this.f31840r = true;
                        if (this.f31835m > 0 && (handler = this.f31823a) != null) {
                            handler.removeMessages(1);
                        }
                        MBSplashView mBSplashView = this.f31826d;
                        if (mBSplashView == null || (splashWebview = mBSplashView.getSplashWebview()) == null || splashWebview.isDestoryed()) {
                            return;
                        }
                        SplashJsUtils.m21011a(splashWebview, "onInstallAlertShow", "");
                        return;
                    }
                }
            } catch (Throwable th) {
                SameLogTool.m21738a(this.f31824b, th.getMessage());
            }
        }
        if (campaignEx != null) {
            m21165b(campaignEx, z, str);
        }
    }

    /* renamed from: a */
    private void m21178a(View view) {
        if (view != null) {
            view.setOnClickListener(this.f31843u);
        }
    }

    /* renamed from: a */
    private void m21176a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                for (String str2 : pv_urls) {
                    CommonClickControl.m23128a(context, campaignEx, str, str2, false, true);
                }
            } catch (Throwable th) {
                SameLogTool.m21733d(this.f31824b, th.getMessage());
            }
        }
    }
}
