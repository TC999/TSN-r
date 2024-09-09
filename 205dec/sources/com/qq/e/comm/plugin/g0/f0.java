package com.qq.e.comm.plugin.g0;

import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.d1;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f0 extends e implements u {

    /* renamed from: g1  reason: collision with root package name */
    String f43566g1;

    /* renamed from: h1  reason: collision with root package name */
    String f43567h1;

    /* renamed from: i1  reason: collision with root package name */
    private com.qq.e.comm.plugin.rewardvideo.f f43568i1;

    /* renamed from: j1  reason: collision with root package name */
    String f43569j1;

    /* renamed from: k1  reason: collision with root package name */
    int f43570k1;

    /* renamed from: l1  reason: collision with root package name */
    private boolean f43571l1;

    public f0(String str, String str2, String str3, String str4, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
        super(str, str2, str3, str4, com.qq.e.comm.plugin.b.g.REWARDVIDEOAD, jSONObject, lVar);
        this.f43571l1 = false;
        g0.a(this, jSONObject);
        this.f43570k1 = com.qq.e.comm.plugin.rewardvideo.q.b(this);
        try {
            if (TextUtils.isEmpty(this.f43522f)) {
                JSONArray optJSONArray = jSONObject.optJSONArray("img_list");
                if (!com.qq.e.comm.plugin.util.k0.a(optJSONArray)) {
                    String optString = optJSONArray.optString(0);
                    this.f43522f = optString;
                    jSONObject.putOpt("img", optString);
                }
            }
            jSONObject.putOpt("card_show_time", Integer.valueOf(this.f43570k1));
        } catch (JSONException unused) {
        }
    }

    private boolean o1() {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("rpblkl", "https://100000189777.retail.n.weimob.com/saas/retail/100000189777/21036777/goods/detail,https://46a79741.fyeds3.com/");
        if (TextUtils.isEmpty(b4)) {
            return true;
        }
        try {
            if (!b4.contains(new URL(this.f43567h1).getHost()) || Build.VERSION.SDK_INT > 25) {
                return true;
            }
            d1.a("checkCompatible", "not compatible, url : " + this.f43567h1);
            return false;
        } catch (Exception e4) {
            d1.a("checkCompatible", e4.getMessage());
            return true;
        }
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final String a() {
        return this.f43567h1;
    }

    public final void c(String str) {
        this.f43566g1 = str;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public boolean c() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final e d() {
        return this;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final String e() {
        return this.f43566g1;
    }

    @Override // com.qq.e.comm.plugin.g0.u
    public final boolean f() {
        return this.f43571l1 || com.qq.e.comm.plugin.b.b.a(b0());
    }

    public final int p1() {
        return this.f43570k1;
    }

    public final com.qq.e.comm.plugin.rewardvideo.f q1() {
        return this.f43568i1;
    }

    public String r1() {
        return this.f43569j1;
    }

    public boolean s1() {
        return !TextUtils.isEmpty(this.f43567h1) && o1();
    }

    public final void a(com.qq.e.comm.plugin.rewardvideo.f fVar) {
        this.f43568i1 = fVar;
    }

    public final void c(boolean z3) {
        this.f43571l1 = z3;
    }
}
