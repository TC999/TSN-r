package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38043a;

    public av(Context context, int i4) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38167c).intValue(), 4, i4, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38043a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38043a;
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