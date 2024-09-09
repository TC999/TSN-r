package com.mbridge.msdk.splash.js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbjscommon.windvane.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: SplashJSBridgeImpl.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f40719b;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f40720c;

    /* renamed from: d  reason: collision with root package name */
    private String f40721d;

    /* renamed from: e  reason: collision with root package name */
    private String f40722e;

    /* renamed from: f  reason: collision with root package name */
    private int f40723f;

    /* renamed from: g  reason: collision with root package name */
    private int f40724g;

    /* renamed from: i  reason: collision with root package name */
    private int f40726i;

    /* renamed from: j  reason: collision with root package name */
    private com.mbridge.msdk.splash.d.a f40727j;

    /* renamed from: k  reason: collision with root package name */
    private SplashExpandDialog f40728k;

    /* renamed from: a  reason: collision with root package name */
    private String f40718a = "SplashJSBridgeImpl";

    /* renamed from: h  reason: collision with root package name */
    private int f40725h = 5;

    public b(Context context, String str, String str2) {
        this.f40722e = str;
        this.f40721d = str2;
        this.f40719b = new WeakReference<>(context);
    }

    public final void b(int i4) {
        this.f40725h = i4;
    }

    public final void c(int i4) {
        this.f40726i = i4;
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.b
    public final void close() {
        x.d(this.f40718a, "close");
        try {
            com.mbridge.msdk.splash.d.a aVar = this.f40727j;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            x.b(this.f40718a, "close", th);
        }
    }

    public final void d(Object obj, String str) {
        x.d(this.f40718a, AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY);
        try {
            List<CampaignEx> list = this.f40720c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = null;
            if (list != null && list.size() > 0) {
                campaignEx = this.f40720c.get(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    campaignToJsonObject.put(next, jSONObject.getString(next));
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                String optString = campaignToJsonObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (!TextUtils.isEmpty(optString)) {
                    parseCampaignWithBackData.setCampaignUnitId(optString);
                }
                campaignEx = parseCampaignWithBackData;
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            com.mbridge.msdk.splash.d.a aVar = this.f40727j;
            if (aVar != null) {
                aVar.a(campaignEx);
            }
        } catch (Throwable th) {
            x.b(this.f40718a, "click", th);
        }
    }

    public final void e(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = this.f40718a;
        x.d(str2, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbjscommon.bridge.b.a(obj, "params is null");
            return;
        }
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (j4 == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a) != null) {
                    j4 = windVaneWebView.getContext();
                }
            } catch (Exception e4) {
                x.d(this.f40718a, e4.getMessage());
            }
        }
        if (j4 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.mbridge.msdk.click.c.a(j4, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.b(j4, optString);
            }
        } catch (JSONException e5) {
            x.d(this.f40718a, e5.getMessage());
        } catch (Throwable th) {
            x.d(this.f40718a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.b
    public final void expand(String str, boolean z3) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z3);
            WeakReference<Context> weakReference = this.f40719b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            SplashExpandDialog splashExpandDialog = this.f40728k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                SplashExpandDialog splashExpandDialog2 = new SplashExpandDialog(this.f40719b.get(), bundle, this.f40727j);
                this.f40728k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.f40721d, this.f40720c);
                this.f40728k.show();
                com.mbridge.msdk.splash.d.a aVar = this.f40727j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.splash.e.a.a(this.f40721d, getMraidCampaign(), str);
            }
        } catch (Throwable th) {
            x.b(this.f40718a, "expand", th);
        }
    }

    public final void f(Object obj, String str) {
        String str2 = this.f40718a;
        x.a(str2, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbjscommon.bridge.b.a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                try {
                    String optString = new JSONObject(str).optString("packageName");
                    if (TextUtils.isEmpty(optString)) {
                        com.mbridge.msdk.mbjscommon.bridge.b.a(obj, "packageName is empty");
                    }
                    int i4 = ac.c(com.mbridge.msdk.foundation.controller.a.f().j(), optString) ? 1 : 2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", com.mbridge.msdk.mbjscommon.bridge.b.f40210b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", i4);
                        jSONObject.put("data", jSONObject2);
                        h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e4) {
                        com.mbridge.msdk.mbjscommon.bridge.b.a(obj, e4.getMessage());
                        x.a(this.f40718a, e4.getMessage());
                    }
                } catch (Throwable th) {
                    com.mbridge.msdk.mbjscommon.bridge.b.a(obj, "exception: " + th.getLocalizedMessage());
                    x.b(this.f40718a, "cai", th);
                }
            } catch (JSONException e5) {
                com.mbridge.msdk.mbjscommon.bridge.b.a(obj, "exception: " + e5.getLocalizedMessage());
                x.b(this.f40718a, "cai", e5);
            }
        }
    }

    public final void g(Object obj, String str) {
        String str2 = this.f40718a;
        x.a(str2, "gial:" + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", com.mbridge.msdk.mbjscommon.bridge.b.f40210b);
            JSONObject jSONObject2 = new JSONObject();
            List<String> list = com.mbridge.msdk.foundation.controller.a.f39079c;
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    jSONArray.put(list.get(i4));
                }
            }
            jSONObject2.put("packageNameList", jSONArray);
            jSONObject.put("data", jSONObject2);
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            com.mbridge.msdk.mbjscommon.bridge.b.a(obj, e4.getMessage());
            x.a(this.f40718a, e4.getMessage());
        } catch (Throwable th) {
            com.mbridge.msdk.mbjscommon.bridge.b.a(obj, th.getMessage());
            x.a(this.f40718a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.b
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f40720c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f40720c.get(0);
    }

    public final void h(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i4 = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.splash.d.a aVar = this.f40727j;
            if (aVar != null) {
                aVar.b(i4);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public final void i(Object obj, String str) {
        String str2 = this.f40718a;
        x.a(str2, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String string = jSONArray.getString(i4);
                for (CampaignEx campaignEx : this.f40720c) {
                    if (campaignEx.getId().equals(string)) {
                        d.a(this.f40721d, campaignEx, "splash");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.js.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        l a4 = l.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a4.b((String) it.next());
                        }
                    } catch (Exception unused) {
                        x.d(b.this.f40718a, "campain can't insert db");
                    }
                }
            }).start();
        } catch (Throwable th) {
            x.b(this.f40718a, "sendImpressions", th);
        }
    }

    public final void j(Object obj, String str) {
        String str2 = this.f40718a;
        x.a(str2, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbjscommon.bridge.b.a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    int optInt2 = jSONObject.optInt("report");
                    if (optInt2 == 0) {
                        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.f().j(), (CampaignEx) null, "", optString, false, optInt != 0);
                    } else {
                        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.f().j(), (CampaignEx) null, "", optString, false, optInt != 0, optInt2);
                    }
                }
                h.a().a(obj, c.a(0));
            } catch (Throwable th) {
                x.b(this.f40718a, "reportUrls", th);
            }
        }
    }

    public final void k(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbjscommon.windvane.a) {
                h.a().a(((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a);
            }
        } catch (Throwable th) {
            x.b(this.f40718a, "onJSBridgeConnect", th);
        }
    }

    public final void l(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.f40726i);
            jSONObject.put("data", jSONObject2);
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e4) {
            x.d(this.f40718a, e4.getMessage());
        }
        com.mbridge.msdk.splash.d.a aVar = this.f40727j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(java.lang.Object r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L2c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L22
            r0.<init>(r4)     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = "countdown"
            int r4 = r0.optInt(r4)     // Catch: java.lang.Exception -> L22
            com.mbridge.msdk.mbjscommon.windvane.h r0 = com.mbridge.msdk.mbjscommon.windvane.h.a()     // Catch: java.lang.Exception -> L1f
            java.lang.String r1 = com.mbridge.msdk.splash.js.c.a(r1)     // Catch: java.lang.Exception -> L1f
            r0.a(r3, r1)     // Catch: java.lang.Exception -> L1f
            r1 = r4
            goto L2c
        L1f:
            r3 = move-exception
            r1 = r4
            goto L23
        L22:
            r3 = move-exception
        L23:
            java.lang.String r4 = r2.f40718a
            java.lang.String r3 = r3.getMessage()
            com.mbridge.msdk.foundation.tools.x.d(r4, r3)
        L2c:
            com.mbridge.msdk.splash.d.a r3 = r2.f40727j
            if (r3 == 0) goto L34
            r4 = 2
            r3.a(r4, r1)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.js.b.m(java.lang.Object, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.b
    public final void open(String str) {
        com.mbridge.msdk.splash.d.a aVar = this.f40727j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.b
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.b
    public final void useCustomClose(boolean z3) {
        int i4 = z3 ? 2 : 1;
        try {
            com.mbridge.msdk.splash.d.a aVar = this.f40727j;
            if (aVar != null) {
                aVar.a(i4);
            }
        } catch (Throwable th) {
            x.b(this.f40718a, "useCustomClose", th);
        }
    }

    public final void a(Context context) {
        this.f40719b = new WeakReference<>(context);
    }

    public final List<CampaignEx> b() {
        return this.f40720c;
    }

    public final void c(Object obj, String str) {
        com.mbridge.msdk.splash.d.a aVar = this.f40727j;
        if (aVar != null) {
            aVar.a(obj, str);
        }
    }

    public final void a(int i4) {
        this.f40724g = i4;
    }

    public final void b(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.splash.d.a aVar = this.f40727j;
            if (aVar != null) {
                aVar.a(optInt);
            }
        } catch (Throwable th) {
            x.b(this.f40718a, "toggleCloseBtn", th);
        }
    }

    public final void a(com.mbridge.msdk.splash.d.a aVar) {
        if (aVar != null) {
            this.f40727j = aVar;
        }
    }

    public final com.mbridge.msdk.splash.d.a a() {
        return this.f40727j;
    }

    public final void a(List<CampaignEx> list) {
        this.f40720c = list;
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.splash.a.a aVar = new com.mbridge.msdk.splash.a.a(com.mbridge.msdk.foundation.controller.a.f().j());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f40723f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", aVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f40720c));
            com.mbridge.msdk.c.d e4 = com.mbridge.msdk.c.b.a().e(com.mbridge.msdk.foundation.controller.a.f().k(), this.f40721d);
            if (e4 == null) {
                e4 = com.mbridge.msdk.c.d.d(this.f40721d);
            }
            if (!TextUtils.isEmpty(this.f40722e)) {
                e4.g(this.f40722e);
            }
            e4.a(this.f40721d);
            e4.b(this.f40725h);
            e4.a(this.f40724g);
            jSONObject.put("unitSetting", e4.t());
            String c4 = com.mbridge.msdk.c.b.a().c(com.mbridge.msdk.foundation.controller.a.f().k());
            if (!TextUtils.isEmpty(c4)) {
                jSONObject.put("appSetting", new JSONObject(c4));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbjscommon.base.d.f40205a);
            String str2 = this.f40718a;
            x.d(str2, "init" + jSONObject.toString());
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            x.b(this.f40718a, "init", th);
        }
    }
}
