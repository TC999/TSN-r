package com.bxkj.base.p085v2.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* renamed from: com.bxkj.base.v2.common.utils.o */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OpenUDID {

    /* renamed from: a */
    protected static final String f15136a = "gank_device_id.xml";

    /* renamed from: b */
    protected static final String f15137b = "gank_device_id";

    /* renamed from: c */
    protected static String f15138c;

    /* renamed from: a */
    public static synchronized String m43752a(Context context) {
        String str;
        synchronized (OpenUDID.class) {
            String str2 = f15138c;
            if (str2 == null && str2 == null) {
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f15136a, 0);
                String string = sharedPreferences.getString(f15137b, null);
                if (string != null) {
                    f15138c = string;
                } else {
                    String string2 = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                    if (string2 != null) {
                        try {
                            if (!"9774d56d682e549c".equals(string2)) {
                                f15138c = UUID.nameUUIDFromBytes(string2.getBytes("utf8")).toString();
                                sharedPreferences.edit().putString(f15137b, f15138c).commit();
                            }
                        } catch (UnsupportedEncodingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                    f15138c = (deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID()).toString();
                    sharedPreferences.edit().putString(f15137b, f15138c).commit();
                }
            }
            str = f15138c;
        }
        return str;
    }
}
