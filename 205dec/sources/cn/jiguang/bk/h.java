package cn.jiguang.bk;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2734a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2735b;

    /* renamed from: c  reason: collision with root package name */
    private static String f2736c;

    /* renamed from: d  reason: collision with root package name */
    private static Integer f2737d;

    /* renamed from: e  reason: collision with root package name */
    private static final LinkedList<String> f2738e;

    static {
        String b4 = cn.jiguang.cn.d.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 123, 101, 125, 83, 69, 107, 124, 56, 123, 64, 85, 106, 96, 56, 114, 94});
        f2734a = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 106, 123, 122, 114, 85, 82, 109, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2735b = b5;
        LinkedList<String> linkedList = new LinkedList<>();
        f2738e = linkedList;
        linkedList.add(b4);
        linkedList.add(b5);
    }

    public static String a() {
        c();
        return !TextUtils.isEmpty(f2736c) ? f2736c : "";
    }

    public static void a(final Context context, int i4) {
        if (b(context, i4)) {
            cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b("JSslCertUpdateManager") { // from class: cn.jiguang.bk.h.1
                @Override // cn.jiguang.cm.b
                public void a() {
                    try {
                        String b4 = h.b(context);
                        if (TextUtils.isEmpty(b4)) {
                            cn.jiguang.ck.a.a().a(15);
                            return;
                        }
                        synchronized (h.class) {
                            JSONObject jSONObject = new JSONObject(b4);
                            int optInt = jSONObject.optInt("ver", 0);
                            String optString = jSONObject.optString("cert", "");
                            if (TextUtils.isEmpty(optString)) {
                                cn.jiguang.ck.a.a().a(19);
                                return;
                            }
                            String b5 = cn.jiguang.cn.g.b(optString, cn.jiguang.a.a.f2017i);
                            if (TextUtils.isEmpty(b5) || optInt <= 0) {
                                cn.jiguang.ck.a.a().a(17);
                            } else {
                                String unused = h.f2736c = b5;
                                Integer unused2 = h.f2737d = Integer.valueOf(optInt);
                                boolean b6 = h.b(context, jSONObject);
                                cn.jiguang.ck.a.a().a(b6 ? 18 : 17);
                                StringBuilder sb = new StringBuilder();
                                sb.append("update cert status: ");
                                sb.append(b6 ? "succeed" : "failed");
                                cn.jiguang.bq.d.c("JSslCertUpdateManager", sb.toString());
                            }
                        }
                    } catch (Throwable th) {
                        cn.jiguang.ck.a.a().a(16);
                        cn.jiguang.bq.d.i("JSslCertUpdateManager", "checkCrtUpdate failed, " + th.getMessage());
                    }
                }
            });
        }
    }

    public static int b() {
        c();
        Integer num = f2737d;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context) {
        String a4;
        try {
            a4 = a.a(context);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSslCertUpdateManager", "request crt failed, " + th.getMessage());
        }
        if (TextUtils.isEmpty(a4)) {
            cn.jiguang.bq.d.i("JSslCertUpdateManager", "appKey is empty, return");
            return null;
        }
        Iterator<String> it = f2738e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (TextUtils.isEmpty(next)) {
                cn.jiguang.bq.d.i("JSslCertUpdateManager", "url is empty, return it");
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", a4);
                jSONObject.put("sdkver", cn.jiguang.a.a.f2010b);
                jSONObject.put("platform", 0);
                cn.jiguang.bs.g a5 = cn.jiguang.bs.b.a(next, jSONObject.toString(), context, true, 3, 2);
                cn.jiguang.bq.d.c("JSslCertUpdateManager", "update cert code[" + a5.a() + "] from url=" + next + "\n body=" + a5.b());
                if (a5.a() == 0) {
                    String b4 = a5.b();
                    if (!TextUtils.isEmpty(b4)) {
                        if (new JSONObject(b4).optInt("code") != 200) {
                            return null;
                        }
                        return b4;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private static boolean b(Context context, int i4) {
        String str;
        String str2;
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.i())).booleanValue()) {
            int b4 = b();
            if (b4 < i4) {
                cn.jiguang.bv.c.a(false);
                synchronized (h.class) {
                    f2736c = null;
                    if (!b(context, new JSONObject())) {
                        context.deleteFile("ccp.catch.");
                    }
                    cn.jiguang.bq.d.c("JSslCertUpdateManager", "should update, clear cert");
                }
                return true;
            }
            str = "JSslCertUpdateManager";
            str2 = "it need not update cert, l_cert_ver: " + b4 + ", new_cert_ver: " + i4;
        } else {
            str = "JSslCertUpdateManager";
            str2 = "not use tcp ssl, so need not update cert.";
        }
        cn.jiguang.bq.d.c(str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 41, null, null, "ccp.catch.", jSONObject);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSslCertUpdateManager", "writeJson throwable:" + th.getMessage());
            return false;
        }
    }

    private static JSONObject c(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 42, null, null, "ccp.catch.");
            if (onEvent instanceof JSONObject) {
                return (JSONObject) onEvent;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("JSslCertUpdateManager", "readJson throwable:" + th.getMessage());
            return null;
        }
    }

    private static void c() {
        if (f2737d == null && TextUtils.isEmpty(f2736c)) {
            synchronized (h.class) {
                JSONObject c4 = c(JConstants.getAppContext(null));
                if (c4 != null && !"{}".equals(c4.toString())) {
                    String optString = c4.optString("cert", "");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    f2736c = cn.jiguang.cn.g.b(optString, cn.jiguang.a.a.f2017i);
                    f2737d = Integer.valueOf(c4.optInt("ver", 0));
                }
            }
        }
    }
}
