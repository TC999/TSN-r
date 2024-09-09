package com.mbridge.msdk.out;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ChannelManager {
    public static void setChannel(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Aa aa = new Aa();
            Method declaredMethod = Aa.class.getDeclaredMethod("b", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(aa, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
