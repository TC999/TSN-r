package cn.jiguang.bs;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.analytics.page.PushSA;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f2839c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f2840d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private long f2841a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Set<String>> f2842b = new HashMap();

    private a() {
    }

    public static a a() {
        if (f2839c == null) {
            synchronized (f2840d) {
                if (f2839c == null) {
                    f2839c = new a();
                }
            }
        }
        return f2839c;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (optJSONArray != null) {
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            linkedHashSet.add(optJSONArray.getString(i4));
                        }
                    }
                    hashMap.put(next, linkedHashSet);
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                this.f2842b = hashMap;
            } catch (JSONException unused) {
            }
        }
    }

    public a a(Context context) {
        try {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.S())).longValue();
            long j4 = this.f2841a;
            if (j4 == 0 || j4 != longValue) {
                this.f2841a = longValue;
                String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.Q());
                if (!TextUtils.isEmpty(str)) {
                    a(new JSONObject(str));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1051289244:
                if (str.equals("active_user")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c4 = 4;
                    break;
                }
                break;
            case -820729752:
                if (str.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                    c4 = 5;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c4 = 6;
                    break;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    c4 = 7;
                    break;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c4 = 11;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c4 = '\r';
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c4 = 14;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 3:
            case 5:
                return "active_user";
            case 1:
            case '\f':
            case 14:
                return "account";
            case 2:
            case 6:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\r':
                return "awake";
            case 4:
                break;
            case 7:
                return "android_notification_state";
            default:
                if (this.f2842b.containsKey(str)) {
                    return str;
                }
                break;
        }
        return "normal";
    }

    public String a(Set<String> set) {
        if (set != null) {
            try {
                if (!set.isEmpty()) {
                    String str = null;
                    for (String str2 : set) {
                        String a4 = a(str2);
                        if (str == null) {
                            str = a4;
                        } else if (!str.equals(a4)) {
                            cn.jiguang.bq.d.i("AddressGroupManager", "Report JSONArray belong more than one space, using normal-space");
                            return "normal";
                        }
                    }
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        return "normal";
    }

    public void a(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
        long j4 = 3600000;
        try {
            long j5 = jSONObject.getLong("ttl");
            if (j5 >= 0) {
                j4 = j5;
            }
        } catch (JSONException unused) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ips");
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[4];
        aVarArr[0] = cn.jiguang.g.a.R().a((cn.jiguang.g.a<String>) optJSONArray.toString());
        aVarArr[1] = cn.jiguang.g.a.T().a((cn.jiguang.g.a<Long>) Long.valueOf(j4 * 1000));
        aVarArr[2] = cn.jiguang.g.a.S().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis()));
        aVarArr[3] = cn.jiguang.g.a.Q().a((cn.jiguang.g.a<String>) (optJSONObject != null ? optJSONObject.toString() : ""));
        cn.jiguang.g.b.a(context, aVarArr);
        a(optJSONObject);
    }

    public a b(Context context) {
        boolean z3;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(context);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.T())).longValue();
            if (longValue < 0) {
                longValue = 3600000;
            } else if (longValue < 60000) {
                longValue = 60000;
            }
            if (longValue > 604800000) {
                longValue = 604800000;
            }
            SimpleDateFormat a4 = cn.jiguang.f.b.a("yyyy-MM-dd HH:mm:ss");
            cn.jiguang.bq.d.c("AddressGroupManager", "lastUpdateTime=" + a4.format(new Date(this.f2841a)) + " now=" + a4.format(new Date(currentTimeMillis)) + " expire=" + (longValue / 1000));
            long j4 = this.f2841a;
            if (j4 == 0 || j4 + longValue < currentTimeMillis) {
                cn.jiguang.bq.d.c("AddressGroupManager", "cache invalid, fetch new urls");
                Map<String, Set<String>> map = this.f2842b;
                if (map != null && !map.isEmpty()) {
                    z3 = false;
                    e.a(context, z3);
                }
                z3 = true;
                e.a(context, z3);
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("AddressGroupManager", "refresh e" + th);
        }
        return this;
    }

    public Set<String> b(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            Set<String> set2 = null;
            for (String str : set) {
                Set<String> set3 = this.f2842b.get(a(str));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.f2842b.get("normal");
    }
}
