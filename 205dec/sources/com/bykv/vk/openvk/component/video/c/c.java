package com.bykv.vk.openvk.component.video.c;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.c.w;
import com.bykv.vk.openvk.component.video.api.f.xv;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static int f24970c = 10;
    public static int sr = 10;
    private static w ux = null;

    /* renamed from: w  reason: collision with root package name */
    public static int f24971w = 10;
    public static int xv = 10;

    public static void c(Context context) {
        com.bykv.vk.openvk.component.video.api.f.c.c(context);
        if (Build.VERSION.SDK_INT < 23) {
            com.bykv.vk.openvk.component.video.c.w.f.c.c();
        }
    }

    public static int sr() {
        return xv;
    }

    public static int ux() {
        return sr;
    }

    public static int w() {
        return f24970c;
    }

    public static int xv() {
        return f24971w;
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            f24970c = jSONObject.optInt("splash", 10);
            f24971w = jSONObject.optInt("reward", 10);
            xv = jSONObject.optInt("brand", 10);
            int optInt = jSONObject.optInt("other", 10);
            sr = optInt;
            if (f24970c < 0) {
                f24970c = 10;
            }
            if (f24971w < 0) {
                f24971w = 10;
            }
            if (xv < 0) {
                xv = 10;
            }
            if (optInt < 0) {
                sr = 10;
            }
            xv.w("MediaConfig", "splash=", Integer.valueOf(f24970c), ",reward=", Integer.valueOf(f24971w), ",brand=", Integer.valueOf(xv), ",other=", Integer.valueOf(sr));
        } catch (Throwable th) {
            xv.sr("MediaConfig", th.getMessage());
        }
    }

    public static void c(w wVar) {
        ux = wVar;
    }

    public static void c() {
        w wVar = ux;
        if (wVar != null) {
            wVar.ux();
        }
    }
}
