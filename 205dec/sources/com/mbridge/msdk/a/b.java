package com.mbridge.msdk.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.adsession.CreativeType;
import com.iab.omid.library.mmadbridge.adsession.ImpressionType;
import com.iab.omid.library.mmadbridge.adsession.Owner;
import com.iab.omid.library.mmadbridge.adsession.g;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.x;
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

/* compiled from: OmsdkUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static void a(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = "";
            new d(context).a("", "", "", "", "fetch OM failed, OMID_JS_SERVICE_URL null");
        } else if (context == null) {
        } else {
            try {
                new a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(0, MBridgeConstans.OMID_JS_SERVICE_URL, (com.mbridge.msdk.foundation.same.net.g.d) null, new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.a.b.1
                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void a(final String str) {
                        MBridgeConstans.OMID_JS_SERVICE_CONTENT = str;
                        x.a("OMSDK", "fetch OMJSContent success, content = " + str);
                        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    File file = new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt");
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    v.a(str.getBytes(), file);
                                } catch (Exception e4) {
                                    x.a("OMSDK", e4.getMessage());
                                }
                            }
                        }).start();
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void b(String str) {
                        x.a("OMSDK", "fetch OMJSContent failed, errorCode = " + str);
                        new d(context).a("", "", "", "", "fetch OM failed, request failed");
                    }
                });
            } catch (Exception e4) {
                x.d("OMSDK", e4.getMessage());
            }
        }
    }

    public static void b(final Context context) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_URL)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = "";
            new d(context).a("", "", "", "", "fetch OM failed, OMID_JS_H5_URL null");
        } else if (context == null) {
        } else {
            try {
                new a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(0, MBridgeConstans.OMID_JS_H5_URL, (com.mbridge.msdk.foundation.same.net.g.d) null, new com.mbridge.msdk.foundation.same.net.b.a() { // from class: com.mbridge.msdk.a.b.2
                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void a(final String str) {
                        MBridgeConstans.OMID_JS_H5_CONTENT = str;
                        x.a("OMSDK", "fetch OMJSH5Content success, content = " + str);
                        new Thread(new Runnable() { // from class: com.mbridge.msdk.a.b.4
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    File file = new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    v.a(str.getBytes(), file);
                                } catch (Exception e4) {
                                    x.a("OMSDK", e4.getMessage());
                                }
                            }
                        }).start();
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.b.a
                    public final void b(String str) {
                        x.a("OMSDK", "fetch OMJSH5Content failed, errorCode = " + str);
                        new d(context).a("", "", "", "", "fetch OM H5 failed, request failed");
                    }
                });
            } catch (Exception e4) {
                x.d("OMSDK", e4.getMessage());
            }
        }
    }

    private static void c(Context context) {
        if (com.iab.omid.library.mmadbridge.a.c()) {
            return;
        }
        com.iab.omid.library.mmadbridge.a.a(context);
    }

    private static List<g> a(String str, Context context, String str2, String str3, String str4, String str5) {
        g a4;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (str != null) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    String optString = optJSONObject.optString("vkey", "");
                    URL url = new URL(optJSONObject.optString("et_url", ""));
                    String optString2 = optJSONObject.optString("verification_p", "");
                    if (TextUtils.isEmpty(optString2)) {
                        if (TextUtils.isEmpty(optString)) {
                            a4 = g.b(url);
                        } else {
                            a4 = g.b(url);
                        }
                    } else {
                        a4 = g.a(optString, url, optString2);
                    }
                    arrayList.add(a4);
                }
            }
        } catch (IllegalArgumentException e4) {
            x.d("OMSDK", e4.getMessage());
            d dVar = new d(context);
            dVar.a(str2, str5, str3, str4, "failed, exception " + e4.getMessage());
        } catch (MalformedURLException e5) {
            x.d("OMSDK", e5.getMessage());
            d dVar2 = new d(context);
            dVar2.a(str2, str5, str3, str4, "failed, exception " + e5.getMessage());
        } catch (JSONException e6) {
            x.d("OMSDK", e6.getMessage());
            d dVar3 = new d(context);
            dVar3.a(str2, str5, str3, str4, "failed, exception " + e6.getMessage());
        }
        return arrayList;
    }

    private static String b() {
        try {
            File file = new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_h5_content.txt");
            return file.exists() ? v.a(file) : "";
        } catch (Exception e4) {
            x.a("OMSDK", e4.getMessage());
            return "";
        }
    }

    public static com.iab.omid.library.mmadbridge.adsession.b a(Context context, WebView webView, String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        if (!TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) && !TextUtils.isEmpty(campaignEx.getOmid())) {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            c(context);
            ImpressionType impressionType = ImpressionType.BEGIN_TO_RENDER;
            Owner owner = Owner.JAVASCRIPT;
            CreativeType creativeType2 = CreativeType.HTML_DISPLAY;
            com.iab.omid.library.mmadbridge.adsession.b b4 = com.iab.omid.library.mmadbridge.adsession.b.b(com.iab.omid.library.mmadbridge.adsession.c.a(creativeType, impressionType, owner, Owner.NONE, false), com.iab.omid.library.mmadbridge.adsession.d.a(com.iab.omid.library.mmadbridge.adsession.e.a("Mintegral", MBConfiguration.SDK_VERSION), webView, null, null));
            b4.g(webView);
            return b4;
        }
        x.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(campaignEx.getOmid()) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
        new d(context).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), campaignEx.getCampaignUnitId(), "failed, OMID_JS_SERVICE_CONTENT null or omid null");
        return null;
    }

    public static com.iab.omid.library.mmadbridge.adsession.b a(Context context, boolean z3, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT)) {
            MBridgeConstans.OMID_JS_SERVICE_CONTENT = a();
        }
        com.iab.omid.library.mmadbridge.adsession.b bVar = null;
        if (!TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT) && !TextUtils.isEmpty(str)) {
            try {
                c(context);
                com.iab.omid.library.mmadbridge.adsession.e a4 = com.iab.omid.library.mmadbridge.adsession.e.a("Mintegral", MBConfiguration.SDK_VERSION);
                CreativeType creativeType = CreativeType.NATIVE_DISPLAY;
                ImpressionType impressionType = ImpressionType.LOADED;
                Owner owner = Owner.NATIVE;
                try {
                    bVar = com.iab.omid.library.mmadbridge.adsession.b.b(com.iab.omid.library.mmadbridge.adsession.c.a(creativeType, impressionType, owner, z3 ? Owner.NONE : owner, false), com.iab.omid.library.mmadbridge.adsession.d.c(a4, MBridgeConstans.OMID_JS_SERVICE_CONTENT, a(str, context, str2, str3, str4, str6), str5, str2));
                    x.a("OMSDK", "adSession create success");
                    return bVar;
                } catch (IllegalArgumentException e4) {
                    e = e4;
                    x.d("OMSDK", e.getMessage());
                    d dVar = new d(context);
                    dVar.a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                    return bVar;
                } catch (Exception e5) {
                    e = e5;
                    x.d("OMSDK", e.getMessage());
                    d dVar2 = new d(context);
                    dVar2.a(str2, str6, str3, str4, "failed, exception " + e.getMessage());
                    return bVar;
                }
            } catch (IllegalArgumentException e6) {
                e = e6;
            } catch (Exception e7) {
                e = e7;
            }
        } else {
            x.a("OMSDK", "createNativeAdSession: TextUtils.isEmpty(omid) = " + TextUtils.isEmpty(str) + " TextUtils.isEmpty(MIntegralConstans.OMID_JS_SERVICE_CONTENT) = " + TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_CONTENT));
            new d(context).a(str2, str6, str3, str4, "failed, OMID_JS_SERVICE_CONTENT null or omid null");
            return null;
        }
    }

    private static String a() {
        try {
            return v.a(new File(e.b(c.MBRIDGE_OTHER), "/omsdk/om_js_content.txt"));
        } catch (Exception e4) {
            x.a("OMSDK", e4.getMessage());
            return "";
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(MBridgeConstans.OMID_JS_H5_CONTENT)) {
            MBridgeConstans.OMID_JS_H5_CONTENT = b();
        }
        return TextUtils.isEmpty(str) ? str : str.replace("/*OMSDK_INSERT_HERE*/", MBridgeConstans.OMID_JS_H5_CONTENT).replace("[INSERT RESOURCE URL]", "https://s3-us-west-2.amazonaws.com/omsdk-files/compliance-js/omid-validation-verification-script-v1.js");
    }
}
