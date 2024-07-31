package com.mbridge.msdk.splash.p508js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.Frequence;
import com.mbridge.msdk.foundation.entity.VideoBean;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.p472db.VideoDao;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDKTool;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.js.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashJsUtils {

    /* renamed from: a */
    private static String f31964a = "SplashJsUtils";

    /* renamed from: b */
    private static int f31965b = 0;

    /* renamed from: c */
    private static int f31966c = 1;

    /* renamed from: b */
    public static void m21007b(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                m21010a(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                m21010a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.js.c.1
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
                        SplashJsUtils.m21008a(CampaignEx.this.getCampaignUnitId(), CampaignEx.this);
                    } catch (Throwable th) {
                        SameLogTool.m21735b(SplashJsUtils.f31964a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f31965b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e) {
                m21010a(obj, e.getMessage());
                SameLogTool.m21738a(f31964a, e.getMessage());
            }
        } catch (Throwable th) {
            m21010a(obj, th.getMessage());
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x021a: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:83:0x021a */
    /* renamed from: a */
    public static void m21009a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONArray jSONArray;
        int i;
        String str5;
        String str6 = "";
        JSONObject jSONObject2 = new JSONObject();
        String str7 = "message";
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e) {
                SameLogTool.m21738a(f31964a, e.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray2 = jSONObject.getJSONArray("resource");
            try {
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    JSONArray jSONArray3 = new JSONArray();
                    int length = jSONArray2.length();
                    int i3 = 0;
                    while (i3 < length) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        String optString = jSONObject3.optString("ref", str6);
                        int i4 = jSONObject3.getInt("type");
                        JSONObject jSONObject4 = new JSONObject();
                        if (i4 == i2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            VideoBean m22662a = VideoDao.m22664a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22662a(optString);
                            if (m22662a != null) {
                                jSONArray = jSONArray2;
                                i = length;
                                SameLogTool.m21738a(f31964a, "VideoBean not null");
                                jSONObject5.put("type", 1);
                                jSONObject5.put("videoDataLength", m22662a.m22452c());
                                String m22450e = m22662a.m22450e();
                                str4 = str7;
                                if (TextUtils.isEmpty(m22450e)) {
                                    SameLogTool.m21738a(f31964a, "VideoPath null");
                                    jSONObject5.put("path", str6);
                                    jSONObject5.put("path4Web", str6);
                                    str3 = str6;
                                } else {
                                    str3 = str6;
                                    SameLogTool.m21738a(f31964a, "VideoPath not null");
                                    jSONObject5.put("path", m22450e);
                                    jSONObject5.put("path4Web", m22450e);
                                }
                                if (m22662a.m22451d() == 5) {
                                    jSONObject5.put("downloaded", 1);
                                } else {
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject5);
                                jSONArray3.put(jSONObject4);
                            } else {
                                str3 = str6;
                                str4 = str7;
                                jSONArray = jSONArray2;
                                i = length;
                                SameLogTool.m21738a(f31964a, "VideoBean null");
                            }
                        } else {
                            str3 = str6;
                            str4 = str7;
                            jSONArray = jSONArray2;
                            i = length;
                            if (i4 == 2 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 2);
                                jSONObject6.put("path", H5DownLoadManager.getInstance().getH5ResAddress(optString) == null ? str3 : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray3.put(jSONObject4);
                            } else if (i4 == 3 && !TextUtils.isEmpty(optString)) {
                                File file = new File(optString);
                                if (file.exists() && file.isFile() && file.canRead()) {
                                    SameLogTool.m21738a(f31964a, "getFileInfo Mraid file " + optString);
                                    str5 = "file:////" + optString;
                                } else {
                                    str5 = str3;
                                }
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("type", 3);
                                jSONObject7.put("path", str5);
                                jSONObject4.put(optString, jSONObject7);
                                jSONArray3.put(jSONObject4);
                            } else if (i4 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                jSONObject8.put("path", SameSDKTool.m22030a(optString) == null ? str3 : SameSDKTool.m22030a(optString));
                                jSONObject4.put(optString, jSONObject8);
                                jSONArray3.put(jSONObject4);
                            }
                        }
                        i3++;
                        jSONArray2 = jSONArray;
                        length = i;
                        str7 = str4;
                        str6 = str3;
                        i2 = 1;
                    }
                    jSONObject2.put("resource", jSONArray3);
                    WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                try {
                    jSONObject2.put("code", 1);
                    str = "message";
                } catch (JSONException e2) {
                    e = e2;
                    str = "message";
                }
                try {
                    try {
                        jSONObject2.put(str, "resource is null");
                        WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (Throwable th) {
                        th = th;
                        try {
                            jSONObject2.put("code", 1);
                            jSONObject2.put(str, th.getLocalizedMessage());
                            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (JSONException e3) {
                            SameLogTool.m21738a(f31964a, e3.getMessage());
                        }
                    }
                } catch (JSONException e4) {
                    e = e4;
                    SameLogTool.m21738a(f31964a, e.getMessage());
                }
            } catch (Throwable th2) {
                th = th2;
                str = str2;
            }
        } catch (Throwable th3) {
            th = th3;
            str = str7;
        }
    }

    /* renamed from: a */
    public static String m21013a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            SameLogTool.m21733d(f31964a, "code to string is error");
            return "";
        }
    }

    /* renamed from: a */
    private static void m21010a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f31966c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            SameLogTool.m21738a(f31964a, e.getMessage());
        }
    }

    /* renamed from: a */
    public static void m21011a(WebView webView, String str, String str2) {
        WindVaneCallJs.m21387a().m21385a(webView, str, str2);
    }

    /* renamed from: a */
    public static void m21012a(WebView webView) {
        SameLogTool.m21733d(f31964a, "fireOnJSBridgeConnected");
        WindVaneCallJs.m21387a().m21386a(webView);
    }

    /* renamed from: a */
    static /* synthetic */ void m21008a(String str, CampaignEx campaignEx) {
        if (StaticDataPoll.f30618i == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        StaticDataPoll.m22375a(str, campaignEx, MediationConstant.RIT_TYPE_SPLASH);
    }
}
