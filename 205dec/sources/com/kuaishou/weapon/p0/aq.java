package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38035a;

    public aq(Context context, int i4) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38167c).intValue(), 3, i4, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38035a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38035a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(String str) {
        JSONObject jSONObject = this.f38035a;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(optString) && optString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i4), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
