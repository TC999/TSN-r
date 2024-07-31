package com.mbridge.msdk.splash.p505d;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.ViewUtil;
import com.mbridge.msdk.mbjscommon.webEnvCheck.MBWebViewChecker;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.SettingRequestController;
import com.mbridge.msdk.p457c.UnitSetting;
import com.mbridge.msdk.splash.p504c.ResManager;
import com.mbridge.msdk.splash.p504c.SplashLoadManager;
import com.mbridge.msdk.splash.p504c.SplashShowManager;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.splash.view.SplashWebViewClient;

/* renamed from: com.mbridge.msdk.splash.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SplashProvider {

    /* renamed from: b */
    private static String f31880b = "SplashProvider";

    /* renamed from: A */
    private Activity f31881A;

    /* renamed from: B */
    private boolean f31882B;

    /* renamed from: C */
    private CampaignEx f31883C;

    /* renamed from: D */
    private MBSplashPopView f31884D;

    /* renamed from: c */
    private String f31887c;

    /* renamed from: d */
    private String f31888d;

    /* renamed from: e */
    private MBridgeIds f31889e;

    /* renamed from: g */
    private long f31891g;

    /* renamed from: h */
    private SplashLoadManager f31892h;

    /* renamed from: i */
    private SplashShowManager f31893i;

    /* renamed from: j */
    private SplashLoadListenerImpl f31894j;

    /* renamed from: k */
    private MBSplashShowListener f31895k;

    /* renamed from: l */
    private SplashShowListenerImpl f31896l;

    /* renamed from: m */
    private MBSplashView f31897m;

    /* renamed from: n */
    private MBSplashWebview f31898n;

    /* renamed from: o */
    private ViewGroup f31899o;

    /* renamed from: p */
    private View f31900p;

    /* renamed from: q */
    private UnitSetting f31901q;

    /* renamed from: r */
    private boolean f31902r;

    /* renamed from: s */
    private ViewGroup f31903s;

    /* renamed from: t */
    private SettingRequestController f31904t;

    /* renamed from: u */
    private boolean f31905u;

    /* renamed from: f */
    private int f31890f = 5;

    /* renamed from: v */
    private int f31906v = 1;

    /* renamed from: w */
    private int f31907w = SameDiTool.m21765x(MBSDKContext.m22865f().m22861j());

    /* renamed from: x */
    private int f31908x = SameDiTool.m21763y(MBSDKContext.m22865f().m22861j());

    /* renamed from: y */
    private Object f31909y = new Object();

    /* renamed from: z */
    private Object f31910z = new Object();

    /* renamed from: a */
    public boolean f31886a = false;

    /* renamed from: E */
    private boolean f31885E = false;

    public SplashProvider(Activity activity, String str, String str2) {
        this.f31888d = str;
        this.f31887c = str2;
        this.f31889e = new MBridgeIds(str, str2);
        this.f31881A = activity;
        if (this.f31893i == null) {
            if (activity != null) {
                this.f31893i = new SplashShowManager(activity, this.f31888d, this.f31887c);
            } else {
                this.f31893i = new SplashShowManager(MBSDKContext.m22865f().m22861j(), this.f31888d, this.f31887c);
            }
        }
        if (this.f31898n == null) {
            try {
                if (activity != null) {
                    this.f31898n = new MBSplashWebview(activity);
                } else {
                    this.f31898n = new MBSplashWebview(MBSDKContext.m22865f().m22861j());
                }
            } catch (Exception unused) {
            }
            MBSplashWebview mBSplashWebview = this.f31898n;
            if (mBSplashWebview != null) {
                mBSplashWebview.setWebViewClient(new SplashWebViewClient(this.f31887c, this.f31893i.m21180a()));
            }
        }
        if (this.f31897m == null) {
            if (activity != null) {
                this.f31897m = new MBSplashView(activity);
            } else {
                this.f31897m = new MBSplashView(MBSDKContext.m22865f().m22861j());
            }
            this.f31897m.setSplashWebview(this.f31898n);
        }
        if (this.f31904t == null) {
            this.f31904t = new SettingRequestController();
        }
        this.f31904t.m23215a(MBSDKContext.m22865f().m22861j(), MBSDKContext.m22865f().m22860k(), MBSDKContext.m22865f().m22859l(), this.f31887c);
    }

    /* renamed from: b */
    public final long m21093b() {
        return this.f31891g;
    }

    /* renamed from: c */
    public final boolean m21086c() {
        return this.f31905u;
    }

    /* renamed from: d */
    public final int m21082d() {
        return this.f31890f;
    }

    /* renamed from: e */
    public final String m21079e() {
        if (!this.f31886a) {
            SplashLoadManager splashLoadManager = this.f31892h;
            return splashLoadManager != null ? splashLoadManager.m21223a() : "";
        }
        SplashShowManager splashShowManager = this.f31893i;
        return splashShowManager != null ? splashShowManager.m21168b() : "";
    }

    /* renamed from: f */
    public final void m21078f() {
        this.f31885E = true;
        MBSplashPopView mBSplashPopView = this.f31884D;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    /* renamed from: g */
    public final void m21077g() {
        this.f31885E = false;
        MBSplashShowListener mBSplashShowListener = this.f31895k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.f31888d, this.f31887c));
        }
        MBSplashPopView mBSplashPopView = this.f31884D;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }

    /* renamed from: h */
    public final void m21076h() {
        SplashShowManager splashShowManager = this.f31893i;
        if (splashShowManager != null) {
            splashShowManager.m21158d();
        }
        MBSplashPopView mBSplashPopView = this.f31884D;
        if (mBSplashPopView == null || !this.f31885E) {
            return;
        }
        mBSplashPopView.reStartCountDown();
    }

    /* renamed from: i */
    public final void m21075i() {
        SplashShowManager splashShowManager = this.f31893i;
        if (splashShowManager != null) {
            splashShowManager.m21156e();
        }
        MBSplashPopView mBSplashPopView = this.f31884D;
        if (mBSplashPopView == null || !this.f31885E) {
            return;
        }
        mBSplashPopView.pauseCountDown();
    }

    /* renamed from: j */
    public final void m21074j() {
        this.f31883C = null;
        if (this.f31895k != null) {
            this.f31895k = null;
        }
        if (this.f31894j != null) {
            this.f31894j = null;
        }
        if (this.f31896l != null) {
            this.f31896l = null;
        }
        SplashLoadManager splashLoadManager = this.f31892h;
        if (splashLoadManager != null) {
            splashLoadManager.m21201b();
        }
        SplashShowManager splashShowManager = this.f31893i;
        if (splashShowManager != null) {
            splashShowManager.m21162c();
        }
        if (this.f31881A != null) {
            this.f31881A = null;
        }
    }

    /* renamed from: a */
    public final void m21103a(ViewGroup viewGroup) {
        this.f31903s = viewGroup;
    }

    /* renamed from: b */
    public final void m21089b(String str) {
        m21096a(str, 1);
    }

    /* renamed from: c */
    public final boolean m21085c(String str) {
        return ResManager.m21228a(this.f31897m, this.f31888d, this.f31887c, str, this.f31905u, this.f31890f, false, true) != null;
    }

    /* renamed from: d */
    public final void m21081d(String str, ViewGroup viewGroup) {
        this.f31899o = viewGroup;
        MBSplashView mBSplashView = this.f31897m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx m21228a = ResManager.m21228a(this.f31897m, this.f31888d, this.f31887c, str, this.f31905u, this.f31890f, true, false);
        if (m21228a != null) {
            if (this.f31901q == null) {
                this.f31901q = SettingManager.m23261a().m23248c(MBSDKContext.m22865f().m22860k(), this.f31887c);
            }
            this.f31896l = new SplashShowListenerImpl(this, this.f31895k, this.f31901q.m23195e(), m21228a);
            SameLogTool.m21738a(f31880b, "show start");
            if (this.f31907w != 0 && this.f31908x != 0) {
                int i = this.f31890f;
                if (i >= 2 && i <= 10) {
                    m21102a(m21228a, this.f31901q.m23182o(), false);
                    return;
                }
                SplashShowListenerImpl splashShowListenerImpl = this.f31896l;
                if (splashShowListenerImpl != null) {
                    MBridgeIds mBridgeIds = this.f31889e;
                    splashShowListenerImpl.m21068a(mBridgeIds, "countDownTime must in 2 - 10 ,but now is " + this.f31890f);
                    return;
                }
                return;
            }
            SplashShowListenerImpl splashShowListenerImpl2 = this.f31896l;
            if (splashShowListenerImpl2 != null) {
                splashShowListenerImpl2.m21068a(this.f31889e, "width or height is 0  or width or height is too small");
                return;
            }
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f31895k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f31889e, "campaignEx is vali");
        }
    }

    /* renamed from: a */
    public final boolean m21108a() {
        return this.f31902r;
    }

    /* renamed from: b */
    public final void m21088b(String str, ViewGroup viewGroup) {
        this.f31899o = viewGroup;
        MBSplashView mBSplashView = this.f31897m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        m21096a(str, 2);
    }

    /* renamed from: c */
    public final void m21084c(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            MBSplashShowListener mBSplashShowListener = this.f31895k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.f31889e, "token is null or empty");
                return;
            }
            return;
        }
        m21081d(str, viewGroup);
    }

    /* renamed from: a */
    public final void m21094a(boolean z) {
        this.f31902r = z;
    }

    /* renamed from: a */
    public final void m21107a(int i) {
        this.f31906v = i;
    }

    /* renamed from: a */
    public final void m21105a(long j) {
        this.f31891g = j;
    }

    /* renamed from: a */
    public final void m21101a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.f31894j == null) {
            this.f31894j = new SplashLoadListenerImpl(this, this.f31889e);
        }
        this.f31894j.m21111a(mBSplashLoadListener);
    }

    /* renamed from: b */
    public final void m21087b(boolean z) {
        this.f31905u = z;
    }

    /* renamed from: c */
    public final void m21083c(boolean z) {
        this.f31882B = z;
    }

    /* renamed from: b */
    public final void m21092b(int i) {
        this.f31890f = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m21090b(final CampaignEx campaignEx, final int i, final boolean z) {
        if (!ResManager.m21233a(this.f31897m, campaignEx)) {
            if (i > 0) {
                this.f31893i.f31823a.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashProvider.this.m21090b(campaignEx, i - 1, z);
                    }
                }, 1L);
                return;
            }
            SplashShowListenerImpl splashShowListenerImpl = this.f31896l;
            if (splashShowListenerImpl != null) {
                splashShowListenerImpl.m21068a(this.f31889e, "campaignEx is not ready");
                return;
            }
            return;
        }
        m21080d(true);
        ViewGroup.LayoutParams layoutParams = this.f31899o.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f31899o.setLayoutParams(layoutParams);
        this.f31899o.removeAllViews();
        this.f31893i.m21179a(this.f31890f);
        this.f31893i.m21177a(this.f31903s);
        this.f31893i.m21170a(this.f31896l);
        SameLogTool.m21733d(f31880b, "start show process");
        ViewGroup viewGroup = this.f31899o;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ViewUtil.m21933a(this.f31897m);
            this.f31899o.addView(this.f31897m);
        }
        this.f31893i.m21169a(this.f31905u);
        this.f31893i.m21175a(campaignEx, this.f31897m);
    }

    /* renamed from: a */
    public final void m21100a(MBSplashShowListener mBSplashShowListener) {
        this.f31895k = mBSplashShowListener;
    }

    /* renamed from: a */
    public final void m21097a(String str) {
        if (TextUtils.isEmpty(str)) {
            SplashLoadListenerImpl splashLoadListenerImpl = this.f31894j;
            if (splashLoadListenerImpl != null) {
                splashLoadListenerImpl.mo21109a("token is null or empty", 1);
                return;
            }
            return;
        }
        m21096a(str, 1);
    }

    /* renamed from: a */
    public final void m21095a(String str, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str)) {
            SplashLoadListenerImpl splashLoadListenerImpl = this.f31894j;
            if (splashLoadListenerImpl != null) {
                splashLoadListenerImpl.mo21109a("token is null or empty", 1);
                return;
            }
            return;
        }
        m21088b(str, viewGroup);
    }

    /* renamed from: a */
    public final void m21106a(int i, int i2) {
        m21091b(i2, i);
    }

    /* renamed from: d */
    public final void m21080d(final boolean z) {
        MBSplashWebview mBSplashWebview = this.f31898n;
        if (mBSplashWebview != null) {
            mBSplashWebview.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.d.c.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z;
                }
            });
        }
        MBSplashView mBSplashView = this.f31897m;
        if (mBSplashView != null) {
            mBSplashView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.splash.d.c.3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m21102a(CampaignEx campaignEx, int i, boolean z) {
        if (campaignEx != null && z) {
            if (this.f31901q == null) {
                this.f31901q = SettingManager.m23261a().m23248c(MBSDKContext.m22865f().m22860k(), this.f31887c);
            }
            this.f31896l = new SplashShowListenerImpl(this, this.f31895k, this.f31901q.m23195e(), campaignEx);
        }
        this.f31883C = campaignEx;
        ViewGroup viewGroup = this.f31899o;
        if (viewGroup == null) {
            SplashShowListenerImpl splashShowListenerImpl = this.f31896l;
            if (splashShowListenerImpl != null) {
                splashShowListenerImpl.m21068a(this.f31889e, "container is null");
                return;
            }
            return;
        }
        if (this.f31893i == null) {
            this.f31893i = new SplashShowManager(viewGroup.getContext(), this.f31888d, this.f31887c);
        }
        m21090b(campaignEx, i, z);
    }

    /* renamed from: a */
    private void m21096a(String str, int i) {
        synchronized (this.f31909y) {
            if (this.f31902r) {
                SplashLoadListenerImpl splashLoadListenerImpl = this.f31894j;
                if (splashLoadListenerImpl != null) {
                    splashLoadListenerImpl.mo21109a("current unit is loading", i);
                    this.f31902r = true;
                }
                return;
            }
            this.f31902r = true;
            int i2 = this.f31890f;
            if (i2 >= 2 && i2 <= 10) {
                if (this.f31907w != 0 && this.f31908x != 0) {
                    boolean z = false;
                    try {
                        z = MBWebViewChecker.m21406a(MBSDKContext.m22865f().m22861j());
                    } catch (Exception unused) {
                    }
                    if (!z) {
                        SplashLoadListenerImpl splashLoadListenerImpl2 = this.f31894j;
                        if (splashLoadListenerImpl2 != null) {
                            splashLoadListenerImpl2.mo21109a("WebView is not available", i);
                            return;
                        }
                        return;
                    }
                    this.f31897m.clearResState();
                    this.f31901q = SettingManager.m23261a().m23248c(MBSDKContext.m22865f().m22860k(), this.f31887c);
                    if (this.f31892h == null) {
                        this.f31892h = new SplashLoadManager(this.f31888d, this.f31887c, this.f31891g * 1000);
                    }
                    SplashLoadListenerImpl splashLoadListenerImpl3 = this.f31894j;
                    if (splashLoadListenerImpl3 != null) {
                        splashLoadListenerImpl3.m21110a(str);
                        this.f31892h.m21215a(this.f31894j);
                    }
                    this.f31897m.resetLoadState();
                    this.f31892h.m21222a(this.f31890f);
                    this.f31892h.m21207a(this.f31897m);
                    this.f31892h.m21217a(this.f31901q);
                    this.f31892h.m21221a(this.f31907w, this.f31908x);
                    this.f31892h.m21202a(this.f31905u);
                    this.f31892h.m21200b(this.f31906v);
                    this.f31892h.m21206a(str, i);
                    return;
                }
                SplashLoadListenerImpl splashLoadListenerImpl4 = this.f31894j;
                if (splashLoadListenerImpl4 != null) {
                    splashLoadListenerImpl4.mo21109a("width or height is 0  or width or height is too small", i);
                    return;
                }
                return;
            }
            SplashLoadListenerImpl splashLoadListenerImpl5 = this.f31894j;
            if (splashLoadListenerImpl5 != null) {
                splashLoadListenerImpl5.mo21109a("countDownTime must in 2 - 10 ,but now is " + this.f31890f, i);
            }
        }
    }

    /* renamed from: b */
    private void m21091b(int i, int i2) {
        int m21765x = SameDiTool.m21765x(MBSDKContext.m22865f().m22861j());
        int m21763y = SameDiTool.m21763y(MBSDKContext.m22865f().m22861j());
        int i3 = this.f31906v;
        if (i3 == 1) {
            if (m21763y >= i2 * 4) {
                this.f31908x = m21763y - i2;
                this.f31907w = m21765x;
                return;
            }
            this.f31908x = 0;
            this.f31907w = 0;
        } else if (i3 == 2) {
            if (m21765x >= i * 4) {
                this.f31907w = m21765x - i;
                this.f31908x = m21763y;
                return;
            }
            this.f31908x = 0;
            this.f31907w = 0;
        }
    }

    /* renamed from: a */
    public final void m21104a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f31900p = view;
        if (view != null) {
            m21091b(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.f31897m;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    /* renamed from: a */
    public final ViewGroup m21099a(ZoomOutTypeEnum zoomOutTypeEnum) {
        MBSplashPopView mBSplashPopView = new MBSplashPopView(MBSDKContext.m22865f().m22861j(), new MBSplashPopView.C11633a(this.f31888d, this.f31887c, zoomOutTypeEnum.getIndex(), this.f31883C), this.f31896l);
        this.f31884D = mBSplashPopView;
        return mBSplashPopView;
    }
}
