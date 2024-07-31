package com.mbridge.msdk.videocommon.p514c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener;
import com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.videocommon.p515d.RewardSettingManager;
import com.mbridge.msdk.videocommon.p515d.RewardUnitSetting;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.videocommon.c.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RewardSettingController {

    /* renamed from: a */
    private static final String f32199a = "com.mbridge.msdk.videocommon.c.a";

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d A[Catch: all -> 0x0071, TRY_ENTER, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x0022, B:5:0x0029, B:7:0x0050, B:11:0x005d, B:12:0x0061, B:16:0x006d, B:8:0x0055), top: B:22:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x0022, B:5:0x0029, B:7:0x0050, B:11:0x005d, B:12:0x0061, B:16:0x006d, B:8:0x0055), top: B:22:0x0022 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m20863a(android.content.Context r5, final java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.same.net.g.d r0 = new com.mbridge.msdk.foundation.same.net.g.d
            r0.<init>()
            java.lang.String r1 = "app_id"
            r0.m22222a(r1, r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)
            java.lang.String r1 = "sign"
            r0.m22222a(r1, r7)
            com.mbridge.msdk.videocommon.p515d.RewardSettingManager.m20835a()     // Catch: java.lang.Throwable -> L71
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.p515d.RewardSettingManager.f32218a     // Catch: java.lang.Throwable -> L71
            if (r7 != 0) goto L55
            com.mbridge.msdk.foundation.a.a.a r7 = com.mbridge.msdk.foundation.p468a.p469a.SharedPerferenceManager.m22949a()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = "reward_"
            r1.append(r2)     // Catch: java.lang.Throwable -> L71
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Throwable -> L71
            java.lang.String r2 = r2.m22860k()     // Catch: java.lang.Throwable -> L71
            r1.append(r2)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L71
            java.lang.String r7 = r7.m22944b(r1)     // Catch: java.lang.Throwable -> L71
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L55
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.p515d.RewardSetting.m20852a(r7)     // Catch: java.lang.Throwable -> L71
            goto L57
        L55:
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.p515d.RewardSettingManager.f32218a     // Catch: java.lang.Throwable -> L71
        L57:
            java.lang.String r1 = ""
            java.lang.String r2 = "vtag"
            if (r7 != 0) goto L61
            r0.m22222a(r2, r1)     // Catch: java.lang.Throwable -> L71
            goto L7b
        L61:
            java.lang.String r7 = r7.m20855a()     // Catch: java.lang.Throwable -> L71
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L71
            if (r3 == 0) goto L6c
            goto L6d
        L6c:
            r1 = r7
        L6d:
            r0.m22222a(r2, r1)     // Catch: java.lang.Throwable -> L71
            goto L7b
        L71:
            r7 = move-exception
            java.lang.String r1 = com.mbridge.msdk.videocommon.p514c.RewardSettingController.f32199a
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r7)
        L7b:
            com.mbridge.msdk.videocommon.c.a$1 r7 = new com.mbridge.msdk.videocommon.c.a$1
            r7.<init>()
            com.mbridge.msdk.videocommon.c.b r6 = new com.mbridge.msdk.videocommon.c.b
            r6.<init>(r5)
            r5 = 1
            com.mbridge.msdk.foundation.same.net.f.d r1 = com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil.m22248a()
            java.lang.String r1 = r1.f30808r
            r6.m22234a(r5, r1, r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.p514c.RewardSettingController.m20863a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public final void m20862a(Context context, final String str, String str2, String str3, final RewardSettingResponseHandler rewardSettingResponseHandler) {
        CommonRequestParams commonRequestParams = new CommonRequestParams();
        commonRequestParams.m22222a("app_id", str);
        commonRequestParams.m22222a("sign", SameMD5.getMD5(str + str2));
        commonRequestParams.m22222a("unit_ids", "[" + str3 + "]");
        try {
            RewardUnitSetting m20821c = RewardSettingManager.m20835a().m20821c(str, str3);
            String str4 = "";
            if (m20821c == null) {
                commonRequestParams.m22222a("vtag", "");
            } else {
                String m20775l = m20821c.m20775l();
                if (!TextUtils.isEmpty(m20775l)) {
                    str4 = m20775l;
                }
                commonRequestParams.m22222a("vtag", str4);
            }
        } catch (Throwable th) {
            SameLogTool.m21733d(f32199a, th.getMessage());
        }
        CommonMBListener commonMBListener = new CommonMBListener() { // from class: com.mbridge.msdk.videocommon.c.a.2
            @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener
            /* renamed from: a */
            public final void mo20859a(final JSONObject jSONObject) {
                try {
                    try {
                        RewardSettingManager.m20835a().m20833a(this.f30757d);
                    } catch (Throwable th2) {
                        SameLogTool.m21733d(RewardSettingController.f32199a, th2.getMessage());
                        return;
                    }
                } catch (Exception e) {
                    SameLogTool.m21733d(RewardSettingController.f32199a, e.getMessage());
                }
                if (SameTool.m22006a(jSONObject)) {
                    if (RewardSettingManager.m20822c(jSONObject.toString())) {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.videocommon.c.a.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                RewardSettingManager m20835a = RewardSettingManager.m20835a();
                                C117232 c117232 = C117232.this;
                                m20835a.m20831a(str, c117232.f30757d, jSONObject.toString());
                            }
                        };
                        if (SDKController.m22827a().m22818d()) {
                            ThreadPoolUtils.m22309a().execute(runnable);
                        } else {
                            runnable.run();
                        }
                        RewardSettingResponseHandler rewardSettingResponseHandler2 = rewardSettingResponseHandler;
                        if (rewardSettingResponseHandler2 != null) {
                            rewardSettingResponseHandler2.m20857a("request success");
                        }
                    } else {
                        RewardSettingResponseHandler rewardSettingResponseHandler3 = rewardSettingResponseHandler;
                        if (rewardSettingResponseHandler3 != null) {
                            rewardSettingResponseHandler3.m20856b("data error");
                        }
                    }
                    RewardSettingController.m20861a(RewardSettingController.this, 1, "");
                    return;
                }
                RewardSettingManager m20835a = RewardSettingManager.m20835a();
                String str5 = str;
                String str6 = this.f30757d;
                String m22944b = SharedPerferenceManager.m22949a().m22944b("reward_" + str5 + "_" + str6);
                if (TextUtils.isEmpty(m22944b)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(m22944b);
                jSONObject2.put("current_time", System.currentTimeMillis());
                m20835a.m20831a(str5, str6, jSONObject2.toString());
            }

            @Override // com.mbridge.msdk.foundation.same.net.p486g.CommonMBListener
            /* renamed from: a */
            public final void mo20860a(String str5) {
                try {
                    RewardSettingManager.m20835a().m20833a(this.f30757d);
                } catch (Exception e) {
                    SameLogTool.m21733d(RewardSettingController.f32199a, e.getMessage());
                }
                if (!TextUtils.isEmpty(str5)) {
                    RewardSettingResponseHandler rewardSettingResponseHandler2 = rewardSettingResponseHandler;
                    if (rewardSettingResponseHandler2 != null) {
                        rewardSettingResponseHandler2.m20856b(str5);
                    }
                } else {
                    RewardSettingResponseHandler rewardSettingResponseHandler3 = rewardSettingResponseHandler;
                    if (rewardSettingResponseHandler3 != null) {
                        rewardSettingResponseHandler3.m20856b("request error");
                    }
                }
                RewardSettingController.m20861a(RewardSettingController.this, 2, str5);
            }
        };
        commonMBListener.f30757d = str3;
        new RewardSettingRequest(context).m22234a(1, RequestUrlUtil.m22248a().f30808r, commonRequestParams, commonMBListener);
    }

    /* renamed from: a */
    static /* synthetic */ void m20861a(RewardSettingController rewardSettingController, int i, String str) {
        try {
            new ReportController(MBSDKContext.m22865f().m22861j()).m22105a(i, RequestUrlUtil.m22248a().f30799i, str, RequestUrlUtil.m22248a().f30798h ? RequestUrlUtil.m22248a().f30811u : RequestUrlUtil.m22248a().f30806p);
        } catch (Throwable th) {
            SameLogTool.m21733d(f32199a, th.getMessage());
        }
    }
}
