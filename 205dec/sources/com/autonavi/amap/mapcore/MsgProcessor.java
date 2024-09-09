package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.col.p0003l.x5;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MsgProcessor {
    private static x5 mDelegate = new x5();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z3, String str, String str2, String str3, String[] strArr) {
        mDelegate.a(context, z3, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.b(str, str2);
    }
}
