package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p566b.C13010b;
import com.tencent.open.utils.C13049a;
import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13066k;
import com.tencent.open.utils.C13071m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g */
    private static SharedPreferences f37018g;

    /* renamed from: a */
    private String f37019a;

    /* renamed from: b */
    private String f37020b;

    /* renamed from: c */
    private String f37021c;

    /* renamed from: d */
    private int f37022d = 1;

    /* renamed from: e */
    private long f37023e = -1;

    /* renamed from: f */
    private C13049a f37024f;

    public QQToken(String str) {
        this.f37019a = str;
    }

    @TargetApi(11)
    /* renamed from: a */
    private static synchronized SharedPreferences m15437a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            if (f37018g == null) {
                f37018g = C13061g.m15027a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = f37018g;
        }
        return sharedPreferences;
    }

    @Deprecated
    /* renamed from: b */
    private static String m15433b(String str) {
        return Base64.encodeToString(C13071m.m14919j(str), 2);
    }

    @Deprecated
    /* renamed from: c */
    private static String m15432c(String str) {
        return Base64.encodeToString(C13071m.m14919j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f37020b;
    }

    public String getAppId() {
        return this.f37019a;
    }

    public int getAuthSource() {
        return this.f37022d;
    }

    public long getExpireTimeInSecond() {
        return this.f37023e;
    }

    public String getOpenId() {
        return this.f37021c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject loadSession = loadSession(this.f37019a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.m15127i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f37019a);
            } else {
                SLog.m15127i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f37019a);
            }
        } catch (Exception e) {
            SLog.m15127i("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.f37020b != null && System.currentTimeMillis() < this.f37023e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f37024f == null) {
                this.f37024f = new C13049a(C13061g.m15027a());
            }
            return m15435a(str, this.f37024f);
        } catch (Exception e) {
            SLog.m15127i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = m15437a().edit();
        edit.remove(m15432c(str));
        edit.remove(m15432c(str));
        edit.remove(m15436a(str));
        edit.apply();
        SLog.m15127i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f37024f == null) {
                this.f37024f = new C13049a(C13061g.m15027a());
            }
            return m15434a(this.f37019a, jSONObject, this.f37024f);
        } catch (Exception e) {
            SLog.m15127i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f37020b = str;
        this.f37023e = 0L;
        if (str2 != null) {
            this.f37023e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f37019a = str;
    }

    public void setAuthSource(int i) {
        this.f37022d = i;
    }

    public void setOpenId(String str) {
        this.f37021c = str;
        C13010b.m15193a().m15190a(str);
    }

    /* renamed from: a */
    private static synchronized JSONObject m15435a(String str, C13049a c13049a) {
        String m15056b;
        synchronized (QQToken.class) {
            if (C13061g.m15027a() == null) {
                SLog.m15127i("QQToken", "loadJsonPreference context null");
                return null;
            } else if (str == null) {
                SLog.m15127i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            } else {
                String string = m15437a().getString(m15436a(str), "");
                if (TextUtils.isEmpty(string)) {
                    if (!JniInterface.isJniOk) {
                        C13066k.m14991a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                        JniInterface.loadSo();
                    }
                    if (!JniInterface.isJniOk) {
                        SLog.m15127i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                        return null;
                    }
                    String m15432c = m15432c(str);
                    String string2 = m15437a().getString(m15432c, "");
                    if (TextUtils.isEmpty(string2)) {
                        String m15433b = m15433b(str);
                        String string3 = m15437a().getString(m15433b, "");
                        if (TextUtils.isEmpty(string3)) {
                            SLog.m15127i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            m15056b = JniInterface.m14907d1(string3);
                            if (TextUtils.isEmpty(m15056b)) {
                                SLog.m15127i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                m15437a().edit().remove(m15433b).apply();
                                return null;
                            }
                            m15434a(str, new JSONObject(m15056b), c13049a);
                            m15437a().edit().remove(m15433b).apply();
                        } catch (Exception e) {
                            SLog.m15128e("QQToken", "Catch Exception", e);
                            m15437a().edit().remove(m15433b).apply();
                            return null;
                        }
                    } else {
                        try {
                            m15056b = JniInterface.m14906d2(string2);
                            m15434a(str, new JSONObject(m15056b), c13049a);
                            m15437a().edit().remove(m15432c).apply();
                        } catch (Exception e2) {
                            SLog.m15128e("QQToken", "Catch Exception", e2);
                            m15437a().edit().remove(m15432c).apply();
                            return null;
                        }
                    }
                } else {
                    m15056b = c13049a.m15056b(string);
                }
                try {
                    JSONObject jSONObject = new JSONObject(m15056b);
                    SLog.m15127i("QQToken", "loadJsonPreference sucess");
                    return jSONObject;
                } catch (Exception e3) {
                    SLog.m15127i("QQToken", "loadJsonPreference decode " + e3.toString());
                    return null;
                }
            }
        }
    }

    /* renamed from: a */
    private static synchronized boolean m15434a(String str, JSONObject jSONObject, C13049a c13049a) {
        synchronized (QQToken.class) {
            if (C13061g.m15027a() == null) {
                SLog.m15127i("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String m15436a = m15436a(str);
                        String m15058a = c13049a.m15058a(jSONObject.toString());
                        if (m15436a.length() > 6 && m15058a != null) {
                            m15437a().edit().putString(m15436a, m15058a).commit();
                            SLog.m15127i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.m15127i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.m15127i("QQToken", "expires is null");
                    return false;
                } catch (Exception e) {
                    SLog.m15129e("QQToken", "saveJsonPreference exception:" + e.toString());
                    return false;
                }
            } else {
                SLog.m15127i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            }
        }
    }

    /* renamed from: a */
    private static String m15436a(String str) {
        return Base64.encodeToString(C13071m.m14919j(str), 2) + "_aes_google";
    }
}
