package com.mbridge.msdk.videocommon.b;

import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdUnitInfo.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f40940a;

    /* renamed from: b  reason: collision with root package name */
    private int f40941b;

    /* renamed from: c  reason: collision with root package name */
    private a f40942c;

    public b(int i4, int i5, a aVar) {
        this.f40940a = i4;
        this.f40941b = i5;
        this.f40942c = aVar;
    }

    public final int a() {
        return this.f40940a;
    }

    public final int b() {
        return this.f40941b;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(EventMonitor.V3_PARAMS);
                    arrayList.add(new b(optInt, optInt2, optJSONObject2 != null ? a.a(optJSONObject2) : null));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }
}
