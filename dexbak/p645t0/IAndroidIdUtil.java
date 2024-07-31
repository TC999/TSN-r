package p645t0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* renamed from: t0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IAndroidIdUtil {
    /* renamed from: a */
    public static String m308a(Context context) {
        String m306b = ISettingUtils.m306b(context, SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        if (TextUtils.isEmpty(m306b)) {
            m306b = ISettingUtils.m307a(context, SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            if (TextUtils.isEmpty(m306b)) {
                return Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            }
        }
        return m306b;
    }
}
