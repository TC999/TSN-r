package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.av */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7178av {

    /* renamed from: a */
    private JSONObject f24535a;

    public C7178av(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24671c).intValue(), 4, i, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24535a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34322a(String str) {
        JSONObject jSONObject = this.f24535a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                if (string.length() > 2) {
                    return string;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
