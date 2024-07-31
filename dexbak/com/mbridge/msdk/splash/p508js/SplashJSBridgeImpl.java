package com.mbridge.msdk.splash.p508js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.same.p474a.StaticDataPoll;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.base.JsCommonParams;
import com.mbridge.msdk.mbjscommon.bridge.CommonJSBridgeImpUtils;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.UnitSetting;
import com.mbridge.msdk.splash.p501a.C11566a;
import com.mbridge.msdk.splash.p505d.SplashBridgeListener;
import com.mbridge.msdk.splash.p506e.SplashReport;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.splash.js.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashJSBridgeImpl implements InterfaceC11610a {

    /* renamed from: b */
    private WeakReference<Context> f31952b;

    /* renamed from: c */
    private List<CampaignEx> f31953c;

    /* renamed from: d */
    private String f31954d;

    /* renamed from: e */
    private String f31955e;

    /* renamed from: f */
    private int f31956f;

    /* renamed from: g */
    private int f31957g;

    /* renamed from: i */
    private int f31959i;

    /* renamed from: j */
    private SplashBridgeListener f31960j;

    /* renamed from: k */
    private SplashExpandDialog f31961k;

    /* renamed from: a */
    private String f31951a = "SplashJSBridgeImpl";

    /* renamed from: h */
    private int f31958h = 5;

    public SplashJSBridgeImpl(Context context, String str, String str2) {
        this.f31955e = str;
        this.f31954d = str2;
        this.f31952b = new WeakReference<>(context);
    }

    /* renamed from: b */
    public final void m21028b(int i) {
        this.f31958h = i;
    }

    /* renamed from: c */
    public final void m21026c(int i) {
        this.f31959i = i;
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
    public final void close() {
        SameLogTool.m21733d(this.f31951a, "close");
        try {
            SplashBridgeListener splashBridgeListener = this.f31960j;
            if (splashBridgeListener != null) {
                splashBridgeListener.mo21120a();
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "close", th);
        }
    }

    /* renamed from: d */
    public final void m21024d(Object obj, String str) {
        SameLogTool.m21733d(this.f31951a, "install");
        try {
            List<CampaignEx> list = this.f31953c;
            if (list == null) {
                return;
            }
            CampaignEx campaignEx = null;
            if (list != null && list.size() > 0) {
                campaignEx = this.f31953c.get(0);
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
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SplashBridgeListener splashBridgeListener = this.f31960j;
            if (splashBridgeListener != null) {
                splashBridgeListener.mo21117a(campaignEx);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    /* renamed from: e */
    public final void m21023e(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = this.f31951a;
        SameLogTool.m21733d(str2, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.m21521a(obj, "params is null");
            return;
        }
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (m22861j == null) {
            try {
                if ((obj instanceof CallMethodContext) && (windVaneWebView = ((CallMethodContext) obj).f31554a) != null) {
                    m22861j = windVaneWebView.getContext();
                }
            } catch (Exception e) {
                SameLogTool.m21733d(this.f31951a, e.getMessage());
            }
        }
        if (m22861j == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                CommonClickUtil.m23076a(m22861j, optString);
            } else if (optInt == 2) {
                CommonClickUtil.m23069b(m22861j, optString);
            }
        } catch (JSONException e2) {
            SameLogTool.m21733d(this.f31951a, e2.getMessage());
        } catch (Throwable th) {
            SameLogTool.m21733d(this.f31951a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
    public final void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.f31952b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            SplashExpandDialog splashExpandDialog = this.f31961k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                SplashExpandDialog splashExpandDialog2 = new SplashExpandDialog(this.f31952b.get(), bundle, this.f31960j);
                this.f31961k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.f31954d, this.f31953c);
                this.f31961k.show();
                SplashBridgeListener splashBridgeListener = this.f31960j;
                if (splashBridgeListener != null) {
                    splashBridgeListener.mo21115a(true);
                }
                SplashReport.m21058a(this.f31954d, getMraidCampaign(), str);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "expand", th);
        }
    }

    /* renamed from: f */
    public final void m21022f(Object obj, String str) {
        String str2 = this.f31951a;
        SameLogTool.m21738a(str2, "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.m21521a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                try {
                    String optString = new JSONObject(str).optString(TTDownloadField.TT_PACKAGE_NAME);
                    if (TextUtils.isEmpty(optString)) {
                        CommonJSBridgeImpUtils.m21521a(obj, "packageName is empty");
                    }
                    int i = SameTool.m21992c(MBSDKContext.m22865f().m22861j(), optString) ? 1 : 2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", CommonJSBridgeImpUtils.f31438b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(CommonNetImpl.RESULT, i);
                        jSONObject.put("data", jSONObject2);
                        WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        CommonJSBridgeImpUtils.m21521a(obj, e.getMessage());
                        SameLogTool.m21738a(this.f31951a, e.getMessage());
                    }
                } catch (Throwable th) {
                    CommonJSBridgeImpUtils.m21521a(obj, "exception: " + th.getLocalizedMessage());
                    SameLogTool.m21735b(this.f31951a, "cai", th);
                }
            } catch (JSONException e2) {
                CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e2.getLocalizedMessage());
                SameLogTool.m21735b(this.f31951a, "cai", e2);
            }
        }
    }

    /* renamed from: g */
    public final void m21021g(Object obj, String str) {
        String str2 = this.f31951a;
        SameLogTool.m21738a(str2, "gial:" + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.f31438b);
            JSONObject jSONObject2 = new JSONObject();
            List<String> list = MBSDKContext.f30252c;
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(list.get(i));
                }
            }
            jSONObject2.put("packageNameList", jSONArray);
            jSONObject.put("data", jSONObject2);
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, e.getMessage());
            SameLogTool.m21738a(this.f31951a, e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.m21521a(obj, th.getMessage());
            SameLogTool.m21738a(this.f31951a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f31953c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f31953c.get(0);
    }

    /* renamed from: h */
    public final void m21020h(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = new JSONObject(str).getInt("countdown");
            SplashBridgeListener splashBridgeListener = this.f31960j;
            if (splashBridgeListener != null) {
                splashBridgeListener.mo21113b(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: i */
    public final void m21019i(Object obj, String str) {
        String str2 = this.f31951a;
        SameLogTool.m21738a(str2, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                for (CampaignEx campaignEx : this.f31953c) {
                    if (campaignEx.getId().equals(string)) {
                        StaticDataPoll.m22375a(this.f31954d, campaignEx, MediationConstant.RIT_TYPE_SPLASH);
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.js.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        FrequenceDao m22703a = FrequenceDao.m22703a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            m22703a.m22698b((String) it.next());
                        }
                    } catch (Exception unused) {
                        SameLogTool.m21733d(SplashJSBridgeImpl.this.f31951a, "campain can't insert db");
                    }
                }
            }).start();
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "sendImpressions", th);
        }
    }

    /* renamed from: j */
    public final void m21018j(Object obj, String str) {
        String str2 = this.f31951a;
        SameLogTool.m21738a(str2, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.m21521a(obj, "params is null");
        } else if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    int optInt2 = jSONObject.optInt("report");
                    if (optInt2 == 0) {
                        CommonClickControl.m23128a(MBSDKContext.m22865f().m22861j(), (CampaignEx) null, "", optString, false, optInt != 0);
                    } else {
                        CommonClickControl.m23127a(MBSDKContext.m22865f().m22861j(), (CampaignEx) null, "", optString, false, optInt != 0, optInt2);
                    }
                }
                WindVaneCallJs.m21387a().m21384a(obj, SplashJsUtils.m21013a(0));
            } catch (Throwable th) {
                SameLogTool.m21735b(this.f31951a, "reportUrls", th);
            }
        }
    }

    /* renamed from: k */
    public final void m21017k(Object obj, String str) {
        try {
            if (obj instanceof CallMethodContext) {
                WindVaneCallJs.m21387a().m21386a(((CallMethodContext) obj).f31554a);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "onJSBridgeConnect", th);
        }
    }

    /* renamed from: l */
    public final void m21016l(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.f31959i);
            jSONObject.put("data", jSONObject2);
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            SameLogTool.m21733d(this.f31951a, e.getMessage());
        }
        SplashBridgeListener splashBridgeListener = this.f31960j;
        if (splashBridgeListener != null) {
            splashBridgeListener.mo21118a(1, -1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m21015m(java.lang.Object r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L2c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L22
            r0.<init>(r4)     // Catch: java.lang.Exception -> L22
            java.lang.String r4 = "countdown"
            int r4 = r0.optInt(r4)     // Catch: java.lang.Exception -> L22
            com.mbridge.msdk.mbjscommon.windvane.h r0 = com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs.m21387a()     // Catch: java.lang.Exception -> L1f
            java.lang.String r1 = com.mbridge.msdk.splash.p508js.SplashJsUtils.m21013a(r1)     // Catch: java.lang.Exception -> L1f
            r0.m21384a(r3, r1)     // Catch: java.lang.Exception -> L1f
            r1 = r4
            goto L2c
        L1f:
            r3 = move-exception
            r1 = r4
            goto L23
        L22:
            r3 = move-exception
        L23:
            java.lang.String r4 = r2.f31951a
            java.lang.String r3 = r3.getMessage()
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r4, r3)
        L2c:
            com.mbridge.msdk.splash.d.a r3 = r2.f31960j
            if (r3 == 0) goto L34
            r4 = 2
            r3.mo21118a(r4, r1)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.p508js.SplashJSBridgeImpl.m21015m(java.lang.Object, java.lang.String):void");
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
    public final void open(String str) {
        SplashBridgeListener splashBridgeListener = this.f31960j;
        if (splashBridgeListener != null) {
            splashBridgeListener.mo21114a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbjscommon.mraid.IMraidJSBridge
    public final void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            SplashBridgeListener splashBridgeListener = this.f31960j;
            if (splashBridgeListener != null) {
                splashBridgeListener.mo21119a(i);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "useCustomClose", th);
        }
    }

    /* renamed from: a */
    public final void m21034a(Context context) {
        this.f31952b = new WeakReference<>(context);
    }

    /* renamed from: b */
    public final List<CampaignEx> m21029b() {
        return this.f31953c;
    }

    /* renamed from: c */
    public final void m21025c(Object obj, String str) {
        SplashBridgeListener splashBridgeListener = this.f31960j;
        if (splashBridgeListener != null) {
            splashBridgeListener.mo21116a(obj, str);
        }
    }

    /* renamed from: a */
    public final void m21035a(int i) {
        this.f31957g = i;
    }

    /* renamed from: b */
    public final void m21027b(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int optInt = new JSONObject(str).optInt("state");
            SplashBridgeListener splashBridgeListener = this.f31960j;
            if (splashBridgeListener != null) {
                splashBridgeListener.mo21119a(optInt);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "toggleCloseBtn", th);
        }
    }

    /* renamed from: a */
    public final void m21033a(SplashBridgeListener splashBridgeListener) {
        if (splashBridgeListener != null) {
            this.f31960j = splashBridgeListener;
        }
    }

    /* renamed from: a */
    public final SplashBridgeListener m21036a() {
        return this.f31960j;
    }

    /* renamed from: a */
    public final void m21030a(List<CampaignEx> list) {
        this.f31953c = list;
    }

    /* renamed from: a */
    public final void m21031a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            C11566a c11566a = new C11566a(MBSDKContext.m22865f().m22861j());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f31956f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(ConstantHelper.LOG_DE, c11566a.m21298a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f31953c));
            UnitSetting m23244e = SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), this.f31954d);
            if (m23244e == null) {
                m23244e = UnitSetting.m23196d(this.f31954d);
            }
            if (!TextUtils.isEmpty(this.f31955e)) {
                m23244e.m23190g(this.f31955e);
            }
            m23244e.m23204a(this.f31954d);
            m23244e.m23202b(this.f31958h);
            m23244e.m23205a(this.f31957g);
            jSONObject.put("unitSetting", m23244e.m23177t());
            String m23249c = SettingManager.m23261a().m23249c(MBSDKContext.m22865f().m22860k());
            if (!TextUtils.isEmpty(m23249c)) {
                jSONObject.put("appSetting", new JSONObject(m23249c));
            }
            jSONObject.put("sdk_info", JsCommonParams.f31433a);
            String str2 = this.f31951a;
            SameLogTool.m21733d(str2, "init" + jSONObject.toString());
            WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            SameLogTool.m21735b(this.f31951a, "init", th);
        }
    }
}
