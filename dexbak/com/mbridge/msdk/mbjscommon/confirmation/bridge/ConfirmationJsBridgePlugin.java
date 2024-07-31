package com.mbridge.msdk.mbjscommon.confirmation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.DomainDeviceInfo;
import com.mbridge.msdk.foundation.tools.PermMappingUtil;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.bridge.CommonJSBridgeImpUtils;
import com.mbridge.msdk.mbjscommon.confirmation.ConfirmationJsExtra;
import com.mbridge.msdk.mbjscommon.confirmation.SecondaryConfirmationManager;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.p457c.UnitSetting;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ConfirmationJsBridgePlugin extends AbsMbridgeDownload {

    /* renamed from: a */
    private static String f31446a = "ConfirmationJsBridgePlugin";

    /* renamed from: a */
    private ConfirmationJsExtra m21493a(Object obj) {
        if (obj instanceof CallMethodContext) {
            Object object = ((CallMethodContext) obj).f31554a.getObject();
            if (object instanceof ConfirmationJsExtra) {
                return (ConfirmationJsExtra) object;
            }
        }
        return null;
    }

    public void click(Object obj, String str) {
        try {
            m21492a(obj, str);
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }

    public void confirmCancel(Object obj, String str) {
        try {
            SecondaryConfirmationManager.m21474a().m21458a(obj, str);
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }

    public void confirmClick(Object obj, String str) {
        try {
            m21492a(obj, str);
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }

    public void confirmClose(Object obj, String str) {
        try {
            SecondaryConfirmationManager.m21474a().m21458a(obj, str);
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }

    public void init(Object obj, String str) {
        SameLogTool.m21733d(f31446a, " INIT INVOKE");
        ConfirmationJsExtra m21493a = m21493a(obj);
        if (m21493a != null) {
            CampaignEx m21496b = m21493a.m21496b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(m21496b);
            try {
                JSONObject jSONObject = new JSONObject();
                DomainDeviceInfo domainDeviceInfo = new DomainDeviceInfo(MBSDKContext.m22865f().m22861j());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dev_close_state", 0);
                jSONObject.put("sdkSetting", jSONObject2);
                jSONObject.put(ConstantHelper.LOG_DE, domainDeviceInfo.m21924a());
                jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(arrayList));
                UnitSetting m23244e = SettingManager.m23261a().m23244e(MBSDKContext.m22865f().m22860k(), m21493a.m21494d());
                if (m23244e == null) {
                    m23244e = UnitSetting.m23196d(m21493a.m21494d());
                }
                jSONObject.put("unitSetting", m23244e.m23177t());
                String m23249c = SettingManager.m23261a().m23249c(MBSDKContext.m22865f().m22860k());
                if (!TextUtils.isEmpty(m23249c)) {
                    jSONObject.put("appSetting", new JSONObject(m23249c));
                }
                WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                SameLogTool.m21735b(f31446a, "init", th);
                CommonJSBridgeImpUtils.m21521a(obj, "exception: " + th.getLocalizedMessage());
            }
        }
    }

    public void install(Object obj, String str) {
        try {
            m21492a(obj, str);
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }

    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            String str2 = f31446a;
            SameLogTool.m21733d(str2, "openURL:" + str);
            if (TextUtils.isEmpty(str)) {
                CommonJSBridgeImpUtils.m21521a(obj, "params is null");
                return;
            }
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (!TextUtils.isEmpty(str)) {
                if (m22861j == null) {
                    try {
                        if ((obj instanceof CallMethodContext) && (windVaneWebView = ((CallMethodContext) obj).f31554a) != null) {
                            m22861j = windVaneWebView.getContext();
                        }
                    } catch (Exception e) {
                        SameLogTool.m21733d(f31446a, e.getMessage());
                    }
                }
                if (m22861j == null) {
                    CommonJSBridgeImpUtils.m21521a(obj, "context is null");
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
                    SameLogTool.m21733d(f31446a, e2.getMessage());
                } catch (Throwable th) {
                    SameLogTool.m21733d(f31446a, th.getMessage());
                }
            }
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e3) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e3.getLocalizedMessage());
        }
    }

    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int optInt = new JSONObject(str).optInt("isReady", 1);
                WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
                ConfirmationJsExtra m21493a = m21493a(obj);
                if ((m21493a != null ? m21493a.m21496b() : null) != null) {
                    SecondaryConfirmationManager.m21474a().m21459a(obj, optInt);
                } else {
                    SecondaryConfirmationManager.m21474a().m21459a(obj, 2);
                }
            } catch (Throwable th) {
                SameLogTool.m21735b(f31446a, "readyStatus", th);
                CommonJSBridgeImpUtils.m21521a(obj, "exception: " + th.getLocalizedMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        SecondaryConfirmationManager.m21474a().m21451b(obj, str);
    }

    public void translatePermission(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("permissionMap");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, PermMappingUtil.m21816a(jSONObject2.getJSONArray(next)));
                }
                jSONObject.put("permissionMap", jSONObject2);
                WindVaneCallJs.m21387a().m21384a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                return;
            }
            CommonJSBridgeImpUtils.m21521a(obj, "exception: params is " + str);
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    private void m21492a(Object obj, String str) {
        try {
            addDownloaderListener(obj, str);
            SecondaryConfirmationManager.m21474a().m21451b(obj, str);
            WindVaneCallJs.m21387a().m21384a(obj, CommonJSBridgeImpUtils.m21522a(0));
        } catch (Exception e) {
            CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e.getLocalizedMessage());
        }
    }
}
