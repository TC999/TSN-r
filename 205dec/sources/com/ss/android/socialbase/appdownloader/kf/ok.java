package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.h;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {
    private static final HashMap<String, h.ok> ok = new HashMap<>();

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i4 = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString("allow_os_api_range");
        int optInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i4 >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i5 = 0; i5 < split.length; i5 += 2) {
                int parseInt = Integer.parseInt(split[i5]);
                int parseInt2 = Integer.parseInt(split[i5 + 1]);
                if (i4 >= parseInt && i4 <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    public static boolean bl(JSONObject jSONObject) {
        return jSONObject == null || kf.ok() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean ok(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && ok(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return a(jSONObject) && ok(jSONObject.optJSONArray("device_requirements")) && bl(jSONObject);
    }

    public static boolean ok(JSONArray jSONArray) {
        int length;
        String[] split;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z3 = false;
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if ("market".equals(str)) {
                        str = n.k();
                    }
                    h.ok a4 = a(str);
                    if (a4 != null && !(z3 = ok(optJSONArray, optJSONArray2, optString2, a4))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return z3;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i4).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static h.ok a(String str) {
        HashMap<String, h.ok> hashMap = ok;
        if (hashMap.containsKey(str)) {
            h.ok okVar = hashMap.get(str);
            if (okVar != null) {
                return okVar;
            }
            return null;
        }
        h.ok a4 = h.a(str);
        hashMap.put(str, a4);
        if (a4 != null) {
            return a4;
        }
        return null;
    }

    private static boolean ok(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull h.ok okVar) {
        String h4 = okVar.h();
        int kf = okVar.kf();
        String str2 = kf + "_" + h4;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i4 = 0; i4 < split.length; i4 += 2) {
                    int parseInt = Integer.parseInt(split[i4]);
                    int parseInt2 = Integer.parseInt(split[i4 + 1]);
                    if (kf >= parseInt && kf <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (a(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !a(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static h.ok ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                h.ok a4 = a(str);
                if (a4 != null) {
                    return a4;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean ok(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String ok2 = bl.ok(jSONObject.optString("az"), optString);
                String ok3 = bl.ok(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(ok2);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(ok3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
