package com.mbridge.msdk.mbdownload;

import android.content.Context;

/* compiled from: DeltaUpdate.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f40022a;

    static {
        try {
            System.loadLibrary("bspatch");
            f40022a = true;
        } catch (UnsatisfiedLinkError unused) {
            f40022a = false;
        }
    }

    public static String a(Context context) {
        return context.getApplicationInfo().sourceDir;
    }
}
