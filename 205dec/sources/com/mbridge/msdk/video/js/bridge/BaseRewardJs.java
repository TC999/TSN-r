package com.mbridge.msdk.video.js.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.bridge.b;
import com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbjscommon.windvane.h;
import com.mbridge.msdk.video.js.a.j;
import com.stub.StubApp;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BaseRewardJs extends AbsMbridgeDownload implements IRewardBridge {

    /* renamed from: a  reason: collision with root package name */
    protected IRewardBridge f40890a;

    private String a(int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i4);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            x.d("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void cai(Object obj, String str) {
        x.a("JS-Reward-Brigde", "cai:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                try {
                    String optString = new JSONObject(str).optString("packageName");
                    if (TextUtils.isEmpty(optString)) {
                        b.a(obj, "packageName is empty");
                    }
                    int i4 = ac.c(a.f().j(), optString) ? 1 : 2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", b.f40210b);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", i4);
                        jSONObject.put("data", jSONObject2);
                        h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e4) {
                        b.a(obj, e4.getMessage());
                        x.a("JS-Reward-Brigde", e4.getMessage());
                    }
                } catch (JSONException e5) {
                    b.a(obj, "exception: " + e5.getLocalizedMessage());
                    x.b("JS-Reward-Brigde", "cai", e5);
                }
            } catch (Throwable th) {
                b.a(obj, "exception: " + th.getLocalizedMessage());
                x.b("JS-Reward-Brigde", "cai", th);
            }
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void getEndScreenInfo(Object obj, String str) {
        try {
            IRewardBridge iRewardBridge = this.f40890a;
            if (iRewardBridge != null) {
                iRewardBridge.getEndScreenInfo(obj, str);
                x.d("JS-Reward-Brigde", "getEndScreenInfo factory is true");
            } else {
                x.d("JS-Reward-Brigde", "getEndScreenInfo factory is null");
                if (obj != null) {
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbjscommon.windvane.a) obj).f40326a;
                    if ((windVaneWebView instanceof WindVaneWebView) && windVaneWebView.getWebViewListener() != null) {
                        ((com.mbridge.msdk.mbjscommon.c.a) windVaneWebView.getWebViewListener()).a(obj);
                    }
                }
            }
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void gial(Object obj, String str) {
        x.a("JS-Reward-Brigde", "gial:" + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", b.f40210b);
            JSONObject jSONObject2 = new JSONObject();
            List<String> list = a.f39079c;
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
            b.a(obj, e4.getMessage());
            x.a("JS-Reward-Brigde", e4.getMessage());
        } catch (Throwable th) {
            b.a(obj, th.getMessage());
            x.a("JS-Reward-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.f40890a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f40890a.handlerPlayableException(obj, str);
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", "handlerPlayableException", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.j
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean z3;
        super.initialize(context, windVaneWebView);
        try {
            z3 = Class.forName("com.mbridge.msdk.video.js.factory.IJSFactory").isInstance(context);
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            z3 = false;
        }
        try {
            if (z3) {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.js.bridge.BaseRewardJsH5");
                this.f40890a = (IRewardBridge) cls.newInstance();
                cls.getMethod("initialize", Context.class, WindVaneWebView.class).invoke(this.f40890a, context, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardBridge)) {
                this.f40890a = (IRewardBridge) windVaneWebView.getObject();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void install(Object obj, String str) {
        String addDownloaderListener = addDownloaderListener(obj, str);
        try {
            IRewardBridge iRewardBridge = this.f40890a;
            if (iRewardBridge != null) {
                iRewardBridge.install(obj, addDownloaderListener);
            } else if (TextUtils.isEmpty(addDownloaderListener)) {
            } else {
                if (obj != null) {
                    com.mbridge.msdk.mbjscommon.windvane.a aVar = (com.mbridge.msdk.mbjscommon.windvane.a) obj;
                    if (aVar.f40326a.getObject() instanceof j) {
                        j jVar = (j) aVar.f40326a.getObject();
                        Context context = aVar.f40326a.getContext();
                        if (context != null && context != StubApp.getOrigApplicationContext(context.getApplicationContext())) {
                            jVar.a(context);
                        }
                        jVar.click(1, addDownloaderListener);
                        x.d("JS-Reward-Brigde", "JSCommon install jump success");
                    }
                }
                x.d("JS-Reward-Brigde", "JSCommon install failed");
            }
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_INSTALL_KEY, th);
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f40890a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f40890a.notifyCloseBtn(obj, str);
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void openURL(Object obj, String str) {
        x.d("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
        } else if (TextUtils.isEmpty(str)) {
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                int optInt = jSONObject.optInt("type");
                if (optInt == 1) {
                    c.a(this.mContext, optString);
                } else if (optInt == 2) {
                    c.b(this.mContext, optString);
                }
            } catch (JSONException e4) {
                x.d("JS-Reward-Brigde", e4.getMessage());
            } catch (Throwable th) {
                x.d("JS-Reward-Brigde", th.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.AbsMbridgeDownload
    public void sendNoticeAndCallBackClick(Object obj, String str) {
        install(obj, str);
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void setOrientation(Object obj, String str) {
        try {
            if (this.f40890a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f40890a.setOrientation(obj, str);
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f40890a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f40890a.toggleCloseBtn(obj, str);
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.js.bridge.IRewardBridge
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.f40890a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f40890a.triggerCloseBtn(obj, str);
        } catch (Throwable th) {
            x.b("JS-Reward-Brigde", "triggerCloseBtn", th);
            h.a().a(obj, a(-1));
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.j
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean z3;
        super.initialize(obj, windVaneWebView);
        try {
            z3 = Class.forName("com.mbridge.msdk.video.js.factory.IJSFactory").isInstance(obj);
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            z3 = false;
        }
        try {
            if (z3) {
                Class<?> cls = Class.forName("com.mbridge.msdk.video.js.bridge.BaseRewardJsH5");
                this.f40890a = (IRewardBridge) cls.newInstance();
                cls.getMethod("initialize", Object.class, WindVaneWebView.class).invoke(this.f40890a, obj, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof IRewardBridge)) {
                this.f40890a = (IRewardBridge) windVaneWebView.getObject();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }
}
