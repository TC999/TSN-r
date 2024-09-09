package com.mbridge.msdk.widget.custom.b;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41194a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f41195b = "com.mbridge.msdk.widget.custom.baseview.MB";

    public static void a(String str) {
        if (f41194a) {
            new SecurityManager();
            Log.e(new Throwable().getStackTrace()[1].getFileName(), str);
        }
    }
}
