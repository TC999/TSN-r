package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38041a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38042b;

    public au(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38171g).intValue(), 0, 200, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38041a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38041a;
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public List b(String str) {
        JSONObject jSONObject = this.f38041a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                String a4 = i.a("98bb0a15913e0654348b", "0805");
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    String string2 = jSONArray.getString(i4);
                    if (string2.contains(a4)) {
                        this.f38042b = true;
                    } else {
                        arrayList.add(string2);
                    }
                }
                if (arrayList.size() > 0) {
                    return arrayList;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public boolean a() {
        return this.f38042b;
    }
}
