package com.bykv.vk.openvk.component.video.c.w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.bykv.vk.openvk.component.video.c.w.c.xv;
import com.stub.StubApp;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    static volatile com.bykv.vk.openvk.component.video.c.w.c.w f25133c;

    /* renamed from: f  reason: collision with root package name */
    static volatile boolean f25134f;
    public static volatile Integer gd;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: k  reason: collision with root package name */
    private static volatile Context f25135k;

    /* renamed from: p  reason: collision with root package name */
    private static volatile com.bykv.vk.openvk.component.video.c.w.w.xv f25136p;
    public static volatile boolean sr;

    /* renamed from: w  reason: collision with root package name */
    static volatile com.bykv.vk.openvk.component.video.c.w.c.xv f25138w;
    public static final boolean xv = com.bytedance.sdk.component.utils.a.xv();
    static volatile boolean ux = true;

    /* renamed from: r  reason: collision with root package name */
    static volatile int f25137r = 0;
    public static volatile int ev = 3;

    public static void c(boolean z3) {
        ux = z3;
    }

    public static Context getContext() {
        return f25135k;
    }

    public static void w(boolean z3) {
        f25134f = z3;
    }

    public static void c(int i4) {
        f25137r = i4;
    }

    public static com.bykv.vk.openvk.component.video.c.w.c.w w() {
        return f25133c;
    }

    public static void c(com.bykv.vk.openvk.component.video.c.w.c.xv xvVar, Context context) {
        if (xvVar != null && context != null) {
            f25135k = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (f25138w != null) {
                return;
            }
            com.bykv.vk.openvk.component.video.c.w.c.w wVar = f25133c;
            if (wVar != null && wVar.f25055c.getAbsolutePath().equals(xvVar.f25057c.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
            }
            f25138w = xvVar;
            f25136p = com.bykv.vk.openvk.component.video.c.w.w.xv.c(context);
            f25138w.c(new xv.c() { // from class: com.bykv.vk.openvk.component.video.c.w.ux.1
                @Override // com.bykv.vk.openvk.component.video.c.w.c.xv.c
                public void c(String str) {
                    if (ux.xv) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.c.w.c.xv.c
                public void c(Set<String> set) {
                    ux.f25136p.c(set, 0);
                    if (ux.xv) {
                        Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
                    }
                }
            });
            f c4 = f.c();
            c4.c(xvVar);
            c4.c(f25136p);
            sr xv2 = sr.xv();
            xv2.c(xvVar);
            xv2.c(f25136p);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }

    public static com.bykv.vk.openvk.component.video.c.w.c.xv c() {
        return f25138w;
    }
}
