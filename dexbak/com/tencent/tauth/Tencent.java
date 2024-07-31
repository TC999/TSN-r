package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.internal.C2606av;
import com.stub.StubApp;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.C12949c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.p565a.C13003f;
import com.tencent.open.p566b.C13010b;
import com.tencent.open.p568im.C13035IM;
import com.tencent.open.utils.C13058f;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13063i;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR;

    /* renamed from: c */
    private static Tencent f37466c;

    /* renamed from: d */
    private static boolean f37467d;

    /* renamed from: a */
    private final C12949c f37468a;

    /* renamed from: b */
    private String f37469b;

    private Tencent(String str, Context context) {
        this.f37468a = C12949c.m15380a(str, context);
        C13010b.m15193a().m15189a(str, context);
        C13058f.m15034a().m15033a(context);
    }

    /* renamed from: a */
    private static boolean m14897a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            SLog.m15129e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        } catch (Throwable th) {
            SLog.m15128e("openSDK_LOG.Tencent", "checkManifestConfig exception", th);
        }
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.m15129e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
            return false;
        } catch (Throwable th2) {
            SLog.m15128e("openSDK_LOG.Tencent", "checkManifestConfig exception", th2);
            return true;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            createInstance = createInstance(str, context);
            SLog.m15127i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
            m14895a("createInstance_authority", "appid", str, "authorities", str2);
            if (createInstance != null) {
                createInstance.f37469b = str2;
            } else {
                SLog.m15127i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
            }
        }
        return createInstance;
    }

    public static synchronized String getAuthorities(String str) {
        synchronized (Tencent.class) {
            m14895a("getAuthorities", "appid", str);
            if (TextUtils.isEmpty(str)) {
                SLog.m15127i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            Tencent tencent = f37466c;
            if (tencent == null) {
                SLog.m15127i("openSDK_LOG.Tencent", "sInstance == null");
                return null;
            }
            return str.equals(tencent.getAppId()) ? f37466c.f37469b : "";
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.m15127i("openSDK_LOG.Tencent", sb.toString());
        m14895a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isPermissionNotGranted() {
        return !f37467d || TextUtils.isEmpty(C13058f.m15034a().m15031b());
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z = C13066k.m14983c(context, "5.9.5") >= 0;
        SLog.m15127i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        m14896a("isSupportPushToQZone", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.m15127i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (C13071m.m14939c(context) && C13066k.m14996a(context, Constants.PACKAGE_QQ_PAD) != null) {
            m14896a("isSupportShareToQQ", Boolean.TRUE);
            return true;
        }
        if (C13066k.m14983c(context, "4.1") < 0 && C13066k.m14996a(context, Constants.PACKAGE_TIM) == null) {
            z = false;
        }
        SLog.m15127i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        m14896a("isSupportShareToQQ", Boolean.valueOf(z));
        return z;
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.m15127i("openSDK_LOG.Tencent", sb.toString());
        m14895a("onActivityResultData", "requestCode", Integer.valueOf(i), "resultCode", Integer.valueOf(i2));
        return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        String stringExtra;
        m14895a("parseMiniParameters", new Object[0]);
        HashMap hashMap = new HashMap();
        if (intent == null) {
            SLog.m15129e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SLog.m15131d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        }
        Uri data = intent.getData();
        if (data == null) {
            SLog.m15131d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return hashMap;
        }
        String uri = data.toString();
        if (TextUtils.isEmpty(uri)) {
            SLog.m15131d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return hashMap;
        }
        String substring = uri.substring(uri.lastIndexOf(63) + 1);
        if (TextUtils.isEmpty(substring)) {
            SLog.m15131d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return hashMap;
        }
        SLog.m15131d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
        for (String str : substring.split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static void resetQQAppInfoCache() {
        C13066k.m14993a("com.tencent.mobileqq");
    }

    public static void resetTargetAppInfoCache() {
        C13066k.m15002a();
    }

    public static void resetTimAppInfoCache() {
        C13066k.m14993a(Constants.PACKAGE_TIM);
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.m15127i("openSDK_LOG.Tencent", "setCustomLogger");
        m14895a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(tracer);
    }

    public static void setIsPermissionGranted(boolean z) {
        String str;
        SLog.m15127i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z);
        if (z) {
            C13058f.m15034a().m15033a(C13061g.m15027a());
            str = C13058f.m15034a().m15031b();
            if (str == null || str.isEmpty()) {
                str = Build.MODEL;
            }
        } else {
            str = "";
        }
        setIsPermissionGranted(z, str);
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "bindQQGroup()");
        m14895a("bindQQGroup", "organizationId", str, "organizationName", str2);
        new SocialOperation(getQQToken()).bindQQGroup(activity, str, str2, iUiListener);
    }

    public void callCommonChannelApi(Activity activity, Bundle bundle, IUiListener iUiListener) {
        C12949c c12949c = this.f37468a;
        int launchQQ = new CommonChannelApi(c12949c, c12949c.m15378b()).launchQQ(activity, bundle, iUiListener);
        SLog.m15127i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + launchQQ);
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "checkLogin()");
        m14895a("checkLogin", new Object[0]);
        this.f37468a.m15381a(iUiListener);
    }

    public String getAccessToken() {
        String accessToken = this.f37468a.m15378b().getAccessToken();
        SLog.m15127i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        m14895a("getAccessToken", new Object[0]);
        return accessToken;
    }

    public String getAppId() {
        String appId = this.f37468a.m15378b().getAppId();
        SLog.m15127i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        m14896a("getAppId", appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f37468a.m15378b().getExpireTimeInSecond();
        SLog.m15127i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        m14896a("getExpiresIn", Long.valueOf(expireTimeInSecond));
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f37468a.m15378b().getOpenId();
        SLog.m15127i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        m14895a("getOpenId", new Object[0]);
        return openId;
    }

    public QQToken getQQToken() {
        SLog.m15127i("openSDK_LOG.Tencent", "getQQToken()");
        m14895a("getQQToken", new Object[0]);
        return this.f37468a.m15378b();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.m15127i("openSDK_LOG.Tencent", sb.toString());
        m14895a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) {
        m14895a("initSessionCache", new Object[0]);
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.m15127i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e) {
            SLog.m15127i("QQToken", "initSessionCache " + e.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean m14989b = C13066k.m14989b(context);
        SLog.m15127i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + m14989b);
        m14896a("isQQInstalled", Boolean.valueOf(m14989b));
        return m14989b;
    }

    public boolean isReady() {
        boolean z = isSessionValid() && getOpenId() != null;
        SLog.m15127i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        m14896a("isReady", Boolean.valueOf(z));
        return z;
    }

    public boolean isSessionValid() {
        boolean m15375c = this.f37468a.m15375c();
        SLog.m15127i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + m15375c);
        m14896a("isSessionValid", Boolean.valueOf(m15375c));
        return m15375c;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.m15127i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (C13071m.m14939c(activity) && C13066k.m14996a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            m14896a("isSupportSSOLogin", Boolean.TRUE);
            return true;
        }
        if (C13066k.m14983c(activity, "4.1") < 0 && C13066k.m14981d(activity, "1.1") < 0) {
            z = false;
        }
        SLog.m15127i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        m14896a("isSupportSSOLogin", Boolean.valueOf(z));
        return z;
    }

    public void joinQQGroup(Activity activity, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "joinQQGroup()");
        m14895a("joinQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).joinGroup(activity, str, iUiListener);
    }

    public JSONObject loadSession(String str) {
        JSONObject loadSession = this.f37468a.m15378b().loadSession(str);
        StringBuilder sb = new StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(loadSession != null ? loadSession.length() : 0);
        SLog.m15127i("openSDK_LOG.Tencent", sb.toString());
        m14895a("loadSession", "appid", str);
        return loadSession;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        m14895a("login_scope", Constants.PARAM_SCOPE, str);
        return this.f37468a.m15388a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        m14895a("loginServerSide_activity", Constants.PARAM_SCOPE, str);
        C12949c c12949c = this.f37468a;
        return c12949c.m15388a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.m15127i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        m14895a("loginWithOEM", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z), "registerChannel", str2, "installChannel", str3, "businessId", str4);
        return this.f37468a.m15385a(activity, str, iUiListener, z, str2, str3, str4);
    }

    public void logout(Context context) {
        SLog.m15127i("openSDK_LOG.Tencent", "logout()");
        m14895a(C2606av.f8628b, new Object[0]);
        this.f37468a.m15378b().setAccessToken(null, "0");
        this.f37468a.m15378b().setOpenId(null);
        this.f37468a.m15378b().removeSession(this.f37468a.m15378b().getAppId());
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "publishToQzone()");
        m14895a("publishToQzone", new Object[0]);
        new QzonePublish(activity, this.f37468a.m15378b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        m14895a("reAuth", Constants.PARAM_SCOPE, str);
        return this.f37468a.m15377b(activity, str, iUiListener);
    }

    public void reportDAU() {
        SLog.m15127i("openSDK_LOG.Tencent", "reportDAU() ");
        m14895a("reportDAU", new Object[0]);
        this.f37468a.m15393a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.m15127i("openSDK_LOG.Tencent", "request()");
        m14895a("request", "graphPath", str, "httpMethod", str2);
        return HttpUtils.request(this.f37468a.m15378b(), C13061g.m15027a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "requestAsync()");
        m14895a("requestAsync", "graphPath", str, "httpMethod", str2);
        HttpUtils.requestAsync(this.f37468a.m15378b(), C13061g.m15027a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.m15127i("openSDK_LOG.Tencent", sb.toString());
        m14895a("saveSession", new Object[0]);
        this.f37468a.m15378b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        SLog.m15127i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        m14895a("setAccessToken", new Object[0]);
        this.f37468a.m15379a(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "setAvatar()");
        m14895a("setAvatar", new Object[0]);
        String string = bundle.getString("picture");
        new QQAvatar(this.f37468a.m15378b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        m14895a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f37468a.m15378b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        m14895a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f37468a.m15378b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "saveQQEmotions()");
        m14895a("setEmotions", new Object[0]);
        new QQEmotion(this.f37468a.m15378b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(String str) {
        SLog.m15127i("openSDK_LOG.Tencent", "setOpenId() --start");
        m14895a("setOpenId", new Object[0]);
        this.f37468a.m15376b(C13061g.m15027a(), str);
        SLog.m15127i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "shareToQQ()");
        m14895a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.f37469b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f37468a.m15378b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "shareToQzone()");
        m14895a("shareToQzone", new Object[0]);
        new QzoneShare(activity, this.f37468a.m15378b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void startAuthManagePage(Activity activity, IApiCallback iApiCallback) {
        SLog.m15127i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f37468a, getQQToken()).gotoManagePage(activity, iApiCallback);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.m15127i("openSDK_LOG.Tencent", "startIMAio()");
        m14895a("startIMAio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, C13035IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.m15127i("openSDK_LOG.Tencent", "startIMAudio()");
        m14895a("startIMAudio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, C13035IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        m14895a("startIMConversation", "chatType", str, "uin", str2, Constants.PARAM_PKG_NAME, str3);
        return new C13035IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.m15127i("openSDK_LOG.Tencent", "startIMVideo()");
        m14895a("startIMVideo", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, C13035IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.m15127i("openSDK_LOG.Tencent", "startMiniApp()");
        m14895a("startMiniApp", "miniAppId", str, "miniAppPath", str2, "miniAppVersion", str3);
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public void unBindQQGroup(Context context, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "unBindQQGroup()");
        m14895a("unBindQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).unBindGroup(context, str, iUiListener);
    }

    public boolean isQQInstalled(Context context, String str) {
        boolean z = C13066k.m14983c(context, str) >= 0;
        SLog.m15127i("openSDK_LOG.Tencent", "isQQInstalled version[" + str + "] = " + z);
        return z;
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.m15127i("openSDK_LOG.Tencent", "login activity with params");
        m14895a("login_param", new Object[0]);
        return this.f37468a.m15389a(activity, iUiListener, map);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        m14895a("loginServerSide_fragment", Constants.PARAM_SCOPE, str);
        C12949c c12949c = this.f37468a;
        return c12949c.m15383a(fragment, str + ",server_side", iUiListener, "");
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            C13061g.m15026a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            SLog.m15127i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                SLog.m15129e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            Tencent tencent = f37466c;
            if (tencent == null) {
                f37466c = new Tencent(str, context);
            } else if (!str.equals(tencent.getAppId())) {
                f37466c.logout(context);
                f37466c = new Tencent(str, context);
            }
            if (m14897a(context, str)) {
                m14895a("createInstance", "appid", str);
                C13003f.m15216a().m15214a(C13063i.m15015a(context, str));
                SLog.m15127i("openSDK_LOG.Tencent", "createInstance()  -- end");
                return f37466c;
            }
            return null;
        }
    }

    public static void setIsPermissionGranted(boolean z, String str) {
        SLog.m15127i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z + ", model = " + str);
        if (z) {
            if (str == null || str.trim().isEmpty()) {
                SLog.m15129e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + str + "]");
                z = false;
            }
            f37467d = z;
            C13058f.m15034a().m15032a(C13061g.m15027a(), str);
        }
        str = null;
        f37467d = z;
        C13058f.m15034a().m15032a(C13061g.m15027a(), str);
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.m15127i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        m14895a("login_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z));
        return this.f37468a.m15386a(activity, str, iUiListener, z);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i, int i2) {
        SLog.m15127i("openSDK_LOG.Tencent", "setAvatar()");
        m14895a("setAvatar_anim", new Object[0]);
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        m14895a("login_fragment_scope", Constants.PARAM_SCOPE, str);
        return this.f37468a.m15383a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z) {
        SLog.m15127i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        m14895a("login_fragment_scope_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z));
        return this.f37468a.m15382a(fragment, str, iUiListener, "", z);
    }

    /* renamed from: a */
    private static void m14895a(String str, Object... objArr) {
        C13010b.m15193a().m15187a(str, m14894a(objArr));
    }

    /* renamed from: a */
    private static String m14894a(Object... objArr) {
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i += 2) {
            if (i > 0) {
                sb.append('|');
            }
            sb.append(objArr[i]);
            sb.append(':');
            sb.append(objArr[i + 1]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m14896a(String str, Object obj) {
        C13010b.m15193a().m15188a(str, obj);
    }
}
