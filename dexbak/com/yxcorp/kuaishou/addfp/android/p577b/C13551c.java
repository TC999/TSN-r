package com.yxcorp.kuaishou.addfp.android.p577b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.yxcorp.kuaishou.addfp.android.b.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C13551c {

    /* renamed from: a */
    boolean f40048a;

    /* renamed from: b */
    int f40049b;

    /* renamed from: c */
    boolean f40050c;

    /* renamed from: d */
    String f40051d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C13551c(String str) {
        this.f40048a = true;
        if (TextUtils.isEmpty(str)) {
            this.f40048a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f40049b = jSONObject.optInt("errorCode", 2);
            this.f40050c = jSONObject.optBoolean("userSet", true);
            this.f40051d = jSONObject.optString(DomainCampaignEx.LOOPBACK_VALUE, "KWE_OTHER");
        } catch (JSONException e) {
            this.f40048a = false;
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public String m12882a(boolean z) {
        if (this.f40048a) {
            if (z != this.f40050c) {
                return "KWE_NPN";
            }
            int i = this.f40049b;
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f40051d) ? this.f40051d : "KWE_N";
        }
        return "KWE_OTHER";
    }
}
