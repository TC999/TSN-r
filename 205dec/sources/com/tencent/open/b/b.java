package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f51689a;

    /* renamed from: b  reason: collision with root package name */
    private String f51690b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f51691c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f51692d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f51693e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f51694f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f51695g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f51696h = "";

    /* renamed from: i  reason: collision with root package name */
    private List<Serializable> f51697i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j  reason: collision with root package name */
    private List<Serializable> f51698j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k  reason: collision with root package name */
    private Executor f51699k = l.b();

    /* renamed from: l  reason: collision with root package name */
    private boolean f51700l;

    private b() {
    }

    private void c() {
        while (!this.f51698j.isEmpty()) {
            c cVar = (c) this.f51698j.remove(0);
            cVar.f51703a.put("appid", this.f51690b);
            cVar.f51703a.put("app_name", this.f51691c);
            cVar.f51703a.put("app_ver", this.f51693e);
            cVar.f51703a.put("pkg_name", this.f51694f);
            cVar.f51703a.put("qq_install", this.f51695g);
            cVar.f51703a.put("qq_ver", this.f51696h);
            cVar.f51703a.put("openid", this.f51692d);
            HashMap<String, String> hashMap = cVar.f51703a;
            hashMap.put("time_appid_openid", cVar.f51703a.get("time") + "_" + this.f51690b + "_" + this.f51692d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(cVar);
            SLog.i("AttaReporter", sb.toString());
            this.f51697i.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.f51700l) {
            List<Serializable> b4 = g.b("report_atta");
            this.f51700l = b4.isEmpty();
            this.f51697i.addAll(b4);
            Iterator<Serializable> it = b4.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f51697i.isEmpty()) {
            c cVar = (c) this.f51697i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (!arrayList.isEmpty()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) it2.next())));
            }
            g.a("report_atta", arrayList);
            this.f51700l = false;
        } else if (this.f51700l) {
        } else {
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.f51700l = true;
        }
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f51689a == null) {
                f51689a = new b();
            }
            bVar = f51689a;
        }
        return bVar;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put("token", "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + "_" + this.f51690b + "_" + this.f51692d);
        hashMap.put("time", String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.f51692d);
        hashMap.put("appid", this.f51690b);
        hashMap.put("app_name", this.f51691c);
        hashMap.put("app_ver", this.f51693e);
        hashMap.put("pkg_name", this.f51694f);
        hashMap.put("os", "AND");
        hashMap.put("os_ver", Build.VERSION.RELEASE);
        hashMap.put("sdk_ver", "3.5.13.lite");
        hashMap.put("model_name", com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        hashMap.put("interface_result", obj == null ? "" : obj.toString());
        hashMap.put("qq_install", this.f51695g);
        hashMap.put("qq_ver", this.f51696h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            hashMap.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            hashMap.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            hashMap.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            hashMap.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new c(hashMap);
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", "init");
        this.f51690b = str;
        this.f51691c = k.a(context);
        this.f51693e = m.d(context, com.tencent.open.utils.g.b());
        this.f51694f = com.tencent.open.utils.g.b();
        this.f51695g = k.b(context) ? "1" : "0";
        this.f51696h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f51692d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c b4 = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f51690b) && !TextUtils.isEmpty(this.f51691c) && com.tencent.open.utils.g.a() != null) {
            a(b4);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f51690b + ", mAppName=" + this.f51691c + ", context=" + com.tencent.open.utils.g.a() + ", " + b4);
        this.f51698j.add(b4);
    }

    private void a(final c cVar) {
        this.f51699k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f51697i.add(cVar);
                if (m.b(com.tencent.open.utils.g.a())) {
                    try {
                        b.this.d();
                        return;
                    } catch (Exception e4) {
                        SLog.e("AttaReporter", "Exception", e4);
                        return;
                    }
                }
                SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
            }
        });
    }

    private boolean b(c cVar) {
        int i4 = 0;
        do {
            i4++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                return com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.f51703a).d() == 200;
            } catch (Exception e4) {
                SLog.i("AttaReporter", "Exception", e4);
                if (i4 >= 2) {
                    return false;
                }
            }
        } while (i4 >= 2);
        return false;
    }

    public static String b() {
        return a().f51690b;
    }
}
