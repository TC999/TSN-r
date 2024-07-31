package com.mbridge.msdk.p457c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.DomainMBridgeConstans;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest;
import com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.p454a.OmsdkUtils;
import com.mbridge.msdk.p457c.p458a.SettingRequest;
import com.mbridge.msdk.p457c.p459b.ActiveAppUtil;
import com.mbridge.msdk.p457c.p459b.MraidJSController;
import com.mbridge.msdk.p457c.p459b.WebEnvCheckController;
import com.mbridge.msdk.p462d.ShortCutsManager;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SettingRequestController {

    /* renamed from: a */
    private static final String f29899a = "c";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m23208b(final Context context, final String str, final String str2) {
        String[] split;
        if (!RequestUrlUtil.m22248a().m22241d()) {
            try {
                if (RequestUrlUtil.m22248a().f30773E) {
                    return;
                }
                RequestUrlUtil.m22248a().f30773E = true;
                if (System.currentTimeMillis() >= SharedPerferenceManager.m22949a().m22948a("mkey_spare_host_ts").longValue() + 86400000) {
                    String m22944b = SharedPerferenceManager.m22949a().m22944b("mkey_spare_host");
                    if (!TextUtils.isEmpty(m22944b)) {
                        for (String str3 : m22944b.split(ShellAdbUtils.f33810d)) {
                            if (!TextUtils.isEmpty(str3.trim()) && !RequestUrlUtil.m22248a().f30774F.contains(str3.trim())) {
                                RequestUrlUtil.m22248a().f30774F.add(str3.trim());
                                RequestUrlUtil.m22248a().f30775G.add(str3.trim());
                            }
                        }
                        m23208b(context, str, str2);
                        return;
                    }
                }
                new CommonAsyncHttpRequest(StubApp.getOrigApplicationContext(context.getApplicationContext())).m22234a(0, RequestUrlUtil.m22248a().f30770B, new CommonRequestParams(), new CommonStringResponseHandler() { // from class: com.mbridge.msdk.c.c.2
                    @Override // com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler
                    /* renamed from: a */
                    public final void mo22294a(String str4) {
                        String[] split2;
                        SameLogTool.m21738a(SettingRequestController.f29899a, "fetch CNDSettingHost success, content = " + str4);
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        SharedPerferenceManager.m22949a().m22946a("mkey_spare_host_ts", System.currentTimeMillis());
                        SharedPerferenceManager.m22949a().m22945a("mkey_spare_host", str4);
                        for (String str5 : str4.split(ShellAdbUtils.f33810d)) {
                            if (!TextUtils.isEmpty(str5.trim()) && !RequestUrlUtil.m22248a().f30774F.contains(str5.trim())) {
                                RequestUrlUtil.m22248a().f30774F.add(str5.trim());
                                RequestUrlUtil.m22248a().f30775G.add(str5.trim());
                            }
                        }
                        SettingRequestController.this.m23208b(context, str, str2);
                    }

                    @Override // com.mbridge.msdk.foundation.same.net.p481b.CommonStringResponseHandler
                    /* renamed from: b */
                    public final void mo22293b(String str4) {
                        RequestUrlUtil.m22248a().f30773E = false;
                        String str5 = SettingRequestController.f29899a;
                        SameLogTool.m21738a(str5, "fetch CNDSettingHost failed, errorCode = " + str4);
                    }
                });
                return;
            } catch (Throwable th) {
                RequestUrlUtil.m22248a().f30773E = false;
                SameLogTool.m21733d(f29899a, th.getMessage());
                return;
            }
        }
        m23216a(context, str, str2);
    }

    /* renamed from: a */
    public final void m23216a(final Context context, final String str, final String str2) {
        if (context == null) {
            return;
        }
        CommonRequestParams commonRequestParams = new CommonRequestParams();
        commonRequestParams.m22222a("app_id", str);
        commonRequestParams.m22222a("sign", SameMD5.getMD5(str + str2));
        commonRequestParams.m22222a("jm_a", ShortCutsManager.m22996a(context).m22975c());
        commonRequestParams.m22222a("jm_n", ShortCutsManager.m22996a(context).m22999a() + "");
        commonRequestParams.m22222a("launcher", ShortCutsManager.m22996a(context).m22980b());
        try {
            String m23339bb = SettingManager.m23261a().m23241g(str).m23339bb();
            if (TextUtils.isEmpty(m23339bb)) {
                m23339bb = "";
            }
            commonRequestParams.m22222a("vtag", m23339bb);
        } catch (Throwable th) {
            SameLogTool.m21733d(f29899a, th.getMessage());
        }
        if (RequestUrlUtil.m22248a().f30773E) {
            commonRequestParams.m22222a("st_net", RequestUrlUtil.m22248a().f30799i + "");
        }
        CommonMBListener commonMBListener = new CommonMBListener() { // from class: com.mbridge.msdk.c.c.1
            @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener
            /* renamed from: a */
            public final void mo20859a(JSONObject jSONObject) {
                try {
                    String m23209b = SettingRequestController.this.m23209b();
                    int i = RequestUrlUtil.m22248a().f30799i;
                    if (SameTool.m22006a(jSONObject)) {
                        try {
                            int optInt = jSONObject.optInt("use_thread_pool", 0);
                            Context context2 = context;
                            if (context2 != null) {
                                context2.getSharedPreferences("mb_optimization_setting", 0).edit().putInt("use_thread_pool", optInt).apply();
                            }
                        } catch (Exception unused) {
                            Context context3 = context;
                            if (context3 != null) {
                                context3.getSharedPreferences("mb_optimization_setting", 0).edit().putInt("use_thread_pool", 0).apply();
                            }
                        }
                        DomainMBridgeConstans.ALLOW_APK_DOWNLOAD = jSONObject.optBoolean("aa");
                        jSONObject.put("current_time", System.currentTimeMillis());
                        if (RequestUrlUtil.m22248a().f30798h) {
                            if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                jSONObject.put("hst_st_t", RequestUrlUtil.m22248a().f30794d);
                            }
                        } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                            jSONObject.put("hst_st", RequestUrlUtil.m22248a().f30793c);
                        }
                        SettingManager.m23261a().m23251b(str, jSONObject.toString());
                        RequestUrlUtil.m22248a().m22242c();
                        if (!ActiveAppUtil.m23238a().m23235c()) {
                            new Thread(new Runnable() { // from class: com.mbridge.msdk.c.c.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Looper.prepare();
                                    ActiveAppUtil.m23238a().m23233e();
                                    Looper.loop();
                                }
                            }).start();
                        } else {
                            ActiveAppUtil.m23238a().m23234d();
                        }
                        new Thread(new Runnable() { // from class: com.mbridge.msdk.c.c.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                MBSDKContext.m22864g();
                            }
                        }).start();
                        try {
                            if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                MraidJSController.m23231a().m23230a(context, jSONObject.optString("mraid_js"));
                            }
                        } catch (Exception e) {
                            SameLogTool.m21733d(SettingRequestController.f29899a, e.getMessage());
                        }
                        if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                            WebEnvCheckController.m23225a().m23224a(context, jSONObject.optString("web_env_url"));
                        }
                        SettingRequestController.m23211a(SettingRequestController.this, context, str);
                    } else {
                        SettingManager m23261a = SettingManager.m23261a();
                        String str3 = str;
                        String m23249c = m23261a.m23249c(str3);
                        if (!TextUtils.isEmpty(m23249c)) {
                            JSONObject jSONObject2 = new JSONObject(m23249c);
                            jSONObject2.put("current_time", System.currentTimeMillis());
                            m23261a.m23251b(str3, jSONObject2.toString());
                        }
                    }
                    SettingRequestController.m23213a(SettingRequestController.this, 1, i, "", m23209b);
                    SettingRequestController.m23207b(SettingRequestController.this);
                } catch (Exception e2) {
                    SameLogTool.m21733d(SettingRequestController.f29899a, e2.getMessage());
                }
            }

            @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener
            /* renamed from: a */
            public final void mo20860a(String str3) {
                SettingRequestController.m23213a(SettingRequestController.this, 2, RequestUrlUtil.m22248a().f30799i, str3, SettingRequestController.this.m23209b());
                if (!RequestUrlUtil.m22248a().f30798h) {
                    RequestUrlUtil.m22248a().f30771C++;
                } else {
                    RequestUrlUtil.m22248a().f30772D++;
                }
                SettingRequestController.this.m23208b(context, str, str2);
                SettingRequestController.m23207b(SettingRequestController.this);
                SameLogTool.m21733d(SettingRequestController.f29899a, "get app setting error" + str3);
            }
        };
        SettingRequest settingRequest = new SettingRequest(context);
        String str3 = RequestUrlUtil.m22248a().f30806p;
        try {
            if (RequestUrlUtil.m22248a().f30798h && RequestUrlUtil.m22248a().f30773E && RequestUrlUtil.m22248a().f30772D < RequestUrlUtil.m22248a().f30775G.size()) {
                String str4 = RequestUrlUtil.m22248a().f30775G.get(RequestUrlUtil.m22248a().f30772D);
                if (!TextUtils.isEmpty(str4) && (str4.startsWith(IDataSource.f43971a) || str4.startsWith("https"))) {
                    str3 = str4 + "/setting";
                }
            }
        } catch (Throwable th2) {
            SameLogTool.m21733d(f29899a, th2.getMessage());
        }
        settingRequest.m22234a(1, str3, commonRequestParams, commonMBListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m23209b() {
        String str = RequestUrlUtil.m22248a().f30798h ? RequestUrlUtil.m22248a().f30811u : RequestUrlUtil.m22248a().f30806p;
        try {
            if (RequestUrlUtil.m22248a().f30798h && RequestUrlUtil.m22248a().f30773E && RequestUrlUtil.m22248a().f30772D < RequestUrlUtil.m22248a().f30775G.size()) {
                String str2 = RequestUrlUtil.m22248a().f30775G.get(RequestUrlUtil.m22248a().f30772D);
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                if (str2.startsWith(IDataSource.f43971a) || str2.startsWith("https")) {
                    return str2 + "/setting";
                }
                return str;
            }
            return str;
        } catch (Throwable th) {
            SameLogTool.m21733d(f29899a, th.getMessage());
            return str;
        }
    }

    /* renamed from: a */
    public final void m23215a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = MBSDKContext.m22865f().m22860k();
            str2 = MBSDKContext.m22865f().m22859l();
        }
        if (SettingManager.m23261a().m23256a(str3, str) && SettingManager.m23261a().m23257a(str, 2, str3)) {
            CommonRequestParams commonRequestParams = new CommonRequestParams();
            String str4 = "[" + str3 + "]";
            commonRequestParams.m22222a("unit_ids", str4);
            commonRequestParams.m22222a("app_id", str);
            commonRequestParams.m22222a("sign", SameMD5.getMD5(str + str2));
            try {
                String m23172y = SettingManager.m23261a().m23248c(str, str4).m23172y();
                if (TextUtils.isEmpty(m23172y)) {
                    m23172y = "";
                }
                commonRequestParams.m22222a("vtag", m23172y);
            } catch (Throwable th) {
                SameLogTool.m21733d(f29899a, th.getMessage());
            }
            new SettingRequest(context).m22234a(1, RequestUrlUtil.m22248a().f30806p, commonRequestParams, new CommonMBListener() { // from class: com.mbridge.msdk.c.c.3
                @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener
                /* renamed from: a */
                public final void mo20859a(JSONObject jSONObject) {
                    try {
                        if (SameTool.m22006a(jSONObject)) {
                            String optString = jSONObject.optString("vtag", "");
                            JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                                optJSONObject.put("current_time", System.currentTimeMillis());
                                optJSONObject.put("vtag", optString);
                                SettingManager.m23261a().m23255a(str, str3, optJSONObject.toString());
                            }
                        } else {
                            SettingManager.m23261a().m23240g(str, str3);
                        }
                        SettingRequestController.m23212a(SettingRequestController.this, 1, "");
                    } catch (Exception e) {
                        SameLogTool.m21733d(SettingRequestController.f29899a, e.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener
                /* renamed from: a */
                public final void mo20860a(String str5) {
                    SettingRequestController.m23212a(SettingRequestController.this, 2, str5);
                }
            });
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m23207b(SettingRequestController settingRequestController) {
        try {
            new ReportController(MBSDKContext.m22865f().m22861j()).m22106a();
        } catch (Throwable th) {
            SameLogTool.m21733d(f29899a, th.getMessage());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23211a(SettingRequestController settingRequestController, Context context, String str) {
        Setting m23252b;
        SettingManager m23261a = SettingManager.m23261a();
        if (m23261a != null && (m23252b = m23261a.m23252b(str)) != null) {
            MBridgeConstans.OMID_JS_SERVICE_URL = m23252b.m23385aM();
            MBridgeConstans.OMID_JS_H5_URL = m23252b.m23386aL();
        }
        OmsdkUtils.m23472a(context);
        OmsdkUtils.m23466b(context);
    }

    /* renamed from: a */
    static /* synthetic */ void m23213a(SettingRequestController settingRequestController, int i, int i2, String str, String str2) {
        try {
            new ReportController(MBSDKContext.m22865f().m22861j()).m22105a(i, i2, str, str2);
        } catch (Throwable th) {
            SameLogTool.m21733d(f29899a, th.getMessage());
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23212a(SettingRequestController settingRequestController, int i, String str) {
        try {
            new ReportController(MBSDKContext.m22865f().m22861j()).m22105a(i, RequestUrlUtil.m22248a().f30799i, str, RequestUrlUtil.m22248a().f30798h ? RequestUrlUtil.m22248a().f30811u : RequestUrlUtil.m22248a().f30806p);
        } catch (Throwable th) {
            SameLogTool.m21733d(f29899a, th.getMessage());
        }
    }
}
