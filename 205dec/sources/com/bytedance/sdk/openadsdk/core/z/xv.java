package com.bytedance.sdk.openadsdk.core.z;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.gb;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends p {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f35794c;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f35795f;

    /* renamed from: r  reason: collision with root package name */
    private Comparator<JSONObject> f35796r;
    private AtomicBoolean sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private final Context f35797w;
    private final c xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w {
        static String c(String str) {
            byte[] bytes = str.getBytes();
            for (int i4 = 0; i4 < bytes.length; i4++) {
                bytes[i4] = (byte) (bytes[i4] - 3);
            }
            return new String(bytes);
        }
    }

    private xv() {
        super("ApplistHelper");
        this.sr = new AtomicBoolean(false);
        this.ux = false;
        this.f35795f = true;
        this.f35796r = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.z.xv.1
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context context = ls.getContext();
        this.f35797w = context;
        this.xv = new c(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!ys.c(this.f35797w)) {
            this.sr.set(false);
            return;
        }
        try {
            boolean xv = this.xv.xv();
            if (xv) {
                long currentTimeMillis = System.currentTimeMillis();
                List<JSONObject> w3 = w(this.f35797w);
                a.w("ApplistHelper", "get duration: " + (System.currentTimeMillis() - currentTimeMillis));
                c(w3, xv);
            } else {
                this.sr.set(false);
            }
        } catch (Throwable th) {
            this.sr.set(false);
            a.xv("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    public void xv() {
        if (wv.w()) {
            this.ux = ls.w().iw() && k.sr().ux().w();
            if (ux.ux() && this.f35795f) {
                this.f35795f = false;
                if (this.sr.get()) {
                    return;
                }
                this.sr.set(true);
                try {
                    ev.c(this, 1);
                } catch (Throwable th) {
                    a.c("ApplistHelper", "upload sdk applist error: ", th);
                    this.sr.set(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c {

        /* renamed from: w  reason: collision with root package name */
        private com.bytedance.sdk.component.f.c f35802w;

        c(Context context) {
            try {
                this.f35802w = c(context);
            } catch (Throwable unused) {
                a.w("listHelper", "cache throwable");
            }
        }

        private com.bytedance.sdk.component.f.c c(Context context) {
            try {
                return ba.c("tt_sp_app_list");
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }

        String w() {
            com.bytedance.sdk.component.f.c cVar = this.f35802w;
            return cVar == null ? "" : cVar.w("old_app_list", "");
        }

        boolean xv() {
            com.bytedance.sdk.component.f.c cVar = this.f35802w;
            return !wv.c(cVar != null ? cVar.w("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }

        void c(String str) {
            com.bytedance.sdk.component.f.c cVar;
            if (TextUtils.isEmpty(str) || (cVar = this.f35802w) == null) {
                return;
            }
            cVar.c("old_app_list", str);
        }

        void c() {
            com.bytedance.sdk.component.f.c cVar = this.f35802w;
            if (cVar == null) {
                return;
            }
            cVar.c("day_update_time", System.currentTimeMillis());
        }
    }

    public static xv w() {
        if (f35794c == null) {
            synchronized (xv.class) {
                if (f35794c == null) {
                    f35794c = new xv();
                }
            }
        }
        return f35794c;
    }

    public List<String> c(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.c.xv(w.c("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object invoke = gb.c(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(gb.c(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke instanceof List) && (list = (List) invoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (c(packageInfo) != 1) {
                            arrayList.add("unknown:" + packageInfo.packageName);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            a.c("ApplistHelper", "loadApps error2: ", th);
        }
        return arrayList;
    }

    private List<JSONObject> w(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.ux || (com.bytedance.sdk.openadsdk.core.eq.ls.ev() && Build.VERSION.SDK_INT >= 29)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.c.xv(w.c("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object invoke = gb.c(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(gb.c(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((invoke instanceof List) && (list = (List) invoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("package_name", packageInfo.packageName);
                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                        jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                        jSONObject2.put("version_name", packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put("app_name", "unknown");
                        jSONObject2.put("app_type", c(packageInfo));
                        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                        jSONObject2.put("apk_dir", applicationInfo != null ? applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable th) {
            a.c("ApplistHelper", "get install apps error: ", th);
        }
        return arrayList;
    }

    private int c(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null || (applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    private boolean c(List<JSONObject> list) {
        int i4;
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, this.f35796r);
            String xv = com.bytedance.sdk.component.utils.c.xv(this.xv.w());
            if (TextUtils.isEmpty(xv)) {
                a.w("ApplistHelper", "is app change true2");
                return true;
            }
            try {
                JSONArray jSONArray = new JSONArray(xv);
                int length = jSONArray.length();
                if (length == list.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < length; i5++) {
                        arrayList.add(jSONArray.getJSONObject(i5));
                    }
                    Collections.sort(arrayList, this.f35796r);
                    while (i4 < length) {
                        JSONObject jSONObject = list.get(i4);
                        JSONObject jSONObject2 = (JSONObject) arrayList.get(i4);
                        String optString = jSONObject.optString("package_name");
                        String optString2 = jSONObject.optString("last_update_time");
                        i4 = (optString != null && optString2 != null && optString.equals(jSONObject2.optString("package_name")) && optString2.equals(jSONObject2.optString("last_update_time"))) ? i4 + 1 : 0;
                        a.w("ApplistHelper", "is app change true3");
                        return true;
                    }
                    a.w("ApplistHelper", "is app change false");
                    return false;
                }
                a.w("ApplistHelper", "is app change true4");
                return true;
            } catch (Throwable th) {
                a.xv("ApplistHelper", "is app change error: ", th);
                return true;
            }
        }
        a.w("ApplistHelper", "is app change true1");
        return false;
    }

    private void c(final List<JSONObject> list, final boolean z3) throws JSONException {
        boolean c4 = c(list);
        JSONObject c5 = com.bytedance.sdk.component.utils.c.c(c(c4 ? list : new ArrayList<>(), ls.w().eb(), ls.w().kn()));
        StringBuilder sb = new StringBuilder();
        sb.append("param:");
        sb.append(list == null ? 0 : list.size());
        a.w("ApplistHelper", sb.toString());
        com.bytedance.sdk.component.ev.w.sr w3 = com.bytedance.sdk.openadsdk.core.q.ux.c().w().w();
        w3.c(wv.r("/api/ad/union/sdk/upload/app_info/"));
        w3.xv(c5.toString());
        w3.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.z.xv.2
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                a.w("ApplistHelper", "real upload response");
                if (wVar != null && wVar.ev() && !TextUtils.isEmpty(wVar.sr())) {
                    try {
                        if ("20000".equals(new JSONObject(wVar.sr()).optString("status"))) {
                            if (z3) {
                                xv.this.xv.c();
                            }
                            xv.this.xv.c(com.bytedance.sdk.component.utils.c.w(new JSONArray((Collection) list).toString()));
                            a.w("ApplistHelper", "APP List upload success ! ");
                        } else {
                            a.w("ApplistHelper", "APP List upload failed !");
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
                xv.this.sr.set(false);
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                xv.this.sr.set(false);
            }
        });
    }

    private JSONObject c(List<JSONObject> list, List<String> list2, List<String> list3) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        int i4 = -1;
        try {
            String f4 = i.f();
            Object obj2 = "";
            if (TextUtils.isEmpty(f4)) {
                f4 = "";
            }
            if (TextUtils.isEmpty(f4)) {
                obj = "";
            } else {
                obj = f4;
                i4 = 1;
            }
            String c4 = com.bytedance.sdk.openadsdk.core.eq.i.c();
            if (TextUtils.isEmpty(c4)) {
                c4 = "";
            }
            if (i4 < 0 && !TextUtils.isEmpty(c4)) {
                i4 = 4;
                obj = c4;
            }
            String ux = i.ux();
            if (TextUtils.isEmpty(ux)) {
                ux = "";
            }
            String w3 = com.bytedance.sdk.openadsdk.core.r.c().w();
            if (!TextUtils.isEmpty(w3)) {
                obj2 = w3;
            }
            if (i4 < 0) {
                i4 = 3;
                obj = ux;
            }
            JSONArray jSONArray = new JSONArray();
            for (JSONObject jSONObject2 : list) {
                jSONArray.put(jSONObject2.optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", i.xv());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", i.u());
            jSONObject.put("app_id", k.sr().ev());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", eq.xv);
            jSONObject.put("device_id_type", i4);
            jSONObject.put("imei", f4);
            jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, c4);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", ux);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        if (wv.xv(ls.getContext(), str)) {
                            jSONArray2.put(str);
                        } else {
                            jSONArray3.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray2);
                jSONObject.put("no_applist", jSONArray3);
            }
            boolean g4 = ls.w().g();
            jSONObject.put("scheme_get_type", g4 ? 0 : 1);
            if (list3 != null && !list3.isEmpty() && g4) {
                for (String str2 : list3) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            Uri parse = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(parse);
                            wv.c(ls.getContext(), intent, true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            Map<String, Boolean> c5 = com.bytedance.sdk.openadsdk.core.eq.gb.c(259200000L);
            if (c5 != null && c5.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (Map.Entry<String, Boolean> entry : c5.entrySet()) {
                    if (entry.getValue().booleanValue()) {
                        jSONArray4.put(entry.getKey());
                    } else {
                        jSONArray5.put(entry.getKey());
                    }
                }
                jSONObject.put("scheme_success_list", jSONArray4);
                jSONObject.put("scheme_fail_list", jSONArray5);
            }
            List<String> c6 = wv.c();
            if (c6.size() > 0) {
                jSONObject.put("query_all_package", c6);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }
}
