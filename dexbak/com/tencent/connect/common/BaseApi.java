package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;
import com.tencent.connect.auth.C12949c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C13058f;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;

    /* renamed from: b */
    protected C12949c f37135b;

    /* renamed from: c */
    protected QQToken f37136c;

    /* compiled from: ProGuard */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class TempRequestListener implements IRequestListener {

        /* renamed from: b */
        private final IUiListener f37138b;

        /* renamed from: c */
        private final Handler f37139c;

        public TempRequestListener(IUiListener iUiListener) {
            this.f37138b = iUiListener;
            this.f37139c = new Handler(C13061g.m15027a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.f37138b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.f37138b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.f37139c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.f37139c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.f37139c.sendMessage(obtainMessage);
        }
    }

    public BaseApi(C12949c c12949c, QQToken qQToken) {
        this.f37135b = c12949c;
        this.f37136c = qQToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Bundle m15318a() {
        Bundle bundle = new Bundle();
        bundle.putString(IjkMediaMeta.IJKM_KEY_FORMAT, "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", C13058f.m15034a().m15029c(C13061g.m15027a()));
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.f37136c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.f37136c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.f37136c.getAppId());
            bundle.putString("openid", this.f37136c.getOpenId());
        }
        SharedPreferences sharedPreferences = C13061g.m15027a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + FaceEnvironment.f8430OS + "-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Bundle m15308b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f37136c.getAppId());
        if (this.f37136c.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.f37136c.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.f37136c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
        SharedPreferences sharedPreferences = C13061g.m15027a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + FaceEnvironment.f8430OS + "-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public Intent m15307c() {
        Intent intent = new Intent();
        if (C13071m.m14939c(C13061g.m15027a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, "com.tencent.open.agent.AgentActivity");
            if (C13066k.m14988b(C13061g.m15027a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
        if (C13066k.m14988b(C13061g.m15027a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, "com.tencent.open.agent.AgentActivity");
        if (C13066k.m14988b(C13061g.m15027a(), intent)) {
            return intent;
        }
        return null;
    }

    public void releaseResource() {
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public Intent m15306c(String str) {
        Intent intent = new Intent();
        Intent mo15248b = mo15248b(str);
        if (mo15248b == null || mo15248b.getComponent() == null) {
            return null;
        }
        intent.setClassName(mo15248b.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String m15311a(String str) {
        Bundle m15318a = m15318a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            m15318a.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(m15318a));
        return sb.toString();
    }

    /* renamed from: b */
    protected Intent mo15248b(String str) {
        Intent intent = new Intent();
        if (C13071m.m14939c(C13061g.m15027a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (C13066k.m14997a(C13061g.m15027a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (C13066k.m14997a(C13061g.m15027a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, str);
        if (C13066k.m14997a(C13061g.m15027a(), intent)) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15310a(StringBuilder sb, Activity activity) {
        if (sb.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        sb.append("=");
        sb.append(Constants.JumpUrlConstants.SRC_TYPE_APP);
        String appId = this.f37136c.getAppId();
        String openId = this.f37136c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            m15309a(sb, "app_id", appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            m15309a(sb, Constants.JumpUrlConstants.URL_KEY_OPENID, C13071m.m14918k(openId));
        }
        String m14968a = C13071m.m14968a(activity);
        if (!TextUtils.isEmpty(m14968a)) {
            if (m14968a.length() > 20) {
                m14968a = m14968a.substring(0, 20) + "...";
            }
            m15309a(sb, "app_name", C13071m.m14918k(m14968a));
        }
        m15309a(sb, "sdk_version", C13071m.m14918k(Constants.SDK_VERSION));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15309a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(C13071m.m14927f(str2));
    }

    /* renamed from: a */
    private Intent m15314a(Activity activity, Intent intent, Map<String, Object> map) {
        Intent intent2 = new Intent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.BaseApi", "Exception", e);
        }
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15317a(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        try {
            activity.startActivityForResult(intent2, i);
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.BaseApi", "startAssistActivity exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15316a(Activity activity, Intent intent, int i) {
        m15315a(activity, intent, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15315a(Activity activity, Intent intent, int i, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i);
        try {
            activity.startActivityForResult(m15314a(activity, intent, map), i);
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.BaseApi", "startAssitActivity exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15312a(Fragment fragment, Intent intent, int i, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i);
        try {
            fragment.startActivityForResult(m15314a(fragment.getActivity(), intent, map), i);
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.BaseApi", "startAssitActivity exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m15313a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f37136c).show();
    }
}
