package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.by */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7210by {

    /* renamed from: a */
    private JSONObject f24624a;

    public C7210by(Context context) {
        if (Engine.loadSuccess) {
            String cde = Engine.getInstance(context).cde();
            if (TextUtils.isEmpty(cde)) {
                return;
            }
            try {
                this.f24624a = new JSONObject(cde);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34115a(String str) {
        JSONObject jSONObject = this.f24624a;
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
    public JSONArray m34114b(String str) {
        JSONObject jSONObject = this.f24624a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONArray(string);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
