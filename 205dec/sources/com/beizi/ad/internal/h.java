package com.beizi.ad.internal;

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
import com.beizi.ad.RewardedVideoAd;
import com.beizi.ad.internal.b.f;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.SPUtils;
import com.beizi.ad.internal.utilities.StringUtil;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BeiZiImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h {
    private static boolean G = false;
    private static boolean H = false;

    /* renamed from: g  reason: collision with root package name */
    public static String f13795g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f13796h = "";

    /* renamed from: i  reason: collision with root package name */
    public static String f13797i = "";

    /* renamed from: m  reason: collision with root package name */
    private static String f13798m = "USED_AD_UNIT_IDS_KEY";

    /* renamed from: n  reason: collision with root package name */
    private static h f13799n = null;

    /* renamed from: o  reason: collision with root package name */
    private static String f13800o = "BeiZiImpl";

    /* renamed from: p  reason: collision with root package name */
    private static String f13801p;
    private boolean A;
    private RewardedVideoAd B;
    private DisplayMetrics C;
    private com.beizi.ad.internal.b.f F;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f13804c;

    /* renamed from: j  reason: collision with root package name */
    public Context f13808j;

    /* renamed from: k  reason: collision with root package name */
    public float f13809k;

    /* renamed from: l  reason: collision with root package name */
    public float f13810l;

    /* renamed from: z  reason: collision with root package name */
    private float f13820z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13802a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f13803b = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13805d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f13806e = "";

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f13807f = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    private HashSet<String> f13811q = new HashSet<>();

    /* renamed from: r  reason: collision with root package name */
    private HashSet<String> f13812r = new HashSet<>();

    /* renamed from: s  reason: collision with root package name */
    private HashSet<String> f13813s = new HashSet<>();

    /* renamed from: t  reason: collision with root package name */
    private HashSet<String> f13814t = new HashSet<>();

    /* renamed from: u  reason: collision with root package name */
    private HashSet<String> f13815u = new HashSet<>();

    /* renamed from: v  reason: collision with root package name */
    private HashSet<String> f13816v = new HashSet<>();

    /* renamed from: w  reason: collision with root package name */
    private Handler f13817w = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i4 = message.what;
        }
    };

    /* renamed from: x  reason: collision with root package name */
    private Handler f13818x = null;

    /* renamed from: y  reason: collision with root package name */
    private HandlerThread f13819y = null;
    private boolean D = false;
    private boolean E = false;
    private int I = 0;
    private List<b> J = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BeiZiImpl.java */
    /* renamed from: com.beizi.ad.internal.h$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13824a;

        static {
            int[] iArr = new int[k.values().length];
            f13824a = iArr;
            try {
                iArr[k.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13824a[k.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13824a[k.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13824a[k.NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13824a[k.REWARDEDVIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static /* synthetic */ int a(h hVar) {
        int i4 = hVar.I;
        hVar.I = i4 + 1;
        return i4;
    }

    static /* synthetic */ int c(h hVar) {
        int i4 = hVar.I;
        hVar.I = i4 - 1;
        return i4;
    }

    private com.beizi.ad.internal.b.f p() {
        Context context = this.f13808j;
        if (context == null) {
            return null;
        }
        return new f.a(context).a(52428800L).a();
    }

    private void q() {
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
        } catch (Exception e4) {
            e4.printStackTrace();
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
        } catch (Exception e5) {
            e5.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, boolean z3) {
    }

    public Context e() {
        return this.f13808j;
    }

    public String f() {
        String a4 = com.beizi.ad.lance.a.b.a("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        return TextUtils.isEmpty(a4) ? "" : this.f13802a ? a4.replace("http:", "https:") : a4;
    }

    public String g() {
        if (!TextUtils.isEmpty(f13801p)) {
            return f13801p;
        }
        String a4 = com.beizi.ad.lance.a.b.a("aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAw");
        return TextUtils.isEmpty(a4) ? "" : this.f13802a ? a4.replace("http:", "https:") : a4;
    }

    public float h() {
        return this.f13809k;
    }

    public float i() {
        return this.f13810l;
    }

    public float j() {
        return Math.max(this.f13809k, this.f13810l);
    }

    public DisplayMetrics k() {
        return this.C;
    }

    public HashSet<String> l() {
        return this.f13816v;
    }

    public String m() {
        if (TextUtils.isEmpty(this.f13803b)) {
            return f() + "/mb/sdk0/json";
        }
        return this.f13803b;
    }

    public void n() {
        try {
            ((Application) StubApp.getOrigApplicationContext(this.f13808j.getApplicationContext())).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.beizi.ad.internal.h.3
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Log.e("openDeeplink", "count:" + h.this.I + ";onActivityDestroyed" + activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    h.this.J.clear();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    h.a(h.this);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    try {
                        h.c(h.this);
                        if (h.this.I < 0) {
                            h.this.I = 0;
                        }
                        if (h.this.I != 0 || h.this.J == null || h.this.J.size() <= 0) {
                            return;
                        }
                        Iterator it = h.this.J.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar != null) {
                                bVar.onReport();
                            }
                            it.remove();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public List<String> o() {
        return this.f13804c;
    }

    public com.beizi.ad.internal.b.f b() {
        if (this.f13808j == null) {
            return null;
        }
        com.beizi.ad.internal.b.f fVar = this.F;
        if (fVar == null) {
            com.beizi.ad.internal.b.f p3 = p();
            this.F = p3;
            return p3;
        }
        return fVar;
    }

    public Handler c() {
        if (this.f13818x == null) {
            if (this.f13819y == null) {
                HandlerThread handlerThread = new HandlerThread("BackgroundHandler");
                this.f13819y = handlerThread;
                handlerThread.start();
            }
            this.f13818x = new Handler(this.f13819y.getLooper());
        }
        return this.f13818x;
    }

    public String d() {
        return f13795g;
    }

    public h a(String str) {
        f13801p = str;
        return f13799n;
    }

    public void b(String str) {
        this.f13803b = str;
    }

    public static h a() {
        h hVar;
        synchronized (h.class) {
            if (f13799n == null) {
                f13799n = new h();
            }
            hVar = f13799n;
        }
        return hVar;
    }

    public void a(Context context, String str) {
        synchronized (h.class) {
            try {
                if (context != null) {
                    Log.i("lance", "SDK_VERSION:3.5.0.11");
                    this.f13808j = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    try {
                        HaoboLog.setErrorContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                        f13795g = str;
                        n();
                        String string = SPUtils.getString(this.f13808j, "userAgent");
                        if (!TextUtils.isEmpty(string)) {
                            a().f13806e = string;
                        } else {
                            WebView webView = new WebView(context);
                            int i4 = Build.VERSION.SDK_INT;
                            if (i4 < 19) {
                                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                                webView.removeJavascriptInterface("accessibility");
                                webView.removeJavascriptInterface("accessibilityTraversal");
                            }
                            if (i4 >= 19) {
                                WebView.setWebContentsDebuggingEnabled(false);
                            }
                            webView.getSettings().setSavePassword(false);
                            a().f13806e = webView.getSettings().getUserAgentString();
                            if (!TextUtils.isEmpty(a().f13806e)) {
                                SPUtils.put(this.f13808j, "userAgent", a().f13806e);
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        a().f13806e = "";
                    }
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    this.C = displayMetrics;
                    int i5 = displayMetrics.widthPixels;
                    int i6 = displayMetrics.heightPixels;
                    if (i5 < i6) {
                        this.f13809k = i5 / 720.0f;
                        this.f13810l = i6 / 1280.0f;
                    } else {
                        this.f13809k = i6 / 720.0f;
                        this.f13810l = i5 / 1280.0f;
                    }
                    if (!this.E) {
                        com.beizi.ad.lance.b.a(this.f13808j).a(new com.beizi.ad.lance.a() { // from class: com.beizi.ad.internal.h.2
                            @Override // com.beizi.ad.lance.a
                            public void a(long j4, long j5) {
                                com.beizi.ad.lance.a.l.a("lance", "\u5728\u7ebf\u65f6\u957f:" + (j5 - j4));
                                SPUtils.put(h.this.f13808j, "startTime", Long.valueOf(j4));
                                SPUtils.put(h.this.f13808j, "endTime", Long.valueOf(j5));
                            }

                            @Override // com.beizi.ad.lance.a
                            public void a() {
                                com.beizi.ad.lance.a.l.a("lance", "\u4e0a\u62a5\u6d3b\u8dc3\u91cf");
                            }
                        });
                    }
                    this.E = true;
                    if (Build.VERSION.SDK_INT >= 28) {
                        q();
                    }
                } else {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RewardedVideoAd a(Context context) {
        o oVar;
        synchronized (h.class) {
            oVar = new o(context);
            this.B = oVar;
        }
        return oVar;
    }

    public void a(float f4) {
        q.a(0.0f <= f4 && f4 <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        q.a(f13795g, (Object) "BeiZi.initialize() must be called prior to setting the app volume.");
        this.f13820z = f4;
    }

    public void a(boolean z3) {
        q.a(f13795g, (Object) "BeiZi.initialize() must be called prior to setting the app volume.");
        this.A = z3;
    }

    public void a(k kVar, String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        int i4 = AnonymousClass4.f13824a[kVar.ordinal()];
        if (i4 == 1) {
            this.f13811q.add(str);
        } else if (i4 == 2) {
            this.f13812r.add(str);
        } else if (i4 == 3) {
            this.f13813s.add(str);
        } else if (i4 == 4) {
            this.f13814t.add(str);
        } else if (i4 != 5) {
        } else {
            this.f13815u.add(str);
        }
    }

    public void a(b bVar) {
        this.J.add(bVar);
    }

    public void a(List<String> list) {
        this.f13804c = list;
    }
}
