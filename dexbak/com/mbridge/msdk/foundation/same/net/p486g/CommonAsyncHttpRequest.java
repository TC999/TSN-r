package com.mbridge.msdk.foundation.same.net.p486g;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.p472db.p473a.ReplaceTempDaoMiddle;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.net.BandWideUtil;
import com.mbridge.msdk.foundation.same.net.C11332Aa;
import com.mbridge.msdk.foundation.same.net.DefaultRetryPolicy;
import com.mbridge.msdk.foundation.same.net.IListener;
import com.mbridge.msdk.foundation.same.net.RetryPolicy;
import com.mbridge.msdk.foundation.same.net.VolleyManager;
import com.mbridge.msdk.foundation.same.net.p485f.RequestUrlUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.UnitSetting;
import com.stub.StubApp;
import java.io.File;
import org.json.JSONArray;

/* renamed from: com.mbridge.msdk.foundation.same.net.g.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CommonAsyncHttpRequest {

    /* renamed from: b */
    private static final String f30818b = "b";

    /* renamed from: a */
    protected Context f30819a;

    public CommonAsyncHttpRequest(Context context) {
        if (context == null) {
            this.f30819a = MBSDKContext.m22865f().m22861j();
        } else {
            this.f30819a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: d */
    private void m22226d(int i, String str, CommonRequestParams commonRequestParams, IListener iListener) {
        String str2 = commonRequestParams.m22221b().get("sign");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        commonRequestParams.m22222a("ts", currentTimeMillis + "");
        commonRequestParams.m22222a("st", SameMD5.getMD5(currentTimeMillis + str2));
        m22232a(i, str, commonRequestParams, new DefaultRetryPolicy(), iListener);
    }

    /* renamed from: a */
    public void mo20858a(String str, CommonRequestParams commonRequestParams) {
        if (commonRequestParams != null) {
            String m22305a = C11332Aa.m22305a();
            if (m22305a == null) {
                m22305a = "";
            }
            commonRequestParams.m22222a("channel", m22305a);
            commonRequestParams.m22222a("band_width", BandWideUtil.m22300a().m22296e() + "");
            commonRequestParams.m22222a("open", CommonConst.f30562C);
            String str2 = f30818b;
            SameLogTool.m21738a(str2, "excute addExtraParams , url:" + str);
            if (!TextUtils.isEmpty(str) && str.contains("setting")) {
                String m22304b = C11332Aa.m22304b();
                if (!TextUtils.isEmpty(m22304b)) {
                    commonRequestParams.m22222a("keyword", m22304b);
                }
            }
            String str3 = commonRequestParams.m22221b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (str3 != null) {
                String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str3, str);
                if (!TextUtils.isEmpty(customInfoByUnitId)) {
                    commonRequestParams.m22222a("ch_info", customInfoByUnitId);
                }
                UnitSetting m23244e = SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), str3);
                if (m23244e != null && !TextUtils.isEmpty(m23244e.m23206a())) {
                    commonRequestParams.m22222a("u_stid", m23244e.m23206a());
                }
            }
            if (SDKAuthorityController.m22828g()) {
                return;
            }
            commonRequestParams.m22222a("dev_source", "2");
            return;
        }
        SameLogTool.m21733d(f30818b, "addExtraParams error, params is null,frame work error");
    }

    /* renamed from: b */
    public final void m22229b(int i, String str, CommonRequestParams commonRequestParams, IListener iListener) {
        m22231a(i, str, commonRequestParams, new DefaultRetryPolicy(), iListener, true);
    }

    /* renamed from: c */
    public final void m22227c(int i, String str, CommonRequestParams commonRequestParams, IListener iListener) {
        m22232a(i, str, commonRequestParams, new DefaultRetryPolicy(), iListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m22228b(int r14, java.lang.String r15, com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams r16, com.mbridge.msdk.foundation.same.net.RetryPolicy r17, com.mbridge.msdk.foundation.same.net.IListener r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest.m22228b(int, java.lang.String, com.mbridge.msdk.foundation.same.net.g.d, com.mbridge.msdk.foundation.same.net.l, com.mbridge.msdk.foundation.same.net.e, boolean):void");
    }

    /* renamed from: a */
    public final void m22234a(int i, String str, CommonRequestParams commonRequestParams, IListener iListener) {
        m22228b(i, str, commonRequestParams, new DefaultRetryPolicy(), iListener, false);
    }

    /* renamed from: a */
    public final void m22231a(int i, String str, CommonRequestParams commonRequestParams, RetryPolicy retryPolicy, IListener iListener, boolean z) {
        m22228b(i, str, commonRequestParams, retryPolicy, iListener, z);
    }

    /* renamed from: a */
    public static void m22230a(File file, String str, IListener iListener) {
        String str2 = f30818b;
        SameLogTool.m21736b(str2, "downloadFile url = " + str);
        VolleyManager.m22160a().m22278a(file, str, iListener);
    }

    /* renamed from: a */
    public final void m22236a(int i, CommonRequestParams commonRequestParams, IListener iListener, String str) {
        m22235a(i, commonRequestParams, iListener, str, new DefaultRetryPolicy());
    }

    /* renamed from: a */
    public final void m22235a(int i, CommonRequestParams commonRequestParams, IListener iListener, String str, RetryPolicy retryPolicy) {
        int m23373aY;
        Setting m23241g = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
        if (TextUtils.isEmpty(str)) {
            m23373aY = m23241g.m23372aZ();
        } else {
            m23373aY = m23241g.m23373aY();
        }
        String m22245a = RequestUrlUtil.m22248a().m22245a(str, m23373aY);
        if (m23373aY < 2) {
            if (retryPolicy == null) {
                m22226d(i, m22245a, commonRequestParams, iListener);
                return;
            } else {
                m22233a(i, m22245a, commonRequestParams, iListener, retryPolicy);
                return;
            }
        }
        if (m23373aY % 2 == 0) {
            if (commonRequestParams == null) {
                commonRequestParams = new CommonRequestParams();
            }
            JSONArray m22810b = ReplaceTempDaoMiddle.m22814a().m22810b();
            if (m22810b != null) {
                String jSONArray = m22810b.toString();
                int m22243b = RequestUrlUtil.m22248a().m22243b();
                if (m22243b > 0 && jSONArray.length() > m22243b) {
                    m22227c(i, m22245a, commonRequestParams, iListener);
                    return;
                }
                commonRequestParams.m22222a(CommonRequestParams.f30825e, jSONArray);
            }
        }
        CommonRequestParams commonRequestParams2 = commonRequestParams;
        if (retryPolicy == null) {
            m22229b(i, m22245a, commonRequestParams2, iListener);
        } else {
            m22231a(i, m22245a, commonRequestParams2, retryPolicy, iListener, true);
        }
    }

    /* renamed from: a */
    private void m22233a(int i, String str, CommonRequestParams commonRequestParams, IListener iListener, RetryPolicy retryPolicy) {
        String str2 = commonRequestParams.m22221b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        commonRequestParams.m22222a("ts", currentTimeMillis + "");
        commonRequestParams.m22222a("st", SameMD5.getMD5(currentTimeMillis + str2));
        if (retryPolicy != null) {
            m22232a(i, str, commonRequestParams, retryPolicy, iListener);
        } else {
            m22232a(i, str, commonRequestParams, new DefaultRetryPolicy(), iListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[Catch: Exception -> 0x00dc, TRY_ENTER, TryCatch #3 {Exception -> 0x00dc, blocks: (B:34:0x00b0, B:36:0x00b6, B:41:0x00c1, B:46:0x00e0), top: B:75:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m22232a(int r15, java.lang.String r16, com.mbridge.msdk.foundation.same.net.p486g.CommonRequestParams r17, com.mbridge.msdk.foundation.same.net.RetryPolicy r18, com.mbridge.msdk.foundation.same.net.IListener r19) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest.m22232a(int, java.lang.String, com.mbridge.msdk.foundation.same.net.g.d, com.mbridge.msdk.foundation.same.net.l, com.mbridge.msdk.foundation.same.net.e):void");
    }
}
