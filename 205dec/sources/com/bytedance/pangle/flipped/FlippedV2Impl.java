package com.bytedance.pangle.flipped;

import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FlippedV2Impl implements c {
    private static final String TAG = "FlippedV2Impl";

    static {
        System.loadLibrary("pangleflipped");
    }

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    @Override // com.bytedance.pangle.flipped.c
    public void invokeHiddenApiRestrictions() {
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, new String[]{"L"});
        } catch (Exception e4) {
            Log.e("FlippedV2Impl", "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e4));
        }
    }
}
