package com.jmolsmobile.landscapevideocapture;

import android.content.Context;
import android.util.Log;

/* renamed from: com.jmolsmobile.landscapevideocapture.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CLog {

    /* renamed from: a */
    public static final String f24343a = "VideoCapture_Exception";

    /* renamed from: b */
    public static final String f24344b = "VideoCapture_Activity";

    /* renamed from: c */
    public static final String f24345c = "VideoCapture_Preview";

    /* renamed from: d */
    public static final String f24346d = "VideoCapture_CaptureHelper";

    /* renamed from: e */
    public static final String f24347e = "VideoCapture_VideoRecorder";

    /* renamed from: f */
    public static final String f24348f = "VideoCapture_CameraWrapper";

    /* renamed from: g */
    private static boolean f24349g = true;

    /* renamed from: a */
    public static void m34554a(String str, String str2) {
        if (f24349g) {
            Log.d(str, str2);
        }
    }

    /* renamed from: b */
    public static void m34553b(String str, String str2) {
        if (f24349g) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m34552c(Context context) {
        f24349g = (context.getApplicationInfo().flags & 2) != 0;
    }
}
