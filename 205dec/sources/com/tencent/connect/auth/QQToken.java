package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g  reason: collision with root package name */
    private static SharedPreferences f51384g;

    /* renamed from: a  reason: collision with root package name */
    private String f51385a;

    /* renamed from: b  reason: collision with root package name */
    private String f51386b;

    /* renamed from: c  reason: collision with root package name */
    private String f51387c;

    /* renamed from: d  reason: collision with root package name */
    private int f51388d = 1;

    /* renamed from: e  reason: collision with root package name */
    private long f51389e = -1;

    /* renamed from: f  reason: collision with root package name */
    private com.tencent.open.utils.a f51390f;

    public QQToken(String str) {
        this.f51385a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f51384g == null) {
                f51384g = g.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f51384g;
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(m.j(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f51386b;
    }

    public String getAppId() {
        return this.f51385a;
    }

    public int getAuthSource() {
        return this.f51388d;
    }

    public long getExpireTimeInSecond() {
        return this.f51389e;
    }

    public String getOpenId() {
        return this.f51387c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.f51385a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f51385a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f51385a);
            }
        } catch (Exception e4) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e4.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.f51386b != null && System.currentTimeMillis() < this.f51389e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f51390f == null) {
                this.f51390f = new com.tencent.open.utils.a(g.a());
            }
            return a(str, this.f51390f);
        } catch (Exception e4) {
            SLog.i("QQToken", "login loadSession" + e4.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f51390f == null) {
                this.f51390f = new com.tencent.open.utils.a(g.a());
            }
            return a(this.f51385a, jSONObject, this.f51390f);
        } catch (Exception e4) {
            SLog.i("QQToken", "login saveSession" + e4.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f51386b = str;
        this.f51389e = 0L;
        if (str2 != null) {
            this.f51389e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f51385a = str;
    }

    public void setAuthSource(int i4) {
        this.f51388d = i4;
    }

    public void setOpenId(String str) {
        this.f51387c = str;
        com.tencent.open.b.b.a().a(str);
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b4;
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            } else {
                String string = a().getString(a(str), "");
                if (TextUtils.isEmpty(string)) {
                    if (!JniInterface.isJniOk) {
                        k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                    }
                    if (!JniInterface.isJniOk) {
                        SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                        return null;
                    }
                    String c4 = c(str);
                    String string2 = a().getString(c4, "");
                    if (TextUtils.isEmpty(string2)) {
                        String b5 = b(str);
                        String string3 = a().getString(b5, "");
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            b4 = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(b4)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                a().edit().remove(b5).apply();
                                return null;
                            }
                            a(str, new JSONObject(b4), aVar);
                            a().edit().remove(b5).apply();
                        } catch (Exception e4) {
                            SLog.e("QQToken", "Catch Exception", e4);
                            a().edit().remove(b5).apply();
                            return null;
                        }
                    } else {
                        try {
                            b4 = JniInterface.d2(string2);
                            a(str, new JSONObject(b4), aVar);
                            a().edit().remove(c4).apply();
                        } catch (Exception e5) {
                            SLog.e("QQToken", "Catch Exception", e5);
                            a().edit().remove(c4).apply();
                            return null;
                        }
                    }
                } else {
                    b4 = aVar.b(string);
                }
                try {
                    JSONObject jSONObject = new JSONObject(b4);
                    SLog.i("QQToken", "loadJsonPreference sucess");
                    return jSONObject;
                } catch (Exception e6) {
                    SLog.i("QQToken", "loadJsonPreference decode " + e6.toString());
                    return null;
                }
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a4 = a(str);
                        String a5 = aVar.a(jSONObject.toString());
                        if (a4.length() > 6 && a5 != null) {
                            a().edit().putString(a4, a5).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e4) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e4.toString());
                    return false;
                }
            } else {
                SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            }
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_aes_google";
    }
}
