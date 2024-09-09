package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.p4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SDKSPUtil.java */
/* renamed from: com.amap.api.col.3l.a6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a6 {

    /* renamed from: a  reason: collision with root package name */
    private p4 f7110a;

    public a6(String str) {
        this.f7110a = null;
        try {
            this.f7110a = new p4.a(str, "1.0", "1.0.0").b(new String[]{"info"}).c();
        } catch (fk unused) {
        }
    }

    private static p4 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                arrayList.add(optJSONArray.getString(i4));
            }
            return new p4.a(optString, optString2, optString).a(optString3).b((String[]) arrayList.toArray(new String[0])).c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final List<p4> b(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(z5.a(context, this.f7110a, "rbck"));
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                p4 p4Var = null;
                try {
                    p4Var = a(jSONArray.getJSONObject(i4));
                } catch (JSONException unused) {
                }
                if (p4Var != null) {
                    arrayList.add(p4Var);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    public final void c(Context context, p4 p4Var) {
        JSONArray jSONArray;
        if (p4Var == null) {
            return;
        }
        ArrayList<p4> arrayList = new ArrayList();
        arrayList.add(p4Var);
        if (arrayList.size() == 0) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray();
            for (p4 p4Var2 : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a", p4Var2.a());
                    jSONObject.put("b", p4Var2.e());
                    jSONObject.put("c", p4Var2.f());
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; p4Var2.i() != null && i4 < p4Var2.i().length; i4++) {
                        jSONArray2.put(p4Var2.i()[i4]);
                    }
                    jSONObject.put("d", jSONArray2);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        String jSONArray3 = jSONArray.toString();
        if (TextUtils.isEmpty(jSONArray3)) {
            return;
        }
        z5.b(context, this.f7110a, "rbck", jSONArray3);
    }
}
