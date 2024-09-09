package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12453a = 0;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f12454b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f12453a = jSONObject.optInt("n", 0);
            int optInt = jSONObject.optInt("enc", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("ad");
            if (optInt == 1) {
                String optString = jSONObject.optString("ad");
                if (!TextUtils.isEmpty(optString)) {
                    String b4 = h.b(optString);
                    if (!TextUtils.isEmpty(b4)) {
                        optJSONArray = new JSONArray(b4);
                    }
                }
            }
            bVar.f12454b = a.a(optJSONArray);
            return bVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }

    public List<a> a() {
        return this.f12454b;
    }
}
