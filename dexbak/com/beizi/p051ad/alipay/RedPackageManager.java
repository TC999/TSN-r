package com.beizi.p051ad.alipay;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.app.OpenAuthTask;
import com.beizi.p051ad.alipay.RedPackageEnum;
import com.beizi.p051ad.alipay.inter.Callback;
import com.beizi.p051ad.alipay.inter.ResultListener;
import com.beizi.p051ad.alipay.inter.UserInfoListener;
import com.beizi.p051ad.alipay.inter.WelfareListener;
import com.beizi.p051ad.alipay.model.AliPayEventBean;
import com.beizi.p051ad.alipay.model.IncentiveConfig;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.lance.p062a.C3019b;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.alipay.RedPackageManager */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RedPackageManager {
    public static final String APP_ORDER_ID_KEY = "app_order_id_key";
    public static final String APP_USERID_KEY = "app_user_id_key";
    public static final String AUTH_CODE_KEY = "auth_code";
    private static final String MACRO_DEFAULT = "appId=__APPID__&packageName=__PACKAGENAME__&installTime=__INSTALLTIME__&updateTime=__UPDATETIME__&nowTime=__NOWTIME__&appVersion=__APPVERSION__&appVersionCode=__APPVERSIONCODE__&sdkVersion=__SDKVERSION__&OAID=__OAID__&GAID=__GAID__&sdkUID=__SDKUID__&SDKUIDORIG=__SDKUIDORIG__&idfa=__IDFA__&idfv=__IDFV__&os=__OS__&platform=__PLATFORM__&devType=__DEVTYPE__&brand=__BRAND__&model=__MODEL__&resolution=__RESOLUTION__&screenSize=__SCREENSIZE__&density=__DENSITY__&language=__LANGUAGE__&root=__ROOT__&net=__NET__&isp=__ISP__&battery=__BATTERY__&diskSpace=__DISKSPACE__&useSpace=__USESPACE__&developerMode=__DEVELOPERMODE__&appUserId=__APP_USERID__&appOrderId=__APP_ORDERID__&transAmount=__TRANS_AMOUNT__&incentiveConfigVersion=__INCENTIVECONFIGVERSION__&authCode=__AUTH_CODE__";
    private static String TAG = "RedPackageManager";
    private static final String TEST_APPID = "";
    public static final String TRANS_AMOUNT_KEY = "trans_amount_key";
    private static RedPackageManager instance;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.beizi.ad.alipay.RedPackageManager$3 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C27783 implements Callback {
        final /* synthetic */ Activity val$context;
        final /* synthetic */ String val$finalAppId;
        final /* synthetic */ UserInfoListener val$listener;
        final /* synthetic */ Map val$map;

        C27783(String str, UserInfoListener userInfoListener, Activity activity, Map map) {
            this.val$finalAppId = str;
            this.val$listener = userInfoListener;
            this.val$context = activity;
            this.val$map = map;
        }

        @Override // com.beizi.p051ad.alipay.inter.Callback
        public void failCallback(int i, String str) {
            UserInfoListener userInfoListener = this.val$listener;
            if (userInfoListener != null) {
                userInfoListener.failCallback(i, str);
            }
            String str2 = RedPackageManager.TAG;
            LogUtil.m49045b(str2, "failCallback1111 errorCode : " + i + " message : " + str);
        }

        @Override // com.beizi.p051ad.alipay.inter.Callback
        public void successCallback(JSONObject jSONObject) {
            String str = RedPackageManager.TAG;
            LogUtil.m49045b(str, "successCallback1111 : resultStr ： " + jSONObject);
            if (jSONObject.has("resultCode")) {
                if ("200".equals(jSONObject.optString("resultCode"))) {
                    if (!jSONObject.has("userInfo") || TextUtils.isEmpty(jSONObject.optString("userInfo"))) {
                        return;
                    }
                    Map<String, Object> stringToMap = RedPackageUtil.stringToMap(jSONObject.optString("userInfo"));
                    stringToMap.put("appId", this.val$finalAppId);
                    UserInfoListener userInfoListener = this.val$listener;
                    if (userInfoListener != null) {
                        userInfoListener.successCallBack(stringToMap);
                        return;
                    }
                    return;
                } else if ("4001".equals(jSONObject.optString("resultCode"))) {
                    if (!jSONObject.has("authUrl") || TextUtils.isEmpty(jSONObject.optString("authUrl"))) {
                        return;
                    }
                    if (!SystemUtil.m49035a("com.alipay.sdk.app.OpenAuthTask")) {
                        UserInfoListener userInfoListener2 = this.val$listener;
                        if (userInfoListener2 != null) {
                            RedPackageEnum.RedPackageError redPackageError = RedPackageEnum.RedPackageError.ERROR_ALIPAY_SDK_NOT_EXIST;
                            userInfoListener2.failCallback(redPackageError.getCode(), redPackageError.getMsg());
                            return;
                        }
                        return;
                    }
                    String optString = jSONObject.optString("authUrl");
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", optString);
                    new OpenAuthTask(this.val$context).execute("", OpenAuthTask.BizType.AccountAuth, hashMap, new OpenAuthTask.Callback() { // from class: com.beizi.ad.alipay.RedPackageManager.3.1
                        public void onResult(int i, String str2, Bundle bundle) {
                            String str3;
                            String str4 = RedPackageManager.TAG;
                            LogUtil.m49045b(str4, "i : " + i + " , s : " + str2 + " , bundle : " + bundle);
                            if (bundle != null && bundle.containsKey(RedPackageManager.AUTH_CODE_KEY)) {
                                Map map = C27783.this.val$map;
                                String str5 = (map == null || !map.containsKey("app_user_id_key")) ? "" : (String) C27783.this.val$map.get("app_user_id_key");
                                IncentiveConfig m49464n = BeiZiImpl.m49492a().m49464n();
                                String m49089a = C3019b.m49089a("aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FsaXBheS9hdXRoY29kZQ==");
                                if (m49464n == null || TextUtils.isEmpty(m49464n.getAuthUrl())) {
                                    str3 = RedPackageManager.MACRO_DEFAULT;
                                } else {
                                    m49089a = m49464n.getAuthUrl();
                                    str3 = m49464n.getMacro();
                                }
                                String str6 = RedPackageManager.TAG;
                                LogUtil.m49045b(str6, "authUrl : " + m49089a);
                                String string = bundle.getString(RedPackageManager.AUTH_CODE_KEY);
                                AliPayEventBean aliPayEventBean = new AliPayEventBean();
                                aliPayEventBean.setAppUserId(str5);
                                aliPayEventBean.setAuthCode(string);
                                String str7 = RedPackageManager.TAG;
                                LogUtil.m49045b(str7, "aliPayEventBean : " + aliPayEventBean);
                                BeiZiExecutor.m49087b().m49085d().execute(new RedPackageRequest(m49089a, str3, aliPayEventBean, new Callback() { // from class: com.beizi.ad.alipay.RedPackageManager.3.1.1
                                    @Override // com.beizi.p051ad.alipay.inter.Callback
                                    public void failCallback(int i2, String str8) {
                                        UserInfoListener userInfoListener3 = C27783.this.val$listener;
                                        if (userInfoListener3 != null) {
                                            userInfoListener3.failCallback(i2, str8);
                                        }
                                        String str9 = RedPackageManager.TAG;
                                        LogUtil.m49045b(str9, "failCallback2222 : errorCode : " + i2 + " , message : " + str8);
                                    }

                                    @Override // com.beizi.p051ad.alipay.inter.Callback
                                    public void successCallback(JSONObject jSONObject2) {
                                        String str8 = RedPackageManager.TAG;
                                        LogUtil.m49045b(str8, "authAliPayWithParams : successCallback22222 : " + jSONObject2);
                                        if (jSONObject2.has("resultCode")) {
                                            if ("200".equals(jSONObject2.optString("resultCode"))) {
                                                if (!jSONObject2.has("userInfo") || TextUtils.isEmpty(jSONObject2.optString("userInfo"))) {
                                                    return;
                                                }
                                                Map<String, Object> stringToMap2 = RedPackageUtil.stringToMap(jSONObject2.optString("userInfo"));
                                                stringToMap2.put("appId", C27783.this.val$finalAppId);
                                                stringToMap2.put("authCode", "200");
                                                UserInfoListener userInfoListener3 = C27783.this.val$listener;
                                                if (userInfoListener3 != null) {
                                                    userInfoListener3.successCallBack(stringToMap2);
                                                    return;
                                                }
                                                return;
                                            } else if ("4002".equals(jSONObject2.optString("resultCode"))) {
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put("authCode", "4002");
                                                UserInfoListener userInfoListener4 = C27783.this.val$listener;
                                                if (userInfoListener4 != null) {
                                                    userInfoListener4.successCallBack(hashMap2);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                UserInfoListener userInfoListener5 = C27783.this.val$listener;
                                                if (userInfoListener5 != null) {
                                                    RedPackageEnum.RedPackageError redPackageError2 = RedPackageEnum.RedPackageError.ERROR_AUTH_USER_INFO_NOT_EXIST;
                                                    userInfoListener5.failCallback(redPackageError2.getCode(), redPackageError2.getMsg());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        UserInfoListener userInfoListener6 = C27783.this.val$listener;
                                        if (userInfoListener6 != null) {
                                            RedPackageEnum.RedPackageError redPackageError3 = RedPackageEnum.RedPackageError.ERROR_AUTH_INFO_FAIL;
                                            userInfoListener6.failCallback(redPackageError3.getCode(), redPackageError3.getMsg());
                                        }
                                    }
                                }));
                            } else if (C27783.this.val$listener != null) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("authCode", "9001");
                                C27783.this.val$listener.successCallBack(hashMap2);
                            }
                        }
                    }, true);
                    return;
                } else if (this.val$listener != null) {
                    this.val$listener.successCallBack(RedPackageUtil.jsonToMap(jSONObject));
                    return;
                } else {
                    return;
                }
            }
            UserInfoListener userInfoListener3 = this.val$listener;
            if (userInfoListener3 != null) {
                RedPackageEnum.RedPackageError redPackageError2 = RedPackageEnum.RedPackageError.ERROR_AUTH_INFO_FAIL;
                userInfoListener3.failCallback(redPackageError2.getCode(), redPackageError2.getMsg());
            }
        }
    }

    public static RedPackageManager getInstance() {
        if (instance == null) {
            synchronized (RedPackageManager.class) {
                if (instance == null) {
                    instance = new RedPackageManager();
                }
            }
        }
        return instance;
    }

    public void authAliPayWithParams(Activity activity, Map<String, String> map, UserInfoListener userInfoListener) {
        String str;
        String str2;
        String str3;
        try {
            IncentiveConfig m49464n = BeiZiImpl.m49492a().m49464n();
            String m49089a = C3019b.m49089a("aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FsaXBheS91c2VyaW5mbw==");
            String str4 = "";
            if (m49464n == null || TextUtils.isEmpty(m49464n.getUserInfoUrl())) {
                str = m49089a;
                str2 = MACRO_DEFAULT;
                str3 = "";
            } else {
                String userInfoUrl = m49464n.getUserInfoUrl();
                str = userInfoUrl;
                str2 = m49464n.getMacro();
                str3 = m49464n.getAppId();
            }
            String str5 = TAG;
            LogUtil.m49045b(str5, "authAliPayWithParams userInfoUrl : " + str + " , appId : " + str3);
            String str6 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("authAliPayWithParams macroStr : ");
            sb.append(str2);
            LogUtil.m49045b(str6, sb.toString());
            if (map != null && map.containsKey("app_user_id_key") && !TextUtils.isEmpty(map.get("app_user_id_key"))) {
                str4 = map.get("app_user_id_key");
            }
            AliPayEventBean aliPayEventBean = new AliPayEventBean();
            aliPayEventBean.setAppUserId(str4);
            BeiZiExecutor.m49087b().m49085d().execute(new RedPackageRequest(str, str2, aliPayEventBean, new C27783(str3, userInfoListener, activity, map)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void authInfo(Map<String, String> map, final UserInfoListener userInfoListener) {
        final String str;
        try {
            IncentiveConfig m49464n = BeiZiImpl.m49492a().m49464n();
            String m49089a = C3019b.m49089a("aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FsaXBheS91c2VyaW5mbw==");
            String str2 = MACRO_DEFAULT;
            String str3 = "";
            if (m49464n == null || TextUtils.isEmpty(m49464n.getUserInfoUrl())) {
                str = "";
            } else {
                m49089a = m49464n.getUserInfoUrl();
                str2 = m49464n.getMacro();
                str = m49464n.getAppId();
            }
            String str4 = TAG;
            LogUtil.m49045b(str4, "userInfoUrl : " + m49089a + " , appId : " + str);
            String str5 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("macroStr : ");
            sb.append(str2);
            LogUtil.m49045b(str5, sb.toString());
            if (map != null && map.containsKey("app_user_id_key") && !TextUtils.isEmpty(map.get("app_user_id_key"))) {
                str3 = map.get("app_user_id_key");
            }
            AliPayEventBean aliPayEventBean = new AliPayEventBean();
            aliPayEventBean.setAppUserId(str3);
            BeiZiExecutor.m49087b().m49085d().execute(new RedPackageRequest(m49089a, str2, aliPayEventBean, new Callback() { // from class: com.beizi.ad.alipay.RedPackageManager.2
                @Override // com.beizi.p051ad.alipay.inter.Callback
                public void failCallback(int i, String str6) {
                    UserInfoListener userInfoListener2 = userInfoListener;
                    if (userInfoListener2 != null) {
                        userInfoListener2.failCallback(i, str6);
                    }
                    String str7 = RedPackageManager.TAG;
                    LogUtil.m49045b(str7, "failCallback1111 errorCode : " + i + " message : " + str6);
                }

                @Override // com.beizi.p051ad.alipay.inter.Callback
                public void successCallback(JSONObject jSONObject) {
                    String str6 = RedPackageManager.TAG;
                    LogUtil.m49045b(str6, "successCallback1111 : resultStr ： " + jSONObject);
                    if (jSONObject.has("resultCode")) {
                        if ("200".equals(jSONObject.optString("resultCode"))) {
                            if (!jSONObject.has("userInfo") || TextUtils.isEmpty(jSONObject.optString("userInfo"))) {
                                return;
                            }
                            Map<String, Object> stringToMap = RedPackageUtil.stringToMap(jSONObject.optString("userInfo"));
                            stringToMap.put("appId", str);
                            stringToMap.put("authCode", "200");
                            UserInfoListener userInfoListener2 = userInfoListener;
                            if (userInfoListener2 != null) {
                                userInfoListener2.successCallBack(stringToMap);
                                return;
                            }
                            return;
                        } else if ("4001".equals(jSONObject.optString("resultCode"))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("authCode", "4001");
                            UserInfoListener userInfoListener3 = userInfoListener;
                            if (userInfoListener3 != null) {
                                userInfoListener3.successCallBack(hashMap);
                                return;
                            }
                            return;
                        } else if (userInfoListener != null) {
                            userInfoListener.successCallBack(RedPackageUtil.jsonToMap(jSONObject));
                            return;
                        } else {
                            return;
                        }
                    }
                    UserInfoListener userInfoListener4 = userInfoListener;
                    if (userInfoListener4 != null) {
                        RedPackageEnum.RedPackageError redPackageError = RedPackageEnum.RedPackageError.ERROR_GET_USER_INFO_FAIL;
                        userInfoListener4.failCallback(redPackageError.getCode(), redPackageError.getMsg());
                    }
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rtaUser(final ResultListener resultListener) {
        try {
            IncentiveConfig m49464n = BeiZiImpl.m49492a().m49464n();
            String m49089a = C3019b.m49089a("aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FsaXBheS9ydGE=");
            String str = MACRO_DEFAULT;
            if (m49464n != null && !TextUtils.isEmpty(m49464n.getRtaUrl())) {
                m49089a = m49464n.getRtaUrl();
                str = m49464n.getMacro();
            }
            String str2 = TAG;
            LogUtil.m49045b(str2, "rtaUrl : " + m49089a);
            String str3 = TAG;
            LogUtil.m49045b(str3, "macroStr : " + str);
            BeiZiExecutor.m49087b().m49085d().execute(new RedPackageRequest(m49089a, str, null, new Callback() { // from class: com.beizi.ad.alipay.RedPackageManager.1
                @Override // com.beizi.p051ad.alipay.inter.Callback
                public void failCallback(int i, String str4) {
                    ResultListener resultListener2 = resultListener;
                    if (resultListener2 != null) {
                        resultListener2.onFail(i, str4);
                    }
                    String str5 = RedPackageManager.TAG;
                    LogUtil.m49045b(str5, "failCallback 000000 errorCode : " + i + " , message : " + str4);
                }

                @Override // com.beizi.p051ad.alipay.inter.Callback
                public void successCallback(JSONObject jSONObject) {
                    ResultListener resultListener2;
                    String str4 = RedPackageManager.TAG;
                    LogUtil.m49045b(str4, "successCallback 000000 resultJson ： " + jSONObject);
                    if (jSONObject.has("requiredFlow") && jSONObject.optBoolean("requiredFlow") && (resultListener2 = resultListener) != null) {
                        resultListener2.onSuccess(true);
                    }
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void welfareAliPayWithParams(Map<String, String> map, final WelfareListener welfareListener) {
        String str;
        IncentiveConfig m49464n;
        String m49089a;
        String str2;
        String str3 = "";
        if (map != null) {
            try {
                if (map.containsKey("app_user_id_key")) {
                    str = map.get("app_user_id_key");
                    String str4 = (map == null && map.containsKey("app_order_id_key")) ? map.get("app_order_id_key") : "";
                    if (map != null && map.containsKey("trans_amount_key")) {
                        str3 = map.get("trans_amount_key");
                    }
                    m49464n = BeiZiImpl.m49492a().m49464n();
                    m49089a = C3019b.m49089a("aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FsaXBheS90cmFuc2Zlci9tb25leQ==");
                    str2 = MACRO_DEFAULT;
                    if (m49464n != null && !TextUtils.isEmpty(m49464n.getTransferUrl())) {
                        m49089a = m49464n.getTransferUrl();
                        str2 = m49464n.getMacro();
                    }
                    String str5 = TAG;
                    LogUtil.m49045b(str5, "transferUrl : " + m49089a);
                    AliPayEventBean aliPayEventBean = new AliPayEventBean();
                    aliPayEventBean.setAppUserId(str);
                    aliPayEventBean.setAppOrderId(str4);
                    aliPayEventBean.setTransAmount(str3);
                    BeiZiExecutor.m49087b().m49085d().execute(new RedPackageRequest(m49089a, str2, aliPayEventBean, new Callback() { // from class: com.beizi.ad.alipay.RedPackageManager.4
                        @Override // com.beizi.p051ad.alipay.inter.Callback
                        public void failCallback(int i, String str6) {
                            WelfareListener welfareListener2 = welfareListener;
                            if (welfareListener2 != null) {
                                welfareListener2.failCallback(i, str6);
                            }
                            String str7 = RedPackageManager.TAG;
                            LogUtil.m49045b(str7, " failCallback3333 errorCode : " + i + " , message : " + str6);
                        }

                        @Override // com.beizi.p051ad.alipay.inter.Callback
                        public void successCallback(JSONObject jSONObject) {
                            String str6 = RedPackageManager.TAG;
                            LogUtil.m49045b(str6, "successCallback3333 resultStr ： " + jSONObject);
                            if (jSONObject.has("resultCode")) {
                                Map<String, Object> jsonToMap = RedPackageUtil.jsonToMap(jSONObject);
                                WelfareListener welfareListener2 = welfareListener;
                                if (welfareListener2 == null || jsonToMap == null) {
                                    return;
                                }
                                welfareListener2.successCallBack(jsonToMap);
                            }
                        }
                    }));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        str = "";
        if (map == null) {
        }
        if (map != null) {
            str3 = map.get("trans_amount_key");
        }
        m49464n = BeiZiImpl.m49492a().m49464n();
        m49089a = C3019b.m49089a("aHR0cDovL3Nkay1hcGkuYWRuLXBsdXMuY29tLmNuL2FsaXBheS90cmFuc2Zlci9tb25leQ==");
        str2 = MACRO_DEFAULT;
        if (m49464n != null) {
            m49089a = m49464n.getTransferUrl();
            str2 = m49464n.getMacro();
        }
        String str52 = TAG;
        LogUtil.m49045b(str52, "transferUrl : " + m49089a);
        AliPayEventBean aliPayEventBean2 = new AliPayEventBean();
        aliPayEventBean2.setAppUserId(str);
        aliPayEventBean2.setAppOrderId(str4);
        aliPayEventBean2.setTransAmount(str3);
        BeiZiExecutor.m49087b().m49085d().execute(new RedPackageRequest(m49089a, str2, aliPayEventBean2, new Callback() { // from class: com.beizi.ad.alipay.RedPackageManager.4
            @Override // com.beizi.p051ad.alipay.inter.Callback
            public void failCallback(int i, String str6) {
                WelfareListener welfareListener2 = welfareListener;
                if (welfareListener2 != null) {
                    welfareListener2.failCallback(i, str6);
                }
                String str7 = RedPackageManager.TAG;
                LogUtil.m49045b(str7, " failCallback3333 errorCode : " + i + " , message : " + str6);
            }

            @Override // com.beizi.p051ad.alipay.inter.Callback
            public void successCallback(JSONObject jSONObject) {
                String str6 = RedPackageManager.TAG;
                LogUtil.m49045b(str6, "successCallback3333 resultStr ： " + jSONObject);
                if (jSONObject.has("resultCode")) {
                    Map<String, Object> jsonToMap = RedPackageUtil.jsonToMap(jSONObject);
                    WelfareListener welfareListener2 = welfareListener;
                    if (welfareListener2 == null || jsonToMap == null) {
                        return;
                    }
                    welfareListener2.successCallBack(jsonToMap);
                }
            }
        }));
    }
}
