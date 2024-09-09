package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.al;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.z;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Monitor.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53247a = "iucc";

    /* renamed from: b  reason: collision with root package name */
    private static final String f53248b = au.b().b("ccfg");

    /* renamed from: c  reason: collision with root package name */
    private static JSONObject f53249c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f53250d = {"screen_on", "screen_off", "screen_unlock"};

    /* renamed from: e  reason: collision with root package name */
    private static ArrayList<aa> f53251e = null;

    /* renamed from: f  reason: collision with root package name */
    private static ArrayList<aa> f53252f = null;

    /* renamed from: g  reason: collision with root package name */
    private static ArrayList<aa> f53253g = null;

    /* renamed from: j  reason: collision with root package name */
    private static c f53254j = new c();

    /* renamed from: h  reason: collision with root package name */
    private volatile String f53255h = "";

    /* renamed from: i  reason: collision with root package name */
    private Map<String, a> f53256i = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Monitor.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private JSONArray f53259b;

        /* renamed from: c  reason: collision with root package name */
        private String f53260c;

        public a(JSONArray jSONArray, String str) {
            this.f53259b = jSONArray;
            this.f53260c = str;
        }

        public JSONArray a() {
            return this.f53259b;
        }

        public String b() {
            return this.f53260c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Monitor.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final d f53261a = new d();

        private b() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Monitor.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends BroadcastReceiver {
        public long a(ArrayList<aa> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    aa aaVar = arrayList.get(i4);
                    if (aaVar instanceof ac) {
                        return ((ac) aaVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (arrayList.get(i4).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i("MobclickRT", "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f53251e)) {
                        UMRTLog.i("MobclickRT", "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f53251e) * 1000);
                    } else {
                        UMRTLog.i("MobclickRT", "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i("MobclickRT", "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f53252f)) {
                        UMRTLog.i("MobclickRT", "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f53252f) * 1000);
                    } else {
                        UMRTLog.i("MobclickRT", "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i("MobclickRT", "recv intent : ACTION_USER_PRESENT");
                    if (b(d.f53253g)) {
                        UMRTLog.i("MobclickRT", "report screen_unlock event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f53253g) * 1000);
                        return;
                    }
                    UMRTLog.i("MobclickRT", "don't report screen_unlock event.");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f53254j, intentFilter);
    }

    private String e(Context context) {
        try {
            SharedPreferences a4 = ar.a(context);
            return a4 != null ? a4.getString("iucc_s2", "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void f() {
        try {
            SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
            if (a4 != null) {
                a4.edit().putString("sdk_type_ver", new JSONObject(ap.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean g() {
        try {
            SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
            if (a4 != null) {
                return !TextUtils.isEmpty(a4.getString("should_fetch", ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback("iucc", new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences a4 = ar.a(context);
            if (a4 == null) {
                return 0L;
            }
            return Long.valueOf(a4.getLong("iucc_s1", 0L));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("cc")) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("cc");
            z a4 = optJSONObject.has("col_wifi") ? a("col_wifi", optJSONObject.optJSONObject("col_wifi")) : null;
            z a5 = optJSONObject.has("col_bs") ? a("col_bs", optJSONObject.optJSONObject("col_bs")) : null;
            z a6 = optJSONObject.has("col_lbs") ? a("col_lbs", optJSONObject.optJSONObject("col_lbs")) : null;
            z a7 = optJSONObject.has("col_apl") ? a("col_apl", optJSONObject.optJSONObject("col_apl")) : null;
            z a8 = optJSONObject.has("screen_on") ? a("screen_on", optJSONObject.optJSONObject("screen_on")) : null;
            z a9 = optJSONObject.has("screen_off") ? a("screen_off", optJSONObject.optJSONObject("screen_off")) : null;
            z a10 = optJSONObject.has("screen_unlock") ? a("screen_unlock", optJSONObject.optJSONObject("screen_unlock")) : null;
            ArrayList arrayList = new ArrayList();
            if (a4 != null) {
                arrayList.add(a4);
            }
            if (a5 != null) {
                arrayList.add(a5);
            }
            if (a6 != null) {
                arrayList.add(a6);
            }
            if (a7 != null) {
                arrayList.add(a7);
            }
            if (a8 != null) {
                arrayList.add(a8);
            }
            if (a9 != null) {
                arrayList.add(a9);
            }
            if (a10 != null) {
                arrayList.add(a10);
            }
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
        } catch (Throwable unused) {
        }
    }

    private boolean e() {
        SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
        if (a4 != null) {
            String string = a4.getString("sdk_type_ver", "");
            if (TextUtils.isEmpty(string)) {
                f();
                return false;
            }
            try {
                if (!ap.a().keySet().equals(ap.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static d a() {
        return b.f53261a;
    }

    private JSONObject b(Context context) {
        FileInputStream fileInputStream;
        try {
            File filesDir = context.getFilesDir();
            String str = f53248b;
            if (!new File(filesDir, str).exists()) {
                return null;
            }
            try {
                fileInputStream = context.openFileInput(str);
                try {
                    JSONObject jSONObject = new JSONObject(new String(at.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                    try {
                        ap.a(fileInputStream);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    ap.a(fileInputStream);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has("cc")) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Context context, JSONObject jSONObject, String str) {
        try {
            long b4 = b(jSONObject);
            byte[] a4 = at.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (a4 != null && a4.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f53248b));
                fileOutputStream.write(a4);
                fileOutputStream.flush();
                ap.a(fileOutputStream);
                a(context, str, b4);
                UMRTLog.i("MobclickRT", "saveConfigFile success.");
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str) {
        String str2 = "interval_" + str;
        SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
        if (a4 != null) {
            a4.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, aa aaVar) {
        if ("screen_on".equalsIgnoreCase(str)) {
            if (f53251e == null) {
                f53251e = new ArrayList<>();
            }
            f53251e.add(aaVar);
        }
        if ("screen_off".equalsIgnoreCase(str)) {
            if (f53252f == null) {
                f53252f = new ArrayList<>();
            }
            f53252f.add(aaVar);
        }
        if ("screen_unlock".equalsIgnoreCase(str)) {
            if (f53253g == null) {
                f53253g = new ArrayList<>();
            }
            f53253g.add(aaVar);
        }
    }

    private z a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        String str3;
        z zVar;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("cfg") && (optJSONArray = jSONObject.optJSONArray("cfg")) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has("col_delay_times");
                    boolean has2 = jSONObject2.has("col_interval");
                    boolean has3 = jSONObject2.has("col_delay_ts");
                    if (has && has2 && has3) {
                        try {
                            int optInt = jSONObject2.optInt("col_delay_times");
                            long optLong = jSONObject2.optLong("col_interval");
                            long optLong2 = jSONObject2.optLong("col_delay_ts");
                            String optString = jSONObject2.optString("hit_sdk");
                            ArrayList arrayList = new ArrayList();
                            if (jSONObject2.has("week_on")) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray("week_on");
                                str2 = "action";
                                HashSet hashSet = new HashSet();
                                if (optJSONArray3 != null) {
                                    str3 = "sdk";
                                    int i4 = 0;
                                    for (int length = optJSONArray3.length(); i4 < length; length = length) {
                                        hashSet.add(Integer.valueOf(optJSONArray3.getInt(i4)));
                                        i4++;
                                    }
                                } else {
                                    str3 = "sdk";
                                }
                                if (hashSet.size() > 0) {
                                    aj ajVar = new aj(hashSet);
                                    if (Arrays.asList(f53250d).contains(str)) {
                                        a(str, ajVar);
                                    } else {
                                        arrayList.add(ajVar);
                                    }
                                }
                            } else {
                                str2 = "action";
                                str3 = "sdk";
                            }
                            if (jSONObject2.has("hour_on")) {
                                String optString2 = jSONObject2.optString("hour_on");
                                if (!TextUtils.isEmpty(optString2)) {
                                    ah ahVar = new ah(optString2);
                                    HashSet hashSet2 = new HashSet();
                                    for (int i5 = 1; i5 <= 24; i5++) {
                                        if (ahVar.a(i5)) {
                                            hashSet2.add(Integer.valueOf(i5));
                                        }
                                    }
                                    if (hashSet2.size() > 0) {
                                        ad adVar = new ad(hashSet2);
                                        if (Arrays.asList(f53250d).contains(str)) {
                                            a(str, adVar);
                                        } else {
                                            arrayList.add(adVar);
                                        }
                                    }
                                }
                            }
                            arrayList.add(new af(optInt));
                            ae aeVar = new ae(str, optLong);
                            String[] strArr = f53250d;
                            if (Arrays.asList(strArr).contains(str)) {
                                a(str, aeVar);
                            } else {
                                arrayList.add(aeVar);
                            }
                            ac acVar = new ac(optLong2);
                            if (Arrays.asList(strArr).contains(str)) {
                                a(str, acVar);
                                arrayList.add(acVar);
                            } else {
                                arrayList.add(acVar);
                            }
                            if ("col_apl".equals(str)) {
                                zVar = new ab(str, arrayList);
                            } else {
                                zVar = new z(str, arrayList);
                            }
                            try {
                                zVar.a(optString);
                                String str4 = "";
                                String str5 = str3;
                                if (jSONObject.has(str5) && (optJSONArray2 = jSONObject.optJSONArray(str5)) != null) {
                                    Map<String, a> map = this.f53256i;
                                    if (map != null && !map.containsKey(str)) {
                                        this.f53256i.put(str, new a(new JSONArray(optJSONArray2.toString()), optString));
                                    }
                                    int length2 = optJSONArray2.length();
                                    for (int i6 = 0; i6 < optJSONArray2.length(); i6++) {
                                        str4 = str4 + optJSONArray2.getString(i6);
                                        if (i6 < length2 - 1) {
                                            str4 = str4 + ",";
                                        }
                                    }
                                }
                                zVar.b(str4);
                                if ("col_apl".equals(str) && (zVar instanceof ab)) {
                                    String str6 = str2;
                                    if (jSONObject2.has(str6)) {
                                        ((ab) zVar).d(jSONObject2.optString(str6));
                                    }
                                    if (jSONObject2.has("batch")) {
                                        ((ab) zVar).c(jSONObject2.optString("batch"));
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            return zVar;
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j4) {
        SharedPreferences a4;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a4 = ar.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a4.edit();
            edit.putLong("config_ts", j4);
            edit.putLong("iucc_s1", parseLong);
            edit.putString("iucc_s2", str2).commit();
            UMRTLog.i("MobclickRT", "updateTsS1S2 : ts = " + j4 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f53255h)) {
                String[] split2 = this.f53255h.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i("MobclickRT", "\u91cd\u590d\u7684iucc S1 and S2, \u5ffd\u7565\u672c\u6b21\u66f4\u65b0\uff0c\u4e0d\u53d1\u8d77fetch\u3002");
                        return;
                    }
                }
            }
            SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
            if (a4 != null) {
                if (a4.getLong("config_ts", 0L) != parseLong) {
                    UMRTLog.i("MobclickRT", "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f53255h = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i("MobclickRT", "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f53255h = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z3) {
        try {
            SharedPreferences a4 = ar.a(UMGlobalContext.getAppContext());
            if (a4 != null) {
                SharedPreferences.Editor edit = a4.edit();
                if (z3) {
                    edit.putString("should_fetch", "1").commit();
                } else {
                    edit.putString("should_fetch", "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v54 */
    @Override // com.umeng.ccg.c.a
    public void a(Object obj, int i4) {
        Integer valueOf;
        ArrayList arrayList;
        int size;
        a aVar;
        a aVar2;
        a aVar3;
        boolean z3 = true;
        int i5 = 0;
        try {
            switch (i4) {
                case 101:
                    if (obj == null || !(obj instanceof String)) {
                        return;
                    }
                    String str = (String) obj;
                    UMRTLog.i("MobclickRT", "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                    JSONObject a4 = al.a(UMGlobalContext.getAppContext(), str);
                    if (a4 != null) {
                        UMRTLog.i("MobclickRT", "[imprint] send request. body: " + a4.toString());
                        as.a(new ao("https://ucc.umeng.com/v2/inn/fetch", a4, str), 0L, TimeUnit.SECONDS);
                    }
                    if (g()) {
                        c(UMGlobalContext.getAppContext());
                        String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "iucc", "");
                        UMRTLog.i("MobclickRT", "manual check iucc value: " + imprintProperty);
                        a(imprintProperty);
                        return;
                    }
                    return;
                case 102:
                    UMRTLog.i("MobclickRT", "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.f53255h = "";
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (a(jSONObject.optJSONObject("config"))) {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 103, a(), jSONObject);
                            return;
                        } else {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                            return;
                        }
                    }
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                    return;
                case 103:
                    UMRTLog.i("MobclickRT", "[workEvent]: recv FETCH_SUCCESS msg.");
                    Context appContext = UMGlobalContext.getAppContext();
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj;
                    JSONObject optJSONObject = jSONObject2.optJSONObject("config");
                    String optString = jSONObject2.optString("sourceIucc");
                    if (optJSONObject != null) {
                        if (g()) {
                            UMRTLog.i("MobclickRT", "--->>> \u6210\u529f\u62c9\u53d6\u4e91\u914d\u53c2\u6570\u540e\uff0c\u68c0\u6d4b\u5230should fetch\u6807\u5fd7\uff0c\u6e05\u9664\u6b64\u6807\u5fd7\u3002\u66f4\u65b0SDK\u7c7b\u578b\u96c6\u7f13\u5b58\u503c");
                            f();
                            a(false);
                        }
                        a(appContext, optJSONObject, optString);
                        return;
                    }
                    return;
                case 104:
                    UMRTLog.i("MobclickRT", "[workEvent]: recv FETCH_FAILED msg.");
                    return;
                case 105:
                    String[] collectItemList = CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    ?? r3 = 0;
                    while (r3 < length) {
                        String str2 = collectItemList[r3];
                        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(str2);
                        UMRTLog.i("MobclickRT", "[forbid_sdk] \u91c7\u96c6\u9879: " + str2 + "; \u503c: " + forbidSdkArray.toString());
                        r3++;
                    }
                    UMRTLog.i("MobclickRT", "[workEvent]: recv LOAD_CONFIG msg.");
                    Integer num = 0;
                    try {
                        JSONObject b4 = b(UMGlobalContext.getAppContext());
                        if (b4 != null) {
                            if (a(b4)) {
                                valueOf = Integer.valueOf(num.intValue() | 1);
                            } else {
                                valueOf = Integer.valueOf(num.intValue() | 0);
                            }
                        } else {
                            valueOf = Integer.valueOf(num.intValue() | 0);
                        }
                        r3 = new JSONObject();
                        r3.put("result", valueOf);
                        if (b4 != null) {
                            r3.put("config", b4);
                        }
                    } catch (Throwable unused) {
                    }
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), r3);
                    return;
                case 106:
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject3 = (JSONObject) obj;
                    if (jSONObject3.has("result")) {
                        if ((jSONObject3.optInt("result") & 1) != 0 && jSONObject3.has("config")) {
                            JSONObject optJSONObject2 = jSONObject3.optJSONObject("config");
                            f53249c = optJSONObject2;
                            if (optJSONObject2 != null) {
                                CcgAgent.notifyConfigReady(optJSONObject2);
                                i5 = 1;
                            }
                        }
                        if (i5 == 0) {
                            CcgAgent.notifyConfigReady(null);
                        }
                    }
                    if (e()) {
                        UMRTLog.i("MobclickRT", "--->>> \u68c0\u6d4b\u5230\u96c6\u6210\u7684SDK\u7c7b\u578b\u96c6\u5408\u53d1\u751f\u53d8\u5316\uff0c\u53d1\u8d77\u4e91\u914d\u53c2\u6570\u62c9\u53d6\u8bf7\u6c42(\u8bbe\u7f6e\u672c\u5730should fetch\u6807\u5fd7).");
                        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "iucc", "");
                        a(true);
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), imprintProperty2);
                        return;
                    }
                    c(UMGlobalContext.getAppContext());
                    String imprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "iucc", "");
                    UMRTLog.i("MobclickRT", "manual check iucc value: " + imprintProperty3);
                    a(imprintProperty3);
                    return;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str3 = (String) obj;
                                UMRTLog.i("MobclickRT", "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                a(str3);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            UMRTLog.e("MobclickRT", "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    return;
                default:
                    switch (i4) {
                        case 201:
                            UMRTLog.i("MobclickRT", "recv PARSE_CONFIG msg.");
                            if (obj == null || !(obj instanceof JSONObject)) {
                                return;
                            }
                            c((JSONObject) obj);
                            return;
                        case 202:
                            UMRTLog.i("MobclickRT", "recv COLLECTION_JUDGMENT msg.");
                            if (obj == null || !(obj instanceof ArrayList) || (size = (arrayList = (ArrayList) obj).size()) <= 0) {
                                return;
                            }
                            while (i5 < size) {
                                z zVar = (z) arrayList.get(i5);
                                JSONObject a5 = zVar.a(zVar.a(), null);
                                if (a5 != null) {
                                    long optLong = !Arrays.asList(f53250d).contains(zVar.a()) ? a5.optLong("delay") * 1000 : 0L;
                                    a5.remove("delay");
                                    UMRTLog.i("MobclickRT", "send START_COLLECT msg, delayTs = " + optLong);
                                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 203, a(), a5, optLong);
                                }
                                i5++;
                            }
                            return;
                        case 203:
                            if (obj == null || !(obj instanceof JSONObject)) {
                                return;
                            }
                            JSONObject jSONObject4 = (JSONObject) obj;
                            String optString2 = jSONObject4.optString("actionName");
                            UMRTLog.i("MobclickRT", "recv START_COLLECT msg. name is : " + optString2);
                            if (!com.umeng.ccg.b.a(optString2)) {
                                UMRTLog.i("MobclickRT", "Local switch of [" + optString2 + "] is off, ignore this command.");
                                return;
                            }
                            String jSONObject5 = jSONObject4.toString();
                            if (Arrays.asList(f53250d).contains(optString2)) {
                                if ("screen_on".equalsIgnoreCase(optString2)) {
                                    UMRTLog.i("MobclickRT", "register Intent.ACTION_SCREEN_ON");
                                    a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON");
                                }
                                if ("screen_off".equalsIgnoreCase(optString2)) {
                                    UMRTLog.i("MobclickRT", "register Intent.ACTION_SCREEN_OFF");
                                    a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF");
                                }
                                if ("screen_unlock".equalsIgnoreCase(optString2)) {
                                    UMRTLog.i("MobclickRT", "register Intent.ACTION_USER_PRESENT");
                                    a(UMGlobalContext.getAppContext(), "android.intent.action.USER_PRESENT");
                                    return;
                                }
                                return;
                            }
                            b(optString2);
                            if (CcgAgent.hasRegistedActionInfo()) {
                                if (CcgAgent.getActionInfo("anti") == null) {
                                    z3 = false;
                                }
                                String optString3 = jSONObject4.optString("local_hit_sdk");
                                if (!TextUtils.isEmpty(optString3)) {
                                    ActionInfo actionInfo = CcgAgent.getActionInfo(optString3);
                                    if (actionInfo != null) {
                                        UMRTLog.i("MobclickRT", "\u8c03\u7528[" + optString3 + "] onCommand\u63a5\u53e3\u65b9\u6cd5, \u53c2\u6570: " + jSONObject4.toString());
                                        actionInfo.onCommand(UMGlobalContext.getAppContext(), optString2, jSONObject4);
                                    }
                                } else {
                                    UMRTLog.i("MobclickRT", "\u5ffd\u7565 \u672c\u6b21\u91c7\u96c6\u9879[" + optString2 + "]\u91c7\u96c6\u8bf7\u6c42.");
                                }
                                if (z3) {
                                    return;
                                }
                                ap.a(UMGlobalContext.getAppContext(), jSONObject5);
                                return;
                            }
                            ap.a(UMGlobalContext.getAppContext(), jSONObject5);
                            return;
                        default:
                            switch (i4) {
                                case 301:
                                    UMRTLog.i("MobclickRT", "recv REPORT_SCREEN_ON msg.");
                                    b("screen_on");
                                    if (!this.f53256i.containsKey("screen_on") || (aVar = this.f53256i.get("screen_on")) == null) {
                                        return;
                                    }
                                    JSONObject a6 = al.a(UMGlobalContext.getAppContext(), 1, aVar.a(), aVar.b());
                                    UMRTLog.i("MobclickRT", "screen_on event param: " + a6.toString());
                                    as.a(new an("https://aspect-upush.umeng.com/occa/v1/event/report", a6), 0L, TimeUnit.SECONDS);
                                    return;
                                case 302:
                                    UMRTLog.i("MobclickRT", "recv REPORT_SCREEN_OFF msg.");
                                    b("screen_off");
                                    if (!this.f53256i.containsKey("screen_off") || (aVar2 = this.f53256i.get("screen_off")) == null) {
                                        return;
                                    }
                                    JSONObject a7 = al.a(UMGlobalContext.getAppContext(), 3, aVar2.a(), aVar2.b());
                                    UMRTLog.i("MobclickRT", "screen_off event param: " + a7.toString());
                                    as.a(new an("https://aspect-upush.umeng.com/occa/v1/event/report", a7), 0L, TimeUnit.SECONDS);
                                    return;
                                case 303:
                                    UMRTLog.i("MobclickRT", "recv REPORT_SCREEN_UNLOCK msg.");
                                    b("screen_unlock");
                                    if (!this.f53256i.containsKey("screen_unlock") || (aVar3 = this.f53256i.get("screen_unlock")) == null) {
                                        return;
                                    }
                                    JSONObject a8 = al.a(UMGlobalContext.getAppContext(), 2, aVar3.a(), aVar3.b());
                                    UMRTLog.i("MobclickRT", "screen_unlock event param: " + a8.toString());
                                    as.a(new an("https://aspect-upush.umeng.com/occa/v1/event/report", a8), 0L, TimeUnit.SECONDS);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } catch (Throwable unused2) {
        }
    }
}
