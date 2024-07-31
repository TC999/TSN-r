package com.p521ss.android.socialbase.appdownloader.p543kf;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.appdownloader.C12310h;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12318ok {

    /* renamed from: ok */
    private static final HashMap<String, C12310h.C12311ok> f34745ok = new HashMap<>();

    /* renamed from: a */
    public static boolean m18221a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString("allow_os_api_range");
        int optInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split[i2 + 1]);
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: bl */
    public static boolean m18220bl(JSONObject jSONObject) {
        return jSONObject == null || C12316kf.m18251ok() || jSONObject.optInt("scy_mode") != 1;
    }

    /* renamed from: ok */
    public static boolean m18217ok(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && m18215ok(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m18215ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return m18221a(jSONObject) && m18218ok(jSONObject.optJSONArray("device_requirements")) && m18220bl(jSONObject);
    }

    /* renamed from: ok */
    public static boolean m18218ok(JSONArray jSONArray) {
        int length;
        String[] split;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
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
                        str = C12317n.m18239k();
                    }
                    C12310h.C12311ok m18223a = m18223a(str);
                    if (m18223a != null && !(z = m18216ok(optJSONArray, optJSONArray2, optString2, m18223a))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m18222a(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static C12310h.C12311ok m18223a(String str) {
        HashMap<String, C12310h.C12311ok> hashMap = f34745ok;
        if (hashMap.containsKey(str)) {
            C12310h.C12311ok c12311ok = hashMap.get(str);
            if (c12311ok != null) {
                return c12311ok;
            }
            return null;
        }
        C12310h.C12311ok m18380a = C12310h.m18380a(str);
        hashMap.put(str, m18380a);
        if (m18380a != null) {
            return m18380a;
        }
        return null;
    }

    /* renamed from: ok */
    private static boolean m18216ok(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull C12310h.C12311ok c12311ok) {
        String m18372h = c12311ok.m18372h();
        int m18371kf = c12311ok.m18371kf();
        String str2 = m18371kf + "_" + m18372h;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i = 0; i < split.length; i += 2) {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split[i + 1]);
                    if (m18371kf >= parseInt && m18371kf <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (m18222a(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !m18222a(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    public static C12310h.C12311ok m18219ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                C12310h.C12311ok m18223a = m18223a(str);
                if (m18223a != null) {
                    return m18223a;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: ok */
    public static boolean m18214ok(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String m18260ok = C12315bl.m18260ok(jSONObject.optString("az"), optString);
                String m18260ok2 = C12315bl.m18260ok(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(m18260ok);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(m18260ok2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
