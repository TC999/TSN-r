package com.mbridge.msdk.mbdownload;

import android.content.Context;

/* renamed from: com.mbridge.msdk.mbdownload.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class DeltaUpdate {

    /* renamed from: a */
    private static boolean f31250a;

    static {
        try {
            System.loadLibrary("bspatch");
            f31250a = true;
        } catch (UnsatisfiedLinkError unused) {
            f31250a = false;
        }
    }

    /* renamed from: a */
    public static String m21682a(Context context) {
        return context.getApplicationInfo().sourceDir;
    }
}
