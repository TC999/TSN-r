package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2715l {

    /* renamed from: a */
    private int f9095a;

    /* renamed from: b */
    private String f9096b;

    /* renamed from: a */
    public static List<CpuChannelResponse> m50359a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    C2715l m50358a = m50358a(jSONArray.getJSONObject(i));
                    if (m50358a != null) {
                        arrayList.add(new CpuChannelResponse(m50358a));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public String m50357b() {
        return this.f9096b;
    }

    /* renamed from: a */
    private static C2715l m50358a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        C2715l c2715l = new C2715l();
        c2715l.f9095a = optInt;
        c2715l.f9096b = optString;
        return c2715l;
    }

    /* renamed from: a */
    public int m50360a() {
        return this.f9095a;
    }
}
