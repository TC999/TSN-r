package com.bxkj.base.v2.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OpenUDID.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f18628a = "gank_device_id.xml";

    /* renamed from: b  reason: collision with root package name */
    protected static final String f18629b = "gank_device_id";

    /* renamed from: c  reason: collision with root package name */
    protected static String f18630c;

    public static synchronized String a(Context context) {
        String str;
        synchronized (o.class) {
            String str2 = f18630c;
            if (str2 == null && str2 == null) {
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f18628a, 0);
                String string = sharedPreferences.getString(f18629b, null);
                if (string != null) {
                    f18630c = string;
                } else {
                    String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (string2 != null) {
                        try {
                            if (!"9774d56d682e549c".equals(string2)) {
                                f18630c = UUID.nameUUIDFromBytes(string2.getBytes("utf8")).toString();
                                sharedPreferences.edit().putString(f18629b, f18630c).commit();
                            }
                        } catch (UnsupportedEncodingException e4) {
                            throw new RuntimeException(e4);
                        }
                    }
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    f18630c = (deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID()).toString();
                    sharedPreferences.edit().putString(f18629b, f18630c).commit();
                }
            }
            str = f18630c;
        }
        return str;
    }
}
