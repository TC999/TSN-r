package com.mbridge.msdk.widget.custom.p517b;

import android.util.Log;

/* compiled from: Logger.java */
/* renamed from: com.mbridge.msdk.widget.custom.b.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C11754d {

    /* renamed from: a */
    public static boolean f32505a = false;

    /* renamed from: b */
    public static String f32506b = "com.mbridge.msdk.widget.custom.baseview.MB";

    /* renamed from: a */
    public static void m20566a(String str) {
        if (f32505a) {
            new SecurityManager();
            Log.e(new Throwable().getStackTrace()[1].getFileName(), str);
        }
    }
}
