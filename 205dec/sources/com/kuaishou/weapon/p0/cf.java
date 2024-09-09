package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cf {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38158a;

    public cf(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(nop)) {
                return;
            }
            try {
                this.f38158a = new JSONObject(nop);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38158a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f38158a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                try {
                    if (jSONArray.length() > 0) {
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                            String a4 = f.a(jSONObject2.optString("1"));
                            String a5 = f.a(jSONObject2.optString("2"));
                            if (!TextUtils.isEmpty(a4)) {
                                jSONObject2.put("1", a4);
                            }
                            if (!TextUtils.isEmpty(a5)) {
                                jSONObject2.put("2", a5);
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
