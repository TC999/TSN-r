package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WeixinPreferences {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_OPENID = "openid";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_REFRESH_TOKEN_TTL = "rt_expires_in";
    private static final String KEY_UID = "unionid";
    private String mAccessToken;
    private long mAccessTokenTTL;
    private String mOpenid;
    private String mRefreshToken;
    private long mRefreshTokenTTL;
    private String mUID;
    private final SharedPreferences sharedPreferences;

    public WeixinPreferences(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str + "full", 0);
        this.sharedPreferences = sharedPreferences;
        this.mUID = sharedPreferences.getString("unionid", null);
        this.mOpenid = sharedPreferences.getString("openid", null);
        this.mAccessToken = sharedPreferences.getString("access_token", null);
        this.mAccessTokenTTL = sharedPreferences.getLong("expires_in", 0L);
        this.mRefreshToken = sharedPreferences.getString("refresh_token", null);
        this.mRefreshTokenTTL = sharedPreferences.getLong("rt_expires_in", 0L);
    }

    public void commit() {
        this.sharedPreferences.edit().putString("unionid", this.mUID).putString("openid", this.mOpenid).putString("access_token", this.mAccessToken).putString("refresh_token", this.mRefreshToken).putLong("rt_expires_in", this.mRefreshTokenTTL).putLong("expires_in", this.mAccessTokenTTL).commit();
    }

    public void delete() {
        this.sharedPreferences.edit().clear().commit();
        this.mAccessToken = "";
        this.mRefreshToken = "";
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public long getAccessTokenTTL() {
        return this.mAccessTokenTTL;
    }

    public Map<String, String> getMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", this.mAccessToken);
        hashMap.put("unionid", this.mUID);
        hashMap.put("openid", this.mOpenid);
        hashMap.put("refresh_token", this.mRefreshToken);
        hashMap.put("expires_in", String.valueOf(this.mAccessTokenTTL));
        return hashMap;
    }

    public String getOpenid() {
        return this.mOpenid;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getUID() {
        return this.mUID;
    }

    public boolean isAccessTokenAvailable() {
        return (TextUtils.isEmpty(this.mAccessToken) || (((this.mAccessTokenTTL - System.currentTimeMillis()) > 0L ? 1 : ((this.mAccessTokenTTL - System.currentTimeMillis()) == 0L ? 0 : -1)) <= 0)) ? false : true;
    }

    public boolean isAuth() {
        return !TextUtils.isEmpty(getAccessToken());
    }

    public boolean isAuthValid() {
        return (TextUtils.isEmpty(this.mRefreshToken) || (((this.mRefreshTokenTTL - System.currentTimeMillis()) > 0L ? 1 : ((this.mRefreshTokenTTL - System.currentTimeMillis()) == 0L ? 0 : -1)) <= 0)) ? false : true;
    }

    public WeixinPreferences setBundle(Bundle bundle) {
        if (TextUtils.isEmpty(bundle.getString("unionid"))) {
            this.mUID = bundle.getString("unionid");
        }
        if (TextUtils.isEmpty(bundle.getString("openid"))) {
            this.mOpenid = bundle.getString("openid");
        }
        this.mAccessToken = bundle.getString("access_token");
        this.mRefreshToken = bundle.getString("refresh_token");
        String string = bundle.getString("expires_in");
        if (!TextUtils.isEmpty(string)) {
            this.mAccessTokenTTL = (Long.valueOf(string).longValue() * 1000) + System.currentTimeMillis();
        }
        long j4 = bundle.getLong("refresh_token_expires");
        if (j4 != 0) {
            this.mRefreshTokenTTL = (j4 * 1000) + System.currentTimeMillis();
        }
        commit();
        return this;
    }
}
