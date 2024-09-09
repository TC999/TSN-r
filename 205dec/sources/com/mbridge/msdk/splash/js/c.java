package com.mbridge.msdk.splash.js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.db.s;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.entity.o;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SplashJsUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f40731a = "SplashJsUtils";

    /* renamed from: b  reason: collision with root package name */
    private static int f40732b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f40733c = 1;

    public static void b(Object obj, JSONObject jSONObject) {
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
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.js.c.1
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
                        c.a(CampaignEx.this.getCampaignUnitId(), CampaignEx.this);
                    } catch (Throwable th) {
                        x.b(c.f40731a, th.getMessage(), th);
                    }
                }
            }).start();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", f40732b);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception e4) {
                a(obj, e4.getMessage());
                x.a(f40731a, e4.getMessage());
            }
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x021a: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:83:0x021a */
    public static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONArray jSONArray;
        int i4;
        String str5;
        String str6 = "";
        JSONObject jSONObject2 = new JSONObject();
        String str7 = "message";
        int i5 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e4) {
                x.a(f40731a, e4.getMessage());
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
                    int i6 = 0;
                    while (i6 < length) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i6);
                        String optString = jSONObject3.optString("ref", str6);
                        int i7 = jSONObject3.getInt("type");
                        JSONObject jSONObject4 = new JSONObject();
                        if (i7 == i5 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            o a4 = s.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j())).a(optString);
                            if (a4 != null) {
                                jSONArray = jSONArray2;
                                i4 = length;
                                x.a(f40731a, "VideoBean not null");
                                jSONObject5.put("type", 1);
                                jSONObject5.put("videoDataLength", a4.c());
                                String e5 = a4.e();
                                str4 = str7;
                                if (TextUtils.isEmpty(e5)) {
                                    x.a(f40731a, "VideoPath null");
                                    jSONObject5.put("path", str6);
                                    jSONObject5.put("path4Web", str6);
                                    str3 = str6;
                                } else {
                                    str3 = str6;
                                    x.a(f40731a, "VideoPath not null");
                                    jSONObject5.put("path", e5);
                                    jSONObject5.put("path4Web", e5);
                                }
                                if (a4.d() == 5) {
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
                                i4 = length;
                                x.a(f40731a, "VideoBean null");
                            }
                        } else {
                            str3 = str6;
                            str4 = str7;
                            jSONArray = jSONArray2;
                            i4 = length;
                            if (i7 == 2 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 2);
                                jSONObject6.put("path", H5DownLoadManager.getInstance().getH5ResAddress(optString) == null ? str3 : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray3.put(jSONObject4);
                            } else if (i7 == 3 && !TextUtils.isEmpty(optString)) {
                                File file = new File(optString);
                                if (file.exists() && file.isFile() && file.canRead()) {
                                    x.a(f40731a, "getFileInfo Mraid file " + optString);
                                    str5 = "file:////" + optString;
                                } else {
                                    str5 = str3;
                                }
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("type", 3);
                                jSONObject7.put("path", str5);
                                jSONObject4.put(optString, jSONObject7);
                                jSONArray3.put(jSONObject4);
                            } else if (i7 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                jSONObject8.put("path", ab.a(optString) == null ? str3 : ab.a(optString));
                                jSONObject4.put(optString, jSONObject8);
                                jSONArray3.put(jSONObject4);
                            }
                        }
                        i6++;
                        jSONArray2 = jSONArray;
                        length = i4;
                        str7 = str4;
                        str6 = str3;
                        i5 = 1;
                    }
                    jSONObject2.put("resource", jSONArray3);
                    com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                try {
                    jSONObject2.put("code", 1);
                    str = "message";
                } catch (JSONException e6) {
                    e = e6;
                    str = "message";
                }
                try {
                    try {
                        jSONObject2.put(str, "resource is null");
                        com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (Throwable th) {
                        th = th;
                        try {
                            jSONObject2.put("code", 1);
                            jSONObject2.put(str, th.getLocalizedMessage());
                            com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (JSONException e7) {
                            x.a(f40731a, e7.getMessage());
                        }
                    }
                } catch (JSONException e8) {
                    e = e8;
                    x.a(f40731a, e.getMessage());
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

    public static String a(int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i4);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            x.d(f40731a, "code to string is error");
            return "";
        }
    }

    private static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f40733c);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            com.mbridge.msdk.mbjscommon.windvane.h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            x.a(f40731a, e4.getMessage());
        }
    }

    public static void a(WebView webView, String str, String str2) {
        com.mbridge.msdk.mbjscommon.windvane.h.a().a(webView, str, str2);
    }

    public static void a(WebView webView) {
        x.d(f40731a, "fireOnJSBridgeConnected");
        com.mbridge.msdk.mbjscommon.windvane.h.a().a(webView);
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (d.f39413i == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        d.a(str, campaignEx, "splash");
    }
}
