package com.iab.omid.library.mmadbridge.p204d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.p202b.C7088c;
import com.iab.omid.library.mmadbridge.walking.C7119b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.d.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7101b {

    /* renamed from: a */
    private static WindowManager f24255a;

    /* renamed from: b */
    private static String[] f24256b = {"x", "y", "width", "height"};

    /* renamed from: c */
    static float f24257c = Resources.getSystem().getDisplayMetrics().density;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.iab.omid.library.mmadbridge.d.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7102a {

        /* renamed from: a */
        final float f24258a;

        /* renamed from: b */
        final float f24259b;

        C7102a(float f, float f2) {
            this.f24258a = f;
            this.f24259b = f2;
        }
    }

    /* renamed from: a */
    static float m34695a(int i) {
        return i / f24257c;
    }

    /* renamed from: b */
    public static JSONObject m34694b(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", m34695a(i));
            jSONObject.put("y", m34695a(i2));
            jSONObject.put("width", m34695a(i3));
            jSONObject.put("height", m34695a(i4));
        } catch (JSONException e) {
            C7103c.m34676b("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static void m34693c(Context context) {
        if (context != null) {
            f24257c = context.getResources().getDisplayMetrics().density;
            f24255a = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: d */
    public static void m34692d(JSONObject jSONObject) {
        C7102a m34685k = m34685k(jSONObject);
        try {
            jSONObject.put("width", m34685k.f24258a);
            jSONObject.put("height", m34685k.f24259b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public static void m34691e(JSONObject jSONObject, C7119b.C7120a c7120a) {
        C7088c m34584a = c7120a.m34584a();
        JSONArray jSONArray = new JSONArray();
        for (String str : c7120a.m34582c()) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", m34584a.m34741b());
            jSONObject.put("friendlyObstructionPurpose", m34584a.m34740c());
            jSONObject.put("friendlyObstructionReason", m34584a.m34739d());
        } catch (JSONException e) {
            C7103c.m34676b("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: f */
    public static void m34690f(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e) {
            C7103c.m34676b("Error with setting not visible reason", e);
        }
    }

    /* renamed from: g */
    public static void m34689g(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C7103c.m34676b("Error with setting ad session id", e);
        }
    }

    /* renamed from: h */
    public static void m34688h(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e) {
            C7103c.m34676b("JSONException during JSONObject.put for name [" + str + "]", e);
        }
    }

    /* renamed from: i */
    public static void m34687i(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private static boolean m34686j(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    /* renamed from: k */
    private static C7102a m34685k(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (f24255a != null) {
            Point point = new Point(0, 0);
            f24255a.getDefaultDisplay().getRealSize(point);
            f2 = m34695a(point.x);
            f = m34695a(point.y);
        } else {
            f = 0.0f;
        }
        return new C7102a(f2, f);
    }

    /* renamed from: l */
    public static void m34684l(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C7103c.m34676b("Error with setting not visible reason", e);
        }
    }

    /* renamed from: m */
    public static boolean m34683m(@NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && m34682n(jSONObject, jSONObject2) && m34680p(jSONObject, jSONObject2) && m34681o(jSONObject, jSONObject2) && m34679q(jSONObject, jSONObject2) && m34678r(jSONObject, jSONObject2);
    }

    /* renamed from: n */
    private static boolean m34682n(JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        for (String str : f24256b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: o */
    private static boolean m34681o(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    /* renamed from: p */
    private static boolean m34680p(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    /* renamed from: q */
    private static boolean m34679q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (m34686j(optJSONArray, optJSONArray2)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!optJSONArray.optString(i, "").equals(optJSONArray2.optString(i, ""))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: r */
    private static boolean m34678r(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (m34686j(optJSONArray, optJSONArray2)) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!m34683m(optJSONArray.optJSONObject(i), optJSONArray2.optJSONObject(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
