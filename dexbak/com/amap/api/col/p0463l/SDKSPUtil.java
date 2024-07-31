package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0463l.SDKInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.z5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SDKSPUtil {

    /* renamed from: a */
    private SDKInfo f5824a;

    public SDKSPUtil(String str) {
        this.f5824a = null;
        try {
            this.f5824a = new SDKInfo.C1869a(str, "1.0", "1.0.0").m54390b(new String[]{"info"}).m54389c();
        } catch (AMapCoreException unused) {
        }
    }

    /* renamed from: a */
    private static SDKInfo m53322a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.getString(i));
            }
            return new SDKInfo.C1869a(optString, optString2, optString).m54391a(optString3).m54390b((String[]) arrayList.toArray(new String[0])).m54389c();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public final List<SDKInfo> m53321b(Context context) {
        try {
            JSONArray jSONArray = new JSONArray(SPConfig.m53400a(context, this.f5824a, "rbck"));
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                SDKInfo sDKInfo = null;
                try {
                    sDKInfo = m53322a(jSONArray.getJSONObject(i));
                } catch (JSONException unused) {
                }
                if (sDKInfo != null) {
                    arrayList.add(sDKInfo);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    /* renamed from: c */
    public final void m53320c(Context context, SDKInfo sDKInfo) {
        JSONArray jSONArray;
        if (sDKInfo == null) {
            return;
        }
        ArrayList<SDKInfo> arrayList = new ArrayList();
        arrayList.add(sDKInfo);
        if (arrayList.size() == 0) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray();
            for (SDKInfo sDKInfo2 : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("a", sDKInfo2.m54400a());
                    jSONObject.put("b", sDKInfo2.m54396e());
                    jSONObject.put("c", sDKInfo2.m54395f());
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; sDKInfo2.m54392i() != null && i < sDKInfo2.m54392i().length; i++) {
                        jSONArray2.put(sDKInfo2.m54392i()[i]);
                    }
                    jSONObject.put("d", jSONArray2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        String jSONArray3 = jSONArray.toString();
        if (TextUtils.isEmpty(jSONArray3)) {
            return;
        }
        SPConfig.m53399b(context, this.f5824a, "rbck", jSONArray3);
    }
}
