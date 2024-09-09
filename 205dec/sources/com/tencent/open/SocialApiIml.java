package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: a  reason: collision with root package name */
    private Activity f51621a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProGuard */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends DefaultUiListener {

        /* renamed from: b  reason: collision with root package name */
        private IUiListener f51623b;

        /* renamed from: c  reason: collision with root package name */
        private String f51624c;

        /* renamed from: d  reason: collision with root package name */
        private String f51625d;

        /* renamed from: e  reason: collision with root package name */
        private Bundle f51626e;

        /* renamed from: f  reason: collision with root package name */
        private Activity f51627f;

        a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f51623b = iUiListener;
            this.f51624c = str;
            this.f51625d = str2;
            this.f51626e = bundle;
            this.f51627f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f51623b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString("encry_token");
            } catch (JSONException e4) {
                e4.printStackTrace();
                SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e4);
                str = null;
            }
            this.f51626e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.a((Context) socialApiIml.f51621a, this.f51624c, this.f51626e, this.f51625d, this.f51623b);
            if (TextUtils.isEmpty(str)) {
                SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f51627f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f51623b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, "action_ask", bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    protected Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.minihd.qq", str);
        if (m.c(g.a()) && k.a(g.a(), intent)) {
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        if (!k.a(g.a(), intent2) || k.c(g.a(), "4.7") < 0) {
            Intent intent3 = new Intent();
            intent3.setClassName("com.qzone", str);
            if (k.a(g.a(), intent3) && k.a(k.a(g.a(), "com.qzone"), "4.2") >= 0 && k.a(g.a(), intent3.getComponent().getPackageName(), "ec96e9ac1149251acbb1b0c5777cae95")) {
                return intent3;
            }
            return null;
        }
        return intent2;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, "action_gift", bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f51621a = activity;
        Intent c4 = c("com.tencent.open.agent.SocialFriendChooser");
        if (c4 == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c4 = c("com.tencent.open.agent.AppInvitationActivity");
        }
        bundle.putAll(b());
        a(activity, c4, "action_invite", bundle, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f51621a = activity;
        Intent c4 = c("com.tencent.open.agent.SendStoryActivity");
        bundle.putAll(b());
        a(activity, c4, "action_story", bundle, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.f51502c.getAccessToken();
        String appId = this.f51502c.getAppId();
        String openId = this.f51502c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = m.g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        com.tencent.open.web.a.a(bVar);
        String a4 = j.a().a(context, "https://imgcache.qq.com");
        bVar.loadDataWithBaseURL(a4, "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f51502c.getOpenId() + "_" + this.f51502c.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>", "text/html", "utf-8", a4);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f51621a = activity;
        Intent c4 = c("com.tencent.open.agent.SocialFriendChooser");
        if (c4 == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c4 = c("com.tencent.open.agent.RequestFreegiftActivity");
        }
        Intent intent = c4;
        bundle.putAll(b());
        if ("action_ask".equals(str)) {
            bundle.putString("type", "request");
        } else if ("action_gift".equals(str)) {
            bundle.putString("type", "freegift");
        }
        a(activity, intent, str, bundle, j.a().a(g.a(), "https://imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z4 = true;
        sb.append(intent == null);
        SLog.i("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        i a4 = i.a(g.a(), this.f51502c.getAppId());
        if (!z3 && !a4.b("C_LoginH5")) {
            z4 = false;
        }
        if (z4) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra("key_action", str);
        intent.putExtra("key_params", bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(11105, iUiListener);
        a(activity, intent, 11105);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent c4 = c();
        IUiListener aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent b4 = b("com.tencent.open.agent.EncryTokenActivity");
        if (b4 != null && c4 != null && c4.getComponent() != null && b4.getComponent() != null && c4.getComponent().getPackageName().equals(b4.getComponent().getPackageName())) {
            b4.putExtra("oauth_consumer_key", this.f51502c.getAppId());
            b4.putExtra("openid", this.f51502c.getOpenId());
            b4.putExtra("access_token", this.f51502c.getAccessToken());
            b4.putExtra("key_action", "action_check_token");
            SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
            UIListenerManager.getInstance().setListenerWithRequestcode(11106, aVar);
            a(activity, b4, 11106);
            return;
        }
        SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String g4 = m.g("tencent&sdk&qazxc***14969%%" + this.f51502c.getAccessToken() + this.f51502c.getAppId() + this.f51502c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("encry_token", g4);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f51502c.getAppId());
        if (this.f51502c.isSessionValid()) {
            bundle.putString("access_token", this.f51502c.getAccessToken());
        }
        String openId = this.f51502c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", g.a().getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
        } catch (Exception e4) {
            e4.printStackTrace();
            bundle.putString("pf", "openmobile_android");
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!"action_challenge".equals(str) && !"action_brag".equals(str)) {
            new TDialog(this.f51621a, str, str3, iUiListener, this.f51502c).show();
            return;
        }
        SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
        new d(this.f51621a, str, str3, iUiListener, this.f51502c).show();
    }
}
