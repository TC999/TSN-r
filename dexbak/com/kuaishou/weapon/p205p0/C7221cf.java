package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7221cf {

    /* renamed from: a */
    private JSONObject f24659a;

    public C7221cf(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(nop)) {
                return;
            }
            try {
                this.f24659a = new JSONObject(nop);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34094a(String str) {
        JSONObject jSONObject = this.f24659a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public JSONArray m34093b(String str) {
        JSONObject jSONObject = this.f24659a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                try {
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String m33897a = C7281f.m33897a(jSONObject2.optString("1"));
                            String m33897a2 = C7281f.m33897a(jSONObject2.optString("2"));
                            if (!TextUtils.isEmpty(m33897a)) {
                                jSONObject2.put("1", m33897a);
                            }
                            if (!TextUtils.isEmpty(m33897a2)) {
                                jSONObject2.put("2", m33897a2);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                return jSONArray;
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }
}
