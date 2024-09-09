package com.mbridge.msdk.mbjscommon.bridge;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import org.json.JSONObject;

/* compiled from: CommonJSBridgeImpUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40209a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static int f40210b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f40211c = 1;

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.bridge.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l a4 = l.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
                        if (a4 != null) {
                            if (!a4.a(CampaignEx.this.getId())) {
                                h hVar = new h();
                                hVar.a(CampaignEx.this.getId());
                                hVar.a(CampaignEx.this.getFca());
                                hVar.b(CampaignEx.this.getFcb());
                                hVar.d(0);
                                hVar.c(1);
                                hVar.a(System.currentTimeMillis());
                                a4.a(hVar);
                            } else {
                                a4.b(CampaignEx.this.getId());
                            }
                        }
                        b.a(CampaignEx.this.getCampaignUnitId(), CampaignEx.this);
                    } catch (Throwable th) {
                        x.b(b.f40209a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f40210b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e4) {
                a(obj, e4.getMessage());
                x.a(f40209a, e4.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static String a(float f4, float f5) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39385m, ac.a(com.mbridge.msdk.foundation.controller.a.f().j(), f4));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39386n, ac.a(com.mbridge.msdk.foundation.controller.a.f().j(), f5));
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39388p, 0);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39389q, com.mbridge.msdk.foundation.controller.a.f().j().getResources().getConfiguration().orientation);
            jSONObject2.put(com.mbridge.msdk.foundation.same.a.f39390r, ac.d(com.mbridge.msdk.foundation.controller.a.f().j()));
            jSONObject.put(com.mbridge.msdk.foundation.same.a.f39387o, jSONObject2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i4);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            x.d(f40209a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f40211c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            x.a(f40209a, e4.getMessage());
        }
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (d.f39412h == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        d.a(str, campaignEx, "banner");
    }
}
