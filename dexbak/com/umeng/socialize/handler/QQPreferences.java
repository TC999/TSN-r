package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QQPreferences {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String EXPIRES_IN = "expires_in";
    private static final String OPENID = "openid";
    private static final String UID = "uid";
    private static final String UNIONID = "unionid";
    private static long mtl;
    private String mAccessToken;
    private String mOpenid;
    private String mUID;
    private SharedPreferences sharedPreferences;
    private String unionid;

    public QQPreferences(Context context, String str) {
        this.mAccessToken = null;
        this.mUID = null;
        this.unionid = null;
        this.mOpenid = null;
        this.sharedPreferences = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str + "full", 0);
        this.sharedPreferences = sharedPreferences;
        this.mAccessToken = sharedPreferences.getString("access_token", null);
        this.mUID = this.sharedPreferences.getString("uid", null);
        this.mOpenid = this.sharedPreferences.getString("openid", null);
        mtl = this.sharedPreferences.getLong("expires_in", 0L);
        this.unionid = this.sharedPreferences.getString("unionid", null);
    }

    public static long getExpiresIn() {
        return mtl;
    }

    public void commit() {
        this.sharedPreferences.edit().putString("access_token", this.mAccessToken).putLong("expires_in", mtl).putString("uid", this.mUID).putString("openid", this.mOpenid).putString("unionid", this.unionid).commit();
    }

    public void delete() {
        this.mAccessToken = null;
        mtl = 0L;
        this.sharedPreferences.edit().clear().commit();
    }

    public String getUnionid() {
        return this.unionid;
    }

    public String getmAccessToken() {
        return this.mAccessToken;
    }

    public String getmUID() {
        return this.mUID;
    }

    public boolean isAuthValid() {
        return (this.mAccessToken == null || (((mtl - System.currentTimeMillis()) > 0L ? 1 : ((mtl - System.currentTimeMillis()) == 0L ? 0 : -1)) <= 0)) ? false : true;
    }

    public QQPreferences setAuthData(Bundle bundle) {
        this.mAccessToken = bundle.getString("access_token");
        mtl = (Long.valueOf(bundle.getString("expires_in")).longValue() * 1000) + System.currentTimeMillis();
        this.mOpenid = bundle.getString("openid");
        this.mUID = bundle.getString("openid");
        this.unionid = bundle.getString("unionid");
        return this;
    }

    public void setUnionid(String str) {
        this.unionid = str;
    }

    public void setmOpenid(String str) {
        this.mOpenid = str;
    }

    public void setmUID(String str) {
        this.mUID = str;
    }
}
