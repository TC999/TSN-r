package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class UMInnerManager {
    private static Class<?> innerImplClazz;
    private static Method sendInternalMethod;

    static {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMInnerImpl");
            innerImplClazz = cls;
            Method declaredMethod = cls.getDeclaredMethod("initAndSendInternal", Context.class);
            if (declaredMethod != null) {
                sendInternalMethod = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    public static void sendInnerPackage(Context context) {
        Method method;
        if (context == null || !UMUtils.isMainProgress(context)) {
            return;
        }
        if (SdkVersion.SDK_TYPE != 1) {
            Class<?> cls = innerImplClazz;
            if (cls == null || (method = sendInternalMethod) == null) {
                return;
            }
            try {
                method.invoke(cls, context);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        UMConfigureInternation.sendInternal(context);
    }
}
