package com.beizi.ad.alipay.js;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.beizi.ad.alipay.RedPackageManager;
import com.beizi.ad.alipay.RedPackageUtil;
import com.beizi.ad.alipay.inter.ResultListener;
import com.beizi.ad.alipay.inter.UserInfoListener;
import com.beizi.ad.alipay.inter.WelfareListener;
import com.beizi.ad.lance.a.l;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class JavaScriptInterface {
    private static final String TAG = "JavaScriptInterface";
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
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
        l.b(TAG, "welfareAliPayWithParams : bean " + jsInnerInterfaceBean.toString());
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
                    @Override // com.beizi.ad.alipay.inter.BaseListener
                    public void failCallback(int i4, String str) {
                        l.b(JavaScriptInterface.TAG, "authAliPayWithParams failCallback code : " + i4 + " , msg : " + str);
                        JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                        JSONObject jSONObject2 = jSONObject;
                        JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject2, i4 + "", str, "");
                        l.b(JavaScriptInterface.TAG, "authAliPayWithParams failCallback jsonObjectResult : " + convertJsonObject);
                        JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                    }

                    @Override // com.beizi.ad.alipay.inter.BaseListener
                    public void successCallBack(Map<String, Object> map) {
                        l.b(JavaScriptInterface.TAG, "authAliPayWithParams successCallBack map : " + map);
                        JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", RedPackageUtil.convertMapToJson(map));
                        l.b(JavaScriptInterface.TAG, "authAliPayWithParams successCallBack jsonObjectResult : " + convertJsonObject);
                        JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                    }
                });
            }
        } catch (Exception e4) {
            l.b(TAG, "authAliPayWithParams : exception " + e4);
            e4.printStackTrace();
        }
    }

    private void authInfo(JsInnerInterfaceBean jsInnerInterfaceBean) {
        l.b(TAG, "authInfo : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            if (TextUtils.isEmpty(jsInnerInterfaceBean.getData())) {
                return;
            }
            RedPackageManager.getInstance().authInfo(RedPackageUtil.convertJsonToMap(jsInnerInterfaceBean.getData()), new UserInfoListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.2
                @Override // com.beizi.ad.alipay.inter.BaseListener
                public void failCallback(int i4, String str) {
                    l.b(JavaScriptInterface.TAG, "authInfo failCallback code : " + i4 + " ,msg : " + str);
                    JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                    JSONObject jSONObject2 = jSONObject;
                    JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject2, i4 + "", str, "");
                    l.b(JavaScriptInterface.TAG, "authInfo failCallback jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }

                @Override // com.beizi.ad.alipay.inter.BaseListener
                public void successCallBack(Map<String, Object> map) {
                    l.b(JavaScriptInterface.TAG, "authInfo successCallBack map : " + map);
                    JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", RedPackageUtil.convertMapToJson(map));
                    l.b(JavaScriptInterface.TAG, "authInfo successCallBack jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }
            });
        } catch (Exception e4) {
            l.b(TAG, "authInfo : exception " + e4);
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject convertJsonObject(JSONObject jSONObject, String str, String str2, String str3) {
        try {
            jSONObject.put("code", str);
            jSONObject.put("msg", str2);
            jSONObject.put("data", str3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    private void rtaUser(JsInnerInterfaceBean jsInnerInterfaceBean) {
        l.b(TAG, "rtaUser : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            final JSONObject jSONObject2 = new JSONObject();
            RedPackageManager.getInstance().rtaUser(new ResultListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.1
                @Override // com.beizi.ad.alipay.inter.ResultListener
                public void onFail(int i4, String str) {
                    l.b(JavaScriptInterface.TAG, "rtaUser onFail errorCode : " + i4 + " , msg : " + str);
                    JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                    JSONObject jSONObject3 = jSONObject;
                    JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject3, i4 + "", str, "");
                    l.b(JavaScriptInterface.TAG, "rtaUser onFail jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }

                @Override // com.beizi.ad.alipay.inter.ResultListener
                public void onSuccess(boolean z3) {
                    l.b(JavaScriptInterface.TAG, "rtaUser successCallBack map : " + z3);
                    try {
                        jSONObject2.put("requiredFlow", z3);
                        JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", jSONObject2.toString());
                        l.b(JavaScriptInterface.TAG, "rtaUser successCallBack jsonObjectResult : " + convertJsonObject);
                        JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            l.b(TAG, "rtaUser : exception " + e4);
            e4.printStackTrace();
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
        l.b(TAG, "welfareAliPayWithParams : bean " + jsInnerInterfaceBean.toString());
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("handlerName", jsInnerInterfaceBean.getHandlerName());
            if (TextUtils.isEmpty(jsInnerInterfaceBean.getData())) {
                return;
            }
            RedPackageManager.getInstance().welfareAliPayWithParams(RedPackageUtil.convertJsonToMap(jsInnerInterfaceBean.getData()), new WelfareListener() { // from class: com.beizi.ad.alipay.js.JavaScriptInterface.4
                @Override // com.beizi.ad.alipay.inter.BaseListener
                public void failCallback(int i4, String str) {
                    l.b(JavaScriptInterface.TAG, "welfareAliPayWithParams failCallback code : " + i4 + " , msg : " + str);
                    JavaScriptInterface javaScriptInterface = JavaScriptInterface.this;
                    JSONObject jSONObject2 = jSONObject;
                    JSONObject convertJsonObject = javaScriptInterface.convertJsonObject(jSONObject2, i4 + "", str, "");
                    l.b(JavaScriptInterface.TAG, "welfareAliPayWithParams failCallback jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }

                @Override // com.beizi.ad.alipay.inter.BaseListener
                public void successCallBack(Map<String, Object> map) {
                    l.b(JavaScriptInterface.TAG, "welfareAliPayWithParams successCallBack map : " + map);
                    JSONObject convertJsonObject = JavaScriptInterface.this.convertJsonObject(jSONObject, "200", "success call", RedPackageUtil.convertMapToJson(map));
                    l.b(JavaScriptInterface.TAG, "welfareAliPayWithParams successCallBack jsonObjectResult : " + convertJsonObject);
                    JavaScriptInterface.this.sendResultMessage(convertJsonObject);
                }
            });
        } catch (Exception e4) {
            l.b(TAG, "welfareAliPayWithParams : exception " + e4);
            e4.printStackTrace();
        }
    }

    @JavascriptInterface
    public void callNativeHandler(String str) {
        l.b(TAG, "jsCode: " + str);
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
        } catch (Exception e4) {
            e4.printStackTrace();
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
