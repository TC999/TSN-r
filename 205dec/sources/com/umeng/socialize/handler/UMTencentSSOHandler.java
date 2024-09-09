package com.umeng.socialize.handler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class UMTencentSSOHandler extends UMSSOHandler {
    protected static final String FIGUREURL_QQ_2 = "figureurl_qq_2";
    protected static final String IS_YELLOW_VIP = "is_yellow_vip";
    protected static final String IS_YELLOW_YEAR_VIP = "is_yellow_year_vip";
    protected static final String LEVEL = "level";
    protected static final String MSG = "msg";
    protected static final String NICKNAME = "nickname";
    private static final String PUBLIC_ACCOUNT = "100424468";
    protected static final String RET = "ret";
    private static final String TAG = "UMTencentSSOHandler";
    protected static final String VIP = "vip";
    protected static final String YELLOW_VIP_LEVEL = "yellow_vip_level";
    protected static Map<String, String> mImageCache = new HashMap();
    protected UMAuthListener mAuthListener;
    protected UMShareListener mShareListener;
    protected Tencent mTencent;
    protected ProgressDialog mProgressDialog = null;
    protected String mImageUrl = null;
    public PlatformConfig.APPIDPlatform config = null;
    protected String VERSION = "7.3.2";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    protected interface ObtainAppIdListener {
        void onComplete();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ObtainImageUrlListener {
        void onComplete(String str);
    }

    private void setImageUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        mImageCache.put(str, str2);
        this.mImageUrl = str2;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getVersion() {
        return this.VERSION;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onCreate(Context context, PlatformConfig.Platform platform) {
        super.onCreate(context, platform);
        PlatformConfig.APPIDPlatform aPPIDPlatform = (PlatformConfig.APPIDPlatform) platform;
        this.config = aPPIDPlatform;
        if (TextUtils.isEmpty(aPPIDPlatform.getFileProvider())) {
            SLog.E(UmengText.QQ.QQ_FILE_PROVIDER_ERROR);
            this.mTencent = Tencent.createInstance(this.config.appId, context);
        } else {
            PlatformConfig.APPIDPlatform aPPIDPlatform2 = this.config;
            this.mTencent = Tencent.createInstance(aPPIDPlatform2.appId, context, aPPIDPlatform2.getFileProvider());
        }
        if (this.mTencent == null) {
            SLog.E(UmengText.QQ.QQ_TENCENT_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle parseOauthData(Object obj) {
        Bundle bundle = new Bundle();
        if (obj == null) {
            return bundle;
        }
        String trim = obj.toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return bundle;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(trim);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (jSONObject == null) {
            return bundle;
        }
        bundle.putString("auth_time", jSONObject.optString("auth_time", ""));
        bundle.putString("pay_token", jSONObject.optString("pay_token", ""));
        bundle.putString("pf", jSONObject.optString("pf", ""));
        bundle.putString("ret", String.valueOf(jSONObject.optInt("ret", -1)));
        bundle.putString("sendinstall", jSONObject.optString("sendinstall", ""));
        bundle.putString("page_type", jSONObject.optString("page_type", ""));
        bundle.putString("appid", jSONObject.optString("appid", ""));
        bundle.putString("openid", jSONObject.optString("openid", ""));
        bundle.putString("uid", jSONObject.optString("openid", ""));
        bundle.putString("expires_in", jSONObject.optString("expires_in", ""));
        bundle.putString("pfkey", jSONObject.optString("pfkey", ""));
        bundle.putString("access_token", jSONObject.optString("access_token", ""));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean validTencent() {
        Tencent tencent = this.mTencent;
        return tencent != null && tencent.getAppId().equals(this.config.appId);
    }
}
