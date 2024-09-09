package com.umeng.umzid;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Spy {
    public static boolean initSuccess;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z3, boolean z4);

    public static synchronized String getTag(Context context) {
        boolean j4;
        String nativeTag;
        synchronized (Spy.class) {
            if (context != null) {
                try {
                    j4 = d.j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                j4 = false;
            }
            nativeTag = getNativeTag(j4, context != null ? d.i(context) : false);
        }
        return nativeTag;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
