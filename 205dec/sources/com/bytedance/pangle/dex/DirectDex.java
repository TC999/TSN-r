package com.bytedance.pangle.dex;

import android.os.Build;
import androidx.annotation.Keep;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DirectDex {
    static {
        System.loadLibrary("zeus_direct_dex");
        native_init(Build.VERSION.SDK_INT);
    }

    private static native boolean native_init(int i4);

    public static native Object native_load_direct_dex(String str);
}
