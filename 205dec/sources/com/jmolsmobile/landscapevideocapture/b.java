package com.jmolsmobile.landscapevideocapture;

import android.content.Context;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: CLog.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f37891a = "VideoCapture_Exception";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37892b = "VideoCapture_Activity";

    /* renamed from: c  reason: collision with root package name */
    public static final String f37893c = "VideoCapture_Preview";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37894d = "VideoCapture_CaptureHelper";

    /* renamed from: e  reason: collision with root package name */
    public static final String f37895e = "VideoCapture_VideoRecorder";

    /* renamed from: f  reason: collision with root package name */
    public static final String f37896f = "VideoCapture_CameraWrapper";

    /* renamed from: g  reason: collision with root package name */
    private static boolean f37897g = true;

    public static void a(String str, String str2) {
        if (f37897g) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f37897g) {
            Log.e(str, str2);
        }
    }

    public static void c(Context context) {
        f37897g = (context.getApplicationInfo().flags & 2) != 0;
    }
}
