package com.umeng.umzid;

import android.content.Context;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    public static native String getNativeTag(boolean z, boolean z2);

    public static synchronized String getTag(Context context) {
        boolean m13173j;
        String nativeTag;
        synchronized (Spy.class) {
            if (context != null) {
                try {
                    m13173j = C13492d.m13173j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                m13173j = false;
            }
            nativeTag = getNativeTag(m13173j, context != null ? C13492d.m13174i(context) : false);
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
