package com.beizi.p051ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebView;
import com.beizi.p051ad.RewardedVideoAd;
import com.beizi.p051ad.alipay.model.IncentiveConfig;
import com.beizi.p051ad.internal.p058b.HttpProxyCacheServer;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.SPUtils;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.lance.OnLineImpl;
import com.beizi.p051ad.lance.OnLineState;
import com.beizi.p051ad.lance.p062a.C3019b;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.ad.internal.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiImpl {

    /* renamed from: G */
    private static boolean f10117G = false;

    /* renamed from: H */
    private static boolean f10118H = false;

    /* renamed from: f */
    public static String f10119f = null;

    /* renamed from: g */
    public static String f10120g = "";

    /* renamed from: h */
    public static String f10121h = "";

    /* renamed from: l */
    private static String f10122l = "USED_AD_UNIT_IDS_KEY";

    /* renamed from: m */
    private static BeiZiImpl f10123m = null;

    /* renamed from: n */
    private static String f10124n = "BeiZiImpl";

    /* renamed from: p */
    private static String f10125p;

    /* renamed from: A */
    private boolean f10126A;

    /* renamed from: B */
    private RewardedVideoAd f10127B;

    /* renamed from: C */
    private DisplayMetrics f10128C;

    /* renamed from: F */
    private HttpProxyCacheServer f10131F;

    /* renamed from: i */
    public Context f10139i;

    /* renamed from: j */
    public float f10140j;

    /* renamed from: k */
    public float f10141k;

    /* renamed from: o */
    private IncentiveConfig f10142o;

    /* renamed from: z */
    private float f10152z;

    /* renamed from: a */
    public boolean f10134a = false;

    /* renamed from: b */
    public String f10135b = null;

    /* renamed from: c */
    public boolean f10136c = false;

    /* renamed from: d */
    public String f10137d = "";

    /* renamed from: e */
    public HashMap<String, String> f10138e = new HashMap<>();

    /* renamed from: q */
    private HashSet<String> f10143q = new HashSet<>();

    /* renamed from: r */
    private HashSet<String> f10144r = new HashSet<>();

    /* renamed from: s */
    private HashSet<String> f10145s = new HashSet<>();

    /* renamed from: t */
    private HashSet<String> f10146t = new HashSet<>();

    /* renamed from: u */
    private HashSet<String> f10147u = new HashSet<>();

    /* renamed from: v */
    private HashSet<String> f10148v = new HashSet<>();

    /* renamed from: w */
    private Handler f10149w = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    };

    /* renamed from: x */
    private Handler f10150x = null;

    /* renamed from: y */
    private HandlerThread f10151y = null;

    /* renamed from: D */
    private boolean f10129D = false;

    /* renamed from: E */
    private boolean f10130E = false;

    /* renamed from: I */
    private int f10132I = 0;

    /* renamed from: J */
    private List<AdClickReportListener> f10133J = new ArrayList();

    /* compiled from: BeiZiImpl.java */
    /* renamed from: com.beizi.ad.internal.h$4 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C28874 {

        /* renamed from: a */
        static final /* synthetic */ int[] f10156a;

        static {
            int[] iArr = new int[EnumC2888k.values().length];
            f10156a = iArr;
            try {
                iArr[EnumC2888k.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10156a[EnumC2888k.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10156a[EnumC2888k.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10156a[EnumC2888k.NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10156a[EnumC2888k.REWARDEDVIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m49487a(BeiZiImpl beiZiImpl) {
        int i = beiZiImpl.f10132I;
        beiZiImpl.f10132I = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m49476c(BeiZiImpl beiZiImpl) {
        int i = beiZiImpl.f10132I;
        beiZiImpl.f10132I = i - 1;
        return i;
    }

    /* renamed from: p */
    private HttpProxyCacheServer m49462p() {
        Context context = this.f10139i;
        if (context == null) {
            return null;
        }
        return new HttpProxyCacheServer.C2867a(context).m49592a(52428800L).m49593a();
    }

    /* renamed from: q */
    private void m49461q() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m49483a(String str, boolean z) {
    }

    /* renamed from: e */
    public Context m49473e() {
        return this.f10139i;
    }

    /* renamed from: f */
    public String m49472f() {
        String m49089a = C3019b.m49089a("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        return TextUtils.isEmpty(m49089a) ? "" : this.f10134a ? m49089a.replace("http:", "https:") : m49089a;
    }

    /* renamed from: g */
    public String m49471g() {
        if (!TextUtils.isEmpty(f10125p)) {
            return f10125p;
        }
        String m49089a = C3019b.m49089a("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        return TextUtils.isEmpty(m49089a) ? "" : this.f10134a ? m49089a.replace("http:", "https:") : m49089a;
    }

    /* renamed from: h */
    public float m49470h() {
        return this.f10140j;
    }

    /* renamed from: i */
    public float m49469i() {
        return this.f10141k;
    }

    /* renamed from: j */
    public float m49468j() {
        return Math.max(this.f10140j, this.f10141k);
    }

    /* renamed from: k */
    public DisplayMetrics m49467k() {
        return this.f10128C;
    }

    /* renamed from: l */
    public HashSet<String> m49466l() {
        return this.f10148v;
    }

    /* renamed from: m */
    public String m49465m() {
        if (TextUtils.isEmpty(this.f10135b)) {
            return m49472f() + "/mb/sdk0/json";
        }
        return this.f10135b;
    }

    /* renamed from: n */
    public IncentiveConfig m49464n() {
        return this.f10142o;
    }

    /* renamed from: o */
    public void m49463o() {
        try {
            ((Application) StubApp.getOrigApplicationContext(this.f10139i.getApplicationContext())).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.beizi.ad.internal.h.3
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Log.e("openDeeplink", "count:" + BeiZiImpl.this.f10132I + ";onActivityDestroyed" + activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    BeiZiImpl.this.f10133J.clear();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    BeiZiImpl.m49487a(BeiZiImpl.this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        BeiZiImpl.m49476c(BeiZiImpl.this);
                        if (BeiZiImpl.this.f10132I < 0) {
                            BeiZiImpl.this.f10132I = 0;
                        }
                        if (BeiZiImpl.this.f10132I != 0 || BeiZiImpl.this.f10133J == null || BeiZiImpl.this.f10133J.size() <= 0) {
                            return;
                        }
                        Iterator it = BeiZiImpl.this.f10133J.iterator();
                        while (it.hasNext()) {
                            AdClickReportListener adClickReportListener = (AdClickReportListener) it.next();
                            if (adClickReportListener != null) {
                                adClickReportListener.onReport();
                            }
                            it.remove();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public HttpProxyCacheServer m49480b() {
        if (this.f10139i == null) {
            return null;
        }
        HttpProxyCacheServer httpProxyCacheServer = this.f10131F;
        if (httpProxyCacheServer == null) {
            HttpProxyCacheServer m49462p = m49462p();
            this.f10131F = m49462p;
            return m49462p;
        }
        return httpProxyCacheServer;
    }

    /* renamed from: c */
    public Handler m49477c() {
        if (this.f10150x == null) {
            if (this.f10151y == null) {
                HandlerThread handlerThread = new HandlerThread("BackgroundHandler");
                this.f10151y = handlerThread;
                handlerThread.start();
            }
            this.f10150x = new Handler(this.f10151y.getLooper());
        }
        return this.f10150x;
    }

    /* renamed from: d */
    public String m49475d() {
        return f10119f;
    }

    /* renamed from: a */
    public BeiZiImpl m49484a(String str) {
        f10125p = str;
        return f10123m;
    }

    /* renamed from: b */
    public void m49478b(String str) {
        this.f10135b = str;
    }

    /* renamed from: a */
    public static BeiZiImpl m49492a() {
        BeiZiImpl beiZiImpl;
        synchronized (BeiZiImpl.class) {
            if (f10123m == null) {
                f10123m = new BeiZiImpl();
            }
            beiZiImpl = f10123m;
        }
        return beiZiImpl;
    }

    /* renamed from: a */
    public void m49489a(Context context, String str) {
        synchronized (BeiZiImpl.class) {
            try {
                if (context != null) {
                    Log.i("lance", "SDK_VERSION:3.5.0.5");
                    this.f10139i = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    try {
                        HaoboLog.setErrorContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                        f10119f = str;
                        m49463o();
                        String string = SPUtils.getString(this.f10139i, TTDownloadField.TT_USERAGENT);
                        if (!TextUtils.isEmpty(string)) {
                            m49492a().f10137d = string;
                        } else {
                            WebView webView = new WebView(context);
                            int i = Build.VERSION.SDK_INT;
                            if (i < 19) {
                                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                                webView.removeJavascriptInterface("accessibility");
                                webView.removeJavascriptInterface("accessibilityTraversal");
                            }
                            if (i >= 19) {
                                WebView.setWebContentsDebuggingEnabled(false);
                            }
                            webView.getSettings().setSavePassword(false);
                            m49492a().f10137d = webView.getSettings().getUserAgentString();
                            if (!TextUtils.isEmpty(m49492a().f10137d)) {
                                SPUtils.put(this.f10139i, TTDownloadField.TT_USERAGENT, m49492a().f10137d);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        m49492a().f10137d = "";
                    }
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    this.f10128C = displayMetrics;
                    int i2 = displayMetrics.widthPixels;
                    int i3 = displayMetrics.heightPixels;
                    if (i2 < i3) {
                        this.f10140j = i2 / 720.0f;
                        this.f10141k = i3 / 1280.0f;
                    } else {
                        this.f10140j = i3 / 720.0f;
                        this.f10141k = i2 / 1280.0f;
                    }
                    if (!this.f10130E) {
                        OnLineState.m49019a(this.f10139i).m49018a(new OnLineImpl() { // from class: com.beizi.ad.internal.h.2
                            @Override // com.beizi.p051ad.lance.OnLineImpl
                            /* renamed from: a */
                            public void mo49092a(long j, long j2) {
                                LogUtil.m49046a("lance", "在线时长:" + (j2 - j));
                                SPUtils.put(BeiZiImpl.this.f10139i, AnalyticsConfig.RTD_START_TIME, Long.valueOf(j));
                                SPUtils.put(BeiZiImpl.this.f10139i, "endTime", Long.valueOf(j2));
                            }

                            @Override // com.beizi.p051ad.lance.OnLineImpl
                            /* renamed from: a */
                            public void mo49093a() {
                                LogUtil.m49046a("lance", "上报活跃量");
                            }
                        });
                    }
                    this.f10130E = true;
                    if (Build.VERSION.SDK_INT >= 28) {
                        m49461q();
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: a */
    public RewardedVideoAd m49490a(Context context) {
        RewardedVideoAdImpl rewardedVideoAdImpl;
        synchronized (BeiZiImpl.class) {
            rewardedVideoAdImpl = new RewardedVideoAdImpl(context);
            this.f10127B = rewardedVideoAdImpl;
        }
        return rewardedVideoAdImpl;
    }

    /* renamed from: a */
    public void m49491a(float f) {
        Validator.m49295a(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        Validator.m49296a(f10119f, (Object) "BeiZi.initialize() must be called prior to setting the app volume.");
        this.f10152z = f;
    }

    /* renamed from: a */
    public void m49481a(boolean z) {
        Validator.m49296a(f10119f, (Object) "BeiZi.initialize() must be called prior to setting the app volume.");
        this.f10126A = z;
    }

    /* renamed from: a */
    public void m49485a(EnumC2888k enumC2888k, String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        int i = C28874.f10156a[enumC2888k.ordinal()];
        if (i == 1) {
            this.f10143q.add(str);
        } else if (i == 2) {
            this.f10144r.add(str);
        } else if (i == 3) {
            this.f10145s.add(str);
        } else if (i == 4) {
            this.f10146t.add(str);
        } else if (i != 5) {
        } else {
            this.f10147u.add(str);
        }
    }

    /* renamed from: a */
    public void m49482a(Map<String, String> map) {
        this.f10142o = new IncentiveConfig();
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("configVersion".equals(entry.getKey())) {
                this.f10142o.setConfigVersion(entry.getValue());
            }
            if ("macro".equals(entry.getKey())) {
                this.f10142o.setMacro(entry.getValue());
            }
            if ("rtaUrl".equals(entry.getKey())) {
                this.f10142o.setRtaUrl(entry.getValue());
            }
            if ("userInfoUrl".equals(entry.getKey())) {
                this.f10142o.setUserInfoUrl(entry.getValue());
            }
            if ("authUrl".equals(entry.getKey())) {
                this.f10142o.setAuthUrl(entry.getValue());
            }
            if ("transferUrl".equals(entry.getKey())) {
                this.f10142o.setTransferUrl(entry.getValue());
            }
            if ("appId".equals(entry.getKey())) {
                this.f10142o.setAppId(entry.getValue());
            }
        }
    }

    /* renamed from: a */
    public void m49488a(AdClickReportListener adClickReportListener) {
        this.f10133J.add(adClickReportListener);
    }
}
