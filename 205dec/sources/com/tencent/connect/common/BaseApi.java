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
import com.stub.StubApp;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;

    /* renamed from: b  reason: collision with root package name */
    protected c f51501b;

    /* renamed from: c  reason: collision with root package name */
    protected QQToken f51502c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class TempRequestListener implements IRequestListener {

        /* renamed from: b  reason: collision with root package name */
        private final IUiListener f51504b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f51505c;

        public TempRequestListener(IUiListener iUiListener) {
            this.f51504b = iUiListener;
            this.f51505c = new Handler(g.a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.f51504b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.f51504b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.f51505c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.f51505c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.f51505c.sendMessage(obtainMessage);
        }
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.f51501b = cVar;
        this.f51502c = qQToken;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", f.a().c(g.a()));
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", "3.5.13.lite");
        bundle.putString("sdkp", "a");
        QQToken qQToken = this.f51502c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.f51502c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.f51502c.getAppId());
            bundle.putString("openid", this.f51502c.getOpenId());
        }
        SharedPreferences sharedPreferences = g.a().getSharedPreferences("pfStore", 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f51502c.getAppId());
        if (this.f51502c.isSessionValid()) {
            bundle.putString("keystr", this.f51502c.getAccessToken());
            bundle.putString("keytype", "0x80");
        }
        String openId = this.f51502c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = g.a().getSharedPreferences("pfStore", 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", "openmobile_android"));
            bundle.putString("pf", "openmobile_android");
        }
        bundle.putString("sdkv", "3.5.13.lite");
        bundle.putString("sdkp", "a");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent c() {
        Intent intent = new Intent();
        if (m.c(g.a())) {
            intent.setClassName("com.tencent.minihd.qq", "com.tencent.open.agent.AgentActivity");
            if (k.b(g.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
        if (k.b(g.a(), intent)) {
            return intent;
        }
        intent.setClassName("com.tencent.tim", "com.tencent.open.agent.AgentActivity");
        if (k.b(g.a(), intent)) {
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
    public Intent c(String str) {
        Intent intent = new Intent();
        Intent b4 = b(str);
        if (b4 == null || b4.getComponent() == null) {
            return null;
        }
        intent.setClassName(b4.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        Bundle a4 = a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            a4.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(a4));
        return sb.toString();
    }

    protected Intent b(String str) {
        Intent intent = new Intent();
        if (m.c(g.a())) {
            intent.setClassName("com.tencent.minihd.qq", str);
            if (k.a(g.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (k.a(g.a(), intent)) {
            return intent;
        }
        intent.setClassName("com.tencent.tim", str);
        if (k.a(g.a(), intent)) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(StringBuilder sb, Activity activity) {
        if (sb.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append("src_type");
        sb.append("=");
        sb.append("app");
        String appId = this.f51502c.getAppId();
        String openId = this.f51502c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            a(sb, "app_id", appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            a(sb, "open_id", m.k(openId));
        }
        String a4 = m.a(activity);
        if (!TextUtils.isEmpty(a4)) {
            if (a4.length() > 20) {
                a4 = a4.substring(0, 20) + "...";
            }
            a(sb, "app_name", m.k(a4));
        }
        a(sb, "sdk_version", m.k("3.5.13.lite"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(m.f(str2));
    }

    private Intent a(Activity activity, Intent intent, Map<String, Object> map) {
        Intent intent2 = new Intent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.BaseApi", "Exception", e4);
        }
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, int i4, Intent intent, boolean z3) {
        Intent intent2 = new Intent(StubApp.getOrigApplicationContext(activity.getApplicationContext()), AssistActivity.class);
        if (z3) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        try {
            activity.startActivityForResult(intent2, i4);
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.BaseApi", "startAssistActivity exception", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Intent intent, int i4) {
        a(activity, intent, i4, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Intent intent, int i4, Map<String, Object> map) {
        intent.putExtra("key_request_code", i4);
        try {
            activity.startActivityForResult(a(activity, intent, map), i4);
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Fragment fragment, Intent intent, int i4, Map<String, Object> map) {
        intent.putExtra("key_request_code", i4);
        try {
            fragment.startActivityForResult(a(fragment.getActivity(), intent, map), i4);
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.BaseApi", "startAssitActivity exception", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f51502c).show();
    }
}
