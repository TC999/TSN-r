package com.mbridge.msdk.splash.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.Frame;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SplashResponseHandler.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class c extends f<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40691a = "c";

    /* renamed from: b  reason: collision with root package name */
    private int f40692b;

    /* renamed from: c  reason: collision with root package name */
    private String f40693c;

    public abstract void a(List<Frame> list);

    public abstract void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit);

    public abstract void b(int i4, String str);

    public final void a(String str) {
        this.f40693c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a() {
        super.a();
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(k<JSONObject> kVar) {
        com.mbridge.msdk.foundation.same.net.e.c cVar;
        CampaignUnit parseCampaignUnit;
        super.a(kVar);
        if (kVar == null || (cVar = kVar.f39630c) == null) {
            return;
        }
        int i4 = this.f40692b;
        if (i4 == 0) {
            final List<com.mbridge.msdk.foundation.same.net.c.b> list = cVar.f39548d;
            final JSONObject jSONObject = kVar.f39628a;
            final int optInt = jSONObject.optInt("status");
            if (1 == optInt) {
                a(System.currentTimeMillis());
                final String optString = jSONObject.optString("version");
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() { // from class: com.mbridge.msdk.splash.f.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final CampaignUnit parseV5CampaignUnit = "v5".equals(optString) ? CampaignUnit.parseV5CampaignUnit(jSONObject.optJSONObject("data"), c.this.f40693c) : CampaignUnit.parseCampaignUnit(jSONObject.optJSONObject("data"), c.this.f40693c);
                        com.mbridge.msdk.foundation.same.f.b.d().post(new Runnable() { // from class: com.mbridge.msdk.splash.f.c.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                CampaignUnit campaignUnit = parseV5CampaignUnit;
                                if (campaignUnit != null && campaignUnit.getAds() != null && parseV5CampaignUnit.getAds().size() > 0) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c.this.a(list, parseV5CampaignUnit);
                                    c.this.a(parseV5CampaignUnit.getAds().size());
                                    return;
                                }
                                CampaignUnit campaignUnit2 = parseV5CampaignUnit;
                                String msg = campaignUnit2 != null ? campaignUnit2.getMsg() : null;
                                if (TextUtils.isEmpty(msg)) {
                                    msg = jSONObject.optString("msg");
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                c.this.b(optInt, msg);
                            }
                        });
                    }
                });
                return;
            }
            b(optInt, jSONObject.optString("msg"));
        } else if (i4 == 1) {
            List<com.mbridge.msdk.foundation.same.net.c.b> list2 = cVar.f39548d;
            JSONObject jSONObject2 = kVar.f39628a;
            int optInt2 = jSONObject2.optInt("status");
            if (1 == optInt2) {
                a(System.currentTimeMillis());
                if ("v5".equals(jSONObject2.optString("version"))) {
                    parseCampaignUnit = CampaignUnit.parseV5CampaignUnit(jSONObject2.optJSONObject("data"), this.f40693c);
                } else {
                    parseCampaignUnit = CampaignUnit.parseCampaignUnit(jSONObject2.optJSONObject("data"), this.f40693c);
                }
                if (parseCampaignUnit != null && parseCampaignUnit.getListFrames() != null && parseCampaignUnit.getListFrames().size() > 0) {
                    List<Frame> listFrames = parseCampaignUnit.getListFrames();
                    a(listFrames);
                    a(listFrames.size());
                    return;
                }
                String msg = parseCampaignUnit != null ? parseCampaignUnit.getMsg() : null;
                if (TextUtils.isEmpty(msg)) {
                    msg = jSONObject2.optString("msg");
                }
                b(optInt2, msg);
                return;
            }
            b(optInt2, jSONObject2.optString("msg"));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = f40691a;
        x.d(str, "errorCode = " + aVar.f39484a);
        b(aVar.f39484a, com.mbridge.msdk.foundation.same.net.f.a.a(aVar));
    }
}
