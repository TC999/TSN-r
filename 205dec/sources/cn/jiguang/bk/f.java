package cn.jiguang.bk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2720a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2721b;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f2722c;

    /* renamed from: d  reason: collision with root package name */
    private static long f2723d;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f2724e;

    /* renamed from: f  reason: collision with root package name */
    private static LinkedList<String> f2725f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends cn.jiguang.cm.b {

        /* renamed from: a  reason: collision with root package name */
        private Context f2726a;

        a(Context context) {
            this.f2726a = context;
            this.f3462h = "JBannedConfig";
        }

        private int a(Context context) {
            String a4;
            String str;
            try {
                a4 = cn.jiguang.bk.a.a(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a4)) {
                cn.jiguang.bq.d.i("JBannedConfig", "request bannedConfig failed because can't get appKey");
                return -1;
            }
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
            cn.jiguang.f.g.a(context, f.f2725f);
            Iterator it = f.f2725f.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String uuid = UUID.randomUUID().toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", a4);
                jSONObject.put("uid", longValue);
                jSONObject.put("stoken", uuid);
                cn.jiguang.bq.d.c("JBannedConfig", "request url: " + str2 + ", param json:" + jSONObject.toString());
                if (TextUtils.isEmpty(str2)) {
                    cn.jiguang.bq.d.i("JBannedConfig", "can't get url, give up upload");
                    return -1;
                }
                cn.jiguang.bs.g a5 = cn.jiguang.bs.b.a(str2, jSONObject.toString(), context, false, 3, 3);
                int a6 = a5.a();
                String b4 = a5.b();
                cn.jiguang.bq.d.c("JBannedConfig", "code: " + a6 + ", responseBody:" + b4);
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
                        String optString = new JSONObject(b4).optString("stoken");
                        if (uuid.equals(optString)) {
                            f.b(context, new JSONObject(b4));
                            return 0;
                        }
                        cn.jiguang.bq.d.i("JBannedConfig", "banned config uuid not match, reqUuid: " + uuid + ", resUuid: " + optString);
                        return 0;
                    } else {
                        str = "upload" + jSONObject.toString() + " failed";
                    }
                    cn.jiguang.bq.d.c("JBannedConfig", str);
                } else {
                    Boolean unused2 = f.f2724e = null;
                }
            }
            return -1;
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            cn.jiguang.bq.d.c("JBannedConfig", "start request sdk banned config");
            int a4 = a(this.f2726a);
            if (a4 != 0) {
                cn.jiguang.bq.d.i("JBannedConfig", "request banned config failed, code: " + a4);
            }
        }
    }

    static {
        String b4 = cn.jiguang.cn.d.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 30, 74, 105, 125, 101, 121, 30, 67, 119, 39, 96, 32, 31, 83, 109, 105, 98, 100, 67});
        f2720a = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 114, 95, 78, Byte.MAX_VALUE, 97, 113, 60, 89, 80, 111, 62, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 111, 57, 57, 98, 68, 65, 109, 125, 101});
        f2721b = b5;
        f2722c = new AtomicBoolean(false);
        f2723d = 0L;
        f2724e = null;
        LinkedList<String> linkedList = new LinkedList<>();
        f2725f = linkedList;
        linkedList.clear();
        f2725f.add(b4);
        f2725f.add(b5);
    }

    private static void a(Context context, String str) {
        try {
            cn.jiguang.bq.d.c("JSDKBannedHelper", "save sdk banned status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_banned_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSDKBannedHelper", "[saveBannedConfigJson] parse json error, " + th.getMessage());
        }
    }

    private static void a(Context context, boolean z3, long j4) {
        f2723d = j4;
        if (f2722c.get() != z3) {
            cn.jiguang.bq.d.c("JSDKBannedHelper", "sdk banned status changed, update status, sdkBanned: " + z3);
            if (!z3) {
                f2722c = new AtomicBoolean(z3);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z3);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z3) {
            cn.jiguang.bq.d.l("JSDKBannedHelper", "[key-step]Your sdk is disabled already. If you want to enable it, please contact us.");
        }
        f2722c = new AtomicBoolean(z3);
        cn.jiguang.bq.d.f("JSDKBannedHelper", "sdk banned status, banned: " + z3 + ", nextTime: " + f2723d);
    }

    public static boolean a() {
        Context appContext = JConstants.getAppContext(null);
        if (appContext != null && cn.jiguang.cn.a.a() && cn.jiguang.cf.b.a().b(appContext)) {
            return f2724e == null ? a(appContext) : f2722c.get();
        }
        return false;
    }

    public static synchronized boolean a(Context context) {
        synchronized (f.class) {
            if (!cn.jiguang.cn.a.a()) {
                return f2722c.get();
            } else if (TextUtils.isEmpty(cn.jiguang.bk.a.a(context))) {
                return f2722c.get();
            } else if (f2724e != null) {
                return f2722c.get();
            } else {
                f2724e = Boolean.TRUE;
                cn.jiguang.bq.d.c("JSDKBannedHelper", "[isSDKBanned] first request banned config");
                b(context);
                if (System.currentTimeMillis() > f2723d) {
                    cn.jiguang.cm.d.a("FUTURE_TASK", new a(context), 0, false);
                } else {
                    if (f2722c.get()) {
                        cn.jiguang.bq.d.l("JSDKBannedHelper", "[key-step]Your sdk is disabled already. If you want to enable it, please contact us.");
                    }
                    cn.jiguang.bq.d.c("JSDKBannedHelper", "request sdk banned config not time up, not request");
                }
                return f2722c.get();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("values");
            if (optJSONObject != null) {
                boolean equals = "banned".equals(optJSONObject.optString("status"));
                long optLong = optJSONObject.optLong("nexttime", 43200L);
                cn.jiguang.bq.d.c("JSDKBannedHelper", "from server sdk banned status: " + equals + ", next request time: " + optLong);
                if (optLong <= 0) {
                    optLong = 0;
                }
                if (optLong >= 86400) {
                    optLong = 86400;
                }
                long currentTimeMillis = System.currentTimeMillis() + (optLong * 1000);
                a(context, equals + "," + currentTimeMillis);
                a(context, equals, currentTimeMillis);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSDKBannedHelper", "parse sdk banned config failed, " + th.getMessage());
        }
    }

    private static boolean b(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_banned_status", "");
            cn.jiguang.bq.d.f("JSDKBannedHelper", "local sdk banned config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.bq.d.c("JSDKBannedHelper", "local banned config, isBanned: " + parseBoolean + ", nextReqTime: " + parseLong);
                f2723d = parseLong;
                f2722c = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSDKBannedHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }
}
