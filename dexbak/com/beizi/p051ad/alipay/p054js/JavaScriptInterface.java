package com.beizi.p051ad.alipay.p054js;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.beizi.p051ad.alipay.RedPackageManager;
import com.beizi.p051ad.alipay.RedPackageUtil;
import com.beizi.p051ad.alipay.inter.ResultListener;
import com.beizi.p051ad.alipay.inter.UserInfoListener;
import com.beizi.p051ad.alipay.inter.WelfareListener;
import com.beizi.p051ad.lance.p062a.LogUtil;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.alipay.js.JavaScriptInterface */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class JavaScriptInterface {
    private static final String TAG = "JavaScriptInterface";
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.alipay.js.JavaScriptInterface$JsInnerInterfaceBean */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class JsInnerInterfaceBean implements Serializable {
        private String data;
        private String handlerName;

        private JsInnerInterfaceBean() {
        }

        public String getData() {
            return this.data;
        }

        public String getHandlerName() {
            return this.handlerName;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setHandlerName(String str) {
            this.handlerName = str;
        }

        public String toString() {
            return "{\"handlerName\":\"" + this.handlerName + "\", \"data\":\"" + this.data + "\"}";
        }
    }

    public JavaScriptInterface(WebView webView) {
        this.webView = webView;
    }

    private void authAliPayWithParams(JsInnerInterfaceBean jsInnerInterfaceBean) {
        LogUtil.m49045b(TAG, "welfareAliPayWithParams : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            if (TextUtils.isEmpty(jsInnerInterfaceBean.getData())) {
                return;
            }
            Map<String, String> convertJsonToMap = RedPackageUtil.convertJsonToMap(jsInnerInterfaceBean.getData());
            Activity activityFromView = getActivityFromView(this.webView);
            if (activityFromView != null) {
                RedPackageManager.getInstance().authAliPayWithParams(activityFromView, convertJsonToMap, new UserInfoListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.3
                    @Override // com.beizi.p051ad.alipay.inter.BaseListener
                    public void failCallback(int i, String str) {
                        LogUtil.m49045b(JavaScriptInterface.TAG, "authAliPayWithParams failCallback code : " + i + " , msg : " + str);
                        JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                        JSONObject jSONObject2 = jSONObject;
                        JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject2, i + "", str, "");
                        LogUtil.m49045b(JavaScriptInterface.TAG, "authAliPayWithParams failCallback jsonObjectResult : " + convertJsonObject);
                        JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                    }

                    @Override // com.beizi.p051ad.alipay.inter.BaseListener
                    public void successCallBack(Map<String, Object> map) {
                        LogUtil.m49045b(JavaScriptInterface.TAG, "authAliPayWithParams successCallBack map : " + map);
                        JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", RedPackageUtil.convertMapToJson(map));
                        LogUtil.m49045b(JavaScriptInterface.TAG, "authAliPayWithParams successCallBack jsonObjectResult : " + convertJsonObject);
                        JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                    }
                });
            }
        } catch (Exception e) {
            LogUtil.m49045b(TAG, "authAliPayWithParams : exception " + e);
            e.printStackTrace();
        }
    }

    private void authInfo(JsInnerInterfaceBean jsInnerInterfaceBean) {
        LogUtil.m49045b(TAG, "authInfo : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            if (TextUtils.isEmpty(jsInnerInterfaceBean.getData())) {
                return;
            }
            RedPackageManager.getInstance().authInfo(RedPackageUtil.convertJsonToMap(jsInnerInterfaceBean.getData()), new UserInfoListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.2
                @Override // com.beizi.p051ad.alipay.inter.BaseListener
                public void failCallback(int i, String str) {
                    LogUtil.m49045b(JavaScriptInterface.TAG, "authInfo failCallback code : " + i + " ,msg : " + str);
                    JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                    JSONObject jSONObject2 = jSONObject;
                    JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject2, i + "", str, "");
                    LogUtil.m49045b(JavaScriptInterface.TAG, "authInfo failCallback jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }

                @Override // com.beizi.p051ad.alipay.inter.BaseListener
                public void successCallBack(Map<String, Object> map) {
                    LogUtil.m49045b(JavaScriptInterface.TAG, "authInfo successCallBack map : " + map);
                    JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", RedPackageUtil.convertMapToJson(map));
                    LogUtil.m49045b(JavaScriptInterface.TAG, "authInfo successCallBack jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }
            });
        } catch (Exception e) {
            LogUtil.m49045b(TAG, "authInfo : exception " + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject convertJsonObject(JSONObject jSONObject, String str, String str2, String str3) {
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
            jSONObject.put("data", str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void rtaUser(JsInnerInterfaceBean jsInnerInterfaceBean) {
        LogUtil.m49045b(TAG, "rtaUser : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            final JSONObject jSONObject2 = new JSONObject();
            RedPackageManager.getInstance().rtaUser(new ResultListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.1
                @Override // com.beizi.p051ad.alipay.inter.ResultListener
                public void onFail(int i, String str) {
                    LogUtil.m49045b(JavaScriptInterface.TAG, "rtaUser onFail errorCode : " + i + " , msg : " + str);
                    JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                    JSONObject jSONObject3 = jSONObject;
                    JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject3, i + "", str, "");
                    LogUtil.m49045b(JavaScriptInterface.TAG, "rtaUser onFail jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }

                @Override // com.beizi.p051ad.alipay.inter.ResultListener
                public void onSuccess(boolean z) {
                    LogUtil.m49045b(JavaScriptInterface.TAG, "rtaUser successCallBack map : " + z);
                    try {
                        jSONObject2.put("requiredFlow", z);
                        JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", jSONObject2.toString());
                        LogUtil.m49045b(JavaScriptInterface.TAG, "rtaUser successCallBack jsonObjectResult : " + convertJsonObject);
                        JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            LogUtil.m49045b(TAG, "rtaUser : exception " + e);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResultMessage(JSONObject jSONObject) {
        final String jSONObject2 = jSONObject.toString();
        this.webView.post(new Runnable() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.5
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = JavaScriptInterface.this.webView;
                webView.loadUrl("javascript:handleMessageFromNative(" + jSONObject2 + ")");
            }
        });
    }

    private void welfareAliPayWithParams(JsInnerInterfaceBean jsInnerInterfaceBean) {
        LogUtil.m49045b(TAG, "welfareAliPayWithParams : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            if (TextUtils.isEmpty(jsInnerInterfaceBean.getData())) {
                return;
            }
            RedPackageManager.getInstance().welfareAliPayWithParams(RedPackageUtil.convertJsonToMap(jsInnerInterfaceBean.getData()), new WelfareListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.4
                @Override // com.beizi.p051ad.alipay.inter.BaseListener
                public void failCallback(int i, String str) {
                    LogUtil.m49045b(JavaScriptInterface.TAG, "welfareAliPayWithParams failCallback code : " + i + " , msg : " + str);
                    JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                    JSONObject jSONObject2 = jSONObject;
                    JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject2, i + "", str, "");
                    LogUtil.m49045b(JavaScriptInterface.TAG, "welfareAliPayWithParams failCallback jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }

                @Override // com.beizi.p051ad.alipay.inter.BaseListener
                public void successCallBack(Map<String, Object> map) {
                    LogUtil.m49045b(JavaScriptInterface.TAG, "welfareAliPayWithParams successCallBack map : " + map);
                    JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", RedPackageUtil.convertMapToJson(map));
                    LogUtil.m49045b(JavaScriptInterface.TAG, "welfareAliPayWithParams successCallBack jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }
            });
        } catch (Exception e) {
            LogUtil.m49045b(TAG, "welfareAliPayWithParams : exception " + e);
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void callNativeHandler(String str) {
        LogUtil.m49045b(TAG, "jsCode: " + str);
        try {
            JsInnerInterfaceBean jsInnerInterfaceBean = new JsInnerInterfaceBean();
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("handlerName") && !TextUtils.isEmpty(jSONObject.optString("handlerName"))) {
                    jsInnerInterfaceBean.setHandlerName(jSONObject.optString("handlerName"));
                }
                if (jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.optString("data"))) {
                    jsInnerInterfaceBean.setData(jSONObject.optString("data"));
                }
            }
            if ("rtaUser".equals(jsInnerInterfaceBean.getHandlerName())) {
                rtaUser(jsInnerInterfaceBean);
            } else if ("authInfo".equals(jsInnerInterfaceBean.getHandlerName())) {
                authInfo(jsInnerInterfaceBean);
            } else if ("authAliPayWithParams".equals(jsInnerInterfaceBean.getHandlerName())) {
                authAliPayWithParams(jsInnerInterfaceBean);
            } else if ("welfareAliPayWithParams".equals(jsInnerInterfaceBean.getHandlerName())) {
                welfareAliPayWithParams(jsInnerInterfaceBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Activity getActivityFromView(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
