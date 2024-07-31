package com.mbridge.msdk.out;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.C11332Aa;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ChannelManager {
    public static void setChannel(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C11332Aa c11332Aa = new C11332Aa();
            Method declaredMethod = C11332Aa.class.getDeclaredMethod("b", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(c11332Aa, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
