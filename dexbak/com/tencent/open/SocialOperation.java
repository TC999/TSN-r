package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.C12925a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13014e;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocialOperation extends BaseApi {
    public static final String GAME_FRIEND_ADD_MESSAGE = "add_msg";
    public static final String GAME_FRIEND_LABEL = "friend_label";
    public static final String GAME_FRIEND_OPENID = "fopen_id";
    public static final String GAME_SIGNATURE = "signature";
    public static final String GAME_UNION_ID = "unionid";
    public static final String GAME_UNION_NAME = "union_name";
    public static final String GAME_ZONE_ID = "zoneid";

    public SocialOperation(QQToken qQToken) {
        super(qQToken);
    }

    public void bindQQGroup(final Activity activity, String str, String str2, final IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- start");
        if (C12925a.m15471a("openSDK_LOG.GameAppOperation", iUiListener)) {
            return;
        }
        if (activity == null) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, activity is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("mqqapi://opensdk/bind_group?src_type=app&version=1");
        String appId = this.f37136c.getAppId();
        if (TextUtils.isEmpty(appId)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appId is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1003, "appid is null", "please login."));
                return;
            }
            return;
        }
        String openId = this.f37136c.getOpenId();
        if (TextUtils.isEmpty(openId)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, openid is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1004, "openid params is null", "please login."));
                return;
            }
            return;
        }
        String m14968a = C13071m.m14968a(activity);
        if (TextUtils.isEmpty(m14968a)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appname is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1005, "appName params is null", ""));
            }
        } else if (TextUtils.isEmpty(str)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization id is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1006, "organizationId params is null", ""));
            }
        } else if (TextUtils.isEmpty(str2)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization name is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1007, "organizationName params is null", ""));
            }
        } else {
            stringBuffer.append("&app_name=" + Base64.encodeToString(C13071m.m14919j(m14968a), 2));
            stringBuffer.append("&organization_id=" + Base64.encodeToString(C13071m.m14919j(str), 2));
            stringBuffer.append("&organization_name=" + Base64.encodeToString(C13071m.m14919j(str2), 2));
            stringBuffer.append("&openid=" + Base64.encodeToString(C13071m.m14919j(openId), 2));
            stringBuffer.append("&appid=" + Base64.encodeToString(C13071m.m14919j(appId), 2));
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(C13071m.m14919j(Constants.SDK_VERSION), 2));
            stringBuffer.append("&app_name_url_encode=" + C13071m.m14927f(Base64.encodeToString(C13071m.m14919j(m14968a), 2)));
            stringBuffer.append("&organization_name_url_encode=" + C13071m.m14927f(Base64.encodeToString(C13071m.m14919j(str2), 2)));
            SLog.m15123v("openSDK_LOG.GameAppOperation", "-->bindQQGroup, url: " + stringBuffer.toString());
            Uri parse = Uri.parse(stringBuffer.toString());
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.setPackage("com.tencent.mobileqq");
            if (C13066k.m14983c(activity, "8.1.0") < 0) {
                SLog.m15121w("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
                m15247a(activity);
                return;
            }
            DefaultUiListener defaultUiListener = new DefaultUiListener() { // from class: com.tencent.open.SocialOperation.3
                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onCancel() {
                }

                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    SLog.m15121w("openSDK_LOG.GameAppOperation", "-->bind group resp is: " + obj);
                    if (obj == null) {
                        IUiListener iUiListener2 = iUiListener;
                        if (iUiListener2 != null) {
                            iUiListener2.onError(new UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                        }
                    } else if (((JSONObject) obj).optInt("bind") != 1) {
                        try {
                            SocialOperation.this.m15317a(activity, (int) Constants.REQUEST_BIND_GROUP, intent, false);
                        } catch (Exception e) {
                            SLog.m15128e("openSDK_LOG.GameAppOperation", "-->bind group, start activity exception.", e);
                            SocialOperation.this.m15247a(activity);
                        }
                    } else {
                        IUiListener iUiListener3 = iUiListener;
                        if (iUiListener3 != null) {
                            iUiListener3.onError(new UiError(3002, "该群已绑定！", "绑定过的群不能再次绑定。"));
                        }
                        SLog.m15127i("openSDK_LOG.GameAppOperation", "-->bindQQGroup() binded return.");
                    }
                }

                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    SLog.m15123v("openSDK_LOG.GameAppOperation", "-->bindQQGroup, error: " + uiError);
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onError(uiError);
                    }
                }
            };
            Bundle m15318a = m15318a();
            m15318a.putString("appid", appId);
            m15318a.putString("orgid", str);
            HttpUtils.requestAsync(this.f37136c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", m15318a, "GET", new BaseApi.TempRequestListener(defaultUiListener));
            SLog.m15127i("openSDK_LOG.GameAppOperation", "-->bindQQGroup() do.");
        }
    }

    public void joinGroup(final Activity activity, String str, final IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.GameAppOperation", "joinQQGroup()");
        if (C12925a.m15471a("openSDK_LOG.GameAppOperation", iUiListener)) {
            return;
        }
        if (activity == null) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->joinGroup, activity is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1001, "param acitivty is null", "activity param of api can not be null."));
            }
        } else if (TextUtils.isEmpty(str)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->joinGroup, params is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1006, "param organizationId is null", "organizationId param of api can not be null."));
            }
        } else {
            final Intent intent = new Intent();
            String appId = this.f37136c.getAppId();
            if (TextUtils.isEmpty(appId)) {
                SLog.m15129e("openSDK_LOG.GameAppOperation", "-->joinGroup, appid is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1003, "appid is null", "appid is null, please login."));
                    return;
                }
                return;
            }
            String openId = this.f37136c.getOpenId();
            if (TextUtils.isEmpty(openId)) {
                SLog.m15129e("openSDK_LOG.GameAppOperation", "-->joinGroup, openid is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1004, "openid is null", "openid is null, please login."));
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("mqqapi://opensdk/join_group?src_type=app&version=1");
            stringBuffer.append("&openid=" + Base64.encodeToString(C13071m.m14919j(openId), 2));
            stringBuffer.append("&appid=" + Base64.encodeToString(C13071m.m14919j(appId), 2));
            stringBuffer.append("&organization_id=" + Base64.encodeToString(C13071m.m14919j(str), 2));
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(C13071m.m14919j(Constants.SDK_VERSION), 2));
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.setPackage("com.tencent.mobileqq");
            if (C13066k.m14983c(activity, "8.1.0") < 0) {
                SLog.m15121w("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
                m15247a(activity);
                return;
            }
            DefaultUiListener defaultUiListener = new DefaultUiListener() { // from class: com.tencent.open.SocialOperation.2
                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onCancel() {
                }

                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    SLog.m15121w("openSDK_LOG.GameAppOperation", "-->join group resp is: " + obj);
                    if (obj == null) {
                        IUiListener iUiListener2 = iUiListener;
                        if (iUiListener2 != null) {
                            iUiListener2.onError(new UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                        }
                    } else if (((JSONObject) obj).optInt("bind") == 1) {
                        try {
                            SocialOperation.this.m15317a(activity, (int) Constants.REQUEST_JOIN_GROUP, intent, false);
                        } catch (Exception e) {
                            SLog.m15128e("openSDK_LOG.GameAppOperation", "-->join group, start activity exception.", e);
                            SocialOperation.this.m15247a(activity);
                        }
                    } else {
                        IUiListener iUiListener3 = iUiListener;
                        if (iUiListener3 != null) {
                            iUiListener3.onError(new UiError(3003, "该组织未绑群，无法加入", "该组织未绑群，无法加入。"));
                        }
                    }
                }

                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    SLog.m15123v("openSDK_LOG.GameAppOperation", "-->joinQQGroup, error: " + uiError);
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onError(uiError);
                    }
                }
            };
            Bundle m15318a = m15318a();
            m15318a.putString("appid", appId);
            m15318a.putString("orgid", str);
            HttpUtils.requestAsync(this.f37136c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", m15318a, "GET", new BaseApi.TempRequestListener(defaultUiListener));
            SLog.m15127i("openSDK_LOG.GameAppOperation", "-->joinQQGroup() do.");
        }
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        SLog.m15127i("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- start");
        if (C12925a.m15471a("openSDK_LOG.GameAppOperation", null)) {
            return;
        }
        if (bundle == null) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->makeFriend params is null");
            C13014e.m15176a().m15174a(this.f37136c.getOpenId(), this.f37136c.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            return;
        }
        String string = bundle.getString(GAME_FRIEND_OPENID);
        if (TextUtils.isEmpty(string)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid is empty.");
            C13014e.m15176a().m15174a(this.f37136c.getOpenId(), this.f37136c.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            return;
        }
        String string2 = bundle.getString(GAME_FRIEND_LABEL);
        String string3 = bundle.getString(GAME_FRIEND_ADD_MESSAGE);
        String m14968a = C13071m.m14968a(activity);
        String openId = this.f37136c.getOpenId();
        String appId = this.f37136c.getAppId();
        SLog.m15123v("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid: " + string + " | label: " + string2 + " | message: " + string3 + " | openid: " + openId + " | appid:" + appId);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/add_friend?src_type=app&version=1");
        StringBuilder sb = new StringBuilder();
        sb.append("&fopen_id=");
        sb.append(Base64.encodeToString(C13071m.m14919j(string), 2));
        stringBuffer.append(sb.toString());
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(C13071m.m14919j(openId), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&app_id=" + appId);
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&friend_label=" + Base64.encodeToString(C13071m.m14919j(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&add_msg=" + Base64.encodeToString(C13071m.m14919j(string3), 2));
        }
        if (!TextUtils.isEmpty(m14968a)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(C13071m.m14919j(m14968a), 2));
        }
        SLog.m15123v("openSDK_LOG.GameAppOperation", "-->make friend, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (!C13071m.m14928f(activity, "5.1.0")) {
            SLog.m15127i("openSDK_LOG.GameAppOperation", "-->makeFriend target activity found, qqver greater than 5.1.0");
            try {
                activity.startActivity(intent);
                C13014e.m15176a().m15174a(this.f37136c.getOpenId(), this.f37136c.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "0");
            } catch (Exception e) {
                SLog.m15128e("openSDK_LOG.GameAppOperation", "-->make friend, start activity exception.", e);
                m15247a(activity);
                C13014e.m15176a().m15174a(this.f37136c.getOpenId(), this.f37136c.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            }
        } else {
            SLog.m15121w("openSDK_LOG.GameAppOperation", "-->make friend, there is no activity.");
            m15247a(activity);
            C13014e.m15176a().m15174a(this.f37136c.getOpenId(), this.f37136c.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
        }
        SLog.m15127i("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- end");
    }

    public void unBindGroup(Context context, String str, final IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.GameAppOperation", "unBindQQGroup()");
        if (C12925a.m15471a("openSDK_LOG.GameAppOperation", iUiListener)) {
            return;
        }
        if (context == null) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->uinBindGroup, activity is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1001, "param acitivty is null", "activity param of api can not be null."));
            }
        } else if (TextUtils.isEmpty(str)) {
            SLog.m15129e("openSDK_LOG.GameAppOperation", "-->unBindGroup, params is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(1006, "param organizationId is null", "organizationId param of api can not be null."));
            }
        } else {
            String appId = this.f37136c.getAppId();
            if (TextUtils.isEmpty(appId)) {
                SLog.m15129e("openSDK_LOG.GameAppOperation", "-->unBindGroup, appid is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1003, "param appId is null", "appid is null please login."));
                    return;
                }
                return;
            }
            DefaultUiListener defaultUiListener = new DefaultUiListener() { // from class: com.tencent.open.SocialOperation.1
                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onCancel() {
                }

                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    SLog.m15121w("openSDK_LOG.GameAppOperation", "-->unbind group resp is: " + obj);
                    if (obj == null) {
                        IUiListener iUiListener2 = iUiListener;
                        if (iUiListener2 != null) {
                            iUiListener2.onError(new UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject = (JSONObject) obj;
                    IUiListener iUiListener3 = iUiListener;
                    if (iUiListener3 != null) {
                        iUiListener3.onComplete(jSONObject);
                    }
                }

                @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    SLog.m15123v("openSDK_LOG.GameAppOperation", "-->unbindQQGroup, error: " + uiError);
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onError(uiError);
                    }
                }
            };
            Bundle m15318a = m15318a();
            m15318a.putString("appid", appId);
            m15318a.putString("orgid", str);
            HttpUtils.requestAsync(this.f37136c, context, "https://openmobile.qq.com/cgi-bin/qunopensdk/unbind", m15318a, "GET", new BaseApi.TempRequestListener(defaultUiListener));
            SLog.m15127i("openSDK_LOG.GameAppOperation", "-->unBindQQGroup() do.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15247a(Activity activity) {
        m15246a(activity, "");
    }

    /* renamed from: a */
    private void m15246a(Activity activity, String str) {
        new TDialog(activity, "", m15311a(str), null, this.f37136c).show();
    }
}
