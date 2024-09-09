package com.bytedance.c.w.xv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.bytedance.c.w.b;
import com.bytedance.c.w.d;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f26648c = {"version_code", "manifest_version_code", "aid", "update_version_code"};

    /* renamed from: a  reason: collision with root package name */
    private Context f26649a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f26650b = new JSONObject();

    public b(Context context) {
        this.f26649a = context;
    }

    public static b a(Context context) {
        b bVar = new b(context);
        JSONObject b4 = bVar.b();
        bVar.e(b4);
        bVar.n(b4);
        bVar.h(b4);
        bVar.i(b4);
        bVar.f(b4);
        bVar.g(b4);
        bVar.l(b4);
        return bVar;
    }

    @SuppressLint({"MissingPermission"})
    private void e(JSONObject jSONObject) {
        int i4;
        try {
            ApplicationInfo applicationInfo = this.f26649a.getPackageManager().getPackageInfo(this.f26649a.getPackageName(), 0).applicationInfo;
            if (applicationInfo != null && (i4 = applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.f26649a.getString(i4));
            }
            jSONObject.put("sdk_version", 134);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.14-cloud");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", m());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", j());
        } catch (Exception unused) {
        }
    }

    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put("access", b.i.a(this.f26649a));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private void g(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f26649a.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void h(JSONObject jSONObject) {
        try {
            String language = this.f26649a.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    private void i(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (b.q.f()) {
                sb.append("MIUI-");
            } else if (b.q.c()) {
                sb.append("FLYME-");
            } else {
                String a4 = b.q.a();
                if (b.q.b(a4)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a4)) {
                    sb.append(a4);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", b.d.c());
        } catch (Throwable unused) {
        }
    }

    private String j() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                int i4 = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (i4 >= strArr.length) {
                        break;
                    }
                    sb.append(strArr[i4]);
                    if (i4 != strArr.length - 1) {
                        sb.append(", ");
                    }
                    i4++;
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e4) {
            b.k.c(e4);
            return "unknown";
        }
    }

    private void l(JSONObject jSONObject) {
        Map<String, Object> e4;
        Object obj;
        com.bytedance.c.w.ux.a a4 = d.a();
        if (a4 == null || jSONObject == null || (e4 = a4.e()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : e4.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = e4.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Exception e5) {
            b.k.c(e5);
        }
    }

    private String m() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private void n(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.f26649a.getResources().getDisplayMetrics();
            int i4 = displayMetrics.densityDpi;
            String str = i4 != 120 ? i4 != 240 ? i4 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i4);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    public JSONObject b() {
        return this.f26650b;
    }

    public JSONObject c(String str) {
        try {
            this.f26650b.put("device_id", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f26650b;
    }

    public JSONObject d(@Nullable Map<String, Object> map) {
        String[] strArr;
        if (map == null) {
            return this.f26650b;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.f26650b.has(entry.getKey())) {
                this.f26650b.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : f26648c) {
            if (map.containsKey(str)) {
                try {
                    this.f26650b.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.f26650b.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.f26650b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.f26650b.put("udid", map.get("iid"));
            this.f26650b.remove("iid");
        }
        return this.f26650b;
    }

    public JSONObject k(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f26650b.put("user_id", str);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f26650b;
    }
}
