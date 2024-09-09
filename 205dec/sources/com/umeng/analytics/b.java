package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: InternalAgent.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a  reason: collision with root package name */
    private static Context f52441a = null;

    /* renamed from: h  reason: collision with root package name */
    private static final String f52442h = "sp_uapp";

    /* renamed from: i  reason: collision with root package name */
    private static final String f52443i = "prepp_uapp";

    /* renamed from: o  reason: collision with root package name */
    private static final int f52444o = 128;

    /* renamed from: p  reason: collision with root package name */
    private static final int f52445p = 256;

    /* renamed from: q  reason: collision with root package name */
    private static String f52446q = "";

    /* renamed from: r  reason: collision with root package name */
    private static String f52447r = "";

    /* renamed from: t  reason: collision with root package name */
    private static final String f52449t = "ekv_bl_ver";

    /* renamed from: w  reason: collision with root package name */
    private static final String f52451w = "ekv_wl_ver";

    /* renamed from: z  reason: collision with root package name */
    private static final String f52452z = "umsp_1";

    /* renamed from: b  reason: collision with root package name */
    private ISysListener f52453b;

    /* renamed from: c  reason: collision with root package name */
    private p f52454c;

    /* renamed from: d  reason: collision with root package name */
    private v f52455d;

    /* renamed from: e  reason: collision with root package name */
    private k f52456e;

    /* renamed from: f  reason: collision with root package name */
    private u f52457f;

    /* renamed from: g  reason: collision with root package name */
    private l f52458g;

    /* renamed from: j  reason: collision with root package name */
    private boolean f52459j;

    /* renamed from: k  reason: collision with root package name */
    private volatile JSONObject f52460k;

    /* renamed from: l  reason: collision with root package name */
    private volatile JSONObject f52461l;

    /* renamed from: m  reason: collision with root package name */
    private volatile JSONObject f52462m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f52463n;

    /* renamed from: u  reason: collision with root package name */
    private com.umeng.analytics.filter.a f52464u;

    /* renamed from: x  reason: collision with root package name */
    private com.umeng.analytics.filter.b f52465x;

    /* renamed from: y  reason: collision with root package name */
    private m f52466y;

    /* renamed from: s  reason: collision with root package name */
    private static final String f52448s = d.ar;

    /* renamed from: v  reason: collision with root package name */
    private static final String f52450v = d.as;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: InternalAgent.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f52467a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f52441a = StubApp.getOrigApplicationContext(appContext.getApplicationContext());
        }
    }

    public static b a() {
        return a.f52467a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f52460k == null) {
                this.f52460k = new JSONObject();
            }
            if (this.f52461l == null) {
                this.f52461l = new JSONObject();
            }
            String string = sharedPreferences.getString("prepp_uapp", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f52462m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f52462m == null) {
                this.f52462m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f52460k;
    }

    public JSONObject c() {
        return this.f52462m;
    }

    public JSONObject d() {
        return this.f52461l;
    }

    public void e() {
        this.f52461l = null;
    }

    public String f() {
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("getOnResumedActivityName can not be called in child process");
            return null;
        }
        return f52446q;
    }

    public String g() {
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("getOnPausedActivityName can not be called in child process");
            return null;
        }
        return f52447r;
    }

    public void h() {
        try {
            Context context = f52441a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 4352, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = f52441a;
                UMWorkDispatch.sendEvent(context3, 4103, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.f52453b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        try {
            Context context = f52441a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f52441a;
            UMWorkDispatch.sendEvent(context2, 4102, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f52441a;
            UMWorkDispatch.sendEvent(context3, 4356, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        Context context;
        try {
            context = f52441a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f52460k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f52441a).edit();
            edit.putString("sp_uapp", this.f52460k.toString());
            edit.commit();
        } else {
            this.f52460k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        Context context;
        try {
            context = f52441a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f52460k == null) {
            this.f52460k = new JSONObject();
        }
        return this.f52460k;
    }

    public synchronized void m() {
        try {
            Context context = f52441a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                    return;
                }
                SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f52441a).edit();
                edit.remove("sp_uapp");
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i("MobclickRT", "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (FieldManager.allow("header_ekv_send_on_exit")) {
                if (UMWorkDispatch.eventHasExist(8210)) {
                    return;
                }
                UMRTLog.i("MobclickRT", "--->>> \u9000\u51fa\u65f6\u53d1\u9001\u7b56\u7565 \u88ab\u89e6\u53d1\uff01");
                Context context = f52441a;
                UMWorkDispatch.sendEvent(context, 8210, CoreProtocol.getInstance(context), null);
                return;
            }
            UMRTLog.i("MobclickRT", "--->>> \u9000\u51fa\u53d1\u9001\u7b56\u7565: \u4e91\u63a7\u63a7\u5236\u5b57\u5173\u95ed\u3002\u529f\u80fd\u4e0d\u751f\u6548");
        }
    }

    private b() {
        this.f52454c = new p();
        this.f52455d = new v();
        this.f52456e = new k();
        this.f52457f = u.a();
        this.f52458g = null;
        this.f52459j = false;
        this.f52460k = null;
        this.f52461l = null;
        this.f52462m = null;
        this.f52463n = false;
        this.f52464u = null;
        this.f52465x = null;
        this.f52466y = null;
        this.f52454c.a(this);
    }

    private boolean e(String str) {
        if (this.f52464u.enabled() && this.f52464u.matchHit(str)) {
            return true;
        }
        if (this.f52465x.enabled()) {
            if (this.f52465x.matchHit(str)) {
                UMRTLog.i("MobclickRT", "--->>> white list match! id = " + str);
                return false;
            }
            return true;
        }
        return false;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (this.f52464u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(f52448s, "ekv_bl_ver");
                this.f52464u = aVar;
                aVar.register(f52441a);
            }
            if (this.f52465x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(f52450v, "ekv_wl_ver");
                this.f52465x = bVar;
                bVar.register(f52441a);
            }
            if (UMUtils.isMainProgress(f52441a)) {
                if (!this.f52459j) {
                    this.f52459j = true;
                    i(f52441a);
                }
                synchronized (this) {
                    if (!this.f52463n) {
                        l a4 = l.a(context);
                        this.f52458g = a4;
                        if (a4.a()) {
                            this.f52463n = true;
                        }
                        this.f52466y = m.a();
                        try {
                            m.a(context);
                            this.f52466y.a(this);
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo("\u7edf\u8ba1SDK\u5e38\u89c1\u95ee\u9898\u7d22\u5f15\u8d34 \u8be6\u89c1\u94fe\u63a5 http://developer.umeng.com/docs/66650/cate/66650", 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f52441a));
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f52455d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context) {
        if (context == null) {
            UMLog.aq(j.f53006p, 0, "\\|");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f52441a)) {
                MLog.e("onPause can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.aq(j.f53007q, 2, "\\|");
            }
            try {
                if (!this.f52459j || !this.f52463n) {
                    a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f52456e.b(context.getClass().getName());
                }
                i();
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e("Exception occurred in Mobclick.onRause(). ", th);
                }
            }
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f52447r = context.getClass().getName();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f52441a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            l lVar = this.f52458g;
            if (lVar != null) {
                lVar.c();
            }
            l.a(context, "onKillProcess");
            k kVar = this.f52456e;
            if (kVar != null) {
                kVar.b();
            }
            v vVar = this.f52455d;
            if (vVar != null) {
                vVar.b();
            }
            Context context2 = f52441a;
            if (context2 != null) {
                u uVar = this.f52457f;
                if (uVar != null) {
                    uVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(f52441a).d();
                v.a(f52441a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f52441a);
                }
                PreferenceWrapper.getDefault(f52441a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        this.f52460k = new JSONObject();
        Context context2 = f52441a;
        UMWorkDispatch.sendEvent(context2, 8196, CoreProtocol.getInstance(context2), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(j.ap, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        if (this.f52462m.length() > 0) {
            Context context2 = f52441a;
            UMWorkDispatch.sendEvent(context2, 8201, CoreProtocol.getInstance(context2), null);
        }
        this.f52462m = new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
        } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
        } else {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f52441a)) {
                MLog.e("onResume can not be called in child process");
                return;
            }
            if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
                UMLog.aq(j.f53005o, 2, "\\|");
            }
            try {
                if (!this.f52459j || !this.f52463n) {
                    a(context);
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                    this.f52456e.a(context.getClass().getName());
                }
                h();
                if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                    f52446q = context.getClass().getName();
                }
            } catch (Throwable th) {
                MLog.e("Exception occurred in Mobclick.onResume(). ", th);
            }
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        } else if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return null;
        } else if (!str.equals("umsp_1") && !str.equals("umsp_2") && !str.equals("umsp_3") && !str.equals("umsp_4") && !str.equals("umsp_5")) {
            MLog.e("please check key or value, must be correct!");
            return null;
        } else {
            if (this.f52460k != null) {
                if (this.f52460k.has(str)) {
                    return this.f52460k.opt(str);
                }
            } else {
                this.f52460k = new JSONObject();
            }
            return null;
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(j.aq, 0, "\\|");
            return null;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        if (this.f52462m == null) {
            this.f52462m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f52462m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f52462m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = f52441a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 4104, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f52441a;
                UMWorkDispatch.sendEvent(context3, 4100, CoreProtocol.getInstance(context3), null);
                Context context4 = f52441a;
                UMWorkDispatch.sendEvent(context4, 4099, CoreProtocol.getInstance(context4), null);
                Context context5 = f52441a;
                UMWorkDispatch.sendEvent(context5, 4105, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f52453b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.an, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        if (this.f52462m == null) {
            this.f52462m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f52462m.has(str)) {
                this.f52462m.remove(str);
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 8200, CoreProtocol.getInstance(context2), this.f52462m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean g(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq("MobclickAgent.setSecret\u65b9\u6cd5\u53c2\u6570context\u4e0d\u80fd\u4e3anull|\u53c2\u6570Context\u9700\u8981\u6307\u5b9aApplicationContext\u503c\u3002", 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        AnalyticsConfig.a(f52441a, str);
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
        } else if (!str.equals("umsp_1") && !str.equals("umsp_2") && !str.equals("umsp_3") && !str.equals("umsp_4") && !str.equals("umsp_5")) {
            MLog.e("please check key or value, must be correct!");
        } else {
            if (this.f52460k == null) {
                this.f52460k = new JSONObject();
            }
            if (this.f52460k.has(str)) {
                this.f52460k.remove(str);
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 8197, CoreProtocol.getInstance(context2), str);
            }
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq("MobclickAgent.onDeepLinkReceived\u65b9\u6cd5Context\u53c2\u6570\u4e0d\u80fd\u4e3anull\u3002|\u53c2\u6570Context\u9700\u8981\u6307\u5b9aApplicationContext\u503c\u3002", 0, "\\|");
                return;
            }
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f52441a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f52459j || !this.f52463n) {
                a(f52441a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("_$!link", str);
                a(f52441a, "_$!deep_link", (Map<String, Object>) hashMap, -1L, false);
                return;
            }
            UMLog.aq("MobclickAgent.onDeepLinkReceived\u65b9\u6cd5link\u53c2\u6570\u4e0d\u80fd\u4e3anull\uff0c\u4e5f\u4e0d\u80fd\u4e3a\u7a7a\u5b57\u7b26\u4e32\u3002|\u53c2\u6570link\u5fc5\u987b\u4e3a\u975e\u7a7a\u5b57\u7b26\u4e32\u3002", 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f52455d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str, Object obj) {
        int i4;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i4 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i4 = 0;
        }
        if (i4 > 128) {
            MLog.e("key length is " + i4 + ", please check key, illegal");
            return false;
        } else if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length > 256) {
                MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
                return false;
            }
            return true;
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        } else {
            MLog.e("value is " + obj + ", please check value, type illegal");
            return false;
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        } else if (this.f52460k != null) {
            return this.f52460k.toString();
        } else {
            this.f52460k = new JSONObject();
            return null;
        }
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f52453b = iSysListener;
        }
    }

    public void a(Context context, int i4) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        AnalyticsConfig.a(f52441a, i4);
    }

    private void b(String str, Object obj) {
        try {
            if (this.f52460k == null) {
                this.f52460k = new JSONObject();
            }
            int i4 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i4 < strArr.length) {
                        if (strArr[i4] != null && !HelperUtils.checkStrLen(strArr[i4], 256)) {
                            jSONArray.put(strArr[i4]);
                        }
                        i4++;
                    }
                    this.f52460k.put(str, jSONArray);
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i4 < jArr.length) {
                        jSONArray2.put(jArr[i4]);
                        i4++;
                    }
                    this.f52460k.put(str, jSONArray2);
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i4 < iArr.length) {
                        jSONArray3.put(iArr[i4]);
                        i4++;
                    }
                    this.f52460k.put(str, jSONArray3);
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i4 < fArr.length) {
                        jSONArray4.put(fArr[i4]);
                        i4++;
                    }
                    this.f52460k.put(str, jSONArray4);
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i4 < dArr.length) {
                        jSONArray5.put(dArr[i4]);
                        i4++;
                    }
                    this.f52460k.put(str, jSONArray5);
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i4 < sArr.length) {
                        jSONArray6.put((int) sArr[i4]);
                        i4++;
                    }
                    this.f52460k.put(str, jSONArray6);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i4 < list.size()) {
                    Object obj2 = list.get(i4);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i4));
                    }
                    i4++;
                }
                this.f52460k.put(str, jSONArray7);
            } else if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f52460k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean f(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    public void c(String str) {
        if (g(str)) {
            a("_$!mobile", (Object) str);
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f52441a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f52459j || !this.f52463n) {
                a(f52441a);
            }
            String str2 = "";
            if (this.f52460k == null) {
                this.f52460k = new JSONObject();
            } else {
                str2 = this.f52460k.toString();
            }
            s.a(f52441a).a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void d(String str) {
        if (g(str)) {
            a("_$!email", (Object) str);
        }
    }

    void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f53013w, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("reportError can not be called in child process");
        } else if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.f53014x, 0, "\\|");
            }
        } else {
            try {
                if (!this.f52459j || !this.f52463n) {
                    a(f52441a);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("error_source", 2);
                jSONObject.put("context", str);
                jSONObject.put("__ii", this.f52457f.c());
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 4106, CoreProtocol.getInstance(context2), jSONObject);
            } catch (Throwable th) {
                if (MLog.DEBUG) {
                    MLog.e(th);
                }
            }
        }
    }

    void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f52441a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f52459j || !this.f52463n) {
                    a(f52441a);
                }
                a(f52441a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e4) {
                if (MLog.DEBUG) {
                    MLog.e(e4);
                    return;
                }
                return;
            }
        }
        UMLog.aq(j.f53015y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j4, int i4) {
        if (context == null) {
            return;
        }
        try {
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f52459j || !this.f52463n) {
                a(f52441a);
            }
            if (e(str)) {
                UMRTLog.i("MobclickRT", "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f52460k == null) {
                this.f52460k = new JSONObject();
            } else {
                str3 = this.f52460k.toString();
            }
            s.a(f52441a).a(str, str2, j4, i4, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized void b(Object obj) {
        Context context;
        try {
            context = f52441a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f52441a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString("prepp_uapp", str).commit();
            }
        } else if (edit != null) {
            edit.remove("prepp_uapp").commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str, Map<String, Object> map, long j4) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(d.aL).contains(str)) {
                UMLog.aq(j.f52992b, 0, "\\|");
                return;
            } else if (map.isEmpty()) {
                UMLog.aq(j.f52994d, 0, "\\|");
                return;
            } else {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (Arrays.asList(d.aL).contains(entry.getKey())) {
                        UMLog.aq(j.f52995e, 0, "\\|");
                        return;
                    }
                }
                a(context, str, map, j4, false);
                return;
            }
        }
        UMLog.aq(j.f52993c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j4, boolean z3) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f52441a == null) {
                f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f52459j || !this.f52463n) {
                a(f52441a);
            }
            if (e(str)) {
                UMRTLog.i("MobclickRT", "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f52460k == null) {
                this.f52460k = new JSONObject();
            } else {
                str2 = this.f52460k.toString();
            }
            s.a(f52441a).a(str, map, j4, str2, z3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th) {
        try {
            Context context = f52441a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onAppCrash can not be called in child process");
            } else if (AnalyticsConfig.enable) {
                v vVar = this.f52455d;
                if (vVar != null) {
                    vVar.b();
                }
                l.a(f52441a, "onAppCrash");
                k kVar = this.f52456e;
                if (kVar != null) {
                    kVar.b();
                }
                l lVar = this.f52458g;
                if (lVar != null) {
                    lVar.c();
                }
                u uVar = this.f52457f;
                if (uVar != null) {
                    uVar.c(f52441a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put("error_source", 1);
                    jSONObject.put("context", DataHelper.convertExceptionToString(th));
                    i.a(f52441a).a(this.f52457f.c(), jSONObject.toString(), 1);
                }
                o.a(f52441a).d();
                v.a(f52441a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f52441a);
                }
                PreferenceWrapper.getDefault(f52441a).edit().commit();
            }
        } catch (Exception e4) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            Context context = f52441a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("provider", str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f52441a;
            UMWorkDispatch.sendEvent(context2, 4101, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f52441a;
            UMWorkDispatch.sendEvent(context3, 4356, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        Context context = f52441a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
        } else {
            AnalyticsConfig.CATCH_EXCEPTION = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d4, double d5) {
        Context context = f52441a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f52418a == null) {
            AnalyticsConfig.f52418a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f52418a;
        dArr[0] = d4;
        dArr[1] = d5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f52441a, eScenarioType.toValue());
        }
        if (this.f52459j && this.f52463n) {
            return;
        }
        a(f52441a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        Context context = f52441a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
            return;
        }
        AnalyticsConfig.kContinueSessionMillis = j4;
        y.a().a(AnalyticsConfig.kContinueSessionMillis);
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i4 = 0;
        if (context == null) {
            UMLog.aq(j.af, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals("umsp_1") && !str.equals("umsp_2") && !str.equals("umsp_3") && !str.equals("umsp_4") && !str.equals("umsp_5")) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            } else if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            } else {
                try {
                    if (this.f52460k == null) {
                        this.f52460k = new JSONObject();
                    }
                    if (obj.getClass().isArray()) {
                        if (obj instanceof String[]) {
                            String[] strArr = (String[]) obj;
                            if (strArr.length > 10) {
                                MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray = new JSONArray();
                            while (i4 < strArr.length) {
                                if (strArr[i4] != null && HelperUtils.checkStrLen(strArr[i4], 256)) {
                                    jSONArray.put(strArr[i4]);
                                    i4++;
                                }
                                MLog.e("please check value, length is " + strArr[i4].length() + ", overlength 256!");
                                return;
                            }
                            this.f52460k.put(str, jSONArray);
                        } else if (obj instanceof long[]) {
                            long[] jArr = (long[]) obj;
                            if (jArr.length > 10) {
                                MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            while (i4 < jArr.length) {
                                jSONArray2.put(jArr[i4]);
                                i4++;
                            }
                            this.f52460k.put(str, jSONArray2);
                        } else if (obj instanceof int[]) {
                            int[] iArr = (int[]) obj;
                            if (iArr.length > 10) {
                                MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            while (i4 < iArr.length) {
                                jSONArray3.put(iArr[i4]);
                                i4++;
                            }
                            this.f52460k.put(str, jSONArray3);
                        } else if (obj instanceof float[]) {
                            float[] fArr = (float[]) obj;
                            if (fArr.length > 10) {
                                MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray4 = new JSONArray();
                            while (i4 < fArr.length) {
                                jSONArray4.put(fArr[i4]);
                                i4++;
                            }
                            this.f52460k.put(str, jSONArray4);
                        } else if (obj instanceof double[]) {
                            double[] dArr = (double[]) obj;
                            if (dArr.length > 10) {
                                MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray5 = new JSONArray();
                            while (i4 < dArr.length) {
                                jSONArray5.put(dArr[i4]);
                                i4++;
                            }
                            this.f52460k.put(str, jSONArray5);
                        } else if (obj instanceof short[]) {
                            short[] sArr = (short[]) obj;
                            if (sArr.length > 10) {
                                MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                                return;
                            }
                            JSONArray jSONArray6 = new JSONArray();
                            while (i4 < sArr.length) {
                                jSONArray6.put((int) sArr[i4]);
                                i4++;
                            }
                            this.f52460k.put(str, jSONArray6);
                        } else {
                            MLog.e("please check value, illegal type!");
                            return;
                        }
                    } else {
                        if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                            MLog.e("please check value, illegal type!");
                            return;
                        }
                        this.f52460k.put(str, obj);
                    }
                } catch (Throwable unused) {
                }
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 8195, CoreProtocol.getInstance(context2), this.f52460k.toString());
                return;
            }
        }
        UMLog.aq(j.ag, 0, "\\|");
    }

    public synchronized void a(Object obj) {
        Context context;
        try {
            context = f52441a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f52441a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString("sp_uapp", this.f52460k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(j.aj, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        s.a(f52441a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.aq(j.al, 0, "\\|");
            return;
        }
        if (f52441a == null) {
            f52441a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f52441a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f52459j || !this.f52463n) {
            a(f52441a);
        }
        if (this.f52462m == null) {
            this.f52462m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.f52462m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (c(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f52462m = jSONObject2;
            if (this.f52462m.length() > 0) {
                Context context2 = f52441a;
                UMWorkDispatch.sendEvent(context2, 8199, CoreProtocol.getInstance(context2), this.f52462m.toString());
            }
            return;
        }
        UMLog.aq(j.am, 0, "\\|");
    }

    public void a(String str, Object obj) {
        if (f(str)) {
            if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                MLog.e("userProfile: Invalid value type, please check!");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pk", str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        str2 = str2.trim();
                    }
                    if (!g(str2)) {
                        return;
                    }
                    jSONObject.put("pv", str2);
                } else {
                    jSONObject.put("pv", obj);
                }
                Context context = f52441a;
                UMWorkDispatch.sendEvent(context, 4358, CoreProtocol.getInstance(context), jSONObject);
            } catch (Throwable unused) {
            }
        }
    }
}
