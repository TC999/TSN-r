package com.mbridge.msdk.videocommon.p515d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.p513b.Reward;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.videocommon.d.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RewardSetting {

    /* renamed from: a */
    private Map<String, Integer> f32207a;

    /* renamed from: b */
    private Map<String, Reward> f32208b;

    /* renamed from: c */
    private long f32209c;

    /* renamed from: d */
    private long f32210d;

    /* renamed from: e */
    private long f32211e;

    /* renamed from: f */
    private long f32212f;

    /* renamed from: g */
    private long f32213g;

    /* renamed from: h */
    private long f32214h;

    /* renamed from: j */
    private String f32216j;

    /* renamed from: i */
    private int f32215i = 0;

    /* renamed from: k */
    private String f32217k = "";

    /* renamed from: a */
    public final String m20855a() {
        return this.f32217k;
    }

    /* renamed from: b */
    public final String m20850b() {
        return this.f32216j;
    }

    /* renamed from: c */
    public final long m20847c() {
        return this.f32209c * 1000;
    }

    /* renamed from: d */
    public final long m20845d() {
        return this.f32210d * 1000;
    }

    /* renamed from: e */
    public final long m20843e() {
        return this.f32211e * 1000;
    }

    /* renamed from: f */
    public final long m20841f() {
        return this.f32212f;
    }

    /* renamed from: g */
    public final long m20840g() {
        return this.f32213g;
    }

    /* renamed from: h */
    public final long m20839h() {
        return this.f32214h;
    }

    /* renamed from: i */
    public final Map<String, Integer> m20838i() {
        if (this.f32207a == null) {
            HashMap hashMap = new HashMap();
            this.f32207a = hashMap;
            hashMap.put("1", 1000);
            this.f32207a.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, 1000);
            this.f32207a.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, 1000);
        }
        return this.f32207a;
    }

    /* renamed from: j */
    public final Map<String, Reward> m20837j() {
        return this.f32208b;
    }

    /* renamed from: k */
    public final JSONObject m20836k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f32207a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f32207a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, Reward> map2 = this.f32208b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, Reward> entry2 : this.f32208b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        Reward value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.m20872a());
                            jSONObject3.put(RewardPlus.AMOUNT, value.m20867b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f32209c);
            jSONObject.put("ruct", this.f32210d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f32211e);
            jSONObject.put("dlct", this.f32212f);
            jSONObject.put("vcct", this.f32213g);
            jSONObject.put("current_time", this.f32214h);
            jSONObject.put("vtag", this.f32217k);
            jSONObject.put("isDefault", this.f32215i);
            return jSONObject;
        } catch (Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }

    /* renamed from: a */
    public final void m20853a(long j) {
        this.f32209c = j;
    }

    /* renamed from: b */
    public final void m20849b(long j) {
        this.f32210d = j;
    }

    /* renamed from: c */
    public final void m20846c(long j) {
        this.f32211e = j;
    }

    /* renamed from: d */
    public final void m20844d(long j) {
        this.f32212f = j;
    }

    /* renamed from: e */
    public final void m20842e(long j) {
        this.f32213g = j;
    }

    /* renamed from: a */
    public final void m20851a(Map<String, Integer> map) {
        this.f32207a = map;
    }

    /* renamed from: b */
    public final void m20848b(Map<String, Reward> map) {
        this.f32208b = map;
    }

    /* renamed from: a */
    public final void m20854a(int i) {
        this.f32215i = i;
    }

    /* renamed from: a */
    public static RewardSetting m20852a(String str) {
        RewardSetting rewardSetting = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                RewardSetting rewardSetting2 = new RewardSetting();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                    rewardSetting2.f32216j = jSONObject.optString("ab_id", "");
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
                        rewardSetting2.f32207a = hashMap;
                    }
                    rewardSetting2.f32208b = Reward.m20869a(jSONObject.optJSONArray("reward"));
                    rewardSetting2.f32209c = jSONObject.optLong("getpf", 43200L);
                    rewardSetting2.f32210d = jSONObject.optLong("ruct", 5400L);
                    rewardSetting2.f32211e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L);
                    rewardSetting2.f32212f = jSONObject.optLong("dlct", 3600L);
                    rewardSetting2.f32213g = jSONObject.optLong("vcct", 5L);
                    rewardSetting2.f32214h = jSONObject.optLong("current_time");
                    rewardSetting2.f32217k = jSONObject.optString("vtag", "");
                    return rewardSetting2;
                } catch (Exception e) {
                    e = e;
                    rewardSetting = rewardSetting2;
                    e.printStackTrace();
                    return rewardSetting;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return rewardSetting;
    }
}
