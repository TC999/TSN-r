package com.bytedance.sdk.openadsdk.n;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.ls;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ev {

    /* renamed from: c  reason: collision with root package name */
    public static String f36243c = null;

    /* renamed from: f  reason: collision with root package name */
    private static int f36244f = 1;
    private static String sr;
    private static String ux;

    /* renamed from: w  reason: collision with root package name */
    public static volatile com.bykv.vk.openvk.component.video.api.c.w f36245w;
    public static volatile com.bykv.vk.openvk.component.video.api.c.w xv;

    public static com.bykv.vk.openvk.component.video.api.c.w c(int i4) {
        if (i4 == 1) {
            return ev();
        }
        return r();
    }

    private static com.bykv.vk.openvk.component.video.api.c.w ev() {
        if (xv == null) {
            synchronized (ev.class) {
                if (xv == null) {
                    xv = new com.bytedance.sdk.component.k.w.c.c();
                    xv.c(gd());
                    xv.ux();
                }
            }
        }
        return xv;
    }

    public static String f() {
        if (ux == null) {
            ux = c("image");
        }
        return ux;
    }

    private static String gd() {
        if (!TextUtils.isEmpty(f36243c)) {
            return f36243c;
        }
        int rh = ls.w().rh();
        f36244f = rh;
        String w3 = w(rh);
        f36243c = w3;
        return w3;
    }

    private static com.bykv.vk.openvk.component.video.api.c.w r() {
        if (f36245w == null) {
            synchronized (ev.class) {
                if (f36245w == null) {
                    f36245w = new com.bykv.vk.openvk.component.video.c.c.c.c();
                    f36245w.c(gd());
                    f36245w.ux();
                }
            }
        }
        return f36245w;
    }

    public static int sr() {
        return f36244f;
    }

    public static String ux() {
        if (sr == null) {
            sr = c("splash_image");
        }
        return sr;
    }

    private static String w(int i4) {
        File c4;
        Context context = ls.getContext();
        if (i4 == 1) {
            a.xv("CacheDirConstants", "\u4f7f\u7528\u5185\u90e8\u5b58\u50a8");
            c4 = com.bytedance.sdk.component.utils.f.w(context, com.bytedance.sdk.openadsdk.core.multipro.w.xv(), "tt_ad");
        } else {
            a.xv("CacheDirConstants", "\u4f7f\u7528\u5916\u90e8\u5b58\u50a8");
            c4 = com.bytedance.sdk.component.utils.f.c(context, com.bytedance.sdk.openadsdk.core.multipro.w.xv(), "tt_ad");
        }
        if (c4.isFile()) {
            c4.delete();
        }
        if (!c4.exists()) {
            c4.mkdirs();
        }
        return c4.getAbsolutePath();
    }

    public static long[] xv() {
        long j4 = 10485760;
        long j5 = 20971520;
        long j6 = 31457280;
        return new long[]{j4, j5, j6, j5, j4, j5, j6, j5};
    }

    public static String c() {
        return gd() + File.separator + "video_brand";
    }

    public static String c(String str) {
        return gd() + File.separator + str;
    }

    public static String[] w() {
        String w3 = w(1);
        com.bytedance.sdk.component.k.w.c.c cVar = new com.bytedance.sdk.component.k.w.c.c();
        cVar.c(w3);
        String w4 = w(0);
        com.bytedance.sdk.component.k.w.c.c cVar2 = new com.bytedance.sdk.component.k.w.c.c();
        cVar2.c(w4);
        return new String[]{cVar.w(), cVar.xv(), cVar.c(), cVar.sr(), cVar2.w(), cVar2.xv(), cVar2.c(), cVar2.sr()};
    }
}
