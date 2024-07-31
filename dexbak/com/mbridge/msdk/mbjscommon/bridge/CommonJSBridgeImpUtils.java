package com.mbridge.msdk.mbjscommon.bridge;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.Frequence;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.bridge.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CommonJSBridgeImpUtils {

    /* renamed from: a */
    public static final String f31437a = "b";

    /* renamed from: b */
    public static int f31438b = 0;

    /* renamed from: c */
    public static int f31439c = 1;

    /* renamed from: a */
    public static void m21520a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                m21521a(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                m21521a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbjscommon.bridge.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        FrequenceDao m22703a = FrequenceDao.m22703a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
                        if (m22703a != null) {
                            if (!m22703a.m22701a(CampaignEx.this.getId())) {
                                Frequence frequence = new Frequence();
                                frequence.m22551a(CampaignEx.this.getId());
                                frequence.m22553a(CampaignEx.this.getFca());
                                frequence.m22549b(CampaignEx.this.getFcb());
                                frequence.m22545d(0);
                                frequence.m22547c(1);
                                frequence.m22552a(System.currentTimeMillis());
                                m22703a.m22702a(frequence);
                            } else {
                                m22703a.m22698b(CampaignEx.this.getId());
                            }
                        }
                        CommonJSBridgeImpUtils.m21519a(CampaignEx.this.getCampaignUnitId(), CampaignEx.this);
                    } catch (Throwable th) {
                        SameLogTool.m21735b(CommonJSBridgeImpUtils.f31437a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f31438b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                m21521a(obj, e.getMessage());
                SameLogTool.m21738a(f31437a, e.getMessage());
            }
        } catch (Throwable th) {
            m21521a(obj, th.getMessage());
        }
    }

    /* renamed from: a */
    public static String m21523a(float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CommonConst.f30590m, SameTool.m22021a(MBSDKContext.m22865f().m22861j(), f));
            jSONObject2.put(CommonConst.f30591n, SameTool.m22021a(MBSDKContext.m22865f().m22861j(), f2));
            jSONObject2.put(CommonConst.f30593p, 0);
            jSONObject2.put(CommonConst.f30594q, MBSDKContext.m22865f().m22861j().getResources().getConfiguration().orientation);
            jSONObject2.put(CommonConst.f30595r, SameTool.m21988d(MBSDKContext.m22865f().m22861j()));
            jSONObject.put(CommonConst.f30592o, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static String m21522a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            SameLogTool.m21733d(f31437a, "code to string is error");
            return "";
        }
    }

    /* renamed from: a */
    public static void m21521a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f31439c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            SameLogTool.m21738a(f31437a, e.getMessage());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21519a(String str, CampaignEx campaignEx) {
        if (StaticDataPoll.f30617h == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        StaticDataPoll.m22375a(str, campaignEx, "banner");
    }
}
