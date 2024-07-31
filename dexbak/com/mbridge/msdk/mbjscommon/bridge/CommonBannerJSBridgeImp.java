package com.mbridge.msdk.mbjscommon.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.click.CommonClickControl;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.bridge.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class CommonBannerJSBridgeImp implements IBannerJSBridge {

    /* renamed from: a */
    public static final String f31436a = "a";

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: a */
    public void mo21518a(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "init: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: b */
    public void mo21517b(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "click: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: c */
    public void mo21516c(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "readyStatus: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: d */
    public void mo21515d(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "toggleCloseBtn: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: e */
    public void mo21514e(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "triggerCloseBtn: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: f */
    public void mo21513f(Object obj, String str) {
        try {
            if (obj instanceof CallMethodContext) {
                WindVaneCallJs.m21387a().m21386a(((CallMethodContext) obj).f31554a);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b(f31436a, "onJSBridgeConnect", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: g */
    public void mo21512g(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "install: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: h */
    public void mo21511h(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "resetCountdown: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: i */
    public void mo21510i(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "sendImpressions: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: j */
    public void mo21509j(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "getFileInfo:" + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: k */
    public final void mo21508k(Object obj, String str) {
        String str2 = f31436a;
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
                WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
            } catch (Throwable th) {
                SameLogTool.m21735b(f31436a, "reportUrls", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: l */
    public final void mo21507l(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "increaseOfferFrequence:" + str);
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.m21521a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                CommonJSBridgeImpUtils.m21520a(obj, new JSONObject(str));
            } catch (Throwable th) {
                SameLogTool.m21735b(f31436a, "increaseOfferFrequence", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: m */
    public final void mo21506m(Object obj, String str) {
        String str2 = f31436a;
        SameLogTool.m21738a(str2, "handlerH5Exception: " + str);
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: n */
    public final void mo21505n(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = f31436a;
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
                SameLogTool.m21733d(f31436a, e.getMessage());
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
            SameLogTool.m21733d(f31436a, e2.getMessage());
        } catch (Throwable th) {
            SameLogTool.m21733d(f31436a, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: o */
    public final void mo21504o(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        String str2 = f31436a;
        SameLogTool.m21733d(str2, "getNetstat:" + str);
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
                SameLogTool.m21733d(f31436a, e.getMessage());
            }
        }
        if (m22861j == null) {
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(1));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("netstat", SameDiTool.m21804D(m22861j));
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            WindVaneCallJs.m21387a().m21384a(obj, jSONObject2);
        } catch (Throwable th) {
            SameLogTool.m21733d(f31436a, th.getMessage());
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(1));
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: p */
    public final void mo21503p(Object obj, String str) {
        String str2 = f31436a;
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
                        SameLogTool.m21738a(f31436a, e.getMessage());
                    }
                } catch (Throwable th) {
                    CommonJSBridgeImpUtils.m21521a(obj, "exception: " + th.getLocalizedMessage());
                    SameLogTool.m21735b(f31436a, "cai", th);
                }
            } catch (JSONException e2) {
                CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e2.getLocalizedMessage());
                SameLogTool.m21735b(f31436a, "cai", e2);
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.bridge.IBannerJSBridge
    /* renamed from: q */
    public final void mo21502q(Object obj, String str) {
        String str2 = f31436a;
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
            SameLogTool.m21738a(f31436a, e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.m21521a(obj, th.getMessage());
            SameLogTool.m21738a(f31436a, th.getMessage());
        }
    }
}
