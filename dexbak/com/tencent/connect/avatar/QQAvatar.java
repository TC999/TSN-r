package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.C12925a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.tauth.IUiListener;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QQAvatar extends BaseApi {
    public static final String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";

    /* renamed from: a */
    private IUiListener f37105a;

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    /* renamed from: a */
    private Intent m15334a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i) {
        if (C12925a.m15471a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f37105a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f37105a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", this.f37136c.getAppId());
        bundle.putString("access_token", this.f37136c.getAccessToken());
        bundle.putLong("expires_in", this.f37136c.getExpireTimeInSecond());
        bundle.putString("openid", this.f37136c.getOpenId());
        Intent m15334a = m15334a(activity);
        Bundle m14954a = C13071m.m14954a(this.f37136c.getOpenId(), Constants.VIA_SET_AVATAR, Constants.VIA_REPORT_TYPE_SET_AVATAR, "18", this.f37136c.getAppId());
        m15334a.putExtra(Constants.KEY_PASS_REPORT_VIA_TIMELY, true);
        m15334a.putExtra(Constants.KEY_PASS_REPORT_VIA_PARAM, m14954a);
        m15333a(activity, bundle, m15334a);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        if (C12925a.m15471a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f37105a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f37105a = iUiListener;
        if (!C13066k.m14989b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
        } else if (C13066k.m14983c(activity, "8.0.0") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
        } else {
            String m14968a = C13071m.m14968a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
            if (!TextUtils.isEmpty(m14968a)) {
                if (m14968a.length() > 20) {
                    m14968a = m14968a.substring(0, 20) + "...";
                }
                stringBuffer.append("&app_name=" + Base64.encodeToString(C13071m.m14919j(m14968a), 2));
            }
            String appId = this.f37136c.getAppId();
            String openId = this.f37136c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(C13071m.m14919j(openId), 2));
            }
            String m14944b = C13071m.m14944b(activity, uri);
            if (!TextUtils.isEmpty(m14944b)) {
                try {
                    activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                    stringBuffer.append("&set_uri=" + Base64.encodeToString(C13071m.m14919j(uri.toString()), 2));
                } catch (Exception e) {
                    SLog.m15128e("QQAvatar", "Exception", e);
                }
            }
            if (!TextUtils.isEmpty(m14944b)) {
                stringBuffer.append("&set_path=" + Base64.encodeToString(C13071m.m14919j(m14944b), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(C13071m.m14919j(Constants.SDK_VERSION), 2));
            SLog.m15123v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
            intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
            intent.setData(Uri.parse(stringBuffer.toString()));
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_AVATAR, iUiListener);
            m15317a(activity, Constants.REQUEST_EDIT_AVATAR, intent, false);
        }
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        if (C12925a.m15471a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f37105a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f37105a = iUiListener;
        if (!C13066k.m14989b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
        } else if (C13066k.m14983c(activity, "8.0.5") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
        } else {
            String m14968a = C13071m.m14968a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
            if (!TextUtils.isEmpty(m14968a)) {
                if (m14968a.length() > 20) {
                    m14968a = m14968a.substring(0, 20) + "...";
                }
                stringBuffer.append("&app_name=" + Base64.encodeToString(C13071m.m14919j(m14968a), 2));
            }
            String appId = this.f37136c.getAppId();
            String openId = this.f37136c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(C13071m.m14919j(openId), 2));
            }
            String m14944b = C13071m.m14944b(activity, uri);
            if (!TextUtils.isEmpty(m14944b)) {
                try {
                    activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                    stringBuffer.append("&video_uri=");
                    stringBuffer.append(Base64.encodeToString(C13071m.m14919j(uri.toString()), 2));
                } catch (Exception e) {
                    SLog.m15128e("QQAvatar", "Exception", e);
                }
            }
            if (!TextUtils.isEmpty(m14944b)) {
                stringBuffer.append("&video_path=" + Base64.encodeToString(C13071m.m14919j(m14944b), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(C13071m.m14919j(Constants.SDK_VERSION), 2));
            SLog.m15123v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
            intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
            intent.setData(Uri.parse(stringBuffer.toString()));
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_DYNAMIC_AVATAR, iUiListener);
            m15317a(activity, Constants.REQUEST_EDIT_DYNAMIC_AVATAR, intent, false);
        }
    }

    /* renamed from: a */
    private void m15333a(Activity activity, Bundle bundle, Intent intent) {
        m15332a(bundle);
        intent.putExtra(Constants.KEY_ACTION, "action_avatar");
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_AVATER, this.f37105a);
        m15316a(activity, intent, Constants.REQUEST_AVATER);
    }

    /* renamed from: a */
    private void m15332a(Bundle bundle) {
        QQToken qQToken = this.f37136c;
        if (qQToken != null) {
            bundle.putString("appid", qQToken.getAppId());
            if (this.f37136c.isSessionValid()) {
                bundle.putString(Constants.PARAM_KEY_STR, this.f37136c.getAccessToken());
                bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
            }
            String openId = this.f37136c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
            try {
                bundle.putString("pf", C13061g.m15027a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
            } catch (Exception e) {
                e.printStackTrace();
                bundle.putString("pf", Constants.DEFAULT_PF);
            }
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
    }
}
