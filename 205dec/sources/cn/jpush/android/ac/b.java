package cn.jpush.android.ac;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3927a = "I7MUZXCPZWRFZAJS";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3928b = "CBDHJXMDDVXH8THW";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3929c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f3930d;

    /* renamed from: e  reason: collision with root package name */
    private static LinkedList<String> f3931e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private Context f3932a;

        /* renamed from: b  reason: collision with root package name */
        private String f3933b;

        /* renamed from: c  reason: collision with root package name */
        private cn.jpush.android.ac.a f3934c;

        public a(Context context, String str, cn.jpush.android.ac.a aVar) {
            this.f3932a = context;
            this.f3984e = "JPConfig";
            this.f3934c = aVar;
            this.f3933b = str;
        }

        private void b() {
            Bundle bundle = JPushConstants.getBundle();
            if (!JConstants.isTestEnv() || bundle == null) {
                return;
            }
            String string = bundle.getString("test_key_config_url");
            if (TextUtils.isEmpty(string) || m.c(string) == null) {
                return;
            }
            b.f3931e.clear();
            b.f3931e.addAll(m.c(string));
            Logger.d("JPConfig", "test env and use the test urls " + b.f3931e);
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                if (System.currentTimeMillis() - cn.jpush.android.cache.a.r(this.f3932a) < 86400000) {
                    Logger.d("JPConfig", "it not sdk config request business time");
                    return;
                }
                int f4 = e.a().f(this.f3932a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dev_key", this.f3933b);
                jSONObject.put("p_name", this.f3932a.getPackageName());
                jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, f4);
                String upperCase = cn.jpush.android.ad.a.d(jSONObject.toString()).toUpperCase();
                String upperCase2 = cn.jpush.android.ad.a.d(this.f3933b + upperCase).toUpperCase();
                if (TextUtils.isEmpty(upperCase2)) {
                    Logger.w("JPConfig", "authToken is null");
                    return;
                }
                String encodeToString = Base64.encodeToString((this.f3933b + ":" + upperCase2).getBytes(), 10);
                if (TextUtils.isEmpty(encodeToString)) {
                    Logger.w("JPConfig", "authorization is null");
                    return;
                }
                String a4 = l.a(jSONObject.toString().getBytes(), b.f3927a, b.f3928b);
                b();
                m.a(this.f3932a, b.f3931e);
                Iterator it = b.f3931e.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    cn.jpush.android.w.c cVar = new cn.jpush.android.w.c(str);
                    cVar.a("init_config");
                    cVar.a("Content-Type", "application/json");
                    cVar.a("Accept", "application/json");
                    cVar.a("X-Http-Platform", "android");
                    cVar.a("Authorization", "Basic " + encodeToString);
                    cVar.a("Charset", "UTF-8");
                    cVar.a((Object) a4);
                    Logger.d("JPConfig", "url: " + str + ", request param: " + jSONObject.toString());
                    cn.jpush.android.w.d a5 = cn.jpush.android.w.e.a(this.f3932a, cVar);
                    int b4 = a5.b();
                    Logger.d("JPConfig", "responseCode:" + b4);
                    if (200 == b4) {
                        String a6 = a5.a();
                        Logger.d("JPConfig", "responseBody:" + a6);
                        if (TextUtils.isEmpty(a6)) {
                            continue;
                        } else {
                            String str2 = new String(l.a(a6, b.f3927a, b.f3928b));
                            if (this.f3934c != null && !TextUtils.isEmpty(str2)) {
                                Logger.d("JPConfig", "request response - p2:" + str2);
                                JSONObject jSONObject2 = new JSONObject(str2);
                                if (jSONObject2.optInt("code") == 2000) {
                                    cn.jpush.android.cache.a.d(this.f3932a, System.currentTimeMillis());
                                    this.f3934c.a(this.f3932a, jSONObject2.optJSONObject("data").toString());
                                    return;
                                }
                            }
                        }
                    }
                }
                cn.jpush.android.ac.a aVar = this.f3934c;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Throwable th) {
                Logger.w("JPConfig", "request JP config failed, " + th.getMessage());
            }
        }
    }

    static {
        String b4 = cn.jpush.android.ad.d.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 114, 85, 19, 124, 63, 35, 117, 5, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 102, 89, 15, 122, 102, 122});
        f3929c = b4;
        String b5 = cn.jpush.android.ad.d.b(new byte[]{113, 124, 98, 97, 67, 26, 54, 39, 117, 116, 3, 69, 46, 61, 114, 36, 29, 73, 105, 126, 32, 63, 90, 80, 108, 123, 126, 63, 83, 78, 54, Byte.MAX_VALUE, Byte.MAX_VALUE, 62, 83, 78, 117});
        f3930d = b5;
        LinkedList<String> linkedList = new LinkedList<>();
        f3931e = linkedList;
        linkedList.clear();
        f3931e.add(b4);
        f3931e.add(b5);
    }

    public static void a(Context context, String str, cn.jpush.android.ac.a aVar) {
        JCoreHelper.normalExecutor(context, null, new a(context, str, aVar));
    }
}
