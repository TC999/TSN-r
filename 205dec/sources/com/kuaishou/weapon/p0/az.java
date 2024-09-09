package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38047a;

    public az(Context context, int i4) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38167c).intValue(), 2, i4 < 10 ? 10 : i4, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38047a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f38047a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public JSONObject a(String str) {
        try {
            String b4 = b(str);
            if (TextUtils.isEmpty(b4)) {
                return null;
            }
            return new JSONObject(b4);
        } catch (Exception unused) {
            return null;
        }
    }
}
