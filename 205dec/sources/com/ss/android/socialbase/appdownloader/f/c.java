package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.r;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, r.c> f49070c = new HashMap<>();

    public static boolean c(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && c(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean w(JSONObject jSONObject) {
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

    public static boolean xv(JSONObject jSONObject) {
        return jSONObject == null || f.c() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return w(jSONObject) && c(jSONObject.optJSONArray("device_requirements")) && xv(jSONObject);
    }

    public static boolean c(JSONArray jSONArray) {
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
                        str = ux.p();
                    }
                    r.c w3 = w(str);
                    if (w3 != null && !(z3 = c(optJSONArray, optJSONArray2, optString2, w3))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return z3;
    }

    private static boolean w(JSONArray jSONArray, String str) {
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

    private static r.c w(String str) {
        HashMap<String, r.c> hashMap = f49070c;
        if (hashMap.containsKey(str)) {
            r.c cVar = hashMap.get(str);
            if (cVar != null) {
                return cVar;
            }
            return null;
        }
        r.c w3 = r.w(str);
        hashMap.put(str, w3);
        if (w3 != null) {
            return w3;
        }
        return null;
    }

    private static boolean c(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull r.c cVar) {
        String r3 = cVar.r();
        int f4 = cVar.f();
        String str2 = f4 + "_" + r3;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i4 = 0; i4 < split.length; i4 += 2) {
                    int parseInt = Integer.parseInt(split[i4]);
                    int parseInt2 = Integer.parseInt(split[i4 + 1]);
                    if (f4 >= parseInt && f4 <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (w(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !w(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static r.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                r.c w3 = w(str);
                if (w3 != null) {
                    return w3;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean c(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String c4 = xv.c(jSONObject.optString("az"), optString);
                String c5 = xv.c(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(c4);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(c5);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
