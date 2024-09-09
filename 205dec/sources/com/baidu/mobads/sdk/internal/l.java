package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private int f12881a;

    /* renamed from: b  reason: collision with root package name */
    private String f12882b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    l a4 = a(jSONArray.getJSONObject(i4));
                    if (a4 != null) {
                        arrayList.add(new CpuChannelResponse(a4));
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f12882b;
    }

    private static l a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        l lVar = new l();
        lVar.f12881a = optInt;
        lVar.f12882b = optString;
        return lVar;
    }

    public int a() {
        return this.f12881a;
    }
}
