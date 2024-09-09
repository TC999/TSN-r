package cn.jiguang.ax;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.ag.h;
import cn.jiguang.ah.a;
import cn.jiguang.as.e;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    private static final String f2460i;

    /* renamed from: j  reason: collision with root package name */
    private static final String f2461j;

    /* renamed from: k  reason: collision with root package name */
    private static LinkedList<String> f2462k;

    /* renamed from: c  reason: collision with root package name */
    private Context f2463c;

    /* renamed from: e  reason: collision with root package name */
    private int f2464e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f2465f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f2466g = "";

    /* renamed from: b  reason: collision with root package name */
    private static final String f2457b = cn.jiguang.ao.c.b(new byte[]{107, 125, 122, 116, 111, 70, 112, 100, 115, 78, 93, 68, 44});

    /* renamed from: a  reason: collision with root package name */
    public static String f2456a = "";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile c f2458d = null;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f2459h = new Object();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private class a implements Callable<Integer> {

        /* renamed from: b  reason: collision with root package name */
        private Context f2471b;

        public a(Context context) {
            this.f2471b = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Integer call() {
            c.this.a(this.f2471b);
            return 0;
        }
    }

    static {
        String b4 = cn.jiguang.ao.c.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 126, 64, 24, 115, 108, 99});
        f2460i = b4;
        String b5 = cn.jiguang.ao.c.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 103, 102, 41, 90, 68, 108});
        f2461j = b5;
        LinkedList<String> linkedList = new LinkedList<>();
        f2462k = linkedList;
        linkedList.clear();
        f2462k.add(b4);
        f2462k.add(b5);
    }

    private int a(Context context, String str) {
        synchronized (f2459h) {
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.w.a.b("JDataConfigManager", "[refreshConfig] data config is null");
                return 0;
            }
            String str2 = new String(cn.jiguang.ap.b.a(str, a.C0049a.f2221j, a.C0049a.f2222k), "UTF-8");
            a("JDataConfigManager", "serverConfig:" + str2);
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message");
            if (optInt == 2000) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    cn.jiguang.ar.a.a().b();
                    int optInt2 = optJSONObject.optInt("status");
                    this.f2465f = optJSONObject.optString("sign");
                    if (optInt2 == 0) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("rt");
                        if (optJSONArray != null) {
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                String optString2 = optJSONArray.optString(i4);
                                if (!TextUtils.isEmpty(optString2)) {
                                    String[] split = optString2.split("-");
                                    cn.jiguang.ar.a.a().f2359b.add(new String[]{split[0], split[1]});
                                }
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("pl");
                        if (optJSONArray2 != null) {
                            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i5);
                                if (optJSONObject2 != null) {
                                    cn.jiguang.ax.a aVar = new cn.jiguang.ax.a();
                                    aVar.a(true);
                                    aVar.a(optJSONObject2.optInt("ci"));
                                    aVar.b(optJSONObject2.optInt("sc"));
                                    aVar.c(optJSONObject2.optInt("rp"));
                                    aVar.e(optJSONObject2.optInt("bc"));
                                    aVar.d(optJSONObject2.optInt("sr"));
                                    aVar.f(optJSONObject2.optInt("br"));
                                    aVar.g(optJSONObject2.optInt("bg"));
                                    aVar.h(optJSONObject2.optInt(LiveConfigKey.MEDIUM));
                                    cn.jiguang.ar.a.a().a(aVar);
                                }
                            }
                        }
                    } else {
                        cn.jiguang.w.a.b("JDataConfigManager", "parse data config , config status is no");
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("in_app");
                    if (optJSONObject3 != null) {
                        String optString3 = optJSONObject3.optString(f2457b);
                        cn.jiguang.w.a.b("JDataConfigManager", "recv inapp file hash: " + optString3);
                        if (!TextUtils.isEmpty(optString3) && !"null".equals(optString3)) {
                            cn.jiguang.ah.d.h(context, optString3);
                        }
                    }
                    a(context, optJSONObject.optJSONObject("extra"));
                }
            } else {
                cn.jiguang.w.a.b("JDataConfigManager", "[refreshConfig] data config code:" + optInt + " msg:" + optString);
            }
            return optInt;
        }
    }

    public static c a() {
        if (f2458d == null) {
            synchronized (c.class) {
                if (f2458d == null) {
                    f2458d = new c();
                }
            }
        }
        return f2458d;
    }

    private String a(String str) {
        String b4;
        try {
            b4 = cn.jiguang.ah.d.b(this.f2463c);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDataConfigManager", "request data config exception:" + th.getMessage());
        }
        if (TextUtils.isEmpty(b4)) {
            cn.jiguang.w.a.f("JDataConfigManager", "request data config failed because can't get appKey");
            return null;
        }
        h.a(this.f2463c, f2462k);
        Iterator<String> it = f2462k.iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ak", b4);
            jSONObject.put("p", "a");
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_AV_KEY, "4");
            jSONObject.put("sign", str);
            String r3 = cn.jiguang.ah.d.r(this.f2463c);
            if (TextUtils.isEmpty(r3)) {
                r3 = "";
            }
            jSONObject.put("file_version", r3);
            jSONObject.put("manufacturer", cn.jiguang.ag.a.t(this.f2463c));
            jSONObject.put("rom", cn.jiguang.bb.e.a(this.f2463c));
            jSONObject.put("model", cn.jiguang.ag.a.p(this.f2463c));
            String num = Integer.toString(Build.VERSION.SDK_INT);
            jSONObject.put("osversion", num);
            if (!TextUtils.isEmpty(num) && !num.equalsIgnoreCase((String) cn.jiguang.ai.b.a(this.f2463c, cn.jiguang.ai.a.e()))) {
                cn.jiguang.ao.h.a().a(this.f2463c, num);
            }
            String v3 = cn.jiguang.ag.a.v(this.f2463c);
            if (!TextUtils.isEmpty(v3)) {
                jSONObject.put("android_ver", v3);
            }
            String a4 = cn.jiguang.ah.d.a();
            if (!TextUtils.isEmpty(a4)) {
                jSONObject.put("jcore_ver", a4);
            }
            String b5 = cn.jiguang.ah.d.b(0);
            if (!TextUtils.isEmpty(b5)) {
                jSONObject.put("jpush_ver", b5);
            }
            jSONObject.put("pb_sign", this.f2466g);
            cn.jiguang.w.a.b("JDataConfigManager", "url:" + next + ", param json:" + jSONObject.toString());
            cn.jiguang.ak.a aVar = new cn.jiguang.ak.a(next);
            aVar.a("Content-Type", "text/plain");
            aVar.a("Accept", "application/json");
            aVar.a("Charset", "UTF-8");
            String a5 = cn.jiguang.ap.b.a(jSONObject.toString().getBytes(), a.C0049a.f2221j, a.C0049a.f2222k);
            cn.jiguang.w.a.b("JDataConfigManager", "encryptStr:" + a5 + ", paramJson: " + jSONObject);
            aVar.a(a5);
            cn.jiguang.ak.b b6 = cn.jiguang.ak.c.b(this.f2463c, aVar);
            int b7 = b6.b();
            cn.jiguang.w.a.b("JDataConfigManager", "responseCode:" + b7);
            String a6 = b6.a();
            cn.jiguang.w.a.b("JDataConfigManager", "request data config code:" + b7 + ", body:" + a6);
            if (200 == b7 && !TextUtils.isEmpty(a6)) {
                cn.jiguang.w.a.b("JDataConfigManager", "request data config success");
                return a6;
            }
        }
        return null;
    }

    private void a(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.w.a.b("JDataConfigManager", "it can't process extra list, because no extra data");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(CampaignEx.JSON_KEY_AD_AL);
        if (optJSONObject != null) {
            cn.jiguang.common.n.d.f3555c = optJSONObject.optInt("priority", cn.jiguang.common.n.d.f3554b);
        }
        b(context, jSONObject);
    }

    public static void a(String str, String str2) {
        int length = 4000 - str.length();
        while (str2.length() > length) {
            cn.jiguang.w.a.b(str, str2.substring(0, length));
            str2 = str2.substring(length);
        }
        cn.jiguang.w.a.b(str, str2);
    }

    public static void a(LinkedList<String> linkedList) {
        if (!a.C0049a.f2212a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        cn.jiguang.w.a.b("JDataConfigManager", "setTestUrls use data url :" + linkedList);
        f2462k.clear();
        f2462k.addAll(linkedList);
    }

    private void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.w.a.b("JDataConfigManager", "it can't process probe list, because no extra data");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("pb");
        if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString("pb_sign"))) {
            cn.jiguang.w.a.b("JDataConfigManager", "it can't process probe list, because no pb data");
            return;
        }
        this.f2466g = optJSONObject.optString("pb_sign");
        String optString = optJSONObject.optString("list");
        optString = (TextUtils.isEmpty(optString) || TextUtils.equals("null", optString)) ? "" : "";
        if (!TextUtils.isEmpty(optString)) {
            cn.jiguang.as.e.d().f(context, optString);
        }
        e.a e4 = cn.jiguang.as.e.d().e();
        if (e4 != null && TextUtils.equals(this.f2466g, e4.c())) {
            optString = cn.jiguang.as.e.d().c(context);
            cn.jiguang.w.a.b("JDataConfigManager", "probe list not change, use cache list data");
        }
        cn.jiguang.w.a.b("JDataConfigManager", "probe list : " + optString);
        cn.jiguang.as.e.d().a(new e.a().b(this.f2466g).a(optString).a(optJSONObject.optInt("ap", 1) != 0));
    }

    public synchronized void a(Context context) {
        if (this.f2464e >= 3) {
            cn.jiguang.w.a.b("JDataConfigManager", "try more than 3 times,won't try again");
            cn.jiguang.ah.c.e(context, "JDataConfigManager");
            this.f2464e = 0;
            return;
        }
        if (cn.jiguang.ah.c.a(context, "JDataConfigManager")) {
            b(context);
            String a4 = a(this.f2465f);
            if (TextUtils.isEmpty(a4)) {
                this.f2464e++;
            } else {
                if (a(context, a4) == 2000) {
                    cn.jiguang.ao.e.a(context, "bac.catch", a4);
                }
                cn.jiguang.ah.c.e(context, "JDataConfigManager");
                this.f2464e = 0;
            }
        } else {
            b(context);
        }
    }

    public void a(Context context, int i4) {
        try {
            this.f2463c = context;
            FutureTask futureTask = new FutureTask(new a(context));
            cn.jiguang.ah.d.a(futureTask);
            futureTask.get(i4, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            cn.jiguang.w.a.b("JDataConfigManager", "requestConfigSync timeout");
        }
    }

    public void a(final Context context, final b bVar) {
        this.f2463c = context;
        cn.jiguang.ah.d.a(new cn.jiguang.ah.e() { // from class: cn.jiguang.ax.c.1
            @Override // cn.jiguang.ah.e
            public void a() {
                try {
                    c.this.a(context);
                } catch (Throwable th) {
                    cn.jiguang.w.a.b("JDataConfigManager", "request config error:" + th);
                }
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        });
    }

    public void b(Context context) {
        synchronized (f2459h) {
            if (TextUtils.isEmpty(this.f2465f)) {
                String c4 = cn.jiguang.ao.e.c(context, "bac.catch");
                if (!TextUtils.isEmpty(c4)) {
                    a(context, c4);
                }
            }
        }
    }
}
