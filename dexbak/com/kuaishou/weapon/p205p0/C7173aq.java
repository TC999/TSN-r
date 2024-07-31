package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.aq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7173aq {

    /* renamed from: a */
    private JSONObject f24527a;

    public C7173aq(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 3, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24527a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34343a(String str) {
        JSONObject jSONObject = this.f24527a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public Set m34342b(String str) {
        JSONObject jSONObject = this.f24527a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
