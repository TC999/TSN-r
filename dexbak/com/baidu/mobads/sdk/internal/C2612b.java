package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2612b {

    /* renamed from: a */
    private int f8638a = 0;

    /* renamed from: b */
    private List<C2573a> f8639b = new ArrayList();

    /* renamed from: a */
    public static C2612b m50842a(String str) {
        C2612b c2612b = new C2612b();
        if (TextUtils.isEmpty(str)) {
            return c2612b;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c2612b.f8638a = jSONObject.optInt("n", 0);
            int optInt = jSONObject.optInt("enc", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray(UMCommonContent.f37822az);
            if (optInt == 1) {
                String optString = jSONObject.optString(UMCommonContent.f37822az);
                if (!TextUtils.isEmpty(optString)) {
                    String m50392b = C2709h.m50392b(optString);
                    if (!TextUtils.isEmpty(m50392b)) {
                        optJSONArray = new JSONArray(m50392b);
                    }
                }
            }
            c2612b.f8639b = C2573a.m51104a(optJSONArray);
            return c2612b;
        } catch (Throwable th) {
            th.printStackTrace();
            return c2612b;
        }
    }

    /* renamed from: a */
    public List<C2573a> m50843a() {
        return this.f8639b;
    }
}
