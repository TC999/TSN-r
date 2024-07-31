package com.bxkj.student.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* compiled from: OpenUDID.java */
/* renamed from: com.bxkj.student.common.utils.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C4249g {

    /* renamed from: a */
    protected static final String f16223a = "gank_device_id.xml";

    /* renamed from: b */
    protected static final String f16224b = "gank_device_id";

    /* renamed from: c */
    protected static String f16225c;

    /* renamed from: a */
    public static synchronized String m42833a(Context mContext) {
        String str;
        synchronized (C4249g.class) {
            String str2 = f16225c;
            if (str2 == null && str2 == null) {
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(mContext.getApplicationContext()).getSharedPreferences(f16223a, 0);
                String string = sharedPreferences.getString(f16224b, null);
                if (string != null) {
                    f16225c = string;
                } else {
                    String string2 = Settings.Secure.getString(mContext.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                    if (string2 != null) {
                        try {
                            if (!"9774d56d682e549c".equals(string2)) {
                                f16225c = UUID.nameUUIDFromBytes(string2.getBytes("utf8")).toString();
                                sharedPreferences.edit().putString(f16224b, f16225c).commit();
                            }
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String deviceId = ((TelephonyManager) mContext.getSystemService("phone")).getDeviceId();
                    f16225c = (deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID()).toString();
                    sharedPreferences.edit().putString(f16224b, f16225c).commit();
                }
            }
            str = f16225c;
        }
        return str;
    }
}
