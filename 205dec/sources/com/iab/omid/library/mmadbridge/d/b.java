package com.iab.omid.library.mmadbridge.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.walking.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f37737a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f37738b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    static float f37739c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final float f37740a;

        /* renamed from: b  reason: collision with root package name */
        final float f37741b;

        a(float f4, float f5) {
            this.f37740a = f4;
            this.f37741b = f5;
        }
    }

    static float a(int i4) {
        return i4 / f37739c;
    }

    public static JSONObject b(int i4, int i5, int i6, int i7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", a(i4));
            jSONObject.put("y", a(i5));
            jSONObject.put("width", a(i6));
            jSONObject.put("height", a(i7));
        } catch (JSONException e4) {
            c.b("Error with creating viewStateObject", e4);
        }
        return jSONObject;
    }

    public static void c(Context context) {
        if (context != null) {
            f37739c = context.getResources().getDisplayMetrics().density;
            f37737a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void d(JSONObject jSONObject) {
        a k4 = k(jSONObject);
        try {
            jSONObject.put("width", k4.f37740a);
            jSONObject.put("height", k4.f37741b);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public static void e(JSONObject jSONObject, b.a aVar) {
        com.iab.omid.library.mmadbridge.b.c a4 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        for (String str : aVar.c()) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a4.b());
            jSONObject.put("friendlyObstructionPurpose", a4.c());
            jSONObject.put("friendlyObstructionReason", a4.d());
        } catch (JSONException e4) {
            c.b("Error with setting friendly obstruction", e4);
        }
    }

    public static void f(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e4) {
            c.b("Error with setting not visible reason", e4);
        }
    }

    public static void g(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e4) {
            c.b("Error with setting ad session id", e4);
        }
    }

    public static void h(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e4) {
            c.b("JSONException during JSONObject.put for name [" + str + "]", e4);
        }
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private static boolean j(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    private static a k(JSONObject jSONObject) {
        float f4;
        float f5 = 0.0f;
        if (f37737a != null) {
            Point point = new Point(0, 0);
            f37737a.getDefaultDisplay().getRealSize(point);
            f5 = a(point.x);
            f4 = a(point.y);
        } else {
            f4 = 0.0f;
        }
        return new a(f5, f4);
    }

    public static void l(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e4) {
            c.b("Error with setting not visible reason", e4);
        }
    }

    public static boolean m(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && n(jSONObject, jSONObject2) && p(jSONObject, jSONObject2) && o(jSONObject, jSONObject2) && q(jSONObject, jSONObject2) && r(jSONObject, jSONObject2);
    }

    private static boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : f37738b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    private static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (j(optJSONArray, optJSONArray2)) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                if (!optJSONArray.optString(i4, "").equals(optJSONArray2.optString(i4, ""))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean r(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (j(optJSONArray, optJSONArray2)) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                if (!m(optJSONArray.optJSONObject(i4), optJSONArray2.optJSONObject(i4))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
