package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardSetting.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f40955a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, d> f40956b;

    /* renamed from: c  reason: collision with root package name */
    private long f40957c;

    /* renamed from: d  reason: collision with root package name */
    private long f40958d;

    /* renamed from: e  reason: collision with root package name */
    private long f40959e;

    /* renamed from: f  reason: collision with root package name */
    private long f40960f;

    /* renamed from: g  reason: collision with root package name */
    private long f40961g;

    /* renamed from: h  reason: collision with root package name */
    private long f40962h;

    /* renamed from: j  reason: collision with root package name */
    private String f40964j;

    /* renamed from: i  reason: collision with root package name */
    private int f40963i = 0;

    /* renamed from: k  reason: collision with root package name */
    private String f40965k = "";

    public final String a() {
        return this.f40965k;
    }

    public final String b() {
        return this.f40964j;
    }

    public final long c() {
        return this.f40957c * 1000;
    }

    public final long d() {
        return this.f40958d * 1000;
    }

    public final long e() {
        return this.f40959e * 1000;
    }

    public final long f() {
        return this.f40960f;
    }

    public final long g() {
        return this.f40961g;
    }

    public final long h() {
        return this.f40962h;
    }

    public final Map<String, Integer> i() {
        if (this.f40955a == null) {
            HashMap hashMap = new HashMap();
            this.f40955a = hashMap;
            hashMap.put("1", 1000);
            this.f40955a.put("9", 1000);
            this.f40955a.put("8", 1000);
        }
        return this.f40955a;
    }

    public final Map<String, d> j() {
        return this.f40956b;
    }

    public final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f40955a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f40955a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            Map<String, d> map2 = this.f40956b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, d> entry2 : this.f40956b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        d value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.a());
                            jSONObject3.put(RewardPlus.AMOUNT, value.b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f40957c);
            jSONObject.put("ruct", this.f40958d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f40959e);
            jSONObject.put("dlct", this.f40960f);
            jSONObject.put("vcct", this.f40961g);
            jSONObject.put("current_time", this.f40962h);
            jSONObject.put("vtag", this.f40965k);
            jSONObject.put("isDefault", this.f40963i);
            return jSONObject;
        } catch (Exception e6) {
            e6.printStackTrace();
            return jSONObject;
        }
    }

    public final void a(long j4) {
        this.f40957c = j4;
    }

    public final void b(long j4) {
        this.f40958d = j4;
    }

    public final void c(long j4) {
        this.f40959e = j4;
    }

    public final void d(long j4) {
        this.f40960f = j4;
    }

    public final void e(long j4) {
        this.f40961g = j4;
    }

    public final void a(Map<String, Integer> map) {
        this.f40955a = map;
    }

    public final void b(Map<String, d> map) {
        this.f40956b = map;
    }

    public final void a(int i4) {
        this.f40963i = i4;
    }

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                    aVar2.f40964j = jSONObject.optString("ab_id", "");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            int intValue = Integer.valueOf(optJSONObject.optInt(next, 1000)).intValue();
                            if (!TextUtils.isEmpty(next)) {
                                if (!TextUtils.isEmpty(next) && intValue == 0) {
                                    hashMap.put(next, 1000);
                                } else {
                                    hashMap.put(next, Integer.valueOf(intValue));
                                }
                            }
                        }
                        aVar2.f40955a = hashMap;
                    }
                    aVar2.f40956b = d.a(jSONObject.optJSONArray("reward"));
                    aVar2.f40957c = jSONObject.optLong("getpf", 43200L);
                    aVar2.f40958d = jSONObject.optLong("ruct", 5400L);
                    aVar2.f40959e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L);
                    aVar2.f40960f = jSONObject.optLong("dlct", 3600L);
                    aVar2.f40961g = jSONObject.optLong("vcct", 5L);
                    aVar2.f40962h = jSONObject.optLong("current_time");
                    aVar2.f40965k = jSONObject.optString("vtag", "");
                    return aVar2;
                } catch (Exception e4) {
                    e = e4;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return aVar;
    }
}
