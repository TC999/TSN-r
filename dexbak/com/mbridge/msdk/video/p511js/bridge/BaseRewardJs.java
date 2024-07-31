package com.mbridge.msdk.video.p511js.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.mbjscommon.bridge.CommonJSBridgeImpUtils;
import com.mbridge.msdk.mbjscommon.p496c.DefaultRVWebViewListener;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.CallMethodContext;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneCallJs;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.js.a.j;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.video.js.bridge.BaseRewardJs */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BaseRewardJs extends AbsMbridgeDownload implements IRewardBridge {

    /* renamed from: a */
    protected IRewardBridge f32143a;

    /* renamed from: a */
    private String m20927a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            SameLogTool.m21733d("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void cai(Object obj, String str) {
        SameLogTool.m21738a("JS-Reward-Brigde", "cai:" + str);
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
                        SameLogTool.m21738a("JS-Reward-Brigde", e.getMessage());
                    }
                } catch (JSONException e2) {
                    CommonJSBridgeImpUtils.m21521a(obj, "exception: " + e2.getLocalizedMessage());
                    SameLogTool.m21735b("JS-Reward-Brigde", "cai", e2);
                }
            } catch (Throwable th) {
                CommonJSBridgeImpUtils.m21521a(obj, "exception: " + th.getLocalizedMessage());
                SameLogTool.m21735b("JS-Reward-Brigde", "cai", th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void getEndScreenInfo(Object obj, String str) {
        try {
            IRewardBridge iRewardBridge = this.f32143a;
            if (iRewardBridge != null) {
                iRewardBridge.getEndScreenInfo(obj, str);
                SameLogTool.m21733d("JS-Reward-Brigde", "getEndScreenInfo factory is true");
            } else {
                SameLogTool.m21733d("JS-Reward-Brigde", "getEndScreenInfo factory is null");
                if (obj != null) {
                    WindVaneWebView windVaneWebView = ((CallMethodContext) obj).f31554a;
                    if ((windVaneWebView instanceof WindVaneWebView) && windVaneWebView.getWebViewListener() != null) {
                        ((DefaultRVWebViewListener) windVaneWebView.getWebViewListener()).m21500a(obj);
                    }
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void gial(Object obj, String str) {
        SameLogTool.m21738a("JS-Reward-Brigde", "gial:" + str);
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
            SameLogTool.m21738a("JS-Reward-Brigde", e.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.m21521a(obj, th.getMessage());
            SameLogTool.m21738a("JS-Reward-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f32143a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f32143a.handlerPlayableException(obj, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "handlerPlayableException", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.WindVanePlugin
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(context, windVaneWebView);
        try {
            z = Class.forName("com.mbridge.msdk.video.js.factory.IJSFactory").isInstance(context);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        try {
            if (z) {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.js.bridge.BaseRewardJsH5");
                this.f32143a = (IRewardBridge) cls.newInstance();
                cls.getMethod("initialize", Context.class, WindVaneWebView.class).invoke(this.f32143a, context, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardBridge)) {
                this.f32143a = (IRewardBridge) windVaneWebView.getObject();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void install(Object obj, String str) {
        String addDownloaderListener = addDownloaderListener(obj, str);
        try {
            IRewardBridge iRewardBridge = this.f32143a;
            if (iRewardBridge != null) {
                iRewardBridge.install(obj, addDownloaderListener);
            } else if (TextUtils.isEmpty(addDownloaderListener)) {
            } else {
                if (obj != null) {
                    CallMethodContext callMethodContext = (CallMethodContext) obj;
                    if (callMethodContext.f31554a.getObject() instanceof j) {
                        j jVar = (j) callMethodContext.f31554a.getObject();
                        Context context = callMethodContext.f31554a.getContext();
                        if (context != null && context != StubApp.getOrigApplicationContext(context.getApplicationContext())) {
                            jVar.a(context);
                        }
                        jVar.click(1, addDownloaderListener);
                        SameLogTool.m21733d("JS-Reward-Brigde", "JSCommon install jump success");
                    }
                }
                SameLogTool.m21733d("JS-Reward-Brigde", "JSCommon install failed");
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "install", th);
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f32143a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f32143a.notifyCloseBtn(obj, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void openURL(Object obj, String str) {
        SameLogTool.m21733d("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.m21521a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt("type");
                if (optInt == 1) {
                    CommonClickUtil.m23076a(this.mContext, optString);
                } else if (optInt == 2) {
                    CommonClickUtil.m23069b(this.mContext, optString);
                }
            } catch (JSONException e) {
                SameLogTool.m21733d("JS-Reward-Brigde", e.getMessage());
            } catch (Throwable th) {
                SameLogTool.m21733d("JS-Reward-Brigde", th.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        install(obj, str);
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f32143a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f32143a.setOrientation(obj, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f32143a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f32143a.toggleCloseBtn(obj, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.p511js.bridge.IRewardBridge
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f32143a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f32143a.triggerCloseBtn(obj, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("JS-Reward-Brigde", "triggerCloseBtn", th);
            WindVaneCallJs.m21387a().m21384a(obj, m20927a(-1));
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.WindVanePlugin
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(obj, windVaneWebView);
        try {
            z = Class.forName("com.mbridge.msdk.video.js.factory.IJSFactory").isInstance(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        try {
            if (z) {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.js.bridge.BaseRewardJsH5");
                this.f32143a = (IRewardBridge) cls.newInstance();
                cls.getMethod("initialize", Object.class, WindVaneWebView.class).invoke(this.f32143a, obj, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardBridge)) {
                this.f32143a = (IRewardBridge) windVaneWebView.getObject();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
