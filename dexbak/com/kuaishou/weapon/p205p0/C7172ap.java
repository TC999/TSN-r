package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ap */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7172ap {

    /* renamed from: a */
    private JSONObject f24526a;

    public C7172ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24675g).intValue(), 0, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24526a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public JSONObject m34345a(String str) {
        JSONObject jSONObject = this.f24526a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                return new JSONObject(string);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public String m34344b(String str) {
        JSONObject jSONObject = this.f24526a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    if (string.contains("{}")) {
                        return null;
                    }
                    return string;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
