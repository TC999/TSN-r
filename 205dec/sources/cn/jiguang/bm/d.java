package cn.jiguang.bm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2747a;

    public static Bundle a(Context context, int i4, JSONObject jSONObject) {
        String c4 = cn.jiguang.bp.g.c(context);
        Bundle d4 = d(context, c4);
        if (d4 != null) {
            return d4;
        }
        Bundle bundle = new Bundle();
        String a4 = cn.jiguang.bp.e.a(context, i4, c4);
        try {
            JSONObject jSONObject2 = new JSONObject(a4);
            int i5 = jSONObject2.getInt("code");
            bundle.putInt("code", i5);
            if (i5 == 0) {
                bundle.putString("msg", a4);
            } else {
                cn.jiguang.bp.h.e("JOperateImp", "testDemo:" + jSONObject2);
                bundle.putString("msg", jSONObject2.optString("msg", "unknown error"));
            }
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateImp", "testDemo:" + a4 + ":", th);
            bundle.putInt("code", -1);
            bundle.putString("msg", th.getMessage());
        }
        return bundle;
    }

    private static synchronized Bundle a(Context context, String str, String str2, JSONObject jSONObject) {
        Bundle bundle;
        synchronized (d.class) {
            bundle = new Bundle();
            String a4 = cn.jiguang.bp.e.a(context, str, str2, jSONObject);
            JSONObject jSONObject2 = new JSONObject(a4);
            int i4 = jSONObject2.getInt("code");
            bundle.putInt("code", i4);
            if (i4 == 0) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                String string = jSONObject3.getString("cuid");
                String string2 = jSONObject3.getString("orgId");
                int optInt = jSONObject3.optInt("isNew", 0);
                if (!TextUtils.isEmpty(string) && !"null".equals(string)) {
                    cn.jiguang.bp.h.a("JOperateImp", "sendLoginTag cuidNew:" + string);
                    cn.jiguang.bp.g.a(context, string);
                    cn.jiguang.bp.g.b(context, string2);
                    if (!string.equals(str)) {
                        cn.jiguang.bp.g.b(context, 0L);
                        cn.jiguang.bp.g.a(context, 0L);
                        c(context, new JSONArray().toString());
                        a(context, new JSONArray().toString());
                        a(context);
                    }
                }
                if (1 == optInt) {
                    i.a(context);
                }
            } else {
                cn.jiguang.bp.h.e("JOperateImp", "setLoginTag f:" + a4);
                bundle.putString("msg", jSONObject2.optString("msg", "unknown error"));
            }
        }
        return bundle;
    }

    public static Bundle a(Context context, String str, JSONObject jSONObject) {
        String optString;
        String c4 = cn.jiguang.bp.g.c(context);
        Bundle d4 = d(context, c4);
        if (d4 != null) {
            return d4;
        }
        Bundle bundle = new Bundle();
        String b4 = cn.jiguang.bp.e.b(context, c4, str, jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject(b4);
            int i4 = jSONObject2.getInt("code");
            bundle.putInt("code", i4);
            if (i4 == 0) {
                jSONObject2.getJSONObject("data");
                optString = "successful";
            } else {
                cn.jiguang.bp.h.e("JOperateImp", "userProfile:" + jSONObject2);
                optString = jSONObject2.optString("msg", "unknown error");
            }
            bundle.putString("msg", optString);
            a(context);
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateImp", "userProfile:" + b4 + ":", th);
            bundle.putInt("code", -1);
            bundle.putString("msg", th.getMessage());
        }
        return bundle;
    }

    public static synchronized Bundle a(Context context, JSONObject jSONObject) {
        synchronized (d.class) {
            String c4 = cn.jiguang.bp.g.c(context);
            String f4 = f.f(context);
            if (TextUtils.isEmpty(f4)) {
                cn.jiguang.bp.h.e("JOperateImp", "setLoginTag rid null");
                Bundle bundle = new Bundle();
                bundle.putInt("code", -1);
                bundle.putString("msg", "No RID, please try again later");
                return bundle;
            }
            Bundle d4 = d(context, c4);
            if (d4 != null) {
                return d4;
            }
            if (jSONObject.length() != 0) {
                return a(context, c4, f4, jSONObject);
            }
            cn.jiguang.bp.h.e("JOperateImp", "setLoginTag value is null");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("code", -1);
            bundle2.putString("msg", "value is not null ");
            return bundle2;
        }
    }

    public static void a(Context context) {
        f2747a = false;
        a(context, 0L, (String) null, true);
    }

    public static void a(Context context, long j4, final String str, final boolean z3) {
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (f2747a) {
            cn.jiguang.bp.h.a("JOperateImp", "isDownloadSucc is true");
            return;
        }
        if (!z3) {
            long o4 = cn.jiguang.bp.g.o(origApplicationContext);
            if (System.currentTimeMillis() - o4 < cn.jiguang.bp.g.n(origApplicationContext)) {
                cn.jiguang.bp.h.a("JOperateImp", "getEventIntervals is false");
                return;
            }
        }
        if (str == null) {
            str = f.f(origApplicationContext);
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.bp.h.a("JOperateImp", "no has registrationId");
                return;
            }
        }
        f.a(new Runnable() { // from class: cn.jiguang.bm.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.b(origApplicationContext, str, z3);
            }
        }, new int[0]);
    }

    public static void a(Context context, String str) {
        cn.jiguang.bp.f.f(context, str);
    }

    private static void a(Context context, Map<String, cn.jiguang.bn.a> map, long j4) {
        a.a(context).a(map);
        a(context, a.a(context).c().toString());
        cn.jiguang.bp.g.a(context, j4);
    }

    private static void a(Context context, Set<String> set, long j4) {
        a.a(context).a(set);
        cn.jiguang.bp.g.b(context, j4);
        c(context, a.a(context).a().toString());
    }

    private static synchronized Bundle b(Context context, String str, JSONObject jSONObject) {
        Bundle bundle;
        synchronized (d.class) {
            bundle = new Bundle();
            JSONObject jSONObject2 = new JSONObject(cn.jiguang.bp.e.a(context, str, jSONObject));
            int i4 = jSONObject2.getInt("code");
            bundle.putInt("code", i4);
            if (i4 != 0) {
                cn.jiguang.bp.h.e("JOperateImp", "setChannel:" + jSONObject2);
                bundle.putString("msg", jSONObject2.optString("msg", "unknown error"));
            }
        }
        return bundle;
    }

    public static synchronized Bundle b(Context context, JSONObject jSONObject) {
        synchronized (d.class) {
            String c4 = cn.jiguang.bp.g.c(context);
            Bundle d4 = d(context, c4);
            if (d4 != null) {
                return d4;
            }
            return b(context, c4, jSONObject);
        }
    }

    public static Object b(Context context, String str) {
        String optString;
        String c4 = cn.jiguang.bp.g.c(context);
        Bundle d4 = d(context, c4);
        if (d4 != null) {
            return d4;
        }
        Bundle bundle = new Bundle();
        String a4 = cn.jiguang.bp.e.a(context, c4, str);
        try {
            JSONObject jSONObject = new JSONObject(a4);
            int i4 = jSONObject.getInt("code");
            bundle.putInt("code", i4);
            if (i4 == 0) {
                jSONObject.getJSONObject("data");
                optString = "successful";
            } else {
                cn.jiguang.bp.h.e("JOperateImp", "unUserProfile:" + jSONObject);
                optString = jSONObject.optString("msg", "unknown error");
            }
            bundle.putString("msg", optString);
            a(context);
        } catch (Throwable th) {
            cn.jiguang.bp.h.b("JOperateImp", "unUserProfile:" + a4 + ":", th);
            bundle.putInt("code", -1);
            bundle.putString("msg", th.getMessage());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void b(Context context, String str, boolean z3) {
        String str2;
        String str3;
        synchronized (d.class) {
            try {
                cn.jiguang.bp.h.a("JOperateImp", "download isDownloadSucc:" + f2747a);
                cn.jiguang.bp.h.c("JOperateImp", "try to get operate config");
            } catch (Throwable th) {
                cn.jiguang.bp.h.g("JOperateImp", "download e:" + th.getMessage());
            }
            if (f2747a) {
                return;
            }
            if (!z3) {
                long o4 = cn.jiguang.bp.g.o(context);
                if (System.currentTimeMillis() - o4 < cn.jiguang.bp.g.n(context)) {
                    cn.jiguang.bp.h.a("JOperateImp", "download getEventIntervals is false");
                    return;
                }
            }
            String a4 = cn.jiguang.bp.e.a(context, cn.jiguang.bp.g.c(context), str, cn.jiguang.bp.g.a(context), cn.jiguang.bp.g.b(context));
            cn.jiguang.bp.h.a("JOperateImp", "download:" + a4);
            JSONObject jSONObject = new JSONObject(a4);
            int i4 = jSONObject.getInt("code");
            cn.jiguang.bp.g.c(context, jSONObject.optLong("intervals", 0L));
            cn.jiguang.bp.g.d(context, System.currentTimeMillis());
            if (i4 == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String optString = jSONObject2.optString("cuid");
                String optString2 = jSONObject2.optString("orgId");
                String optString3 = jSONObject2.optString("dataSourceId");
                int optInt = jSONObject2.optInt("isNew", 0);
                cn.jiguang.bp.h.c("JOperateImp", "operate cuid is :" + optString);
                c(context, jSONObject2);
                d(context, jSONObject2);
                if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                    cn.jiguang.bp.h.a("JOperateImp", "cuidNew:" + optString);
                    cn.jiguang.bp.g.a(context, optString);
                    cn.jiguang.bp.g.b(context, optString2);
                    cn.jiguang.bp.g.c(context, optString3);
                }
                if (1 == optInt) {
                    i.a(context);
                }
                f2747a = true;
                cn.jiguang.bp.g.b(context, false);
                str2 = "JOperateImp";
                str3 = "download success";
            } else if (4001 != i4) {
                cn.jiguang.bp.h.e("JOperateImp", "download failed:" + a4);
            } else {
                f2747a = true;
                cn.jiguang.bp.g.b(context, true);
                a(context, new HashSet(), 0L);
                a(context, new HashMap(), 0L);
                cn.jiguang.bp.f.a(context, null);
                cn.jiguang.bp.f.c(context, null);
                str2 = "JOperateImp";
                str3 = "download success JOpetate Off";
            }
            cn.jiguang.bp.h.b(str2, str3);
        }
    }

    private static void c(Context context, String str) {
        cn.jiguang.bp.f.e(context, str);
    }

    private static void c(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("userProperties");
        if (optJSONObject == null) {
            cn.jiguang.bp.h.a("JOperateImp", "userProperties no change");
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("data");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        a(context, a.b(optJSONArray), jSONObject.optLong("userVersion", 0L));
    }

    private static Bundle d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.bp.h.e("JOperateImp", "checkCUid cUid null");
            Bundle bundle = new Bundle();
            bundle.putInt("code", -1);
            bundle.putString("msg", "No cUID, please try again later ");
            a(context, 0L, (String) null, true);
            return bundle;
        }
        return null;
    }

    private static void d(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("reservedEvents");
        if (optJSONObject == null) {
            cn.jiguang.bp.h.a("JOperateImp", "reservedEvents no change");
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("data");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        a(context, a.a(optJSONArray), jSONObject.optLong("eventVersion", 0L));
    }
}
