package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.w.c.a;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f24938c = false;

    /* renamed from: f  reason: collision with root package name */
    private static int f24939f = 1;
    private static boolean sr;
    private static a ux;

    /* renamed from: w  reason: collision with root package name */
    private static Context f24940w;
    private static String xv;

    public static String c() {
        if (TextUtils.isEmpty(xv)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                xv = file.getAbsolutePath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return xv;
    }

    public static Context getContext() {
        return f24940w;
    }

    public static boolean sr() {
        return f24938c;
    }

    public static int ux() {
        return f24939f;
    }

    public static boolean w() {
        return sr;
    }

    public static a xv() {
        if (ux == null) {
            a.c cVar = new a.c("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ux = cVar.c(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).w(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).xv(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, timeUnit).c();
        }
        return ux;
    }

    public static void c(Context context, String str) {
        f24940w = context;
        xv = str;
    }

    public static void c(boolean z3) {
        sr = z3;
    }

    public static void c(a aVar) {
        ux = aVar;
    }
}
