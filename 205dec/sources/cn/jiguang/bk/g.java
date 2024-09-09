package cn.jiguang.bk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2727a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2728b;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f2729c;

    /* renamed from: d  reason: collision with root package name */
    private static long f2730d;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f2731e;

    /* renamed from: f  reason: collision with root package name */
    private static LinkedList<String> f2732f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends cn.jiguang.cm.b {

        /* renamed from: a  reason: collision with root package name */
        private Context f2733a;

        a(Context context) {
            this.f2733a = context;
            this.f3462h = "JLimitConfig";
        }

        private int a(Context context) {
            String a4;
            String str;
            try {
                a4 = cn.jiguang.bk.a.a(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a4)) {
                cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "request bannedConfig failed because can't get appKey");
                return -1;
            }
            cn.jiguang.f.g.a(context, g.f2732f);
            Iterator it = g.f2732f.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                JSONObject jSONObject = new JSONObject();
                ActionManager.getInstance();
                if (!ActionManager.wrapSdkTypeVersionInfo(jSONObject)) {
                    cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "request bannedConfig wrapSdkTypeVersionInfo is false");
                    return -1;
                }
                if (jSONObject.length() > 0) {
                    jSONObject.put("appkey", a4);
                    jSONObject.put("platform", "android");
                }
                cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "request url: " + str2 + ", param json:" + jSONObject.toString());
                if (TextUtils.isEmpty(str2)) {
                    cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "can't get url, give up upload");
                    return -1;
                }
                cn.jiguang.bs.g a5 = cn.jiguang.bs.b.a(str2, jSONObject.toString(), context, false, 3, 3);
                int a6 = a5.a();
                String b4 = a5.b();
                cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "code: " + a6 + ", responseBody:" + b4);
                int a7 = a5.a();
                if (a7 == -3) {
                    return -2;
                }
                if (a7 != 3006) {
                    if (a7 == -1) {
                        str = "upload" + jSONObject.toString() + " error:" + a5.b();
                    } else if (a7 == 0) {
                        if (TextUtils.isEmpty(b4)) {
                            return 0;
                        }
                        g.b(context, new JSONObject(b4));
                        return 0;
                    } else {
                        str = "upload" + jSONObject.toString() + " failed";
                    }
                    cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", str);
                } else {
                    Boolean unused2 = g.f2731e = null;
                }
            }
            return -1;
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "start request sdk limit config");
            int a4 = a(this.f2733a);
            if (a4 != 0) {
                cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "request limit config failed, code: " + a4);
            }
        }
    }

    static {
        String b4 = cn.jiguang.cn.d.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 118, 102, 112, 120, 87, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 103, 1, 15, 111, 109, 100, 98, 89, 79, 119, 37, 117, 121, 85, 67, 114});
        f2727a = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 29, 73, 105, 126, 32, 63, 90, 80, 108, 123, 126, 63, 83, 78, 54, 126, 39, 62, 70, 69, 107, 123, Byte.MAX_VALUE, 126, 94, 13, 122, 96, 115, 114, 91});
        f2728b = b5;
        f2729c = new AtomicBoolean(false);
        f2730d = 0L;
        f2731e = null;
        LinkedList<String> linkedList = new LinkedList<>();
        f2732f = linkedList;
        linkedList.clear();
        f2732f.add(b4);
        f2732f.add(b5);
    }

    private static void a(Context context, String str) {
        try {
            cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "save sdk limit status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_limit_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "[saveSdkLimitStatus] parse json error, " + th.getMessage());
        }
    }

    private static void a(Context context, boolean z3, long j4) {
        f2730d = j4;
        if (f2729c.get() != z3) {
            cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "sdk limit status changed, update status, sdkLimit: " + z3);
            if (!z3) {
                f2729c = new AtomicBoolean(z3);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z3);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z3) {
            cn.jiguang.bq.d.d("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk type is " + b());
            cn.jiguang.bq.d.l("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk, but it is limited now. If you want to enable it, please contact us.");
        }
        f2729c = new AtomicBoolean(z3);
        cn.jiguang.bq.d.f("JSDKDeveloperIdLimitHelper", "sdk limit status, limit: " + z3 + ", nextTime: " + f2730d);
    }

    public static boolean a() {
        Context appContext;
        try {
            appContext = JConstants.getAppContext(null);
        } catch (Throwable th) {
            cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "isSDKLimit error:" + th);
        }
        if (appContext != null && cn.jiguang.cn.a.a() && cn.jiguang.cf.b.a().b(appContext)) {
            if (TextUtils.isEmpty(cn.jiguang.bk.a.a(appContext))) {
                return f2729c.get();
            }
            if (cn.jiguang.a.a.f2011c == JConstants.SDK_VERSION_INT && f2731e == null) {
                if (ActionManager.wrapSdkTypeVersionInfo(new JSONObject())) {
                    return a(appContext);
                }
                f2731e = Boolean.TRUE;
            }
            return f2729c.get();
        }
        return false;
    }

    public static boolean a(int i4) {
        return i4 == 1 || i4 == 4 || i4 == 5 || i4 == 3;
    }

    public static synchronized boolean a(Context context) {
        synchronized (g.class) {
            if (f2731e != null) {
                return f2729c.get();
            }
            f2731e = Boolean.TRUE;
            b(context);
            if (System.currentTimeMillis() > f2730d) {
                cn.jiguang.cm.d.a("FUTURE_TASK", new a(context), 0, false);
            } else {
                if (f2729c.get()) {
                    cn.jiguang.bq.d.d("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk type is " + b());
                    cn.jiguang.bq.d.l("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk, but it is limited now. If you want to enable it, please contact us.");
                }
                cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "request sdk limit config not time up, not request");
            }
            return f2729c.get();
        }
    }

    public static int b() {
        return !TextUtils.isEmpty(cn.jiguang.a.a.f2012d) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean z3 = true;
            if (jSONObject.optInt("code") != 1) {
                z3 = false;
            }
            long optLong = jSONObject.optLong("nexttime", 43200L);
            cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "from server sdk limit status: " + z3 + ", next request time: " + optLong);
            if (optLong <= 0) {
                optLong = 0;
            }
            if (optLong >= 86400) {
                optLong = 86400;
            }
            long currentTimeMillis = System.currentTimeMillis() + (optLong * 1000);
            a(context, z3 + "," + currentTimeMillis);
            a(context, z3, currentTimeMillis);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "parse sdk limit config failed, " + th.getMessage());
        }
    }

    private static boolean b(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_limit_status", "");
            cn.jiguang.bq.d.f("JSDKDeveloperIdLimitHelper", "local sdk limit config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.bq.d.c("JSDKDeveloperIdLimitHelper", "local limit config, isLimit: " + parseBoolean + ", nextReqTime: " + parseLong);
                f2730d = parseLong;
                f2729c = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSDKDeveloperIdLimitHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }
}
