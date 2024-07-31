package com.mbridge.msdk.videocommon.p513b;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.videocommon.b.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Cbprule {

    /* renamed from: a */
    private int f32195a;

    /* renamed from: b */
    private List<Integer> f32196b;

    private Cbprule(int i, List<Integer> list) {
        this.f32195a = i;
        this.f32196b = list;
    }

    /* renamed from: a */
    public final int m20875a() {
        return this.f32195a;
    }

    /* renamed from: b */
    public final List<Integer> m20873b() {
        return this.f32196b;
    }

    /* renamed from: a */
    public static Cbprule m20874a(JSONObject jSONObject) {
        Cbprule cbprule = new Cbprule(1, Arrays.asList(1, 2, 3, 4));
        if (jSONObject == null) {
            return cbprule;
        }
        try {
            int optInt = jSONObject.optInt("type");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(DomainCampaignEx.LOOPBACK_VALUE);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
            return new Cbprule(optInt, arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            return cbprule;
        }
    }
}
