package com.mbridge.msdk.p454a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.C7073a;
import com.iab.omid.library.mmadbridge.adsession.AbstractC7075b;
import com.iab.omid.library.mmadbridge.adsession.C7076c;
import com.iab.omid.library.mmadbridge.adsession.C7077d;
import com.iab.omid.library.mmadbridge.adsession.C7078e;
import com.iab.omid.library.mmadbridge.adsession.C7080g;
import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.SameFileTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.MBConfiguration;
import com.stub.StubApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class OmsdkUtils {
    /* renamed from: a */
    public static void m23472a(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = "";
            new ReportController(context).m22093a("", "", "", "", "fetch OM failed, OMID_JS_SERVICE_URL null");
        } else if (context == null) {
        } else {
            try {
                new OmidRequest(StubApp.getOrigApplicationContext(context.getApplicationContext())).m22234a(0, MBridgeConstans.OMID_JS_SERVICE_URL, (CommonRequestParams) null, new CommonStringResponseHandler() { // from class: com.mbridge.msdk.a.b.1
                    @Override // com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler
                    /* renamed from: a */
                    public final void mo22294a(final String str) {
                        MBridgeConstans.OMID_JS_SERVICE_CONTENT = str;
                        SameLogTool.m21738a("OMSDK", "fetch OMJSContent success, content = " + str);
                        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    File file = new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_OTHER), "/omsdk/om_js_content.txt");
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    SameFileTool.m21751a(str.getBytes(), file);
                                } catch (Exception e) {
                                    SameLogTool.m21738a("OMSDK", e.getMessage());
                                }
                            }
                        }).start();
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler
                    /* renamed from: b */
                    public final void mo22293b(String str) {
                        SameLogTool.m21738a("OMSDK", "fetch OMJSContent failed, errorCode = " + str);
                        new ReportController(context).m22093a("", "", "", "", "fetch OM failed, request failed");
                    }
                });
            } catch (Exception e) {
                SameLogTool.m21733d("OMSDK", e.getMessage());
            }
        }
    }

    /* renamed from: b */
    public static void m23466b(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_URL)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = "";
            new ReportController(context).m22093a("", "", "", "", "fetch OM failed, OMID_JS_H5_URL null");
        } else if (context == null) {
        } else {
            try {
                new OmidRequest(StubApp.getOrigApplicationContext(context.getApplicationContext())).m22234a(0, MBridgeConstans.OMID_JS_H5_URL, (CommonRequestParams) null, new CommonStringResponseHandler() { // from class: com.mbridge.msdk.a.b.2
                    @Override // com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler
                    /* renamed from: a */
                    public final void mo22294a(final String str) {
                        MBridgeConstans.OMID_JS_H5_CONTENT = str;
                        SameLogTool.m21738a("OMSDK", "fetch OMJSH5Content success, content = " + str);
                        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.4
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    File file = new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    SameFileTool.m21751a(str.getBytes(), file);
                                } catch (Exception e) {
                                    SameLogTool.m21738a("OMSDK", e.getMessage());
                                }
                            }
                        }).start();
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler
                    /* renamed from: b */
                    public final void mo22293b(String str) {
                        SameLogTool.m21738a("OMSDK", "fetch OMJSH5Content failed, errorCode = " + str);
                        new ReportController(context).m22093a("", "", "", "", "fetch OM H5 failed, request failed");
                    }
                });
            } catch (Exception e) {
                SameLogTool.m21733d("OMSDK", e.getMessage());
            }
        }
    }

    /* renamed from: c */
    private static void m23465c(Context context) {
        if (C7073a.m34840c()) {
            return;
        }
        C7073a.m34842a(context);
    }

    /* renamed from: a */
    private static List<C7080g> m23468a(String str, Context context, String str2, String str3, String str4, String str5) {
        C7080g m34815a;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (str != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("vkey", "");
                    URL url = new URL(optJSONObject.optString("et_url", ""));
                    String optString2 = optJSONObject.optString("verification_p", "");
                    if (TextUtils.isEmpty(optString2)) {
                        if (TextUtils.isEmpty(optString)) {
                            m34815a = C7080g.m34814b(url);
                        } else {
                            m34815a = C7080g.m34814b(url);
                        }
                    } else {
                        m34815a = C7080g.m34815a(optString, url, optString2);
                    }
                    arrayList.add(m34815a);
                }
            }
        } catch (IllegalArgumentException e) {
            SameLogTool.m21733d("OMSDK", e.getMessage());
            ReportController reportController = new ReportController(context);
            reportController.m22093a(str2, str5, str3, str4, "failed, exception " + e.getMessage());
        } catch (MalformedURLException e2) {
            SameLogTool.m21733d("OMSDK", e2.getMessage());
            ReportController reportController2 = new ReportController(context);
            reportController2.m22093a(str2, str5, str3, str4, "failed, exception " + e2.getMessage());
        } catch (JSONException e3) {
            SameLogTool.m21733d("OMSDK", e3.getMessage());
            ReportController reportController3 = new ReportController(context);
            reportController3.m22093a(str2, str5, str3, str4, "failed, exception " + e3.getMessage());
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m23467b() {
        try {
            File file = new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
            return file.exists() ? SameFileTool.m21756a(file) : "";
        } catch (Exception e) {
            SameLogTool.m21738a("OMSDK", e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public static AbstractC7075b m23471a(Context context, WebView webView, String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = m23473a();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = m23467b();
        }
        if (!TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) && !TextUtils.isEmpty(campaignEx.getOmid())) {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            m23465c(context);
            ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
            Owner owner = Owner.JAVASCRIPT;
            CreativeType creativeType2 = CreativeType.HTML_DISPLAY;
            AbstractC7075b m34835b = AbstractC7075b.m34835b(C7076c.m34834a(creativeType, impressionType, owner, Owner.NONE, false), C7077d.m34830a(C7078e.m34819a("Mintegral", MBConfiguration.SDK_VERSION), webView, null, null));
            m34835b.mo34801g(webView);
            return m34835b;
        }
        SameLogTool.m21738a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(campaignEx.getOmid()) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
        new ReportController(context).m22093a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), campaignEx.getCampaignUnitId(), "failed, OMID_JS_SERVICE_CONTENT null or omid null");
        return null;
    }

    /* renamed from: a */
    public static AbstractC7075b m23470a(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = m23473a();
        }
        AbstractC7075b abstractC7075b = null;
        if (!TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) && !TextUtils.isEmpty(str)) {
            try {
                m23465c(context);
                C7078e m34819a = C7078e.m34819a("Mintegral", MBConfiguration.SDK_VERSION);
                CreativeType creativeType = CreativeType.NATIVE_DISPLAY;
                ImpressionType impressionType = ImpressionType.LOADED;
                Owner owner = Owner.NATIVE;
                try {
                    abstractC7075b = AbstractC7075b.m34835b(C7076c.m34834a(creativeType, impressionType, owner, z ? Owner.NONE : owner, false), C7077d.m34828c(m34819a, MBridgeConstans.OMID_JS_SERVICE_CONTENT, m23468a(str, context, str2, str3, str4, str6), str5, str2));
                    SameLogTool.m21738a("OMSDK", "adSession create success");
                    return abstractC7075b;
                } catch (IllegalArgumentException e) {
                    e = e;
                    SameLogTool.m21733d("OMSDK", e.getMessage());
                    ReportController reportController = new ReportController(context);
                    reportController.m22093a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                    return abstractC7075b;
                } catch (Exception e2) {
                    e = e2;
                    SameLogTool.m21733d("OMSDK", e.getMessage());
                    ReportController reportController2 = new ReportController(context);
                    reportController2.m22093a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                    return abstractC7075b;
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
        } else {
            SameLogTool.m21738a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(str) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new ReportController(context).m22093a(str2, str6, str3, str4, "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
    }

    /* renamed from: a */
    private static String m23473a() {
        try {
            return SameFileTool.m21756a(new File(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_OTHER), "/omsdk/om_js_content.txt"));
        } catch (Exception e) {
            SameLogTool.m21738a("OMSDK", e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public static String m23469a(String str) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = m23467b();
        }
        return TextUtils.isEmpty(str) ? str : str.replace("/*OMSDK_INSERT_HERE*/", MBridgeConstans.OMID_JS_H5_CONTENT).replace("[INSERT RESOURCE URL]", "https://s3-us-west-2.amazonaws.com/omsdk-files/compliance-js/omid-validation-verification-script-v1.js");
    }
}
