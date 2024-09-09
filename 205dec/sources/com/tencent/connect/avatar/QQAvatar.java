package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QQAvatar extends BaseApi {
    public static final String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";

    /* renamed from: a  reason: collision with root package name */
    private IUiListener f51471a;

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    private Intent a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i4) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f51471a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f51471a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i4);
        bundle.putString("appid", this.f51502c.getAppId());
        bundle.putString("access_token", this.f51502c.getAccessToken());
        bundle.putLong("expires_in", this.f51502c.getExpireTimeInSecond());
        bundle.putString("openid", this.f51502c.getOpenId());
        Intent a4 = a(activity);
        Bundle a5 = m.a(this.f51502c.getOpenId(), "ANDROIDSDK.SETAVATAR.XX", "12", "18", this.f51502c.getAppId());
        a4.putExtra(Constants.KEY_PASS_REPORT_VIA_TIMELY, true);
        a4.putExtra(Constants.KEY_PASS_REPORT_VIA_PARAM, a5);
        a(activity, bundle, a4);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f51471a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f51471a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u5f53\u524d\u624b\u673a\u672a\u5b89\u88c5QQ\uff0c\u8bf7\u5b89\u88c5\u6700\u65b0\u7248QQ\u540e\u518d\u8bd5\u3002", 1).show();
        } else if (k.c(activity, "8.0.0") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u5f53\u524d\u624b\u673aQQ\u7248\u672c\u8fc7\u4f4e\uff0c\u4e0d\u652f\u6301\u8bbe\u7f6e\u5934\u50cf\u529f\u80fd\u3002", 1).show();
        } else {
            String a4 = m.a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
            if (!TextUtils.isEmpty(a4)) {
                if (a4.length() > 20) {
                    a4 = a4.substring(0, 20) + "...";
                }
                stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a4), 2));
            }
            String appId = this.f51502c.getAppId();
            String openId = this.f51502c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
            }
            String b4 = m.b(activity, uri);
            if (!TextUtils.isEmpty(b4)) {
                try {
                    activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                    stringBuffer.append("&set_uri=" + Base64.encodeToString(m.j(uri.toString()), 2));
                } catch (Exception e4) {
                    SLog.e("QQAvatar", "Exception", e4);
                }
            }
            if (!TextUtils.isEmpty(b4)) {
                stringBuffer.append("&set_path=" + Base64.encodeToString(m.j(b4), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j("3.5.13.lite"), 2));
            SLog.v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
            intent.putExtra("pkg_name", activity.getPackageName());
            intent.setData(Uri.parse(stringBuffer.toString()));
            UIListenerManager.getInstance().setListenerWithRequestcode(10108, iUiListener);
            a(activity, 10108, intent, false);
        }
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f51471a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f51471a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u5f53\u524d\u624b\u673a\u672a\u5b89\u88c5QQ\uff0c\u8bf7\u5b89\u88c5\u6700\u65b0\u7248QQ\u540e\u518d\u8bd5\u3002", 1).show();
        } else if (k.c(activity, "8.0.5") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "\u5f53\u524d\u624b\u673aQQ\u7248\u672c\u8fc7\u4f4e\uff0c\u4e0d\u652f\u6301\u8bbe\u7f6e\u5934\u50cf\u529f\u80fd\u3002", 1).show();
        } else {
            String a4 = m.a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
            if (!TextUtils.isEmpty(a4)) {
                if (a4.length() > 20) {
                    a4 = a4.substring(0, 20) + "...";
                }
                stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a4), 2));
            }
            String appId = this.f51502c.getAppId();
            String openId = this.f51502c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
            }
            String b4 = m.b(activity, uri);
            if (!TextUtils.isEmpty(b4)) {
                try {
                    activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                    stringBuffer.append("&video_uri=");
                    stringBuffer.append(Base64.encodeToString(m.j(uri.toString()), 2));
                } catch (Exception e4) {
                    SLog.e("QQAvatar", "Exception", e4);
                }
            }
            if (!TextUtils.isEmpty(b4)) {
                stringBuffer.append("&video_path=" + Base64.encodeToString(m.j(b4), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j("3.5.13.lite"), 2));
            SLog.v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.tencent.mobileqq");
            intent.putExtra("FROM_WHERE", "FROM_SDK_AVATAR_SET_IMAGE");
            intent.putExtra("pkg_name", activity.getPackageName());
            intent.setData(Uri.parse(stringBuffer.toString()));
            UIListenerManager.getInstance().setListenerWithRequestcode(10110, iUiListener);
            a(activity, 10110, intent, false);
        }
    }

    private void a(Activity activity, Bundle bundle, Intent intent) {
        a(bundle);
        intent.putExtra("key_action", "action_avatar");
        intent.putExtra("key_params", bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(11102, this.f51471a);
        a(activity, intent, 11102);
    }

    private void a(Bundle bundle) {
        QQToken qQToken = this.f51502c;
        if (qQToken != null) {
            bundle.putString("appid", qQToken.getAppId());
            if (this.f51502c.isSessionValid()) {
                bundle.putString("keystr", this.f51502c.getAccessToken());
                bundle.putString("keytype", "0x80");
            }
            String openId = this.f51502c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString("platform", "androidqz");
            try {
                bundle.putString("pf", g.a().getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
            } catch (Exception e4) {
                e4.printStackTrace();
                bundle.putString("pf", "openmobile_android");
            }
        }
        bundle.putString("sdkv", "3.5.13.lite");
        bundle.putString("sdkp", "a");
    }
}
