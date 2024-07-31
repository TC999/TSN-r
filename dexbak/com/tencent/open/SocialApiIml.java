package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.C12949c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.p567c.C13026b;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13063i;
import com.tencent.open.utils.C13065j;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.C13074a;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SocialApiIml extends BaseApi {

    /* renamed from: a */
    private Activity f37221a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.SocialApiIml$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12990a extends DefaultUiListener {

        /* renamed from: b */
        private IUiListener f37223b;

        /* renamed from: c */
        private String f37224c;

        /* renamed from: d */
        private String f37225d;

        /* renamed from: e */
        private Bundle f37226e;

        /* renamed from: f */
        private Activity f37227f;

        C12990a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.f37223b = iUiListener;
            this.f37224c = str;
            this.f37225d = str2;
            this.f37226e = bundle;
            this.f37227f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.f37223b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            try {
                str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e) {
                e.printStackTrace();
                SLog.m15128e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e);
                str = null;
            }
            this.f37226e.putString("encrytoken", str);
            SocialApiIml socialApiIml = SocialApiIml.this;
            socialApiIml.m15251a((Context) socialApiIml.f37221a, this.f37224c, this.f37226e, this.f37225d, this.f37223b);
            if (TextUtils.isEmpty(str)) {
                SLog.m15131d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f37227f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.m15131d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
            this.f37223b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        m15253a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    /* renamed from: b */
    protected Intent mo15248b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (C13071m.m14939c(C13061g.m15027a()) && C13066k.m14997a(C13061g.m15027a(), intent)) {
            return intent;
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        if (!C13066k.m14997a(C13061g.m15027a(), intent2) || C13066k.m14983c(C13061g.m15027a(), "4.7") < 0) {
            Intent intent3 = new Intent();
            intent3.setClassName(Constants.PACKAGE_QZONE, str);
            if (C13066k.m14997a(C13061g.m15027a(), intent3) && C13066k.m14992a(C13066k.m14996a(C13061g.m15027a(), Constants.PACKAGE_QZONE), "4.2") >= 0 && C13066k.m14995a(C13061g.m15027a(), intent3.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
                return intent3;
            }
            return null;
        }
        return intent2;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        m15253a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f37221a = activity;
        Intent m15306c = m15306c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (m15306c == null) {
            SLog.m15127i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            m15306c = m15306c(SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(m15308b());
        m15254a(activity, m15306c, SocialConstants.ACTION_INVITE, bundle, C13065j.m15004a().m15003a(C13061g.m15027a(), "https://imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.f37221a = activity;
        Intent m15306c = m15306c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(m15308b());
        m15254a(activity, m15306c, SocialConstants.ACTION_STORY, bundle, C13065j.m15004a().m15003a(C13061g.m15027a(), "https://imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str;
        String accessToken = this.f37136c.getAccessToken();
        String appId = this.f37136c.getAppId();
        String openId = this.f37136c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            str = C13071m.m14924g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        C13026b c13026b = new C13026b(context);
        WebSettings settings = c13026b.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        C13074a.m14910a(c13026b);
        String m15003a = C13065j.m15004a().m15003a(context, "https://imgcache.qq.com");
        c13026b.loadDataWithBaseURL(m15003a, "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f37136c.getOpenId() + "_" + this.f37136c.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>", "text/html", "utf-8", m15003a);
    }

    public SocialApiIml(C12949c c12949c, QQToken qQToken) {
        super(c12949c, qQToken);
    }

    /* renamed from: a */
    private void m15253a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.f37221a = activity;
        Intent m15306c = m15306c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (m15306c == null) {
            SLog.m15127i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            m15306c = m15306c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = m15306c;
        bundle.putAll(m15308b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", "request");
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        m15254a(activity, intent, str, bundle, C13065j.m15004a().m15003a(C13061g.m15027a(), "https://imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    /* renamed from: a */
    private void m15254a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        SLog.m15127i("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            m15255a(activity, intent, str, bundle, iUiListener);
            return;
        }
        C13063i m15015a = C13063i.m15015a(C13061g.m15027a(), this.f37136c.getAppId());
        if (!z && !m15015a.m15008b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            m15252a(activity, str, bundle, str2, iUiListener);
        } else {
            m15313a(activity, bundle, iUiListener);
        }
    }

    /* renamed from: a */
    private void m15255a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        m15316a(activity, intent, Constants.REQUEST_SOCIAL_API);
    }

    /* renamed from: a */
    private void m15252a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.m15127i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        Intent m15307c = m15307c();
        IUiListener c12990a = new C12990a(activity, iUiListener, str, str2, bundle);
        Intent mo15248b = mo15248b("com.tencent.open.agent.EncryTokenActivity");
        if (mo15248b != null && m15307c != null && m15307c.getComponent() != null && mo15248b.getComponent() != null && m15307c.getComponent().getPackageName().equals(mo15248b.getComponent().getPackageName())) {
            mo15248b.putExtra("oauth_consumer_key", this.f37136c.getAppId());
            mo15248b.putExtra("openid", this.f37136c.getOpenId());
            mo15248b.putExtra("access_token", this.f37136c.getAccessToken());
            mo15248b.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            SLog.m15127i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, c12990a);
            m15316a(activity, mo15248b, Constants.REQUEST_SOCIAL_H5);
            return;
        }
        SLog.m15127i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
        String m14924g = C13071m.m14924g("tencent&sdk&qazxc***14969%%" + this.f37136c.getAccessToken() + this.f37136c.getAppId() + this.f37136c.getOpenId() + "qzone3.4");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, m14924g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c12990a.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15251a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        SLog.m15123v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.f37136c.getAppId());
        if (this.f37136c.isSessionValid()) {
            bundle.putString("access_token", this.f37136c.getAccessToken());
        }
        String openId = this.f37136c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", C13061g.m15027a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
        } catch (Exception e) {
            e.printStackTrace();
            bundle.putString("pf", Constants.DEFAULT_PF);
        }
        String str3 = str2 + HttpUtils.encodeUrl(bundle);
        SLog.m15131d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
            new TDialog(this.f37221a, str, str3, iUiListener, this.f37136c).show();
            return;
        }
        SLog.m15131d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
        new DialogC13029d(this.f37221a, str, str3, iUiListener, this.f37136c).show();
    }
}
