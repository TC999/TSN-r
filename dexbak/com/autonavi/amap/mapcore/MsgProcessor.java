package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.col.p0463l.MsgProcessorDelegate;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MsgProcessor {
    private static MsgProcessorDelegate mDelegate = new MsgProcessorDelegate();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        mDelegate.m53586a(context, z, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.m53585b(str, str2);
    }
}
